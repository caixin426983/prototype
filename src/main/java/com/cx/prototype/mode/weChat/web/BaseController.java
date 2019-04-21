package com.cx.prototype.mode.weChat.web;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.weChat.util.HttpGetUtil;
import com.cx.prototype.mode.weChat.util.WechatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/code/weChat/base")
public class BaseController {

    /**
     * 认证服务器
     */
    @RequestMapping(value = "authServer")
    public void authServer(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter print;
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (signature != null && WechatUtil.checkSignature(signature, timestamp, nonce)) {
            try {
                print = response.getWriter();
                print.write(echostr);
                print.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取OpenId
     */
    @RequestMapping(value = "getCode",method = RequestMethod.GET)
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //这里要将你的授权回调地址处理一下，否则微信识别不了
        String redirect_uri = URLEncoder.encode("http://yaan.cdoservice.com/Rencai/code/weChat/base/getOpenId", "UTF-8");
        //简单获取openid的话参数response_type与scope与state参数固定写死即可

        StringBuffer url = new StringBuffer("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=" + redirect_uri +
                "&appid=" + WechatUtil.getAppid() + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
        System.out.println("准备获取code...");
        System.out.println("重定向地址为:"+url);
        response.sendRedirect(url.toString());
    }

    /**
     * 获取OpenId
     */
    @RequestMapping(value = "getOpenId",method = RequestMethod.GET)
    public void getOpenId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取微信返回code
        String code = request.getParameter("code");//获取code
        System.out.println("code为"+code);
        Map params = new HashMap();
        params.put("secret", WechatUtil.getSecret());
        params.put("appid", WechatUtil.getAppid());
        params.put("grant_type", "authorization_code");
        params.put("code", code);

        //httpRequestToString
        System.out.println("准备获取openid...");
        /*String result = HttpRequestUtil.sendGet("https://api.weixin.qq.com/sns/oauth2/access_token", params.toString());*/
        String result = HttpGetUtil.httpRequestToString(
                "https://api.weixin.qq.com/sns/oauth2/access_token", params);
        JSONObject jsonObject = JSONObject.parseObject(result);

        /*JSONObject jsonObject = JSONObject.parseObject(result);*/

        String openid = jsonObject.get("openid").toString();
        System.out.println("得到的openid为:"+openid);

        response.sendRedirect("http://yaan.cdoservice.com/Rencai/static/weChat/getOpenId.html?openid="+openid);

    }
}

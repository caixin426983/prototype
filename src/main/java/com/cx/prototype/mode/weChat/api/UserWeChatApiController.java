package com.cx.prototype.mode.weChat.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "weChatUser")
public class UserWeChatApiController{

    /**
     * 微信注册或完善资料
     *
     * @param request
     * @param response
     * @return
     */
//    @RequestMapping(value = "/weChat/register", method = RequestMethod.POST)
//    public BodyResult register(HttpServletRequest request, HttpServletResponse response ) throws UnsupportedEncodingException {
//        //数据参数
//        String openId = request.getParameter("openId").toString();
//
//        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
//        UserInfo sysUser = new UserInfo();
//        sysUser.setName(name);
//        sysUser.setPhone(request.getParameter("phone"));
//        sysUser.setIdcard(request.getParameter("idcard"));
//
//        //1.新用户 2.老用户绑定openId
//        //首先查找数据库中是否有该用户
//        SysUser oldUser = this.service.findByNameOrPhone(sysUser.getPhone());
//        if (oldUser == null) {
//            //确认为新用户
//            sysUser.setUsername(sysUser.getPhone());
//            String password = EncryptUtils.md5("123456", sysUser.getUsername(), 2);
//            sysUser.setPassword(password);
//            sysUser.setUserType("0");
//            sysUser.setOpenId(openId);
//            sysUser.setSex(SpiderUtils.getSexByIdCard(sysUser.getIdcard()));
//            if (this.service.insertOrUpdateUser(sysUser) == -1) {
//                return new BodyResult().fail("已存在相同的用户");
//            }
//        } else {
//            oldUser.setOpenId(openId);
//            oldUser.setIdcard(sysUser.getIdcard());
//            oldUser.setName(sysUser.getName());
//            oldUser.setSex(SpiderUtils.getSexByIdCard(oldUser.getIdcard()));
//            if (this.service.insertOrUpdateUser(oldUser) == -1) {
//                return new BodyResult().fail("已存在相同的用户");
//            }
//        }
//        return this.getResult(request, response);
//    }

}

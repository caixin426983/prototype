package com.cx.prototype.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description JSON Web Token
 * @Author cx
 * @Date 2019/1/4 16:54
 **/
public class Jwt {

    /**
     * token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj
     */
    public static final String SECRET = "1111111111111";


    public static final int calendarField = Calendar.DATE;

    public static final int calendarInterval = 10;

    /**
     * 创建token
     *
     * @param userId
     * @return
     */
    public static String creatrToken(Long userId) {
        //当前时间
        Date now = new Date();

        Calendar nowTime = Calendar.getInstance();

        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create().withHeader(map) // header
                .withClaim("iss", "Service") // payload
                .withClaim("aud", "APP")
                .withClaim("userId", null == userId ? null : userId.toString())
                .withIssuedAt(now) // sign time(开始时间)
                .withExpiresAt(expiresDate) // expire time(结束时间)
                .sign(Algorithm.HMAC256(SECRET)); // signature

        return token;
    }


    /**
     * 解密token
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jwt.getClaims();
    }

    /**
     * 获取userId
     *
     * @param token
     * @return
     */
    public static Long getAppUID(String token) {
        Map<String, Claim> claim = verifyToken(token);
        Claim userId = claim.get("userId");
        if (null == userId || StringUtils.isEmpty(userId.asString())) {

        }
        return Long.valueOf(userId.asString());
    }


    public static void main(String[] args) {


        String s = creatrToken(12580L);
        System.out.println(s);


        Map<String, Claim> token = verifyToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJTZXJ2aWNlIiwiZXhwIjoxNTQ3NDU4MjM1LCJ1c2VySWQiOiIxMjU4MCIsImlhdCI6MTU0NjU5NDIzNX0.qyqsAgXlAf8AF3POA_ngegQsWAlKSvZSwp7YH8vvpRQ");
        System.out.println(token.toString());

        Long appUID = getAppUID("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJTZXJ2aWNlIiwiZXhwIjoxNTQ3NDU4MjM1LCJ1c2VySWQiOiIxMjU4MCIsImlhdCI6MTU0NjU5NDIzNX0.qyqsAgXlAf8AF3POA_ngegQsWAlKSvZSwp7YH8vvpRQ");
        System.out.println(appUID);

    }


}

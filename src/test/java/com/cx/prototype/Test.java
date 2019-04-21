package com.cx.prototype;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * @Description TODO
 * @Author cx
 * @Date 2019/1/4 15:57
 **/
public class Test {


    public static void main(String[] args) {
        SimpleHash md5 = new SimpleHash("MD5", "123456", "admin8d78869f470951332959580424d4bf4f", 2);
        System.out.println(md5);


        Md5Hash md5Hash = new Md5Hash("123456", "admin8d78869f470951332959580424d4bf4f", 2);
//        System.out.println(md5Hash);

        System.out.println(UUID.randomUUID().toString().replace("-", ""));


        String ss1 = new String("china");
        String s1 = "china";
        String s2 = "china";
        String s3 = "china";
        String ss2 = new String("china");
        String ss3 = new String("china");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println(s1 == ss1);
        System.out.println(ss1 == ss2);

        int a1 = 128;
        final int INT1 = 128;
        System.out.println(System.identityHashCode(a1));
        System.out.println(System.identityHashCode(INT1));


    }

}

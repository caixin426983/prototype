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

    }

}

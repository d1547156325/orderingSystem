package com.noname.demo.comment;


/**
 * 封装微信小程序appid, secret js_code  为获得用户openId
 */
public class ComonUtils {

    public static StringBuffer appendUrl(String code) {

        StringBuffer info = new StringBuffer("https://api.weixin.qq.com/sns/jscode2session?");

        info.append("appid=").append("wx8d87127163bbef11").append("&");

        info.append("secret=").append("9718b02bb9be37ba2eecfdec7ec88c00").append("&");

        info.append("js_code=").append(code).append("&");

        info.append("grant_type=").append("authorization_code");

        return info;
    }
}



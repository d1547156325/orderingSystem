package com.noname.demo.comment;


/**
 * 封装微信小程序appid, secret js_code  为获得用户openId
 */
public class ComonUtils {

    public static StringBuffer appendUrl(String code) {

        StringBuffer info = new StringBuffer("https://api.weixin.qq.com/sns/jscode2session?");

        info.append("appid=").append("wx75e5ecadcfeada7d").append("&");

        info.append("secret=").append("2ffd049f802a990c0b2d098a3d748508").append("&");

        info.append("js_code=").append(code).append("&");

        info.append("grant_type=").append("authorization_code");

        return info;
    }
}



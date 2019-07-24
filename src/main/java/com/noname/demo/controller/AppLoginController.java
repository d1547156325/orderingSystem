package com.noname.demo.controller;

import com.noname.demo.comment.ComonUtils;
import com.noname.demo.comment.RedisOperator;
import com.noname.demo.entity.AppUserModel;
import com.noname.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/AppLogin")
public class AppLoginController {

    @Autowired
    CustomerService customerService = null;
    @Autowired
    RedisOperator redis = null;


    /**
     * 获取用户openid, 并将session存入redis，发送到前端
     * @param code
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public Map<String, Object> appDoLogin(String code){
        Map<String, Object> map = new HashMap<>();
        if(code == null){
            map.put("success", false);
            return map;
        }
        //System.out.println(code);
        //System.out.println(new ComonUtils().appendUrl(code));
        String url = new ComonUtils().appendUrl(code).toString();
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url, String.class);
        if(reponse == null){
            map.put("success", false);
            return map;
        }
        System.out.println(reponse);
        String openid = "";
        String session_key = "";
        String[] strings = reponse.split(",");
        openid = strings[1].substring(10, strings[1].length()-2);
        session_key = strings[0].substring(16, strings[0].length()-1);
        AppUserModel appUserModel = new AppUserModel();
        appUserModel.setOpenid(openid);
        appUserModel.setSession_key(session_key);
        redis.set("userSession:" + appUserModel.getOpenid(), appUserModel.getSession_key(),
                60*10);
        //System.out.println(openid);
        map.put("sessionId","userSession:" + appUserModel.getOpenid());
        map.put("success", true);

        return map;
    }

    /**
     * 检测session是否过期
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Map<String, Object> doSession(String sessionId){
        String resout = redis.get(sessionId);
        Map<String, Object> map = new HashMap<>();
        if(resout == null){
            map.put("success", false);
            return map;
        }
        map.put("success", true);
        return map;
    }

    /**
     * 将sessin从redis中删除，实现退出账号
     */
    @RequestMapping(value = "/rvmSession",method = RequestMethod.GET)
    public Map<String, Object> removeSession(String sessionId){
        Map<String, Object> map = new HashMap<>();
        redis.del(sessionId);
        map.put("success", true);
        return map;
    }
}

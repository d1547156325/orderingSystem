package com.noname.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.noname.demo.comment.ComonUtils;
import com.noname.demo.entity.Customers;
import com.noname.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/AppLogin")
public class AppLoginController {

    @Autowired
    CustomerService customerService = null;

    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public Map<String, Object> appDoLogin(String code){
        Map<String, Object> map = new HashMap<>();
        System.out.println(code);
        System.out.println(new ComonUtils().appendUrl(code));
        String url = new ComonUtils().appendUrl(code).toString();
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url, String.class);
        System.out.println(reponse);
        String openid = "";
        for(int i = 0; i<reponse.length()-8; i++){
            if(reponse.substring(i,i+6).equals("openid")){

            }
        }
        map.put("openid", reponse);
        return map;
    }
}

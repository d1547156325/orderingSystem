package com.noname.demo.controller;

import com.noname.demo.entity.Remark;
import com.noname.demo.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AppRem")
public class AppRemarkController {
    @Autowired
    private RemarkService remarkService = null;

    /**
     * 通过订单id 顾客id 增加评论
     * @return
     */
    @RequestMapping("/addRem")
    public Map<String, Object> addRemById(Integer oId, Integer cId, String content){
        Map<String, Object> map = new HashMap<>();
        Remark remark = new Remark();
        remark.setCid(cId);
        remark.setOid(oId);
        remark.setContent(content);
        int sucess = remarkService.intsertRemark(remark);
        map.put("sucess", sucess);
        return  map;
    }

    /**
     * 查询所有评论
     */
    @RequestMapping("/allRem")
    public Map<String, Object> allRem(){
        Map<String, Object> map = new HashMap<>();
        List<Remark> list = remarkService.findAllRemark();
        map.put("remList", list);

        return map;
    }
}
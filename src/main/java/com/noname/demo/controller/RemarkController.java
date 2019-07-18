package com.noname.demo.controller;

import com.noname.demo.entity.Remark;
import com.noname.demo.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/remark")
public class RemarkController {
    @Autowired
    private RemarkService remarkService=null;
    /*查询所有评论*/
    @RequestMapping("/findAll")
    public List<Remark> findAll()
    {
        return remarkService.findAllRemark();
    }
}

package com.noname.demo.controller;

import com.noname.demo.entity.Merchants;
import com.noname.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
   @Autowired
    private MerchantService merchantService=null;
   @RequestMapping("/findAll")
    public List<Merchants> findAll()
   {
       return merchantService.findAllMerchant();
   }
}

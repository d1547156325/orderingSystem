package com.noname.demo.controller;

import com.noname.demo.entity.Merchants;
import com.noname.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/merchant")
public class MerchantController {
   @Autowired
    private MerchantService merchantService=null;
   /*查找所有商户*/
   @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Merchants> findAll()
   {
       return merchantService.findAllMerchant();
   }
}

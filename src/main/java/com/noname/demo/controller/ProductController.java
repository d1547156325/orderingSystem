package com.noname.demo.controller;

import com.noname.demo.entity.Product;
import com.noname.demo.entity.Product1;
import com.noname.demo.entity.ProductTemp;
import com.noname.demo.entity.Productinfo;
import com.noname.demo.service.ProductService;
import com.noname.demo.service.ProductinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService=null;
    @Autowired
    private ProductinfoService productinfoService=null;
    /*查询所有产品*/
    @RequestMapping(value = "/findAllPro",method = RequestMethod.GET)
    public List<Product> findAllPro()
    {
        return productService.findAllProduct();
    }
    /*删除产品*/
    @RequestMapping(value = "/deletePro",method = RequestMethod.POST)
    public int deletePro(@RequestBody Integer[] ids)
    {
        return productService.deletePro(ids);
    }
    /*根据分类ID查询商品*/
    @RequestMapping(value = "/findAllByCateId",method = RequestMethod.POST )
    public List<Product> findAllByCateID(@RequestBody Integer id)
    {
        return productService.findAllByCateId(id);
    }
    @RequestMapping(value = "/addProc",method = RequestMethod.POST)
    public int addProc(HttpServletRequest request, ProductTemp productTemp) throws IOException {
        Date tempdate=new Date();
        String filename =(System.currentTimeMillis())+productTemp.getFile().getOriginalFilename();
        Product product=new Product();
        product.setCateid(productTemp.getCateid());
        product.setPname(productTemp.getPname());
        product.setPprice(productTemp.getPprice());
        File newFile = new File("E:\\IMAGES" + File.separator + filename);
        product.setPpic(filename);
        productTemp.getFile().transferTo(newFile);
        int tempid=productService.insertPro(product);
        Productinfo productinfo=new Productinfo();
        productinfo.setComment(productTemp.getComment());
        productinfo.setPid(tempid);
        productinfo.setSales(0);
        return productinfoService.insertSelective(productinfo);
    }

    @RequestMapping(value = "/deleteOne",method = RequestMethod.POST)
    public int deleteOne(@RequestBody Product product)
    {
        System.out.println(product.getId());
        return productService.deleteOntPro(product.getId());
    }
    @RequestMapping(value = "/getInfoByPid",method = RequestMethod.POST)
    public Product1 getInfo(@RequestBody Product product)
    {
        return productService.findByPid(product.getId());
    }
}

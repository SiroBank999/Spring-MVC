package com.nhon.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nhon.spring.models.Product;
import com.nhon.spring.service.ProductService;



@Controller
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/products")
    public ModelAndView list(){
        List<Product> products = this.productService.findAll();
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        this.productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product was created");
        return modelAndView;
    }

    @GetMapping(value = "/view")
    public ModelAndView view(@RequestParam("id") Integer productId){
        Product product = this.productService.findById(productId);
        ModelAndView modelAndView = new ModelAndView("product/view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @GetMapping("/update")
    public ModelAndView showUpdateForm(@RequestParam("id") Integer productId){
        ModelAndView modelAndView = new ModelAndView("product/update");
        modelAndView.addObject("product", this.productService.findById(productId));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Product product){
    	this.productService.update(product);
    	return new ModelAndView("redirect:products");
    }
    @GetMapping(value = "/remove")
    public ModelAndView remove(@RequestParam("id") Integer productId){
    	this.productService.removeById(productId);
    	return new ModelAndView("redirect:products");
    }
}
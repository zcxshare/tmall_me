package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {

    @Autowired(required = false)
    CategoryService categoryService;

//    @ResponseBody
    @RequestMapping("admin_category_list")
    public String list(Model model){
        List<Category> categoryList = categoryService.list();
        model.addAttribute("cs",categoryList);
        System.out.println("##################aaaaa");
        return "admin/listCategory";
    }
}

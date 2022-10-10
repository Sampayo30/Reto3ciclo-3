package com.retoo.reto3.controller;


import com.retoo.reto3.entidades.Category;
import com.retoo.reto3.entidades.Producto;
import com.retoo.reto3.service.CategoryService;
import com.retoo.reto3.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getALL(){
        return categoryService.getALL();

    }
    @PostMapping("/save")
    public Category save(@RequestBody Category p){
        return categoryService.save(p);
    }




}

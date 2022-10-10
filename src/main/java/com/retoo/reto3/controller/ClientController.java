package com.retoo.reto3.controller;


import com.retoo.reto3.entidades.Category;
import com.retoo.reto3.entidades.Client;
import com.retoo.reto3.entidades.Producto;
import com.retoo.reto3.service.CategoryService;
import com.retoo.reto3.service.ClientService;
import com.retoo.reto3.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {


    @Autowired
    private ClientService categoryService;

    @GetMapping("/all")
    public List<Client> getALL(){
        return categoryService.getALL();

    }
    @PostMapping("/save")
    public Client save(@RequestBody Client p){
        return categoryService.save(p);
    }




}

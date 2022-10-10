package com.retoo.reto3.controller;


import com.retoo.reto3.entidades.Producto;
import com.retoo.reto3.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Producto")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public List<Producto> getALL(){
        return productoService.getALL();

    }
    @PostMapping("/save")
    public Producto save(@RequestBody Producto p){
        return productoService.save(p);
    }




}

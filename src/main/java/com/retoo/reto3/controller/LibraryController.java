package com.retoo.reto3.controller;


import com.retoo.reto3.entidades.Library;
import com.retoo.reto3.entidades.Producto;
import com.retoo.reto3.service.LibreryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Library")
public class LibraryController {


    @Autowired
    private LibreryService libraryService;

    @GetMapping("/all")
    public List<Library> getALL(){
        return libraryService.getALL();

    }
    @PostMapping("/save")
    public Library save(@RequestBody Library p){
        return libraryService.save(p);
    }




}

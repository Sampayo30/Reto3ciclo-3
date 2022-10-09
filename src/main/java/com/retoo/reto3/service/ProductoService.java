package com.retoo.reto3.service;

import com.retoo.reto3.entidades.Producto;
import com.retoo.reto3.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getALL(){
        return productoRepository.getAll();
    }
    public Optional<Producto> getProducto(int id){
        return productoRepository.getProducto(id);
    }

    public Producto save(Producto p){
        if(p.getId()==null){
            return productoRepository.save(p);
        }else {
            Optional<Producto> e = productoRepository.getProducto(p.getId());
            if(e.isPresent()){
                return p;
            }else {
                return productoRepository.save(p);
            }
        }
    }

    public Producto update(Producto p){
        if(p.getId()!=null){
            Optional<Producto> q = productoRepository.getProducto(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getYear()!=null){
                    q.get().setYear(p.getYear());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }
                productoRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Producto>p=productoRepository.getProducto(id);
        if(p.isPresent()){
            productoRepository.delete(p.get());
            flag=true;
        }

        return flag;

    }

}

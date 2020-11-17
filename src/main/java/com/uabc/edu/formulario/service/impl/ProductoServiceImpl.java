package com.uabc.edu.formulario.service.impl;

import com.uabc.edu.formulario.entity.Producto;
import com.uabc.edu.formulario.repository.ProductoRepository;
import com.uabc.edu.formulario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository repo;

    @Override
    public boolean guardarProducto(Producto prod) {
        try{
        repo.save(prod);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean editarProducto(Producto prod) {
        return false;
    }

    @Override
    public boolean borrarProducto(Integer id) {
        return false;
    }

    @Override
    public List<Producto> obtenerProductos() {

            //Convertir Iterador a Lista
            Iterable<Producto> ite=repo.findAll();
            Iterator<Producto> it=ite.iterator();
            List<Producto> actualList = new ArrayList<Producto>();
            while (it.hasNext()) {
                actualList.add(it.next());
            }

        return actualList;
    }
}

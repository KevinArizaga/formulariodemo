package com.uabc.edu.formulario.service.impl;

import com.uabc.edu.formulario.entity.Producto;
import com.uabc.edu.formulario.repository.ProductoRepository;
import com.uabc.edu.formulario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository repo;

    @Override
    public boolean guardarProducto(Producto prod) {
        try {
            repo.save(prod);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /* Creo que hace lo mismo que guardarProducto, así que lo dejo pero no lo uso... */
    @Override
    public boolean editarProducto(Producto newProducto) {
        try {
            repo.save(newProducto);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean borrarProducto(Integer id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Producto> obtenerProductos() {
            /*Iterable<Producto> ite=repo.findAll();
            Iterator<Producto> it=ite.iterator();
            List<Producto> actualList = new ArrayList<Producto>();
            while (it.hasNext()) {
                actualList.add(it.next());
            }*/
        List<Producto> allProductos = new ArrayList<>();
        repo.findAll().forEach(allProductos::add);
        return allProductos;
    }

    public Producto buscarProducto(Integer id) {
        /* Busca el Producto por medio del ID y luego lo regresa */
        return repo.findById(id).get();
    }

    public boolean existeProducto(Integer id) {
        if (repo.existsById(id))
            return true;
        return false;
    }
}

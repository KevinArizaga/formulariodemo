package com.uabc.edu.formulario.service;

import com.uabc.edu.formulario.entity.Producto;
import java.util.List;


public interface ProductoService {

    public boolean guardarProducto(Producto prod);
    public boolean editarProducto(Producto prod);
    public boolean borrarProducto(Integer id);
    public List<Producto> obtenerProductos();

}

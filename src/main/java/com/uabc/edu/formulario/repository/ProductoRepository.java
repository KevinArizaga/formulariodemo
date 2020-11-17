package com.uabc.edu.formulario.repository;

import com.uabc.edu.formulario.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository  extends CrudRepository<Producto,Integer> {


}

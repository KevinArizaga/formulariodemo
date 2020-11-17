package com.uabc.edu.formulario.controller;

import com.uabc.edu.formulario.entity.Producto;
import com.uabc.edu.formulario.service.ProductoService;
import com.uabc.edu.formulario.service.impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/productos")
public class ProductoController {

    @Autowired
    ProductoServiceImpl service;

    @GetMapping(value = "/agregar")
    public String agregarProducto(Model model){
        model.addAttribute("producto",new Producto());

        return "productos/agregar";
    }

   @PostMapping(value = "/agregar")
   public String guardarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttrs) {

        service.guardarProducto(producto);
        redirectAttrs.addFlashAttribute("mensaje","Agregado correctamente");

        return "redirect:/productos/mostrar";

   }

    @GetMapping(value = "/mostrar")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", service.obtenerProductos());
        return "productos/mostrar";
    }


   }

package com.altoque.controller;

import com.altoque.model.Producto;
import com.altoque.service.CarritoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    private final CarritoService carritoService;

    public MenuController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    private List<Producto> obtenerProductos() {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto(1L,"Hamburguesa","Hamburguesa clásica con queso",4500,"hamburguesa.jpg"));
        productos.add(new Producto(2L,"Pizza","Pizza pepperoni",6500,"pizza.jpg"));
        productos.add(new Producto(3L,"Papas","Papas fritas",2500,"papas.jpg"));
        productos.add(new Producto(4L,"Refresco","Bebida gaseosa",1200,"refresco.jpg"));

        return productos;
    }

    @GetMapping("/menu")
    public String verMenu(Model model){

        model.addAttribute("productos", obtenerProductos());
        model.addAttribute("contador", carritoService.cantidadProductos());

        return "menu";
    }

}
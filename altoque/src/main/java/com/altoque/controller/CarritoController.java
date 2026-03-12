package com.altoque.controller;

import com.altoque.model.Producto;
import com.altoque.service.CarritoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("/agregar")
    public String agregarProducto(@RequestParam Long id,
                                  @RequestParam String nombre,
                                  @RequestParam int precio,
                                  @RequestParam int cantidad) {

        Producto producto = new Producto(id, nombre, "", precio, "");

        carritoService.agregarProducto(producto, cantidad);

        return "redirect:/menu";
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model){

        model.addAttribute("items", carritoService.obtenerCarrito());
        model.addAttribute("subtotal", carritoService.obtenerSubtotal());

        return "carrito";
    }

}
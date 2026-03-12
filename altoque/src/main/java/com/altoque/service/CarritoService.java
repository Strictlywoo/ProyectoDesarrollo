package com.altoque.service;

import com.altoque.model.ItemCarrito;
import com.altoque.model.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    private List<ItemCarrito> carrito = new ArrayList<>();

    public void agregarProducto(Producto producto, int cantidad) {

        for (ItemCarrito item : carrito) {
            if (item.getProducto().getId().equals(producto.getId())) {
                return;
            }
        }

        carrito.add(new ItemCarrito(producto, cantidad));
    }

    public List<ItemCarrito> obtenerCarrito() {
        return carrito;
    }

    public int obtenerSubtotal() {

        int subtotal = 0;

        for (ItemCarrito item : carrito) {
            subtotal += item.getSubtotal();
        }

        return subtotal;
    }

    public int cantidadProductos() {

        int total = 0;

        for (ItemCarrito item : carrito) {
            total += item.getCantidad();
        }

        return total;
    }

}
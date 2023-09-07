package service;


import dto.ProductoDTO;
import interfaces.IProducto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductoServiceImpl implements IProducto {
    private List<ProductoDTO> productos;

    public ProductoServiceImpl() throws IOException, ClassNotFoundException {
        productos = new ArrayList<>();
    }

    @Override
    public ProductoDTO findById(int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ProductoDTO> findAll() throws IOException, ClassNotFoundException {
        productos = (List<ProductoDTO>) ObjectSerializer.readObjectFromFile("productos.ax");
       return productos;
    }

    @Override
    public void save(ProductoDTO producto) throws IOException {
        productos.add(producto);
        ObjectSerializer.writeObjectToFile(productos, "productos.ax");
    }

    @Override
    public void update(ProductoDTO producto) throws IOException {
        ProductoDTO oldProducto = findById(producto.getId());
        if (oldProducto != null) {
            productos.remove(oldProducto);
            productos.add(producto);
            ObjectSerializer.writeObjectToFile(productos, "productos.ax");
        }
    }

    @Override
    public void delete(ProductoDTO producto) throws IOException {
        productos.remove(producto);
        ObjectSerializer.writeObjectToFile(productos, "productos.ax");
    }
}


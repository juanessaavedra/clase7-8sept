package ejemplo1.service;


import ejemplo1.dto.ProductoDTO;
import ejemplo1.interfaces.IProducto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductoServiceImpl implements IProducto {
    private List<ProductoDTO> productos; //Crear la lista de productos, esto va tener varios productoDTO

    public ProductoServiceImpl() throws IOException, ClassNotFoundException {
        productos = new ArrayList<>(); //Esto se debe crear, el constructor no lo hace
    }

    @Override
    public ProductoDTO findById(int id) {
        return productos.stream() //Tuberia
                .filter(producto -> producto.getId() == id)// Filtra, el producto es un parametro (puedo colocar x, o lo que sea) ese producto le tomo el id y verifico si es igual al id
                .findFirst() //Encontrar el primero
                .orElse(null); //Si no lo encuentra, que retorne null
    }

    @Override
    public List<ProductoDTO> findAll() throws IOException, ClassNotFoundException {
        productos = (List<ProductoDTO>) ObjectSerializer.readObjectFromFile("productos.ax"); //Lista de objetos que deserealizo del archivo productos.ax
       return productos; //Ya tengo todos los productos ahora que voy hacer? Los voy a recorrer despues con un forEach
    }

    @Override
    public void save(ProductoDTO producto) throws IOException {
        productos.add(producto); //A la lista le agrego el producto
        ObjectSerializer.writeObjectToFile(productos, "productos.ax"); // Serializo la lista y la guardo en el archivo productos.ax
    }

    @Override
    public void update(ProductoDTO producto) throws IOException {
        ProductoDTO oldProducto = findById(producto.getId()); //Encuentra el producto de la lista
        if (oldProducto != null) { //El producto tiene que ser diferente de null porque null es que no esta un producto
            productos.remove(oldProducto); //Elimino el producto que encontre
            productos.add(producto); //Añado el nuevo producto
            ObjectSerializer.writeObjectToFile(productos, "productos.ax"); //El producto lo guardo en la lista productos y serializo la lista para que persista en productos.ax
        }
    }

    @Override
    public void delete(ProductoDTO producto) throws IOException {
        productos.remove(producto); //Remuevo el producto
        ObjectSerializer.writeObjectToFile(productos, "productos.ax"); //Serializo la lista y persiste en productos.ax
    }
}


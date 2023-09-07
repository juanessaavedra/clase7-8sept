package interfaces;

import dto.ProductoDTO;

import java.io.IOException;
import java.util.List;

public interface IProducto {
    ProductoDTO findById(int id);
    List<ProductoDTO> findAll() throws IOException, ClassNotFoundException;
    void save(ProductoDTO producto) throws IOException;
    void update(ProductoDTO producto) throws IOException;
    void delete(ProductoDTO producto) throws IOException;
}

package com.programacion.javaCrud.service;

import com.programacion.javaCrud.entity.Product;
import com.programacion.javaCrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Crear nuevo producto
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    // Leer todos los productos
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Leer producto por id
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    // Actualizar producto por nombre
    public Product updateProductByName(String name, Product updatedProduct) {
        Product existing = repository.findByName(name);
        if (existing != null) {
            existing.setName(updatedProduct.getName());
            existing.setDescription(updatedProduct.getDescription());
            existing.setIsAvailable(updatedProduct.getIsAvailable());
            existing.setPrice(updatedProduct.getPrice());
            existing.setCategoryId(updatedProduct.getCategoryId());
            return repository.save(existing);
        }
        return null;
    }

    // Borrar producto por id
    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}

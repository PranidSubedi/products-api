package uk.ac.westminster.products_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return (productService.getAllProducts());
    }
    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return (productService.getProductById(id));
    }

    @PostMapping("/products")
    public List<Product> addProduct(
            @RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct (@PathVariable long id){
        productService.deleteProduct(id);
    }
}

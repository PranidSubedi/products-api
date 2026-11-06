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
            @RequestBody DigitalProduct product){ //Product Type has been changed to DigitalProduct, because Jackson Cannot create object of abstract class. This is a temporary fix.
        return productService.addProduct(product);
        //This returned a 400 error. This was because, i didn't add fields of DigitalProduct.
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct (@PathVariable long id){
        productService.deleteProduct(id);
    }

    @GetMapping ("/products/search")
    public List<Product> findByName (@RequestParam String name){
        return (productService.findByName(name));
    }

    @GetMapping("/products/summaries")
    public List<String> getSummaries () {
        return (productService.getAllSummaries());
    }
}

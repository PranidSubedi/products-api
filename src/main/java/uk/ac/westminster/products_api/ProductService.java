package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> addProduct(Product product){
        product.setId(nextId);
        nextId++;
        products.add(product);
        return products;
    }

    public Optional<Product> getProductById(Long id){
        return(products.stream().
                filter((product) -> product.getId().equals(id)).
                findFirst()
        );
    }

    public void deleteProduct(Long id){
        products.removeIf((p) -> p.getId().equals(id));
        //If remove inside loop, that sends shortening list while looping through it error.

    }

}

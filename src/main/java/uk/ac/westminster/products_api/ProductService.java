package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService(){
        products.add(new DigitalProduct(
                nextId++,
                "ebook",
                22.22,
                "/downloads/clean-code.pdf",
                4.2));
        //ID, name and price comes from parent product class.
        //getId,getName and getPrice are inherited getters.
        products.add(new PhysicalProduct(
                nextId++,
                "Hard cover Book",
                32.22,
                1.2,
                "61cm x 41cm x 18cm"));

    }

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
        //If remove inside loop, that sends shortening list while looping through its error.

    }

    public List<Product> findByName (String name){
        return (products.stream().
                filter((p) -> p.getName().contains(name)).
                toList());
    }

    public List<String> getAllSummaries(){
        List<String> summaries = new ArrayList<>();

        for (Product p :products){
//            p.applyDiscount(0.10);
//            Cannot resolve method 'applyDiscount' in 'Product'
//            if (p instanceof Discountable d) //Checks if p is instance of interface Discountable and then casts it to the variable d
//            {
//                d.applyDiscount(0.10);
//            }
            summaries.add(p.getSummary()+" ");
        }
        return summaries;

    }

}

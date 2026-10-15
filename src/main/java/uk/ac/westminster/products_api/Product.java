package uk.ac.westminster.products_api;

public class Product {

    private Long id;
    private String name;
    private double price;

    public Product (Long id, String name , double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Product (){}

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

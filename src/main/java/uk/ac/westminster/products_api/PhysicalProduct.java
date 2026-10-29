package uk.ac.westminster.products_api;

// Physical Product IS-A product because it is a type of product, it is not an attribute for a product.
// Shopping Cart HAS-A product because product doesn't inherit Shopping Cart, they are not related.

public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {}

    public PhysicalProduct (Long id,
                            String name,
                            double price,
                            double weightKg,
                            String dimensions){
        super(id,name,price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}

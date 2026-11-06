package uk.ac.westminster.products_api;

// Physical Product IS-A product because it is a type of product, it is not an attribute for a product.
// Shopping Cart HAS-A product because product doesn't inherit Shopping Cart, they are not related.

public class PhysicalProduct extends Product
    implements Discountable{
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

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
//    When the base getSummary was made abstract, and the overriden getsummary method of this class was commented out, this was the error it showed
    //Class 'PhysicalProduct' must either be declared abstract or implement abstract method 'getSummary()' in 'Product'
    @Override
    public String getSummary() {
        return ("ID: " + getId() +
                " Name: " + getName() +
                " Price: " +getPrice() +
                " Weight: " + weightKg +
                " Dimensions: " + dimensions);
    }
    //Even though the code works without the annotation, the override annotation is a safety net for the compiler as it always checks the parent class for a function to override. Without it, human error
    //like wrong signature and typos will be detected. Without it, a different function will be created and an error will not be thrown.

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate,0.2);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    // Interface is just a contract that contains the signature of a method, the actual contents of the methods are immaterial to the contract.
}

package uk.ac.westminster.products_api;

public class DigitalProduct extends Product
        implements Discountable{
    private String downloadUrl;
    private double fileSizeMb;
    private double discountedPrice;

    public DigitalProduct( Long id,
                            String name,
                            double price,
                            String downloadUrl,
                            double fileSizeMb) {
        super(id,name,price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMb = fileSizeMb;
    }
    public DigitalProduct(){}

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSizeMb() {
        return fileSizeMb;
    }

    public void setFileSizeMb(double fileSizeMb) {
        this.fileSizeMb = fileSizeMb;
    }

    @Override
    public String getSummary() {
        return ("ID: " + getId() +
                " Name: " + getName() +
                " Price: " +getPrice() +
                " URL: " + downloadUrl +
                " Size: " + fileSizeMb);
    }

    @Override
    public void applyDiscount(double rate) {
        this.discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}

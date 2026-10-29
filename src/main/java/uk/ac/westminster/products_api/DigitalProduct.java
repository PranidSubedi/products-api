package uk.ac.westminster.products_api;

public class DigitalProduct extends Product{
    private String downloadUrl;
    private double fileSizeMb;

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
}

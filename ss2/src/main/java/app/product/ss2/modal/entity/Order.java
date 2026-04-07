package app.product.ss2.modal.entity;

import java.util.Date;

public class Order {
    private String id;
    private String productName;
    private double total;
    private Date date;

    public Order() {
    }

    public Order(String id, String productName, double total, Date date) {
        this.id = id;
        this.productName = productName;
        this.total = total;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
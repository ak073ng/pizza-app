package com.akoteng.pizzaapp.classes;


public class Cart {

    protected String name, size, order_detail, status;
    protected int quantity, price, order_id, product_id, customer_id;


    public Cart(String name, String size, int quantity, int price, String order_detail ) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.order_detail = order_detail;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOrderDetail() {
        return order_detail;
    }

    public void setOrderDetail(String order_detail) {
        this.order_detail = order_detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public int getCustonmerId() {
        return quantity;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }


}

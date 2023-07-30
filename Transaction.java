package javaproject9;

import java.util.ArrayList;

public class Transaction {
    private int payment;
    private Product product;
    private int change;
    private Combo products;

    public Transaction(int payment, Product product, int change) {
        this.payment = payment;
        this.product = product;
        this.change = change;
    }

    public Transaction(int payment, Combo products, int change) {
        this.payment = payment;
        this.products = products;
        this.change = change;
    }

    public int getPayment() {
        return payment;
    }

    public Product getProduct() {
        return product;
    }

    public int getChange() {
        return change;
    }

}

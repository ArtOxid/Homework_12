package ru.netology;

public class Repository {
    protected Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToId = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToId] = product;
                copyToId++;
            }
            products = tmp;
        }


    }

    public Product[] getProducts() {
        return products;

    }


}
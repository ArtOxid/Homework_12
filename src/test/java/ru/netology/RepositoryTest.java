package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RepositoryTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);


    Product product1 = new Book(1, "Book_1", 10, "Title_1", "Author_1");
    Product product2 = new Book(2, "Book_2", 100, "Title_2", "Author_2");
    Product product3 = new Smartphone(3, "Phone_1", 1000, "Model_1", "Developer_1");
    Product product4 = new Smartphone(4, "Phone_2", 10000, "Model_2", "Developer_2");

    public void testSave() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);


        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);


        repo.removeById(product1.getId());
        repo.removeById(product4.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNoneProductsFit() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Car");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchIfOneItemFits() {
        manager.add(product1);
        manager.add(product4);

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Phone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfMultipleProductsFound() {
        manager.add(product1);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfMultipleOptions() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = {product1, product2};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);
    }
}





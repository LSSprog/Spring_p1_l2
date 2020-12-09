package spring.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component(value = "prodRep")
public class ProductRepository {
    private List<Product> productList; // task1 - товары хранятся в бине

    public List<Product> getProductList() { // task2 - весь список товаров
        return Collections.unmodifiableList(productList);
    }

    public Product getProductById(int id) { //task2 - один товар по id
        for (Product pr: productList) {
            if (pr.getId() == id) {
                return pr;
            }
        }
        return null;
    }

    @PostConstruct
    public void before() { // task 1  - пристарте добавляются 5 любых товаров
        String[] titlesProduct = new String[] {"туфли", "платье", "рубашка", "купальник", "брюки"};
        int size = 5;
        productList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            productList.add(new Product(i+1, titlesProduct[i], (i+1)*50));
        }
    }


}

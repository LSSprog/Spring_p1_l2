package spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "prototype") // task4 - каждый раз новая корзина
public class Cart { //task2 - корзина с возможностью добавлять и удалять по id
    //@Autowired
    private ProductRepository productRepository;
    private List<Product> cartList;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id){
        cartList.add(productRepository.getProductById(id));
    }

    public void deleteProduct(int id) {
        cartList.remove(productRepository.getProductById(id));
    }

    public List<Product> showList() {
        return cartList;
    }

    @PostConstruct
    public void before() {
        cartList = new ArrayList<>();
    }
}

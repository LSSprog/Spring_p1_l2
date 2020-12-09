package spring.context;

import javafx.scene.transform.Scale;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        ProductRepository productRepository = context.getBean("prodRep", ProductRepository.class);
        //System.out.println(productRepository.getProductList());
        //System.out.println(productRepository.getProductById(3));

        Cart cart = context.getBean("cart", Cart.class);
        /*System.out.println(cart.showList());
        cart.addProduct(1);
        System.out.println(cart.showList());
        cart.addProduct(3);
        System.out.println(cart.showList());
        cart.addProduct(4);
        cart.deleteProduct(3);
        System.out.println(cart.showList());*/

        // task3 - консольное приложение по управлению карзиной
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        int id = 0;
        System.out.println("list - для просмотра всех возможных товаров");
        System.out.println("add id - для добавления в корзину товара с номером id");
        System.out.println("del id - для удаления товара с номером id из корзины");
        System.out.println("cart - для просмотра корзины");
        System.out.println("exit - для выхода из приложения");
        do {
            cmd = scanner.nextLine();
            if (cmd.equals("list")) {
                System.out.println(productRepository.getProductList());
            }
            if (cmd.equals("cart")) {
                System.out.println(cart.showList());
            }
            if (cmd.startsWith("add")){
                id = Integer.parseInt(cmd.substring(4));
                cart.addProduct(id);
            }
            if (cmd.startsWith("del")) {
                id = Integer.parseInt(cmd.substring(4));
                cart.deleteProduct(id);
            }
        } while (!cmd.equals("exit"));


        context.close();
    }
}

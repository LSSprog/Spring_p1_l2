package spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        ProductRepository productRepository = context.getBean("prodRep", ProductRepository.class);

        Cart cart = context.getBean("cart", Cart.class);

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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.OptionalInt;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);


        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Анна").setSurname("Петрова").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
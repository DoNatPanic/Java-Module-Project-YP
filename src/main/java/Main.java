import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // количество гостей
        int personCount;

        // 1. Входные параметры для счётчика
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            String input = scanner.nextLine();

            try
            {
                personCount = Integer.parseInt(input);
                if(personCount == 1) {
                    System.out.println("Счет делить не требуется. Завершаем программу");
                    return;
                } else if(personCount < 1) {
                    System.out.println("Неверный формат: введите положительное число");
                } else {
                    System.out.println("Принято: количество человек: " + personCount);
                    break;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Неверный формат: введите целое число.");
            }
        }

        // создание калькулятора
        Calculator calculator = new Calculator(personCount);

        // 2. Добавление товаров в калькулятор
        calculator.addToCart();

        System.out.println("Добавленные товары:");
        for(Product product : calculator.products){
            System.out.printf("%s %.2f%n", product.name, product.price);
        }

        // 3. Расчет и вывод результата
        System.out.println(calculator.calculate());
    }
}
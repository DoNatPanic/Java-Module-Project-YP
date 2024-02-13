import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public int personCount;
    public double totalPriceSum;
    public double dividedSum;
    public ArrayList<Product> products = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    Calculator(int personCount){
        this.personCount = personCount;
    }
    public void addToCart(){
        while (true) {
            System.out.println("\nВведите название товара:");
            String inputName = scanner.nextLine();
            if(inputName.trim().equalsIgnoreCase("завершить")) {
                break;
            }

            System.out.println("Введите его стоимость в формате 'рубли.копейки':");
            while (true) {
                String inputPrice = scanner.nextLine();
                try
                {
                    double price = Double.parseDouble(inputPrice);
                    if(price < 0) {
                        System.out.println("Стоимость не может быть отрицательной. Повторите ввод:");
                    } else {
                        System.out.printf("Принято: товар '%s' с ценой %.2f успешно добавлен в корзину!%n", inputName, price);
                        totalPriceSum += price;
                        products.add(new Product(inputName, price));
                        System.out.println("Если хотите добавить еще товары, продолжайте ввод, иначе введите 'Завершить'");
                        break;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Неверный формат: введите стоимость товара в формате 'рубли.копейки':");
                }
            }
        }
    }

    public String calculate() {
        dividedSum = totalPriceSum / personCount;

        // определяем, с каким окончанием нужно закончить фразу: "рубль/рубля/рублей"
        Formatter formatter = new Formatter();
        String phraseEnd = formatter.getPhraseEnd(dividedSum);

        return String.format("Все должны заплатить по %.2f %s", dividedSum, phraseEnd);
    }
}

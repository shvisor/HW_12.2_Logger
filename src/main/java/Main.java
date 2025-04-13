import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        logger = Logger.getInstance();
        logger.log("Тест");

        System.out.print("Введите размер списка: ");
        int size = Integer.parseInt(scan.nextLine());
        System.out.print("Введите верхнюю границу для значений: ");
        int border = Integer.parseInt(scan.nextLine());

        logger.log("Создаём и наполняем список");
        List<Integer> list = Arrays.stream(new int[size])
                .map(x -> random.nextInt(border + 1))
                .boxed()
                .toList();

        logger.log(String.format("Сгенерирован случайный список: %s", list));

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int threshold = Integer.parseInt(scan.nextLine());

        Filter filter = new Filter(threshold);
        List<Integer> filterList = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println(String.format("Отфильтрованный список: %s", filterList));
        logger.log("Завершаем программу");
    }
}

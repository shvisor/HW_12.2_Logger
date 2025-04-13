import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();

        logger.log("Запускаем фильтрацию");

        List<Integer> result = source.stream().filter((number) -> {
            logger.log(String.format("Элемент \"%d\" %s", number, number >= threshold ? "проходит" : "не проходит"));
            return number >= threshold;
                }).toList();

        logger.log(String.format("Прошло фильтр %d элемента из %d", result.size(), source.size()));

        return result;
    }
}

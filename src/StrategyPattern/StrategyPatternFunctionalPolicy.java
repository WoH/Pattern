package StrategyPattern;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Created by Wolfgang Hobmaier on 10/31/16.
 */
public class StrategyPatternFunctionalPolicy {
    interface SortStrategy extends UnaryOperator<Integer[]> {
        @Override
        Integer[] apply(Integer[] iS);
    }
    private static SortStrategy MergeSort = iS -> {
        // Implementation
        System.out.println("Using MergeSort");
        return new Integer[0];
    };
    private static SortStrategy QuickSort = iS -> {
        // Implementation
        System.out.println("Using QuickSort");
        return new Integer[0];
    };
    private static SortStrategy BubbleSort = iS -> {
        // Implementation
        System.out.println("Using BubbleSort");
        return new Integer[0];
    };

    private static void sort(Integer[] array, Predicate<Void> applicable, SortStrategy sortStrategy){
        if(applicable.test(null)) {
            sortStrategy.apply(array);
        }
    }
    public static void main(String[] args) {
        boolean timeImportant = true;
        boolean spaceImportant= true;
        Integer[] array = {1, 2, 3};
        sort(array, x -> timeImportant && spaceImportant, MergeSort);
    }
}

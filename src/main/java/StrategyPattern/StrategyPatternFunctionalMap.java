package StrategyPattern;

import java.util.HashMap;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

/**
 * Created by whobmaier on 1/23/17.
 */
public class StrategyPatternFunctionalMap {
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

    interface SortPolicy<A, B> extends BiPredicate<A, B> { }

    private static SortPolicy<Boolean, Boolean> MergeSortPolicy =
            (timeImportant, spaceImportant) -> timeImportant && !spaceImportant;
    private static SortPolicy<Boolean, Boolean> QuickSortPolicy =
            (timeImportant, spaceImportant) -> timeImportant && spaceImportant;
    private static SortPolicy<Boolean, Boolean> BubbleSortPolicy =
            (timeImportant, spaceImportant) -> timeImportant && !spaceImportant;

    private static HashMap<SortPolicy, SortStrategy> hashMap = new HashMap<>();
    static {
        hashMap.put(MergeSortPolicy, MergeSort);
        hashMap.put(QuickSortPolicy, QuickSort);
        hashMap.put(BubbleSortPolicy, BubbleSort);
    }
    private static SortStrategy Policy(boolean timeImportant, boolean spaceImportant) {
        return hashMap.keySet()
                .stream()
                .filter((SortPolicy sortPolicy) -> sortPolicy.test(timeImportant, spaceImportant))
                .map((SortPolicy sortPolicy) -> hashMap.get(sortPolicy))
                .findFirst()
                .get();
    }

    public static void main(String[] args) {
        boolean timeImportant = true;
        boolean spaceImportant= true;
        Integer[] array = {1, 2, 3};
        Policy(timeImportant, spaceImportant).apply(array);
    }
}

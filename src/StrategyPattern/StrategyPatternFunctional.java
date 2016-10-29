package StrategyPattern;
public class StrategyPatternFunctional {
    private interface SortStrategy {
        void performSort(int[] input);
    }
    private static SortStrategy BubbleSort = new SortStrategy() {
        public void performSort(int[] input) {
            System.out.println("Using BubbleSort");
            //implementation
        }
    };
    private static SortStrategy QuickSort = new SortStrategy() {
        public void performSort(int[] input) {
            System.out.println("Using QuickSort");
            //implementation
        }
    };
    private static SortStrategy MergeSort = input -> {
        System.out.println("Using MergeSort");
        //implementation
    };

    private static class Context {
        private SortStrategy sortStrategy;
        private int[] array;
        public void sort() {
            sortStrategy.performSort(this.array);
        }

        private void setSortAlgorithm(SortStrategy sortStrategy) {
            this.sortStrategy = sortStrategy;
        }

        private void setArray(int[] array) {
            this.array = array;
        }
    }

    private static class Policy {
        private boolean timeImportant;
        private boolean spaceImportant;
        private Context context;

        Policy(Context context) {
            this.context = context;
        }

        private void configure (boolean timeIsImportant, boolean spaceIsImportant){
            this.setTimeImportant(timeIsImportant);
            this.setSpaceImportant(spaceIsImportant);
            if (isTimeImportant() && !isSpaceImportant()) {
                System.out.println("Time is important, choosing merge sort!");
                this.context.setSortAlgorithm(MergeSort);
            } else if (isTimeImportant() && isSpaceImportant()) {
                System.out.println("Time and space are important, choosing quick sort!");
                this.context.setSortAlgorithm(QuickSort);
            }
        }

        private boolean isTimeImportant() {
            return timeImportant;
        }

        private void setTimeImportant(boolean timeImportant) {
            this.timeImportant = timeImportant;
        }

        private boolean isSpaceImportant() {
            return spaceImportant;
        }

        private void setSpaceImportant(boolean spaceImportant) {
            this.spaceImportant = spaceImportant;
        }
    }

    public static void main(String[] args) {
        Context sortingContext = new Context();
        Policy policy = new Policy(sortingContext);
        policy.configure(true, false);
        int[] array = {1, 2, 3};
        sortingContext.setArray(array);
        sortingContext.sort();
    }
}

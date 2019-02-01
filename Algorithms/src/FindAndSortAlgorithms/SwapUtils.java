package FindAndSortAlgorithms;

public class SwapUtils {
    public static void swap(int[] data, int from, int to) {
        int tmp = data[from];
        data[from] = data[to];
        data[to] = tmp;
    }
}

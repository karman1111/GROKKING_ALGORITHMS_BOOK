import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class selection_sort {
    // O(nlog(n))
    private static ArrayList<Integer[]> findAllPairs(int[] array, int x){

        ArrayList<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);

        for (int j : array) {
            int search = Arrays.binarySearch(array, x - j);
            if(search >= 0){
                result.add(new Integer[]{j, array[search]});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> array = findAllPairs(new int[]{3, 1, 5, 4, 2, 6, 8, 7}, 10);

        for(Integer[] a : array){
            for (Integer k : a){
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}

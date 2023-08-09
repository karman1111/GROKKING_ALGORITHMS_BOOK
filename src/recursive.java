import java.util.Arrays;

public class recursive {

    //my version
    private static int sum_1(int[] array, int index){
        if(index == array.length)
            return 0;
        return array[index] + sum_1(array, index+1);
    }

    //books version
    private static int sum_1(int[] array){
        if(array.length == 0)
            return 0;
        return array[0] + sum_1(Arrays.copyOfRange(array, 1, array.length));
    }

    private static int size(int[] array){
        if(array.length == 0)
            return 0;
        return size(Arrays.copyOfRange(array, 1, array.length)) + 1;
    }

    private static int find_max_1(int[] array, int number){
        if(array.length == 0)
            return 0;
        return Math.max(Math.max(array[0], number),
                find_max_1(Arrays.copyOfRange(array, 1, array.length), array[0]));
    }

    private static int find_max_2(int[] array, int index){
        if(index == array.length - 1)
            return 0;

        int max = find_max_2(array, index+1);
        return Math.max(array[index], max);
    }

    public static void main(String[] args) {
        int[] rec = new int[]{1, 2, 3, 8, 5, 6, 7};
        int sum_1 = sum_1(rec);
        int size = size(rec);
        int max_1 = find_max_1(rec,0);
        int max_2 = find_max_2(rec, 0);
        System.out.println(max_2);
    }

    // base:
}

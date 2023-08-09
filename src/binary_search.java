// Алгорими призначених для багатьох даних
// O(log n) -> 4 000 000 000 -> не більше 32 спроб
// O(n) -> 4 000 000 000 -> до 4 000 000 000 спроб


public class binary_search
{
    public static int binary_search(int[] array, int item){
        int low = array[0];
        int height = array[array.length - 1];

        int mid;
        while (low <= height){
            mid = (low + height)/2;
            if(array[mid] == item){
                return mid;
            }else if(array[mid] > item){
                height = (low + height)/2;
            }else if(array[mid] < item){
                low = (low + height)/2;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binary_search(array, 6));
    }
}
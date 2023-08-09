import java.util.Arrays;

class LinkedList {
    int value;
    LinkedList next;
    public LinkedList(int value, LinkedList next) {
        this.value = value;
        this.next = next;
    }
    public LinkedList(){}

    public LinkedList(LinkedList list){
        this.value = list.value;
        this.next = list.next;
    }
}

public class lists {
    private static LinkedList getLinkedList_1(int[] array){
        if(array == null){
            throw new RuntimeException("Array is null");
        }
        LinkedList head = new LinkedList(array[0], null);
        LinkedList current = head;
        for(int i = 1; i < array.length; i++){
            current.next = new LinkedList(array[i], null);
            current = current.next;
        }
        return head;
    }

    private static LinkedList getLinkedList_2(int[] array){
        if(array == null || array.length == 0){
            return null;
        }
        LinkedList head = new LinkedList(array[0], null);
        head.next = getLinkedList_2(Arrays.copyOfRange(array,1, array.length));
        return head;
    }

    private static LinkedList getLastElement(LinkedList linkedList){
        if(linkedList.next == null){
            return linkedList;
        }
        return getLastElement(linkedList.next);
    }


    // 2) Вставлення елменту
    private static void putOnFirstPosition_1(LinkedList list, int x){
        if(list == null)
            return;

        LinkedList k = new LinkedList(list.value, list.next);
        list.value = x;
        list.next = k;
    }

    private static boolean valueExist(int x, LinkedList linkedList){
        if(linkedList == null){
            return false;
        }
        if(x == linkedList.value){
            return true;
        }
        return valueExist(x, linkedList.next);
    }


    //ask about this function
    private static void deleteX(int x, LinkedList linkedList){
        if(linkedList == null)
            return;

        if(linkedList.value == x){
            linkedList.value = linkedList.next.value;
            linkedList.next = linkedList.next.next;
        }

        if(linkedList.next == null)
            return;

        if(linkedList.next.value == x){
            linkedList.next = linkedList.next.next;
        }else {
            deleteX(x, linkedList.next);
        }
    }

    private static int getSize(LinkedList list){
        if(list == null){
            return -1;
        }

        int size = 0;
        LinkedList linkedList = list;
        while(linkedList != null){
            linkedList = linkedList.next;
            size++;
        }
        return size;

    }

    public static LinkedList getValueByIndex(int index, LinkedList list){
        LinkedList result = list;
        for(int i = 0; i < index; i++){
            result = result.next;
        }
        result.next = null;
        return result;
    }

    private static void printLinkedList(LinkedList linkedList) {
        if (linkedList != null){
            System.out.print(linkedList.value + " ");
            printLinkedList(linkedList.next);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5, 6};
        int[] test_1 = new int[]{6, 5, 4, 3, 2, 1};
        LinkedList linkedList = getLinkedList_2(test);
       // putOnFirstPosition_1(linkedList, 12);

        printLinkedList(linkedList);

        deleteX(6, linkedList);
        System.out.println();
        printLinkedList(linkedList);
        System.out.println();
        System.out.println(getSize(linkedList));
        System.out.println();
        printLinkedList(getValueByIndex(2, linkedList));
        System.out.println();
    }
}


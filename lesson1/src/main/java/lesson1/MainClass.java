package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public <T> void swap(T[] arr, int indexOne, int indexTwo) {
        T temp = arr[indexOne];
        arr[indexOne]=arr[indexTwo];
        arr[indexTwo]=temp;
    }

    public <T> ArrayList<T> arrToList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(arr));
        return arrayList;
    }
}

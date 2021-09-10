package HomeWork_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Задание 1
        String[] array = new String[2];

        array[0] = "name";
        array[1] = "surname";

        System.out.println(Arrays.deepToString(array));
        swap(array, 0, 1);
        System.out.println(Arrays.deepToString(array));

        // Задание 2
        ArrayList<String> arrList = toArrayList(array);

        // Задание 3
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> box1 = new Box<>(apple1, apple2, apple3);
        Box<Orange> box2 = new Box<>(orange1, orange2);

        System.out.println(box1.compare(box2));

        Box<Orange> box3 = new Box<>();
        box2.transfer(box3);
    }

    public static void swap(Object[] array, int index1, int index2) {
        Object tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}

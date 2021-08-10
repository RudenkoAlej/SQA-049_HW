package hw_7;


import java.util.Arrays;

public class ArrayListApp {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("FirstLine");
        list.add("SecondLine");

        System.out.println(list.size());

        list.remove(0);

        System.out.println(list.size());

    }
}

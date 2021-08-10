package hw_7;

import java.util.Arrays;

public class MyArrayList<T> {
    private int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public void add (T item) {
        if (array.length == INIT_SIZE) {
            resize((int) (array.length * 1.5));
        }
        array[pointer++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= pointer) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    public int size() {
        return pointer;
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++) {
            array[i] = array[i+1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length/CUT_RATE) {
            resize(array.length/2);
        }
    }

    public void resize(int newSize) {
        array = Arrays.copyOf(array, newSize);
        INIT_SIZE = newSize;
    }

 }

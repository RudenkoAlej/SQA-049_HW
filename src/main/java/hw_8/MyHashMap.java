package hw_8;

import java.util.Objects;

public class MyHashMap {
    private float loadFactor = 0.75f;
    private int capacity = 100;
    private int size =0;
    private Entry[] buckets = new Entry[capacity];


//    public MyHashMap() {this.buckets = new Entry[size];}
//    public MyHashMap(int capacity) {
//        this.size = capacity;
//        this.buckets = new Entry[size];
//    }

    private int Hashing(int hashcode) {
        int location = hashcode % capacity;
        System.out.println("Location: " + location);
        return location;
    }

    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public boolean containsKey(Object key) {
        if (key == null) {
            if (buckets[0].getKey() == null) {
                return true;
            }
        }
        int location = Hashing(key.hashCode());
        Entry e = null;
        try {
            e = buckets[location];
        }catch (NullPointerException ex) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null && buckets[i].getValue() == value) {
                return true;
            }
        }
        return false;
    }

    public Object get (Objects key) {
        Objects ret = null;
        if (key == null) {
            Entry e = null;
            try {
                e = buckets[0];
            } catch (NullPointerException ex) {

            }
            if (e != null) {
                return e.getValue();
            }
        } else  {
            int location = Hashing(key.hashCode());
            Entry e = null;
            try {
                e = buckets[location];
            } catch (NullPointerException ex) {

            }
            if (e != null && e.getKey() == key) {
                return e.getValue();
            }
        }
        return ret;
    }

    public Object put(Object key, Object val) {
        Object ret = null;
        if (key == null) {
            ret = putForNullKey(val);
            return ret;
        } else {
            int location = Hashing(key.hashCode());
            if (location >= capacity) {
                System.out.println("Rehashing required");
                return null;
            }
            Entry e = null;
            try {
                e = buckets[location];
            }catch (NullPointerException ex) {

            }
            if (e != null && e.getKey() == key) {
                ret = e.getValue();
            }else {
                Entry eNew = new Entry();
                eNew.setKey(key);
                eNew.setValue(val);
                buckets[location] = eNew;
                size++;
            }
        }
        return ret;
    }

    private Object putForNullKey(Object val) {
        Entry e = null;
        try {
            e = buckets[0];
        } catch (NullPointerException ex) {

        }
        Object ret = null;
        if (e != null && e.getKey() == null) {
            ret = e.getValue();
            e.setValue(val);
            return ret;
        } else {
            Entry eNew = new Entry();
            eNew.setKey(null);
            eNew.setValue(val);
            buckets[0] = eNew;
            size++;
        }
        return ret;
    }

    public Object remove(Object key) {
        int location = Hashing(key.hashCode());
        Object ret = null;
        if (buckets[location].getKey() == key) {
            for (int i = location; i < buckets.length; i++) {
                buckets[i] = buckets[i+1];
            }
        }
        return ret;
    }

}

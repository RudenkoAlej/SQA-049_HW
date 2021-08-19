package hw_8;

public class Entry<K, V> {
    Object key;
    Object value;
//    Entry next;

//    public Entry(Object key, Object value, Entry next) {
//        this.key = key;
//        this.value = value;
////        this.next = next;
//    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int mul = 11;
        if (key != null) {
            int hashCode = prime * mul + key.hashCode();
            return hashCode();
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass().getName() != obj.getClass().getName()) {
            return false;
        }
        Entry e = (Entry) obj;
        if (this.key == e.key) {
            return  false;
        }
        return false;
    }
}


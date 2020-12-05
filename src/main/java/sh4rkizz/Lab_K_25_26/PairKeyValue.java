package sh4rkizz.Lab_K_25_26;

public class PairKeyValue<K, V> {
    private K key;
    private V value;

    public PairKeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair {"
                + key + ", "
                + value +
                '}';
    }
}
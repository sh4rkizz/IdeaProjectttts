package sh4rkizz.Lab_K_25_26;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap<K, V> implements HashMapInterface<K, V> {
    private final ArrayList<LinkedList<PairKeyValue<K, V>>> mainList = new ArrayList<>();
    private final ArrayList<PairKeyValue<K, V>> notNullPairList = new ArrayList<>();
    private int capacity = 10;

    public MyHashMap() {
        for (short i = 0; i < 10; i++)
            mainList.add(new LinkedList<>());
    }

    public MyHashMap(int initialCapacity) {
        this.capacity = initialCapacity;

        for (int i = 0; i < initialCapacity; i++)
            mainList.add(new LinkedList<>());
    }

    @Override
    public void add(K key, V value) {
        if (getPair(key) != null)
            remove(key);

        PairKeyValue<K, V> pair = new PairKeyValue<>(key, value);

        notNullPairList.add(pair);
        mainList.get(key.hashCode() % capacity).add(pair);
    }

    @Override
    public V get(K key) {
        for (PairKeyValue<K, V> pair : mainList.get(key.hashCode() % capacity))
            if (pair.getKey() == key)
                return pair.getValue();

        return null;
    }

    public PairKeyValue<K, V> getPair(K key) {
        for (PairKeyValue<K, V> pair : mainList.get(key.hashCode() % capacity))
            if (pair.getKey() == key)
                return pair;

        return null;
    }

    @Override
    public V remove(K key) {
        PairKeyValue<K, V> pair = getPair(key);
        System.out.println(pair);
        mainList.get(key.hashCode() % capacity).remove(pair);
        notNullPairList.remove(pair);

        return pair.getValue();
    }

    public void setCapacity(int newSize) {
        if (capacity < newSize) {
            capacity = newSize;

            for (int i = mainList.size(); i < capacity; i++)
                mainList.add(new LinkedList<>());
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new CustomIterator();
    }

    @Override
    public String toString() {
        return "MyHashMap {" +
                "mainList: " + notNullPairList +
                '}';
    }

    private class CustomIterator implements Iterator<V> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < notNullPairList.size();
        }

        @Override
        public V next() {
            return notNullPairList.get(currentIndex++).getValue();
        }
    }
}
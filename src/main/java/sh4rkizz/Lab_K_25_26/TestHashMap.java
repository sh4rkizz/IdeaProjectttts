package sh4rkizz.Lab_K_25_26;

public class TestHashMap {
    public static void main(String[] args) {
        MyHashMap<String, String> str = new MyHashMap<>(10);

        for (int i = 0; i < 7; i++)
            str.add("key_" + i, "val_" + i);

        System.out.println(str);
    }
}
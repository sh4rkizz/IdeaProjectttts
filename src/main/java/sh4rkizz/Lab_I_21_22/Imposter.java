package sh4rkizz.Lab_I_21_22;

import java.util.List;

public class Imposter implements ItemStore {
    private static List<Item> items;

    public static void main(String[] args) {

    }

    public List<Item> getAll() {
        return items;
    }

    public Item get(int id) {
        Item item = new Item(0, "", true, "");
        return item;
    }

    public Item addItem(Item item) {
        Item item1 = new Item(0, "", true, "");
        return item1;
    }

    public Item editItem(int id, Item item) {
        Item editedItem = item;

        return editedItem;
    }

    public void deleteItem(int id) {

    }
}

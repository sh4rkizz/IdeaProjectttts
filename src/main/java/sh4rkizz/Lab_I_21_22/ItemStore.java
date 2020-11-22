package sh4rkizz.Lab_I_21_22;

import java.util.List;

public interface ItemStore {
    List<Item> getAll();
    Item addItem(Item item);
    Item get(int id);
    Item editItem(int id, Item item);
    void deleteItem(int id);
}
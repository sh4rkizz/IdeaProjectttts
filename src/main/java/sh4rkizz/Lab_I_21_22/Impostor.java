package sh4rkizz.Lab_I_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Impostor implements ItemStore {
    private final static String path = "src/main/java/sh4rkizz/Lab_I_21_22/data.json";
    private final static File jsonFile = new File(path);
    private final static Gson gson = new Gson();

    @Override
    public List<Item> getAll() {
        try {
            if (gson.fromJson(new FileReader(jsonFile), new TypeToken<List<Item>>() {
            }.getType()).toString().equals("[]"))
                throw new NullPointerException();

            return gson.fromJson(new FileReader(jsonFile), new TypeToken<List<Item>>() {
            }.getType());
        } catch (IOException | NullPointerException nPtr) {
            return null;
        }
    }

    @Override
    public Item get(int id) {
        try {
            List<Item> itemList = getAll();
            for (Item item : itemList)
                if (item.getId() == id)
                    return item;

            throw new NullPointerException();
        } catch (NullPointerException nullPtrEx) {
            return null;
        }
    }

    @Override
    public Item addItem(Item item) {
        List<Item> itemList = getAll();

        if (itemList == null)
            itemList = new ArrayList<>();

        for (Item thing : itemList)
            if (item.getId() == thing.getId())
                throw new NullPointerException();

        try {
            if (item.getId() == 0)
                item.setId(itemList.get(itemList.size() - 1).getId() + 1);
        } catch (NullPointerException nullPtr) {
            item.setId(1);
        }

        itemList.add(item);
        rewriteItemWarehouse(itemList);

        return item;
    }

    @Override
    public Item editItem(int id, Item item) {
        List<Item> itemList = getAll();
        try {
            if (itemList != null)
                if (itemList.removeIf(thing -> thing.getId() == id)) {
                    itemList.add(item);
                    rewriteItemWarehouse(itemList);
                } else throw new NullPointerException();
        } catch (NullPointerException nPtr) {
            return null;
        }

        return item;
    }

    @Override
    public void deleteItem(int id) {
        List<Item> itemList = getAll();

        itemList.removeIf(thing -> thing.getId() == id);
        rewriteItemWarehouse(itemList);
    }

    private static void sortById(List<Item> itemList, int leftBound, int rightBound) {
        if (itemList.size() == 0 || !(leftBound < rightBound))
            return;

        int mid = leftBound + (rightBound - leftBound) / 2;
        int left = leftBound, right = rightBound;

        while (left <= right) {
            while (itemList.get(left).getId() < itemList.get(mid).getId())
                left++;

            while (itemList.get(right).getId() > itemList.get(mid).getId())
                right--;

            if (left <= right) {
                Collections.swap(itemList, left, right);
                left++;
                right--;
            }
        }

        if (leftBound < right)
            sortById(itemList, leftBound, right);
        if (rightBound > left)
            sortById(itemList, left, rightBound);
    }

    private static void rewriteItemWarehouse(List<Item> itemList) {
        try (FileWriter jsonFileWriter = new FileWriter(path)) {
            sortById(itemList, 0, itemList.size() - 1);
            jsonFileWriter.write("[\n");

            for (Item item : itemList)
                if (item != itemList.get(itemList.size() - 1))
                    jsonFileWriter.write(gson.toJson(item) + ",\n");
                else jsonFileWriter.write(gson.toJson(item));

            jsonFileWriter.write("\n]");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
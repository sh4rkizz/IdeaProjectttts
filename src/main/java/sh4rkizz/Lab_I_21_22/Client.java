package sh4rkizz.Lab_I_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Client implements ItemStore {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final String path ="http://80.87.199.76:3000/objects/";

    private HttpRequest request;

    @Override
    public List<Item> getAll() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(path))
                    .build();

            return new Gson().fromJson(
                    httpClient.send(request,
                            HttpResponse.BodyHandlers.ofString()).body(),
                    new TypeToken<List<Item>>() {
                    }.getType()
            );
        } catch (IOException | InterruptedException | NullPointerException exception) {
            return null;
        }
    }

    @Override
    public Item get(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(path + "?id=" + id))
                    .build();
            return new Gson().fromJson(httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body(), Item.class);
        } catch (IOException | InterruptedException | NullPointerException exception) {
            return null;
        }
    }

    @Override
    public Item addItem(Item item) {
        List<Item> itemList = getAll();
        if (itemList == null)
            itemList = new ArrayList<>();
        try {
            for (Item thing : itemList)
                if (item.getId() == thing.getId())
                    throw new NullPointerException();
            try {
                if (item.getId() == 0)
                    item.setId(itemList.get(itemList.size() - 1).getId() + 1);
            } catch (NullPointerException nullPtr) {
                item.setId(1);
            }

            request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(item)))
                    .uri(URI.create(path))
                    .setHeader("Content-Type", "application/json")
                    .build();
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException exception) {
            return null;
        }
        return item;
    }

    @Override
    public Item editItem(int id, Item item) {
        try {
            httpClient.send(HttpRequest.newBuilder()
                    .PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson(item)))
                    .uri(URI.create("path" + id))
                    .setHeader("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
            return null;
        }

        return item;
    }

    @Override
    public void deleteItem(int id) {
        HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(path + id))
                .build();
    }
}

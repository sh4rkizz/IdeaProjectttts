package sh4rkizz.Lab_L_27_28;

import java.net.URI;
import java.util.List;
import java.io.IOException;

import com.google.gson.Gson;

import java.lang.reflect.Method;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class WorkWithAddress {
    private static final String serverPath = "http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final TaskHolder task = new TaskHolder();

    public static void main(String[] args) {
        try {
            for (NewObject object : connect())
                for (Method method : task.getClass().getDeclaredMethods())
                    if (object.getType().equals(method.getName()))
                        System.out.println(method.invoke(task, object));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static List<NewObject> connect() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(serverPath))
                .build();

        return gson.fromJson(httpClient.send(request,
                HttpResponse.BodyHandlers.ofString()).body(),
                new TypeToken<List<NewObject>>() {
                }.getType());
    }
}
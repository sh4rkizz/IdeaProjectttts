package sh4rkizz.Lab_L_27_28;

import java.net.URI;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;

import com.google.gson.Gson;

import java.lang.reflect.Method;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class WorkWithAddress {
    public static void main(String[] args) {
        try {
            final TaskHolder task = new TaskHolder();

            List<Method> methods = Arrays.stream(task.getClass().getDeclaredMethods())
                    .filter(a -> Arrays.stream(a.getAnnotations())
                            .anyMatch(m -> m instanceof ConsoleAnnotation))
                    .collect(Collectors.toList());

            for (NewObject object : connect())
                for (Method method : methods)
                    if (object.getType().equals(method.getAnnotation(ConsoleAnnotation.class).operationType()))
                        System.out.println(method.invoke(task, object));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static List<NewObject> connect() throws IOException, InterruptedException {
        final HttpClient httpClient = HttpClient.newHttpClient();
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final String serverPath = "http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks";

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
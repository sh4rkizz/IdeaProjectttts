package sh4rkizz.Lab_J_23_24;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.net.URI;

public class Worker {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String serverPath = "http://gitlessons2020.rtuitlab.ru:3000/";

    public static void main(String[] args) {
        worker("src/main/java/sh4rkizz/Lab_J_23_24/db.json");
    }

    public static void worker(String filePath) {
        File jsonFile = new File(filePath);
        createJsonFile(jsonFile);

        while (true)
            try {
                Thread.sleep((int) (Math.abs(Math.random() * 1000 + 800)));

                if (isNewExpressionExist(jsonFile))
                    answerToServer(Objects.requireNonNull(solveNewExpressions(jsonFile)));

            } catch (Exception nPtr) {
                nPtr.printStackTrace();
                break;
            }
    }

    private static boolean isNewExpressionExist(File jsonFile) throws IOException, InterruptedException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(serverPath + "tasks"))
                    .build();

            List<Vitals> vitals = gson.fromJson(httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString()).body(),
                    new TypeToken<List<Vitals>>() {
                    }.getType());

            List<Vitals> exclude = gson.fromJson(new FileReader(jsonFile),
                    new TypeToken<List<Vitals>>() {
                    }.getType());

            sortById(vitals);

            return exclude.size() != vitals.size() &&
                    exclude.get(exclude.size() - 1).getId() != vitals.get(vitals.size() - 1).getId();
        } catch (NullPointerException nPtr) {
            return true;
        }
    }

    public static List<Vitals> getNewExpressions(File jsonFile) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(serverPath + "tasks"))
                    .build();

            List<Vitals> vitals = gson.fromJson(httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString()).body(),
                    new TypeToken<List<Vitals>>() {
                    }.getType());

            try {
                List<Vitals> exclude = gson.fromJson(new FileReader(jsonFile),
                        new TypeToken<List<Vitals>>() {
                        }.getType());

                vitals.removeAll(exclude);
            } catch (FileNotFoundException | NullPointerException fNf) {
                return vitals;
            }

            return vitals;
        } catch (IOException | InterruptedException | NullPointerException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static List<Report> solveNewExpressions(File jsonFile) {
        try {
            List<Vitals> expressions = getNewExpressions(jsonFile);
            List<Report> report = new ArrayList<>();

            if (expressions == null)
                throw new NullPointerException();

            for (Vitals expr : expressions)
                report.add(new Report(0, expr.getId(), calculator(expr.getExpression())));

            rewriteJson(expressions, jsonFile);

            return report;
        } catch (NullPointerException nPtr) {
            nPtr.printStackTrace();
            return null;
        }
    }

    public static double calculator(String expression) {
        Matcher matcher = Pattern.compile("(-?\\d+)\\s*([/\\-*+])?\\s*(-?\\d+)").matcher(expression);
        double firstOperand, secondOperand;
        double result = 0;

        if (matcher.find()) {
            firstOperand = Double.parseDouble(matcher.group(1));
            secondOperand = Double.parseDouble(matcher.group(3));

            switch (matcher.group(2)) {
                case "+" -> result = firstOperand + secondOperand;
                case "-" -> result = firstOperand - secondOperand;
                case "*" -> result = firstOperand * secondOperand;
                case "/" -> result = firstOperand / secondOperand;
            }
        }

        return Double.parseDouble(new DecimalFormat("#.##").format(result).replace(",", "."));
    }

    public static void answerToServer(List<Report> reports) {
        try {
            for (Report report : reports)
                httpClient.send(HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(report)))
                        .uri(URI.create(serverPath + "reports"))
                        .setHeader("Content-Type", "application/json")
                        .build(), HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void createJsonFile(File jsonFile) {
        try (FileWriter jsonFileWriter = new FileWriter(jsonFile)) {
            jsonFileWriter.write("");
        } catch (IOException | NullPointerException nPtr) {
            nPtr.printStackTrace();
        }
    }

    private static void rewriteJson(List<Vitals> vitals, File jsonFile) {
        try (FileWriter jsonFileWriter = new FileWriter(jsonFile)) {
            List<Vitals> medBay = gson.fromJson(new FileReader(jsonFile), new TypeToken<List<Vitals>>() {
            }.getType());

            if (medBay != null)
                vitals.addAll(medBay);

            sortById(vitals);
            jsonFileWriter.write("[\n");

            for (Vitals vital : vitals)
                if (vital != vitals.get(vitals.size() - 1))
                    jsonFileWriter.write(gson.toJson(vital) + ",\n");

                else jsonFileWriter.write(gson.toJson(vital));

            jsonFileWriter.write("\n]");
        } catch (IOException | NullPointerException nPtr) {
            nPtr.printStackTrace();
        }
    }

    private static void sortById(List<Vitals> vitals) {
        vitals.sort((first, second) -> (int) Math.signum(first.getId() - second.getId()));
    }
}
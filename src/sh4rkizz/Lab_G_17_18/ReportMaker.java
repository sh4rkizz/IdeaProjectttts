package sh4rkizz.Lab_G_17_18;

import java.io.*;

public class ReportMaker {
    private static final String basePath = "src/sh4rkizz";
    private static final String mdFilePath = basePath + "/Lab_G_17_18/result.md";

    public static void main(String[] args) {
        File file = new File(basePath);

        try (PrintWriter writer = new PrintWriter(mdFilePath)) {
            writer.write("# " + "Java sh4rkizz`s programming report");
        } catch (Exception e) {
            System.out.println("File has not been opened");
        }

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();

            if (fileList != null)
                for (File f : fileList)
                    reportCreator(f.getPath());
        }
    }

    public static void reportCreator(String path) {
        File file = new File(path);
        String line;
        String[] files = null;

        if (file.isDirectory())
            files = file.list();

        if (files != null)
            for (String str : files)
                if (str.endsWith(".java")) {
                    try (FileWriter writer = new FileWriter(mdFilePath, true)) {
                        writer.write("\n" + "## " + path.substring(path.lastIndexOf("\\") + 1) + "\n");
                        writer.write("**    " + str + "**\n");
                        writer.write("```java" + "\n");

                        try (BufferedReader reader = new BufferedReader(new FileReader(path + "/" + str))) {
                            line = reader.readLine();
                            while (line != null) {
                                writer.write(line + "\n");
                                line = reader.readLine();
                            }
                        } catch (Exception exception) {
                            System.out.println("Error1");
                        }

                        writer.write("```");
                    } catch (IOException ioException) {
                        System.out.println("Error2");
                    }
                }
    }
}

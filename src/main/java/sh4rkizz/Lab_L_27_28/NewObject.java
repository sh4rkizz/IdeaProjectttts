package sh4rkizz.Lab_L_27_28;

import java.util.List;

public class NewObject {
    private String type;
    private Data data;
    private int id;

    public String getType() {
        return type;
    }

    public Data getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public static class Data {
        private List<Integer> numbers;
        private List<String> words;
        private String delimeter;

        public String getDelimeter() {
            return delimeter;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public List<String> getWords() {
            return words;
        }
    }
}
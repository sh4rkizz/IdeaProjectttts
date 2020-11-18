package sh4rkizz.Lab_C_12;

public class Colors {
    public static void outColoredText(String message, ColoredText COLOR) {
        System.out.println(COLOR.getColor() + message + ColoredText.RESET_COLOR.getColor());
    }

    public static void test() {
        String message = "Сейчас 12 ночи, я прогаю на жаве";
        outColoredText(ColoredText.YELLOW_TEXT.getName() + " " + message, ColoredText.YELLOW_TEXT);

        message = "Придумывать сообщения для этих тестов очень сложно";
        outColoredText(ColoredText.RED_TEXT.getName() + " " + message, ColoredText.RED_TEXT);

        message = "Поэтому анекдот!";
        outColoredText(ColoredText.CYAN_TEXT.getName() + " " + message, ColoredText.CYAN_TEXT);

        message = "Колобок повесился";
        outColoredText(ColoredText.PURPLE_TEXT.getName() + " " + message, ColoredText.PURPLE_TEXT);

        message = "Смешно.";
        outColoredText(ColoredText.BLUE_TEXT.getName() + " " + message, ColoredText.BLUE_TEXT);
    }

    public static void main(String[] args) {
        test();
    }
}

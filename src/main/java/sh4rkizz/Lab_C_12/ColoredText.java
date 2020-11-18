package sh4rkizz.Lab_C_12;

public enum ColoredText {
    RED_TEXT("\u001B[31m", "Red"),
    GREEN_TEXT("\u001B[32m", "Green"),
    YELLOW_TEXT("\u001B[33m", "Yellow"),
    BLUE_TEXT("\u001B[34m", "Blue"),
    PURPLE_TEXT("\u001B[35m", "Purple"),
    CYAN_TEXT("\u001B[36m", "Cyan"),
    WHITE_TEXT("\u001B[30m", "White"),
    RESET_COLOR("\u001B[0m", "");

    private final String color;
    private final String name;

    ColoredText(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}

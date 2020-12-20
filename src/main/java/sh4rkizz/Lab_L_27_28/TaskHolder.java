package sh4rkizz.Lab_L_27_28;

import java.util.StringJoiner;

public class TaskHolder {
    @ConsoleAnnotation(operationType = "sum")
    public String addAndPrint(NewObject object) {
        int sum = 0;

        for (Integer number : object.getData().getNumbers())
            sum += number;

        return "id: " + object.getId() + ", " + sum;
    }

    @ConsoleAnnotation(operationType = "print")
    public String combineAndPrint(NewObject object) {
        StringJoiner sj = new StringJoiner(object.getData().getDelimeter());

        for (String str : object.getData().getWords())
            sj.add(str);

        return "id: " + object.getId() + ", " + sj;
    }
}
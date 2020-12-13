package sh4rkizz.Lab_L_27_28;

import java.util.StringJoiner;

public class TaskHolder {
    public String sum(NewObject object) {
        int sum = 0;

        for (Integer number : object.getData().getNumbers())
            sum += number;

        return "id: " + object.getId() + ", " + sum;
    }

    public String print(NewObject object) {
        StringJoiner sj = new StringJoiner(object.getData().getDelimeter());

        for (String str : object.getData().getWords())
            sj.add(str);

        return "id: " + object.getId() + ", " + sj;
    }
}
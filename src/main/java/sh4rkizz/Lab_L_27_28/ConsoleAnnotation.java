package sh4rkizz.Lab_L_27_28;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ConsoleAnnotation {
    String operationType();
}

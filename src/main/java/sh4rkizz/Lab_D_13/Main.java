package sh4rkizz.Lab_D_13;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        test();
        myRuntimeException();
    }

    public static void test() throws InterruptedException {
        try {
            myExcept(Math.random() < 0.5);
            except();
        } catch (MyException myEx) {
            System.out.println("Сработал 'MyException'");
        } catch (Exception ex) {
            System.out.println("Сработал 'Exception'");
        } finally {
            System.out.print("Совершаются очень важные действия");
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            System.out.println("\nВажные действия совершены");
        }
    }

    public static void except() throws Exception {
        throw new Exception();
    }

    public static void myExcept(boolean b) throws MyException {
        if (b)
            throw new MyException();
    }

    public static void myRuntimeException() {
        throw new MyRuntimeException();
    }
}

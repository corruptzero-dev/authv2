package task;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Coder {
    private final Scanner scanner = new Scanner(System.in);
    public boolean sendCode(){
        String notACode = Integer.toString(ThreadLocalRandom.current().nextInt(100000, 999999 + 1));
        Fw.writeToFile("code.txt", notACode);
        System.out.print("Введите код доступа: ");
        String userCode = scanner.next();
        Fw.clear("code.txt");
        if(userCode.equals(notACode) && userCode.length()==6){
            return true;
        } else {
            System.out.println("Неверный код. Повторите попытку.");
            return false;
        }

    }

}
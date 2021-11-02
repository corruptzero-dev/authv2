package task;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

class AuthImpl extends Auth {
    private final Server serv = ServerImpl.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final HashMap<String, String> data = serv.getData();

    AuthImpl() throws FileNotFoundException {
        init();
    }
    void init() throws FileNotFoundException {
        System.out.print("Введите логин: ");
        String login = scanner.next();
        System.out.print("Введите пароль: ");
        String passwd = scanner.next();
        if(login.matches("\\+\\d{11}") || login.matches("^\\w+@\\w+.\\w+")){
            if (data.get(login) == null && (Fw.getPasswd("users.txt", login)==null)) {
                register(login, passwd);
            } else {
                login(login, passwd);
            }
        } else {
            System.out.println("Неверный формат логина. Повторите попытку.");
            init();
        }
    }

    @Override
    void register(String login, String password) throws FileNotFoundException {
        Coder coder = new Coder();
        if(!coder.sendCode()){
            init();
        } else {
            serv.register(login,password);
            new AuthImpl();
        }
    }

    @Override
    void login(String login, String password) throws FileNotFoundException {
        serv.login(login,password);
    }
}

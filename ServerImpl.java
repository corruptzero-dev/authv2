package task;

import java.io.FileNotFoundException;
import java.util.HashMap;

class ServerImpl extends Server {
    private static Server _instance = null;
    private final HashMap<String, String> data = new HashMap<>();

    public static Server getInstance() {
        if (_instance == null)
            _instance = new ServerImpl();
        return _instance;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    @Override
    String register(String login, String password) throws FileNotFoundException {
        password = Integer.toString(password.hashCode());
        Fw.writeToFile("users.txt", (login+":"+password+"\n"));
        data.put(login,password);
        System.out.println("Успешная регистрация! Войдите в аккаунт.\n");
        new AuthImpl();
        return null;
    }
    @Override
    String login(String login, String password){
        password = Integer.toString(password.hashCode());
        String enc = Fw.getPasswd("users.txt", login);
        if ((enc!=null)) {
            if ((enc.equals(password))) {
                System.out.println("Успех.");
            } else {
                System.out.println("Неверный пароль.");
            }
        } else {
            if(data.get(login).equals(password)){
                System.out.println("Успех.");
            } else {
                System.out.println("Неверный пароль.");
            }
        }
        return null;
    }

    @Override
    void dropDataBase() {
        data.clear();
        Fw.clear("users.txt");
    }
}

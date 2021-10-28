package task;

import java.io.FileNotFoundException;
import java.util.HashMap;

abstract class Server {
    abstract String register(String login, String password) throws FileNotFoundException;

    abstract String login(String login, String password) throws FileNotFoundException;

    abstract void dropDataBase();

    abstract public HashMap<String, String> getData();
}

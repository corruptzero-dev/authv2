package task;

import java.io.FileNotFoundException;

abstract class Auth { //симуляция клиента
    abstract void register(String login, String password) throws FileNotFoundException;

    abstract void login(String login, String password) throws FileNotFoundException;
}

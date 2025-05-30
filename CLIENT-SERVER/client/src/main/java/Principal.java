import Connection.ProxyServer;
import Controller.LoginController;
import View.LoginUI;

public class Principal {
    public static void main(String[] args){
        LoginController loginController = new LoginController();
        ProxyServer proxyServer=ProxyServer.getInstance();
    }
}

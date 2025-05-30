package com.server.BusinessLogic;

import com.server.Service.ILogin;

public class LoginImplementationB implements ILogin {
    @Override
    public void login() {
        System.out.println("Implementator B: operație implementată.");
    }
}

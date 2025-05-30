package com.server.Service;

public class AbstractizareLoginA extends Abstractizare{

    public AbstractizareLoginA(ILogin implementor) {
        super(implementor);
    }

    @Override
    public void operatie() {
        System.out.println("Abstractizare A:");
        // Delegăm operația implementatorului specific
        implementor.login();
    }
}

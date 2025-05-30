package com.server.Service;

public class AbstractizareLoginB extends Abstractizare{
    public AbstractizareLoginB(ILogin implementor) {
        super(implementor);
    }
    @Override
    public void operatie() {
        System.out.println("Abstractizare B:");
        implementor.login();
    }
}

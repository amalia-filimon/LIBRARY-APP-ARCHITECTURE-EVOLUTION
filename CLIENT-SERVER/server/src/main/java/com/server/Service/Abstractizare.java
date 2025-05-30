package com.server.Service;

//Clasa de baza (Abstractizare)
public abstract class Abstractizare {
    protected ILogin implementor;

    public Abstractizare(ILogin implementor) {
        this.implementor = implementor;
    }

    public abstract void operatie();
}

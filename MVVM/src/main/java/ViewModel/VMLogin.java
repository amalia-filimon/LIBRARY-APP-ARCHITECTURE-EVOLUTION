package ViewModel;

import ViewModel.Commands.ComandaLogin;
import ViewModel.Commands.IComanda;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

public class VMLogin {
    private Property<String> usernameTF;
    private Property<String> passwordTF;
    public IComanda loginComanda;

    public VMLogin(){
        usernameTF = PropertyFactory.createProperty("username", this, String.class);
        passwordTF = PropertyFactory.createProperty("password", this, String.class);
        this.loginComanda = new ComandaLogin(this);
    }

    public String getUsernameTF() {
        return usernameTF.get();
    }

    public String getPasswordTF() {
        return passwordTF.get();
    }

}

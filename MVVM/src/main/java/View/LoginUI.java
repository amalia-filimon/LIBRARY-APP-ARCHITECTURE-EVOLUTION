package View;

import Model.Librarie;
import ViewModel.VMLogin;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame{
    @Bind(value = "text", target = "usernameTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField usernameTF;
    @Bind(value = "text", target = "passwordTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField passwordTF;

    private JButton loginBtn;
    private JPanel loginPanel;

    private VMLogin vm;

    public LoginUI(){
        setTitle("Login Page");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(600, 500));
        setVisible(true);

        this.vm = new VMLogin();

        try{
            Binder.bind(this, vm);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vm.loginComanda.executa();
            }
        });
    }

}

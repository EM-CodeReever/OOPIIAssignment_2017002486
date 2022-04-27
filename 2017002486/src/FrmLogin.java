//Elliot Morrison
//2017002486
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.EventListener;
import java.util.Objects;

public class FrmLogin extends JFrame{
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JButton loginButton;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JLabel loginFormLabel;
    private JPanel LoginPanel;
    private final String Username = "admin";
    private final String Password = "elliot123";
    int Attempts;

    public FrmLogin(){
        Attempts = 0;
        setContentPane(LoginPanel);
        setTitle("Login Form");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Attempts != 3){
                    String PasswordInput = String.valueOf(passwordPasswordField.getPassword());
                    if(usernameTextField.getText().contentEquals("") || PasswordInput.contentEquals("")){
                        JOptionPane.showMessageDialog(LoginPanel,"Enter Both a Username and Password");
                    }else if(usernameTextField.getText().contentEquals("admin") || PasswordInput.contentEquals("elliot123")){
                        FrmMainMenu mainMenu = new FrmMainMenu();
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(LoginPanel,"Incorrect Username or Password");
                        Attempts++;
                    }
                }else{
                    JOptionPane.showMessageDialog(LoginPanel,"You have exceeded maximum incorrect login attempts");
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        FrmLogin login = new FrmLogin();
    }
}

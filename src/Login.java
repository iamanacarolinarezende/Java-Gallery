import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JLabel UserNameLabel;
    private JLabel PasswordLabel;
    private JTextField textFieldUsername;
    private JPasswordField passwordField1;
    private JButton LoginButton;
    private JButton ExitButton;
    private JLabel TitleLabel;
    public JPanel loginPanel;

    public Login() {
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldUsername.getText().equals("admin") && passwordField1.getText().equals("admin")){
                    JOptionPane.showMessageDialog(LoginButton, "Welcome Admin!");
                    MainForm_CGS cgs = new MainForm_CGS();
                    cgs.setContentPane(cgs.CgsPanel);
                    cgs.setTitle("CGS MAIN");
                    cgs.setSize(400, 300);
                    cgs.setLocationRelativeTo(null);
                    cgs.setVisible(true);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginButton, "Error! Credentials are incorrect!");
                }
            }
        });


        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });


    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setContentPane(login.loginPanel);
        login.setTitle("CGS LOGIN");
        login.setSize(350, 200);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

    }



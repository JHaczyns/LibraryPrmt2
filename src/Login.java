import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public static String loginStatus;
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JLabel loginLabel = new JLabel("User");
    JLabel passwordLabel = new JLabel("Password");
    JTextField loginText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JButton button = new JButton("Login");
    JButton help = new JButton("HELP");
    JButton QUIT = new JButton("QUIT");

    //TYLKO DO TESTÓW, ŻEBY SZYBCIEJ SPRAWDZAĆ CZY DZIAŁA
    JButton admin = new JButton("admin");
    JButton user = new JButton("user");


    public Login() {
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu");

        panel.setLayout(null);
        loginLabel.setBounds(10, 20, 80, 25);
        panel.add(loginLabel);
        passwordLabel.setBounds(10, 55, 80, 25);
        panel.add(passwordLabel);

        loginText.setBounds(100, 20, 165, 25);
        panel.add(loginText);
        passwordText.setBounds(100, 55, 165, 25);
        panel.add(passwordText);

        button.setBounds(10, 100, 80, 25);
        help.setBounds(10,130,80,25);
        QUIT.setBounds(200,130,80,25);

        //TYLKO TYMCZASOWE, POTEM USUNĄĆ
        admin.setBounds(100, 100, 80, 25);
        user.setBounds(100, 130, 80, 25);
        panel.add(admin);
        panel.add(user);
        //

        panel.add(help);
        panel.add(button);
        panel.add(QUIT);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login_check();
            }
        };
        passwordText.addActionListener(action);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login_check();
            }
        });

        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        """
                                Admin login: admin\s
                                Admin password: admin123\s
                                \s
                                User login: user\s
                                User password: user123\s
                                """, "HELP", JOptionPane.PLAIN_MESSAGE);
            }
        });

        //TYLKO TYMCZASOWE, POTEM USUNĄĆ
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                loginStatus = "admin";
                new adminGUI();
            }
        });
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                loginStatus = "user";
                new userGUI();
            }
        });
        //

        QUIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void login_check(){
        String login = loginText.getText();
        String password = passwordText.getText();

        if (login.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(null, "Welcome admin", "Message", JOptionPane.PLAIN_MESSAGE);
            frame.dispose();
            loginStatus = "admin";
            new adminGUI();
        } else if (login.equals("user") && password.equals("user123")) {
            JOptionPane.showMessageDialog(null, "Welcome user", "Message", JOptionPane.PLAIN_MESSAGE);
            frame.dispose();
            loginStatus = "user";
            new userGUI();
        } else {
            JOptionPane.showMessageDialog(null, "Wrong Login or Password!", null, JOptionPane.INFORMATION_MESSAGE);
            passwordText.setText("");
        }
    }

}
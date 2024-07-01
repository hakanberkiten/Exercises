import java.awt.*;
import javax.swing.*;

public class Bank {
    private String name;
    private PersonalAccount currentAccount; 

    public Bank(String name) {
        this.name = name;
        this.currentAccount = new PersonalAccount("Hakan", "Berkiten", 1234);
        createFrame();
    }

    public void createFrame() {
        JFrame frame = new JFrame(getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.green);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel label = new JLabel("Enter your ID and password.");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(label, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(new JLabel("ID: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JTextField idField = new JTextField(20);
        mainPanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JPasswordField passwordField = new JPasswordField(20);
        mainPanel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            createSecondFrame();
            frame.dispose();
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void createSecondFrame() {
        JFrame optionsFrame = new JFrame("JavaBank");
        optionsFrame.setSize(300, 250);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionsFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton checkBalanceButton = new JButton("Check Balance");
        panel.add(checkBalanceButton, gbc);

        gbc.gridy++;
        JButton withdrawButton = new JButton("WithDraw");
        panel.add(withdrawButton, gbc);

        gbc.gridy++;
        JButton depositButton = new JButton("Deposit");
        panel.add(depositButton, gbc);

        gbc.gridy++;
        JButton logoutButton = new JButton("Logout");
        panel.add(logoutButton, gbc);

        checkBalanceButton.addActionListener(e -> JOptionPane.showMessageDialog(optionsFrame, 
            "Current Balance: " + currentAccount.getMoney() + " $"));

        withdrawButton.addActionListener(e -> {
            String amount = JOptionPane.showInputDialog(optionsFrame, "Enter the amount you want to withdraw:");
            try {
                double withdrawAmount = Double.parseDouble(amount);
                if (withdrawAmount > currentAccount.getMoney()) {
                    JOptionPane.showMessageDialog(optionsFrame, "Insufficient funds!");
                } else {
                    currentAccount.setMoney(currentAccount.getMoney() - withdrawAmount);
                    JOptionPane.showMessageDialog(optionsFrame, withdrawAmount + " $ withdrawn. New balance: " + currentAccount.getMoney() + " $");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(optionsFrame, "Invalid amount!");
            }
        });

        depositButton.addActionListener(e -> {
            String amount = JOptionPane.showInputDialog(optionsFrame, "Enter the amount you want to deposit:");
            try {
                double depositAmount = Double.parseDouble(amount);
                currentAccount.setMoney(currentAccount.getMoney() + depositAmount);
                JOptionPane.showMessageDialog(optionsFrame, depositAmount + " $ deposited. New balance: " + currentAccount.getMoney() + " $");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(optionsFrame, "Invalid amount!");
            }
        });

        logoutButton.addActionListener(e -> {
            optionsFrame.dispose();
            createFrame();
        });

        optionsFrame.add(panel);
        optionsFrame.setVisible(true);
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        new Bank("JAVABANK");
    }
}

class Account {
    private long id;

    public Account(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

class PersonalAccount extends Account {
    private String name;
    private String surname;
    private double money;

    public PersonalAccount(String name, String surname, long id) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.money = 0;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
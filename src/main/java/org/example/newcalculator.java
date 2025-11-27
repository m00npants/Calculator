package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newcalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double num1 = 0;





    public newcalculator() {
        setTitle("Andreas Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(350, 90));

        display.setForeground(Color.BLACK);
        display.setBackground(Color.LIGHT_GRAY);


        add(display, BorderLayout.NORTH);









        // grids for the numbers and actions
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "sqrt", "^", "+",
                "C", "=", "%", "!"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);

            btn.setBackground(Color.LIGHT_GRAY);
            btn.setForeground(Color.BLACK);
            panel.setBackground(Color.DARK_GRAY);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();


        try {
            if ("0123456789".contains(cmd)) {
                // puts the information on the display
                display.setText(display.getText() + cmd);
            } else if (cmd.equals("C")) {
                // Rensa allt
                display.setText("");
                num1 = 0;
                operator = "";
            } else if (cmd.equals("=")) {
                // gets the information from the display
                String expression = display.getText();
                double result = 0;

                if (operator.length() > 0) {

                    // Dela upp på operatorn
                    String[] parts = expression.split("\\" + operator);
                    if (parts.length == 2) {
                        double num1 = Double.parseDouble(parts[0]);
                        double num2 = Double.parseDouble(parts[1]);

                        switch (operator) {
                            case "+": result = num1 + num2; break;
                            case "-": result = num1 - num2; break;
                            case "*": result = num1 * num2; break;
                            case "/": result = num1 / num2; break;
                            case "^": result = Math.pow(num1, num2); break;
                            case "%": result = num1 % num2; break;
                        }
                    }
                }

                // shows the entire calculation
                display.setText(expression + "=" + result);
                operator = "";
            } else if (cmd.equals("sqrt")) {
                double val = Double.parseDouble(display.getText());
                display.setText("sqrt(" + val + ")=" + Math.sqrt(val));
            } else if (cmd.equals("!")) {
                int n = Integer.parseInt(display.getText());
                long fact = 1;
                for (int i = 1; i <= n; i++) fact *= i;
                display.setText(n + "!=" + fact);
            } else { // operator
                operator = cmd;
                // shows the operator instead of removing it
                display.setText(display.getText() + operator);
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }


    public static void main(String[] args) {
        new newcalculator();
    }

}
// test
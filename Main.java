import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JFrame frame;
    static JTextField textField;
    static JButton[] numberButtons = new JButton[10];
    static JButton[] functionButtons = new JButton[19];
    static JButton addBtn, subBtn, mulBtn, divBtn, eqBtn, decBtn, clrBtn, delBtn;
    static JButton sinBtn, cosBtn, tanBtn, sqrtBtn, powBtn, logBtn, lnBtn, expBtn, asinBtn, acosBtn, atanBtn;
    static JPanel panel;
    static double num1 = 0, num2 = 0, result = 0;
    static char operator;

    public static void main(String[] args) {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 400, 700);
        frame.setLayout(null);

        Font myFont = new Font("Arial", Font.BOLD, 30);
        Font smallFont = new Font("Arial", Font.PLAIN, 18);

        textField = new JTextField();
        textField.setBounds(45, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Initialize buttons
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        clrBtn = new JButton("Clear");
        delBtn = new JButton("Delete");
        decBtn = new JButton(".");
        eqBtn = new JButton("=");
        sinBtn = new JButton("sin");
        cosBtn = new JButton("cos");
        tanBtn = new JButton("tan");
        sqrtBtn = new JButton("√");
        powBtn = new JButton("^");
        logBtn = new JButton("log");
        lnBtn = new JButton("ln");
        expBtn = new JButton("exp");
        asinBtn = new JButton("asin");
        acosBtn = new JButton("acos");
        atanBtn = new JButton("atan");

        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = eqBtn;
        functionButtons[6] = delBtn;
        functionButtons[7] = clrBtn;
        functionButtons[8] = sinBtn;
        functionButtons[9] = cosBtn;
        functionButtons[10] = tanBtn;
        functionButtons[11] = sqrtBtn;
        functionButtons[12] = powBtn;
        functionButtons[13] = logBtn;
        functionButtons[14] = lnBtn;
        functionButtons[15] = expBtn;
        functionButtons[16] = asinBtn;
        functionButtons[17] = acosBtn;
        functionButtons[18] = atanBtn;

        for (JButton button : functionButtons) {
            button.setFont(smallFont);
            button.setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delBtn.setBounds(45, 610, 145, 50);
        clrBtn.setBounds(205, 610, 142, 50);

        panel = new JPanel();
        panel.setBounds(45, 100, 300, 500);
        panel.setLayout(new GridLayout(7, 4, 0, 0));
        panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(divBtn);
        panel.add(eqBtn);
        panel.add(sinBtn);
        panel.add(cosBtn);
        panel.add(tanBtn);
        panel.add(sqrtBtn);
        panel.add(powBtn);
        panel.add(logBtn);
        panel.add(lnBtn);
        panel.add(expBtn);
        panel.add(asinBtn);
        panel.add(acosBtn);
        panel.add(atanBtn);

        frame.add(textField);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(panel);

        frame.setVisible(true);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + numberButtons[finalI].getText());
                }
            });
        }

        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + ".");
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
        });

        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        });

        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
        });

        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
        });

        eqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '^':
                        result = Math.pow(num1, num2);
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
        });

        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().isEmpty()) {
                    String txt = textField.getText();
                    textField.setText(txt.substring(0, txt.length() - 1));
                }
            }
        });

        sinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.sin(Math.toRadians(value));
                textField.setText(String.valueOf(result));
            }
        });

        cosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.cos(Math.toRadians(value));
                textField.setText(String.valueOf(result));
            }
        });

        tanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.tan(Math.toRadians(value));
                textField.setText(String.valueOf(result));
            }
        });

        sqrtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.sqrt(value);
                textField.setText(String.valueOf(result));
            }
        });

        powBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '^';
                textField.setText("");
            }
        });

        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.log10(value);
                textField.setText(String.valueOf(result));
            }
        });

        lnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.log(value);
                textField.setText(String.valueOf(result));
            }
        });

        expBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.exp(value);
                textField.setText(String.valueOf(result));
            }
        });

        asinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.toDegrees(Math.asin(value));
                textField.setText(String.valueOf(result));
            }
        });

        acosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.toDegrees(Math.acos(value));
                textField.setText(String.valueOf(result));
            }
        });

        atanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.toDegrees(Math.atan(value));
                textField.setText(String.valueOf(result));
            }
        });
    }
}

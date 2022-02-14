import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prob104 {
    private int result = 0;
    private int waitingNum = 0;
    private char operator = ' ';
    private JLabel resultField;
    private JButton buttonC;
    private JButton buttonDiv;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonTim;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton buttonSub;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton buttonAdd;
    private JButton button0;
    private JButton buttonEq;

    private int calc(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else if (op == '*') return a * b;
        else if (op == '/') return b != 0 ? a / b : 0;
        else return b;  // update input value
    }

    class ButtonCAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operator = ' ';
            result = 0;
            waitingNum = 0;
            resultField.setText(Integer.toString(result));
        }
    }
    class ButtonEqAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            result = calc(result, waitingNum, operator);
            resultField.setText(Integer.toString(result));
            waitingNum = result;
            operator = ' ';
            result = 0;
        }
    }
    class ButtonOpAction implements ActionListener {
        private char op;
        ButtonOpAction(char op) {
            this.op = op;
        }
        public void actionPerformed(ActionEvent e) {
            result = calc(result, waitingNum, operator);
            waitingNum = 0;
            operator = this.op;  // set new operator
            resultField.setText(String.valueOf(operator));
        }
    }
    class ButtonNumAction implements ActionListener {
        private int number;
        ButtonNumAction(int num) {
            this.number = num;
        }
        public void actionPerformed(ActionEvent e) {
            waitingNum = waitingNum * 10 + this.number;
            resultField.setText(Integer.toString(waitingNum));
        }
    }

    public Component createComponents() {
        resultField = new JLabel("0");
        buttonC = new JButton("C");
        buttonDiv = new JButton("/");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonTim = new JButton("*");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        buttonSub = new JButton("-");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        buttonAdd = new JButton("+");
        button0 = new JButton("0");
        buttonEq = new JButton("=");

        ButtonCAction buttonCListener = new ButtonCAction();
        buttonC.addActionListener(buttonCListener);
        ButtonEqAction buttonEqListener = new ButtonEqAction();
        buttonEq.addActionListener(buttonEqListener);
        ButtonOpAction buttonDivListener = new ButtonOpAction('/');
        buttonDiv.addActionListener(buttonDivListener);
        ButtonOpAction buttonTimListener = new ButtonOpAction('*');
        buttonTim.addActionListener(buttonTimListener);
        ButtonOpAction buttonSubListener = new ButtonOpAction('-');
        buttonSub.addActionListener(buttonSubListener);
        ButtonOpAction buttonAddListener = new ButtonOpAction('+');
        buttonAdd.addActionListener(buttonAddListener);
        ButtonNumAction button0Listener = new ButtonNumAction(0);
        button0.addActionListener(button0Listener);
        ButtonNumAction button1Listener = new ButtonNumAction(1);
        button1.addActionListener(button1Listener);
        ButtonNumAction button2Listener = new ButtonNumAction(2);
        button2.addActionListener(button2Listener);
        ButtonNumAction button3Listener = new ButtonNumAction(3);
        button3.addActionListener(button3Listener);
        ButtonNumAction button4Listener = new ButtonNumAction(4);
        button4.addActionListener(button4Listener);
        ButtonNumAction button5Listener = new ButtonNumAction(5);
        button5.addActionListener(button5Listener);
        ButtonNumAction button6Listener = new ButtonNumAction(6);
        button6.addActionListener(button6Listener);
        ButtonNumAction button7Listener = new ButtonNumAction(7);
        button7.addActionListener(button7Listener);
        ButtonNumAction button8Listener = new ButtonNumAction(8);
        button8.addActionListener(button8Listener);
        ButtonNumAction button9Listener = new ButtonNumAction(9);
        button9.addActionListener(button9Listener);

        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.setLayout(new GridLayout(0, 1));
        pane.add(resultField);
        JPanel subPane1 = new JPanel();
        subPane1.setLayout(new GridLayout(1, 0));
        subPane1.add(button7);
        subPane1.add(button8);
        subPane1.add(button9);
        subPane1.add(buttonDiv);
        pane.add(subPane1);
        JPanel subPane2 = new JPanel();
        subPane2.setLayout(new GridLayout(1, 0));
        subPane2.add(button4);
        subPane2.add(button5);
        subPane2.add(button6);
        subPane2.add(buttonTim);
        pane.add(subPane2);
        JPanel subPane3 = new JPanel();
        subPane3.setLayout(new GridLayout(1, 0));
        subPane3.add(button1);
        subPane3.add(button2);
        subPane3.add(button3);
        subPane3.add(buttonSub);
        pane.add(subPane3);
        JPanel subPane4 = new JPanel();
        subPane4.setLayout(new GridLayout(1, 0));
        subPane4.add(buttonC);
        subPane4.add(button0);
        subPane4.add(buttonEq);
        subPane4.add(buttonAdd);
        pane.add(subPane4);

        return pane;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingApplication");
        Prob104 app = new Prob104();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

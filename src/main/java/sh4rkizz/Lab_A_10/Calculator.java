package sh4rkizz.Lab_A_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class Calculator extends JFrame {
    private final JButton mButton = new JButton("*");
    private final JButton dButton = new JButton("/");
    private final JButton aButton = new JButton("+");
    private final JButton sButton = new JButton("-");
    private final JTextField inputA = new JTextField("Значение А");
    private final JTextField inputB = new JTextField("Значение Б");
    private final JTextField resultField = new JTextField("Результат");
    private double valA, valB, result;

    public Calculator(String title) {
        super(title);
        Font font = new Font("Serif", Font.PLAIN, 30);
        JFrame container = new JFrame(title);

        int x = 40, y = 125;
        final int side = 56, gap = 30;
        aButton.setBounds(x, y, side, side);

        inputA.setHorizontalAlignment(JTextField.CENTER);
        inputB.setHorizontalAlignment(JTextField.CENTER);
        resultField.setHorizontalAlignment(JTextField.CENTER);

        x += side + gap;
        inputA.setBounds(x - gap, y - side - gap - 15, 2 * side + 3 * gap, side);
        inputB.setBounds(x - gap, y + gap + side + 15, 2 * side + 3 * gap, side);
        resultField.setBounds(x - 2 * gap, y + gap + 4 * side + 15, 2 * side + 5 * gap, side);
        sButton.setBounds(x, y, side, side);

        x += side + gap;
        dButton.setBounds(x, y, side, side);

        x += side + gap;
        mButton.setBounds(x, y, side, side);

        mButton.addActionListener(new Calc());
        dButton.addActionListener(new Calc());
        aButton.addActionListener(new Calc());
        sButton.addActionListener(new Calc());
        inputB.addActionListener(new Calc());
        inputA.addActionListener(new Calc());

        sButton.setFont(font);
        dButton.setFont(font);
        aButton.setFont(font);
        mButton.setFont(font);
        resultField.setFont(font);
        inputA.setFont(font);
        inputB.setFont(font);

        container.add(sButton);
        container.add(mButton);
        container.add(dButton);
        container.add(aButton);
        container.add(inputA);
        container.add(inputB);
        container.add(resultField);

        inputA.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                inputA.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Objects.equals(inputA.getText(), ""))
                    inputA.setText("Значение А");
            }
        });

        inputB.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                inputB.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Objects.equals(inputB.getText(), ""))
                    inputB.setText("Значение А");
            }
        });

        container.setLayout(null);
        container.setVisible(true);
        container.setBounds(770, 170, 400, 550);
    }

    class Calc implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String resultStr = "";
            try {
                valA = Double.parseDouble(inputA.getText());
                try {
                    valB = Double.parseDouble(inputB.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Second input is incorrect",
                            "Output", JOptionPane.PLAIN_MESSAGE);
                    resultStr = "error";
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "First input is incorrect",
                        "Output", JOptionPane.PLAIN_MESSAGE);
                resultStr = "error";
            }
            if (!resultStr.equals("error")) {
                if (event.getSource() == mButton)
                    result = valA * valB;
                else if (event.getSource() == sButton)
                    result = valA - valB;
                else if (event.getSource() == aButton)
                    result = valA + valB;
                else if (event.getSource() == dButton)
                    result = valA / valB;

                resultStr = new DecimalFormat("#.####").format(result);
                resultField.setText(resultStr);
            }
        }
    }
}
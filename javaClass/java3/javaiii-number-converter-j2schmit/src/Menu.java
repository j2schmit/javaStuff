import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu implements ActionListener{

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton decToBin = new JButton();
	JButton hexToBin = new JButton();
	JButton binToDec = new JButton();
	JButton binToHex = new JButton();
	JButton hexToDec = new JButton();
	JButton decToHex = new JButton();

    public Menu(Binary bin, Hexadecimal hex, Decimal dec) {

    }

    public void display() {
        frame.setVisible(true);
        frame.add(panel);
        panel.add(decToBin);
        decToBin.setText("Decimal to Binary");
        panel.add(decToHex);
        decToHex.setText("Decimal to Hexadecimal");
        panel.add(hexToBin);
        hexToBin.setText("Hexadecimal to Binary");
        panel.add(hexToDec);
        hexToDec.setText("Hexadecimal to Decimal");
        panel.add(binToDec);
        binToDec.setText("Binary to Decimal");
        panel.add(binToHex);
        binToHex.setText("Binary to Hexadecimal");
        frame.pack();
        decToBin.addActionListener(this);
        hexToBin.addActionListener(this);
        decToHex.addActionListener(this);
        hexToDec.addActionListener(this);
        binToHex.addActionListener(this);
        binToDec.addActionListener(this);
    }
    @Override
    public void actionPerformed( ActionEvent e) {
        String number;
        String convertedValue;
        if (e.getSource() == decToBin || e.getSource() == decToHex) {
            number = JOptionPane.showInputDialog(null,"Enter a decimal: ");
        } else if (e.getSource() == hexToBin || e.getSource() == hexToDec) {
            number = JOptionPane.showInputDialog(null,"Enter a hexadecimal: ");
        } else {
            number = JOptionPane.showInputDialog(null,"Enter a binary: ");
        }

        if (e.getSource() == decToBin) {
            convertedValue = Decimal.convertToBinary(number);
        } else if (e.getSource() == decToHex) {
            convertedValue = Decimal.convertToHexadecimal(number);
        } else if (e.getSource() == hexToBin) {
            convertedValue = Hexadecimal.convertToBinary(number);
        } else if (e.getSource() == hexToDec) {
            convertedValue = Hexadecimal.convertToDecimal(number);
        } else if (e.getSource() == binToDec) {
            convertedValue = Binary.convertToDecimal(number);
        } else {
            convertedValue = Binary.convertToHexadecimal(number);
        }

        String msg = "The converted value is: " + convertedValue;
        JOptionPane.showMessageDialog(null,msg);
    }
}

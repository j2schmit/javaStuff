package GuestBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ContactViewController {

    private JFrame mainFrame;
    private JPanel fieldPanel;
    private JPanel submitPanel;
    private JPanel scrollPanel;
    private ArrayList<Contact> contacts;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public ContactViewController () {
        prepareGUI();
        showTextField();
    }

    private void prepareGUI(){
        contacts = new ArrayList<Contact>();

        mainFrame = new JFrame();
        mainFrame.setSize(800,400);
        mainFrame.setLayout(new GridLayout(0, 2));
        //mainFrame.setBounds(100, 100, 800, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout( 4, 2));

        submitPanel = new JPanel();
        scrollPanel = new JPanel();

        mainFrame.add(fieldPanel);
        mainFrame.add(scrollPanel);
        mainFrame.add(submitPanel);

        mainFrame.setVisible(true);
    }
    private void showTextField(){

        final JLabel  firstNameLabel= new JLabel("First Name: ", JLabel.CENTER);
        final JLabel  lastNameLabel = new JLabel("Last Name: ", JLabel.CENTER);
        final JLabel  addressLabel = new JLabel("Address: ", JLabel.CENTER);
        final JLabel  phoneNumberLabel = new JLabel("Phone Number: ", JLabel.CENTER);
        final JTextField firstName = new JTextField(6);
        final JTextField lastName = new JTextField(6);
        final JTextField address = new JTextField(6);
        final JTextField phoneNumber = new JTextField(6);
        JTextArea textArea = new JTextArea();
        //textArea.setLineWrap(true);
        //textArea.setEnabled(true);
        //textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(textArea);
        scrollPane.setPreferredSize(new Dimension(350,200));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Contact contact = new Contact(firstName.getText(),
                        lastName.getText(),
                        address.getText(),
                        phoneNumber.getText());

                if (newContact(contact))
                    contacts.add(contact);

                firstName.setText("");
                lastName.setText("");
                address.setText("");
                phoneNumber.setText("");
                textArea.setText(getContactsInfo(contacts));
            }
        });
        fieldPanel.add(firstNameLabel);
        fieldPanel.add(firstName);
        fieldPanel.add(lastNameLabel);
        fieldPanel.add(lastName);
        fieldPanel.add(addressLabel);
        fieldPanel.add(address);
        fieldPanel.add(phoneNumberLabel);
        fieldPanel.add(phoneNumber);
        submitPanel.add(submitButton);
        scrollPanel.add(scrollPane);

        mainFrame.setVisible(true);
    }

    private String getContactsInfo(ArrayList<Contact> contacts) {
        Collections.sort(contacts);
        String text = "";
        for (Contact contact: contacts) {
            text += "Contact:\n";
            text += "First Name:    " + contact.getFirstName() + "\n";
            text += "Last Name:     " + contact.getLastName() + "\n";
            text += "Address:       " + contact.getAddress() + "\n";
            text += "Phone Number:  " + contact.getPhoneNumber() + "\n\n\n";
        }
        return text;
    }

    private boolean newContact(Contact contact) {
        boolean newContact = true;
        for (Contact c: contacts) {
            if (c.compareTo(contact) == 0) {
                newContact = false;
                break;
            }
        }
        return newContact;
    }
}

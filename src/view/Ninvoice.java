package view;


import javax.swing.*;
import java.awt.*;


public class Ninvoice extends JDialog {
    private JTextField custNameField;
    private JTextField invDateField;
    private JLabel custNameLbl;
    private JLabel invDateLbl;
    private JButton okBtn;
    private JButton cancelBtn;

    public Ninvoice(frame frame) {
        custNameLbl = new JLabel("Customer Name:");
        custNameField = new JTextField(20);
        invDateLbl = new JLabel("Invoice Date:");
        invDateField = new JTextField(20);
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        okBtn.setActionCommand("NinvoiceOK");
        cancelBtn.setActionCommand("NinvoiceCancel");

        okBtn.addActionListener(frame.getActionListener());
        cancelBtn.addActionListener(frame.getActionListener());
        setLayout(new GridLayout(3, 2));

        add(invDateLbl);
        add(invDateField);
        add(custNameLbl);
        add(custNameField);
        add(okBtn);
        add(cancelBtn);

        pack();

    }

    public JTextField getCustNameField() {
        return custNameField;
    }

    public JTextField getInvDateField() {
        return invDateField;
    }

}
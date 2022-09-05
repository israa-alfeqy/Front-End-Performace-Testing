package handler;

import model.*;
import view.frame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Table implements ListSelectionListener {

    private frame frame;

    public Table(frame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = frame.getinvHTable().getSelectedRow();
        System.out.println("Invoice selected: " + selectedInvIndex);
        if (selectedInvIndex != -1) {
            Invoice selectedInv = frame.getInvoicesArray().get(selectedInvIndex);
            ArrayList<Line> lines = selectedInv.getLines();
            Ltable LtableModel = new Ltable(lines);
            frame.setLinesArray(lines);
            frame.getInvLTable().setModel(LtableModel);
            //displaying selected invoice data
            frame.getCustNameLbl().setText(selectedInv.getCustomerName());
            frame.getInvNumLbl().setText("" + selectedInv.getInvoiceNumber());
            frame.getInvTotaLbl().setText("" + selectedInv.getInvoiceTotal());
            frame.getInvDateLbl().setText(frame.dateFormat.format(selectedInv.getInvoiceDate()));
        }
    }

}
package handler;

import model.*;

import view.frame;
import view.Ninvoice;
import view.Nline;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Action implements ActionListener {

    private final frame frame;
    private Ninvoice headerDialog;
    private Nline lineDialog;

    public Action(view.frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //according to value received from action command the required method will run
        switch (e.getActionCommand()) {
            case "Save File":
                saveFiles();
                break;

            case "Load File":
                loadFiles();
                break;

            case "Create New Invoice":
                createNinvoice();
                break;

            case "Delete Invoice":
                deleteInvoice();
                break;

            case "New Item":
                createNewItem();
                break;

            case "Delete Item":
                deleteItem();
                break;

            case "NinvoiceOK":
                NinvoiceOkButton();
                break;

            case "NinvoiceCancel":
                NinvoiceCancelButton();
                break;

            case "newLineOK":
                newLineOkButton();
                break;

            case "newLineCancel":
                newLineCancelButton();
                break;
        }
    }


    private void saveFiles() {
        ArrayList<Invoice> invoicesArray = frame.getInvoicesArray();
        JFileChooser fc = new JFileChooser();
        try {
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                String headers = "";
                String lines = "";
                for (Invoice invoice : invoicesArray) {
                    headers += invoice.toString();
                    headers += "\n";
                    for (Line line : invoice.getLines()) {
                        lines += line.toString();
                        lines += "\n";
                    }
                }

                headers = headers.substring(0, headers.length()-1);
                lines = lines.substring(0, lines.length()-1);
                result = fc.showSaveDialog(frame);
                File lineFile = fc.getSelectedFile();
                FileWriter lfw = new FileWriter(lineFile);
                hfw.write(headers);
                lfw.write(lines);
                hfw.close();
                lfw.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "An Error Happened", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadFiles() {

        try {
            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showOpenDialog(frame);
            //if user clicks open
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                ArrayList<Invoice> Invoices = new ArrayList<>();
                for (String headerLine : headerLines) {
                    //spliting invoice header elements
                    String[] parts = headerLine.split(",");
                    int invid = Integer.parseInt(parts[0]);
                    Date invoiceDate = frame.dateFormat.parse(parts[1]);
                    Invoice header = new Invoice(invid, parts[2], invoiceDate);
                    Invoices.add(header);
                }
                frame.setInvoicesArray(Invoices);

                result = fileChooser.showOpenDialog(frame);
                //if user clicks open
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineLines = Files.readAllLines(linePath);
                    ArrayList<Line> Lines = new ArrayList<>();
                    for (String lineLine : lineLines) {
                        //spliting invoice line elements
                        String[] parts = lineLine.split(",");
                        int invCode = Integer.parseInt(parts[0]);
                        double price = Double.parseDouble(parts[2]);
                        int count = Integer.parseInt(parts[3]);
                        Invoice inv = frame.getInvObject(invCode);
                        Line line = new Line(inv, parts[1], price, count);
                        inv.getLines().add(line);
                    }
                }
                Tableheader TableheaderModel = new Tableheader(Invoices);
                frame.setTableheaderModel(TableheaderModel);
                frame.getinvHTable().setModel(TableheaderModel);

            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "An Error Happened", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "An Error Happened", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createNinvoice() {
        headerDialog = new Ninvoice(frame);
        headerDialog.setVisible(true);
    }

    private void deleteInvoice() {
        int selectedInvoiceIndex = frame.getinvHTable().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            frame.getInvoicesArray().remove(selectedInvoiceIndex);
            frame.getTableheaderModel().fireTableDataChanged();
            frame.getInvLTable().setModel(new Ltable(null));
            frame.setLinesArray(null);
            frame.getCustNameLbl().setText("");
            frame.getInvNumLbl().setText("");
            frame.getInvTotaLbl().setText("");
            frame.getInvDateLbl().setText("");
        }
    }

    private void createNewItem() {
        lineDialog = new Nline(frame);
        lineDialog.setVisible(true);
    }

    private void deleteItem() {
        int selectedLineIndex = frame.getInvLTable().getSelectedRow();
        int selectedInvoiceIndex = frame.getinvHTable().getSelectedRow();
        if (selectedLineIndex != -1) {
            frame.getLinesArray().remove(selectedLineIndex);
            Ltable LtableModel = (Ltable) frame.getInvLTable().getModel();
            LtableModel.fireTableDataChanged();
            frame.getInvTotaLbl().setText("" + frame.getInvoicesArray().get(selectedInvoiceIndex).getInvoiceTotal());
            frame.getTableheaderModel().fireTableDataChanged();
            frame.getinvHTable().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    }

    private void NinvoiceOkButton() {
        headerDialog.setVisible(false);

        String custName = headerDialog.getCustNameField().getText();
        String str = headerDialog.getInvDateField().getText();
        Date d = new Date();
        //handelling date entered by user
        try {
            d = frame.dateFormat.parse(str);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Date format is not correct, will add today's date.", "An error happened", JOptionPane.ERROR_MESSAGE);
        }

        int invNum = 0;
        for (Invoice inv : frame.getInvoicesArray()) {
            if (inv.getInvoiceNumber() > invNum) {
                invNum = inv.getInvoiceNumber();
            }
        }
        invNum++;
        Invoice newInv = new Invoice(invNum, custName, d);
        frame.getInvoicesArray().add(newInv);
        frame.getTableheaderModel().fireTableDataChanged();
        headerDialog.dispose();
        headerDialog = null;
    }

    private void NinvoiceCancelButton() {
        headerDialog.setVisible(false);
        headerDialog.dispose();
        headerDialog = null;
    }

    private void newLineOkButton() {
        lineDialog.setVisible(false);

        String name = lineDialog.getItemNameField().getText();
        String str1 = lineDialog.getItemCountField().getText();
        String str2 = lineDialog.getItemPriceField().getText();
        int count = 1;
        double price = 1;
        //handelling item price and number of items entered by user
        try {
            count = Integer.parseInt(str1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Count format is not correct!", "An error happened", JOptionPane.ERROR_MESSAGE);
        }

        try {
            price = Double.parseDouble(str2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Price format is not correct!", "An error happened", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvHeader = frame.getinvHTable().getSelectedRow();
        if (selectedInvHeader != -1) {
            Invoice invHeader = frame.getInvoicesArray().get(selectedInvHeader);
            Line line = new Line(invHeader, name, price, count);
            //invHeader.getLines().add(line);
            frame.getLinesArray().add(line);
            Ltable LtableModel = (Ltable) frame.getInvLTable().getModel();
            LtableModel.fireTableDataChanged();
            frame.getTableheaderModel().fireTableDataChanged();
        }
        frame.getinvHTable().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        lineDialog.dispose();
        lineDialog = null;
    }

    private void newLineCancelButton() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
    }



}
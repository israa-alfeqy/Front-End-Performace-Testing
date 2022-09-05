package model;
import view.frame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Tableheader extends AbstractTableModel {

    private ArrayList<Invoice> invoicesArray;

    private String[] columns = {"Invoice Num", "Invoice Date", "Customer Name", "Invoice Total"};

    public Tableheader(ArrayList<Invoice> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }

    @Override
    public int getRowCount() {
        return invoicesArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice inv = invoicesArray.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inv.getInvoiceNumber();
            case 1:
                return frame.dateFormat.format(inv.getInvoiceDate());
            case 2:
                return inv.getCustomerName();
            case 3:
                return inv.getInvoiceTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
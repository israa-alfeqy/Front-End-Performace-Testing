package model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private int invoiceNumber;
    private String customerName;
    private Date invoiceDate;
    private ArrayList<Line> lines;

    private DateFormat datef = new SimpleDateFormat("dd-MM-yyyy");

    public Invoice() {
    }

    public Invoice(int invoiceNumber, String customerName, Date invoiceDate) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Line> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public double getInvoiceTotal() {
        double total = 0.0;

        for (int i = 0; i < getLines().size(); i++) {
            total += getLines().get(i).getLineTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        return invoiceNumber + "," + datef.format(invoiceDate) + "," + customerName;
    }

}
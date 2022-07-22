package com.myframe;

import javax.swing.*;
import java.awt.*;
public class frame extends JFrame {

private final JTable table;
private String[] cols={"NO.","date","Customer","Total"};
private String[] [] data={{"NO.","date","Customer","Total"},
        {"NO.","date","Customer","Total"}};
private JMenuBar menuBar;
private JMenu file;
private JMenuItem load;
private JMenuItem save;

public frame(){
    setSize (1200,900);
    setLocation(200,50);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    menuBar=new JMenuBar();
    file=new JMenu("file");
    load=new JMenuItem("load file");
    save=new JMenuItem("save file");
    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

    file.add(load);
    file.add(save);
    menuBar.add(file);
    setJMenuBar(menuBar);

    JPanel panel = new JPanel();
    JPanel panelX = new JPanel();
    JPanel panel1 =new JPanel();
    JLabel label =new JLabel("Invoices table .");
    table = new JTable(data,cols);
    panelX.setAlignmentX(Component.LEFT_ALIGNMENT);
    panelX.setMaximumSize(new Dimension(450,900));
    panelX.setBounds(0,0,250,400);
    panel.setMaximumSize(new Dimension(250,400));
    panelX.setLayout(new FlowLayout());
    panelX.add(label);
    panelX.add(panel.add(new JScrollPane(table)));


    panel1.setBounds(100,500,250,400);
    JButton create = new JButton("create new invoices");
    JButton delete = new JButton("delete invoices");
    create.setBounds(450,0,80,30);
    delete.setBounds(450,100,80,30);
    panel1.add(create);
    panel1.add(delete);
     panelX.add(panel1);
     add(panelX);


    JPanel panel2=new JPanel();
    JPanel panelY = new JPanel();
    JPanel panel3=new JPanel();
    JPanel panel4=new JPanel();
    JTable table1 = new JTable(data, cols);
    JLabel label1 =new JLabel("Invoices items .");
    JLabel invoices_number=new JLabel("invoices number");
    JLabel number=new JLabel("23");
    JLabel date=new JLabel("invoices date");
    JLabel name=new JLabel("Customer name");
    JLabel invoices_total=new JLabel("invoices total");
    JLabel total=new JLabel("320");
    JTextField invoices_date=new JTextField(15);
    JTextField customer_name=new JTextField(15);
    panel4.add(invoices_number);
    panel4.add(number);
    panel4.add(date);
    panel4.add(invoices_date);
    panel4.add(name);
    panel4.add(customer_name);
    panel4.add(invoices_total);
    panel4.add(total);
panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
    panelY.setAlignmentX(Component.RIGHT_ALIGNMENT);
    panelY.setMaximumSize(new Dimension(450,900));
    panelY.setBounds(300,10,250,900);
    panel2.setBounds(300,400,250,400);
    panel2.setMaximumSize(new Dimension(250,400));
    JButton save = new JButton("save");
    JButton cancel = new JButton("cancel");
    save.setBounds(700,700,80,30);
    cancel.setBounds(780,780,80,30);
    panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
   panelY.setLayout(new FlowLayout());

   panelY.add(panel4);
    panel2.add(label1);
    panel2.add(new JScrollPane(table1));
    panel3.add(save);
    panel3.add(cancel);

   panelY.add(panel2);
    panelY.add(panel3);
   add(panelY);


panel.setAlignmentX(getAlignmentX());
panel2.setAlignmentX(getAlignmentY());
}

public static void main(String[] args){
    new frame().setVisible(true);

}
}

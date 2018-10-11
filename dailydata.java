/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalsoftwre.com.dcs.project;

/**
 *
 * @author AsiThou
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import jxl.write.Label;
import jxl.Workbook;
import jxl.Sheet;
import jxl.Cell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class dailydata extends JFrame implements ActionListener
{
    File file;
    FileWriter fw;
    FileReader fr;
    String path;
    
    JDialog load;
    JProgressBar pb;
    JFileChooser filechooser;
    JPanel pa,close,min,head;
    JLabel closel,minl,headl,fdate,tdate,total,pname,pnumber;
    JTextField patient_name,patient_number;
    JButton back,show,importxl;
    JRadioButton all,single,multi,name,mname,bill_no;
    ButtonGroup bg;
    JTextField date1,date2;
    JTable list=new JTable();
    JLayeredPane l;
    DefaultTableModel model=new DefaultTableModel();
    JScrollPane sp=new JScrollPane(list);
    Connection con;
    Statement st;
    ResultSet rs;
    
    int x,y;
    String t="TOTAL";
    public dailydata()
    {
        super("medicine list");
        setBounds(10, 10, 1350, 720);
        setLayout(null);
        //setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        
        list.setModel(model);
        model.addColumn("S.NO");
        model.addColumn("BILL NO");
        model.addColumn("BATCH NO");
        model.addColumn("MEDICINE NAME");
        model.addColumn("QUANTITY");
        model.addColumn("AMOUNT PER 1 MEDICINE");
        model.addColumn("TOTAL AMOUNT");
        model.addColumn("TAX");
        model.addColumn("DATE");
        model.addColumn("TIME");
        model.addColumn("SELLER");
        
        sp=new JScrollPane(list);
        sp.setBounds(0, 150, getWidth(), getHeight()-250);
        add(sp);
        list.setRowHeight(40);
        list.setFont(new Font("",Font.PLAIN,20));
        
        
        total=new JLabel(t);
        total.setBounds(getWidth()-550, 631, 500, 100);
        total.setFont(new Font("",Font.BOLD,50));
        add(total);
        
        all=new JRadioButton("all");
        all.setBounds(10, 40, 40, 30);
        all.setBackground(Color.WHITE);
        add(all);
                
        single=new JRadioButton("view by date");
        single.setBounds(60, 40, 90, 30);
        single.setBackground(Color.WHITE);
        add(single);
        
        multi=new JRadioButton("view by between two dates");
        multi.setBounds(220, 40, 170, 30);
        multi.setBackground(Color.WHITE);
        //add(multi);
        
        bill_no=new JRadioButton("view by bill no");
        bill_no.setBounds(290, 40, 120, 30);
        bill_no.setBackground(Color.WHITE);
        add(bill_no);
        
        name=new JRadioButton("view by seller name");
        name.setBounds(160, 40, 120, 30);
        name.setBackground(Color.WHITE);
        add(name);
        
        mname=new JRadioButton("view by medicine name");
        mname.setBounds(530, 40, 140, 30);
        mname.setBackground(Color.WHITE);
        //add(mname);
        
        fdate=new JLabel("date    d-m-yyyy");
        fdate.setBounds(10, 75, 125, 30);
        add(fdate);
        
        tdate=new JLabel("date from yyyy-mm-dd");
        tdate.setBounds(10, 110, 125, 30);
        //add(tdate);
        
        date1=new JTextField();
        date1.setBounds(135, 75, 200, 30);
        add(date1);
        
        date2=new JTextField();
        date2.setBounds(135, 110, 200, 30);
        //add(date2);
        
        show=new JButton("show");
        show.setBounds(355, 75, 60, 30);
        add(show);
        
        importxl=new JButton("export to excel sheet");
        importxl.setBounds(425, 75, 200, 30);
        importxl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/xl.png")));
        add(importxl);
        
        bg=new ButtonGroup();
        bg.add(single);
        bg.add(multi);
        bg.add(all);
        bg.add(name);
        bg.add(mname);
        bg.add(bill_no);
        
        pname=new JLabel("Patent Name");
        pname.setBounds(640, 75, 70, 30);
        add(pname);
        
        patient_name=new JTextField();
        patient_name.setBounds(710, 75, 150, 30);
        add(patient_name);
        
        pnumber=new JLabel("Patent Number");
        pnumber.setBounds(870, 75, 80, 30);
        add(pnumber);
        
        patient_number=new JTextField();
        patient_number.setBounds(950, 75, 150, 30);
        add(patient_number);
        
        date1.setEnabled(false);
        date2.setEnabled(false);
        
        l=new JLayeredPane();
        l.setBounds(5, 35, 630, 105);
        l.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(l);

        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
            
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}

        
        
        back=new JButton();
        back.setBounds(10,631,71,68);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/goback.png")));
        add(back);
        
        minl=new JLabel();
        minl.setBounds(getWidth()-62, 0, 30, 30);
        minl.setBackground(Color.WHITE);
        minl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wmin.png"))); 
        add(minl);
        
        min=new JPanel();
        min.setBounds(getWidth()-62, 0, 30, 30);
        min.setBackground(Color.WHITE);
        add(min);
        
        closel=new JLabel();
        closel.setBounds(getWidth()-30, 0, 30, 30);
        closel.setBackground(Color.WHITE);
        closel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wclose.png")));
        add(closel);
        
        close=new JPanel();
        close.setBounds(getWidth()-30, 0, 30, 30);
        close.setBackground(Color.WHITE);
        add(close);
        
        headl=new JLabel("  Sales Record");
        headl.setBounds(0, 0, getWidth(), 30);
        headl.setBackground(Color.WHITE);
        add(headl);
        
        head=new JPanel();
        head.setBounds(0, 0, getWidth(), 30);
        head.setBackground(Color.WHITE);
        add(head);
        
        pa=new JPanel();
        pa.setBounds(0, 0, getWidth(), getHeight());
        pa.setBackground(Color.WHITE);
        add(pa);
        
        setBounds(10, 10, 1300, 720);
        setBounds(10, 10, 1350, 720);
        
        back.addActionListener(this);
        show.addActionListener(this);
        importxl.addActionListener(this);
        all.addActionListener(this);
        single.addActionListener(this);
        multi.addActionListener(this);
        name.addActionListener(this);
        mname.addActionListener(this);
        bill_no.addActionListener(this);
        
        
        all.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ESCAPE)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new home().setVisible(true);
                    //System.exit(0);
                }
            }
        });
        list.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                int k=ke.getKeyCode();
                if(k==KeyEvent.VK_DOWN)
                {
                    //JOptionPane.showMessageDialog(patient_name, "hi");
                    try
                    {
                        String val=list.getModel().getValueAt(list.getSelectedRow(), 1).toString();
                        //list=new JTable();
                        PreparedStatement ps=con.prepareStatement("select * from sales_data where billno=?");
                        //st=con.createStatement();
                        //rs=st.executeQuery("select * from sales_data");
                        //int count=1;
                         ps.setString(1, val);
                         rs=ps.executeQuery();
                         if(rs.next())
                         {
                             //rs.next();
                            //String[] medicinedata={rs.getString("sno"),rs.getString("billno"),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("amount"),rs.getString("total"),rs.getString("tax"),rs.getString("date"),rs.getString("time"),rs.getString("seller")}; 
                            //model.addRow(medicinedata);
                            patient_name.setText(rs.getString("pname"));
                            patient_number.setText(rs.getString("pno"));
                            //count++;
                        }
                        //rs.close();
                        //st.close();
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(rootPane, e.getMessage());
                    }
                }
                else if(k==KeyEvent.VK_UP)
                {
                    //JOptionPane.showMessageDialog(patient_name, "hi");
                    try
                    {
                        String val=list.getModel().getValueAt(list.getSelectedRow(), 1).toString();
                        //list=new JTable();
                        //PreparedStatement ps=con.prepareStatement();
                        //st=con.createStatement();
                        //rs=st.executeQuery("select * from sales_data");
                        //int count=1;
                        PreparedStatement ps=con.prepareStatement("select * from sales_data where billno=?");
                        ps.setString(1, val);
                        rs=ps.executeQuery();
                        if(rs.next())
                        {
                             //rs.next();
                            //String[] medicinedata={rs.getString("sno"),rs.getString("billno"),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("amount"),rs.getString("total"),rs.getString("tax"),rs.getString("date"),rs.getString("time"),rs.getString("seller")}; 
                            //model.addRow(medicinedata);
                            patient_name.setText(rs.getString("pname"));
                            patient_number.setText(rs.getString("pno"));
                            //count++;
                        }
                        //rs.close();
                        //st.close();
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(rootPane, e.getMessage());
                    }
                }
            }
        });
        date1.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    if(single.isSelected()==true)
                    {
                        singleDate();
                    }
                    else if(all.isSelected()==true)
                    {
                        all();
                    }
                    else if(multi.isSelected()==true)
                    {
                        //all();
                
                    }
                    else if(name.isSelected()==true)
                    {
                        getBySellerName();
                    }
                    else if(bill_no.isSelected()==true)
                    {
                        getByBillNo();
                    }
                    else
                    {
                        for(int i=model.getRowCount()-1;i>=0;i--)
                        {   
                            model.removeRow(i);
                        }
                    }
                    totalAmount();
                }
            }
        });
        
        back.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                backenter(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                backexit(me);
            }
        });
        closel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                close.setBackground(Color.red);
                //setBounds(me.getXOnScreen()-getX(), me.getXOnScreen()-getX(),900,700);
                closel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wclose.png")));
                repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                close.setBackground(Color.WHITE);
                //setBounds(me.getXOnScreen()-getX(), me.getXOnScreen()-getX(),900,700);
                closel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wclose.png")));
                repaint();
            }
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                try
                {
                    Statement st;
                    //Class.forName("com.mysql.jdbc.Driver");
                    //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
                    st=con.createStatement();
                    st.executeUpdate("DELETE FROM user_login WHERE sno=1");
                    st.close();
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                System.exit(0);
            }
        });
        minl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                min.setBackground(Color.lightGray);
                //setBounds(me.getXOnScreen()-getX(), me.getXOnScreen()-getX(),900,700);
                minl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wmin.png")));
                repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                min.setBackground(Color.WHITE);
                //setBounds(me.getXOnScreen()-getX(), me.getXOnScreen()-getX(),900,700);
                minl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wmin.png")));
                repaint();
            }
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                setState(1);
            }
        });
        headl.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent me)
            {
                x=me.getX();
                y=me.getY();
            }
        });
        headl.addMouseMotionListener(new java.awt.event.MouseAdapter() {
                
            public void mouseDragged(java.awt.event.MouseEvent me)
            {
                setLocation(me.getXOnScreen()-x, me.getYOnScreen()-y);
            }
        });
       
    }
            
    
    public void backenter(java.awt.event.MouseEvent me)
    {
        back.setBounds(20,641,71,68);
        
    }
    public void backexit(java.awt.event.MouseEvent me)
    {
        back.setBounds(10,631,71,68);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
            setVisible(false);
            new home().setVisible(true);
        }
        else if(ae.getSource()==all)
        {
            date1.setEnabled(false);
            for(int i=model.getRowCount()-1;i>=0;i--)
            {
                model.removeRow(i);
            }
            //pname.setText("");
            //pnumber.setText("");
            patient_name.setText("");
            patient_number.setText("");
        }
        else if(ae.getSource()==single)
        {
            fdate.setText("date    d-m-yyyy");
            date1.setEnabled(true);
            for(int i=model.getRowCount()-1;i>=0;i--)
            {
                model.removeRow(i);
            }
            //pname.setText("");
            //pnumber.setText("");
            patient_name.setText("");
            patient_number.setText("");
        }
        else if(ae.getSource()==bill_no)
        {
            fdate.setText("enter bill no");
            date1.setEnabled(true);
            for(int i=model.getRowCount()-1;i>=0;i--)
            {
                model.removeRow(i);
            }
            //pname.setText("");
            //pnumber.setText("");
            patient_name.setText("");
            patient_number.setText("");
        }
        else if(ae.getSource()==multi)
        {
            fdate.setText("date from yyyy-mm-dd");
        
            date1.setEnabled(false);
            for(int i=model.getRowCount()-1;i>=0;i--)
            {
                model.removeRow(i);
            }
        }
        if(ae.getSource()==name)
        {
            fdate.setText("enter seller name");
            date1.setEnabled(true);
            for(int i=model.getRowCount()-1;i>=0;i--)
            {
                model.removeRow(i);
            }
            patient_name.setText("");
            patient_number.setText("");
        }
        else if(ae.getSource()==show)
        {
            if(single.isSelected()==true)
            {
                singleDate();
            }
            else if(all.isSelected()==true)
            {
                all();
            }
            else if(multi.isSelected()==true)
            {
                //all();
                
            }
            else if(name.isSelected()==true)
            {
                getBySellerName();
            }
            else if(bill_no.isSelected()==true)
            {
                getByBillNo();
            }
            else
            {
                for(int i=model.getRowCount()-1;i>=0;i--)
                {
                    model.removeRow(i);
                }
            }
            totalAmount();
        }
        else if(ae.getSource()==importxl)
        {
            //importfromExcelSheet();
            if(list.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(rootPane, "don,t export empty table data");
            }
            else
            {
                
                exportTOExcelSheet();
            }
        }
    }
    
    public void all()
    {
        try
        {
            //list=new JTable();
            st=con.createStatement();
            rs=st.executeQuery("select * from sales_data");
            //int count=1;
            while(rs.next())
            {
                
               String[] medicinedata={rs.getString("sno"),rs.getString("billno"),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("amount"),rs.getString("total"),rs.getString("tax"),rs.getString("date"),rs.getString("time"),rs.getString("seller")}; 
                model.addRow(medicinedata);
                patient_name.setText(rs.getString("pname"));
                patient_number.setText(rs.getString("pno"));
                //count++;
            }
            rs.close();
            st.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    public void singleDate()
    {
        String value;
        try
                {
                    value=date1.getText();
                    
                    st=con.createStatement();
                    rs=st.executeQuery("select * from sales_data");
                    
                    while(rs.next())
                    {
                        if(value.equals(rs.getString("date")))
                        {
                
                        String[] medicinedata={rs.getString("sno"),rs.getString("billno"),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("amount"),rs.getString("total"),rs.getString("tax"),rs.getString("date"),rs.getString("time"),rs.getString("seller")}; 
                        model.addRow(medicinedata);
                        patient_name.setText(rs.getString("pname"));
                        patient_number.setText(rs.getString("pno"));
                        //count++;
                        
                        }
                        
                    }
                    rs.close();
                    st.close();
                     
                }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
                      
    }
    public void totalAmount()
    {
        String value;
        int row=0,column=6;
        double tot=0;
        //value=list.getModel().getValueAt(row, column).toString();
        for(row=0;row<model.getRowCount();row++)
        {
            value=list.getModel().getValueAt(row, column).toString();
            tot+=Double.parseDouble(value);
        }
        total.setText(t+" "+Double.toString(tot));
    }
    public void multiDate()
    {
        String value;
        String value2;
        try
                {
                    /*PreparedStatement ps;
                    ps=con.prepareStatement("select * from sales_data where date=?");
                    ps.setString(1, date1.getText().toString());
                    rs=ps.executeQuery();*/
                    value=date1.getText();
                    value2=date2.getText();
                    st=con.createStatement();
                    rs=st.executeQuery("select * from sales_data");
  //                  rs=st.executeQuery("select * from sales_data" 
//+ " WHERE date BETWEEN "+date1.getText()+" AND "+date2.getText());
                    
                    while(rs.next())
                    {
                        if(value.endsWith(rs.getString("date")))
                        {
                
                        String[] medicinedata={rs.getString("sno"),rs.getString("billno"),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("amount"),rs.getString("total"),rs.getString("date"),rs.getString("time")}; 
                        model.addRow(medicinedata);
                        //count++;
                        
                        }
                        
                    }
                     
                }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    public void getBySellerName()
    {
        String value;
        try
                {
                    value=date1.getText();
                    
                    st=con.createStatement();
                    rs=st.executeQuery("select * from sales_data");
                    
                    while(rs.next())
                    {
                        if(value.equals(rs.getString("seller")))
                        {
                
                        String[] medicinedata={rs.getString("sno"),rs.getString("billno"),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("amount"),rs.getString("total"),rs.getString("tax"),rs.getString("date"),rs.getString("time"),rs.getString("seller")}; 
                        model.addRow(medicinedata);
                        patient_name.setText(rs.getString("pname"));
                        patient_number.setText(rs.getString("pno"));
                        //count++;
                        
                        }
                        
                    }
                     rs.close();
                     st.close();
                }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        
    }
    public void getByBillNo()
    {
        String value;
        try
                {
                    value=date1.getText();
                    
                    st=con.createStatement();
                    rs=st.executeQuery("select * from sales_data");
                    
                    while(rs.next())
                    {
                        if(value.equals(rs.getString("billno")))
                        {
                
                        String[] medicinedata={rs.getString("sno"),rs.getString("billno"),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("amount"),rs.getString("total"),rs.getString("tax"),rs.getString("date"),rs.getString("time"),rs.getString("seller")}; 
                        model.addRow(medicinedata);
                        patient_name.setText(rs.getString("pname"));
                        patient_number.setText(rs.getString("pno"));
                        //count++;
                        
                        }
                        
                    }
                     rs.close();
                     st.close();
                }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        
    }
    public void exportTOExcelSheet()
    {
        filechooser=new JFileChooser();
        int opt=filechooser.showSaveDialog(null);
        
        if(opt==JFileChooser.CANCEL_OPTION)
        {
            
        }
        else
        {
        file=new File(filechooser.getSelectedFile().getAbsolutePath());
        
        try
        {   
            WritableWorkbook myexcel=Workbook.createWorkbook(file);
            WritableSheet mysheet=myexcel.createSheet("sale data",0);
            
           
                
            for(int row=0;row<model.getRowCount();row++)
            {
                for(int column=0;column<model.getColumnCount();column++)
                {
                    String data=list.getModel().getValueAt(row, column).toString();
                    Label label=new Label(column,row,data);
                    mysheet.addCell(label);
                }
            }
                myexcel.write(); 
            myexcel.close();
            JOptionPane.showMessageDialog(rootPane, "file successfully exported to "+file);
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        }
    }
    public void importfromExcelSheet()
    {
        filechooser=new JFileChooser();
        filechooser.showOpenDialog(filechooser);
        file=new File(filechooser.getSelectedFile().getAbsolutePath());
        try
        {   
            Workbook wb=Workbook.getWorkbook(file);
            Sheet s=wb.getSheet(0);
            int row=s.getRows();
            int column=s.getColumns();
           
            for(int i=0;i<row;i++)
            {
                String[] a={"","","","","","","","","",""};
                model.addRow(a);
                for(int j=0;j<column;j++)
                {
                    Cell c=s.getCell(j, i);
                    
                    list.setValueAt(c.getContents(), i, j);
                    
                    
                }
            }
                //myexcel.write(); 
            JOptionPane.showMessageDialog(rootPane, "file successfully exported to "+file);
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        
    }
    public static void main(String a[])
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dailydata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dailydata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dailydata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dailydata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new dailydata().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}
    

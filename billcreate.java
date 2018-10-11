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
import com.sun.jmx.snmp.BerDecoder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import  java.util.Date;
import java.util.Calendar;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.GregorianCalendar;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class billcreate extends JFrame implements ActionListener
{
    //@SuppressWarnings("unchecked")
    JPanel pa,pa2,exit,ex1,min;
    Date date=new Date();
    Time time;
    JComboBox tn,gn;
    JTable table=new JTable();
    JScrollPane sp;
    DefaultTableModel mod=new DefaultTableModel();
    JLabel l1,title,billno,batchno,mname,qty,rs,ex,min1,framen,total,pna,pno,exp,stk,tx,gname;
    JTextField tb,tba,tq,tr,pname,pnumber,expdate,stock,tax;
    JButton add,print,back,del;
    Connection con,con2;
    Statement st;
    ResultSet rset;
    PreparedStatement ps;
    PrinterJob pj;
    PageFormat pf;
    
    Calendar cal=Calendar.getInstance();
    
    Color c=new Color(22, 88, 161);
    Color c1=new Color(17, 152, 161);
    
    int day=cal.get(Calendar.DAY_OF_MONTH);
    int month=cal.get(Calendar.MONTH)+1;
    int year=cal.get(Calendar.YEAR);
    
    int hour=cal.get(Calendar.HOUR);
    int minute=cal.get(Calendar.MINUTE);
    int second=cal.get(Calendar.SECOND);
    
    
    String DATE=Integer.toString(day),MONTH=Integer.toString(month),YEAR=Integer.toString(year);
    String HOUR=Integer.toString(hour),MINUTE=Integer.toString(minute),SECOND=Integer.toString(second);
    
    int x,y,sno=1,bno,bill_no;
    double total_amount=0,temp,sale_data,balance_quantity,tot;
    String t="TOTAL",login_;
    public billcreate()
    {
        super("bil create");
        //this.date = new Date();
        setBounds(70, 10, 1350, 700);
        //setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        pj=PrinterJob.getPrinterJob();
        
        
        tb=new JTextField();
        tb.setBounds(50,100,150,30);
        tb.setEnabled(false);
        add(tb);
        
        try
        {
            int temp=0;
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            //con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_data","root","");
            //createBillNo();
            
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");

            st=con.createStatement();
            rset=st.executeQuery("select * from bill_no");
            while(rset.next())
            {
                temp=Integer.parseInt(rset.getString("billno"));
            }
            rset.close();
            st.close();
            if(temp==0)
            {
                ps=con.prepareStatement("insert into bill_no values(?)");
                ps.setString(1, "1");
                ps.executeUpdate();
                tb.setText("1");
                ps.close();
            }
            else
            {
                st=con.createStatement();
                st.executeUpdate("DELETE FROM bill_no WHERE billno="+temp);
                ps=con.prepareStatement("insert into bill_no values(?)");
                ps.setString(1, Integer.toString(temp));
                ps.executeUpdate();
                tb.setText(Integer.toString(temp));
                ps.close();
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        
        pna=new JLabel("patient name");
        pna.setBounds(210, 100, 70, 30);
        add(pna);
        
        pno=new JLabel("patient mobile number");
        pno.setBounds(490, 100, 120, 30);
        add(pno);
        
        gname=new JLabel("generic name");
        gname.setBounds(820, 100, 70, 30);
        add(gname);
        
        billno=new JLabel("bill no");
        billno.setBounds(10, 100, 50, 30);
        add(billno);
        
        
        mname=new JLabel("medicine name");
        mname.setBounds(10, 170, 70, 30);
        add(mname);
        
        batchno=new JLabel("batch no");
        batchno.setBounds(250, 170, 50, 30);
        add(batchno);
        
        qty=new JLabel("quantity");
        qty.setBounds(460, 170, 40, 30);
        add(qty);
        
        exp=new JLabel("expiry date");
        exp.setBounds(670, 170, 70, 30);
        add(exp);
        
        stk=new JLabel("stock");
        stk.setBounds(950, 170, 30, 30);
        add(stk);
        
        rs=new JLabel("amount");
        rs.setBounds(1170, 170, 40, 30);
        add(rs);
        
        tx=new JLabel("tax");
        tx.setBounds(10, 210, 70, 30);
        add(tx);
        
        total=new JLabel(t+" "+total_amount);
        total.setBounds(800,600,400,100);
        total.setFont(new Font("",Font.BOLD,50));
        add(total);
        
        pname=new JTextField();
        pname.setBounds(280, 100, 200, 30);
        add(pname);
        
        pnumber=new JTextField();
        pnumber.setBounds(610, 100, 200, 30);
        add(pnumber);
        
        gn=new JComboBox();
        gn.setBounds(890, 100, 150, 30);
        gn.setEditable(true);
        add(gn);
        
        tba=new JTextField();
        tba.setBounds(300,170,150,30);
        add(tba);
        
        tn=new JComboBox();
        tn.setBounds(90, 170, 150, 30);
        tn.setEditable(true);
        add(tn);
        
        tax=new JTextField();
        tax.setBounds(90, 210, 70, 30);
        add(tax);
        
        gn.addItem("--select--");
        tn.addItem("--select--");
        
        try
        {
        st=con.createStatement();
        rset=st.executeQuery("select * from addmedicine");
        while(rset.next())
        {
            gn.addItem(rset.getString("generic"));
        }
        st.close();
        rset.close();
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        
        
        
        //tn=new JTextField();
        //tn.setBounds(90,170,150,30);
        //add(tn);
        
        tq=new JTextField();
        tq.setBounds(510,170,150,30);
        add(tq);
        
        expdate=new JTextField();
        expdate.setBounds(740, 170, 200, 30);
        add(expdate);
        
        stock=new JTextField();
        stock.setBounds(990, 170, 170, 30);
        add(stock);
        
        tr=new JTextField();
        tr.setBounds(1220,170,120,30);
        add(tr);
        
        
        add=new JButton();
        add.setBounds(10,610,152,44);
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/badd2.png")));
        add(add);
        
        print=new JButton();
        print.setBounds(172,610,152,45);
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/bprint2.png")));
        add(print);
        
        back=new JButton();
        back.setBounds(332,610,155,45);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/back2.png")));
        add(back);
        
        del=new JButton();
        del.setBounds(497,610,155,45);
        del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/del1.png")));
        add(del);
        
        table.setModel(mod);
        mod.addColumn("S.NO");
        mod.addColumn("BILL NO");
        mod.addColumn("BATCH NO");
        mod.addColumn("MEDICINE NAME");
        mod.addColumn("EXP DATE");
        mod.addColumn("QUANTITY");
        mod.addColumn("AMOUNT");
        mod.addColumn("TAX");
        mod.addColumn("TOTAL");
        
        table.setRowHeight(40);
        table.setFont(new Font("",Font.PLAIN,30));
        //table.setEnabled(false);
        sp=new JScrollPane(table);
        sp.setBounds(10, 270, getWidth()-35,330);
        add(sp);
          
        ex=new JLabel();
        ex.setBounds(getWidth()-30, 0, getWidth(), 30);
        ex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wclose.png")));
        add(ex);
        
        min1=new JLabel();
        min1.setBounds(getWidth()-61, 0, 30, 30);
        min1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wmin.png")));
        min1.setForeground(Color.BLACK);
        add(min1);
        
        min=new JPanel();
        min.setBounds(getWidth()-61, 0, 30, 30);
        min.setBackground(Color.WHITE);
        add(min);
        
        exit=new JPanel();
        exit.setBounds(getWidth()-30, 0, getWidth(), 30);
        exit.setBackground(Color.WHITE);
        add(exit);
        
        framen=new JLabel("  Sale");
        framen.setBounds(0, 0, getWidth(), 30);
        framen.setBackground(Color.WHITE);
        add(framen);
        
        ex1=new JPanel();
        ex1.setBounds(0, 0, getWidth(), 30);
        ex1.setBackground(Color.WHITE);
        add(ex1);
        
        title=new JLabel("MEDICINE DATA  ENTRY");
        title.setBounds(0, 30, getWidth(), 70);
        title.setFont(new Font("",Font.BOLD,50));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setForeground(c1);
        add(title);
        
        pa2=new JPanel();
        pa2.setBounds(0, 30, getWidth(), 60);
        pa2.setBackground(c);
        add(pa2);
        
        
        
        pa=new JPanel();
        pa.setBounds(0, 0, getWidth(), getHeight());
        pa.setBackground(Color.WHITE);
        add(pa);
        
        setBounds(70, 10, 1200, 750);
        setBounds(5, 0, 1350, 700);
        
        back.addActionListener(this);
        add.addActionListener(this);
        print.addActionListener(this);
        del.addActionListener(this);
        
        tb.addKeyListener(new java.awt.event.KeyAdapter() {

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
        pname.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                //char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ESCAPE)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new home().setVisible(true);
                    //System.exit(0);
                }
                if(k==KeyEvent.VK_ENTER)
                {
                    pnumber.requestFocus();
                }
            }
        });
        pnumber.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    gn.requestFocus();
                }
            }
        });
        tn.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                tn.setAutoscrolls(true);
                //tn.setText(tn.getSelectedItem().toString().toUpperCase());
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    if(tn.getSelectedItem().equals("--select--"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "please select valuable medicine name");
                    }
                    else
                    {
                        search_();
                        tq.requestFocus();
                    }
                }
            }
        });
        gn.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                gn.setAutoscrolls(true);
                //tn.setText(tn.getSelectedItem().toString().toUpperCase());
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    if(gn.getSelectedItem().equals("--select--"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "don't accept "+gn.getSelectedItem()+" type of generic name please select valuable generic name");
                    }
                    
                    else
                    {
                    //tn=new JComboBox();
                    tn.removeAllItems();
                    tn.addItem("--select--");
                    tn.setSelectedItem("--select--");
                    try
                    {
                        st=con.createStatement();
                        rset=st.executeQuery("select * from addmedicine");
                        while(rset.next())
                        {
                            if(rset.getString("generic").equals(gn.getSelectedItem().toString()))
                            {
                                tn.addItem(rset.getString("name"));
                            }
                        }
                        st.close();
                        rset.close();
                        tn.requestFocus();
                    }
                    catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
                    }
                    
                }
            }
        });
        
        tba.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                tba.setText(tba.getText().toUpperCase());
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    search_();
                    tq.requestFocus();
                }
            }
        });
        tq.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    tr.requestFocus();
                }
            }
        });
        tr.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    tax.requestFocus();
                }
            }
        });
        tax.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    medicineQuantity();
                    if(balance_quantity<Double.parseDouble(tq.getText()))
                    {
                        JOptionPane.showMessageDialog(rootPane, "don't sale this medicine because this medicine quantity "+balance_quantity+" but you are give "+tq.getText()+"no of medicine");
                    }
                    else
                    {
                        addData();
                        tn.requestFocus();
                    }
                }
                else if(k==KeyEvent.VK_SPACE)
                {
                    medicineQuantity();
                    if(balance_quantity<Double.parseDouble(tq.getText()))
                    {
                        JOptionPane.showMessageDialog(rootPane, "don't sale this medicine because this medicine quantity "+balance_quantity+" but you are give "+tq.getText()+"no of medicine");
                    }
                    else
                    {
                        addData();
                        addToDataBase();
                        receipt();
                        for(int i=table.getRowCount()-1;i>=0;i--)
                        {
                            mod.removeRow(i);
                        }
                        total_amount=0;
                        total.setText(t+" "+Double.toString(total_amount));
                        createBillNo();
                        pname.setText("");
                        pnumber.setText("");
                       sno=1;
                        tn.requestFocus();
                        tba.setText("");
                        //tn.setText("");
                        tq.setText("");
                        tr.setText("");
                        expdate.setText("");
                        stock.setText("");
                    }
                }
            }
        });
        tb.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    tba.requestFocus();
                }
            }
        });
        add.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                addent(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                addexit(me);
            }
            
        });
        print.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                printent(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                printexit(me);
            }
            
        });
        back.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                backent(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                backexit(me);
            }
            
        });
        del.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/del2.png")));
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/del1.png")));
            }
        });
        ex.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                exent(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                exexit(me);
            }
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                exclick(me);
            }
            
        });
        min1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                minent(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                minexit(me);
            }
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                minclick(me);
            }
            
        });
        ex1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent me)
            {
                x=me.getX();
                y=me.getY();
            }
            
            
        });
        ex1.addMouseMotionListener(new java.awt.event.MouseAdapter() {
            
            public void mouseDragged(java.awt.event.MouseEvent me)
            {
                int xm=me.getXOnScreen();
                int ym=me.getYOnScreen();
                setLocation(xm-x, ym-y);
            }
            
        });
        tq.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(!(Character.isDigit(k)))
                {
                    ke.consume();
                }
            }
        });
        tr.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(!(Character.isDigit(k)))
                {
                    //ke.consume();
                }
            }
        });
        print.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_SPACE)
                {
                    tn.requestFocus();
                }
            }
        });
        
        
        
        AutoCompleteDecorator.decorate(tn);
        AutoCompleteDecorator.decorate(gn);
        
    }
    public void addent(java.awt.event.MouseEvent me)
    {
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/badd.png")));
        
    }
    public void addexit(java.awt.event.MouseEvent me)
    {
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/badd2.png")));
        
    }
    public void printent(java.awt.event.MouseEvent me)
    {
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/bprint.png")));
        
    }
    public void printexit(java.awt.event.MouseEvent me)
    {
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/bprint2.png")));
        
    }
    public void backent(java.awt.event.MouseEvent me)
    {
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/back1.png")));
        
    }
    public void backexit(java.awt.event.MouseEvent me)
    {
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/back2.png")));
        
    }
    public void exent(java.awt.event.MouseEvent me)
    {
        exit.setBackground(Color.red);
        ex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wclose.png")));
        //setBounds(getX(), getY(), 1350, 701);
        repaint();
        
    }
    public void exexit(java.awt.event.MouseEvent me)
    {
        exit.setBackground(ex1.getBackground());
        ex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wclose.png")));
        //setBounds(getX(), getY(), 1350, 700);
        repaint();        
    }
    public void exclick(java.awt.event.MouseEvent me)
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
    public void minent(java.awt.event.MouseEvent me)
    {
        min.setBackground(Color.LIGHT_GRAY);        
        min1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wmin.png")));
        //setBounds(getX(), getY(), 1350, 701);
        repaint();
    }
    public void minexit(java.awt.event.MouseEvent me)
    {
        min.setBackground(Color.WHITE);
        min1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/wmin.png")));
        //setBounds(getX(), getY(),1350, 700);
        repaint();
        
    }
    public void minclick(java.awt.event.MouseEvent me)
    {
        setState(1);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
            setVisible(false);
            new home().setVisible(true);
        }
        else if(ae.getSource()==add)
        {
            medicineQuantity();
            if(balance_quantity<Double.parseDouble(tq.getText()))
            {
                 JOptionPane.showMessageDialog(rootPane, "don't sale this medicine because this medicine quantity "+balance_quantity+" but you are give "+tq.getText()+"no of medicine");
            }
            else
            {
                addData();
                tn.requestFocus();
            }        
        }
        else if(ae.getSource()==print)
        {
            addToDataBase();
            receipt();
            for(int i=table.getRowCount()-1;i>=0;i--)
            {
                mod.removeRow(i);
            }
            total_amount=0;
            total.setText(t+" "+Double.toString(total_amount));
            createBillNo();
            pname.setText("");
            pnumber.setText("");
            tba.setText("");
            //tn.setText("");
            tq.setText("");
            tr.setText("");
            expdate.setText("");
            stock.setText("");
            sno=1;
        }
        else if(ae.getSource()==del)
        {
            
            if(table.getRowCount()==0)
            {
                
            }
            else
            {
                int temp_row_id=1;
                mod.removeRow(table.getSelectedRow());
            
                for(int row=0;row<=table.getRowCount()-1;row++)
                {
                    table.getModel().setValueAt(temp_row_id, row, 0);
                    temp_row_id++;
                }
                 sno-=1;
            }  
        }
    }
    public void createBillNo()
    {
        int temp=0;
            try
            {
            st=con.createStatement();
            rset=st.executeQuery("select * from bill_no");
            while(rset.next())
            {
                temp=Integer.parseInt(rset.getString("billno"));
            }
            if(temp==0)
            {
                ps=con.prepareStatement("insert into bill_no values(?)");
                ps.setString(1, "1");
                ps.executeUpdate();
                tb.setText("1");
                ps.close();
            }
            else
            {
                ps=con.prepareStatement("DELETE FROM bill_no WHERE billno="+temp);
                ps.close();
                ps=con.prepareStatement("insert into bill_no values(?)");
                ps.setString(1, Integer.toString(temp+=1));
                ps.executeUpdate();
                tb.setText(Integer.toString(temp));
                ps.close();
            }
            }
            catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
    }
    public void medicineQuantity()
    {
        try{
                //----quantity data get from medicine_data
                ps=con.prepareStatement("select * from addmedicine where batchno=?");
                //rset=st.executeQuery("select * from sales_data");
                ps.setString(1, tba.getText());
                rset=ps.executeQuery();
                    if(rset.next())
                    {
                        balance_quantity=Double.parseDouble(rset.getString("quantity"));
                    }
                    rset.close();
                    ps.close();
           }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
    }
    public void addData()
    {
        try
        {
        getData();
            double qua=Double.parseDouble(tq.getText());
            double amt=Double.parseDouble(tr.getText());
            double total_sales_tax=amt*Double.parseDouble(tax.getText());
            tot=qua*amt;
            tot+=total_sales_tax;
            
            String[] data={Integer.toString(sno),tb.getText().toString(),tba.getText().toString(),tn.getSelectedItem().toString()
            ,expdate.getText(),tq.getText().toString(),tr.getText().toString(),tax.getText().toString(),Double.toString(tot)};
            mod.addRow(data);
            //bno=Integer.parseInt(tb.getText());
            total_amount+=tot;
            total.setText(t+" "+Double.toString(total_amount));
            
            
            
            
            //tb.setText("");
            //tb.setText(Integer.toString(bno+=1));
            tba.setText("");
            //tn.setText("");
            tq.setText("");
            tr.setText("");
            expdate.setText("");
            stock.setText("");
            sno+=1;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage()+" amount or tax not accept as letters");
        }
            //---------------------------------------//
    }
    public void addToDataBase()
    {
        //database work
            //----------------------------------------//
            try
            {
                for(int row=0;row<=table.getRowCount()-1;row++)
                {
                try{
                //----quantity data get from medicine_data
                ps=con.prepareStatement("select * from addmedicine where batchno=?");
                //rset=st.executeQuery("select * from sales_data");
                ps.setString(1, table.getModel().getValueAt(row, 2).toString());
                rset=ps.executeQuery();
                    if(rset.next())
                    {
                        sale_data=Double.parseDouble(rset.getString("quantity"));
                        //temp=sale_data;
                        temp=sale_data-Double.parseDouble(table.getModel().getValueAt(row, 5).toString());
                        //JOptionPane.showMessageDialog(rootPane, "get data's"+" "+temp);
                
                        String query="UPDATE addmedicine SET quantity='"+temp+"'WHERE  batchno='"+table.getModel().getValueAt(row, 2).toString()+"'";
               
                        PreparedStatement ps=con.prepareStatement(query);
                //ps.setString(1, tfn.getText());
                    ps.execute();
                    ps.close();
                        
                    }
                    rset.close();
                    ps.close();
                    
                
                //JOptionPane.showMessageDialog(rootPane, "data matched");
                //total.setText(t+" "+Double.toString(sale_data));
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" "+temp);}
                //---------update medicine_data
                
                
                }        
                //------------------------------
                    
                    
          for(int row=0;row<=table.getRowCount()-1;row++)
          {
                    getData();
                    date=new Date();
                    cal=new GregorianCalendar();
                    hour=cal.get(Calendar.HOUR);
                    minute=cal.get(Calendar.MINUTE);
                    second=cal.get(Calendar.SECOND);
                    
                    day=cal.get(Calendar.DAY_OF_MONTH);
                    month=cal.get(Calendar.MONTH)+1;
                    year=cal.get(Calendar.YEAR);
                        
                    SimpleDateFormat s=new SimpleDateFormat("dd/MM/YYYY");
                ps=con.prepareStatement("insert into sales_data values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                //st.setString(1, Integer.toString(count));
                ps.setString(1, table.getModel().getValueAt(row, 0).toString());
                ps.setString(2, table.getModel().getValueAt(row, 1).toString());
                ps.setString(3, table.getModel().getValueAt(row, 2).toString());
                ps.setString(4, table.getModel().getValueAt(row, 3).toString());
                ps.setString(5, table.getModel().getValueAt(row, 5).toString());
                ps.setString(6, table.getModel().getValueAt(row, 6).toString());
                ps.setString(7, login_);
                ps.setString(8, table.getModel().getValueAt(row, 8).toString());
                ps.setString(9, Integer.toString(day)+"-"+Integer.toString(month)+"-"+Integer.toString(year));
                ps.setString(10, Integer.toString(hour)+":"+Integer.toString(minute)+":"+Integer.toString(second));
                ps.setString(11, table.getModel().getValueAt(row, 7).toString());
                ps.setString(12, pname.getText());
                ps.setString(13,pnumber.getText());
                ps.executeUpdate();
                ps.close();
                //JOptionPane.showMessageDialog(rootPane, "database added");
            }
            }
            catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
    }
    public void search_()
        {
            if(tn.getSelectedItem().toString().isEmpty()==false)
            {
            try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addmedicine where name=?");
                    ps.setString(1, tn.getSelectedItem().toString());
                    rset=ps.executeQuery();
               
                    if(rset.next())
                    {
                        tba.setText(rset.getString("batchno"));
                        tn.setSelectedItem(rset.getString("name"));
                        expdate.setText(rset.getString("expdate"));
                        stock.setText(rset.getString("quantity"));
                        tr.setText(rset.getString("saleprice"));
                        tax.setText(rset.getString("tax"));
                        rset.close();
                        ps.close();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "does not match given medicine name");
                    }
                    
                }
                catch(Exception e)
                {
                    
                }
        }
        else if(tba.getText().isEmpty()==false)
        {
            try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addmedicine where batchno=?");
                    ps.setString(1, tba.getText().toString());
                    rset=ps.executeQuery();
               
                    if(rset.next())
                    {
                        tba.setText(rset.getString("batchno"));
                        tn.setSelectedItem(rset.getString("name"));
                        expdate.setText(rset.getString("expdate"));
                        stock.setText(rset.getString("quantity"));
                        tr.setText(rset.getString("saleprice"));
                        rset.close();
                        ps.close();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "does not match given medicine name");
                        ps.close();
                    }
                    
                }
                catch(Exception e)
                {
                    
                }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "you can search by medicine name and medicine batch number please give any one data");
        }
        }
    public String getData()
    {
        try
            {
                    Statement ps;
                    ps=con.createStatement();
                    rset=ps.executeQuery("select * from user_login");
            while(rset.next())
            {
                login_=rset.getString("name");
                rset.close();
                ps.close();
            }
            }
            catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        return login_;
    }

    
    public PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double middleHeight =8.0;  
    double headerHeight = 2.0;                  
    double footerHeight = 2.0;                  
    double width = convert_CM_To_PPI(15);      //printer know only point per inch.default value is 72ppi
    //double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
    double height = convert_CM_To_PPI(table.getModel().getRowCount()+20); 
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        10,
        width,            
        height - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points
            
    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}
    
    protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;       
}
    
    
    public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
                
        
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            ////////// code by alqama//////////////

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

        //    int idPosition=0;
        //    int productPosition=idPosition + idLength + 2;
        //    int pricePosition=productPosition + prodLength +10;
        //    int qtyPosition=pricePosition + priceLength + 2;
        //    int amtPosition=qtyPosition + qtyLength + 2;
            
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
            
              
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
            int headerRectHeighta=40;
            
            ///////////////// Product names Get ///////////
                //String  pn1a=pn1.getText();
                //String pn2a=pn2.getText();
                //String pn3a=pn3.getText();
                //String pn4a=pn4.getText();
            ///////////////// Product names Get ///////////
                
            
            ///////////////// Product price Get ///////////
                //int pp1a=Integer.valueOf(pp1.getText());
                //int pp2a=Integer.valueOf(pp2.getText());
                //int pp3a=Integer.valueOf(pp3.getText());
                //int pp4a=Integer.valueOf(pp4.getText());
                //int sum=pp1a+pp2a+pp3a+pp4a;
            ///////////////// Product price Get ///////////
                
             g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
             g2d.setColor(Color.RED);
             
            
            g2d.drawString("Bill No:"+tb.getText(), 12, y);y+=yShift;
            g2d.drawString("cashier name: "+login_, 12, y);y+=yShift;
            g2d.drawString("------------------------------------------------",12,y);y+=yShift;
            g2d.drawString("                 Medical Bill Receipt           ",12,y);y+=yShift;
            g2d.drawString("------------------------------------------------",12,y);y+=headerRectHeight;
            g2d.drawString("Patient Name:"+pname.getText(), 12, y);
            g2d.drawString("Date:"+DATE+"/"+MONTH+"/"+YEAR, 190, y);y+=yShift;
            g2d.drawString("Mobile No:"+pnumber.getText(), 12, y);
            g2d.drawString("Time:"+HOUR+":"+MINUTE+":"+SECOND, 190, y);y+=yShift;
            g2d.drawString("------------------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Medicine Name       Exp     Qty   TAX    Amount",10,y);y+=yShift;
            g2d.drawString("------------------------------------------------",10,y);y+=headerRectHeight;
            
            for(int row=0;row<=table.getRowCount()-1;row++)
            {
            /*g2d.drawString(" "+table.getModel().getValueAt(row, 3)+"            "+
                    table.getModel().getValueAt(row, 4)+"   "+"   "+table.getModel().getValueAt(row,5)+"   "+table.getModel().getValueAt(row, 6),10,y);*/
            
            g2d.drawString(" "+table.getModel().getValueAt(row,3),10,y);
            g2d.drawString(" "+table.getModel().getValueAt(row, 4),100,y);
            g2d.drawString(" "+table.getModel().getValueAt(row, 5),165,y);
            g2d.drawString(" "+table.getModel().getValueAt(row, 7),200,y);
            g2d.drawString(" "+table.getModel().getValueAt(row, 6),240,y);
            y+=yShift;
            }
            g2d.drawString("------------------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total Amount:"+total.getText(),10,y);y+=yShift;
            g2d.drawString("------------------------------------------------",10,y);y+=yShift;
            g2d.drawString("               Free Home Delivery         ",10,y);y+=yShift;
            g2d.drawString("                  03111111111             ",10,y);y+=yShift;
            g2d.drawString("************************************************",10,y);y+=yShift;
            g2d.drawString("           THANK YOU...!VISIT AGAIN...!  ",10,y);y+=yShift;
            g2d.drawString("************************************************",10,y);y+=yShift;
                   
           
             
           
            
//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
          

    }
    catch(Exception r){
    r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
    
   public void receipt()
   {                                         

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        try {
            //pj.setJobName();
            
            pj.print();

        }
        catch (PrinterException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
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
            java.util.logging.Logger.getLogger(billcreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billcreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billcreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billcreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new billcreate().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}

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
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class medlist extends JFrame implements ActionListener
{
    File file;
    JFileChooser filechooser;
    
    JPanel pa,close,min,head;
    JLabel closel,minl,headl;
    JButton back,importxl,ixl,lowstock,all;
    JTable list;
    JTextField search_data;
    DefaultTableModel model=new DefaultTableModel();
    JScrollPane sp;
    Connection con;
    Statement st;
    ResultSet rs;
    
    int x,y;
    public medlist()
    {
        super("medicine list");
        setBounds(10, 10, 1350, 720);
        setLayout(null);
        //setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        
        
        list=new JTable();
        list.setModel(model);
        list.setBounds(0, 70, getWidth()+100, getHeight()-160);
        
        model.addColumn("S.NO");
        model.addColumn("BATCH NO");
        model.addColumn("MEDICINE NAME");
        model.addColumn("QUANTITY");
        model.addColumn("PURCHASE DATE");
        model.addColumn("EXP DATE");
        model.addColumn("PURCHASE PRICE");
        model.addColumn("SALE PRICE");
        model.addColumn("TAX");
        model.addColumn("RACK NO");
        model.addColumn("SUPPLIER NAME");
        model.addColumn("MEDICINE COMPANY");
        model.addColumn("MEDICINE TYPE");
        model.addColumn("GENERIC NAME");
        
        //list.setEditingRow(0);
        //list.setBounds(0, 70, getWidth()+20, getHeight()-160);
        //add(list);
        
        sp=new JScrollPane(list);
        sp.setBounds(0, 70, getWidth(), getHeight()-160);
        add(sp);
       

        list.setRowHeight(40);
        list.setFont(new Font("",Font.PLAIN,20));
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
            
            
            //st=con.prepareStatement("select * from addmedicine where name=?");
            st=con.createStatement();
            //rs=st.executeQuery("select * from addmedicine where id=?");
            //st.setString(1, "p500");
            //rs=st.executeQuery();
            rs=st.executeQuery("select * from addmedicine");
            int count=1;
            while(rs.next())
            {
                
               String[] medicinedata={Integer.toString(count),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("purchasedate"),rs.getString("expdate"),rs.getString("purchaseprice"),rs.getString("saleprice"),rs.getString("tax"),rs.getString("rackno"),rs.getString("suppliername"),rs.getString("medicinecompany"),rs.getString("medicinetype"),rs.getString("generic")}; 
                model.addRow(medicinedata);
                count++;
            }
            rs.close();
            st.close();
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}

        search_data=new JTextField();
        search_data.setBounds(5, 35, 150, 30);
        add(search_data);
        
        all=new JButton("all");
        all.setBounds(740, 661, 60, 30);
        add(all);
        
        lowstock=new JButton("show low stock");
        lowstock.setBounds(810, 661, 120, 30);
        add(lowstock);
        
        importxl=new JButton("export to excel sheet");
        importxl.setBounds(1150, 661, 200, 30);
        importxl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/xl.png")));
        add(importxl);
        
        ixl=new JButton("import from excel sheet");
        ixl.setBounds(940, 661, 200, 30);
        ixl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/xl.png")));
        add(ixl);
        
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
        
        headl=new JLabel("  Medicine List");
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
        importxl.addActionListener(this);
        ixl.addActionListener(this);
        lowstock.addActionListener(this);
        all.addActionListener(this);
        
        
        search_data.addKeyListener(new java.awt.event.KeyAdapter() {

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
                
                TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
                list.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search_data.getText().toUpperCase()));
            }
        });
        
        list.addKeyListener(new java.awt.event.KeyAdapter() {

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
            try
            {
                for(int i=list.getRowCount()-1;i>=0;i--)
                {
                    model.removeRow(i);
                }
                
                rs=st.executeQuery("select * from addmedicine");
                int count=1;
                while(rs.next())
                {
                    String[] medicinedata={Integer.toString(count),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("purchasedate"),rs.getString("expdate"),rs.getString("purchaseprice"),rs.getString("saleprice"),rs.getString("tax"),rs.getString("rackno"),rs.getString("suppliername"),rs.getString("medicinecompany"),rs.getString("medicinetype"),rs.getString("generic")}; 
                    model.addRow(medicinedata);
                    count++;
                }
            rs.close();
            st.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
        }
        else if(ae.getSource()==lowstock)
        {
            try
            {
                for(int i=list.getRowCount()-1;i>=0;i--)
                {
                    model.removeRow(i);
                }
                
                rs=st.executeQuery("select * from addmedicine");
                int count=1;
                while(rs.next())
                {
                    if(Double.parseDouble(rs.getString("quantity"))<=30)
                    {
                    String[] medicinedata={Integer.toString(count),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("purchasedate"),rs.getString("expdate"),rs.getString("purchaseprice"),rs.getString("saleprice"),rs.getString("tax"),rs.getString("rackno"),rs.getString("suppliername"),rs.getString("medicinecompany"),rs.getString("medicinetype"),rs.getString("generic")}; 
                    model.addRow(medicinedata);
                    count++;
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
        else if(ae.getSource()==importxl)
        {
            if(list.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(rootPane, "don't export empty table data");
            }
            else
            {
                exportTOExcelSheet();
            }
        }
        else if(ae.getSource()==ixl)
        {
            for(int i=model.getRowCount()-1;i>=0;i--)
            {
                model.removeRow(i);
            }
            importfromExcelSheet();
            exportToDataBase();
            try
            {
                        for(int i=model.getRowCount()-1;i>=0;i--)
                        {
                            model.removeRow(i);
                        }
                rs=st.executeQuery("select * from addmedicine");
                int count=1;
                while(rs.next())
                {
                
                    String[] medicinedata={Integer.toString(count),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("purchasedate"),rs.getString("expdate"),rs.getString("purchaseprice"),rs.getString("saleprice"),rs.getString("tax"),rs.getString("rackno"),rs.getString("suppliername"),rs.getString("medicinecompany"),rs.getString("medicinetype"),rs.getString("generic")}; 
                    model.addRow(medicinedata);
                    count++;
                }
                //JOptionPane.showMessageDialog(rootPane, "success");
                rs.close();
                st.close();
                       
            }
            catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        }
    }
    
    public void exportToDataBase()
    {
        int temp_id=0;
        String available="no";
        int totalrow=model.getRowCount()-1;
        for(int row=0;row<=totalrow;row++)
        {
                try
                {
                    //tfb,tfn,tfq,tfm,tfe,tfpp,tfsp,tfr,tfsname,tfc;
                    Statement st;
                st=con.createStatement();
                rs=st.executeQuery("select * from addmedicine");
                while(rs.next())
                {
                    temp_id=Integer.parseInt(rs.getString("sno"));
                }
                if(temp_id==0)
                {
                    st=con.createStatement();
                    rs=st.executeQuery("select * from addmedicine");
                    while(rs.next())
                    {
                        if(rs.getString("batchno").equals(list.getModel().getValueAt(row, 1).toString()))
                        {
                           available="yes";
                           rs.close();
                        }
                        else
                        {
                            available="no";
                        }
                    }
                    if(available.equals("yes"))
                    {
                        
                    }
                    else
                    {
                    PreparedStatement ps=con.prepareStatement("insert into addmedicine values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    //st.setString(1, Integer.toString(count));
                    ps.setString(1, "1");
                    ps.setString(2, list.getModel().getValueAt(row, 1).toString());
                    ps.setString(3, list.getModel().getValueAt(row, 2).toString());
                    ps.setString(4, list.getModel().getValueAt(row, 3).toString());
                    ps.setString(5, list.getModel().getValueAt(row, 4).toString());
                    ps.setString(6, list.getModel().getValueAt(row, 5).toString());
                    ps.setString(7, list.getModel().getValueAt(row, 6).toString());
                    ps.setString(8, list.getModel().getValueAt(row, 7).toString());
                    ps.setString(9, list.getModel().getValueAt(row, 9).toString());
                    ps.setString(10, list.getModel().getValueAt(row, 10).toString());
                    ps.setString(11, list.getModel().getValueAt(row, 11).toString());
                    ps.setString(12, list.getModel().getValueAt(row, 12).toString());
                    ps.setString(13, list.getModel().getValueAt(row, 8).toString());
                    ps.setString(14, list.getModel().getValueAt(row, 13).toString());
                    ps.executeUpdate();
                    ps.close();
                    }
                        //JOptionPane.showMessageDialog(rootPane, "data was successfully added");
                }
                else
                {
                    st=con.createStatement();
                    rs=st.executeQuery("select * from addmedicine");
                    while(rs.next())
                    {
                        if(rs.getString("batchno").equals(list.getModel().getValueAt(row, 1).toString()))
                        {
                           available="yes";
                           rs.close();
                        }
                        else
                        {
                            available="no";
                        }
                    }
                    if(available.equals("yes"))
                    {
                        
                    }
                    else
                    {
                    PreparedStatement ps=con.prepareStatement("insert into addmedicine values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    //st.setString(1, Integer.toString(count));
                    ps.setString(1, Integer.toString(temp_id+1));
                    ps.setString(2, list.getModel().getValueAt(row, 1).toString());
                    ps.setString(3, list.getModel().getValueAt(row, 2).toString());
                    ps.setString(4, list.getModel().getValueAt(row, 3).toString());
                    ps.setString(5, list.getModel().getValueAt(row, 4).toString());
                    ps.setString(6, list.getModel().getValueAt(row, 5).toString());
                    ps.setString(7, list.getModel().getValueAt(row, 6).toString());
                    ps.setString(8, list.getModel().getValueAt(row, 7).toString());
                    ps.setString(9, list.getModel().getValueAt(row, 9).toString());
                    ps.setString(10, list.getModel().getValueAt(row, 10).toString());
                    ps.setString(11, list.getModel().getValueAt(row, 11).toString());
                    ps.setString(12, list.getModel().getValueAt(row, 12).toString());
                    ps.setString(13, list.getModel().getValueAt(row, 8).toString());
                    ps.setString(14, list.getModel().getValueAt(row, 13).toString());
                    ps.executeUpdate();
                    ps.close();
                    }
                }
                    
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "data added error..");
                }
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
                    jxl.write.Label label=new jxl.write.Label(column,row,data);
                    mysheet.addCell(label);
                }
            }
                myexcel.write(); 
                myexcel.close();
            JOptionPane.showMessageDialog(rootPane, "file successfully exported to "+file);
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e);}
        }
    }
    public void importfromExcelSheet()
    {
        filechooser=new JFileChooser();
        int opt=filechooser.showOpenDialog(filechooser);
        if(opt==JFileChooser.CANCEL_OPTION)
        {
            
        }
        else
        {
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
            JOptionPane.showMessageDialog(rootPane, "file successfully imported from "+file);
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
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
            java.util.logging.Logger.getLogger(medlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(medlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(medlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(medlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new medlist().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}

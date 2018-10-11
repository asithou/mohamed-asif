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
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class addmedicine extends JFrame implements ActionListener
{
    JFrame f;
    JPanel pa1,pa2,head,close,min;
    JTextField tfb,tfn,tfq,tfm,tfe,tfpp,tfsp,tfr,tfsname,tfc,tft,tfgn;
    JLabel l1,title,batchno,name,quantity,mfg,exp,pprice,sprice,rno,sname,com,mtype,headl,closel,minl,tx,gen;
    JComboBox cmtype;
    JButton ok,preview,back;
    JTable list;
    DefaultTableModel model;
    JScrollPane sp;
    Color c=new Color(82,188,114);
    String[] ctnt={"--select--","Tablet","Tonic","oilment","Injection","Needle","Cluqoas Bottle","Others..."};
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    
    int x,y,count=1;
    @SuppressWarnings("unchecked")
    public addmedicine()
    {
        super("add medicine");
        setBounds(200,10,900,700);
        setLayout(null);
        //setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
            
        }
        catch(Exception e){}

        
        title=new JLabel("NEW MEDICINE");
        title.setBounds(300, 20, 400, 90);
        title.setFont(new Font("TimesRoman",Font.BOLD,40));
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medicine.png")));
        add(title);
        
        batchno=new JLabel("batch no");
        batchno.setBounds(100, 120, 50, 30);
        add(batchno);
        
        name=new JLabel("name");
        name.setBounds(100, 190, 50, 30);
        add(name);
        
        quantity=new JLabel("quantity");
        quantity.setBounds(100, 260, 50, 30);
        add(quantity);
        
        mfg=new JLabel("purchase date");
        mfg.setBounds(100, 330, 100, 30);
        add(mfg);
        
        exp=new JLabel("exp date");
        exp.setBounds(100, 400, 50, 30);
        add(exp);
        
        pprice=new JLabel("purchase price");
        pprice.setBounds(100, 470, 100, 30);
        add(pprice);
        
        sprice=new JLabel("sale price");
        sprice.setBounds(400, 120, 100, 30);
        add(sprice);
        
        rno=new JLabel("rack no");
        rno.setBounds(400, 190, 100, 30);
        add(rno);
        
        rno=new JLabel("supplier name");
        rno.setBounds(400, 260, 100, 30);
        add(rno);
        
        com=new JLabel("medicine company");
        com.setBounds(400, 330, 120, 30);
        add(com);
        
        mtype=new JLabel("medicine type");
        mtype.setBounds(400, 400, 120, 30);
        add(mtype);
        
        tx=new JLabel("tax");
        tx.setBounds(400, 470, 120, 30);
        add(tx);
        
        gen=new JLabel("generic name");
        gen.setBounds(100, 540, 100, 30);
        add(gen);
        tfgn=new JTextField();
        tfgn.setBounds(190, 540, 200, 30);
        add(tfgn);
        
        tfb=new JTextField();
        tfb.setBounds(190, 120, 200, 30);
        add(tfb);
        
        tfn=new JTextField();
        tfn.setBounds(190, 190, 200, 30);
        add(tfn);
        
        tfq=new JTextField();
        tfq.setBounds(190, 260, 200, 30);
        add(tfq);
        
        tfm=new JTextField();
        tfm.setBounds(190, 330, 200, 30);
        add(tfm);
        
        tfe=new JTextField();
        tfe.setBounds(190, 400, 200, 30);
        add(tfe);
        
        tfpp=new JTextField();
        tfpp.setBounds(190, 470, 200, 30);
        add(tfpp);
        
        tfsp=new JTextField();
        tfsp.setBounds(510, 120, 200, 30);
        add(tfsp);
        
        tfr=new JTextField();
        tfr.setBounds(510, 190, 200, 30);
        add(tfr);
        
        tfsname=new JTextField();
        tfsname.setBounds(510, 260, 200, 30);
        add(tfsname);
        
        tfc=new JTextField();
        tfc.setBounds(510, 330, 200, 30);
        add(tfc);
        
        cmtype=new JComboBox();
        cmtype.setBounds(510, 400, 200, 30);
        cmtype.setEditable(true);
        cmtype.getAccessibleContext();
        
        add(cmtype);
        for(int i=0;i<ctnt.length;i++)
        {
            cmtype.addItem(ctnt[i]);
        }
        
        tft=new JTextField();
        tft.setBounds(510, 470, 200, 30);
        add(tft);
        
        
        
        ok=new JButton();
        ok.setBounds(460,540,158,52);
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/add.png")));
        add(ok);
        
        preview=new JButton();
        preview.setBounds(629,540,158,50);
        preview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/preview.png")));
        add(preview);
        
        back=new JButton();
        back.setBounds(390,530,58,68);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/goback.png")));
        add(back);
        
        l1=new JLabel();
        l1.setBounds(90, 100, 714, 513);
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/entrypanel.png")));
        add(l1);
        
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
        
        headl=new JLabel("  New Medicine");
        headl.setBounds(0, 0, getWidth(), 30);
        headl.setBackground(Color.WHITE);
        add(headl);
        
        head=new JPanel();
        head.setBounds(0, 0, getWidth(), 30);
        head.setBackground(Color.WHITE);
        add(head);
        
        pa1=new JPanel();
        pa1.setBounds(0, 0, getWidth(), 200);
        pa1.setBackground(c);
        add(pa1);
        
        pa2=new JPanel();
        pa2.setBounds(0, 101, getWidth(), 600);
        pa2.setBackground(Color.DARK_GRAY);
        //add(pa2);
        
        back.addActionListener(this);
        ok.addActionListener(this);
        preview.addActionListener(this);
        
        setBounds(200,10,900,770);
        setBounds(200,10,900,700);

        tfb.addKeyListener(new java.awt.event.KeyAdapter() {

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
                tfb.setText(tfb.getText().toUpperCase());
            }
            
        });
        tfn.addKeyListener(new java.awt.event.KeyAdapter() {
        
            
            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                tfn.setText(tfn.getText().toUpperCase());
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            
            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                //bs(ke);
            }
       });
        
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                okclick(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                okrelease(me);
            }
        });
        preview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                previewclick(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                previewrelease(me);
            }
        });
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                backclick(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                backrelease(me);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent we)
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
        
        AutoCompleteDecorator.decorate(cmtype);
        
        setBounds(200,10,900,770);
        setBounds(200,10,900,700);
        
        preview.setEnabled(false);
    }
    
    
    /*public void bs(java.awt.event.KeyEvent ke)
    {
        char k=ke.getKeyChar();
        if(k==KeyEvent.VK_BACK_SPACE)
        {
            setVisible(false);
            new home().setVisible(true);
        }
    }*/
    
    public void okclick(java.awt.event.MouseEvent me)
    {
        ok.setBounds(460,530,159,50);
        
    }
    public void okrelease(java.awt.event.MouseEvent me)
    {
        ok.setBounds(460,540,159,50);
        
    }
    public void previewclick(java.awt.event.MouseEvent me)
    {
        preview.setBounds(629,530,159,50);
        
    }
    public void previewrelease(java.awt.event.MouseEvent me)
    {
        preview.setBounds(629,540,159,50);
        
    }
    public void backclick(java.awt.event.MouseEvent me)
    {
        back.setBounds(390,520,71,68);
        
    }
    public void backrelease(java.awt.event.MouseEvent me)
    {
        back.setBounds(390,530,71,68);
        
    }
    
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==ok)
            {
                if(tfb.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                }
                else if(tfn.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill name");
                }
                else if(tfq.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill quantity");
                }
                else if(tfm.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill purchase date");
                }
                else if(tfe.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill expiry date");
                }
                else if(tfpp.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill purchase price");
                }
                else if(tfsp.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill sale price");
                }
                else if(tfr.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill rack number");
                }
                else if(tfc.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill compnay name");
                }
                else if(tfsname.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill supplier name");
                }
                else if(cmtype.getSelectedItem().equals("--select--"))
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please select type of medicine");
                }
                else if(tft.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill tax");
                }
                else if(tfgn.getText().isEmpty()==true)
                {
                    //JOptionPane.showMessageDialog(rootPane, "please fill batch number");
                    JOptionPane.showMessageDialog(rootPane, "please fill generic name");
                }
                
                else
                {
                    
                    int temp_id=0;
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
                    ps=con.prepareStatement("insert into addmedicine values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    //st.setString(1, Integer.toString(count));
                    ps.setString(1, "1");
                    ps.setString(2, tfb.getText());
                    ps.setString(3, tfn.getText());
                    ps.setString(4, tfq.getText());
                    ps.setString(5, tfm.getText());
                    ps.setString(6, tfe.getText());
                    ps.setString(7, tfpp.getText());
                    ps.setString(8, tfsp.getText());
                    ps.setString(9, tfr.getText());
                    ps.setString(10, tfsname.getText());
                    ps.setString(11, tfc.getText());
                    ps.setString(12, cmtype.getSelectedItem().toString());
                    ps.setString(13, tft.getText());
                    ps.setString(14, tfgn.getText());
                    ps.executeUpdate();
                    count++;
                        tfb.setText("");
                        tfn.setText("");
                        tfq.setText("");
                        tfm.setText("");
                        tfe.setText("");
                        tfpp.setText("");
                        tfsp.setText("");
                        tfr.setText("");
                        tfsname.setText("");
                        tfc.setText("");
                        cmtype.setSelectedItem("--select--");
                        tft.setText("");
                        tfgn.setText("");
                        JOptionPane.showMessageDialog(rootPane, "data was successfully added");
                        preview.setEnabled(true);
                        ps.close();
                }
                else
                {
                    ps=con.prepareStatement("insert into addmedicine values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    //st.setString(1, Integer.toString(count));
                    ps.setString(1, Integer.toString(temp_id+1));
                    ps.setString(2, tfb.getText());
                    ps.setString(3, tfn.getText());
                    ps.setString(4, tfq.getText());
                    ps.setString(5, tfm.getText());
                    ps.setString(6, tfe.getText());
                    ps.setString(7, tfpp.getText());
                    ps.setString(8, tfsp.getText());
                    ps.setString(9, tfr.getText());
                    ps.setString(10, tfsname.getText());
                    ps.setString(11, tfc.getText());
                    ps.setString(12, cmtype.getSelectedItem().toString());
                    ps.setString(13, tft.getText());
                    ps.setString(14, tfgn.getText());
                    ps.executeUpdate();
                    count++;
                        tfb.setText("");
                        tfn.setText("");
                        tfq.setText("");
                        tfm.setText("");
                        tfe.setText("");
                        tfpp.setText("");
                        tfsp.setText("");
                        tfr.setText("");
                        tfsname.setText("");
                        tfc.setText("");
                        cmtype.setSelectedItem("--select--");
                        tft.setText("");
                        tfgn.setText("");
                        JOptionPane.showMessageDialog(rootPane, "data was successfully added");
                        preview.setEnabled(true);
                        ps.close();
                }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "data added error..");
                }
                }
                
                
            }
            else if(ae.getSource()==preview)
            {
                preview();
            }
            else if(ae.getSource()==back)
            {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                setVisible(false);
                new home().setVisible(true);
            }
        }
        public void preview()
        {
            
        f=new JFrame("preview");
        f.setBounds(0, 0, 1400, 800);
        f.setLayout(null);
        f.setVisible(true);
        
        
        list=new JTable();
        model=new DefaultTableModel();
        list.setModel(model);
        model.addColumn("ID");
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
        
        sp=new JScrollPane(list);
        sp.setBounds(0, 0, f.getWidth()-30, f.getHeight()-20);
        f.add(sp);
       

        list.setRowHeight(40);
        list.setFont(new Font("",Font.PLAIN,20));
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            Statement s;
            //st=con.prepareStatement("select * from addmedicine where name=?");
            s=con.createStatement();
            //rs=st.executeQuery("select * from addmedicine where id=?");
            //st.setString(1, "p500");
            //rs=st.executeQuery();
            rs=s.executeQuery("select * from addmedicine");
            int count=1;
            while(rs.next())
            {
                
               String[] medicinedata={Integer.toString(count),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("purchasedate"),rs.getString("expdate"),rs.getString("purchaseprice"),rs.getString("saleprice"),rs.getString("tax"),rs.getString("rackno"),rs.getString("suppliername"),rs.getString("medicinecompany"),rs.getString("medicinetype"),rs.getString("generic")}; 
                model.addRow(medicinedata);
                count++;
            }
            rs.close();
            s.close();
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
            java.util.logging.Logger.getLogger(addmedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addmedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addmedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addmedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new addmedicine().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}

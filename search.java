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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class search extends JFrame implements ActionListener
{
    JPanel pa1,pa2,close,min,head,genpanel;
    JTextField tfb,tfn,tfq,tfm,tfe,tfpp,tfsp,tfr,tfsname,tfc,tft,tfgn;
    JLabel l1,title,batchno,name,quantity,mfg,exp,pprice,sprice,rno,sname,com,mtype,closel,minl,headl,tx,gen;
    JComboBox cmtype;
    JButton ok,preview,back,show;
    JTable list=new JTable();
    DefaultTableModel model=new DefaultTableModel();
    JScrollPane sp=new JScrollPane(list);
    Connection con;
    Statement st;
    ResultSet rs;
    Color c=new Color(82,188,114);
    String[] ctnt={"Tablet","Tonic","oilment","Injection","Needle","Cluqoas Bottle","Others..."};
    String[] b1;
    String[] n1;
    int x,y,datacount=0;
    @SuppressWarnings("unchecked")
    public search()
    {
        super("search medicine");
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
        catch(Exception e)
        {
            
        }
        title=new JLabel("SEARCH MEDICINE");
        title.setBounds(250, 10, 450, 90);
        title.setFont(new Font("TimesRoman",Font.BOLD,40));
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medicine.png")));
        add(title);
        
        list.setModel(model);
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
        sp.setBounds(10, 100, getWidth()-20, 400);
        sp.setVisible(false);
        //add(sp);
       

        list.setRowHeight(40);
        list.setFont(new Font("",Font.PLAIN,20));
        
        
        
        genpanel=new JPanel();
        genpanel.setBounds(10, 100, getWidth()-20, 400);
        genpanel.setVisible(false);
        add(sp);
        add(genpanel);
        
        
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
        ok.setBounds(600,540,159,47);
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/search1.png")));
        add(ok);
        
        preview=new JButton();
        preview.setBounds(419,540,158,50);
        preview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/preview.png")));
        add(preview);
        
        show=new JButton();
        show.setBounds(587,540,157,50);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/show.png")));
        add(show);
        
        back=new JButton();
        back.setBounds(510,530,71,68);
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
        
        headl=new JLabel("  Search Medicine");
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
        preview.setVisible(false);
        show.setVisible(false);
        back.addActionListener(this);
        ok.addActionListener(this);
        show.addActionListener(this);
        
        tfb.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                
                tfb.setText(tfb.getText().toUpperCase());
                
                if(k==KeyEvent.VK_ESCAPE)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new home().setVisible(true);
                    //System.exit(0);
                }
            }
        });
        tfn.addKeyListener(new java.awt.event.KeyAdapter() {
        
            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                tfn.setText(tfn.getText().toUpperCase());
                if(k==KeyEvent.VK_ENTER)
                {
                    search_();
                }
            }
        });
        tfb.addKeyListener(new java.awt.event.KeyAdapter() {
        
            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    search_();
                }
            }
        });
        tfgn.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ENTER)
                {
                    ok.setEnabled(false);
                    searchBYGENERIC();
                }
            }
        });
        tfgn.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ESCAPE)
                {
                    for(int i=list.getModel().getRowCount()-1;i>=0;i--)
                    {
                        model.removeRow(i);
                    }
                    ok.setEnabled(true);
                    genpanel.setVisible(false);
                    sp.setVisible(false);
                }
            }
        });
        list.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ESCAPE)
                {
                    for(int i=list.getModel().getRowCount()-1;i>=0;i--)
                    {
                        model.removeRow(i);
                    }
                    ok.setEnabled(true);
                    genpanel.setVisible(false);
                    sp.setVisible(false);
                    tfgn.requestFocus();
                }
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
        
        setBounds(200,10,900,770);
        setBounds(200,10,900,700);
        
        
    }
    
    
    
    public void okclick(java.awt.event.MouseEvent me)
    {
        ok.setBounds(600,530,159,47);
        
    }
    public void okrelease(java.awt.event.MouseEvent me)
    {
        ok.setBounds(600,540,159,47);
        
    }
    
    public void backclick(java.awt.event.MouseEvent me)
    {
        back.setBounds(510,520,71,68);
        
    }
    public void backrelease(java.awt.event.MouseEvent me)
    {
        back.setBounds(510,530,71,68);
        
    }
    
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==back)
            {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                setVisible(false);
                new home().setVisible(true);
            }
            else if(ae.getSource()==ok)
            {
                search_();
            }
            else if(ae.getSource()==show)
            {
                next_back();
            }
        }
        
        public void search_()
        {
            if(tfb.getText().isEmpty()==false)
            {
            try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addmedicine where batchno=?");
                    ps.setString(1, tfb.getText().toString());
                    rs=ps.executeQuery();
               
                    if(rs.next())
                    {
                        tfb.setText(rs.getString("batchno"));
                        tfn.setText(rs.getString("name"));
                        tfq.setText(rs.getString("quantity"));
                        tfm.setText(rs.getString("purchasedate"));
                        tfe.setText(rs.getString("expdate"));
                        tfpp.setText(rs.getString("purchaseprice"));
                        tfsp.setText(rs.getString("saleprice"));
                        tfr.setText(rs.getString("rackno"));
                        tfsname.setText(rs.getString("suppliername"));
                        tfc.setText(rs.getString("medicinecompany"));
                        cmtype.setSelectedItem(rs.getString("medicinetype"));
                        tft.setText(rs.getString("tax"));
                        tfgn.setText(rs.getString("generic"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "does not match given medicine name");
                    }
                    rs.close();
                    ps.close();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage());
                }
        }
        else if(tfn.getText().isEmpty()==false)
        {
            try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addmedicine where name=?");
                    ps.setString(1, tfn.getText().toString());
                    rs=ps.executeQuery();
               
                    if(rs.next())
                    {
                        tfb.setText(rs.getString("batchno"));
                        tfn.setText(rs.getString("name"));
                        tfq.setText(rs.getString("quantity"));
                        tfm.setText(rs.getString("purchasedate"));
                        tfe.setText(rs.getString("expdate"));
                        tfpp.setText(rs.getString("purchaseprice"));
                        tfsp.setText(rs.getString("saleprice"));
                        tfr.setText(rs.getString("rackno"));
                        tfsname.setText(rs.getString("suppliername"));
                        tfc.setText(rs.getString("medicinecompany"));
                        cmtype.setSelectedItem(rs.getString("medicinetype"));
                        tft.setText(rs.getString("tax"));
                        tfgn.setText(rs.getString("generic"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "does not match given medicine name");
                    }
                    rs.close();
                    ps.close();
                    
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage());
                }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "you can search by medicine name and medicine batch number please give any one data");
        }
        }
        
        public void searchBYGENERIC()
        {
            genpanel.setVisible(true);
            sp.setVisible(true);
            
            try
                {
                    st=con.createStatement();
                    rs=st.executeQuery("select * from addmedicine");
            int count=1;
            while(rs.next())
            {
               if(rs.getString("generic").equals(tfgn.getText()))
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
        
        public void next_back()
        {
            datacount=1;
            try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addmedicine where quantity=?");
                    ps.setString(1, tfq.getText().toString());
                    rs=ps.executeQuery();
            
                         if(rs.next())
                        {
                        tfb.setText(rs.getString("batchno"));
                        tfn.setText(rs.getString("name"));
                        tfq.setText(rs.getString("quantity"));
                        tfm.setText(rs.getString("purchasedate"));
                        tfe.setText(rs.getString("expdate"));
                        tfpp.setText(rs.getString("purchaseprice"));
                        tfsp.setText(rs.getString("saleprice"));
                        tfr.setText(rs.getString("rackno"));
                        tfsname.setText(rs.getString("suppliername"));
                        tfc.setText(rs.getString("medicinecompany"));
                        cmtype.setSelectedItem(rs.getString("medicinetype"));
                          
                        }  
                }
            catch(Exception e){}
            
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
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new search().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}

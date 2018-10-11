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
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
public class medupdate extends JFrame implements ActionListener
{
    JFrame f;
    JPanel pa1,pa2,head,close,min;
    JTextField tfb,tfn,tfq,tfm,tfe,tfpp,tfsp,tfr,tfsname,tfc,tft,search_data,tfgn;
    JLabel l1,title,batchno,name,quantity,mfg,exp,pprice,sprice,rno,sname,com,mtype,headl,minl,closel,tx,gen;
    JComboBox cmtype;
    JButton ok,preview,back,show;
    JTable list;
    JScrollPane sp;
    Timer t;
    DefaultTableModel model;
    Connection con;
    Statement st;
    ResultSet rs;
    Color c=new Color(82,188,114);
    String[] ctnt={"--select--","Tablet","Tonic","oilment","Injection","Needle","Cluqoas Bottle","Others..."};
    int x,y,row;
    String value;
    @SuppressWarnings("unchecked")
    public medupdate()
    {
        super("update medicine");
        setBounds(200,10,900,700);
        setLayout(null);
        //setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_data","root","");
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            
        }
        
        title=new JLabel("UPDATE MEDICINE");
        title.setBounds(250, 10, 450, 90);
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
        ok.setBounds(460,540,158,50);
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/update.png")));
        add(ok);
        
        preview=new JButton();
        preview.setBounds(629,540,158,50);
        preview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/preview.png")));
        add(preview);
        
        show=new JButton();
        show.setBounds(587,540,157,50);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/show.png")));
        //add(show);
        
        back=new JButton();
        back.setBounds(390,530,71,68);
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
        
        headl=new JLabel("  Medicine Update");
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
        show.addActionListener(this);
        preview.addActionListener(this);
        
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
            }
        });
        tfn.addKeyListener(new java.awt.event.KeyAdapter() {
        
            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                key(ke);
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
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                showclick(me);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                showrelease(me);
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
        
        ok.setEnabled(false);
    }
    public void key(java.awt.event.KeyEvent ke)
    {
        if(tfn.getText().equals(" ") || tfn.getText().equals("!"))
        {
            tfn.setText("");
        }
    }
    
    
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
    public void showclick(java.awt.event.MouseEvent me)
    {
        show.setBounds(597,550,159,50);
        
    }
    public void showrelease(java.awt.event.MouseEvent me)
    {
        show.setBounds(587,540,159,50);
        
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
            if(ae.getSource()==back)
            {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                setVisible(false);
                new home().setVisible(true);
            }
            else if(ae.getSource()==preview)
            {
                view();
            }
            else if(ae.getSource()==ok)
            {
                try
                {
                String query="UPDATE addmedicine SET batchno='"+tfb.getText()+"',name='"+tfn.getText()+"',quantity='"+tfq.getText()+"',purchasedate='"+tfm.getText()+"',expdate='"+tfe.getText()+"',purchaseprice='"+tfpp.getText()+"',saleprice='"+tfsp.getText()+"',tax='"+tft.getText()+"',rackno='"+tfr.getText()+"',suppliername='"+tfsname.getText()+"',medicinecompany='"+tfc.getText()+"',medicinetype='"+cmtype.getSelectedItem()+"',generic='"+tfgn.getText()+"'  WHERE  sno='"+value+"'";
                            
                PreparedStatement ps=con.prepareStatement(query);
                //ps.setString(1, tfn.getText());
                    ps.execute();
                    
                JOptionPane.showMessageDialog(rootPane, "updated...");
                ps.close();
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
            }
            else if(ae.getSource()==show)
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
        }
        public void view()
   {
       f=new JFrame("update data");
       f.setBounds(350, 100, 750, 600);
       f.setVisible(true);
       f.setLayout(null);
       //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //f.setVisible(false);
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
        
        
        list.setRowHeight(40);
        list.setFont(new Font("",Font.PLAIN,18));
        sp=new JScrollPane(list);
        sp.setBounds(0, 40, f.getWidth()-20, f.getHeight()-40);
        f.add(sp);
        
        search_data=new JTextField();
        search_data.setBounds(5, 5, 150, 30);
        f.add(search_data);
        
        show.setEnabled(true);
        ok.setEnabled(true);
        int count=1;
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            st=con.createStatement();
            rs=st.executeQuery("select * from addmedicine");
            while(rs.next())
            {
                String[] supdata={rs.getString("sno"),rs.getString("batchno"),rs.getString("name"),rs.getString("quantity"),rs.getString("purchasedate"),rs.getString("expdate"),rs.getString("purchaseprice"),rs.getString("saleprice"),rs.getString("tax"),rs.getString("rackno"),rs.getString("suppliername"),rs.getString("medicinecompany"),rs.getString("medicinetype"),rs.getString("generic")} ;
                model.addRow(supdata);
                //count++;
            }
            st.close();
            rs.close();
            
        }
        catch(Exception e)
        {
            
        }
        
        
        search_data.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
                list.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search_data.getText().toUpperCase()));
                            }
        });
        
        f.addWindowStateListener(new java.awt.event.WindowAdapter() {

            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                
                sp.setBounds(0, 40, f.getWidth()-20, f.getHeight()-40);
                repaint();
            }
        });
        f.addWindowListener(new java.awt.event.WindowAdapter() {

            
        });
        list.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                row=list.getSelectedRow();
                value=(list.getModel().getValueAt(row, 0).toString());
                tfb.setText(list.getModel().getValueAt(row, 1).toString());
                tfn.setText(list.getModel().getValueAt(row, 2).toString());
                tfq.setText(list.getModel().getValueAt(row, 3).toString());
                tfm.setText(list.getModel().getValueAt(row, 4).toString());
                tfe.setText(list.getModel().getValueAt(row, 5).toString());
                tfpp.setText(list.getModel().getValueAt(row,6).toString());
                tfsp.setText(list.getModel().getValueAt(row, 7).toString());
                tft.setText(list.getModel().getValueAt(row, 8).toString());
                tfr.setText(list.getModel().getValueAt(row, 9).toString());
                tfsname.setText(list.getModel().getValueAt(row, 10).toString());
                tfc.setText(list.getModel().getValueAt(row, 11).toString());
                cmtype.setSelectedItem(list.getModel().getValueAt(row, 12).toString());
                tfgn.setText(list.getModel().getValueAt(row, 13).toString());
                
                
                
                f.setVisible(false);
            }
        });
   }
    public static void main(String a[])
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(medupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(medupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(medupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(medupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new medupdate().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}

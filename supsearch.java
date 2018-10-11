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
public class supsearch extends JFrame implements ActionListener
{
    JPanel pa1,close,min,head;
    JLabel title,entry,name,mob,email,com,closel,minl,headl;
    JTextField tn,tm,te,tc;
    JButton ok,preview,back,show;
    Color c=new Color(82,188,114);
    Connection con;
    ResultSet rs;
    Statement st;
    int x,y;
    public supsearch()
    {
        super("search supplier");
        setBounds(400, 100, 700, 450);
        setLayout(null);
        //setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        
        title=new JLabel("SEARCH SUPPLIER");
        title.setBounds(100, 30, 450, 50);
        title.setFont(new Font("TimesRoman",Font.BOLD,40));
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/suppliers.png")));
        add(title);
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
                    
        }
        
        name=new JLabel("name");
        name.setBounds(110, 110, 50, 30);
        add(name);
        
        mob=new JLabel("mobile no");
        mob.setBounds(110, 160, 50, 30);
        add(mob);
        
        email=new JLabel("email");
        email.setBounds(110, 220, 50, 30);
        add(email);
        
        com=new JLabel("company");
        com.setBounds(110, 280, 50, 30);
        add(com);
        
        tn=new JTextField();
        tn.setBounds(170, 110, 250, 30);
        add(tn);
        
        tm=new JTextField();
        tm.setBounds(170, 160, 250, 30);
        add(tm);
        
        te=new JTextField();
        te.setBounds(170, 220, 250, 30);
        add(te);
        
        tc=new JTextField();
        tc.setBounds(170, 280, 250, 30);
        add(tc);
        
        ok=new JButton();
        ok.setBounds(470,330,159,47);
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/search1.png")));
        add(ok);
        
        preview=new JButton();
        preview.setBounds(300,330,158,50);
        preview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/preview.png")));
        //add(preview);
        
        show=new JButton();
        show.setBounds(467,330,157,50);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/show.png")));
        //add(show);
        
        back=new JButton();
        back.setBounds(50,320,71,68);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/goback.png")));
        add(back);
        
        entry=new JLabel();
        entry.setBounds(40, 90, 610, 315);
        entry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/entry2.png")));
        add(entry);
        
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
        
        headl=new JLabel("  Search Supplier");
        headl.setBounds(0, 0, getWidth(), 30);
        headl.setBackground(Color.WHITE);
        add(headl);
        
        head=new JPanel();
        head.setBounds(0, 0, getWidth(), 30);
        head.setBackground(Color.WHITE);
        add(head);
        
        pa1=new JPanel();
        pa1.setBounds(0,0,getWidth(),150);
        pa1.setBackground(c);
        add(pa1);
        
        tn.addKeyListener(new java.awt.event.KeyAdapter() {

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
        
        setBounds(400, 100, 700, 480);
        setBounds(400, 100, 700, 450);
        
        back.addActionListener(this);
        ok.addActionListener(this);
        
        tn.addKeyListener(new java.awt.event.KeyAdapter() {
            
            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                tname(ke);
            }
        });
        tm.addKeyListener(new java.awt.event.KeyAdapter() {
            
            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                tmob(ke);
            }
        });
    }
    
    public void tname(java.awt.event.KeyEvent ke)
    {
        char key=ke.getKeyChar();
        if((Character.isDigit(key)))
        {
            ke.consume();
        }
    }
    public void tmob(java.awt.event.KeyEvent ke)
    {
        char key=ke.getKeyChar();
        int k=ke.getKeyChar();
        if(!(Character.isDigit(key)) && !(Character.isSpaceChar(key)))
        {
            ke.consume();
        }
        
    }
    
    public void okclick(java.awt.event.MouseEvent me)
    {
        ok.setBounds(480,340,159,47);
        
    }
    public void okrelease(java.awt.event.MouseEvent me)
    {
        ok.setBounds(470,330,159,47);
        
    }
    public void previewclick(java.awt.event.MouseEvent me)
    {
        preview.setBounds(310,340,159,50);
        
    }
    public void previewrelease(java.awt.event.MouseEvent me)
    {
        preview.setBounds(300,330,159,50);
        
    }
    public void showclick(java.awt.event.MouseEvent me)
    {
        show.setBounds(477,340,159,50);
        
    }
    public void showrelease(java.awt.event.MouseEvent me)
    {
        show.setBounds(467,330,159,50);
        
    }
    public void backclick(java.awt.event.MouseEvent me)
    {
        back.setBounds(40,310,71,68);
        
    }
    public void backrelease(java.awt.event.MouseEvent me)
    {
        back.setBounds(50,320,71,68);
        
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
            search();
        }
    }
    public void search()
    {
        if(tn.getText().isEmpty()==false)
        {
                try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addsupplier where name=?");
                    ps.setString(1, tn.getText().toString());
                    rs=ps.executeQuery();
               
                    if(rs.next())
                    {
                        tn.setText(rs.getString("name"));
                        tm.setText(rs.getString("mobileno"));
                        te.setText(rs.getString("email"));
                        tc.setText(rs.getString("company"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "could not match");
                    }
                    rs.close();
                    ps.close();
                }
                catch(Exception e){}
        }
        else if(tm.getText().isEmpty()==false)
        {
                try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addsupplier where mobileno=?");
                    ps.setString(1, tm.getText().toString());
                    rs=ps.executeQuery();
               
                    if(rs.next())
                    {
                        tn.setText(rs.getString("name"));
                        tm.setText(rs.getString("mobileno"));
                        te.setText(rs.getString("email"));
                        tc.setText(rs.getString("company"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "could not match");
                    }
                    rs.close();
                    ps.close();
                }
                catch(Exception e){}
        }
        else if(te.getText().isEmpty()==false)
        {
                try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addsupplier where email=?");
                    ps.setString(1, te.getText().toString());
                    rs=ps.executeQuery();
               
                    if(rs.next())
                    {
                        tn.setText(rs.getString("name"));
                        tm.setText(rs.getString("mobileno"));
                        te.setText(rs.getString("email"));
                        tc.setText(rs.getString("company"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "could not match");
                    }
                    rs.close();
                    ps.close();
                }
                catch(Exception e){}
                
        }
        else if(tc.getText().isEmpty()==false)
        {
                try
                {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from addsupplier where company=?");
                    ps.setString(1, tc.getText().toString());
                    rs=ps.executeQuery();
               
                    if(rs.next())
                    {
                        tn.setText(rs.getString("name"));
                        tm.setText(rs.getString("mobileno"));
                        te.setText(rs.getString("email"));
                        tc.setText(rs.getString("company"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "could not match");
                    }
                    rs.close();
                    ps.close();
                }
                catch(Exception e){}
        }
        else 
        {
            JOptionPane.showMessageDialog(rootPane, "can't match any one field data to database");
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
            java.util.logging.Logger.getLogger(supsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new supsearch().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}

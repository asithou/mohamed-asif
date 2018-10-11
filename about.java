/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalsoftwre.com.dcs.project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.net.URI;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
//import java.awt.color.*;
/**
 *
 * @author AsiThou
 */
public class about extends JFrame implements ActionListener 
{
    JPanel min,head,close,pa;
    JLabel minl,closel,headl,logo;
    JLabel background,bg,webpage;
    JButton ok;
    Desktop d=Desktop.getDesktop();

    int x,y;
    Connection con;
    public about()
    {
        super("about");
        setBounds(500, 100, 500, 500);
        setLayout(null);
        //setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
      
        
        
        bg=new JLabel();
        bg.setBounds(0, 30, 500, 254);
        //bg.setText("Medical Billing System");
        //bg.setFont(new Font("Times New Roman",Font.BOLD,50));
        //bg.setForeground(Color.red);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/about bg.jpg")));
        add(bg);
        
        JLabel pro=new JLabel();
        pro.setBounds(0, 294, 500, 50);
        pro.setText("Product: Billing System");
        pro.setFont(new Font("Times New Roman",Font.BOLD,15));
        //pro.setForeground(Color.red);
        add(pro);
        
        JLabel cmp=new JLabel();
        cmp.setBounds(0, 344, 500, 50);
        cmp.setText("Company:Dream Cyber Solutions");
        cmp.setFont(new Font("Times New Roman",Font.BOLD,15));
        //cmp.setForeground(Color.red);
        add(cmp);
        
        JLabel web=new JLabel();
        web.setBounds(0, 390, 60, 50);
        web.setText("WebSite:");
        web.setFont(new Font("Times New Roman",Font.BOLD,15));
        //web.setForeground(Color.red);
        add(web);
        
        webpage=new JLabel();
        webpage.setBounds(60, 390, 500, 50);
        webpage.setText("www.dreamcybersolutions.com");
        webpage.setFont(new Font("Times New Roman",Font.BOLD,15));
        webpage.setForeground(Color.BLUE);
        webpage.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        add(webpage);
        
        ok=new JButton();
        ok.setBounds(170, 440, 156, 47);
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/aok.png")));
        add(ok);
        
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
        
        headl=new JLabel("  About");
        headl.setBounds(0, 0, getWidth(), 30);
        headl.setBackground(Color.WHITE);
        add(headl);
        
        head=new JPanel();
        head.setBounds(0, 0, getWidth(), 30);
        head.setBackground(Color.WHITE);
        add(head);
        
        pa=new JPanel();
        pa.setBounds(0, 0, getWidth(), getHeight()+30);
        pa.setBackground(Color.WHITE);
        add(pa);
        
        
        
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
                //Connection con=null;
                try
                {
                    Statement st;
                    //Class.forName("com.mysql.jdbc.Driver");
                    //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
                    Class.forName("org.sqlite.JDBC");
                    con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
                    
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
        webpage.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                openWebSite();
            }
        });
        
        setBounds(500, 100, 400, 550);
        setBounds(500, 100, 500, 500);
        
        ok.addActionListener(this);
        
    }
    public void openWebSite()
    {
        try 
        {
            d.browse(new URI("http://dreamcybersolutions.com/index.html"));
			
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage()+"no intenernet connection...");
        }
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==ok)
        {
            //try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
            setVisible(false);
            new home().setVisible(true);
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
            java.util.logging.Logger.getLogger(about.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(about.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(about.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(about.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new about().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}

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
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class reset_password extends JFrame implements ActionListener
{
    Thread t=new Thread();
    Timer t1=new Timer(100, this);
    JPanel hpanel,head,min,close;
    Button login,change;
    JLabel username,password,bg,usrmen,img,s1,s2,headl,minl,closel,l,load;
    JTextField usr;
    JPasswordField pass;
    JSeparator sp1,sp2;
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    Color loginc=new Color(82,188,14);
    Color c2=new Color(187, 57, 48);
    String u,p;
    int x,y,i=1;        
    String login_user,mp,sp,bp,cat;
    public reset_password()
    {
        super("Change Password");
        setBounds(400,100,674,490);
        setLayout(null);
        //setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        
        t1.start();
        img=new JLabel();
        img.setBounds(70, 170, 100, 100);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/person.png")));
        add(img);
        
        load=new JLabel();
        load.setBounds(200, 180, 100, 100);
        load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/1.png")));
        //load.setVisible(true);
        //add(load);
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
            
        }
        catch(Exception e){}
        
        l=new JLabel("Passwod Setting");
        l.setBounds(200,100,180,40);
        l.setFont(new Font("Segoe UI",Font.PLAIN,24));
        add(l);
        
        login=new Button("Submit");
        login.setBounds(380, 330, 100, 40);
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.setFont(new Font("Segoe UI",Font.PLAIN,20));
        login.setBackground(Color.RED);
        login.setForeground(Color.WHITE);
        add(login);
        
        change=new Button("Change Password");
        change.setBounds(330, 330, 150, 40);
        change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        change.setFont(new Font("Segoe UI",Font.PLAIN,16));
        change.setBackground(Color.RED);
        change.setForeground(Color.WHITE);
        change.setVisible(false);
        add(change);
        
        username=new JLabel();
        username.setBounds(200, 180, 30, 30);
        username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/user.png")));
        add(username);
        
        password=new JLabel();
        password.setBounds(200, 250, 30, 30);
        password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/password.png")));
        add(password);
        
        sp1=new JSeparator();
        sp1.setBounds(200, 220, 280, 10);
        add(sp1);
        usr=new JTextField("user name");
        usr.setBounds(230, 180, 250, 40);
        usr.setForeground(Color.LIGHT_GRAY);
        usr.setFont(new Font("Segoe UI",Font.PLAIN,20));
        usr.setBorder(null);
        add(usr);
        
        sp2=new JSeparator();
        sp2.setBounds(200, 290, 280, 10);
        add(sp2);
        pass=new JPasswordField("password");
        pass.setBounds(230, 250, 250, 40);
        pass.setForeground(Color.LIGHT_GRAY);
        pass.setFont(new Font("Segoe UI",Font.PLAIN,20));
        pass.setBorder(null);
        add(pass);
        
        
        
        usrmen=new JLabel();
        usrmen.setBounds(350, 5, 257, 242);
        //usrmen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dcs/project/img/loginmen.png")));
        //add(usrmen);
        
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
        
        headl=new JLabel("  Change Password");
        headl.setBounds(0, 0, getWidth(), 30);
        headl.setBackground(Color.WHITE);
        add(headl);
        
        head=new JPanel();
        head.setBounds(0, 0, getWidth(), 30);
        head.setBackground(Color.WHITE);
        add(head);
        
        bg=new JLabel();
        bg.setBounds(0, 0, getWidth(), getHeight());
        //bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dcs/project/img/medbgi.jpg")));
        bg.setBackground(Color.WHITE);
        add(bg);
        hpanel=new JPanel();
        hpanel.setBounds(0,0,getWidth(),getHeight());
        hpanel.setBackground(Color.WHITE);
        add(hpanel);
        
        setBounds(400,100,674,504);
        setBounds(400,100,674,492);
        
        
        usr.addKeyListener(new java.awt.event.KeyAdapter() {

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
        login.addMouseListener(new java.awt.event.MouseAdapter() {
    
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                login.setBackground(c2);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                login.setBackground(Color.RED);
            }
    });
        change.addMouseListener(new java.awt.event.MouseAdapter() {
    
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                change.setBackground(c2);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                change.setBackground(Color.RED);
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
                    //Class.forName("com.mysql.jdbc.Driver");
                    //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
                    st=con.createStatement();
                    st.executeUpdate("DELETE FROM user_login WHERE sno=1");
                    st.close();
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
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
        
        
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            
            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                repaint();
                if(pass.getText().equals("password"))
                {
                    pass.setText("");
                }
                if(k==KeyEvent.VK_ENTER)
                {
                    //pass.requestFocus();
                }
                if(k==KeyEvent.VK_BACK_SPACE && pass.getText().isEmpty())
                {
                    pass.setText("password");
                }
                if(k==KeyEvent.VK_BACK_SPACE && pass.getText().equals("passwor"))
                {
                    pass.setText("password");
                }
            }
        });
        usr.addKeyListener(new java.awt.event.KeyAdapter() {
            
            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                repaint();
                if(usr.getText().equals("user name"))
                {
                    usr.setText("");
                }
                if(k==KeyEvent.VK_ENTER)
                {
                    if(usr.getText().equals("user name"))
                    {
                        usr.setText("user name");
                    }
                    pass.requestFocus();
                }
                if(k==KeyEvent.VK_BACK_SPACE && usr.getText().isEmpty())
                {
                    usr.setText("user name");
                }
                if(k==KeyEvent.VK_BACK_SPACE && usr.getText().equals("user nam"))
                {
                    usr.setText("user name");
                }
            }
        });  
        login.addActionListener(this);
        change.addActionListener(this);
    }
    
    
    
    @Override
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            getData();
            getUserPassword();
            if(u.equals(usr.getText()) && p.equals(pass.getText()))
            {
                usr.setText("user name");
                pass.setText("password");
                login.setVisible(false);
                change.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "user name and password is not matched");
            }
        }
        if(ae.getSource()==change)
        {
            if(checkUserName())
            {
                JOptionPane.showMessageDialog(rootPane, "this user name is already exist so try with different username");
            }
            else
            {
                updatePassword();
                JOptionPane.showMessageDialog(rootPane, "password changed successfully");
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                setVisible(false);
                new home().setVisible(true);
            }
            
        }
        
        
    }
    public void updatePassword()
    {
        try
        {
            PreparedStatement ps;
            ps=con.prepareStatement("UPDATE add_user SET username='"+usr.getText()+"',password='"+pass.getText()+"' WHERE name='"+login_user+"'");
            ps.execute();
            ps.close();
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}

    }
    public void getUserPassword()
    {
        try
            {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from add_user where name=?");
                    ps.setString(1, login_user);
                    rs=ps.executeQuery();
               
                    
                    if(rs.next())
                    {
                        u=rs.getString("username");
                        p=rs.getString("password");
                    }
                    rs.close();
                    ps.close();
            }
            catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        
    }
    public boolean checkUserName()
    {
        boolean status;
        try
        {
                PreparedStatement st;
                st=con.prepareStatement("select * from add_user where username=?");
                st.setString(1, usr.getText());
                rs=st.executeQuery();
                    if(rs.next())
                    {
                        if(rs.getString("username").equals(usr.getText()))
                        {
                            return status=true;
                        }
                    }
                    else 
                    {
                        return status=false;
                    }
                    rs.close();
                    st.close();
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
    return status=false;
    }
    public String getData()
    {
        try
            {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from user_login where sno=?");
                    ps.setString(1, "1");
                    rs=ps.executeQuery();
               
                    
                    if(rs.next())
                    {
                        login_user=rs.getString("name");
                    }
                    rs.close();
                    ps.close();
            }
            catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        return login_user;
    }
    public void load()
    {
        load.setVisible(true);  
                        
                                if(i<=8)
                                {
                           
                                    load.setVisible(true);
                                    load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dcs/project/img/"+i+".png")));
                                    i++;
                                    
                                }
                                if(i>8)
                                {
                                    t1.stop();
                                }
    }
     public static void main(String a[])
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(reset_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reset_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reset_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reset_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new reset_password().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
    
}


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
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    Thread t=new Thread();
    Timer t1=new Timer(200,new loadinganimate());
    //Timer t2=new Timer(200,new animation());
    JPanel hpanel,head,min,close,virtual;
    JButton login;
    JLabel username,password,bg,usrmen,img,s1,s2,headl,minl,closel,l,load,bgi,forgot;
    JTextField usr;
    ImageIcon ii=new ImageIcon("/medicalsoftwre/com/dcs/project/img/user.png");
    JPasswordField pass;
    JSeparator sp1,sp2;
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    ActionListener al;
    //Animation an;
    
    Color loginc=new Color(82,188,14);
    String u,p;
    int x,y,i=1,x_=0,h1=0,h2=0;        
    String login_user,mp,sp,bp,cat;
    public login()
    {
        super("Login");
        setBounds(0,0,1360,710);
        setLayout(null);
        //setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
       
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        
        //t1.start();
        img=new JLabel();
        img.setBounds(590, 110, 100, 100);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/person.png")));
        add(img);
        
        load=new JLabel();
        load.setBounds(590, 420, 100, 100);
        load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/1.png")));
        load.setVisible(false);
        add(load);
       
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
            
            
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" error");}
        
        l=new JLabel("Login");
        l.setBounds(500,200,80,40);
        l.setFont(new Font("Segoe UI",Font.PLAIN,30));
        add(l);
        
        login=new JButton();
        login.setBounds(510, 530, 258, 49);
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //login.setBackground(loginc);
        //login.setForeground(Color.WHITE);
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/loginbutton.png")));
        add(login);
        
        forgot=new JLabel("Forgot Password?");
        forgot.setBounds(700, 420, 100, 15);
        forgot.setForeground(new Color(26,115,232));
        forgot.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        add(forgot);
        
        username=new JLabel();
        username.setBounds(500, 300, 30, 30);
        username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/user.png")));
        add(username);
        
        password=new JLabel();
        password.setBounds(500, 370, 30, 30);
        password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/password.png")));
        add(password);
        
        sp1=new JSeparator();
        sp1.setBounds(500, 340, 280, 10);
        add(sp1);
        usr=new JTextField();
        usr.setBounds(530, 300, 250, 40);
        //usr.setBackground(new Color(0,0,0,80));
        usr.setBorder(null);
        //usr.setOpaque(false);
        add(usr);
        
        sp2=new JSeparator();
        sp2.setBounds(500, 410, 280, 10);
        add(sp2);
        pass=new JPasswordField();
        pass.setBounds(530, 370, 250, 40);
        //pass.setBackground(new Color(0,0,0,80));
        pass.setBorder(null);
        add(pass);
        
        
        
        usrmen=new JLabel();
        usrmen.setBounds(350, 5, 257, 242);
        //usrmen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com\\dcs\\project\\img\\loginmen.png")));
        //add(usrmen);
        
        virtual=new JPanel();
        virtual.setBounds(430, 170, 430, 430);
        virtual.setBackground(new Color(255,255,255));
        add(virtual);
        
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
        
        headl=new JLabel("  Login");
        headl.setBounds(0, 0, getWidth(), 30);
        headl.setBackground(Color.WHITE);
        add(headl);
        
        head=new JPanel();
        head.setBounds(0, 0, getWidth(), 30);
        head.setBackground(Color.WHITE);
        add(head);
        
        bg=new JLabel();
        bg.setBounds(0, 0, getWidth(), getHeight());
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/login bgi.jpg")));
        //bg.setBackground(Color.WHITE);
        add(bg);
        hpanel=new JPanel();
        hpanel.setBounds(0,0,getWidth(),getHeight());
        hpanel.setBackground(Color.WHITE);
        add(hpanel);
        
        setBounds(0,0,1360,700);
        setBounds(0,0,1360,710);
        
        
        forgot.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                setVisible(false);
                new Otp().setVisible(true);
            }
        });
        
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                login.setBackground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                login.setBackground(loginc);
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
        
        usr.addKeyListener(new java.awt.event.KeyAdapter() {
            
            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                repaint();
                //enter(ke);
            }
            public void keyPressed(java.awt.event.KeyEvent ke)
            {
                repaint();
                //enter(ke);
                
            }
            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                char key=ke.getKeyChar();
                if(key==KeyEvent.VK_ENTER)
                {
                    pass.requestFocus();
                }
                
            }
        });
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            
            public void keyTyped(java.awt.event.KeyEvent ke)
            {
                repaint();
                enter(ke);
            }
        });
        
        
                            //@Override
                            
                       
        
        login.addActionListener(this);
        
        //t1.start();
    }
    
    
    
    
    public class loadinganimate implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            
            
                                if(i<=8)
                                {
                           
                                    load.setVisible(true);
                                    load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/"+i+".png")));
                                    //setBounds(0,i,1360,710);
                                    //setBounds(x_+=50, y_+=50, getWidth()-50, getHeight()-50);
                                    i++;
                                    //x_=x_+50;
                                    t1.setDelay(200);
                                    //setBounds(0, 0, getWidth(), getHeight()-105);
                                }
                                if(i>8)
                                {
                                    
                                    t1.stop();
                                    getData();
                                    
                                    
                                    
                                    if(usr.getText().equals(u) && pass.getText().equals(p))
                                    {
                                        //JOptionPane.showMessageDialog(rootPane, "success");
                                        
                                        //t2.start();
                                        loginDetail();
                                        //an=new Animation();
                                        //setBounds(0,an.start,1360,710);
                                        //an.start;
                                        //an.finish;
                                        //System.out.println("\n"+an.start);
                                        setVisible(false);
                                        new home().setVisible(true);
                                        //new home().dcs.setText(login_user);
                                        
                                        
                                    }
                                    else
                                    {
                                       
                                        JOptionPane.showMessageDialog(rootPane, "Authondication Error ");
                                         
                                        load.setVisible(false);
                                        i=1;
                                        //setVisible(false);
                                        //new login().setVisible(true);
                                        //setBounds(0,0,1360,710);
                                    }
                                }
        }
    }
    
    public void enter(java.awt.event.KeyEvent ke)
    {
        char key=ke.getKeyChar();
        if(key==KeyEvent.VK_ENTER)
        {
            t1=new Timer(200,new loadinganimate());
            t1.start();     
            //t2.start();
        }
        
    }
    
    @Override
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            t1=new Timer(200,new loadinganimate());
            //JOptionPane.showMessageDialog(rootPane, "Authendication Access");
            load.setVisible(true);  
            t1.start();
            //load();                        
            //load();
                    
            //}
            //catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        }
        
        
    }
    public void loginDetail()
    {
        try
        {
            PreparedStatement ps;
            ps=con.prepareStatement("insert into user_login values(?,?,?,?,?,?)");
            ps.setString(1, "1");
            ps.setString(2, login_user);
            ps.setString(3, mp);
            ps.setString(4, sp);
            ps.setString(5, bp);
            ps.setString(6, cat);
            
            ps.executeUpdate();
            ps.close();
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        
        
        
    }
    public String getData()
    {
        try
            {
                    PreparedStatement ps;
                    ps=con.prepareStatement("select * from add_user where username=?");
                    ps.setString(1, usr.getText().toString());
                    rs=ps.executeQuery();
               
                    
                    if(rs.next())
                    {
                    u=rs.getString("username");
                    p=rs.getString("password");
                    login_user=rs.getString("name");
                    mp=rs.getString("mpermission");
                    sp=rs.getString("spermission");
                    bp=rs.getString("bpermission");
                    cat=rs.getString("category");
                    }
                    rs.close();
                    ps.close();
            }
            catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        return login_user;
    }
    public void load()
    {
        t1.start();
        load.setVisible(true);  
                        
                                if(i<=8)
                                {
                           
                                    load.setVisible(true);
                                    load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/"+i+".png")));
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new login().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
    
}


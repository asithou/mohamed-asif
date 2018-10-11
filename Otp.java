/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalsoftwre.com.dcs.project;


import java.awt.event.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.mail.internet.MimeMessage;
/**
 *
 * @author AsiThou
 */
public class Otp extends JFrame implements ActionListener
{
    
    JButton send,submit;
    JPanel min,head,close,pa;
    JLabel minl,headl,closel,maillogo,userlogo,resend,eotp,epass;
    JTextField email,user,otp;
    JPasswordField pass;
    JSeparator sp1,sp2;
    
    Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    
    int x,y;
    String temp="";
    String  otp_="0123456789";
    String mail="",u="",m="",temp_otp;
    Random r=new Random();
    char[] OTP=new char[6];
    public Otp()
    {
        
        super("PAssword Recovery");
        setBounds(500, 150, 400, 400);
        //setVisible(true);
        setLayout(null);
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
             JOptionPane.showMessageDialog(rootPane, e.getMessage());
         }
    
        eotp=new JLabel("Enter otp");
        eotp.setBounds(50, 130, 120, 10);
        eotp.setVisible(false);
        add(eotp);
        
        epass=new JLabel("Enter password");
        epass.setBounds(50, 210, 120, 10);
        epass.setVisible(false);
        add(epass);
        
        userlogo=new JLabel();
        userlogo.setBounds(50, 140, 30, 30);
        userlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/user.png")));
        add(userlogo);
         
        maillogo=new JLabel();
        maillogo.setBounds(50, 220, 30, 30);
        maillogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/email.png")));
        add(maillogo);
        sp1=new JSeparator();
        sp1.setBounds(50, 180, 280, 10);
        add(sp1);
        user=new JTextField();
        user.setBounds(80, 140, 250, 40);
        //usr.setBackground(new Color(0,0,0,80));
        user.setBorder(null);
        //usr.setOpaque(false);
        add(user);
        
        otp=new JTextField();
        otp.setBounds(80, 140, 250, 40);
        //usr.setBackground(new Color(0,0,0,80));
        otp.setBorder(null);
        //usr.setOpaque(false);
        otp.setVisible(false);
        add(otp);
        
        sp2=new JSeparator();
        sp2.setBounds(50, 260, 280, 10);
        add(sp2);
        email=new JTextField();
        email.setBounds(80, 220, 250, 40);
        //pass.setBackground(new Color(0,0,0,80));
        email.setBorder(null);
        add(email);
        
        pass=new JPasswordField();
        pass.setBounds(80, 220, 250, 40);
        //pass.setBackground(new Color(0,0,0,80));
        pass.setBorder(null);
        pass.setVisible(false);
        add(pass);
         
        resend=new JLabel("Resend Code");
        resend.setBounds(50, 280, 100, 10);
        resend.setForeground(new Color(26,115,232));
        resend.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        resend.setVisible(false);
        add(resend);
        
        submit=new JButton();
        submit.setBounds(230, 280, 100, 40);
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/submit.png")));
        submit.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        submit.setVisible(false);
        add(submit);
        
        send=new JButton();
        send.setBounds(230, 280, 100, 40);
        send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/send.png")));
        send.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        add(send);
        
        
        
        
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
        
        headl=new JLabel("  Password Recovery");
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
        
        setBounds(300, 100, 450, 500);
        setBounds(500, 150, 400, 400);
        
        
        
        resend.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                deleteOtp();
                sendOtp();
                mail=email.getText();
                sendMail();
                setOtp();
                temp="";
                //JOptionPane.showMessageDialog(rootPane, "otp was successfully send to "+email.getText()+temp);
                
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
                    
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new login().setVisible(true);
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
                //System.exit(0);
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
        
        send.addActionListener(this);
        submit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==send)
        {
            getAccount();
            
            if(user.getText().isEmpty()==true  || email.getText().isEmpty()==true)
            {
                JOptionPane.showMessageDialog(rootPane, "please fill accountname and email");
            }
            else if(u.equals(user.getText()) && m.equals(email.getText()))
            {
            send.setEnabled(false);
            send.setVisible(false);
            resend.setVisible(true);
            sendOtp();
            mail=email.getText();
            sendMail();
            setOtp();
            //JOptionPane.showMessageDialog(rootPane, "otp was successfully send to "+email.getText());
            user.setVisible(false);
            email.setVisible(false);
            userlogo.setVisible(false);
            maillogo.setVisible(false);
            otp.setVisible(true);
            pass.setVisible(true);
            eotp.setVisible(true);
            epass.setVisible(true);
            temp="";
            submit.setVisible(true);
            }
            else
            {
               JOptionPane.showMessageDialog(rootPane, "don't match accountname and email");
            }
        }
        else if(ae.getSource()==submit)
        {
            getOtp();
            if(otp.getText().equals(temp_otp))
            {
            resetPassword();
            deleteOtp();
            JOptionPane.showMessageDialog(rootPane, "password successfully reset");
            try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
            setVisible(false);
            new login().setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "don't match otp");
            }
        }
        
    }
    
    public void sendMail()
    {
     try
     {
     String host = "smtp.gmail.com";//or IP address
     String user = "dcsmailservice@gmail.com";//change accordingly  
     String pass="dcsmail123";
     String to = mail;  
     String from="dcsmailservice@gmail.com";
     String subject="Password Recovery OTP";
     String message=temp;
     boolean sessionDebug=false;         
      
     
     
     Properties props=System.getProperties();
     props.put("mail.smtp.ssl.trust", host);
     props.put("mail.smtp.auth", true);
     props.put("mail.smtp.starttls.enable", true);
     props.put("mail.smtp.host", host);
     props.put("mail.smtp.port", "587");
 
     props.put("mail.smtp.starttls.required", true);
     
     //status.setText("sending....");
     
     java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
     Session mailSession=Session.getDefaultInstance(props,new javax.mail.Authenticator() {

         protected javax.mail.PasswordAuthentication getPasswordAuthentication()
         {
             return new javax.mail.PasswordAuthentication(user, pass);
         }
     });
     mailSession.setDebug(sessionDebug);
     Message msg=new MimeMessage(mailSession);
     msg.setFrom(new InternetAddress("no-reply@gmail.com"));
     InternetAddress[] address={new InternetAddress(to)};
     msg.setRecipients(Message.RecipientType.TO, address);
     msg.setSubject(subject);msg.setSentDate(new Date());
     msg.setText(message);
     
     
     Transport transport=mailSession.getTransport("smtp");
     transport.connect(host,user,pass);
     transport.sendMessage(msg, msg.getAllRecipients());
     //JOptionPane.showMessageDialog(rootPane, "sending...");
     transport.close();
     JOptionPane.showMessageDialog(rootPane, "otp was successfully send to "+email.getText());
     //count++;
     //status.setText("");
//System.out.println("message send successfully....");
         //JOptionPane.showMessageDialog(rootPane, "successfully send");
     
     //status.setText("successfully send");
      }
      catch (Exception e) 
      {
          //System.out.println(e.getMessage()+" asif");
          JOptionPane.showMessageDialog(rootPane, e.getMessage());
          JOptionPane.showMessageDialog(rootPane, "please check your internet connection");
      }
    }
    public void sendOtp()
    {
        
        for(int i=0;i<6;i++)
        {
            OTP[i]=otp_.charAt(r.nextInt(otp_.length()));
            //otp.setText(OTP.toString());
            temp+=OTP[i];
        }
        
        //System.out.println(OTP);
        //msg1.setText(temp);
    }
    public void getAccount()
    {
        try
        {
            ps=con.prepareStatement("select * from add_user where name=?");
            ps.setString(1, user.getText());
            rs=ps.executeQuery();
            if(rs.next())
            {
                u=rs.getString("name");
                m=rs.getString("email");
            }
            else
            {
                //JOptionPane.showMessageDialog(rootPane, "mismatch");
            }
            rs.close();
            ps.close();
            //JOptionPane.showMessageDialog(rootPane, u+" "+m);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    public void resetPassword()
    {
        try
        {
            PreparedStatement ps;
            ps=con.prepareStatement("UPDATE add_user SET password='"+pass.getText()+"' WHERE name='"+u+"'");
            ps.execute();
            ps.close();
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
    }
    public void deleteOtp()
    {
        try
        {
            st=con.createStatement();
            st.executeUpdate("DELETE FROM otp_ WHERE sno="+"1");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    public void setOtp()
    {
        try
        {
        ps=con.prepareStatement("insert into otp_ values(?,?)");
        ps.setString(1, "1");
        ps.setString(2, temp);
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    public void getOtp()
    {
        try
        {
            ps=con.prepareStatement("select * from otp_ where sno=?");
            ps.setString(1, "1");
            rs=ps.executeQuery();
            if(rs.next())
            {
                temp_otp=rs.getString("otp");
            }
            rs.close();
            ps.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
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
            java.util.logging.Logger.getLogger(Otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new Otp().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
}

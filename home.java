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
import java.util.Calendar;
import java.util.GregorianCalendar;

public class home extends JFrame implements ActionListener
{
    JPanel med,sup,bill,set,hpanel,head,min,close,title;
    Button login;
    JLabel headl,minl,closel,l,medicine,supplier,billing,setting,addmed,searchmed,viewmed,deletemed,updatemed
           ,addsup,viewsup,deletesup,updatesup,searchsup,addbill,viewbill,password,adduser,viewuser,about,updateuser,deleteuser;
    JLabel aml,sml,vml,dml,uml,asl,ssl,vsl,dsl,usl,abl,vbl,titlel,dr,pl,aul,vul,al,s1,s2,User_Login,uul,dul,date,time,dcs,mline,sline,setline,bline,mline2,sline2,setline2,bline2;
    JTextField usr;
    JPasswordField pass;
    JSeparator menusp;
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    //Date d=new Date();
    //orange 255, 85, 30
    // sky blue 149, 187, 255
   // dark blue 26, 108, 255 
   //fb 65, 94, 155
    Color color=new Color(65, 94, 155);
    String u,p,login_;
    int x,y;        
    String all="addeditviewsearchdelete";
    String add="add";
    String edit="edit";
    String view="view";
    String search="search";
    String delete="delete";
    String sales="sale";
    String saleview="saleview";
    String billall="salesaleview";
    
    String addeditviewsearch="addeditviewsearch";
    String addeditsearchdelete="addeditsearchdelete";
    String addeditviewdelete="addeditviewdelete";
    String addviewsearchdelete="addviewsearchdelete";
    String editviewsearchdelete="editviewsearchdelete";
    
    String addeditview="addeditview";
    String addeditsearch="addeditsearch";
    String addeditdelete="addeditdelete";
    String addviewsearch="addviewsearch";
    String addviewdelete="addviewdelete";
    String addsearchdelete="addsearchdelete";
    
    String editviewsearch="editviewsearch";
    String editviewdelete="editviewdelete";
    String editsearchdelete="editsearchdelete";
    
    String viewsearchdelete="viewsearchdelete";
    
    String addedit="addedit";
    String addview="addview";
    String addsearch="addsearch";
    String adddelete="adddelete";
            
    String editview="editview";
    String editsearch="editsearch";
    String editdelete="editdelete";
    
    String viewsearch="viewsearch";
    String viewdelete="viewdelete";
    
    String searchdelete="searchdelete";
    
    String medicine_permission,supplier_permission,sale_permission;
    
    String setmenu;
    
    Timer timer=new Timer(100, new TimeAnimate());
    Calendar cal=new GregorianCalendar();
    
    int day=cal.get(Calendar.DAY_OF_MONTH);
    int month=cal.get(Calendar.MONTH)+1;
    int year=cal.get(Calendar.YEAR);
    
    int hour=cal.get(Calendar.HOUR);
    int minute=cal.get(Calendar.MINUTE);
    int second=cal.get(Calendar.SECOND);
    int tt=0;
    int count=0;
    public home()
    {
        super("Home");
        setBounds(0,0,1360,725);
        setLayout(null);
        //setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dcsicon.jpg")));
        
        timer.start();
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:medical_software.db");
            
            
            
            st=con.createStatement();
            rs=st.executeQuery("select * from user_login");
            while(rs.next())
            {
                medicine_permission=rs.getString("mpermission");
                supplier_permission=rs.getString("spermission");
                sale_permission=rs.getString("bpermission");
                //System.out.print(" "+medicine_permission+" "+supplier_permission+" "+
                        //sale_permission);
                
            }
            rs.close();
            st.close();
            
            st=con.createStatement();
            rs=st.executeQuery("select * from menu");
            while(rs.next())
            {
                setmenu=rs.getString("menus");
                
            }
            rs.close();
            st.close();
            
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
        
        
        menusp=new JSeparator();
        menusp.setBounds(250, 30, 10, getHeight()-23);
        menusp.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(menusp);
        
        getLoginUser();
        User_Login=new JLabel(login_);
        User_Login.setBounds(getWidth()-250, 120, 150, 30);
        User_Login.setFont(new Font("Segoe UI",Font.PLAIN,24));
        User_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/logout.png"))); 
        User_Login.setForeground(Color.WHITE);
        User_Login.setToolTipText("Logout "+login_);
        User_Login.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        add(User_Login);
        
        titlel=new JLabel("MEDICAL BILLING SYSTEM");
        titlel.setBounds(250, 30, getWidth()-250, 120);
        titlel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlel.setFont(new Font("Segoe UI",Font.BOLD,50));
        titlel.setBackground(color);
        titlel.setForeground(Color.WHITE);
        add(titlel);
        title=new JPanel();
        title.setBounds(250, 30, getWidth(), 120);
        title.setBackground(color);
        add(title);
        
        date=new JLabel(Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year));
        date.setBounds(250, 150, 200, 50);
        date.setFont(new Font("Times New Roman",Font.BOLD,40));
        date.setForeground(color);
        add(date);        
        
        time=new JLabel(Integer.toString(hour)+"/"+Integer.toString(minute)+"/"+Integer.toString(second));
        time.setBounds(getWidth()-150, 150, 200, 50);
        time.setFont(new Font("Times New Roman",Font.BOLD,40));
        time.setForeground(color);
        add(time);
        
        dcs=new JLabel("DCS(DREAM CYBER SOLUTIONS)");
        dcs.setBounds(260, 600, 200, 30);
        dcs.setForeground(color);
        dcs.setFont(new Font("Segoe UI",Font.BOLD,13));
        add(dcs);
        
        s1=new JLabel("medicine-M | supplier-S | billing-B | setting-T | add-F1| view-F2 | delete-F3 | update-F4 | search-F5 |");
        s1.setBounds(300, 660, getWidth(), 30);
        s1.setForeground(color);
        s1.setFont(new Font("Segoe UI",Font.PLAIN,23));
        add(s1);
        
        s2=new JLabel("sale-F1 | view bill-F2 | add user-F1| view-F2 | password-F3 | update-F4 | delete user-F5 | about-F6 | ");
        s2.setBounds(300, 690, getWidth(), 30);
        s2.setForeground(color);
        s2.setFont(new Font("Segoe UI",Font.PLAIN,23));
        add(s2);
        
        dr=new JLabel();
        dr.setBounds(60, 30, 96, 96);
        dr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/doctor.png"))); 
        add(dr);
        
        medicine=new JLabel("Medicine");
        medicine.setBounds(0, 280, 250, 40);
        medicine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        medicine.setFont(new Font("Segoe UI",Font.PLAIN,24));
        medicine.setForeground(color);
        add(medicine);
        
        supplier=new JLabel("Supplier");
        supplier.setBounds(0, 320, 250, 40);
        supplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplier.setFont(new Font("Segoe UI",Font.PLAIN,24));
        supplier.setForeground(color);
        add(supplier);
        
        billing=new JLabel("Billing");
        billing.setBounds(0, 360, 250, 40);
        billing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        billing.setFont(new Font("Segoe UI",Font.PLAIN,24));
        billing.setForeground(color);
        add(billing);
        
        setting=new JLabel("Setting");
        setting.setBounds(0, 400, 250, 40);
        setting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setting.setFont(new Font("Segoe UI",Font.PLAIN,24));
        setting.setForeground(color);
        add(setting);
        //---finish main menu---//
        
        addmed=new JLabel();
        addmed.setBounds(500, 200, 100, 130);
        addmed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/med1.png"))); 
        addmed.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        addmed.setVisible(false);
        add(addmed);
        aml=new JLabel("Add Medicine");
        aml.setBounds(500, 300, 100, 30);
        aml.setFont(new Font("",Font.BOLD,12));
        aml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aml.setForeground(color);
        aml.setVisible(false);
        add(aml);
        
        
        viewmed=new JLabel();
        viewmed.setBounds(700, 200, 100, 130);
        viewmed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medview.png"))); 
        viewmed.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        viewmed.setVisible(false);
        add(viewmed);
        vml=new JLabel("View Medicine");
        vml.setBounds(700, 300, 100, 30);
        vml.setFont(new Font("",Font.BOLD,12));
        vml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vml.setForeground(color);
        vml.setVisible(false);
        add(vml);
        
        deletemed=new JLabel();
        deletemed.setBounds(900, 200, 100, 130);
        deletemed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/meddelete.png"))); 
        deletemed.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        deletemed.setVisible(false);
        add(deletemed);
        dml=new JLabel("delete Medicine");
        dml.setBounds(900, 300, 100, 30);
        dml.setFont(new Font("",Font.BOLD,12));
        dml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dml.setForeground(color);
        dml.setVisible(false);
        add(dml);
        
        updatemed=new JLabel();
        updatemed.setBounds(500, 350, 100, 130);
        updatemed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medupdate.png"))); 
        updatemed.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        updatemed.setVisible(false);
        add(updatemed);
        uml=new JLabel("Update Medicine");
        uml.setBounds(500, 450, 100, 30);
        uml.setFont(new Font("",Font.BOLD,12));
        uml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uml.setForeground(color);
        uml.setVisible(false);
        add(uml);
        
        searchmed=new JLabel();
        searchmed.setBounds(700, 350, 100, 130);
        searchmed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medsearch.png"))); 
        searchmed.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        searchmed.setVisible(false);
        add(searchmed);
        sml=new JLabel("Search Medicine");
        sml.setBounds(700, 450, 100, 30);
        sml.setFont(new Font("",Font.BOLD,12));
        sml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sml.setForeground(color);
        sml.setVisible(false);
        add(sml);
        
        //---finish medicine menu---//
        
        
        addsup=new JLabel();
        addsup.setBounds(500, 200, 100, 130);
        addsup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/supadd.png"))); 
        addsup.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        addsup.setVisible(false);
        add(addsup);
        asl=new JLabel("Add Supplier");
        asl.setBounds(500, 300, 100, 30);
        asl.setFont(new Font("",Font.BOLD,12));
        asl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asl.setForeground(color);
        asl.setVisible(false);
        add(asl);
        
        viewsup=new JLabel();
        viewsup.setBounds(700, 200, 100, 130);
        viewsup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medview.png"))); 
        viewsup.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        viewsup.setVisible(false);
        add(viewsup);
        vsl=new JLabel("View Supplier");
        vsl.setBounds(700, 300, 100, 30);
        vsl.setFont(new Font("",Font.BOLD,12));
        vsl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vsl.setForeground(color);
        vsl.setVisible(false);
        add(vsl);
        
        deletesup=new JLabel();
        deletesup.setBounds(900, 200, 100, 130);
        deletesup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/meddelete.png"))); 
        deletesup.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        deletesup.setVisible(false);
        add(deletesup);
        dsl=new JLabel("Delete Supplier");
        dsl.setBounds(900, 300, 100, 30);
        dsl.setFont(new Font("",Font.BOLD,12));
        dsl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dsl.setForeground(color);
        dsl.setVisible(false);
        add(dsl);
        
        updatesup=new JLabel();
        updatesup.setBounds(500, 350, 100, 130);
        updatesup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medupdate.png"))); 
        updatesup.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        updatesup.setVisible(false);
        add(updatesup);
        usl=new JLabel("Update Supplier");
        usl.setBounds(500, 450, 100, 30);
        usl.setFont(new Font("",Font.BOLD,12));
        usl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usl.setForeground(color);
        usl.setVisible(false);
        add(usl);
        
        searchsup=new JLabel();
        searchsup.setBounds(700, 350, 100, 130);
        searchsup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medsearch.png"))); 
        searchsup.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        searchsup.setVisible(false);
        add(searchsup);
        ssl=new JLabel("Search Supplier");
        ssl.setBounds(700, 450, 100, 30);
        ssl.setFont(new Font("",Font.BOLD,12));
        ssl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ssl.setForeground(color);
        ssl.setVisible(false);
        add(ssl);
        //---finish supplier menu---//
        
        addbill=new JLabel();
        addbill.setBounds(500, 200, 100, 130);
        addbill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/bill.png"))); 
        addbill.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        addbill.setVisible(false);
        add(addbill);
        abl=new JLabel("Sale");
        abl.setBounds(500, 300, 100, 30);
        abl.setFont(new Font("",Font.BOLD,12));
        abl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        abl.setForeground(color);
        abl.setVisible(false);
        add(abl);
        
        
        viewbill=new JLabel();
        viewbill.setBounds(700, 200, 100, 130);
        viewbill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/dailybill.png"))); 
        viewbill.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        viewbill.setVisible(false);
        add(viewbill);
        vbl=new JLabel("View Bill Data");
        vbl.setBounds(700, 300, 100, 30);
        vbl.setFont(new Font("",Font.BOLD,12));
        vbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vbl.setForeground(color);
        vbl.setVisible(false);
        add(vbl);
        
        //---finish billing menu---//
        
        adduser=new JLabel();
        adduser.setBounds(500, 200, 100, 130);
        adduser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/adduser.png"))); 
        adduser.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        adduser.setVisible(false);
        add(adduser);
        aul=new JLabel("Add User");
        aul.setBounds(500, 300, 100, 30);
        aul.setFont(new Font("",Font.BOLD,12));
        aul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aul.setForeground(color);
        aul.setVisible(false);
        add(aul);
        
        
        viewuser=new JLabel();
        viewuser.setBounds(700, 200, 100, 130);
        viewuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/userlist.png"))); 
        viewuser.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        viewuser.setVisible(false);
        add(viewuser);
        vul=new JLabel("View User List");
        vul.setBounds(700, 300, 100, 30);
        vul.setFont(new Font("",Font.BOLD,12));
        vul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vul.setForeground(color);
        vul.setVisible(false);
        add(vul);
        
        password=new JLabel();
        password.setBounds(900, 200, 100, 130);
        password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/pass.png"))); 
        password.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        password.setVisible(false);
        add(password);
        pl=new JLabel("Password");
        pl.setBounds(900, 300, 100, 30);
        pl.setFont(new Font("",Font.BOLD,12));
        pl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pl.setForeground(color);
        pl.setVisible(false);
        add(pl);
        
        updateuser=new JLabel();
        updateuser.setBounds(500, 350, 100, 130);
        updateuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/medupdate.png"))); 
        updateuser.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        updateuser.setVisible(false);
        add(updateuser);
        uul=new JLabel("Update User");
        uul.setBounds(500, 450, 100, 30);
        uul.setFont(new Font("",Font.BOLD,12));
        uul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uul.setForeground(color);
        uul.setVisible(false);
        add(uul);
        
        deleteuser=new JLabel();
        deleteuser.setBounds(700, 350, 100, 130);
        deleteuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/meddelete.png"))); 
        deleteuser.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        deleteuser.setVisible(false);
        add(deleteuser);
        dul=new JLabel("Delete User");
        dul.setBounds(700, 450, 100, 30);
        dul.setFont(new Font("",Font.BOLD,12));
        dul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dul.setForeground(color);
        dul.setVisible(false);
        add(dul);
        
        about=new JLabel();
        about.setBounds(900, 350, 100, 130);
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/about2.png"))); 
        about.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        about.setVisible(false);
        add(about);
        al=new JLabel("About");
        al.setBounds(900, 450, 100, 30);
        al.setFont(new Font("",Font.BOLD,12));
        al.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        al.setForeground(color);
        al.setVisible(false);
        add(al);
        
        //---finish setting menu---//
        
                mline=new JLabel();
                mline.setBounds(240, 280, 11, 40);
                mline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/mline.png")));
                mline.setVisible(false);
                add(mline);
                sline=new JLabel();
                sline.setBounds(240, 320, 11, 40);
                sline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/mline.png")));
                sline.setVisible(false);
                add(sline);
                setline=new JLabel();
                setline.setBounds(240, 400, 11, 40);
                setline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/mline.png")));
                setline.setVisible(false);
                add(setline);
                bline=new JLabel();
                bline.setBounds(240, 360, 11, 40);
                bline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/mline.png")));
                bline.setVisible(false);
                add(bline);
        
                mline2=new JLabel();
                mline2.setBounds(0, 280, 11, 40);
                mline2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/mline.png")));
                mline2.setVisible(false);
                //add(mline2);
                sline2=new JLabel();
                sline2.setBounds(0, 320, 11, 40);
                sline2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/mline.png")));
                sline2.setVisible(false);
                //add(sline2);
                setline2=new JLabel();
                setline2.setBounds(0, 400, 11, 40);
                setline2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/mline.png")));
                setline2.setVisible(false);
                //add(setline2);
                bline2=new JLabel();
                bline2.setBounds(0, 360, 11, 40);
                bline2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalsoftwre/com/dcs/project/img/mline.png")));
                bline2.setVisible(false);
                //add(bline2);
                
        med=new JPanel();
        med.setBounds(0, 280, 250, 40);
        med.setBackground(Color.WHITE);
        add(med);
        
        sup=new JPanel();
        sup.setBounds(0, 320, 250, 40);
        sup.setBackground(Color.WHITE);
        add(sup);
        
        bill=new JPanel();
        bill.setBounds(0, 360, 250, 40);
        bill.setBackground(Color.WHITE);
        add(bill);
        
        set=new JPanel();
        set.setBounds(0, 400, 250, 40);
        set.setBackground(Color.WHITE);
        add(set);
        
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
        
        headl=new JLabel("  Home");
        headl.setBounds(0, 0, getWidth(), 30);
        headl.setBackground(Color.WHITE);
        add(headl);
        
        
        head=new JPanel();
        head.setBounds(0, 0, getWidth(), 30);
        head.setBackground(Color.WHITE);
        add(head);
        
        hpanel=new JPanel();
        hpanel.setBounds(0,0,250,getHeight());
        hpanel.setBackground(Color.WHITE);
        add(hpanel);
        
        hpanel=new JPanel();
        hpanel.setBounds(0,0,getWidth(),getHeight());
        //hpanel.setBackground(Color.WHITE);
        add(hpanel);
        
        
        setBounds(0,0,1360,705);
        setBounds(0,0,1360,725);
        
        
        
        
        User_Login.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                logOut();
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                int k=ke.getKeyCode();
                if(k==KeyEvent.VK_M)
                {
                    pointMenu(1);
                    setmenu="med";
                    setMenu();
                    supplierMenu(false);
                    billingMenu(false);
                    settingMenu(false);
                    medicineMenu(true);
                    repaint();
                }
                else if(k==KeyEvent.VK_S)
                {
                    pointMenu(2);
                    setmenu="sup";
                    setMenu();
                    supplierMenu(true);
                    billingMenu(false);
                    settingMenu(false);
                    medicineMenu(false);
                    repaint();
                }
                else if(k==KeyEvent.VK_B)
                {
                    pointMenu(3);
                    setmenu="bill";
                    setMenu();
                    supplierMenu(false);
                    billingMenu(true);
                    settingMenu(false);
                    medicineMenu(false);
                    repaint();
                }
                else if(k==KeyEvent.VK_T)
                {
                    pointMenu(4);
                    setmenu="set";
                    setMenu();
                    supplierMenu(false);
                    billingMenu(false);
                    settingMenu(true);
                    medicineMenu(false);
                    repaint();
                }
                //finish main menu shortcut
                
                else if(k==KeyEvent.VK_F1 && addmed.isVisible()==true && addmed.isEnabled()==true && aml.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new addmedicine().setVisible(true);
                    //System.exit(0);
                }
                else if(k==KeyEvent.VK_F2 && viewmed.isVisible()==true && viewmed.isEnabled()==true && vml.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new medlist().setVisible(true);
                    //System.exit(0);
                }
                else if(k==KeyEvent.VK_F3 && deletemed.isVisible()==true && deletemed.isEnabled()==true && dml.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new meddelete().setVisible(true);
                }
                else if(k==KeyEvent.VK_F4 && updatemed.isVisible()==true && updatemed.isEnabled()==true && uml.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new medupdate().setVisible(true);
                }
                else if(k==KeyEvent.VK_F5 && searchmed.isVisible()==true && searchmed.isEnabled()==true && sml.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new search().setVisible(true);
                }
                //finish medicine menu
                
                else if(k==KeyEvent.VK_F1 && addsup.isVisible()==true && addsup.isEnabled()==true && asl.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new addsupplier().setVisible(true);
                    //System.exit(0);
                }
                else if(k==KeyEvent.VK_F2 && viewsup.isVisible()==true && viewsup.isEnabled()==true && vsl.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new suplist().setVisible(true);
                    //System.exit(0);
                }
                else if(k==KeyEvent.VK_F3 && deletesup.isVisible()==true && deletesup.isEnabled()==true && dsl.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new supdelete().setVisible(true);
                }
                else if(k==KeyEvent.VK_F4 && updatesup.isVisible()==true && updatesup.isEnabled()==true && usl.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new supupdate().setVisible(true);
                }
                else if(k==KeyEvent.VK_F5 && searchsup.isVisible()==true && searchsup.isEnabled()==true && ssl.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new supsearch().setVisible(true);
                }
                //finish supplier menu
                
                else if(k==KeyEvent.VK_F1 && addbill.isVisible()==true && addbill.isEnabled()==true && abl.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new billcreate().setVisible(true);
                    //System.exit(0);
                }
                else if(k==KeyEvent.VK_F2 && viewbill.isVisible()==true && viewbill.isEnabled()==true && vbl.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new dailydata().setVisible(true);
                    //System.exit(0);
                }
                //finish billing menu
                
                else if(k==KeyEvent.VK_F1 && adduser.isVisible()==true && adduser.isEnabled()==true && aul.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new AddUser().setVisible(true);
                    //System.exit(0);
                }
                else if(k==KeyEvent.VK_F2 && viewuser.isVisible()==true && viewuser.isEnabled()==true && vul.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new userlist().setVisible(true);
                    //System.exit(0);
                }
                else if(k==KeyEvent.VK_F3 && password.isVisible()==true && password.isEnabled()==true && pl.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new reset_password().setVisible(true);
                }
                else if(k==KeyEvent.VK_F4 && updateuser.isVisible()==true && updateuser.isEnabled()==true && uul.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new userupdate().setVisible(true);
                }
                else if(k==KeyEvent.VK_F5 && deleteuser.isVisible()==true && deleteuser.isEnabled()==true && dul.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new userdelete().setVisible(true);
                }
                else if(k==KeyEvent.VK_F6 && about.isVisible()==true && about.isEnabled()==true && al.isEnabled()==true)
                {
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new about().setVisible(true);
                }
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent ke)
            {
                char k=ke.getKeyChar();
                if(k==KeyEvent.VK_ESCAPE)
                {
                    try
                {
                    //Class.forName("com.mysql.jdbc.Driver");
                    //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
                    //Class.forName("org.sqlite.JDBC");
                    //con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\AsiThou\\Documents\\NetBeansProjects\\medicalsoftwre\\src\\medicalsoftwre\\com\\dcs\\project\\data base\\medical_software.db");
            
            
                    
                    st=con.createStatement();
                    st.executeUpdate("DELETE FROM user_login WHERE sno=1");
                    st.close();
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new login().setVisible(true);
                    
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
                    
                }
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent we)
            {
                try
                {
                    //Class.forName("com.mysql.jdbc.Driver");
                    //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
                    //Class.forName("org.sqlite.JDBC");
                    //con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\AsiThou\\Documents\\NetBeansProjects\\medicalsoftwre\\src\\medicalsoftwre\\com\\dcs\\project\\data base\\medical_software.db");
            
            
                    
                    st=con.createStatement();
                    st.executeUpdate("DELETE FROM user_login WHERE sno=1");
                    st.close();
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    System.exit(0);
                    
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
                
            }
        });
        medicine.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                med.setBackground(Color.lightGray);
                medicine.setFont(new Font("Segoe UI",Font.BOLD,30));
                repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                med.setBackground(Color.WHITE);
                medicine.setFont(new Font("Segoe UI",Font.PLAIN,24));
                repaint();
            }
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                pointMenu(1);
                setmenu="med";
                setMenu();
                supplierMenu(false);
                billingMenu(false);
                settingMenu(false);
                medicineMenu(true);
                repaint();
            }
        });
        addmed.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(addmed.isEnabled()==true && aml.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new addmedicine().setVisible(true);
                }
            }
        });
        viewmed.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(viewmed.isEnabled()==true && vml.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new medlist().setVisible(true);
                }
            }
        });
        deletemed.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(deletemed.isEnabled()==true && dml.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new meddelete().setVisible(true);
                }
            }
        });
        updatemed.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(updatemed.isEnabled()==true && uml.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new medupdate().setVisible(true);
                }
            }
        });
        searchmed.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(searchmed.isEnabled()==true && sml.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new search().setVisible(true);
                }
            }
        });
        //--finish medicine menus---//

        
        supplier.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                sup.setBackground(Color.lightGray);
                supplier.setFont(new Font("Segoe UI",Font.BOLD,30));
                repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                sup.setBackground(Color.WHITE);
                supplier.setFont(new Font("Segoe UI",Font.PLAIN,24));
                repaint();
            }
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                pointMenu(2);
                setmenu="sup";
                setMenu();
                medicineMenu(false);
                billingMenu(false);
                settingMenu(false);
                supplierMenu(true);
                repaint();
            }
            
        });
        
        addsup.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(addsup.isEnabled()==true && asl.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new addsupplier().setVisible(true);
                }
            }
        });
        viewsup.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(viewsup.isEnabled()==true && vsl.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new suplist().setVisible(true);
                }
            }
        });
        deletesup.addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseClicked(java.awt.event.MouseEvent me)
                {
                if(deletesup.isEnabled()==true && dsl.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new supdelete().setVisible(true);
                }
                }
        });
        updatesup.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(updatesup.isEnabled()==true && usl.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new supupdate().setVisible(true);
                }
            }
        });
        searchsup.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(searchsup.isEnabled()==true && ssl.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new supsearch().setVisible(true);
                }
            }
        });
        //---finnsh supplier menu---//
        
        billing.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                bill.setBackground(Color.lightGray);
                billing.setFont(new Font("Segoe UI",Font.BOLD,30));
                repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                bill.setBackground(Color.WHITE);
                billing.setFont(new Font("Segoe UI",Font.PLAIN,24));
                repaint();
            }
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                pointMenu(3);
                setmenu="bill";
                setMenu();
                medicineMenu(false);
                supplierMenu(false);
                settingMenu(false);
                billingMenu(true);
                repaint();
            }
        });
        addbill.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(addbill.isEnabled()==true && abl.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                setVisible(false);
                new billcreate().setVisible(true);
        
               }
            } 
            
        });
        
        viewbill.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                if(viewbill.isEnabled()==true && vbl.isEnabled()==true)
               {
                try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}   
                setVisible(false);
                new dailydata().setVisible(true);
                }
            }
        });

        //---finish billing menu---//
        
        setting.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent me)
            {
                set.setBackground(Color.lightGray);
                setting.setFont(new Font("Segoe UI",Font.BOLD,30));
                repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent me)
            {
                set.setBackground(Color.WHITE);
                setting.setFont(new Font("Segoe UI",Font.PLAIN,24));
                repaint();
            }
            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                pointMenu(4);
                setmenu="set";
                setMenu();
                medicineMenu(false);
                supplierMenu(false);
                billingMenu(false);
                settingMenu(true);
                repaint();
            }
        });
        
        adduser.addMouseListener(new java.awt.event.MouseAdapter() {

           public void mouseClicked(java.awt.event.MouseEvent me)
           {
               if(adduser.isEnabled()==true && aul.isEnabled()==true)
               {
               try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}    
               setVisible(false);
               new AddUser().setVisible(true);
               }
           }
        });
        viewuser.addMouseListener(new java.awt.event.MouseAdapter() {

           public void mouseClicked(java.awt.event.MouseEvent me)
           {
               if(viewuser.isEnabled()==true && vul.isEnabled()==true)
               {
               try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}    
               setVisible(false);
               new userlist().setVisible(true);
               }
           }
        });
        password.addMouseListener(new java.awt.event.MouseAdapter() {

           public void mouseClicked(java.awt.event.MouseEvent me)
           {
               if(password.isEnabled()==true && pl.isEnabled()==true)
               {
               try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}    
               setVisible(false);
               new reset_password().setVisible(true);
               }
           }
        });
        updateuser.addMouseListener(new java.awt.event.MouseAdapter() {

           public void mouseClicked(java.awt.event.MouseEvent me)
           {
               if(updateuser.isEnabled()==true && uul.isEnabled()==true)
               {
               try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}    
               setVisible(false);
               new userupdate().setVisible(true);
               }
           }
        });
        deleteuser.addMouseListener(new java.awt.event.MouseAdapter() {

           public void mouseClicked(java.awt.event.MouseEvent me)
           {
               if(deleteuser.isEnabled()==true && dul.isEnabled()==true)
               {
               try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}    
               setVisible(false);
               new userdelete().setVisible(true);
               }
           }
        });
        about.addMouseListener(new java.awt.event.MouseAdapter() {

           public void mouseClicked(java.awt.event.MouseEvent me)
           {
               if(about.isEnabled()==true && al.isEnabled()==true)
               {
                   try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                   setVisible(false);
                   new about().setVisible(true);
               }
           }
        });
        //---finish setting menu---//
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
            
                    //Class.forName("org.sqlite.JDBC");
                    //con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\AsiThou\\Documents\\NetBeansProjects\\medicalsoftwre\\src\\medicalsoftwre\\com\\dcs\\project\\data base\\medical_software.db");
            
            
                    
                    st=con.createStatement();
                    st.executeUpdate("DELETE FROM user_login WHERE sno=1");
                    st.close();
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    System.exit(0);
                    
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" error");}
                
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
        
        
        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowOpened(java.awt.event.WindowEvent we)
            {
                if(setmenu.equals("med"))
                {
                    pointMenu(1);
                    supplierMenu(false);
                    billingMenu(false);
                    settingMenu(false);
                    medicineMenu(true);
                    //repaint();
                }
        else if(setmenu.equals("sup"))
        {
            pointMenu(2);
            supplierMenu(true);
            billingMenu(false);
            settingMenu(false);
            medicineMenu(false);
            repaint();
        }
        else if(setmenu.equals("bill"))
        {
            pointMenu(3);
            supplierMenu(false);
            billingMenu(true);
            settingMenu(false);
            medicineMenu(false);
            repaint();
        }
        else if(setmenu.equals("set"))
        {
            pointMenu(4);
            supplierMenu(false);
            billingMenu(false);
            settingMenu(true);
            medicineMenu(false);
            repaint();
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane,setmenu);
        }
            }
        });
        
        
        
    }
    public void pointMenu(int y)
    {
        switch(y)
        {
            case 1:
            {    
                mline.setVisible(true);
                sline.setVisible(false);
                bline.setVisible(false);
                setline.setVisible(false);
                
                mline2.setVisible(true);
                sline2.setVisible(false);
                bline2.setVisible(false);
                setline2.setVisible(false);
                
            }
            break;
            case 2:
            {
                mline.setVisible(false);
                sline.setVisible(true);
                bline.setVisible(false);
                setline.setVisible(false);
                
                mline2.setVisible(false);
                sline2.setVisible(true);
                bline2.setVisible(false);
                setline2.setVisible(false);
            }
            break;
            case 4:
            {   
                mline.setVisible(false);
                sline.setVisible(false);
                bline.setVisible(false);
                setline.setVisible(true);
                
                mline2.setVisible(false);
                sline2.setVisible(false);
                bline2.setVisible(false);
                setline2.setVisible(true);
            }   
            break;
            case 3:
            {
                mline.setVisible(false);
                sline.setVisible(false);
                bline.setVisible(true);
                setline.setVisible(false);
                
                mline2.setVisible(false);
                sline2.setVisible(false);
                bline2.setVisible(true);
                setline2.setVisible(false);
            }
            break;
        }
    }
    public void setMenu()
    {
        String query="UPDATE menu SET menus='"+setmenu+"' WHERE sno=1";
        try
        {
            PreparedStatement ps=con.prepareStatement(query);
            ps.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    
    public class TimeAnimate implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            
            //cal=new g
            cal=new GregorianCalendar();
            //day=cal.get(Calendar.DAY_OF_MONTH);
            //month=cal.get(Calendar.MONTH)+1;
            //year=cal.get(Calendar.YEAR);
    
            hour=cal.get(Calendar.HOUR);
            minute=cal.get(Calendar.MINUTE);
            second=cal.get(Calendar.SECOND);
            
            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            
            time.setText(Integer.toString(hour)+":"+Integer.toString(minute)+":"+Integer.toString(second));    
            date.setText(Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year));
            
            //time.setText(Integer.toString(cal.get(Calendar.HOUR))+"/"+Integer.toString(cal.get(Calendar.MINUTE))+"/"+Integer.toString(cal.get(Calendar.SECOND)));
            
            if(count>=0 && count<=950)
            {
                time.setBounds(getWidth()-150-tt, 150, 200, 50);
                date.setBounds(250+tt, 150, 200, 50);
                dcs.setBounds(260+tt, 600, 200, 30);
                tt+=10;
            }
            if(count>=1900)
            {
                count=0;
            }
            else if(count>=950 && count<=1900)
            {
                time.setBounds(getWidth()-150-tt, 150, 200, 50);
                date.setBounds(250+tt, 150, 200, 50);
                dcs.setBounds(260+tt, 600, 200, 30);
                tt-=10;
            }
                
                timer.setDelay(150);
                count+=10;
            //tt+=10;
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        
    }
    public void logOut()
    {
        try
                {
                    //Class.forName("com.mysql.jdbc.Driver");
                    //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
                    //Class.forName("org.sqlite.JDBC");
                    //con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\AsiThou\\Documents\\NetBeansProjects\\medicalsoftwre\\src\\medicalsoftwre\\com\\dcs\\project\\data base\\medical_software.db");

                    st=con.createStatement();
                    st.executeUpdate("DELETE FROM user_login WHERE sno="+"1");
                    st.close();
                    try{con.close();}catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" Error");}
                    setVisible(false);
                    new login().setVisible(true);
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage()+" error");}
    }
    public void getLoginUser()
    {
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            
            //Class.forName("org.sqlite.JDBC");
            //con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\AsiThou\\Documents\\NetBeansProjects\\medicalsoftwre\\src\\medicalsoftwre\\com\\dcs\\project\\data base\\medical_software.db");
            
            
            
            Statement ps;
            ps=con.createStatement();
            rs=ps.executeQuery("select * from user_login");
            while(rs.next())
            {
                login_=rs.getString("name");
            }
            rs.close();
            ps.close();
            
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
    }
    public void medicineMenu(boolean status)
    {
        
        if(all.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            deletemed.setVisible(status);
            dml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);   
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
            
        }
        else if(addeditviewsearch.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
            
        }
        else if(addeditviewdelete.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(addviewsearchdelete.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
            
        }
        else if(addeditsearchdelete.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
            
        }
        else if(editviewsearchdelete.equals(medicine_permission))
        {
            viewmed.setVisible(status);
            vml.setVisible(status);
            deletemed.setVisible(status);
            dml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
            
        }
        else if(addeditview.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(addeditsearch.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        else if(addeditdelete.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(addviewsearch.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
            
        }
        else if(addviewdelete.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
            
        }
        else if(addsearchdelete.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(true);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
            
        }
        else if(editviewsearch.equals(medicine_permission))
        {
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        else if(editviewdelete.equals(medicine_permission))
        {
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(editsearchdelete.equals(medicine_permission))
        {
            viewmed.setVisible(status);
            vml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        else if(viewsearchdelete.equals(medicine_permission))
        {
            viewmed.setVisible(status);
            vml.setVisible(status);
            deletemed.setVisible(status);
            dml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        else if(addedit.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(addview.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(addsearch.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        else if(adddelete.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            deletemed.setVisible(status);
            dml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        
        
        else if(editview.equals(medicine_permission))
        {
            updatemed.setVisible(status);
            uml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
            
        }
        else if(editsearch.equals(medicine_permission))
        {
            updatemed.setVisible(status);
            uml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        else if(editdelete.equals(medicine_permission))
        {
            deletemed.setVisible(status);
            dml.setVisible(status);
            updatemed.setVisible(status);
            uml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        
        
        else if(viewsearch.equals(medicine_permission))
        {
            viewmed.setVisible(status);
            vml.setVisible(status);
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        else if(viewdelete.equals(medicine_permission))
        {
            deletemed.setVisible(status);
            dml.setVisible(status);
            viewmed.setVisible(status);
            vml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        
        
        else if(searchdelete.equals(medicine_permission))
        {
            searchmed.setVisible(status);
            sml.setVisible(status);
            deletemed.setVisible(status);
            dml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        
        
        else if(add.equals(medicine_permission))
        {
            addmed.setVisible(status);
            aml.setVisible(status);
            
            addmed.setEnabled(true);
            aml.setEnabled(true);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(edit.equals(medicine_permission))
        {
            updatemed.setVisible(status);
            uml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(true);
            uml.setEnabled(true);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(view.equals(medicine_permission))
        {
            viewmed.setVisible(status);
            vml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(true);
            vml.setEnabled(true);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            setVisible_(status);
        }
        else if(search.equals(medicine_permission))
        {
            searchmed.setVisible(status);
            sml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(true);
            sml.setEnabled(true);
            setVisible_(status);
        }
        else if(delete.equals(medicine_permission))
        {
            deletemed.setVisible(status);
            dml.setVisible(status);
            
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(true);
            dml.setEnabled(true);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
        
            setVisible_(status);
        }
        else if(!(all.equals(medicine_permission)))
        {
            addmed.setEnabled(false);
            aml.setEnabled(false);
            viewmed.setEnabled(false);
            vml.setEnabled(false);
            deletemed.setEnabled(false);
            dml.setEnabled(false);
            updatemed.setEnabled(false);
            uml.setEnabled(false);
            searchmed.setEnabled(false);
            sml.setEnabled(false);
            
            setVisible_(status);
        }
        
    }
    public void setVisible_(boolean status)
    {
        addmed.setVisible(status);
        aml.setVisible(status);
        viewmed.setVisible(status);
        vml.setVisible(status);
        deletemed.setVisible(status);
        dml.setVisible(status);
        updatemed.setVisible(status);
        uml.setVisible(status);
        searchmed.setVisible(status);
        sml.setVisible(status);
    }
    
    public void setSupVisible_(boolean status)
    {
        addsup.setVisible(status);
        asl.setVisible(status);
        viewsup.setVisible(status);
        vsl.setVisible(status);
        deletesup.setVisible(status);
        dsl.setVisible(status);
        updatesup.setVisible(status);
        usl.setVisible(status);
        searchsup.setVisible(status);
        ssl.setVisible(status);
    }
    public void supplierMenu(boolean status)
    {
        
        if(all.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            deletesup.setVisible(status);
            dsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(addeditviewsearch.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
            
        }
        else if(addeditviewdelete.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
            
        }
        else if(addeditsearchdelete.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
            
        }
        else if(addviewsearchdelete.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
            
        }
        else if(editviewsearchdelete.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            deletesup.setVisible(status);
            dsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(addeditview.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(addeditsearch.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(addeditdelete.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(addviewsearch.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(addviewdelete.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(addsearchdelete.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(editviewsearch.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(editviewdelete.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(editsearchdelete.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(viewsearchdelete.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            deletesup.setVisible(status);
            dsl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(addedit.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
            
        }
        else if(addview.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            viewsup.setVisible(status);
            vsl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(addsearch.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(adddelete.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            deletesup.setVisible(status);
            dsl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        
        
        else if(editview.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(editsearch.equals(supplier_permission))
        {
            updatesup.setVisible(status);
            usl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(editdelete.equals(supplier_permission))
        {
            deletesup.setVisible(status);
            dsl.setVisible(status);
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        
        
        else if(viewsearch.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(viewdelete.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            deletesup.setVisible(status);
            dsl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        
        
        else if(searchdelete.equals(supplier_permission))
        {
            deletesup.setVisible(status);
            dsl.setVisible(status);
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        
        
        else if(add.equals(supplier_permission))
        {
            addsup.setVisible(status);
            asl.setVisible(status);
            
            addsup.setEnabled(true);
            asl.setEnabled(true);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(edit.equals(supplier_permission))
        {
            updatesup.setVisible(status);
            usl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(true);
            usl.setEnabled(true);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(view.equals(supplier_permission))
        {
            viewsup.setVisible(status);
            vsl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(true);
            vsl.setEnabled(true);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(search.equals(supplier_permission))
        {
            searchsup.setVisible(status);
            ssl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(true);
            ssl.setEnabled(true);
            
            setSupVisible_(status);
        }
        else if(delete.equals(supplier_permission))
        {
            deletesup.setVisible(status);
            dsl.setVisible(status);
            
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(true);
            dsl.setEnabled(true);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }
        else if(!(all.equals(supplier_permission)))
        {
            addsup.setEnabled(false);
            asl.setEnabled(false);
            viewsup.setEnabled(false);
            vsl.setEnabled(false);
            deletesup.setEnabled(false);
            dsl.setEnabled(false);
            updatesup.setEnabled(false);
            usl.setEnabled(false);
            searchsup.setEnabled(false);
            ssl.setEnabled(false);
            
            setSupVisible_(status);
        }

    }
    public void billingMenu(boolean status)
    {
        if(billall.equals(sale_permission))
        {
            addbill.setVisible(status);
            abl.setVisible(status);
            viewbill.setVisible(status);
            vbl.setVisible(status);
            
            addbill.setEnabled(true);
            abl.setEnabled(true);
            viewbill.setEnabled(true);
            vbl.setEnabled(true);
            
            setBillVisible_(status);
        }
        else if(sales.equals(sale_permission))
        {
            addbill.setVisible(status);
            abl.setVisible(status);
            
            addbill.setEnabled(true);
            abl.setEnabled(true);
            viewbill.setEnabled(false);
            vbl.setEnabled(false);
            
            setBillVisible_(status);
        }
        else if(saleview.equals(sale_permission))
        {
            viewbill.setVisible(status);
            vbl.setVisible(status);
            
            addbill.setEnabled(false);
            abl.setEnabled(false);
            viewbill.setEnabled(true);
            vbl.setEnabled(true);
            
            setBillVisible_(status);
        }        
        else if(!(billall.equals(sale_permission)))
        {
            addbill.setEnabled(false);
            abl.setEnabled(false);
            viewbill.setEnabled(false);
            vbl.setEnabled(false);
            
            setBillVisible_(status);
        }
        
    }
    public void setBillVisible_(boolean status)
    {
        addbill.setVisible(status);
        abl.setVisible(status);
        viewbill.setVisible(status);
        vbl.setVisible(status);
    }
    public void settingMenu(boolean status)
    {
        try
        {
        PreparedStatement st;
        st=con.prepareStatement("select * from user_login where name=?");
        //rs=st.executeQuery("select * from user_login");
        st.setString(1, login_);
        rs=st.executeQuery();
        if(rs.next())
        {
            if(rs.getString("category").equals("admin"))
            {
                adduser.setVisible(status);
                viewuser.setVisible(status);
                password.setVisible(status);
                updateuser.setVisible(status);
                deleteuser.setVisible(status);
                about.setVisible(status);
                aul.setVisible(status);
                vul.setVisible(status);
                pl.setVisible(status);
                uul.setVisible(status);
                dul.setVisible(status);
                al.setVisible(status);
                
                adduser.setEnabled(true);
                viewuser.setEnabled(true);
                password.setEnabled(true);
                updateuser.setEnabled(true);
                deleteuser.setEnabled(true);
                about.setEnabled(true);
                aul.setEnabled(true);
                vul.setEnabled(true);
                pl.setEnabled(true);
                uul.setEnabled(true);
                dul.setEnabled(true);
                al.setEnabled(true);
                
                rs.close();
                st.close();
                
            }
            else
            {
                adduser.setVisible(status);
                viewuser.setVisible(status);
                password.setVisible(status);
                updateuser.setVisible(status);
                deleteuser.setVisible(status);
                about.setVisible(status);
                aul.setVisible(status);
                vul.setVisible(status);
                pl.setVisible(status);
                uul.setVisible(status);
                dul.setVisible(status);
                al.setVisible(status);
                
                adduser.setEnabled(false);
                viewuser.setEnabled(false);
                password.setEnabled(true);
                updateuser.setEnabled(false);
                deleteuser.setEnabled(false);
                about.setEnabled(true);
                aul.setEnabled(false);
                vul.setEnabled(false);
                pl.setEnabled(true);
                uul.setEnabled(false);
                dul.setEnabled(false);
                al.setEnabled(true);
                
                rs.close();
                st.close();
            }
            
        }
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
                }//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new home().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
    
}


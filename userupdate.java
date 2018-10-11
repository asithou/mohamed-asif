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
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class userupdate extends JFrame implements ActionListener
{
    JDialog jd;
    JPanel min,close,head,pa;
    JLabel name,role,medicine_permission,supplier_permission,billing_permission,userpass,user,pass,mper,sper,bper,minl,closel,headl,entermail,email;
    JCheckBox mall,madd,medit,mdelete,mview,msearch,sall,sadd,sedit,sdelete,sview,ssearch,ball,sale,sale_view;
    JComboBox role_set;
    JButton save,reset,back,preview;
    JTable list=new JTable();
    DefaultTableModel model=new DefaultTableModel();
    JScrollPane sp;
    JTextField user_name,username,gmail;
    JPasswordField password;
    JLayeredPane bpane,mpane,spane,upane,epane;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
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
    String medicine_permission_,supplier_permission_,sale_permission_;
     
    int x,y,row;
    String value;
@SuppressWarnings("unchecked")
    public userupdate()
    {
        super("Add Users");
        setBounds(300, 100, 500, 310);
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
              
              //Statement st=con.createStatement();
              
                //medicine_permission_=rs.getString("mpermission");
                //supplier_permission_=rs.getString("spermission");
                //sale_permission_=rs.getString("bpermission");
                //System.out.print(" "+medicine_permission_+" "+supplier_permission_+" "+
                        //sale_permission_);
                
            
            if(con==null)
            {
                JOptionPane.showMessageDialog(rootPane, "unable to connect database server");
            }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(rootPane, e.getMessage());
         }
       
        
        name=new JLabel("Account Name");
        name.setBounds(10, 30, 85, 25);
        add(name);
        
        user_name=new JTextField();
        user_name.setBounds(85, 30, 150, 25);
        add(user_name);
        
        role_set=new JComboBox();
        role_set.setBounds(255, 30, 200, 25);
        role_set.addItem("--select--");
        role_set.addItem("admin");
        role_set.addItem("user");
        add(role_set);
        
        mpane=new JLayeredPane();
        mpane.setBounds(5, 60, 230, 100);
        mpane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(mpane);
        medicine_permission=new JLabel("Medicine Permission");
        medicine_permission.setBounds(10, 60, 120, 30);
        add(medicine_permission);
        mall=new JCheckBox("Select All");
        mall.setBounds(10, 90, 80, 30);
        mall.setBackground(Color.WHITE);
        add(mall);
        madd=new JCheckBox("Add");
        madd.setBounds(10, 120, 50, 30);
        madd.setBackground(Color.WHITE);
        add(madd);
        medit=new JCheckBox("Edit");
        medit.setBounds(90, 90, 50, 30);
        medit.setBackground(Color.WHITE);
        add(medit);
        mview=new JCheckBox("View");
        mview.setBounds(90, 120, 60, 30);
        mview.setBackground(Color.WHITE);
        add(mview);
        msearch=new JCheckBox("Search");
        msearch.setBounds(150, 90, 70, 30);
        msearch.setBackground(Color.WHITE);
        add(msearch);
        mdelete=new JCheckBox("Delete");
        mdelete.setBounds(150, 120, 70, 30);
        mdelete.setBackground(Color.WHITE);
        add(mdelete);
        
        spane=new JLayeredPane();
        spane.setBounds(240, 60, 230, 100);
        spane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(spane);
        supplier_permission=new JLabel("Supplier Permission");
        supplier_permission.setBounds(245, 60, 120, 30);
        add(supplier_permission);
        sall=new JCheckBox("Select All");
        sall.setBounds(245, 90, 80, 30);
        sall.setBackground(Color.WHITE);
        add(sall);
        sadd=new JCheckBox("Add");
        sadd.setBounds(245, 120, 50, 30);
        sadd.setBackground(Color.WHITE);
        add(sadd);
        sedit=new JCheckBox("Edit");
        sedit.setBounds(330, 90, 50, 30);
        sedit.setBackground(Color.WHITE);
        add(sedit);
        sview=new JCheckBox("View");
        sview.setBounds(330, 120, 60, 30);
        sview.setBackground(Color.WHITE);
        add(sview);
        ssearch=new JCheckBox("Search");
        ssearch.setBounds(390, 90, 70, 30);
        ssearch.setBackground(Color.WHITE);
        add(ssearch);
        sdelete=new JCheckBox("Delete");
        sdelete.setBounds(390, 120, 70, 30);
        sdelete.setBackground(Color.WHITE);
        add(sdelete);
        
        bpane=new JLayeredPane();
        bpane.setBounds(5, 165, 230, 100);
        bpane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(bpane);
        billing_permission=new JLabel("Billing Permission");
        billing_permission.setBounds(10, 165, 120, 30);
        add(billing_permission);
        ball=new JCheckBox("Select All");
        ball.setBounds(10, 195, 80, 30);
        ball.setBackground(Color.WHITE);
        add(ball);
        sale_view=new JCheckBox("Sale Data View");
        sale_view.setBounds(90, 195, 100, 30);
        sale_view.setBackground(Color.WHITE);
        add(sale_view);
        sale=new JCheckBox("Billing");
        sale.setBounds(10, 230, 100, 30);
        sale.setBackground(Color.WHITE);
        add(sale);
        
        userpass=new JLabel("Create UserName Password");
        userpass.setBounds(245, 165, 135, 30);
        add(userpass);
        user=new JLabel("user name");
        user.setBounds(245, 195, 60, 30);
        add(user);
        pass=new JLabel("password");
        pass.setBounds(245, 230, 60, 30);
        add(pass);
        username=new JTextField();
        username.setBounds(305, 195, 150, 30);
        add(username);
        password=new JPasswordField();
        password.setBounds(305, 230, 150, 30);
        add(password);
        spane=new JLayeredPane();
        spane.setBounds(240, 165, 230, 100);
        spane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(spane);
        
        
        mper=new JLabel();
        mper.setBounds(5, 270, 200, 30);
        //add(mper);
        sper=new JLabel();
        sper.setBounds(5, 300, 200, 30);
        //add(sper);
        bper=new JLabel();
        bper.setBounds(5, 330, 200, 30);
        //add(bper);
        
        entermail=new JLabel("Register Mail");
        entermail.setBounds(10, 270, 120, 20);
        add(entermail);
        email=new JLabel("Email");
        email.setBounds(10, 300, 25, 30);
        add(email);
        gmail=new JTextField();
        gmail.setBounds(45, 300, 180, 25);
        add(gmail);
        epane=new JLayeredPane();
        epane.setBounds(5, 270, 230, 60);
        epane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(epane);
        
        save=new JButton("Save");
        save.setBounds(270, 290, 60, 30);
        save.setEnabled(false);
        add(save);
        
        reset=new JButton("Reset");
        reset.setBounds(260, 290, 70, 30);
        reset.setEnabled(false);
        //add(reset);
        
        preview=new JButton("PreView");
        preview.setBounds(340, 290, 70, 30);
        add(preview);
        
        back=new JButton("Back");
        back.setBounds(420, 290, 70, 30);
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
        
        headl=new JLabel("  Update User");
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
        
        setBounds(300, 100, 500, 370);
        setBounds(300, 100, 500, 340);
        
        
        mall.addActionListener(this);
        sall.addActionListener(this);
        ball.addActionListener(this);
        madd.addActionListener(this);
        medit.addActionListener(this);
        mview.addActionListener(this);
        msearch.addActionListener(this);
        mdelete.addActionListener(this);
        sadd.addActionListener(this);
        sedit.addActionListener(this);
        sview.addActionListener(this);
        ssearch.addActionListener(this);
        sdelete.addActionListener(this);
        sale.addActionListener(this);
        sale_view.addActionListener(this);
        save.addActionListener(this);
        reset.addActionListener(this);
        preview.addActionListener(this);
        back.addActionListener(this);
        
        user_name.addKeyListener(new java.awt.event.KeyAdapter() {

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
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==mall)
        {
            if(mall.isSelected()==true)
            {
                madd.setSelected(true);
                medit.setSelected(true);
                mview.setSelected(true);
                msearch.setSelected(true);
                mdelete.setSelected(true);
            }
            else
            {
                madd.setSelected(false);
                medit.setSelected(false);
                mview.setSelected(false);
                msearch.setSelected(false);
                mdelete.setSelected(false);
            }
        }
        else if(ae.getSource()==sall)
        {
            if(sall.isSelected()==true)
            {
                sadd.setSelected(true);
                sedit.setSelected(true);
                sview.setSelected(true);
                ssearch.setSelected(true);
                sdelete.setSelected(true);
            }
            else
            {
                sadd.setSelected(false);
                sedit.setSelected(false);
                sview.setSelected(false);
                ssearch.setSelected(false);
                sdelete.setSelected(false);
            }
        }
        else if(ae.getSource()==ball)
        {
            if(ball.isSelected()==true)
            {
                sale.setSelected(true);
                sale_view.setSelected(true);
            }
            else
            {
                sale.setSelected(false);
                sale_view.setSelected(false);
            }
        }
        else if(ae.getSource()==madd)
        {
            if(medit.isSelected()==true && mview.isSelected()==true && msearch.isSelected()==true && mdelete.isSelected()==true)
            {
                mall.setSelected(true);
                setSelected(true);
            }    
        }
        else if(ae.getSource()==medit)
        {
            if(madd.isSelected()==true && mview.isSelected()==true && msearch.isSelected()==true && mdelete.isSelected()==true)
            {
                mall.setSelected(true);
                setSelected(true);
            }    
        }
        else if(ae.getSource()==mview)
        {
            if(madd.isSelected()==true && medit.isSelected()==true && msearch.isSelected()==true && mdelete.isSelected()==true)
            {
                mall.setSelected(true);
                setSelected(true);
            }    
        }
        else if(ae.getSource()==msearch)
        {
            if(madd.isSelected()==true && medit.isSelected()==true && mview.isSelected()==true && mdelete.isSelected()==true)
            {
                mall.setSelected(true);
                setSelected(true);
            }    
        }
        else if(ae.getSource()==mdelete)
        {
            if(madd.isSelected()==true && medit.isSelected()==true && mview.isSelected()==true && msearch.isSelected()==true)
            {
                mall.setSelected(true);
                setSelected(true);
            }    
        }
        else if(ae.getSource()==sadd)
        {
            if(sedit.isSelected()==true && sview.isSelected()==true && ssearch.isSelected()==true && sdelete.isSelected()==true)
            {
                sall.setSelected(true);
                supplierSetSelected(true);
            }    
        }
        else if(ae.getSource()==sedit)
        {
            if(sadd.isSelected()==true && sview.isSelected()==true && ssearch.isSelected()==true && sdelete.isSelected()==true)
            {
                sall.setSelected(true);
                supplierSetSelected(true);
            }    
        }
        else if(ae.getSource()==sview)
        {
            if(sadd.isSelected()==true && sedit.isSelected()==true && ssearch.isSelected()==true && sdelete.isSelected()==true)
            {
                sall.setSelected(true);
                supplierSetSelected(true);
            }    
        }
        else if(ae.getSource()==ssearch)
        {
            if(sadd.isSelected()==true && sedit.isSelected()==true && sview.isSelected()==true && sdelete.isSelected()==true)
            {
                sall.setSelected(true);
                supplierSetSelected(true);
            }    
        }
        else if(ae.getSource()==sdelete)
        {
            if(sadd.isSelected()==true && sedit.isSelected()==true && sview.isSelected()==true && ssearch.isSelected()==true)
            {
                sall.setSelected(true);
                supplierSetSelected(true);
            }    
        }
        else if(ae.getSource()==sale)
        {
            if(sale_view.isSelected()==true)
            {
                ball.setSelected(true);
                billSetSelected(true);
            }
        }
        else if(ae.getSource()==sale_view)
        {
            if(sale.isSelected()==true)
            {
                ball.setSelected(true);
                billSetSelected(true);
            }
        }
        else if(ae.getSource()==save)
        {
            if(user_name.getText().isEmpty()==true || role_set.getSelectedItem().toString()=="--select--" || gmail.getText().isEmpty()==true)
            {
                JOptionPane.showMessageDialog(rootPane, "some one field is missing");
            }
            else
            {
                saveData();
            }
        }
        else if(ae.getSource()==reset)
        {
            setSelected(false);
            supplierSetSelected(false);
            billSetSelected(false);
            mall.setSelected(false);
            sall.setSelected(false);
            ball.setSelected(false);
            role_set.setSelectedItem("--select--");
            mper.setText("");
            sper.setText("");
            bper.setText("");
            user_name.setText("");
            username.setText("");
            password.setText("");
        }
        else if(ae.getSource()==preview)
        {
            preview();
            save.setEnabled(true);
            reset.setEnabled(true);
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new home().setVisible(true);
        }
    }
    public boolean getData_()
    {
        boolean status;
        try
        {
                PreparedStatement st;
                st=con.prepareStatement("select * from add_user where username=?");
                st.setString(1, username.getText());
                rs=st.executeQuery();
                    if(rs.next())
                    {
                        if(rs.getString("username").equals(username.getText()))
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
    
    public void preview()
    {
        jd=new JDialog();
        jd.setTitle("User List");
        jd.setBounds(10, 10, 1350, 720);
        jd.setVisible(true);
        jd.setLayout(null);
        
        list=new JTable();
        model=new DefaultTableModel();
        list.setModel(model);
        model.addColumn("S NO");
        model.addColumn("NAME");
        model.addColumn("MEDICINE PERMISSION");
        model.addColumn("SUPPLIER PERMISSION");
        model.addColumn("SALES PERMISSION");
        model.addColumn("CATEGORY");
        model.addColumn("EMAIL");
        
        list.setRowHeight(40);
        list.setFont(new Font("",Font.PLAIN,20));
        sp=new JScrollPane(list);
        sp.setBounds(0, 0, jd.getWidth(), jd.getHeight()-40);
        jd.add(sp);
        
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_software","root","");
            Statement st=con.createStatement();
            rs=st.executeQuery("select * from add_user");
            int count=1;
            while(rs.next())
            {
                String[] supdata={rs.getString("sno"),rs.getString("name"),rs.getString("mpermission"),rs.getString("spermission"),rs.getString("bpermission"),rs.getString("category"),rs.getString("email")};
                model.addRow(supdata);
                //count++;
            }
            rs.close();
            st.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        
        list.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent me)
            {
                row=list.getSelectedRow();
                value=list.getModel().getValueAt(row, 0).toString();
                user_name.setText(list.getModel().getValueAt(row, 1).toString());
                medicine_permission_=list.getModel().getValueAt(row, 2).toString();
                supplier_permission_=list.getModel().getValueAt(row, 3).toString();
                sale_permission_=list.getModel().getValueAt(row, 4).toString();
                role_set.setSelectedItem(list.getModel().getValueAt(row, 5).toString());
                gmail.setText(list.getModel().getValueAt(row, 6).toString());
                jd.setVisible(false);
                medicineMenu();
                supplierMenu();
                billingMenu();
            }
        });
    }
            
    public void saveData()
    {
        int temp_id=0;
            
            try
            {
                        getMdicineSelectedPermission();
                        getSupplierSelectedPermission();
                        getBillSelectedPermission();
            
                        ps=con.prepareStatement("UPDATE  add_user SET name='"+user_name.getText()+"',category='"+role_set.getSelectedItem()+"',mpermission='"+mper.getText()+"',spermission='"+sper.getText()+"',bpermission='"+bper.getText()+"',email='"+gmail.getText()+"' WHERE sno="+value);
                        ps.execute();
                    
                        JOptionPane.showMessageDialog(rootPane, "updated");
                        clear();
                        ps.close();
                
                     //clear();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
    }
    public void clear()
    {
        setSelected(false);
        supplierSetSelected(false);
        billSetSelected(false);
        mall.setSelected(false);
        sall.setSelected(false);
        ball.setSelected(false);
        role_set.setSelectedItem("--select--");
        mper.setText("");
        sper.setText("");
        bper.setText("");
        user_name.setText("");
        username.setText("");
        password.setText("");
        gmail.setText("");
    }
    public void getMdicineSelectedPermission()
    {
        if(madd.isSelected()==true)
        {
            mper.setText(mper.getText()+add);
        }
        if(medit.isSelected()==true)
        {
            mper.setText(mper.getText()+edit);
        }
        if(mview.isSelected()==true)
        {
            mper.setText(mper.getText()+view);
        }
        if(msearch.isSelected()==true)
        {
            mper.setText(mper.getText()+search);
        }
        if(mdelete.isSelected()==true)
        {
            mper.setText(mper.getText()+delete);
        }
        if(mall.isSelected()==true)
        {
            mper.setText(all);
        }
        
    }
    public void getSupplierSelectedPermission()
    {
        if(sadd.isSelected()==true)
        {
            sper.setText(sper.getText()+add);
        }
        if(sedit.isSelected()==true)
        {
            sper.setText(sper.getText()+edit);
        }
        if(sview.isSelected()==true)
        {
            sper.setText(sper.getText()+view);
        }
        if(ssearch.isSelected()==true)
        {
            sper.setText(sper.getText()+search);
        }
        if(sdelete.isSelected()==true)
        {
            sper.setText(sper.getText()+delete);
        }
        if(sall.isSelected()==true)
        {
            sper.setText(all);
        }
           
    }
    public void getBillSelectedPermission()
    {
        if(sale.isSelected()==true)
        {
            bper.setText(bper.getText()+sales);
        }
        if(sale_view.isSelected()==true)
        {
            bper.setText(bper.getText()+saleview);
        }
        if(ball.isSelected()==true)
        {
            bper.setText(billall);
        }
        
    }
    public void setSelected(boolean status)
    {
        madd.setSelected(status);
        medit.setSelected(status);
        mview.setSelected(status);
        msearch.setSelected(status);
        mdelete.setSelected(status);
    }
    public void supplierSetSelected(boolean status)
    {
        sadd.setSelected(status);
        sedit.setSelected(status);
        sview.setSelected(status);
        ssearch.setSelected(status);
        sdelete.setSelected(status);
    }
    public void billSetSelected(boolean status)
    {
        sale.setSelected(status);
        sale_view.setSelected(status);
    }
    
    
    
    
    
    public void medicineMenu()
    {
        
        if(all.equals(medicine_permission_))
        {
            mall.setSelected(true);
            madd.setSelected(true);
            medit.setSelected(true);
            mview.setSelected(true);
            msearch.setSelected(true);
            mdelete.setSelected(true);
            
        }
        else if(addeditviewsearch.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(true);
            mview.setSelected(true);
            msearch.setSelected(true);
            mdelete.setSelected(false);
            
        }
        else if(addeditsearchdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(true);
            mview.setSelected(false);
            msearch.setSelected(true);
            mdelete.setSelected(true);
            
        }
        else if(addeditviewdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(true);
            mview.setSelected(true);
            msearch.setSelected(false);
            mdelete.setSelected(true);
            
        }
        else if(addviewsearchdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(false);
            mview.setSelected(true);
            msearch.setSelected(true);
            mdelete.setSelected(true);
            
        }
        else if(editviewsearchdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(true);
            mview.setSelected(true);
            msearch.setSelected(true);
            mdelete.setSelected(true);
            
        }
        else if(addeditview.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(true);
            mview.setSelected(true);
            msearch.setSelected(false);
            mdelete.setSelected(false);
        }
        else if(addeditsearch.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(true);
            mview.setSelected(false);
            msearch.setSelected(true);
            mdelete.setSelected(false);
        }
        else if(addeditdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(true);
            mview.setSelected(false);
            msearch.setSelected(false);
            mdelete.setSelected(true);
        }
        else if(addviewsearch.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(false);
            mview.setSelected(true);
            msearch.setSelected(true);
            mdelete.setSelected(false);
        }
        else if(addviewdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(false);
            mview.setSelected(true);
            msearch.setSelected(false);
            mdelete.setSelected(true);
        }
        else if(addsearchdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(false);
            mview.setSelected(false);
            msearch.setSelected(true);
            mdelete.setSelected(true);
        }
        else if(editviewsearch.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(true);
            mview.setSelected(true);
            msearch.setSelected(true);
            mdelete.setSelected(false);
        }
        else if(editviewdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(true);
            mview.setSelected(true);
            msearch.setSelected(false);
            mdelete.setSelected(true);
        }
        else if(editsearchdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(true);
            mview.setSelected(false);
            msearch.setSelected(true);
            mdelete.setSelected(true);
        }
        else if(viewsearchdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(false);
            mview.setSelected(true);
            msearch.setSelected(true);
            mdelete.setSelected(true);
        }
        else if(addedit.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(true);
            mview.setSelected(false);
            msearch.setSelected(false);
            mdelete.setSelected(false);
        }
        else if(addview.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(false);
            mview.setSelected(true);
            msearch.setSelected(false);
            mdelete.setSelected(false);
        }
        else if(addsearch.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(false);
            mview.setSelected(false);
            msearch.setSelected(true);
            mdelete.setSelected(false);
        }
        else if(adddelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(false);
            mview.setSelected(false);
            msearch.setSelected(false);
            mdelete.setSelected(true);
        }
        
        
        else if(editview.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(true);
            mview.setSelected(true);
            msearch.setSelected(false);
            mdelete.setSelected(false);
            
        }
        else if(editsearch.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(true);
            mview.setSelected(false);
            msearch.setSelected(true);
            mdelete.setSelected(false);
        }
        else if(editdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(true);
            mview.setSelected(false);
            msearch.setSelected(false);
            mdelete.setSelected(true);
        }
        
        
        else if(viewsearch.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(false);
            mview.setSelected(true);
            msearch.setSelected(true);
            mdelete.setSelected(false);
        }
        else if(viewdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(false);
            mview.setSelected(true);
            msearch.setSelected(false);
            mdelete.setSelected(true);
        }
        
        
        else if(searchdelete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(false);
            mview.setSelected(false);
            msearch.setSelected(true);
            mdelete.setSelected(true);
        }
        
        
        else if(add.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(true);
            medit.setSelected(false);
            mview.setSelected(false);
            msearch.setSelected(false);
            mdelete.setSelected(false);
        }
        else if(edit.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(true);
            mview.setSelected(false);
            msearch.setSelected(false);
            mdelete.setSelected(false);
        }
        else if(view.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(false);
            mview.setSelected(true);
            msearch.setSelected(false);
            mdelete.setSelected(false);
        }
        else if(search.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(false);
            mview.setSelected(false);
            msearch.setSelected(true);
            mdelete.setSelected(false);
        }
        else if(delete.equals(medicine_permission_))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(false);
            mview.setSelected(false);
            msearch.setSelected(false);
            mdelete.setSelected(true);
        }
        else if(!(all.equals(medicine_permission_)))
        {
            mall.setSelected(false);
            madd.setSelected(false);
            medit.setSelected(false);
            mview.setSelected(false);
            msearch.setSelected(false);
            mdelete.setSelected(false);
        }
        
    }
    
    
    
    public void supplierMenu()
    {
        
        if(all.equals(supplier_permission_))
        {
            
            sall.setSelected(true);
            sadd.setSelected(true);
            sedit.setSelected(true);
            sview.setSelected(true);
            ssearch.setSelected(true);
            sdelete.setSelected(true);
        }
        else if(addeditviewsearch.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(true);
            sview.setSelected(true);
            ssearch.setSelected(true);
            sdelete.setSelected(false);
            
        }
        else if(addeditsearchdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(true);
            sview.setSelected(false);
            ssearch.setSelected(true);
            sdelete.setSelected(true);
            
        }
        else if(addeditviewdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(true);
            sview.setSelected(true);
            ssearch.setSelected(false);
            sdelete.setSelected(true);
            
        }
        else if(addviewsearchdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(false);
            sview.setSelected(true);
            ssearch.setSelected(true);
            sdelete.setSelected(true);
            
        }
        else if(editviewsearchdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(true);
            sview.setSelected(true);
            ssearch.setSelected(true);
            sdelete.setSelected(true);
        }
        else if(addeditview.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(true);
            sview.setSelected(true);
            ssearch.setSelected(false);
            sdelete.setSelected(false);
        }
        else if(addeditsearch.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(true);
            sview.setSelected(false);
            ssearch.setSelected(true);
            sdelete.setSelected(false);
        }
        else if(addeditdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(true);
            sview.setSelected(false);
            ssearch.setSelected(false);
            sdelete.setSelected(true);
        }
        else if(addviewsearch.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(false);
            sview.setSelected(true);
            ssearch.setSelected(true);
            sdelete.setSelected(false);
        }
        else if(addviewdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(false);
            sview.setSelected(true);
            ssearch.setSelected(false);
            sdelete.setSelected(true);
        }
        else if(addsearchdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(false);
            sview.setSelected(false);
            ssearch.setSelected(true);
            sdelete.setSelected(true);
        }
        else if(editviewsearch.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(true);
            sview.setSelected(true);
            ssearch.setSelected(true);
            sdelete.setSelected(false);
        }
        else if(editviewdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(true);
            sview.setSelected(true);
            ssearch.setSelected(false);
            sdelete.setSelected(true);
        }
        else if(editsearchdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(true);
            sview.setSelected(false);
            ssearch.setSelected(true);
            sdelete.setSelected(true);
        }
        else if(viewsearchdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(false);
            sview.setSelected(true);
            ssearch.setSelected(true);
            sdelete.setSelected(true);
        }
        else if(addedit.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(true);
            sview.setSelected(false);
            ssearch.setSelected(false);
            sdelete.setSelected(false);
            
        }
        else if(addview.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(false);
            sview.setSelected(true);
            ssearch.setSelected(false);
            sdelete.setSelected(false);
        }
        else if(addsearch.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(false);
            sview.setSelected(false);
            ssearch.setSelected(true);
            sdelete.setSelected(false);
        }
        else if(adddelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(false);
            sview.setSelected(false);
            ssearch.setSelected(false);
            sdelete.setSelected(true);
        }
        
        
        else if(editview.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(true);
            sview.setSelected(true);
            ssearch.setSelected(false);
            sdelete.setSelected(false);
        }
        else if(editsearch.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(true);
            sview.setSelected(false);
            ssearch.setSelected(true);
            sdelete.setSelected(false);
        }
        else if(editdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(true);
            sview.setSelected(false);
            ssearch.setSelected(false);
            sdelete.setSelected(true);
        }
        
        
        else if(viewsearch.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(false);
            sview.setSelected(true);
            ssearch.setSelected(true);
            sdelete.setSelected(false);
        }
        else if(viewdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(false);
            sview.setSelected(true);
            ssearch.setSelected(false);
            sdelete.setSelected(true);
        }
        
        
        else if(searchdelete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(false);
            sview.setSelected(false);
            ssearch.setSelected(true);
            sdelete.setSelected(true);
        }
        
        
        else if(add.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(true);
            sedit.setSelected(false);
            sview.setSelected(false);
            ssearch.setSelected(false);
            sdelete.setSelected(false);
        }
        else if(edit.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(true);
            sview.setSelected(false);
            ssearch.setSelected(false);
            sdelete.setSelected(false);
        }
        else if(view.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(false);
            sview.setSelected(true);
            ssearch.setSelected(false);
            sdelete.setSelected(false);
        }
        else if(search.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(false);
            sview.setSelected(false);
            ssearch.setSelected(true);
            sdelete.setSelected(false);
        }
        else if(delete.equals(supplier_permission_))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(false);
            sview.setSelected(false);
            ssearch.setSelected(false);
            sdelete.setSelected(true);
        }
        else if(!(all.equals(supplier_permission_)))
        {
            sall.setSelected(false);
            sadd.setSelected(false);
            sedit.setSelected(false);
            sview.setSelected(false);
            ssearch.setSelected(false);
            sdelete.setSelected(false);
        }

    }
    public void billingMenu()
    {
        if(billall.equals(sale_permission_))
        {
            ball.setSelected(true);
            sale.setSelected(true);
            sale_view.setSelected(true);
        }
        else if(sales.equals(sale_permission_))
        {
            ball.setSelected(false);
            sale.setSelected(true);
            sale_view.setSelected(false);
        }
        else if(saleview.equals(sale_permission_))
        {
            sall.setSelected(false);
            sale.setSelected(false);
            sale_view.setSelected(true);
        }        
        else if(!(billall.equals(sale_permission_)))
        {
            sall.setSelected(false);
            sale.setSelected(false);
            sale_view.setSelected(false);
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
            java.util.logging.Logger.getLogger(userupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new userupdate().setVisible(true);           
                }
                catch(Exception e)
                {
                    
                }
             }
        });
    }
    
}

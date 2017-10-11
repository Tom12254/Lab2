
import java.sql.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;

public class HelloWorld extends JApplet{
 
		Container c;
		JPanel p1,p2;
		JButton b1,b2,b3,b4,d1,d2,d3,d4;	
	    Connection conn;
   	    Statement stmt ; 
   	    ResultSet rs = null;
   	 ResultSet rst = null;
    
    
		public static ResultSet link( Connection conn,Statement stmt) throws ClassNotFoundException, SQLException
		{
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Í¼ÊéÊý¾Ý¿âBookDB","root","mxy19960610");
		    stmt =  conn.createStatement();
	       ResultSet rs = stmt.executeQuery("select * from Book");
	       //ResultSet rs2 = stmt.executeQuery("select * from Author");
	       return rs;
		}
		
    	
        public void init()
    	{
        	BHandler h;
			try {
				rs = link(conn,stmt);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		c=getContentPane();
    		p1=new JPanel(new FlowLayout());
    		p2=new JPanel(new FlowLayout());
    		d1=new JButton("É¾³ý");
    		d2=new JButton("É¾³ý");
    		d3=new JButton("É¾³ý");
    		d4=new JButton("É¾³ý");
    		 try {
				rs.next();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				b1=new JButton(rs.getString(2));
				rst=rs;
				//h=new BHandler(rst);
				//System.out.println(.getString(2));
			//	b1.addActionListener(h);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
    		
    		try {
				rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
			try {
				b2=new JButton(rs.getString(2));
				rst=rs;
				//h=new BHandler(rst);
				//rsx=rs;
				//System.out.println(rs.getString(2));
				//BHandler h2=new BHandler();
			//	b2.addActionListener(h);
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				b3=new JButton(rs.getString(2));
				rst=rs;
				//h=new BHandler(rst);
				//rsx=rs;
				//System.out.println(rs.getString(2));
			   // BHandler h3=new BHandler();
			//	b3.addActionListener(h);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				b4=new JButton(rs.getString(2));
				rst=rs;
			//	h=new BHandler(rst);
				//System.out.println(rs.getString(2));
			   // BHandler h4=new BHandler();
			//	b4.addActionListener(h);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		c.setBackground(new Color(255,255,204));
    		p1.setBackground(new Color(255,255,204));
    		p2.setBackground(new Color(255,255,204));
    		c.add(p1, BorderLayout.NORTH);
    		c.add(p2, BorderLayout.SOUTH);
    		p1.add(b1);
    		p1.add(d1);
    		p1.add(b2);
    		p1.add(d2);
    		p1.add(b3);
    		p1.add(d3);
    		p1.add(b4);
    		p1.add(d4); 
    		System.out.println("End!\n");
    		/* if (rs != null) {
 	            try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 	        }
 	        if (stmt != null) {
 	            try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
 	        }
 	        if (conn != null) {
 	            try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
 	        }*/
    	}
    	public abstract class BHandler implements ActionListener{
    		ActionEvent event;
    		public void actionPerformed(ActionEvent event,ResultSet rst)
    		{
    			
    			try {
    				try {
    					JOptionPane.showMessageDialog(HelloWorld.this,"ISBN:"+rst.getInt(1)+"   AuthorID:"+rst.getInt(3)+"   Publisher:"+rst.getString(4)+"   PublishDate:"+rst.getDate(5)+"   Price:"+rst.getInt(6)+event.getActionCommand());
    					
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			} catch (HeadlessException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    		BHandler (ResultSet rst)
    		{
    			
				actionPerformed(event,rst);
    		}
    		
    	}
    	
}
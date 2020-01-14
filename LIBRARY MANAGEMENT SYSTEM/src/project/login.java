package project;
import java.sql.*;
import java.util.*;
public class login {

	public Connection cn=null;
	public Statement st=null;
	public PreparedStatement pst=null,bst1=null,bst2=null,rst=null,bst3=null,lst=null,bst4=null,nst=null,bst5=null;
	public ResultSet rs=null,rs1=null,rs2=null,rs3=null,rs4=null,rs5=null,rs6=null,prs=null;	
	String sql=null,Username=null;
	
	public login() throws Exception {
	
	//public void log_in() throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/libsystem?useUnicode=true&useJDBCComplaintTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root",null);
		if(cn!=null)
			System.out.println("Connect done");
		else
			System.out.println("Connect fail");
String uname = null,pass = null;
String uid="SRC123";
String pw="SRC";
Scanner sc=new Scanner(System.in);
	System.out.println("User_id=");
	uname=sc.next();
	System.out.println("Password=");
	pass=sc.next();
	
	if((uname.compareTo(uid)==0)&&(pass.compareTo(pw)==0))
	{
		{
			st=cn.createStatement();	
			sql="Select * from registration_details";
	
	rs=st.executeQuery(sql);
	while(rs.next())

		{
		System.out.println("Member details:");
		System.out.println("  "+rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getInt(3)+"   "+rs.getString(4));
		}
		}
	}
	else 
		System.out.println("No member present");
	
			
	}
	
	}



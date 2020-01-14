package project;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
public class booklist extends login{

	public booklist() throws Exception{
		// TODO Auto-generated constructor stub

	}
	//nnection cn=null;
	//atement st=null;
	//eparedStatement pst=null;
	//sultSet rs=null;
	
	Scanner sc=new Scanner(System.in);
public void book_show() throws Exception{
	
	
		
		String ans;
		int ans1,ans2,q;
		int fine=50,days,diff=0;
		String sql=null;
		String cat=null,sub=null;
		String sqli=null,sl=null;
		System.out.println("Want to issue new book or return?");
		ans=sc.next();
		if(ans.compareTo("issue")==0)
		{
		st=cn.createStatement();
		sql="Select * from Book_category";
		rs=st.executeQuery(sql);
		System.out.println("Book_list:");
		while(rs.next())

			{
			System.out.println("  "+rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"  "+rs.getInt(4));
			}
		System.out.println(" Show the books according to subject:");
	System.out.println("1.CSE 2.ECE");
	System.out.println("[1/2]");
	ans1=sc.nextInt();
	if(ans1==1)
	{
	cat="CSE";
	sqli="Select * from Subcategory where Category=?";
	}
		else if(ans1==2)
	{
		cat="ECE";
		sqli="Select * from Subcategory where Category=?";
	}
	pst=cn.prepareStatement(sqli);
	pst.setString(1, cat);
	rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println("     "+rs.getInt(1)+"      "+rs.getString(2)+"     "+rs.getString(3) +"   "+rs.getString(4));	
			}
			System.out.println("Now books of which branch is needed?");
	System.out.println("[1.CSE 2.ECE]");
	q=sc.nextInt();
	if(q==1)
	{
			System.out.println("If CSE which subject?");
		System.out.println("1.java 2.C++");
		System.out.println("[1/2]");
		ans2=sc.nextInt();
		if(ans2==1) {
			sub="java";
			sl="Select * from Subcategory where Sub_category=?";
		}
		else if(ans2==2)
		{
			sub="C++";
			sl=" Select * from subcategory where Sub_category=?";
		}
		pst=cn.prepareStatement(sl);
		pst.setString(1, sub);
		rs=pst.executeQuery();
		while(rs.next())
		{
			System.out.println("     "+rs.getInt(1)+"      "+rs.getString(2)+"     "+rs.getString(3) +"   "+rs.getString(4));			
		}
	
		
	}
	else if(q==2) {
		System.out.println("If ECE which subject?");
		System.out.println("1.Microelectric circuit 2.Digital Electronics");
		System.out.println("[1/2]");
		ans2=sc.nextInt();
		if(ans2==1) {
			sub="Microelectric Circuit";
			sl="Select * from Subcategory where Sub_category=?";
		}
	
		else if(ans2==2)
		{
			sub="Digital Electronics";
			sl=" Select * from subcategory where Sub_category=?";
		}
		pst=cn.prepareStatement(sl);
		pst.setString(1, sub);
		rs=pst.executeQuery();
		while(rs.next())
		{
			System.out.println("     "+rs.getInt(1)+"      "+rs.getString(2)+"     "+rs.getString(3) +"   "+rs.getString(4));				
	}
	
	}
		{
	System.out.println("Which book_id?");
		int id=sc.nextInt();
		int flag=0;
		pst.setString(1, sub);
		rs=pst.executeQuery();
				while(rs.next()){
			if(id==rs.getInt(1))
			{
				flag=1;
				{
				System.out.println("     "+rs.getInt(1)+"      "+rs.getString(2)+"     "+rs.getString(3) +"   "+rs.getString(4));				
				System.out.println("Member name:");
				String mem=sc.next();
				System.out.println("Member id:");
				String mid=sc.next();
				System.out.println("No. of books:");
				int no=sc.nextInt();
				System.out.println("Issue and return date:");
				String sq="Select curdate(),Date_Add(curdate(),interval 7 day)";
					st=cn.createStatement();
					rs1=st.executeQuery(sq);
					while(rs1.next()) {
						System.out.println("  "+rs1.getDate(1)+"  "+rs1.getDate(2));
					String sqllend="insert into lending(Member_name,Member_id,book_id,Sub_category,Book_name,Category,units,Issue_date,due_date) values(?,?,?,?,?,?,?,?,?)";
			bst1=cn.prepareStatement(sqllend);
			bst1.setString(1, mem);
			bst1.setString(2, mid);
			bst1.setInt(3, rs.getInt(1));
			bst1.setString(4, rs.getString(2));
			bst1.setString(5,rs.getString(3));
			bst1.setString(6, rs.getString(4));
			bst1.setInt(7,no);
			bst1.setDate(8, rs1.getDate(1));
			bst1.setDate(9, rs1.getDate(2));
			int res=bst1.executeUpdate();
		     	     
			String a="Select count(*) from Lending where Member_id=?";
			lst=cn.prepareStatement(a);
			lst.setString(1, mid);
			rs2=lst.executeQuery();
			while(rs2.next()) {
				System.out.println("Book Count:");
				System.out.println(""+rs2.getInt(1));
				int rowcount = 0;
				rowcount=rs2.getInt(1);
				rowcount++;
				if(rowcount<=3) 
				{
					if(res==1)
						System.out.println("table created...");
					else
						System.out.println("not created...");
					break;
						
			}
				else if(rowcount>3)
				System.out.println("Cannot lend more books");
				
					
			}
	
				}
				}
			}
				
			else 
				flag=0;
				}	
	}
		}
		
				else if(ans.compareTo("return")==0) 
		{	
		System.out.println("Enter member id:");
		String m_id=sc.next();
		String qry="Select * from lending where Member_id=?";
		nst=cn.prepareStatement(qry);
		nst.setString(1, m_id);
		rs4=nst.executeQuery();
		boolean empty=true;
		System.out.println("Which book u want to return among these?");		
		while(rs4.next()){
				empty=false;
				System.out.println("     "+rs4.getInt(1)+"      "+rs4.getString(2)+"     "+rs4.getString(3) +"   "+rs4.getInt(4)+"   "+rs4.getString(5)+"   "+rs4.getString(6)+"  "+rs4.getString(7)+"    "+rs4.getInt(8)+"   "+rs4.getDate(9)+"   "+rs4.getDate(10));					
		}
				System.out.println("Enter the book id you want to return:");
		int bid=sc.nextInt();
		String c="Select * from lending where book_id=?";
		bst2=cn.prepareStatement(c);
		bst2.setInt(1, bid);
		rs5=bst2.executeQuery();
		while(rs5.next()) {
			System.out.println("     "+rs5.getInt(1)+"      "+rs5.getString(2)+"     "+rs5.getString(3) +"   "+rs5.getInt(4)+"   "+rs5.getString(5)+"   "+rs5.getString(6)+"  "+rs5.getString(7)+"    "+rs5.getInt(8)+"   "+rs5.getDate(9)+"   "+rs5.getDate(10));					
		System.out.println("Enter the date you have returned the book:");
		String sdate=sc.next();
	   // Date date=(Date)new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
	   // System.out.println(sdate+"\t"+date);
		//System.out.println("No. of days late");
		Date date=Date.valueOf(sdate);
		System.out.println(date);
		String e="Insert into return_book(trans_id,Member_name,Member_id,book_id,Subcategory,Book_name,Category,Unit,Issue_date,due_date,return_date) values(?,?,?,?,?,?,?,?,?,?,?)";
		bst4=cn.prepareStatement(e);
		bst4.setInt(1, rs5.getInt(1));
		bst4.setString(2, rs5.getString(2));
		bst4.setString(3, rs5.getString(3));
		bst4.setInt(4, rs5.getInt(4));
		bst4.setString(5, rs5.getString(5));
		bst4.setString(6, rs5.getString(6));
		bst4.setString(7, rs5.getString(7));
		bst4.setInt(8, rs5.getInt(8));
		bst4.setDate(9, rs5.getDate(9));
		bst4.setDate(10, rs5.getDate(10));
		bst4.setDate(11, date);
		int rl=bst4.executeUpdate();
		if(rl==1)
			System.out.println("Insert done");
		else 
			System.out.println("Insert fail");
		String rt="Select * from return_book";
		st=cn.createStatement();
		prs=st.executeQuery(rt);
		while(prs.next()) {
		System.out.println("   "+prs.getInt(1)+"   "+prs.getString(2)+"  "+prs.getString(3)+"   "+prs.getInt(4)+"   "+prs.getString(5)+"   "+prs.getString(6)+"   "+prs.getString(7)+"   "+prs.getInt(8)+"  "+prs.getDate(9)+"  "+prs.getDate(10)+"  "+prs.getDate(11));	
		
		System.out.println("No. of days late:");
		String ts="Select datediff(return_date,due_date) from return_book";
		st=cn.createStatement();
		rs6=st.executeQuery(ts);
		while(rs6.next()) {
		System.out.println(" "+rs6.getInt(1));	
		 diff=rs6.getInt(1);
		}
		
		fine=fine*diff;
		String rp="insert into fine(Member_id,Book_id,due_date,return_date,days_late,fine) values(?,?,?,?,?,?)";
		bst5=cn.prepareStatement(rp);
		bst5.setString(1, prs.getString(3));
		bst5.setInt(2, prs.getInt(4));
		bst5.setDate(3, prs.getDate(10));
		bst5.setDate(4, prs.getDate(11));
		bst5.setInt(5, diff);
		bst5.setInt(6, fine);
		int pr=bst5.executeUpdate();
		if(pr==1)
			System.out.println("Insert in fine table done");
		else
			System.out.println("fail");
		}
		String d="Delete from lending where book_id=?";
		bst3=cn.prepareStatement(d);
		bst3.setInt(1, bid);
		int src=bst3.executeUpdate();
		System.out.println("Data deleted");
		}
		
			
		
			
			if(empty) {
				System.out.println("null...");
			}
		}

}
		
}		


		
		



  
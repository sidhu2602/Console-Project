package employee_management_system;

import java.sql.*;
import java.util.Scanner;
import employee_management_system.connectiondb;
public class admin {
	connectiondb connectiondbobj=new connectiondb();
	Connection con=connectiondbobj.getConnection();
	
	int login() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user name");
		String name=sc.next();
		System.out.println("Enter password");
		String psd=sc.next();
		String sql="select * from login where uname='"+name+"' and password='"+psd+"'";
		Statement stmt = (Statement)con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		String str1="",str2="";
		while(rs.next())
		{
			str1=rs.getString(1);
			str2=rs.getString(2);
		}
		if(str1.equals(""))
		{
			System.out.println("Log in unsuccessfull");
			return 0;
		}
		else
		{
			System.out.println("Welcome "+str1);
			return 1;
			
		}
		
	}
	//add employee
	private static String a="";
	void addEmp() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee detailes");
		
		System.out.println("Eneter the employee Id");
		String emp_id=sc.next();
		System.out.println("Eneter the employee f_name");
		String f_name=sc.next();
		System.out.println("Eneter the employee l_name");
		String l_name=sc.next();
		System.out.println("Eneter the employee gender");
		String gender=sc.next();
		System.out.println("Eneter the employee age");
		int age=sc.nextInt();
		System.out.println("Eneter the employee dob (yy-mm-dd)");
		String dob=sc.next();
		System.out.println("Eneter the employee dept_id");
		String dept_id=sc.next();
		System.out.println("Eneter the employee email-id");
		String mail_id=sc.next();
		System.out.println("Eneter the employee contact_no");
		String contact_no=sc.next();
		sc.nextLine();
		System.out.println("Enter the employee address");
		String addr=sc.nextLine();
		
		String sql="insert into employee values('"+emp_id+"','"+f_name+"','"+l_name+"','"+gender+"','"+age+"','"+dob+"','"+dept_id+"','"+mail_id+"','"+contact_no+"','"+addr+"')";
		Statement stmt = (Statement)con.createStatement();
		int message=stmt.executeUpdate(sql);
		a=emp_id;
		System.out.println(message);
		if(message==1)
		{
			addSalary();
		}
	}
	
	public static String valu() throws Exception
	{
		return a;
	}
	
	
	void addRole() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		String staff_id= admin.valu();
		System.out.println("Enter the role");
		String role=sc.next();
		String sql="insert into role values('"+staff_id+"','"+role+"')";
		Statement stmt = (Statement)con.createStatement();
		int message=stmt.executeUpdate(sql);    
		
		System.out.println(message);
		
	}
	
	void addSalary() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		String staff_id=admin.valu();
		System.out.println("Enter the Salary");
		String salary=sc.next();
		
		String sql="insert into salary values('"+staff_id+"','"+salary+"')";
		Statement stmt = (Statement)con.createStatement();
		int message=stmt.executeUpdate(sql);
		
		System.out.println(message);
		if(message==1)
		{
			addRole();
		}
	}

	void addDept() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Department details");
		
		System.out.println("Enter the Department Id");
		String dept_id=sc.next();
		System.out.println("Enter the Department Name");
		String dept_name=sc.next();
		System.out.println("Enter the Department Head");
		String dept_head=sc.next();
		String sql="insert into department values('"+dept_id+"','"+dept_name+"','"+dept_head+"')";
		Statement stmt = (Statement)con.createStatement();
		int message=stmt.executeUpdate(sql);
		
		System.out.println(message);

	}
	
	int updateEmp() throws Exception {
		Scanner sc=new Scanner(System.in);
		int flg = 1;
		while(flg!=0)
		{
			System.out.println("Choose any option for changing the values");
			System.out.println("1 for emp_id , 2 for f_name , 3 for l_name , 4 for gender , 5 for age" );
			System.out.println("6 for dob , 7 for dept_id , 8 for mail_id , 9 for contact_no , 10 fro address");
			System.out.println( "Enter 0 for exit");
			int opt=sc.nextInt();
			sc.nextLine();
			if(opt==1)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				String sql="update employee set f_name='"+emp_id+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==2)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				System.out.println("Eneter the employee f_name");
				String f_name=sc.next();
				String sql="update employee set f_name='"+f_name+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==3)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				System.out.println("Eneter the employee l_name");
				String l_name=sc.next();
				String sql="update employee set l_name='"+l_name+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==4)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				System.out.println("Eneter the employee gender");
				String gender=sc.next();
				String sql="update employee set gender='"+gender+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==5)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				System.out.println("Eneter the employee age");
				int age=sc.nextInt();
				String sql="update employee set age='"+age+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==6)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				System.out.println("Eneter the employee dob (yy-mm-dd)");
				String dob=sc.next();
				String sql="update employee set dob='"+dob+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message+"Update the department if he/she is an Department Head");
			}
			if(opt==7)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				System.out.println("Eneter the employee dept_id");
				String dept_id=sc.next();
				String sql="update employee set dept_id='"+dept_id+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==8)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				System.out.println("Eneter the employee email-id");
				String mail_id=sc.next();
				String sql="update employee set mail_id='"+mail_id+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==9)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				System.out.println("Eneter the employee contact_no");
				String contact_no=sc.next();
				String sql="update employee set contact_no='"+contact_no+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==10)
			{
				System.out.println("Enter the employee id");
				String emp_id=sc.next();
				sc.nextLine();
				System.out.println("Enter the employee address");
				String addr=sc.nextLine();
				String sql="update employee set addr='"+addr+"' where emp_id='"+emp_id+"'";
				Statement stmt = (Statement)con.createStatement();
				int message=stmt.executeUpdate(sql);
				System.out.println(message);
			}
			if(opt==0)
			{
				flg=0;
			}
		}
		return 1;
	}
	
	void updateSal()throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id");
		String staff_id=sc.next();
		System.out.println("Enter the employee salary");
		String salary=sc.next();
		String sql="update employee set Salary='"+salary+"' where emp_id='"+staff_id+"'";
		Statement stmt = (Statement)con.createStatement();
		int message=stmt.executeUpdate(sql);
		System.out.println(message);
	}
	
	void updateRole() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id");
		String staff_id=sc.next();
		System.out.println("Enter the employee role");
		String role=sc.next();
		String sql="update employee set Role='"+role+"' where emp_id='"+staff_id+"'";
		Statement stmt = (Statement)con.createStatement();
		int message=stmt.executeUpdate(sql);
		System.out.println(message);
	}
	
	void updateDept() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id");
		String staff_id=sc.next();
		System.out.println("Enter the employee id");
		String dept_id=sc.next();
		System.out.println("Enter the employee id");
		String dept_name=sc.next();
		String sql="update employee set Dept_ID='"+dept_id+"', dept_name='"+dept_name+"' where emp_id='"+staff_id+"'";
		Statement stmt = (Statement)con.createStatement();
		int message=stmt.executeUpdate(sql);
		System.out.println(message);
	}
	
	void delete() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Employee Id to delete");
		String emp_id=sc.next();
		String sql1="delete from employee where emp_id='"+emp_id+"'";
		String sql2="delete from Role where staff_id='"+emp_id+"'";
		String sql3="delete from salary where staff_id='"+emp_id+"'";
		String sql4="delete from department where dept_head='"+emp_id+"'";
		Statement stmt=(Statement) con.createStatement();
		int message1=stmt.executeUpdate(sql1);
		int message2=stmt.executeUpdate(sql2);
		int message3=stmt.executeUpdate(sql3);
		int message4=stmt.executeUpdate(sql4);
		System.out.println(message1+" "+message2+" "+message3+" "+message4);
	}
	
	void display() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		
		int opt=1;
		while(opt!=0)
		{
			System.out.println("Enter 1 for display particular employee details");
			System.out.println("Enter 2 for display all employee details");
			System.out.println("Enter 3 for exit");
			int flg=sc.nextInt();
			if(flg==1)
			{
				System.out.println("Enter employee id");
				int emp_id=sc.nextInt();
				String sql="select * from employee where emp_id='"+emp_id+"'";
				Statement stmt=(Statement) con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					String employee_id=rs.getString("emp_id");
					String last_name=rs.getString("l_name");
					System.out.println(last_name+" "+employee_id);
				}
			}
			if(flg==2)
			{
				String sql="select * from employee";
				Statement stmt=(Statement) con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					String employee_id=rs.getString("emp_id");
					String first_name=rs.getString("f_name");
					System.out.println(first_name+" "+employee_id);
				}
			}
			if(flg==3)
			{
				opt=0;
			}
		}

	}
	

}

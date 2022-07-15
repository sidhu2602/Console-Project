package employee_management_system;

import java.sql.*;
import java.util.*;
import employee_management_system.connectiondb;
import employee_management_system.admin;
public class project {
	
	public static void main(String args[]) throws Exception
		{
			Scanner sc=new Scanner(System.in);
			project c = new project();
			Connection a=connectiondb.getConnection();
			admin ad=new admin();
			
			System.out.println("Enter 1 to login");
			int start=sc.nextInt();
			if(start==1)
			{
				int flag=ad.login();
				if(flag==1)
				{
					int flg=1;
					while(flg!=0)
					{
						System.out.println("Enter your choice");
						System.out.println("1 for Add_Employee");
						System.out.println("2 for Update_Employee");
						System.out.println("3 for Display_Employee");
						System.out.println("4 for Delete_Employee");
						System.out.println("5 for Add_Department");
						System.out.println("0 for Exit");
						int opt=sc.nextInt();
						if(opt==1)
						{
							ad.addEmp();
						}
						if(opt==2)
						{
							
							int f=1;
							while(f!=0)
							{
								int cho=sc.nextInt();
								if(cho==1)
								{
									ad.updateEmp();
								}
								if(cho==2)
								{
									ad.updateDept();
								}
								if(cho==3)
								{
									ad.updateSal();
								}
								if(cho==4)
								{
									ad.updateRole();
								}
								if(cho==0)
								{
									f=0;
								}
							}
						}
						if(opt==3)
						{
							ad.display();
						}
						if(opt==4)
						{
							ad.delete();
						}
						if(opt==5)
						{
							ad.addDept();
						}
						if(opt==0)
						{
							flg=0;
						}
							
					}
					
				}
				if(flag==0)
				{
					ad.login();
					int flg=1;
					while(flg!=0)
					{
						System.out.println("Enter your choice");
						System.out.println("1 for Add_Employee");
						System.out.println("2 for Update_Employee");
						System.out.println("3 for Display_Employee");
						System.out.println("4 for Delete_Employee");
						System.out.println("5 for Add_Department");
						System.out.println("0 for Exit");
						int opt=sc.nextInt();
						if(opt==1)
						{
							ad.addEmp();
						}
						if(opt==2)
						{
							
							int f=1;
							while(f!=0)
							{
								int cho=sc.nextInt();
								if(cho==1)
								{
									ad.updateEmp();
								}
								if(cho==2)
								{
									ad.updateDept();
								}
								if(cho==3)
								{
									ad.updateSal();
								}
								if(cho==4)
								{
									ad.updateRole();
								}
								if(cho==0)
								{
									f=0;
								}
							}
						}
						if(opt==3)
						{
							ad.display();
						}
						if(opt==4)
						{
							ad.delete();
						}
						if(opt==5)
						{
							ad.addDept();
						}
						if(opt==0)
						{
							flg=0;
						}
							
					}
				}
			}
			
		}
}

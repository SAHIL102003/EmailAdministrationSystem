package emailApp;
import java.util.*;
import java.io.*;
public class Email 
{
	public Scanner scan=new Scanner(System.in);  // Scanner is Global class
	
	private String fname;
	private String lname;
	private String dept;
	private String email;
	private String password;
	private int mailCapacity=500;
	private String alter_email;


//// Constructor to receive First name and Last name
	public Email(String fname,String lname)
	{
		this.fname=fname;
		this.lname=lname;
		System.out.println("New Employee : "+this.fname+" "+this.lname);	
		
		/// Calling Methods
		
		this.dept=this.setDept();                // Department
		this.password=this.generate_password(8); // Password
		this.email=this.generate_Email();        // Email Generation
		
	}
//// Generate Mail Method
	private String generate_Email()
	{
		return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
	}
//// Asking for the department
	private String setDept()
	{
		System.out.println("Department Codes \n1 For Sales\n2 For Development \n3 For Acounting\n4 For None");
		boolean flag= false;
		do
		{
			System.out.println("Enter the Department Code");
			int choice =scan.nextInt();
			switch (choice) 
			{
			case 1:
				return "Sales";
			case 2:
				return "Devlopment";
			case 3:
				return "Acounting";
			case 0:
				return "None";
			default:
				System.out.println("Inavalid Choice Please Choice it again");
			}	
		}
		while(!flag);
		return null;
	}
//// Generate Random password Method
	private String generate_password(int length)
	{ 
		Random r=new Random();
		String Capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars="abcdefghijklmnopqrstuv";
		String Numbers="0123456789";
		String Symbols="!@#$%?";
		String values=Capital_chars+Small_chars+Numbers+Symbols;
		String password="";
		for(int i=0;i<length;i++)
		{
			password=password+values.charAt(r.nextInt(values.length()));
		}
		return password;
	}
		
//// Change Password Method
	public void set_password()
	{
		boolean flag=false;
		do
		{
			System.out.println("Do you Want to change the Password !(Y/N)");
			char choice =scan.next().charAt(0);
			if(choice =='Y' || choice=='y')
			{
				flag=true;
				System.out.println("Enter the Current Password : ");
				String temp=scan.next();
				if(temp.equals(this.password))
				{
					System.out.println("Enter the New Password :");
					this.password=scan.next();
					System.out.println("Password Changed Sucessfully ");
				}
				else
				{
					System.out.println("Incorrect Password");
				}
			}
			else if(choice=='N'|| choice=='n')
			{
				flag=true;
				System.out.println("Password Changes Option is Cancelled !!!");
			}
			else
			{
				System.out.println("Enter the Valid Choice");
			}	
		}while(!flag);	
	}
	
//// set Mail box Capacity
	public void set_mailcap()
	{
		System.out.println("Current Capacity= "+this.mailCapacity+"mb");
		System.out.println("Enter the new MailBox Capacity : ");
		this.mailCapacity=scan.nextInt();
		System.out.println("Mailbox Capacity is Successfully Changed");
	}
	
//// set Alternate mail
	public void alternate_mail()
	{
		System.out.println("Enter the Alternate mail : ");
		this.alter_email=scan.next();
		System.out.println("Alternate Email is Set");		
	}

//// Display User Information
	public void getInfo()
	{
		System.out.println("New : "+this.fname+" "+this.lname);
		System.out.println("Department : "+this.dept);
		System.out.println("Email : "+this.email);
		System.out.println("Password : "+this.password); 
		System.out.println("MailBox Capacity : "+this.mailCapacity);
		System.out.println("Alternate Email : "+this.alter_email);
	}
		
//// Store in File
	public void storeFile()
	{
		try 
		{
			FileWriter in =new FileWriter("S:\\Study Material\\JavaProgrammingEclipse\\Email Adminstration System Project Data\\info");
			in.write("First Name :"+this.fname);
			in.append("\nLast Name :"+this.lname);
			in.append("\nEmail : "+this.email);
			in.append("\nPassword :"+this.password);
			in.append("\nCapacity :"+this.mailCapacity);
			in.append("\nAlternate Email :"+this.alter_email);
			in.close();
			System.out.println("Data Strored....");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
//// Reading File Method 
	public void readFile()
	{
		try 
		{
			FileReader f1=new FileReader("S:\\Study Material\\JavaProgrammingEclipse\\Email Adminstration System Project Data\\info");
			int i;
			while((i=f1.read())!=-1) 
			{
				System.out.print((char)i);
			}
			System.out.println();
			f1.close();
	
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}

package emailApp;
import java.util.*;
public class EmailApp 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		// User Info
		System.out.println("Enter the First Name :");
		String f_name =s.next();
		System.out.println("Enter the Last Name :");
		String l_name =s.next();
		
		// Creating Object For Email Class
		Email em1=new Email(f_name, l_name);
		int choice =-1;
		do {
			System.out.println("\n**********************\n Enter Your Choice \n1.Show Information \n2.Change Your Password \n3.Change Your MailBox Capacity \n4.Set Alternate Mail\n5.Strored Datas in File \n6.Display Data From File \n7.Exit");
			choice = s.nextInt();
			switch(choice)
			{
			case 1:
				em1.getInfo();
				break;
			case 2:
				em1.set_password();
				break;
			case 3:
				em1.set_mailcap();
			case 4:
				em1.alternate_mail();
				break;
			case 5:
				em1.storeFile();
				break;
			case 6:
				em1.readFile();
				break;
			case 7:
				System.out.println("Thankyou For USing These Application");
				break;
			default:
				System.out.println("Invalid Choice !!! \nEnter Proper Choice ");
			}
		}while(choice!=5);
	
	}

}

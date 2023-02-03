package prop.bank;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class details {
	static Scanner sc;
	account ac;
	List<account> l;
	
	
	details(){
		sc= new Scanner(System.in);
		l= new ArrayList();
	}
	
	
	void welcome() {
		System.out.printf(" %60s" ," * Welcome to Bank *\n");
	   System.out.println("===============================================================================================================================");
	}
	void Mainu()
	{
		System.out.printf("%60s"," * Main Mainu of Bank \n");
		 System.out.println("===============================================================================================================================");
		 System.out.printf("\n%-60s\n%-60s\n%-60s\n%-60s\n%-60s\n%-60s\n%-60s\n%-60s\n%-60s\n","1: Create Account","2: All Accounts","3: WithDrawal","4: Deposit","5:Transfer Amount","6:Search","7: Update","8: Delet","9:Exit");
	}
	
	void Add_ACC()
	{
		 System.out.println("Enter Account Holder Name:-");
		 String nm=sc.next();
		 System.out.println("Enter Contact Number:-");
		 String ph=sc.next();
		 System.out.println("Enter email Id");
		 String em = sc.next();
		 System.out.println("Enter Address");
		 String ad=sc.next();
		 System.out.println("Enter Account No");
		 long acc = sc.nextLong();
		 System.out.println("Enter Balance");
		 int bal = sc.nextInt();
		 System.out.println("Enter PassWord :- ");
		 long pass = sc.nextLong();
		 account ac= new account(acc,nm,bal,ph,em,ad,pass);
		 l.add(ac);
	}
	
	
	void all_acc() 
	{
	  l.forEach((m)->
	  {
		 System.out.println(" || Name - "+m.acc_ho_nm+" || Acc No. -  "+m.acc_no+" || Balance - "+m.balance+" || Contact - "+m.phone +" || Email - "+m.email);
		  System.out.println();
	  });	
	}
	
	void search(long acc_no)
	{
		ac = l.stream().filter((m)->
	    m.acc_no == acc_no
				).toList().get(0);
		System.out.println(ac);
	}
	
	
	void withdrawl() 
	{
		System.out.println("Enter Account no");
		long ac_no=sc.nextLong();
		System.out.println("Enter Password");
		long pas =sc.nextLong();
		search(ac_no);
		l.forEach((m)->{
			if(m.acc_no==ac_no && m.password==pas)
			{
				System.out.println("Enter anmount");
				long am = sc.nextLong();
				if(m.balance>am)
				{
				m.balance=m.balance-am;
				System.out.println("Your balance After Withdrawal is :- "+m.balance);
				}
				else {
					System.out.println("Insufficiant Balance :- "+ m.balance);
				}
			}
			else {
				System.out.println("Incorrect Cridentials");
			}
		});
	}
	
void deposit()
{
	System.out.println(" Enter Account Number :-");
	long ac_no=sc.nextLong();
	System.out.println("Enter Password");
	long pas= sc.nextLong();
	search(ac_no);
	l.forEach((m)->{
		if(m.acc_no==ac_no && m.password==pas)
		{
			System.out.println("Enter Depositing Amount");
			long dep = sc.nextLong();
			m.balance=m.balance+dep;
			System.out.println("Your Balance After Deposit Amount:- "+ m.balance);
		}
	});
}

void Update()
{
	System.out.println(" Enter Account Number :-");
	long ac_no=sc.nextLong();
	search(ac_no);
	l.forEach((m)->{
		if(m.acc_no==ac_no)
		{
			System.out.println("Selected The Option you want to Update");
			System.out.println("1: Name \n 2: Email \n 3: Address \n 4: contact \n 5: Password");
			int cho =sc.nextInt();
			switch(cho)
			{
			case 1:
				System.out.println("Enter Updated Name:-");
				String nme =sc.next();
				m.acc_ho_nm=nme;
				break;
			case 2:
				System.out.println("Enter New Email:-");
				String emai =sc.next();
				m.email=emai;
				break;
			case 3:
				System.out.println("Enter New Addresss:-");
				String addr =sc.next();
				m.address=addr;
				break;
			case 4:
				System.out.println("Enter Updated Name:-");
				String cont =sc.next();
				m.phone=cont;
				break;
			case 5:
				System.out.println("Enter New Name:-");
				long pword =sc.nextLong();
				m.password=pword;
				break;
				
			}
               System.out.println(m);
			
		}
	});
}

	void transferMoney() {
		System.out.println(" Enter Account Number :-");
		long ac_no=sc.nextLong();
		System.out.println("Enter Password");
		long pas= sc.nextLong();
		search(ac_no);
		l.forEach((m)->{
			if(m.acc_no==ac_no && m.password==pas) {
			System.out.println("Enter Amount You Want to Transfer :-");
			long am=sc.nextLong();
			if(m.balance>=am) {
				m.balance=m.balance-am;
				
				System.out.println(" Enter Account Number :-");
				long ac_no2=sc.nextLong();
				
				search(ac_no2);
				
				l.forEach((n)->{
					if(n.acc_no==ac_no2)
					{
					n.balance=n.balance+am;
					System.out.println("Deposited to :-"+n.acc_ho_nm+" || And Now Balance is - "+n.balance);
					}
					
					
				});
				System.out.println("Depositer to :-"+m.acc_ho_nm+" || And Now Balance is - "+m.balance);
				
				
			}else {
				System.out.println("Insufficent Balance ");
			}
			
			
	}
			
			
		});
	}
	
	
void delete()
{
	System.out.println("Enter The Account You Want to delete");
	long ac_no=sc.nextLong();
	search(ac_no);
	l.remove(ac);
	System.out.println("Account Deleted Succesfully.....! ");
}

	public static void main(String[] g)
	{
		
		details obj= new details();
	        obj.welcome();
	       
		System.out.print("Please Enter User name :-");
		String user=sc.next();
		System.out.println();
		System.out.print("Please Enter User Password :-");
		long password=sc.nextInt();
		System.out.println("wait....");
		String temp ="";
		if( user.equals("sant") && 1234==password) {
			while(!temp.equals("n"))
			{
			obj.Mainu();
			System.out.println("Enter your Required Option :-");
			int ch ;
			ch=sc.nextInt();
			switch(ch)
			{
			  case 1:
				    obj.Add_ACC();
				    break;
			  case 2:
				  obj.all_acc();
				  break;
				  
			  case 3:
				  obj.withdrawl();
				  break;
			  case 4:
				  obj.deposit();
				  break;
			  case 5:
				  obj.transferMoney();
				  break;
				  
			  case 6: 
				  System.out.println("Enter Account_No you want to Search ");
				  int search = sc.nextInt();
				  obj.search( search);
				  break;
			  case 7:
				  obj.Update();
				  break;
				  
			  case 8:
				  obj.delete();
				  break;
			  case 9:
				  System.exit(0);
			}
			 System.out.println("Do you want to Continue if yes Enter 'Y' or Want to end Enter 'N' ");
			 temp=sc.next().toLowerCase();
     }
			
	
		}else {
			System.out.println("try again");
		}
		
		
		
	}

}

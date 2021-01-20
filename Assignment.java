import java.util.*;
import java.util.HashMap;

class Librarian extends Student
{
	public void login()
	{
		Scanner ln = new Scanner(System.in);
		System.out.println("Enter User name");
		String lname = ln.nextLine();
		System.out.println("Enter password");
		String lpass = ln.nextLine();
		if(lname.equals("admin") && lpass.equals("admin"))
		{
			System.out.println("Login successful");
			System.out.println("");
			String q = "yes";
			System.out.println("*************************************************");
				System.out.println("****************Welcome librarian****************");
				System.out.println("*************************************************");
				System.out.println("");
				System.out.println(" 1. Add book");
				System.out.println(" 2. View Books");
				System.out.println(" 3. Check books taken by students");
				System.out.println(" 3. Check books taken by students");
				System.out.println(" 4. Exit ");
				int ch1 = ln.nextInt();
			switch(ch1)
			{
				case 1 : add();
						 break;
				
				case 2 : viewBooks();
						 break;
						 
				case 3 : viewstudents();
					 	 break;
						 
				case 4 : exit();
						 break;
			}
		}
		else
		{
			System.out.println("Login failed");
		}
	}
	public void add()
	{
		Book b = new Book();
		b.newBook();
	}
	public void viewBooks()
	{
		Book b = new Book();
		b.view();
	}
	public void viewstudents()
	{
		Student s = new Student();
		s.viewStu();
	}
}
	
class Book
{
	HashMap<Integer, ArrayList<String>> bdata = new HashMap<Integer, ArrayList<String>> ();
	ArrayList<String> bdata1 = new ArrayList<String> ();
	Scanner rb = new Scanner(System.in);
	public void newBook()
	{
		String h ="yes";
		while(h.equals("yes"))
		{
			
			System.out.println("Enter book id : ");
			int ib = rb.nextInt();
			System.out.println("Enter book title : ");
			String title = rb.next();
			System.out.println("Enter book subject : ");
			String sub = rb.next();
			System.out.println("Enter book author : ");
			String aut = rb.next();
			System.out.println("Enter book pages : ");
			String page = rb.next();
			System.out.println("Enter book price : ");
			String price = rb.next();
			bdata1.add(title);
			bdata1.add(sub);
			bdata1.add(aut);
			bdata1.add(page);
			bdata1.add(price);
			bdata.put(ib,bdata1);
			System.out.println("Book added successfully");
			System.out.println(bdata);
			System.out.println("Do you want to add few more books ? yes/no");
			h = rb.next();
		}	
	}
	public void view()
	{
		System.out.println(bdata);
	}
	public void search()
	{
		System.out.println("Enter author name or title");
		String sr = rb.next();
		if(bdata.containsValue(sr))
		{
			System.out.println("Book found");
		}
		else
		{
			System.out.println("Book not found");
		}
	}
	
}		
class Student
{
	ArrayList<String> sdata = new ArrayList<String>();
	HashMap<Integer, ArrayList<String>> sdata1 = new HashMap<Integer, ArrayList<String>>();
	public void login(ArrayList<String> sdata,HashMap<Integer, ArrayList<String>> sdata1)
	{
		Scanner sn = new Scanner(System.in);
		System.out.println("Enter User name");
		String suname = sn.nextLine();
		System.out.println("Enter password");
		String supass = sn.nextLine();
		if(sdata1.containsValue(suname) && sdata1.containsValue(supass))
		{
			System.out.println("Login successful");
			System.out.println("");
			System.out.println("*************************************************");
			System.out.println("****************Welcome Student****************");
			System.out.println("*************************************************");
			System.out.println("");
			System.out.println(" 1. Search");
			System.out.println(" 2. Take Books");
			System.out.println(" 3. Exit ");
			int ch2 = sn.nextInt();
			switch(ch2)
			{
				case 1 : searchbook();
						 break;
				
				//case 2 : takeBooks();
					//	 break;
			}
			
		}
		else
		{
			System.out.println("Login failed");
			System.out.println("if you dont have account press 1 to register ");
			int w = sn.nextInt();
			if(w==1)
			{
				registration();
			}
		}
	}
	public void registration(ArrayList<String> sdata,HashMap<Integer, ArrayList<String>> sdata1)
	{
		Scanner r = new Scanner(System.in);
		Scanner p = new Scanner(System.in);
		System.out.println("Enter Roll No.");
		int sroll = r.nextInt();
		System.out.println("Enter User name");
		String sname = r.next();
		sdata.add(sname);
		System.out.println("Enter password");
		String spass = p.nextLine();
		sdata.add(spass);
		sdata1.put(sroll,sdata);
		System.out.println("Student registered successfully");
		System.out.println("");
		System.out.println("************************************** *******************");
		System.out.println("********************* Now lets login *********************");
		System.out.println("******************* Enter your details *******************");
		System.out.println("************************************** *******************");
		System.out.println("");
		login();
	}
	public void searchbook()
	{
		Book b = new Book();
		b.search();
	}
	public void viewStu()
	{
		System.out.println(sdata1);
	}
}	
public class Assignment
{
	public static void main(String args[])
	{
		System.out.println("");
		System.out.println("**********************************************");
		System.out.println("*****Welcome to library management system*****");
		System.out.println("**********************************************");
		System.out.println("1. Login as librarian");
		System.out.println("2. Login as Student");
		System.out.println("3. Student registration");
		System.out.println("");
		System.out.println("Enter your choice");
		Scanner in = new Scanner(System.in);
		int ch = in.nextInt();
		Student s = new Student();
		switch(ch)
		{
			case 1: System.out.println("**********************Librarian login**********************");
					Librarian l = new Librarian();
					l.login();
					break;
					
			case 2: System.out.println("**********************Student login**********************");
					s.login();
					break;
					
			case 3: System.out.println("**********************Student registration**********************");
					s.registration();
					break;
		}
	}
}
	
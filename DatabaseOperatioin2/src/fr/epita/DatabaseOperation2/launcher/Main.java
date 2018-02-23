/**
 * 
 */
package fr.epita.DatabaseOperation2.launcher;

import java.io.IOException;
import java.util.Scanner;

import fr.epita.DatabaseOperation2.datamodel.Authentication;
import fr.epita.DatabaseOperation2.datamodel.Identity;
import fr.epita.DatabaseOperation2.exceptions.IdentityCreationException;
//import fr.epita.DatabaseOperation2.services.IdentityDAO;
import fr.epita.DatabaseOperation2.services.IdentityJDBCDAO;

/**
 * @author Jaydev
 *
 */
public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static String choice;
	private static String decision;
	final static IdentityJDBCDAO dao = new IdentityJDBCDAO();
	final static Identity id1 = new Identity();
	final static Authentication ud1 = new Authentication();
//	private static final char ch = 0;
	
	
	private static void getalldata() {
				
		System.out.println("Enter your DisplayName:");
		id1.setDisplayName(sc.next());
		System.out.println("Enter your Email:");
		id1.setEmail(sc.next());
		System.out.println("Enter your Uid:");
		id1.setUid(sc.next());
		
		try {
			dao.create(id1);
			dao.showalldata(id1);
		} catch (IdentityCreationException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	sc.close();
	}
	
	private static void searchdata() throws IdentityCreationException{
		final Identity id1 = new Identity();
		String rowname;
		System.out.println("By which Identity do you want to search: ");
		rowname = sc.next();
		
		if(rowname.contentEquals("displayname")) {
			System.out.println("Enter DisplayName for search: ");
			id1.setDisplayName(sc.next());	
		}
		else if(rowname.contentEquals("emailid")) {
			System.out.println("Enter Email Id for search: ");
			id1.setEmail(sc.next());	
		}
		else if(rowname.contentEquals("uid") ) {
			System.out.println("Enter User id for search: ");
			id1.setUid(sc.next());
			
		}
		dao.search(id1);
		sc.close();
	
	
	}
	

	private static void updatedata() {
		
		
		System.out.println("Enter your Uid:");
		id1.setUid(sc.next());
		System.out.println("Enter your DisplayName:");
		id1.setDisplayName(sc.next());
		System.out.println("Enter your Email:");
		id1.setEmail(sc.next());
		try {
			dao.update(id1);
			
;		} catch (IdentityCreationException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		sc.close();
	}

	private static void showdata() {
		dao.showalldata(id1);
	}
	
	private static void deletedata() {
		
		
			System.out.println("Enter User id for search: ");
			id1.setUid(sc.next());
			dao.delete(id1);
			sc.close();
			System.out.println("Identity has been Deleted.");
		}
		
//	private static void clr() throws IOException {
//		final String operatingSystem = System.getProperty("os.name");
//
//		if (operatingSystem .contains("Windows")) {
//		    Runtime.getRuntime().exec("cls");
//		}
//		else {
//		    Runtime.getRuntime().exec("clear");
//		}
//	}
	private static void login() {
		System.out.println("Enter User Name :");
		ud1.setUserName(sc.next());
		System.out.println("Enter password:");
		ud1.setPassword(sc.next());
		try {
			dao.matchuser(ud1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	public static void main(String[] args) throws IdentityCreationException, IOException {
		
		login();
			
		while(true) {
		System.out.println("----------------------------------------------------");
		System.out.println("----------------------------------------------------");
		
		System.out.println("Print 1 to Create a Data");
		System.out.println("Print 2 to Search a Data");
		System.out.println("Print 3 to Update a Data");
		System.out.println("Print 4 to Delete a Data");
		
		choice=sc.next();
		
		if(choice.isEmpty()){
			System.out.println("ENTER A CORRECT NUMBER!!!!");
		}
		
		switch(choice) {
		case "1": 
		{
		getalldata();
		
		break;}	
		case "2": 
		searchdata(); 
				  break;
		case "3": {
			updatedata();
				 
				  showdata(); 
				  break;}
		case "4": {
			
			deletedata(); 
		 
		showdata(); break;}
		default: break;
		}
		
		 System.out.println("enter another name : yes or no");
	        decision = kbd.nextLine();

	        switch(decision){
	        case "yes":
	            yn = false;
	            break;
	        case "no": 
	            yn = true;
	            break;
	        default : 
	            System.out.println("please enter again ");
	             return default;
	        }
	}
		sc.close();
				
	}

	
	
}

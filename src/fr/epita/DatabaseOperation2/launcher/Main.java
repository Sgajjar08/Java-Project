/**
 * 
 */
package fr.epita.DatabaseOperation2.launcher;

import java.util.Scanner;

import fr.epita.DatabaseOperation2.datamodel.Identity;

/**
 * @author Jaydev
 *
 */
public class Main {
	public static void main(String[] args) {
		Identity id1 = new Identity();
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter your DisplayName:");
		id1.setDisplayName(sc.nextLine());
		System.out.println("Enter your Email:");
		id1.setEmail(sc.nextLine());
		System.out.println("Enter your Uid:");
		id1.setUid(sc.nextLine());
		sc.close();
		System.out.println(id1);
		/*id1.setDisplayName("Thomas");
		id1.setUid("123");
		id1.setEmail("tbr@tbr.com");
		
		System.out.println(id1);*/
		
	}

}

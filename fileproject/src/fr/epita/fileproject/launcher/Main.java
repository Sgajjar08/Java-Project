package fr.epita.fileproject.launcher;

import fr.epita.fileproject.datamodel.Identity;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//this is for Run as Java Application for initial test
		Identity id1 = new Identity();
		id1.setDisplayName("Thomas");
		id1.setUid("123");
		id1.setEmail("tbr@tbr.com");
		
		System.out.println(id1);
	}

}

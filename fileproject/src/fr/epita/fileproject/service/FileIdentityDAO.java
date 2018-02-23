package fr.epita.fileproject.service;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.fileproject.datamodel.Identity;

public class FileIdentityDAO {

	private String filePath;
	private Scanner scanner;
	private PrintWriter printwriter;

	
	public FileIdentityDAO(String path) throws IOException {
		
		filePath = path;
		
		final File file = new File(filePath);
		if(!file.exists()) {
			file.getParentFile().mkdirs();
			
			file.createNewFile();
		}
		
		
		printwriter = new PrintWriter(file);         //Write a file
		scanner = new Scanner(file);                 //Read a file
		
	}


	public void create(Identity identity) {
		printwriter.println("----------------------");
		printwriter.println(identity.getUid());
		printwriter.println(identity.getEmail());
		printwriter.println(identity.getDisplayName());
		printwriter.println("----------------------");
		printwriter.flush();
	}
	
	public List<Identity> search(Identity criteria){
		final List<Identity> result = new ArrayList<>();
		while(scanner.hasNext()) {
			final Identity currentIdentity = new Identity();  //new instance
			scanner.nextLine();
			currentIdentity.setUid(scanner.nextLine());
			currentIdentity.setEmail(scanner.nextLine());
			currentIdentity.setDisplayName(scanner.nextLine());
			scanner.nextLine();
			
			if(checkMatch(criteria, currentIdentity)) {
				result.add(currentIdentity);
			}
		}
		return result;
	}


	private boolean checkMatch(Identity criteria, Identity currentIdentity) {
		boolean result = false;
		if(criteria.getDisplayName()!= null) {
			result = result || currentIdentity.getDisplayName().startsWith(criteria.getDisplayName());
		}
		if(criteria.getEmail()!= null) {
			result = result || currentIdentity.getEmail().startsWith(criteria.getEmail());
		}
		if(criteria.getUid()!= null) {
			result = result || currentIdentity.getUid().equals(criteria.getUid());
		}
		return result;
	}
	
	public void update(Identity identity) {
		printwriter.println("----------------------");
		printwriter.println(identity.getUid());
		printwriter.println(identity.getEmail());
		printwriter.println(identity.getDisplayName());
		printwriter.println("----------------------");
		printwriter.flush();

	}
	
	public void delete(Identity identity) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		
		while(br.readLine() == identity.getDisplayName())
		{
			if(trim().equals(identity.getDisplayName())) {
				System.out.println("deleted");
				printwriter.flush();
			}
			
		}
		br.close();
	}


	private Object trim() {
		// TODO Auto-generated method stub
		
		
	
		return null;
	}
}

package fr.epita.fileproject.test.services;

import java.io.IOException;
import java.util.List;

import fr.epita.fileproject.datamodel.Identity;
import fr.epita.fileproject.exceptions.IdentityCreationException;
import fr.epita.fileproject.service.FileIdentityDAO;

public class TestFileOperation {
	
	public static void main(String[] args) throws IOException {
		try {
			testCreateUpdateAndSearch();
		} catch (IdentityCreationException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	
	private static void testCreateUpdateAndSearch() throws IOException, IdentityCreationException {
		
		final FileIdentityDAO dao = new FileIdentityDAO("/javatest/fileoperation1/Identity.txt");
		final Identity id1 = new Identity();
		id1.setDisplayName("Saurabh");
		id1.setEmail("saurabhgajjar134@gmail.com");
		id1.setUid("1234");
		
		dao.create(id1);
		
		id1.setDisplayName("thomas");
		
		dao.update(id1);
		
		final Identity criteria = new Identity();
		criteria.setDisplayName("thomas");
		final List<Identity> identities = dao.search(criteria);
		
		if (identities.get(0).equals(id1)) {
			System.out.println("success");
		} else {
			System.out.println("failure");
		}
		
		id1.setDisplayName("thomas");
		dao.delete(id1);
	}
		
}
		



/**
 * 
 */
package fr.epita.fileproject.service;

import java.util.List;

import fr.epita.fileproject.datamodel.Identity;
import fr.epita.fileproject.exceptions.IdentityCreationException;

/**
 * @author Saurabh
 *
 */
public interface IdentityDAO {
	
	public void create(Identity identity) throws IdentityCreationException;
	public void update(Identity identity);
	public void delete(Identity identity);
	public List<Identity> search(Identity criteria);
	

}

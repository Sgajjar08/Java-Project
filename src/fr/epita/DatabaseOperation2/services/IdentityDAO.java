/**
 * 
 */
package fr.epita.DatabaseOperation2.services;

//import java.util.List;

import fr.epita.DatabaseOperation2.datamodel.Identity;
import fr.epita.DatabaseOperation2.exceptions.IdentityCreationException;

/**
 * @author Jaydev
 *
 */
public interface IdentityDAO {
	public void create(Identity identity) throws IdentityCreationException;
	//public void update(Identity identity);
	//public void delete(Identity identity);
	//public List<Identity> search(Identity criteria);
}

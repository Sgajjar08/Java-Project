/**
 * 
 */
package fr.epita.DatabaseOperation2.exceptions;

import fr.epita.DatabaseOperation2.datamodel.Identity;

/**
 * @author Jaydev
 *
 */
public class IdentityCreationException extends Exception{

	Identity faultyIdentity;
	public IdentityCreationException(Identity identity, Exception originalCause) {
		faultyIdentity = identity;
		initCause(originalCause);

	}

	@Override
	public String getMessage() {
		return "problem occured while creating that identity in the system " + faultyIdentity.toString();
	}

}

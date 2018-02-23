package fr.epita.fileproject.exceptions;

import fr.epita.fileproject.datamodel.Identity;

//User-defined exception

public class IdentityCreationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8914667981636642234L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	Identity faultyIdentity;
	
	public IdentityCreationException(Identity identity, Exception orignalCause) {
		faultyIdentity = identity;
		initCause(orignalCause);
	}
	
	public String getMessage() {
		return "problem occured while creating that identity in the system " + faultyIdentity.toString();
	}
}

/**
 * 
 */
package fr.epita.DatabaseOperation2.exceptions;

import fr.epita.DatabaseOperation2.datamodel.Authentication;


/**
 * @author Jaydev
 *
 */
public class Loginerror extends Exception {

	Authentication faultyLogin;
	public Loginerror(Authentication aunth, Exception originalCause) {
		faultyLogin = aunth;
		initCause(originalCause);

	}

	@Override
	public String getMessage() {
		return "problem occured while Login" + faultyLogin.toString();
	}

}

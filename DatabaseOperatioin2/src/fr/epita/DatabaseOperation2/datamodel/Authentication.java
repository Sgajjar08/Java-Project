/**
 * 
 */
package fr.epita.DatabaseOperation2.datamodel;

/**
 * @author Jaydev
 *
 */
public class Authentication {
	private String userName;
	private String password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public Authentication(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	/* below method is constractor for solve runtime error when we call Identity in other class
	   without Parameters*/
	public Authentication() {
		
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		// when we call Identity with i.Identity 
		if(getClass() != obj.getClass()) {
			return false;
		}
		// we are passing obj Object to Identity 
		final Authentication other = (Authentication) obj;
		if(userName == null) {
			if(other.userName != null) {
				return false;
			}
		}	
		else if(!userName.equals(other.userName)) {
				return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return false;
	}
}

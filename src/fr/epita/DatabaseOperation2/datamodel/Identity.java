/**
 * 
 */
package fr.epita.DatabaseOperation2.datamodel;

import fr.epita.DatabaseOperation2.datamodel.Identity;

/**
 * @author Jaydev
 *
 */
public class Identity {
	
	private String displayName;
	private String email;
	private String uid;
	
	public Identity(String displayName, String email, String uid) {
		this.displayName = displayName;
		this.email = email;
		this.uid = uid;
	}
	/* below method is constractor for solve runtime error when we call Identity in other class
	   without Parameters*/
	public Identity() {
		
	}
	// getter and setter method to extract encapsulation parameter  
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	//hashCode(), toString(), equals() are default methods to Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (displayName == null ? 0 : displayName.hashCode());
		result = prime * result + (email == null ? 0 : email.hashCode());
		result = prime * result + (uid == null ? 0 : uid.hashCode());
		return result;
	}
	
	public String toString() {
		return "Identity [DisplayName =" + displayName + ", Email =" + email + ", Uid =" + uid + " ]";
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
		final Identity other = (Identity) obj;
		if(displayName == null) {
			if(other.displayName != null) {
				return false;
			}
		}	
		else if(!displayName.equals(other.displayName)) {
				return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (uid == null) {
			if (other.uid != null) {
				return false;
			}
		} else if (!uid.equals(other.uid)) {
			return false;
		}
		
		return true;
		
	}
}

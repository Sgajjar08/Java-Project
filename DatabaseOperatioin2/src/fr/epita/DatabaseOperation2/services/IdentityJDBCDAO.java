/**
 * 
 */
package fr.epita.DatabaseOperation2.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.DatabaseOperation2.datamodel.Authentication;
import fr.epita.DatabaseOperation2.datamodel.Identity;
import fr.epita.DatabaseOperation2.exceptions.IdentityCreationException;
import fr.epita.DatabaseOperation2.exceptions.Loginerror;
import fr.epita.logger.Logger;

/**
 * @author Jaydev
 *
 */
public class IdentityJDBCDAO implements IdentityDAO{

	private static final Logger LOGGER = new Logger(IdentityJDBCDAO.class);

	
	@SuppressWarnings("null")
	public void matchuser(Authentication auth) throws Loginerror{
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT USER_NAME, PASSWORD FROM USERS  WHERE USER_NAME = ? AND PASSWORD = ?");
			preparedStatement.setString(1, "saurabhgajjar");
			preparedStatement.setString(2, "Sgajjar08");
			
			final ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				connection.close();
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("error in create method :" + e.getMessage());
			final Loginerror businessException = new Loginerror(auth, e);

			throw businessException;
		}finally {
			try {
				if(connection!= null) {
					connection.close();
				}
				else {
					connection.close();
				}
			}catch(final SQLException E) {
				System.out.println(E.getMessage());
				E.printStackTrace();
			}
		}
	}
	public void create(Identity identity) throws IdentityCreationException {
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO IDENTITIES(UID, DISPLAY_NAME, EMAIL) values (?,?,?) ");
			preparedStatement.setString(1, identity.getUid());
			preparedStatement.setString(2, identity.getDisplayName());
			preparedStatement.setString(3, identity.getEmail());
			preparedStatement.execute();

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("error in create method :" + e.getMessage());
			final IdentityCreationException businessException = new IdentityCreationException(identity, e);

			throw businessException;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}


	public List<Identity> search(Identity criteria) {
		final List<Identity> identities = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement preparedStatement = connection
					.prepareStatement("select UID, DISPLAY_NAME, EMAIL FROM IDENTITIES WHERE DISPLAY_NAME = ? OR EMAIL = ? OR UID = ? ");
			preparedStatement.setString(3, criteria.getUid());
			preparedStatement.setString(1, criteria.getDisplayName());
			preparedStatement.setString(2, criteria.getEmail());

			final ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final Identity identity = new Identity();
				identity.setDisplayName(resultSet.getString(1));
				identity.setEmail(resultSet.getString(2));
				identity.setUid(resultSet.getString(3));
				identities.add(identity);
				
				System.out.println(identity);
			}
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("error while searching", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				LOGGER.error("unresolved error", e);
			}
		}

		return identities;
	}

	public void update(Identity identity) throws IdentityCreationException {
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE IDENTITIES SET UID = ?, DISPLAY_NAME = ?, EMAIL= ? WHERE UID = ?");
			
			preparedStatement.setString(3, identity.getUid());
			preparedStatement.setString(1, identity.getDisplayName());
			preparedStatement.setString(2, identity.getEmail());
			
			
		}catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("error in create method :" + e.getMessage());
			final IdentityCreationException businessException = new IdentityCreationException(identity, e);

			throw businessException;
		}finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (final SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			} 
	}
	
	public List<Identity> showalldata(Identity criteria) {
		final List<Identity> identities = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM IDENTITIES ");

			final ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final Identity identity = new Identity();
		
				identity.setDisplayName(resultSet.get(1));
				identity.setEmail(resultSet.getString(2));
				identity.setUid(resultSet.getString(3));
				
				
				System.out.println(identity);
			}
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("error while searching", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				LOGGER.error("unresolved error", e);
			}
		}

		return identities;
	}
	@Override
	public void delete(Identity identity) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM IDENTITIES WHERE UID = ? ");
			preparedStatement.setString(3, identity.getUid());
			
		}catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("error in create method :" + e.getMessage());
		}finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (final SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			} 
		
	}

	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {

		final String connectionString = Configuration.getInstance().getProperty("db.host");
		//System.out.println(connectionString);
		final String userName = "Saurabh";
		final String password = "1234";

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		final Connection connection = DriverManager.getConnection(connectionString, userName, password);
		return connection;
	}


	
}

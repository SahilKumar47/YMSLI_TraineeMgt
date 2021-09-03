package com.traineemgt.model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.traineemgt.model.dao.factory.JdbcConnectionFactory;
import com.traineemgt.model.exceptions.DataAccessException;
import com.traineemgt.model.exceptions.UserNotFoundException;

public class UserDaoImpl implements UserDao {

	private Connection connection;

	public UserDaoImpl() {
		connection = JdbcConnectionFactory.getConnection();
	}

	@Override
	public User getUser(String username, String password) {
		User user = null;
		String get_user = "select * from users where username=? and password=?";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(get_user);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id"), username, password);
			} else {
				throw new UserNotFoundException("user with username " + username + " is not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		return user;

	}

}

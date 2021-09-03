package com.traineemgt.model.dao.trainee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.traineemgt.model.dao.factory.JdbcConnectionFactory;
import com.traineemgt.model.exceptions.DataAccessException;

public class TraineeDaoImpl implements TraineeDao {

	private Connection connection;

	public TraineeDaoImpl() {
		connection = JdbcConnectionFactory.getConnection();
	}

	@Override
	public List<Trainee> getAllTrainees() {
		if (connection == null)
			System.out.println("-------its null------------");

		List<Trainee> trainees = new ArrayList<>();
		Trainee tempBook;
		try {
			String all_books_query = "select * from trainee";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(all_books_query);
			while (rs.next()) {
				tempBook = new Trainee(rs.getInt("trainee_id"), rs.getString("trainee_name"), rs.getString("branch"),
						rs.getDouble("percentage"));

				trainees.add(tempBook);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DataAccessException(ex.getMessage());
		}
		return trainees;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		try {
			String add_trainee_query = "insert into trainee(trainee_name, branch, percentage) values(?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(add_trainee_query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, trainee.getTrainee_name());
			pstmt.setString(2, trainee.getBranch());
			pstmt.setDouble(3, trainee.getPercentage());

			int noOfRowsEffected = pstmt.executeUpdate();

			if (noOfRowsEffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				trainee.setTrainee_id(rs.getInt(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DataAccessException(ex.getMessage());
		}

		return trainee;
	}

}

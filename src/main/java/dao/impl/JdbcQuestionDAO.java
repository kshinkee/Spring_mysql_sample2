package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import dao.QuestionDAO;
import model.Question;

public class JdbcQuestionDAO implements QuestionDAO {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Question question){
		
		String sql = "INSERT INTO question " +
				"(QUESTION_TEXT, PUB_DATE) VALUES (?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, question.getQuestionId());
			ps.setString(1, question.getQuestionText());
			ps.setDate(2, (java.sql.Date) question.getPubDate());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Question findByQuestionId(int questionId){
		
		String sql = "SELECT * FROM question WHERE ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, questionId);
			Question question = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				question = new Question(
					rs.getInt("ID"),
					rs.getString("QUESTION_TEXT"), 
					rs.getDate("PUB_DATE")
				);
			}
			rs.close();
			ps.close();
			return question;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}

package dao;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

public class UserPosJavaDao {
	
	private Connection connection;

	public UserPosJavaDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(UserPosJava posJava) throws SQLException {
		String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		try {
			insert.setLong(1, posJava.getId());
			insert.setString(2, posJava.getNome());
			insert.setString(3, posJava.getEmail());
			insert.execute();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.UserPosJava;

public class UserPosJavaDao {

	private Connection connection;

	public UserPosJavaDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(UserPosJava posJava) throws SQLException {
		String sql = "insert into userposjava (nome, email) values (?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		try {
			insert.setString(1, posJava.getNome());
			insert.setString(2, posJava.getEmail());
			insert.execute();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
	}

	public void salvarTelefone(Telefone telefone) throws SQLException {
		try {
			String sql = "INSERT INTO public.telefone(\r\n" + "             numero, tipo, usuariopessoa)\r\n"
					+ "    VALUES ( ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
		}
	}

	public List<UserPosJava> findAll() throws Exception {
		List<UserPosJava> list = new ArrayList<>();
		String sql = "select * from userposjava";
		PreparedStatement stament = connection.prepareStatement(sql);
		ResultSet resultSet = stament.executeQuery();
		while (resultSet.next()) {
			UserPosJava userPosJava = new UserPosJava();
			userPosJava.setId(resultSet.getLong("Id"));
			userPosJava.setNome(resultSet.getString("nome"));
			userPosJava.setEmail(resultSet.getString("email"));

			list.add(userPosJava);
		}
		return list;
	}

	public UserPosJava findById(Long id) throws Exception {
		UserPosJava retorno = new UserPosJava();
		String sql = "select * from userposjava where id = " + id;

		PreparedStatement stament = connection.prepareStatement(sql);
		ResultSet resultSet = stament.executeQuery();

		while (resultSet.next()) {
			retorno.setId(resultSet.getLong("Id"));
			retorno.setNome(resultSet.getString("nome"));
			retorno.setEmail(resultSet.getString("email"));
		}
		return retorno;
	}

	public void update(UserPosJava userPosJava) throws SQLException {
		String sql = "update userposjava set nome = ? where id = " + userPosJava.getId();
		try {
			PreparedStatement stament = connection.prepareStatement(sql);
			stament.setString(1, userPosJava.getNome());
			stament.execute();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
	}

	public void delete(UserPosJava userPosJava) throws SQLException {
		try {
			String sql = "delete from userposjava where id = " + userPosJava.getId();
			PreparedStatement stament = connection.prepareStatement(sql);
			stament.execute();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
	}

	public List<BeanUserFone> listaUserFone(Long id) {

		List<BeanUserFone> beanUserFones = new ArrayList<>();

		String sql = "select * from telefone as fone ";
		sql += "inner join userposjava as us ";
		sql += "on fone.usuariopessoa = us.id where us.id = " + id;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				BeanUserFone userFone = new BeanUserFone();
				userFone.setEmail(resultSet.getString("email"));
				userFone.setNome(resultSet.getString("nome"));
				userFone.setNumero(resultSet.getString("numero"));
				beanUserFones.add(userFone);
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return beanUserFones;
	}
}

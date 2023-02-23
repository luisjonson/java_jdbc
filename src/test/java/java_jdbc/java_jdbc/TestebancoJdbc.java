package java_jdbc.java_jdbc;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import dao.UserPosJavaDao;
import model.UserPosJava;

public class TestebancoJdbc {

	@Test
	public void initBanco() {
		UserPosJavaDao userPosJavaDao = new UserPosJavaDao();
		UserPosJava userPosJava = new UserPosJava();
		userPosJava.setNome("Marcos Alex");
		userPosJava.setEmail("marcosalex@hotmail.com");
		try {
			userPosJavaDao.salvar(userPosJava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

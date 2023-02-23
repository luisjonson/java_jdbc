package java_jdbc.java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.UserPosJavaDao;
import model.UserPosJava;

public class TestebancoJdbc {

	@Test
	public void initBanco() {
		UserPosJavaDao userPosJavaDao = new UserPosJavaDao();
		UserPosJava userPosJava = new UserPosJava();
		userPosJava.setNome("maria chiquinha");
		userPosJava.setEmail("marcosalex@hotmail.com");
		try {
			userPosJavaDao.salvar(userPosJava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initList() throws Exception {
		UserPosJavaDao dao = new UserPosJavaDao();
		List<UserPosJava>list = dao.findAll();
		list.forEach(System.out::print);
	}
	
	@Test
	public void initById() throws Exception {
		UserPosJavaDao dao = new UserPosJavaDao();
		UserPosJava userPosJava = dao.findById(4L);
		System.out.println(userPosJava);
	}
	
	@Test
	public void initAlterName() throws Exception {
		UserPosJavaDao dao = new UserPosJavaDao();
		UserPosJava userPosJava = dao.findById(4L);
		userPosJava.setNome("Margarida Almeida");
		dao.update(userPosJava);
		
		System.out.println(userPosJava);
	}

}

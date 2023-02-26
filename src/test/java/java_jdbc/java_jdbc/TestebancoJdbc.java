package java_jdbc.java_jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.UserPosJavaDao;
import model.BeanUserFone;
import model.Telefone;
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
	
	@Test
	public void initDelete() throws Exception {
		UserPosJavaDao dao = new UserPosJavaDao();
		UserPosJava userPosJava = dao.findById(4L);
		dao.delete(userPosJava);
		
		System.out.println(userPosJava);
	}
	
	@Test
	public void testeTelefone() {
		UserPosJavaDao dao = new UserPosJavaDao();
		Telefone telefone = new Telefone("(82) 9 9989-8787", "celular", 8L);
		System.out.println("telefone salvo com sucesso");
		try {
			dao.salvarTelefone(telefone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeCarregaFoneUser() {
		UserPosJavaDao dao = new UserPosJavaDao();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(8L);
		
		beanUserFones.forEach(System.out::print);
	}
}

package model;

public class UserPosJava {
	
	private Long id;
	private String nome;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserPosJava [\n id= " + id + "\n nome= " + nome + "\n email= " + email + "] \n"
				+ "----------------------------------------------------------------------- \n";
	}
}

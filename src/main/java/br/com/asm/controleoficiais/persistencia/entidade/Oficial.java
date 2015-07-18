package br.com.asm.controleoficiais.persistencia.entidade;

public class Oficial {
	@Override
	public String toString() {
		return "Oficial [of_matricula=" + of_matricula + ", of_nome=" + of_nome + "]";
	}
	private String of_matricula;
	private String of_nome;
	
	public String getOf_matricula() {
		return of_matricula;
	}
	public void setOf_matricula(String of_matricula) {
		this.of_matricula = of_matricula;
	}
	public String getOf_nome() {
		return of_nome;
	}
	public void setOf_nome(String of_nome) {
		this.of_nome = of_nome;
	}
	
}

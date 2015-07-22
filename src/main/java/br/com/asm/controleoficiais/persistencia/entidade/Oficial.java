package br.com.asm.controleoficiais.persistencia.entidade;

public class Oficial {
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Oficial [of_matricula=" + of_matricula + ", of_nome=" + of_nome + ", of_senha=" + of_senha + "]";
	}
	
	private String of_matricula;
	private String of_nome;
	private String of_senha;
	
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
	/** Retorna o valor do campo senha.
	 * @return O of_senha retorna o valor do campo of_Senha.
	 */
	public String getOf_senha() {
		return of_senha;
	}
	/** Define o valor no campo senha.
	 * @param of_senha O of_senha contém o valor a ser dado ao campo of_Senha. 
	 */
	public void setOf_senha(String of_senha) {
		this.of_senha = of_senha;
	}
	
}

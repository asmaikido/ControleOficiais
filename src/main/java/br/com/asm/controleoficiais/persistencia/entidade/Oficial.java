package br.com.asm.controleoficiais.persistencia.entidade;

public class Oficial {
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Oficial [ofMatricula=" + ofMatricula + ", ofNome=" + ofNome + ", ofSenha=" + ofSenha + "]";
	}
	
	private String ofMatricula;
	private String ofNome;
	private String ofSenha;
	
	public String getOfMatricula() {
		return ofMatricula;
	}
	public void setOfMatricula(String ofMatricula) {
		this.ofMatricula = ofMatricula;
	}
	public String getOfNome() {
		return ofNome;
	}
	public void setOfNome(String ofNome) {
		this.ofNome = ofNome;
	}
	/** Retorna o valor do campo senha.
	 * @return O of_senha retorna o valor do campo of_Senha.
	 */
	public String getOfSenha() {
		return ofSenha;
	}
	/** Define o valor no campo senha.
	 * @param ofSsenha O of_senha contém o valor a ser dado ao campo of_Senha. 
	 */
	public void setOfSenha(String ofSsenha) {
		this.ofSenha = ofSsenha;
	}
	
}

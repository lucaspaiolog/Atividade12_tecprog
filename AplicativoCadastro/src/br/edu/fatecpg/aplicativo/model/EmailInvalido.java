package br.edu.fatecpg.aplicativo.model;

public class EmailInvalido extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailInvalido(String mensagem) {
        super(mensagem);
    }
}    
    

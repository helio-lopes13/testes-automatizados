package prod;

import javax.swing.JPasswordField;

public class CampoSenha extends JPasswordField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CampoSenha() {
		super();
	}
	
	public CampoSenha(String senha) {
		super(senha);
	}
	
	public String getSenha() {
		return new String(this.getPassword());
	}

}

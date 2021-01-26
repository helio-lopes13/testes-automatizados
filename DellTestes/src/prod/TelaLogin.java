package prod;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaLogin {
	
	private JFrame janela = new JFrame("Tela de Login");;
	
	public TelaLogin() {
		User[] users = {
				new User("helio", "123456"),
                new User("aline", "aline123"),
                new User("ludmila", "ludmila456")
		};
		UserDB.setListaUsers(users);
		CampoLogin login = new CampoLogin();
		CampoSenha senha = new CampoSenha();
		JLabel label = new JLabel("Novo login");
		JLabel lLogin = new JLabel("Usuário: ");
		JLabel lSenha = new JLabel("Senha: ");
		final JButton botao = new JButton("Logar");
		lLogin.setBounds(20, 85, 80, 30);
		login.setBounds(100, 85, 100, 30);
		lSenha.setBounds(20, 135, 80, 30);
		senha.setBounds(100, 135, 100, 30);
		botao.setBounds(110, 185, 80, 30);
		label.setBounds(20, 235, 400, 60);
		janela.setSize(300, 400);
		
		janela.add(label);
		janela.add(login);
		janela.add(senha);
		janela.add(lLogin);
		janela.add(lSenha);
		janela.add(botao);
		
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (login.getText().isEmpty() || senha.getSenha().isEmpty()) {
					label.setText("Login inválido.");
				} else {
					if (UserDB.autenticar(login.getText(), senha.getSenha())) {
						label.setText("Login realizado com sucesso. Bem-vindo usuário " + login.getText() + ".");
					} else {
						label.setText("Login ou senha incorretos. Tente novamente.");
					}
				}
			}
		});
	}
	
	public JFrame getJanela() {
		return this.janela;
	}
	
	public static void main(String[] args) {
		new TelaLogin();
	}

}

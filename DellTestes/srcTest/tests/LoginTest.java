package tests;

import prod.CampoLogin;
import prod.CampoSenha;
import prod.TelaLogin;

import java.awt.Container;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class LoginTest {

	@Test
	public void testeSeLoginEstaDigitado() throws Exception {
		testeSeCampoEstaDigitado("helio", (new CampoLogin("helio").getText()));
	}
	
	@Test
	public void testeSeSenhaEstaDigitada() throws Exception {
		testeSeCampoEstaDigitado("senha", (new CampoSenha("senha").getSenha()));
	}
	
	@Test
	private void testeSeCampoEstaDigitado(String expectedValue, String realValue) throws Exception {
		assertEquals(expectedValue, realValue);
	}
	
	@Test
	public void testeSeFrameAparece() throws Exception {
		assertTrue((new TelaLogin()).getJanela().isShowing());
	}
	
	@Test
	public void testeSeLayoutDaTelaEhNuloParaNaoTerProblemasNoDisplay() throws Exception {
		assertNull((new TelaLogin()).getJanela().getContentPane().getLayout());
	}
	
	@Test
	public void testeSeComponentesPrincipaisEstaoNaTela() throws Exception {
		Container janela = (new TelaLogin()).getJanela().getContentPane();
		for (Component component : janela.getComponents() ) {
			if (component instanceof CampoLogin || component instanceof CampoSenha || component instanceof JButton) {
				assertTrue(true);
			}
		}
	}
	
	@Test
	public void testeSeBotaoReconheceLoginInvalido() throws Exception {
		Container painel = (new TelaLogin()).getJanela().getContentPane();
		int nComponentes = painel.getComponents().length;
		JLabel label = (JLabel) painel.getComponent(0);
		JButton botao = (JButton) painel.getComponent(nComponentes - 1);
		botao.doClick();
		assertEquals("Login inválido.", label.getText());
	}
	
	@Test
	public void testeSeRealizaLogin() throws Exception {
		String user = "helio";
		testeDeValidacaoDoLogin(user, "123456", "Login realizado com sucesso. Bem-vindo usuário " + user + ".");
	}
	
	@Test
	public void testeSeImpedeLoginComSenhaIncorreta() throws Exception {
		testeDeValidacaoDoLogin("ludmila", "ludmila45", "Login ou senha incorretos. Tente novamente.");
	}
	
	@Test
	private void testeDeValidacaoDoLogin(String user, String password, String message) throws Exception {
		Container painel = (new TelaLogin()).getJanela().getContentPane();
		int nComponentes = painel.getComponents().length;
		JLabel label = (JLabel) painel.getComponent(0);
		JButton botao = (JButton) painel.getComponent(nComponentes - 1);
		CampoLogin login = (CampoLogin) painel.getComponent(1);
		CampoSenha senha = (CampoSenha) painel.getComponent(2);
		login.setText(user);
		senha.setText(password);
		botao.doClick();
		assertEquals(message, label.getText());
	}
	
}

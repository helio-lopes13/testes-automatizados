package devmediatest;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(JUnitPlatform.class)
public class DevMediaTest {
	static WebDriver driver;
	
	@BeforeAll
	public static void prepararDriver() {
		driver = new ChromeDriver();
	}
	
	@AfterAll
	public static void finalizarDriver() {
		driver.quit();
	}
	
	@Test
	public void testeSeDriverEstaCriado() {
		assertNotNull(driver);
	}
	
	@Test
	public void testeSeDriverRetornaTítuloCorreto() {
		driver.get("https://www.youtube.com");
		String titulo = driver.getTitle();
		assertEquals("YouTube", titulo, "Não são iguais.");
	}
	
	@Test
	public void testeSeObtemApenasUmElementoNaBuscaDoBotaoDeLogin() {
		driver.get("https://www.devmedia.com.br");
		List<WebElement> elements = driver.findElements(By.className("link-login-devmedia"));
		assertEquals(1, elements.size(), "Não tem nenhum ou tem mais de um elemento.");
	}
	
	@Test
	public void testeSeLoginBoxApareceComClick() {
		driver.get("https://www.devmedia.com.br");
		WebElement botaoLogin = driver.findElement(By.className("link-login-devmedia"));
		botaoLogin.click();
		WebElement boxLogin = driver.findElement(By.className("box-login-devmedia"));
		String boxLoginClasses = boxLogin.getAttribute("class");
		assertEquals("box-login-devmedia show-form-login-devmedia", boxLoginClasses);
	}
	
	// Este teste deve ser o último a ser executado, pois a execução dele pode interferir em outros testes caso aconteça antes
	@Test
	@Order(Integer.MAX_VALUE)
	public void testeSeTituloEhIgualComLoginNoDevMedia() {
		driver.get("https://www.devmedia.com.br");
		driver.findElement(By.className("link-login-devmedia")).click();
		WebElement inputUsuario = driver.findElement(By.name("usuario"));
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputUsuario.sendKeys("dellTestes");
		inputSenha.sendKeys("delltestes");
		driver.findElement(By.className("submit-form-devmedia")).click();
		String titulo = driver.getTitle();
		assertEquals(titulo, "DevMedia | Plataforma para Programadores", "Deu algo errado.");
	}
}

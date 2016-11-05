/** Copyright PECOMP to Antonio Ricardo Alexandre Brasil and Hanna Tatila de Sousa
*   All rights reserved
**/

package br.ifes.pecomp.test.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/*
 * Eu entro no site
 * Eu quero me registrar
 * Eu coloco meu nome Antonio e minha idade 23
 * Eu sou direcionado para a pagina de login
 */

public class LoginStep {

	public static WebDriver driver;
	
	@Given("^Usuario entra no site$")
	public void usuarioEntraNoSite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ricardo\\Documents\\Pecomp-master\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/Pecomp/simulado_disciplina.jsf");
	}
	
	@When("^Usuario esta na pagina de login$")
	public void usuarioEstaNaPaginaDeLogin() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^clica no botao de Registrar$")
	public void clicaNoBotaoDeRegistrar() throws Throwable {
		driver.findElement(By.id("cadastrar")).click();
	}

	@Then("^Usuario redirecionado para pagina de cadastro$")
	public void usuarioRedirecionadoParaPaginaDeCadastro() throws Throwable {
		//driver.findElement(By.xpath(".//*[@id='']/a")).click();
	}

}

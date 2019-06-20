package steps;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;

import pages.TesteSFPages;
import support.BaseSteps;

public class TesteSF extends BaseSteps {
	
	private static  TesteSFPages sfInicial = new TesteSFPages(driver);
	
	
	
	@Dado("^que estou na tela inicial sf$")
	public void queEstouNaTelaInicialSf() throws Throwable {
	   sfInicial.openPage();
	}
	
	@Quando("^clico no link institucional$")
	public void clicoNoLinkInstitucional() throws Throwable {
	    sfInicial.clickInstitucional();
	    
	}

	@Quando("^apresentado tela institucional$")
	public void apresentadoTelaInstitucional() throws Throwable {
	  assertEquals("Sobre a Secretaria da Fazenda e Planejamento", sfInicial.validTelaIsntitucional());
	}
	
	@Quando("^no campo de pesquisa insiro \"([^\"]*)\"$")
	public void noCampoDePesquisaInsiro(String texto) throws Throwable {
	    sfInicial.inserirPesquisa(texto);
	}
}
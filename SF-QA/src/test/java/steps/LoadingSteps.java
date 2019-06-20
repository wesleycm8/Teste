package steps;

import org.apache.velocity.runtime.directive.Break;
import org.junit.Assert;

import cucumber.api.java.es.Dado;

import pages.Loading;

import support.BaseSteps;

public class LoadingSteps extends BaseSteps {
	
	boolean continua = true;
	
	private static Loading loading = new Loading(driver);

	@Dado("^que estou na tela de loading$")
	public void queEstouNaTelaDeLoading() throws Throwable {
	   
	}

	@Dado("^seleciono primeira bolinha do carrocel$")
	public void selecionoPrimeiraBolinhaDoCarrocel() throws Throwable {
	    loading.clickPrimeira();
	   
	}

	@Dado("^seleciono segunda bolinha do carrocel$")
	public void selecionoSegundaBolinhaDoCarrocel() throws Throwable {
		loading.clickSegundo();
	   
	}

	@Dado("^seleciono terceira bolinha do carrocel$")
	public void selecionoTerceiraBolinhaDoCarrocel() throws Throwable {
		loading.clickTerceiro();
	    
	}
	
	
	@Dado("^aguardo carrocel percorrer mensagens$")
	public void aguardoCarrocelPercorrerMensagens() throws Throwable {
		Thread.currentThread().sleep(8000);
	}
	
	
	@Dado("^apresenta tela de loading$")
	public void apresentaTelaDeLoading() throws Throwable {
		for (int x = 0; x < 100; x++) {
			if (loading.loader()) {
				Thread.currentThread().sleep(1000);
			} else {
				break;
			}
		}
		Thread.currentThread().sleep(1000);
	}
	
	@Dado("^apresenta tela inicio pld$")
	public void apresentaTelaInicioPld() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loading.openPagePLD();
		Thread.currentThread().sleep(4000);
		Assert.assertEquals("Juan,", loading.labelTelaInicioPLD());
		
	}

}

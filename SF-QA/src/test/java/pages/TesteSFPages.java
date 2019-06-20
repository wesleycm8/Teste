package pages;

import support.DriverQA;

public class TesteSFPages {

	private DriverQA driver;

	public TesteSFPages(DriverQA stepDriver) {
		driver = stepDriver;
	}

	public void openPage() {
		String url = "https://portal.fazenda.sp.gov.br/Paginas/default.aspx";
		driver.openURL(url);
	}

	public void clickInstitucional() {
		driver.click("//*[@id=\"header-menu-main\"]/li[2]/a/div", "xpath");
	}

	public String validTelaIsntitucional() {
		return driver.getText("ctl00_PlaceHolderMain_TitleDisplayMode");
	}

	public boolean botaoDesabilit() {
		return driver.isEnabled("//*[@id=\"btnContinuar\"]/button", "xpath");
	}
	
	public void inserirPesquisa(String texto) {
		driver.sendKeys(texto, "ctl00_g_c399d3fc_073f_419a_b297_425a69bd0a26_csr_sbox");
	}

}

package pages;

import support.DriverQA;

public class Loading {
	
	private DriverQA driver;
	

	public Loading(DriverQA stepDriver) {
		driver = stepDriver;
		
	}
	
	public void openPagePLD() {
	    String url = "https://webaprecuentas.latam.cloud.ihf/webview/abre-cuentas-web-uy/#/pld-comienzo";
	    driver.openURL(url);
	    
	}
	
	public boolean loader() {
		try {
			return driver.isDisplayed("msgId");
		} catch (Exception e) {
			return false;
		}

	}
	
	
	public void clickPrimeira() {
		driver.click("");
	}
	
	public void clickSegundo() {
		driver.click("");
	}
	
	public void clickTerceiro() {
		driver.click("");
	}
	
	public String labelLoading() {
	 return driver.getText("msgId");
	}
	
	public String labelTelaInicioPLD() {
		return driver.getText("//*[@id=\"titleId\"]/div[1]");
	}
	
	

}

package support;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class DriverQA {

    private static WebDriver driver;
    
    public boolean isEnabled(String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
        return element.isEnabled();
     }

    public boolean isSelected(String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
         return element.isSelected();
     }
    
    public boolean isDisplayed(String parValue, String... parType) {
    	WebElement element = findElem(parValue, parType);
    	return element.isDisplayed();
     }
    
    
    public void start(String parBrowser){
        String title = "";
        try{
            title = driver.getTitle();
        } catch (Exception e){
            title = "ERROR";
        }
        if (title == "ERROR") {
            switch (parBrowser) {
                case "firefox":

                    FirefoxDriverManager.getInstance().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addPreference(FirefoxDriver.MARIONETTE, true);
                    driver = new FirefoxDriver(options);
                    //driver.manage().window().maximize();
                    
                    break;
                case "chrome":
                    ChromeDriverManager.getInstance().setup();
                    ChromeOptions optionsC = new ChromeOptions();
                    
                    optionsC.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors","use-fake-ui-for-media-stream"));
                    //"incognito"
                    
                    //Abrir Chrome em modo device
                    /*Map<String, String> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "iPhone 5/SE");
                    optionsC.setExperimentalOption("mobileEmulation", mobileEmulation);*/
                    
                    driver = new ChromeDriver(optionsC);
                    
                    //Dimension d = new Dimension(320,568);
                    driver.manage().window().maximize();
            }
        }
    }

    private String getAttributeType (String... parType){
        String type;
        if (parType.length == 0) { type = "id"; }
        else { type = parType[0];}
        return type;
    }
    
    public void refresh() {
    	driver.navigate().refresh();
    }
    private WebElement findElem(String parValue, String... parType){
        String param2 = getAttributeType(parType);
        
        if(parValue.length() > 3 && parValue.substring(0, 3).equals("//*") && param2.equals("id")) {
            param2 = "xpath";
       }
        if(parValue.length() > 3 && parValue.substring(0, 3).equals("#") && param2.equals("css")) {
            param2 = "css";
       }

        WebElement element = null;
        try {
            switch (param2) {
                case "id":
                    element = driver.findElement(By.id(parValue));
                    break;
                case "name":
                    element = driver.findElement(By.name(parValue));
                    break;
                case "css":
                    element = driver.findElement(By.cssSelector(parValue));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(parValue));
                    break;
                case "link":
                    element = driver.findElement(By.linkText(parValue));
                    break;
                case "class":
                    element = driver.findElement(By.className(parValue));
                    
            }
        } catch (NoSuchElementException e) {
            element = null;
        }
        return element;
    }

    public void click(String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
        element.click();
    }
    
    
    public void submit(String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
        element.submit();
    }

    public void openURL(String parUrl) {
        driver.get(parUrl);
    }

    public void quit() {
        driver.quit();
    }

    public void close() {
        driver.close();
    }

    public void sendKeys(String parText, String parName, String... parType) {
        WebElement element = findElem(parName, parType);
        element.clear();
        element.sendKeys(parText);
    }
    
    
    public void fileInput(String parText, String parName, String... parType) {
        WebElement file_input = findElem(parName, parType);
        file_input.click();
        file_input.sendKeys(parText);
    }
    
    public String getText(String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
        return element.getText();
    }
    
    
    public String getElementList(String xpath) {
		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element.toString();
	}
    
    public void selectByIndex(Integer parIndex, String parName, String... parType) {
        WebElement element = findElem(parName, parType);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(parIndex);
    }

    public void selectByText(String parText, String parName, String... parType) {
        WebElement element = findElem(parName, parType);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(parText);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void waitElementAll(String parName, String... parType){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String param2 = getAttributeType(parType);
        try {
            switch (param2) {
                case "id":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parName)));
                    break;
                case "name":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(parName)));
                    break;
                case "css":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parName)));
                    break;
                case "xpath":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parName)));
                    break;
                case "link":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(parName)));
                    break;
                case "class":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(parName)));
                    break;
            }
        } catch (NoSuchElementException e) {
            System.out.println("ERROR WAIT => " + e.toString());
        }
    }

    public void waitElement(String parId) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parId)));
    }

    public void waitElementCSS(String parCss) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parCss)));
    }

    public void waitElementXP(String parXp) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parXp)));
    }

    public void switchTo(String... parValue) {
        if (parValue.length == 0) {
            driver.switchTo().defaultContent();
        } else {
            driver.switchTo().window(String.valueOf(parValue));
        }
    }

    public void ChooseOkOnNextConfirmation() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void ChooseCancelOnNextConfirmation() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    
    //Classe para inserir um arquivo para a web
    public void selectArchive(String caminho_arquivo) throws AWTException {
    	StringSelection ss = new StringSelection(caminho_arquivo);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    
	    Robot robot = new Robot();
	    robot.delay(1000);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.delay(1000);
    }
    
    //Tira Print da tela
   public void tirarPrint(String nomePrint){
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File("./evidencias/",nomePrint+"_"+dateFormat.format(date)+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			
		}

	}
    
}

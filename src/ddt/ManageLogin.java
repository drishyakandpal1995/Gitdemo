package ddt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ManageLogin {
	public static void main(String jk[]) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		System.setProperty ("webdriver.chrome.driver", "chromedriver.exe");
		driver.manage().window().maximize();
        
		//Automating Asset Library
		String url = Util.getData(0, 0);
		String userName = Util.getData(0, 1);
		String password = Util.getData(0, 2);
		Flows.login(url, userName, password, driver);
		Flows.search(driver);	
		driver.close();
	}

}

package ddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flows {

	public  static void login(String url,String Username, String Password, WebDriver driver) 
	{
		
        driver.get(url);
        driver.findElement(By.id("ctl00_PageContent_Login1_UserName")).sendKeys(Username);
        driver.findElement(By.id("ctl00_PageContent_Login1_Password")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_Login1_ImageButton1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"id_artworkbtn\"]")).click();	
	}

	public static void search(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='home-tab']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@class='item']//div[@class='well']//div[@class='productname']/div[2]")).click(); //click on menu
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='id_edit_link_0']")).click(); //click on Properties
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//div[@class='modal-dialog in'][1]//div[@class='modal-header']//h4")).getText().trim();
		String version = driver.findElement(By.xpath("//div[@class='modal-dialog in'][1]//div[@class='modal-body']//button[@class='dropdown-toggle']/a")).getText().trim();
		System.out.println(heading+"  ----  "+version);
		Util.setData(heading,0,3);
		Util.setData(version,0,4);
	}
	
	
}

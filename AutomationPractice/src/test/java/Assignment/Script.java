package Assignment;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Script {
public Script() {
	// TODO Auto-generated constructor stub
}
@Test 
public void automation() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("http://automationpractice.com/index.php");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"))).build().perform();
		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/ul/li[2]/a")).click();
		driver.manage().window().maximize();
		driver.findElement((By.xpath("//div[@class='product-image-container']/a"))).click();	
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("2");
		Select s=new Select(driver.findElement(By.xpath("//select[@name='group_1']")));
		s.selectByVisibleText("L");
		driver.findElement(By.xpath("//div[@class='box-cart-bottom']/div/p/button")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[starts-with(@title,'Continue shopping')]")).click();
		driver.findElement(By.xpath("(//a[@title='Women'])[2]")).click();
		
		List<WebElement> productlist = driver.findElements(By.xpath("//a[@class='product-name']"));
		System.out.println(productlist.size());
		for(int i=0;i<=productlist.size();i++){
			String name=productlist.get(i).getText();
			System.out.println(name);
			if(name.equalsIgnoreCase("Printed Chiffon Dress")) {
				driver.findElement(By.xpath("//img[@title='Printed Chiffon Dress']")).click();
						break;		
			}		
		}
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();	
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
        driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[5]//input[@type='text']")).clear();
        driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[5]//input[@type='text']")).sendKeys("1");
       // driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout'])[1]")).click();
        driver.findElement(By.id("email_create")).sendKeys("bandideepakaustralia17@gmail.com");
		driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("ch");
		driver.findElement(By.id("customer_lastname")).sendKeys("laks");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("address1")).sendKeys("zer");
		driver.findElement(By.id("city")).sendKeys("bangalore");
		Select s4=new Select(driver.findElement(By.id("id_state")));
		s4.selectByVisibleText("Florida");
		driver.findElement(By.id("postcode")).sendKeys("29145");
		Select s1=new Select(driver.findElement(By.id("id_country")));
		s1.selectByVisibleText("United States");
		driver.findElement(By.id("phone_mobile")).sendKeys("79925678097");
		driver.findElement(By.id("alias")).sendKeys("abc");

}	
}




















/*String price1=driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[4]//span[@class='price']")).getText();
	    String newprice1=price1.replace("$","");
	    long p1=Long.parseLong(newprice1);
		System.out.println(p1);
		String price2=driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[4]//span[@class='price']")).getText();
	int p2=Integer.parseInt(price2);	
	System.out.println(p2);
	
	String totalprice=driver.findElement(By.xpath("//table[@id='cart_summary']/tfoot/tr[1]")).getText();
	int tabletotal=Integer.parseInt(totalprice);
	int total=p1+p2;
	System.out.println(tabletotal);
	System.out.println(total);
	
}
		
}
		//reduce count in webtable
		public Map<String, Integer> getTableHeaders(List<WebElement> tableHeaders)
		{
			Map<String, Integer> map = new HashMap<String,Integer>();
			for(int i=0; i<tableHeaders.size(); i++)
			{
				String header = tableHeaders.get(i).getText();
				map.put(header, i+1);
			}
			return map;
			
		}
		public int getRowIndex(List<WebElement> tableData, String expectedText) throws Exception
		{
			int rowIndex = 0;
			boolean flag = false;
			for(int i=0; i<tableData.size(); i++)
			{
				String actualText = tableData.get(i).getText();
				if(actualText.equals(expectedText))
				{
					flag=true;
					rowIndex = i+1;
					break;
				}
			}
			if(flag)
				return rowIndex;
			else
				throw new Exception(expectedText+" is not present in the table");
			
		}
		@Test
		public void webTableHandling() throws Exception
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
			
			List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@id='task-table']//th"));
           // tableHeaders.forEach(s->System.out.println(s.getText()));
			Map<String, Integer> tableHeadersMap = getTableHeaders(tableHeaders);
         	System.out.println(tableHeadersMap);
			
			String tableColumnPath = "//table[@id='task-table']//tbody//td[colIndex]";
			String taskColumnXPath = tableColumnPath.replace("colIndex", Integer.toString(tableHeadersMap.get("Task")));
		System.out.println(tableColumnPath);
		System.out.println(taskColumnXPath);
			List<WebElement> taskColumnValues = driver.findElements(By.xpath(taskColumnXPath));
		//taskColumnValues.forEach(s->System.out.println(s.getText()));
			
			int rowIndex = getRowIndex(taskColumnValues, "Browser Issues");
	        System.out.println(rowIndex);
			
			String rowXPath = "//table[@id='task-table']//tbody/tr[rowIndex]/td[colIndex]";
			String finalValueXpath = rowXPath.replace("rowIndex", Integer.toString(rowIndex))
					                    .replace("colIndex", Integer.toString(tableHeadersMap.get("Status")));
     		System.out.println(finalValueXpath);
			String statusValue = driver.findElement(By.xpath(finalValueXpath)).getText();
			System.out.println(statusValue);
			Thread.sleep(5000);

		
		
		//driver.findElement(By.className("mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin")).click();
		//click on register 
		//click on checkout manually
		//terms and conditions
		driver.findElement(By.id("cgv")).click();
		//checkout manually
		driver.findElement(By.className("bankwire")).click();
		//click on I confirm my order[
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
		
		//taking screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File(".\\Screenshots.Screen.png"));
		
		
	driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).click();
		
		driver.findElement(By.xpath("//*[text()='Order history and details']")).click();
		driver.findElement(By.className("logout")).click();
		driver.findElement(By.xpath("(//*[@class='same'])[3]"));

        driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
		driver.close();
		}
  
	}*/



package assignmentWeek4Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA" )).click();
		driver.findElement(By.linkText("Leads" )).click();
		driver.findElement(By.linkText("Merge Leads")).click();
		driver.findElement(By.xpath("(//span[text()='From Lead']/following::img)[1]")).click();

		String windowHandle = driver.getWindowHandle();
		//System.out.println(windowHandle);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		String secondWindow = lstWindowHandles.get(1);

		// Switching to findlead window
		driver.switchTo().window(secondWindow);
		//System.out.println("Window Title:" + driver.getTitle());
		driver.findElement(By.name("firstName")).sendKeys("Babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		//switching to parnet window 
		String secondWindow1 = lstWindowHandles.get(0);
		driver.switchTo().window(secondWindow1);
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//span[text()='From Lead']/following::img)[2]")).click();

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> lstWindowHandles1 = new ArrayList<String>(windowHandles1);
		String secondWindow2 = lstWindowHandles1.get(1);
		// Switching to findlead window
		driver.switchTo().window(secondWindow2);
		//System.out.println("Window Title:" + driver.getTitle());
		driver.findElement(By.name("firstName")).sendKeys("Babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[7]")).click();

		driver.switchTo().window(secondWindow1);
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		String title = driver.getTitle();
		System.out.println("Page Title is:"+title);
		if (title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Lead Merged sucessfully");
		}
		else {
			System.out.println("Not Merged");
		}
		driver.quit();
	}
}

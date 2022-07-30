package assignmentWeek4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		String windowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		int size = lstWindowHandles.size();
		System.out.println("Total Number of windows :" +size);

		// All th windows title
		for(int i=0;i<size;i++) {
			String secondWindow = lstWindowHandles.get(i);
			driver.switchTo().window(secondWindow);
			System.out.println(driver.getTitle());

		}
		driver.quit();
	}

}

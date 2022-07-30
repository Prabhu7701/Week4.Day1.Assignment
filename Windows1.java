package assignmentWeek4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		String windowHandle = driver.getWindowHandle();
		//System.out.println(windowHandle);
		System.out.println(driver.getTitle());

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		int size = lstWindowHandles.size();
		String secondWindow = lstWindowHandles.get(1);
		driver.switchTo().window(secondWindow);
		System.out.println(driver.getTitle());
		System.out.println("Total Number of windows :" +size);
		driver.quit();
	}

}

package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.Excel;

public class Living extends BasePage{
	
public Living(WebDriver driver) {
		
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]")
	WebElement living;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li[1]/div/a")
	WebElement subMenu;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li[1]/ul/li/a/span")
	List<WebElement> subMenuList;
	
	
	public void selectLiving() {
		living.click();
	}
	
	public void printSubMenu() throws IOException {
		Excel excel = new Excel(System.getProperty("user.dir")+"//Excel//WBS.xlsx");
		System.out.println(subMenu.getText());
		System.out.println("---------------");
		excel.setCellData("Living", 0, 0,subMenu.getText());
	}
	
	public void getSubMenu() throws IOException {
		Excel excel = new Excel(System.getProperty("user.dir")+"//Excel//WBS.xlsx");
		int i=1;
		for(WebElement y: subMenuList) {
			String aa =y.getText();
			System.out.println(aa);
			excel.setCellData("Living", i, 0,aa);
			i++;
		}
	}
	

}

package PageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import com.aventstack.extentreports.util.Assert;
//import junit.framework.Assert;
import Utilities.Excel;
import junit.framework.Assert;

public class ConfirmDetails extends BasePage {
	
public ConfirmDetails(WebDriver driver) {
		
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[1]/div[2]/div[1]")
	WebElement recName;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[1]/div[2]/div[2]")
	WebElement recMail;
	
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[1]/div[2]/div[3]")
	WebElement recPhn;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[1]")
	WebElement sndName;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[2]")
	WebElement sndMail;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[3]")
	WebElement sndPhn;
	
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[4]")
	WebElement SndCity;
	
	
	@SuppressWarnings("deprecation")
	public void chkRname() throws IOException {
		Assert.assertEquals(Excel.ExcelRead("GC",2,2),recName.getText());
		
	}
	
	@SuppressWarnings("deprecation")
	public void chkRmail() throws IOException {
		Assert.assertEquals(Excel.ExcelRead("GC",4,2),recMail.getText());
		}
	
	@SuppressWarnings("deprecation")
	public void chkRphn() throws IOException {
		Assert.assertEquals(Excel.ExcelRead("GC",2,4),recPhn.getText());
	}
	
	@SuppressWarnings("deprecation")
	public void chkSname() throws IOException {
		Assert.assertEquals(Excel.ExcelRead("GC",2,5),sndName.getText());
	}
	
	@SuppressWarnings("deprecation")
	public void chkSmail() throws IOException {
		Assert.assertEquals(Excel.ExcelRead("GC",2,6),sndMail.getText());
	}
	
	@SuppressWarnings("deprecation")
	public void chkSphn() throws IOException {
		Assert.assertEquals(Excel.ExcelRead("GC",2,7),sndPhn.getText());
	}
	
	@SuppressWarnings("deprecation")
	public void chkScity() throws IOException {
		Assert.assertEquals(Excel.ExcelRead("GC",2,8),SndCity.getText());
	}
	
	
	

}

package selenium2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 public class selenium {
	   public WebDriver driver;
	   public String loginUrl="http://dev.xjshift.com:81/dev/login?id=40&key=blue";
	   public String baseUrl="http://dev.xjshift.com:81";
	   Alert alert;
//���̲���
	   public void action(){
		   Actions action = new Actions(driver);
	   }
	
//��ͼ����
	public  void takeScreen(String name) throws Exception{
	 	OutputStream out = null; 
		TakesScreenshot take = (TakesScreenshot)driver;
		File file = take.getScreenshotAs(OutputType.FILE);
		out = new FileOutputStream("G:/selenium/testPicture/"+name+".jpg");
		FileUtils.copyFile(file,out);
	 
	 }
	
	
	//�ȴ����ɵ�������
	public void waitClickableAndClick(By locator) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		FileWriter outdata = new FileWriter("G:/selenium/log/log.txt");
		PrintWriter outfile=new PrintWriter(outdata);
		
		for(int i=0;i<2;i++){		
			String s = driver.getWindowHandle();	
			try {
					wait.until(ExpectedConditions.elementToBeClickable(locator));
					break;
					}
				catch (TimeoutException t){
					driver.navigate().refresh();
				
				}
						//outfile.write("��λԪ��"+locator+"ʧ��"+driver.getCurrentUrl());// ���String
						//outfile.flush();// ��������������� 
						//outfile.close();
				catch(UnhandledAlertException U){
					
					alert=driver.switchTo().alert();
					alert.accept();
					driver.switchTo().window(s);
					driver.navigate().refresh();
					System.out.println("alert"+locator+driver.getCurrentUrl());
				}
		
		}
				try{
				Thread.sleep(800);
					}catch(Exception e){};
		for(int i=0;i<2;i--){
			String s = driver.getWindowHandle();
			try{
					driver.findElement(locator).click();
					break;
				}catch(UnhandledAlertException u){
					takeScreen("alert");
					alert=driver.switchTo().alert();
					alert.accept();
					driver.switchTo().window(s);
					driver.navigate().refresh();
					wait.until(ExpectedConditions.elementToBeClickable(locator));
					}
				}
		}
	
	//�ȴ��ɵ��
	public void waitClickable(By locator){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	//�ȴ�����
	public void waitLocated(By locator){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	//�ȴ�����
	public void waitTitles(String title){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	//js���
	public void jsClick(By locator) throws Exception{
		String s = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	   WebDriverWait wait = new WebDriverWait(driver,30);
	   try{
	   wait.until(ExpectedConditions.elementToBeClickable(locator));
	   }catch(TimeoutException t){
		   driver.navigate().refresh();
		   try{
			   wait.until(ExpectedConditions.elementToBeClickable(locator));
			   }catch(TimeoutException T){
				   System.out.println("Ԫ�ض�λʧ��"+locator+driver.getCurrentUrl());
			   }
	   }

	   try{
		   
		   js.executeScript("arguments[0].click();", new Object[]{driver.findElement(locator)});

   		  }catch(StaleElementReferenceException St){
	    	 // driver.get(driver.getCurrentUrl());  
	    	  Thread.sleep(500);
	      }catch (UnhandledAlertException u){
	    	  takeScreen("alert");
	    	  alert=driver.switchTo().alert();
				alert.accept();
				driver.switchTo().window(s);
				driver.navigate().refresh();
				
	   	}
	   }
	}
	
	
	
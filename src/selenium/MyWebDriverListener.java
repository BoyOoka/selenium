package selenium;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWebDriverListener implements WebDriverEventListener{
	WebDriver driver;
	@Override
    public void onException(Throwable throwable, WebDriver driver) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String dateString = format.format(new Date());

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{
            File screenShot = new File("/Users/gaya/Downloads/"+dateString+".png");
            FileUtils.copyFile(srcFile, screenShot);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("发生异变,原因是: "+throwable.getMessage());
        System.out.println("截图保存在: "+"/Users/gaya/Downloads/"+dateString+".png");

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("afterNavigateTo: "+url);
        System.out.println("afterNavigateTo by driver: "+driver.getCurrentUrl());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("单机页面元素的属性: "+element.getAttribute("value"));

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("查找元素的条件是: "+ by.toString());

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub

    }


    @Override
    public void afterScript(String url, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }


    @Override
    public void beforeNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("beforeNavigateTo: "+url);
        System.out.println("beforeNavigateTo by driver : "+driver.getCurrentUrl());
    }

    @Override
    public void beforeScript(String url, WebDriver driver) {
        // TODO Auto-generated method stub

    }

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void click(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
		System.out.println("查找条件是："+locator);
	}
}

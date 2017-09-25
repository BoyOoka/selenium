package selenium2;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginTaobaoCookie {

	public static void main(String[] args) {
//		String username = "13281549858";
//		String password = "13183937209Peng";
    	System.setProperty("webdriver.gecko.driver", "/Users/gaya/git/selenium/lib/selenium/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://pub.alimama.com/");

        Cookie ck0=new Cookie("cookie32","4c76430281b72c0081578dc0ade9c748");
        Cookie ck1=new Cookie("cookie31","MTI3NTc5MzMyLHRiMzkzNzIwOV8yMDExLHdhdGVya2lzc0AxMjYuY29tLFRC");
        Cookie ck2=new Cookie("alimamapw","TVoLWwcOVARcblQIVAAwUQcGDQ5ZVQMJBAFSCFRbAwFaUgVRCloJVQVfUgUBVAQ%3D");
        		Cookie ck3=new Cookie("rurl","aHR0cDovL3B1Yi5hbGltYW1hLmNvbS8%3D");
        		Cookie ck4=new Cookie("login","UtASsssmOIJ0bQ%3D%3D");
        		Cookie ck5=new Cookie("alimamapwag","TW96aWxsYS81LjAgKE1hY2ludG9zaDsgSW50ZWwgTWFjIE9TIFggMTAuMTI7IHJ2OjU0LjApIEdlY2tvLzIwMTAwMTAxIEZpcmVmb3gvNTQuMA%3D%3D");
        		Cookie ck6=new Cookie("cookie2","1ceff26c9b14b2a5bd1c3644c865970b");
        		Cookie ck7=new Cookie("apush03cc34eec28b8d19398b5211fd49339b","%7B%22ts%22%3A1506342235402%2C%22parentId%22%3A1506342232387%7D");
        		Cookie ck8=new Cookie("t","ed31bdc4ef52401bd2b0abdae83fbd3f");
        		Cookie ck9=new Cookie("v","0");
        		Cookie ck10=new Cookie("cna","JuNPEtjGy2ACAXDBjybrWYJS");
        		Cookie ck11=new Cookie("isg","AtPTBvnbjjLkFELmgApLyTIIY1E9IGbPn_Ghp4XwL_IpBPOmDVj3mjFeWE6V");
        		Cookie ck12=new Cookie("_tb_token_","e737fee877e86");
        driver.manage().addCookie(ck0);
        driver.manage().addCookie(ck1);
        driver.manage().addCookie(ck2);
        driver.manage().addCookie(ck3);
        driver.manage().addCookie(ck4);
        driver.manage().addCookie(ck5);
        driver.manage().addCookie(ck6);
        driver.manage().addCookie(ck7);
        driver.manage().addCookie(ck8);
        driver.manage().addCookie(ck9);
        driver.manage().addCookie(ck10);
        driver.manage().addCookie(ck11);
        driver.manage().addCookie(ck12);
//        driver.manage().addCookie(ck13);
//        driver.manage().addCookie(ck14);
//        driver.manage().addCookie(ck15);
//        driver.manage().addCookie(ck16);
//        driver.manage().addCookie(ck17);
//        driver.manage().addCookie(ck18);
//        driver.manage().addCookie(ck19);
//        driver.manage().addCookie(ck20);
//        driver.manage().addCookie(ck21);
//        driver.manage().addCookie(ck22);
//        driver.manage().addCookie(ck23);
//        driver.manage().addCookie(ck24);
//        driver.manage().addCookie(ck25);
//        driver.manage().addCookie(ck26);
//        driver.manage().addCookie(ck27);
//        driver.manage().addCookie(ck28);
//        driver.manage().addCookie(ck29);
//        driver.manage().addCookie(ck30);
//        driver.manage().addCookie(ck31);
//        driver.manage().addCookie(ck32);
//        driver.get("http://login.1688.com/member/signin.htm");
        driver.navigate().refresh();
        try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        Set<Cookie> cookies = driver.manage().getCookies();
        String s = "";
        int i = 0;
        for(Cookie cookie : cookies){
        	s += "Cookie ck"+i+"="+"new Cookie("+"\""+cookie.getName() + "\","+"\""+cookie.getValue()+"\")"+";"+"\n";
        	i++;
        }
        System.out.println(s);
	}

}

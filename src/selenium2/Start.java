package selenium2;

import com.thoughtworks.selenium.DefaultSelenium;

public class Start {

	public static void main(String[] args) {
		DefaultSelenium selenium = new DefaultSelenium("localhost",4444,"*firefox", "http://www.baidu.com");
		selenium.start();
	}

}

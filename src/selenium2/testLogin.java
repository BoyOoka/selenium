package selenium2;

public class testLogin {

	public static void main(String[] args) throws InterruptedException {
		loginTaobao l = new loginTaobao();
		String s = l.click("13281549858", "13183937209Peng");
		System.out.println(s);
	}

}

package selenium2;

public class testLogin {

	public static void main(String[] args) throws InterruptedException {
		loginTaobao l = new loginTaobao();
		String s = l.click("我们的的得到", "hl446991336");
		System.out.println(s);
	}

}

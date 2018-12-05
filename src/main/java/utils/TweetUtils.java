package utils;

import java.util.Random;

import org.junit.Test;

public class TweetUtils {
	
	private final static String titilePrefix = "t";
	private static int i = 0;
	private static final char[] c = new char[] {
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',',','.'
	};

	public static String generateTitle() {
		String title = titilePrefix + ++i;
		return title;
	}
	
	public static String generteText() {
		Random r = new Random();
		int length = r.nextInt(100);
		
		String text = "";
		for(int i = 0;i < length;i++) {
			int pos = r.nextInt(c.length);
			text += c[pos];
		}
		return text;
	}
	
	@Test
	public void test() {
		/*System.out.println("a"+'b');
		Random r = new Random();
		for(int i = 0;i < 500;i++) {
			int length = r.nextInt(52);
			System.out.print(length+" ");
			if(i % 50 == 0) System.out.println();
		}*/
		
		String s = generteText();
		System.out.println(s);
	}
}

package cats2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.HungryCat;

public class HungryCats2 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/hungryCats2.xml");
		
		HungryCat myCat = ctx.getBean("myHungryCat", HungryCat.class);
		System.out.println("My cats color is " + myCat.getColor());
		System.out.println("It eats guess whom?... " + myCat.getFood().getClass().getSimpleName());

		System.exit(0);
	}
}

package cats2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.HungryCat;

public class HungryCats1 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/hungryCats1.xml");
		
		HungryCat myCat = ctx.getBean("hungryCat", HungryCat.class);
		System.out.println("My cats color is " + myCat.getColor());
		System.out.println("It eats guess whom?... " + myCat.getFood().getClass().getSimpleName());

		System.exit(0);
	}
}

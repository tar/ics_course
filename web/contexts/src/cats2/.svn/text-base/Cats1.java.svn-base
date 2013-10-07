package cats2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Cat;

public class Cats1 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/cats1.xml");
		
		Cat myCat = ctx.getBean("myCat", Cat.class);
		System.out.println("My cats color is " + myCat.getColor());

		System.exit(0);
	}
}

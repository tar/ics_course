package cats2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Cat;

public class Cats2 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/cats2.xml");
		
		Cat myCat = ctx.getBean("myCat", Cat.class);
		System.out.println("My cats color is " + myCat.getColor());

		Cat neighborCat = ctx.getBean("neighborCat", Cat.class);
		System.out.println("Neighbor cats color is " + neighborCat.getColor());
		
		System.exit(0);
	}
}

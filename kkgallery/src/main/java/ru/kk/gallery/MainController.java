package ru.kk.gallery;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kk.gallery.dao.Dao;
import ru.kk.gallery.dao.User;


import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        /*String message = "";

        try {

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kk_gallery", "postgres", "pass");

            PreparedStatement statement = connection.prepareStatement("select * from styles");
            ResultSet result = statement.executeQuery();

            while(result.next())
            {
                message += result.getString("name") + "\r\n";
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        model.addAttribute("message", message);
		return "hello";*/

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:dao-context.xml");
        ctx.refresh();

        Dao stylesDao = ctx.getBean("dao", Dao.class);

        List<User> users = stylesDao.getUsers();

        String message = "";
        for(User user : users)
        {
            message += user.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";
	}
}
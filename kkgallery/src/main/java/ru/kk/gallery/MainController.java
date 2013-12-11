package ru.kk.gallery;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kk.gallery.dao.City;
import ru.kk.gallery.dao.Dao;
import ru.kk.gallery.dao.Painting;
import ru.kk.gallery.dao.User;


import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    static{
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:dao-context.xml");
        ctx.refresh();

        dao = ctx.getBean("dao", Dao.class);
    }

    private static Dao dao;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        return printPaintings(model);

	}

    private String printUser(ModelMap model){

        model.addAttribute("message", dao.getUser("togorot").getName());
        return "hello";

    }

    private String printPainting(ModelMap model){

        model.addAttribute("message", dao.getPainting(1).getName());
        return "hello";

    }

    private String printPaintings(ModelMap model, String user_login){

        List<Painting> paintings = dao.getPaintings(user_login);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintings(ModelMap model){

        List<Painting> paintings = dao.getPaintings();
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getUser().getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

}
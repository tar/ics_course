package ru.kk.gallery;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kk.gallery.dao.*;


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

        return printPaintingsForTag(model, 2);

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

    private String printPaintingsForGenre(ModelMap model, int id_genre){

        List<Painting> paintings = dao.getPaintingsForGenre(id_genre);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintingsForStyle(ModelMap model, int id_style){

        List<Painting> paintings = dao.getPaintingsForStyle(id_style);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintingsForTag(ModelMap model, int id_tag){

        List<Painting> paintings = dao.getPaintingsForTag(id_tag);
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

    private String printImages(ModelMap model, int id_painting){

        List<Image> images = dao.getImages(id_painting);
        String message = "";

        for(Image im : images)
        {
            message += im.getPath() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

}
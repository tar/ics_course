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

        dataGetter = ctx.getBean("dao", DataGetter.class);
    }

    private static DataGetter dataGetter;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        return printGenres(model);

    }

    private String printTags(ModelMap model){

        List<Tag> tags = dataGetter.getTags();
        String message = "";

        for(Tag t : tags)
        {
            message += t.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printGenres(ModelMap model){

        List<Genre> genres = dataGetter.getGenres();
        String message = "";

        for(Genre g : genres)
        {
            message += g.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printStyles(ModelMap model){

        List<Style> styles = dataGetter.getStyles();
        String message = "";

        for(Style s : styles)
        {
            message += s.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printUser(ModelMap model){

        model.addAttribute("message", dataGetter.getUser("togorot").getName());
        return "hello";

    }

    private String printPainting(ModelMap model){

        model.addAttribute("message", dataGetter.getPainting(1).getName());
        return "hello";

    }

    private String printPaintings(ModelMap model, User user){

        List<Painting> paintings = dataGetter.getPaintings(user);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintingsForGenre(ModelMap model, Genre genre){

        List<Painting> paintings = dataGetter.getPaintings(genre);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintingsForStyle(ModelMap model, Style style){

        List<Painting> paintings = dataGetter.getPaintings(style);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintingsForTag(ModelMap model, Tag tag){

        List<Painting> paintings = dataGetter.getPaintings(tag);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintings(ModelMap model){

        List<Painting> paintings = dataGetter.getPaintings();
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getUser().getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printImages(ModelMap model, Painting painting){

        List<Image> images = dataGetter.getImages(painting);
        String message = "";

        for(Image im : images)
        {
            message += im.getPath() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

}
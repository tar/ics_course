package ru.kk.gallery;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kk.gallery.dao.*;
import ru.kk.gallery.dao.entity.*;


import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    static{
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:dao-context.xml");
        ctx.refresh();

        galleryDao = ctx.getBean("dao", GalleryDao.class);
    }

    private static GalleryDao galleryDao;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        Genre genre = new Genre();
        genre.setId_genre(11);
        Style style = new Style();
        style.setId_style(2);
        Tag tag = new Tag();
        tag.setId_tag(2);
        return printPaintingsForTag(model,tag);

    }

    private String printCity(ModelMap model, int id_city){

        List<City> city = galleryDao.getCity(id_city);
        String message = "";

        for(City c : city)
        {
            message += c.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printCities(ModelMap model){

        List<City> city = galleryDao.getCities();
        String message = "";

        for(City c : city)
        {
            message += c.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printTags(ModelMap model){

        List<Tag> tags = galleryDao.getTags();
        String message = "";

        for(Tag t : tags)
        {
            message += t.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printGenres(ModelMap model){

        List<Genre> genres = galleryDao.getGenres();
        String message = "";

        for(Genre g : genres)
        {
            message += g.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printStyles(ModelMap model){

        List<Style> styles = galleryDao.getStyles();
        String message = "";

        for(Style s : styles)
        {
            message += s.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printUser(ModelMap model, String login){
        //togorot for example
        List<User> users = galleryDao.getUser(login);
        String message = "";

        for(User user : users)
        {
            message += user.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printUsers(ModelMap model){

        List<User> users = galleryDao.getUsers();
        String message = "";

        for(User user : users)
        {
            message += user.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPainting(ModelMap model){

        model.addAttribute("message", galleryDao.getPainting(1).getName());
        return "hello";

    }

    private String printPaintings(ModelMap model, User user){

        List<Painting> paintings = galleryDao.getPaintings(user);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintingsForGenre(ModelMap model, Genre genre){

        List<Painting> paintings = galleryDao.getPaintings(genre);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintingsForStyle(ModelMap model, Style style){

        List<Painting> paintings = galleryDao.getPaintings(style);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintingsForTag(ModelMap model, Tag tag){

        List<Painting> paintings = galleryDao.getPaintings(tag);
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printPaintings(ModelMap model){

        List<Painting> paintings = galleryDao.getPaintings();
        String message = "";

        for(Painting p : paintings)
        {
            message += p.getName() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

    private String printImages(ModelMap model, Painting painting){

        List<Image> images = galleryDao.getImages(painting);
        String message = "";

        for(Image im : images)
        {
            message += im.getPath() + " ";
        }

        model.addAttribute("message", message);
        return "hello";

    }

}
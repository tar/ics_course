package ru.spbstu.it.controllers;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;








import java.util.Map;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.spbstu.it.domain.ITWork;
import ru.spbstu.it.domain.Task;
import ru.spbstu.it.service.*;


@Controller
public class ITController {	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ITWorkService itworkService;
	
	@Autowired
	private userService uService;
	
	@Autowired
	private taskService taskService;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/index")
	public String index(Locale locale, Model model) {	
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		Collection<GrantedAuthority> grantedAuthority = user.getAuthorities();
		String granted=grantedAuthority.toString();		
		model.addAttribute("username", name);
		model.addAttribute("granted",granted);		
		return "index";
	}
	
	@RequestMapping(value="/it")
	public String it(Locale locale, Model model, Map<String, Object> map){		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		Collection<GrantedAuthority> grantedAuthority = user.getAuthorities();
		String granted=grantedAuthority.toString();		
		model.addAttribute("username", name);
		model.addAttribute("granted",granted);		
		ru.spbstu.it.domain.User u= new ru.spbstu.it.domain.User();
		try {
			u=uService.getUser(name);
			model.addAttribute("skill",u.getSkill());
			model.addAttribute("user_id",u.getId().intValue());
		} catch(Exception e) {
			model.addAttribute("skill",e);
			model.addAttribute("user_id",null);
		}
		finally {}
		
		map.put("users", uService.getAllUsers());
		
		ITWork itwork=new ITWork();
		model.addAttribute("newITWork",itwork);	
		String string="";
		model.addAttribute("string",string);
		map.put("itworklist", itworkService.listITWork());
		return "it";	
	}
	
	@RequestMapping(value="/tasks")
	public String tasks(Locale locale, Model model, Map<String, Object> map){		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		Collection<GrantedAuthority> grantedAuthority = user.getAuthorities();
		String granted=grantedAuthority.toString();
		
		model.addAttribute("username", name);
		model.addAttribute("granted",granted);
		
		
		ru.spbstu.it.domain.User u= new ru.spbstu.it.domain.User();
		try {
			u=uService.getUser(name);
			model.addAttribute("skill",u.getSkill());
			model.addAttribute("user_id",u.getId().intValue());
		} catch(Exception e) {
			model.addAttribute("skill",e);
			model.addAttribute("user_id",null);
		}
		finally {
		
		}
		Task task=new Task();
		model.addAttribute("newTask",task);
		map.put("users", uService.getAllUsers());		
		String description="";
		model.addAttribute("description",description);
		String title="";
		model.addAttribute("title",title);
		
		
		map.put("tasklist", taskService.listTask());
		map.put("userlist", uService.getAllUsers());
		return "tasks";	
	}
		
	@RequestMapping(value="/login")
	public String login(){		
		return "redirect:/index";	
	}
	
	@RequestMapping(value = "/addITWork", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("newITWork") ITWork itwork, BindingResult result, Model model) {
		
		itwork.setCompleted(false);
		
		ru.spbstu.it.domain.User u= new ru.spbstu.it.domain.User();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		u=uService.getUser(name);
		
		itwork.setCreatorID(u.getId().intValue());
		
		itworkService.addITWork(itwork);
		
		return "redirect:/it";
	}
	
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public String addTask(@ModelAttribute("newTask") Task task, BindingResult result, Model model){
		task.setCompleted(false);
		ru.spbstu.it.domain.User u= new ru.spbstu.it.domain.User();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		u=uService.getUser(name);
		task.setOwnerID(u.getId().intValue());
		taskService.addTask(task);
		
		return "redirect:/tasks";
	}
	
	
	@RequestMapping("/complete/{ITWorkID}")
	public String completeITWork(@PathVariable("ITWorkID") Integer itWorkID) {

		itworkService.completeITWork(itWorkID);

		return "redirect:/it";
	}

	@RequestMapping("/completeTask/{TaskID}")
	public String completeTask(@PathVariable("TaskID") Integer taskID){
		taskService.completeTask(taskID);
		return "redirect:/tasks";
	
	}
}

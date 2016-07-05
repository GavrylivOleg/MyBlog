package ua.blog.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.blog.entity.Article;
import ua.blog.entity.Message;
import ua.blog.serviceimpl.ArticleServiceImpl;
import ua.blog.serviceimpl.MessageServiceImpl;
import ua.blog.serviceimpl.UserServiceImpl;

@Controller
public class ReadArticleController {

	@Autowired
	private ArticleServiceImpl articleServiceImpl;

	@Qualifier("userDetailService")
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private MessageServiceImpl messageServiceImpl;

	@RequestMapping(value = "/article/{idx}", method = RequestMethod.GET)
	public String showArticle(Model model, @PathVariable String idx) {
		Article article = articleServiceImpl.findById(Integer.parseInt(idx));
	//	String myMessage=	article.getArticleMessage().get(1).getMessageText();
		// model.addAttribute("message", myMessage);

			
			 model.addAttribute("message",  article.getArticleMessage());
		model.addAttribute("article", article);

		model.addAttribute("user", article.getUser());

		return "article";
	}
	
	
	
	
	@RequestMapping(value="/article/{idx}" , method = RequestMethod.POST)
	public String addMessage(ModelMap model,@ModelAttribute Message message,@PathVariable String idx){
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		message.setDate(dateFormat.format(new Date()));
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();

		ua.blog.entity.User myUser = (ua.blog.entity.User) userServiceImpl.findOneByName(name);
		message.setUser(myUser);
		
		
		 message.setArticle(articleServiceImpl.findById(Integer.parseInt(idx)));
		messageServiceImpl.saveMessage(message);
		return "redirect:/article/{idx}";
		
	}
}

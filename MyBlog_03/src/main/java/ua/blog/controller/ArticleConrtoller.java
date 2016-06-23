package ua.blog.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.blog.entity.Article;
import ua.blog.error.ArticleValidator;
import ua.blog.serviceimpl.ArticleServiceImpl;
import ua.blog.serviceimpl.GroupAtriclesServiceImpl;
import ua.blog.serviceimpl.UserServiceImpl;

@Controller
public class ArticleConrtoller {

	@Autowired
	private ArticleServiceImpl articleServiceImpl;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private GroupAtriclesServiceImpl groupAtriclesServiceImpl;

	@Autowired
	private ArticleValidator articleValidator;

	@RequestMapping(value = "/addArticle", method = RequestMethod.GET)
	public String saveArticle(Model model) {
		model.addAttribute("articles", articleServiceImpl.getAllArticles());

		model.addAttribute("groups", groupAtriclesServiceImpl.getAllGroupArticles());

		model.addAttribute("article", new Article());
		return "addArticle";
	}

	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String saveArticle(ModelMap model,  @RequestParam String groupName , @ModelAttribute Article article , BindingResult result) {
		article.setGroupArticles(groupAtriclesServiceImpl.findOneGroupArticlesByName(groupName));

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();

		ua.blog.entity.User myUser = (ua.blog.entity.User) userServiceImpl.findOneByName(name);
		System.out.println(myUser.toString());
		article.setUser(myUser);

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		article.setDate(dateFormat.format(new Date()));
		
		articleValidator.validate(article, result);
		if (result.hasErrors()) {
			return "addArticle";
		}
	
		
		articleServiceImpl.saveArticle(article);
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteArticle", method = RequestMethod.POST)
	public String deleteArticle(@RequestParam String titleArticle) {
		articleServiceImpl.deleteArticleByName(titleArticle);
		return "redirect:/addArticle";
	}
}

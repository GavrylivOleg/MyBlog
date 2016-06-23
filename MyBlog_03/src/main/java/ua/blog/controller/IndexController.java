package ua.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.blog.serviceimpl.ArticleServiceImpl;
import ua.blog.serviceimpl.GroupAtriclesServiceImpl;

@Controller
public class IndexController {

	@Qualifier("articleService")
	@Autowired
	private ArticleServiceImpl articleServiceImpl;
	@Qualifier("groupArticlesService")
	@Autowired
	private GroupAtriclesServiceImpl groupAtriclesServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showArticle(Model model) {

		model.addAttribute("group", groupAtriclesServiceImpl.getAllGroupArticles());

		model.addAttribute("articles", articleServiceImpl.getAllArticles());
		return "index";
	}

}

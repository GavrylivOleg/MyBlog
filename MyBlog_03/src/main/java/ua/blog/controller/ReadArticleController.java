package ua.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.blog.entity.Article;
import ua.blog.serviceimpl.ArticleServiceImpl;
import ua.blog.serviceimpl.UserServiceImpl;

@Controller
public class ReadArticleController {

	@Autowired
	private ArticleServiceImpl articleServiceImpl;

	@Qualifier("userDetailService")
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/article/{idx}", method = RequestMethod.GET)
	public String showArticle(Model model, @PathVariable String idx) {
		Article article = articleServiceImpl.findById(Integer.parseInt(idx));
		model.addAttribute("article", article);

		model.addAttribute("user", article.getUser());

		return "article";
	}
}

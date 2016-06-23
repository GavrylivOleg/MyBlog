package ua.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.blog.entity.GroupArticles;
import ua.blog.error.AddGroupValidator;
import ua.blog.serviceimpl.ArticleServiceImpl;
import ua.blog.serviceimpl.GroupAtriclesServiceImpl;

@Controller
public class GroupArticlesController {

	@Qualifier("articleService")
	@Autowired
	private ArticleServiceImpl articleServiceImpl;

	@Qualifier("groupArticlesService")
	@Autowired
	private GroupAtriclesServiceImpl groupAtriclesServiceImpl;

	@Autowired
	private AddGroupValidator addGroupValidator;

	@RequestMapping(value = "/addGroupArticles", method = RequestMethod.GET)
	public String saveGroupArticles(Model model) {
		model.addAttribute("groups", groupAtriclesServiceImpl.getAllGroupArticles());
		model.addAttribute("groupArticles", new GroupArticles());
		return "addGroupArticles";
	}

	@RequestMapping(value = "/addGroupArticles", method = RequestMethod.POST)
	public String saveGroupArticles(@ModelAttribute GroupArticles groupArticles, BindingResult result) {

		addGroupValidator.validate(groupArticles, result);
		if (result.hasErrors()) {
			return "addGroupArticles";
		}

		groupAtriclesServiceImpl.saveGroupArticles(groupArticles);
		return "redirect:/addGroupArticles";
	}

	@RequestMapping(value = "/deleteGroupArticles", method = RequestMethod.POST)
	public String deleteGroupArticles(@RequestParam String nameGroup) {
		groupAtriclesServiceImpl.deleteGroupArticlesByName(nameGroup);
		return "redirect:/addGroupArticles";
	}

}

package ua.blog.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HttpErrorController {
	private static final String GENERAL_ERROR_VIEW = "/error/general";

	@RequestMapping(value = "/errors/400.jsp")
	public ModelAndView handle400(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "400");
		modelAndView.addObject("message", "Error 400 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/404.jsp")
	public ModelAndView handle4041(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "404");
		modelAndView.addObject("message", "Error 404 happens");

		return modelAndView;

	}

	@RequestMapping(value = "/errors/405.jsp")
	public ModelAndView handle405(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "405");
		modelAndView.addObject("message", "Error 405 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/406.jsp")
	public ModelAndView handle406(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "406");
		modelAndView.addObject("message", "Error 406 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/408.jsp")
	public ModelAndView handle408(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "408");
		modelAndView.addObject("message", "Error 408 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/415.jsp")
	public ModelAndView handle415(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "415");
		modelAndView.addObject("message", "Error 415 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/500.jsp")
	public ModelAndView handle500(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "500");
		modelAndView.addObject("message", "Error 500 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/503.jsp")
	public ModelAndView handle503(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "503");
		modelAndView.addObject("message", "Error 503 happens");

		return modelAndView;
	}

}

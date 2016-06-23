package ua.blog.error;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.blog.entity.Article;



@Component
public class ArticleValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return Article.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Article articleForm = (Article) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty", "title must not be empty.");
		String title = articleForm.getTitle();
		if ((title.length()) > 16) {
			errors.rejectValue("title", "title.tooLong", "title must not more than 16 characters.");
		}


		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "text.empty", "text must not be empty.");
		String text = articleForm.getText();
		if ((text.length()) <5) {
			errors.rejectValue("text", "text.tooLong", "text must not less than 5 characters.");
		}

	}
}
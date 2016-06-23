package ua.blog.error;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.blog.entity.GroupArticles;

@Component
public class AddGroupValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return GroupArticles.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		GroupArticles groupForm = (GroupArticles) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupName", "groupName.empty",
				"groupName must not be empty.");
		String groupName = groupForm.getGroupName();
		if ((groupName.length()) > 16) {
			errors.rejectValue("groupName", "groupName.tooLong", "groupName must not more than 16 characters.");
		}

	}
}

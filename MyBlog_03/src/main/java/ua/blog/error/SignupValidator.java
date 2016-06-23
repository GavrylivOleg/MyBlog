package ua.blog.error;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.blog.entity.User;

@Component
public class SignupValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User signupForm = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "Username must not be empty.");
		String userName = signupForm.getUserName();
		if ((userName.length()) > 16) {
			errors.rejectValue("userName", "username.tooLong", "Username must not more than 16 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "nickName.empty", "nickName must not be empty.");
		String nickName = signupForm.getNickName();
		if ((nickName.length()) > 16) {
			errors.rejectValue("nickName", "nickName.tooLong", "nickName must not more than 16 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
		if (!(signupForm.getPassword()).equals(signupForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
		}

		if (!EmailValidator.getInstance().isValid(signupForm.getEmail())) {
			errors.rejectValue("email", "email.notValid", "Email address is not valid.");
		}
	}
}
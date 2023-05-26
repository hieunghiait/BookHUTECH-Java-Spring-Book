package lehieunghia.springboot.buoi2.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lehieunghia.springboot.buoi2.model.User;
import lehieunghia.springboot.buoi2.repository.UserRepository;
import lehieunghia.springboot.buoi2.validator.annotaion.ValidUsername;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void initialize(ValidUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }

}

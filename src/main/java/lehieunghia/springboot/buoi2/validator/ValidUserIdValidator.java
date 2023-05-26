package lehieunghia.springboot.buoi2.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lehieunghia.springboot.buoi2.model.User;
import lehieunghia.springboot.buoi2.validator.annotaion.ValidCategoryId;

public class ValidUserIdValidator implements ConstraintValidator<ValidCategoryId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        if (user == null)
            return true;
        return user.getId() != null;
    }
}

package lehieunghia.springboot.buoi2.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lehieunghia.springboot.buoi2.model.Category;
import lehieunghia.springboot.buoi2.validator.annotaion.ValidCategoryId;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public void initialize(ValidCategoryId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext) {
        return category != null && category.getId() != null;
    }
}

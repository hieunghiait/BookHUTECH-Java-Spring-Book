package lehieunghia.springboot.buoi2.validator.annotaion;

import jakarta.persistence.CascadeType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import lehieunghia.springboot.buoi2.validator.ValidCategoryIdValidator;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCategoryIdValidator.class)
@Documented
public @interface ValidCategoryId {
    String message() default "Invalid Category ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

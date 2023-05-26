package lehieunghia.springboot.buoi2.validator.annotaion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import lehieunghia.springboot.buoi2.validator.ValidCategoryIdValidator;
import lehieunghia.springboot.buoi2.validator.ValidUserIdValidator;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUserIdValidator.class)
@Documented
public @interface ValidUserId {
    String message() default "Invalid User ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


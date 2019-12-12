package lab4.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = MinPriceValidator.class)
public @interface MinPrice {
    double value();

    String message() default "{MinPrice}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
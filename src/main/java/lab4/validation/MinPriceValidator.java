package lab4.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinPriceValidator implements ConstraintValidator<MinPrice, Double> {

    private double annotationMinPrice;

    @Override
    public void initialize(MinPrice minPrice) {
        this.annotationMinPrice = minPrice.value();
    }

    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        if(aDouble>= annotationMinPrice)
            return true;
        else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("must be more than " + annotationMinPrice)
                    .addConstraintViolation();
            return false;
        }
    }
}
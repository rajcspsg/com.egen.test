package com.egen.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { GenderPattern.Validator.class })
@Documented
public @interface GenderPattern {
	String regexp();
    String message() default "The value of the gender should be either male or female";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<GenderPattern, Character> {
        String regexp;

        @Override
        public void initialize(GenderPattern c) {
            this.regexp = c.regexp();
        }

        @Override
        public boolean isValid(Character gender, ConstraintValidatorContext ctx) {
        	char charVal = gender.charValue() ;
            if(charVal == 'M' || charVal == 'F') 
            	return true ;
            else 
            	return false;
        }
    }
}

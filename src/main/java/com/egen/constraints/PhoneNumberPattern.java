package com.egen.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { PhoneNumberPattern.Validator.class })
@Documented
public @interface PhoneNumberPattern {
	String regexp();
    String message() default "The phone number should be positive 10 digit numbers";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<PhoneNumberPattern, Long> {
        String regexp;

        @Override
        public void initialize(PhoneNumberPattern c) {
            this.regexp = c.regexp();
        }

        @Override
        public boolean isValid(Long phoneNumber, ConstraintValidatorContext ctx) {
            
        	String strPhoneNumber = Long.toString(phoneNumber);
        	int len = strPhoneNumber.length();
        	if(len != 10) return false;
        	if(strPhoneNumber.matches(regexp)) return true;
        	else return false;
        }
    }
}

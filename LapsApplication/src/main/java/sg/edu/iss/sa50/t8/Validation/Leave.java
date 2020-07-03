package sg.edu.iss.sa50.t8.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=LeavesValidation.class)
public @interface Leave {
	String message() default "Annual Leaves are more than entitled";
	Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};
}

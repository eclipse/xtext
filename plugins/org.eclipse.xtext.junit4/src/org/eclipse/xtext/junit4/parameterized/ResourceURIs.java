package org.eclipse.xtext.junit4.parameterized;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface ResourceURIs {
	String baseDir() default "";

	String[] fileExtensions() default {};

	String[] files() default {};
}

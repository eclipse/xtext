package org.xpect.state;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Creates {
	Class<? extends Annotation> annotatedWith() default Default.class;
}

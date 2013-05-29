package org.eclipse.xtext.junit4.parameterized;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use org.xpect.runner.XpectTestFiles from www.xpect-tests.org instead.
 * 
 * This class will be removed in the next release after 2.4.2
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface ResourceURIs {
	String baseDir() default "";

	String[] fileExtensions() default {};

	String[] files() default {};
}

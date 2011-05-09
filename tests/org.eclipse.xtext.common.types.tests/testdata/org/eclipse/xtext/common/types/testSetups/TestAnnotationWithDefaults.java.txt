/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotationWithDefaults  {

	int intValue() default 17 * 2;
	byte byteValue() default 1;
	float floatValue() default 5f;
	double doubleValue() default 23d;
	boolean booleanValue() default true;
	short shortValue() default 12;
	long[] longArrayValue() default {50, 60};
	char[] charArrayValue() default 'a';
	TestEnum enumValue() default TestEnum.FirstValue;
	NestedAnnotation annotationValue() default @NestedAnnotation("AnotherString");
	NestedAnnotation[] annotationArrayValue() default { 
		@NestedAnnotation("AnotherString"), 
		@NestedAnnotation 
	};
	String stringValue() default "";
	String[] stringArrayValue() default { "arrayValue" };
	Class<? extends CharSequence> charSequenceClass() default String.class;
	Class<?>[] classArray() default {};
	
	@Retention(RetentionPolicy.RUNTIME)
	@interface NestedAnnotation {
		String value() default "MyString";
	}
	
}
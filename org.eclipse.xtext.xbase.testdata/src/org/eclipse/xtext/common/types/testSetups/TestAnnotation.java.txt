/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation  {

	int intValue() default 17 * 2;
	byte byteValue() default 1;
	float floatValue();
	double doubleValue();
	boolean booleanValue() default true;
	short shortValue();
	short shortValue2() default NestedAnnotation.SHORT_2;
	long[] longValue();
	char[] charValue();
	TestEnum enumValue();
	NestedAnnotation annotationValue();
	String stringValue();
	String[] stringArrayValue();
	Class<? extends CharSequence> charSequenceClass();
	Class<?>[] classArray();
	
	static final Object STATIC_FIELD = new Object();
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
	@interface NestedAnnotation {
		String value() default "MyString";
		
		public static final short SHORT_2 = 42;
	}
	
	@TestAnnotation(
			annotationValue = @NestedAnnotation, 
			booleanValue = false, 
			byteValue = 1 + 1, 
			charSequenceClass = String.class, 
			charValue = 'a', 
			classArray = { Annotated.class, Annotated.class }, 
			doubleValue = 0.5, 
			enumValue = TestEnum.FirstValue, 
			floatValue = 0.8f, 
			longValue = { 6 , 5 + 2}, 
			shortValue = 4, 
			shortValue2 = Annotated.CONSTANT, 
			stringArrayValue = { "array", "value", "duplicate", "duplicate" }, 
			stringValue = "stringValue")
	public static class Annotated {
		
		public static final short CONSTANT = 4 + NestedAnnotation.SHORT_2;
		
		@NestedAnnotation()
		public Annotated field;
		
		@NestedAnnotation("constructor")
		public Annotated() {
		}
		
		@NestedAnnotation("secondConstructor")
		public Annotated(String string) {
		}
		
		@NestedAnnotation("thirdConstructorWithBody")
		public Annotated(String s1, String s2) {
			this(s1 + s2);
			method(new CharSequence() {
				@Override
				public CharSequence subSequence(int start, int end) {
					return null;
				}
				@Override
				@NestedAnnotation("method")
				public int length() {
					return 0;
				}
				
				@Override
				public char charAt(int index) {
					return 0;
				}
			});
		}
		
		public Annotated(@TestAnnotation(
				annotationValue = @NestedAnnotation, 
				booleanValue = false, 
				byteValue = 1 + 1, 
				charSequenceClass = String.class, 
				charValue = 'a', 
				classArray = { Annotated.class, Annotated.class }, 
				doubleValue = 0.5, 
				enumValue = TestEnum.FirstValue, 
				floatValue = 0.8f, 
				longValue = { 6 , 5 + 2}, 
				shortValue = 4, 
				stringArrayValue = { "array", "value" }, 
				stringValue = "stringValue") @NestedAnnotation String s1, String s2, @NestedAnnotation("thirdParameter") String s3) {
		}
		
		private void method(CharSequence charSequence) {
		}

		@NestedAnnotation("parameterizedConstructor")
		public <T extends List<String>> Annotated(String string, T t) {
		}
		
		@NestedAnnotation("method")
		public void method() {
		}
		
		public void method(@TestAnnotation(
				annotationValue = @NestedAnnotation, 
				booleanValue = false, 
				byteValue = 1 + 1, 
				charSequenceClass = String.class, 
				charValue = 'a', 
				classArray = { Annotated.class, Annotated.class }, 
				doubleValue = 0.5, 
				enumValue = TestEnum.FirstValue, 
				floatValue = 0.8f, 
				longValue = { 6 , 5 + 2}, 
				shortValue = 4, 
				stringArrayValue = { "array", "value" }, 
				stringValue = "stringValue") @NestedAnnotation String s1, String s2, @NestedAnnotation("thirdParameter") String s3) {
		}
		
		
	}
	
}

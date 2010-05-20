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
	long[] longValue();
	char[] charValue();
	TestEnum enumValue();
	NestedAnnotation annotationValue();
	String stringValue();
	String[] stringArrayValue();
	Class<? extends CharSequence> charSequenceClass();
	Class<?>[] classArray();
	
	@Retention(RetentionPolicy.RUNTIME)
	@interface NestedAnnotation {
		String value() default "MyString";
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
			stringArrayValue = { "array", "value", "duplicate", "duplicate" }, 
			stringValue = "stringValue")
	public static class Annotated {
		
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
				public CharSequence subSequence(int start, int end) {
					return null;
				}
				@NestedAnnotation("method")
				public int length() {
					return 0;
				}
				
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

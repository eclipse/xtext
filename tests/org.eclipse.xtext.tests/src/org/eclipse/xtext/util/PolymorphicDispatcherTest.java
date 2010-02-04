/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.math.BigInteger;

import junit.framework.TestCase;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("unused")
public class PolymorphicDispatcherTest extends TestCase {

	class SuperClass {
		String label(Number i) {
			return "Number_from_superclass_" + i;
		}
	}
	
	public void testPerformance() throws Exception {
		Object first = new SuperClass() {
			String label(Integer i) {
				return "Integer_first_" + i;
			}

			String label(BigInteger i) {
				return "BigInteger_" + i;
			}
		};
		Object second = new Object() {
			String label(Integer i) {
				return "Integer_second_" + i;
			}

			String label(Number i) {
				return "Number_" + i;
			}

			String label(Object i) {
				return "Object_" + i;
			}
		};
		PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("label", Lists.newArrayList(first, second));
		long before = System.currentTimeMillis();
		for (int i=0;i<30000;i++) {
			String string = dispatcher.invoke(34);
			assertNotNull(string);
		}
		long after = System.currentTimeMillis();
		assertTrue((after-before) < 1000);
	}

	public void testSimple() throws Exception {
		Object first = new SuperClass() {
			String label(Integer i) {
				return "Integer_first_" + i;
			}

			String label(BigInteger i) {
				return "BigInteger_" + i;
			}
		};
		Object second = new Object() {
			String label(Integer i) {
				return "Integer_second_" + i;
			}

			String label(Number i) {
				return "Number_" + i;
			}

			String label(Object i) {
				return "Object_" + i;
			}
		};
		PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("label", Lists.newArrayList(first, second));

		assertEquals("Integer_first_3", dispatcher.invoke(new Integer(3)));
		assertEquals("Number_from_superclass_3", dispatcher.invoke(new Long(3)));
		assertEquals("BigInteger_3", dispatcher.invoke(BigInteger.valueOf(3)));
		assertEquals("Object_foo", dispatcher.invoke("foo"));
	}

	public void testMixedTypes() throws Exception {
		Object o1 = new Object() {

			String label(Number i) {
				return "Number_" + i;
			}

			String label(String i) {
				return "String_" + i;
			}

			String label(Integer i) {
				return "Integer_" + i;
			}

		};
		PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("label", Lists.newArrayList(o1));

		assertEquals("Integer_3", dispatcher.invoke(new Integer(3)));
	}

	public void testDifferentParamLength() throws Exception {
		Object o1 = new Object() {
			String label(Integer i, Object stuff) {
				return "Integer_" + i + "_" + stuff;
			}

			String label(Number i, String foo) {
				return "Number_" + i + "_" + foo;
			}

			String label(Object i) {
				return "Object_" + i;
			}
		};
		PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("label", 1, 2, Lists.newArrayList(o1),
			new PolymorphicDispatcher.ErrorHandler<String>(){
				public String handle(Object[] params, Throwable throwable) {
					return null;
				}
			});
		assertEquals("Object_3", dispatcher.invoke(new Integer(3)));
		assertNull("Integer_3_4", dispatcher.invoke(new Long(3), 4));
		assertEquals("Integer_3_4", dispatcher.invoke(new Integer(3), 4));
		assertEquals("Object_3", dispatcher.invoke(BigInteger.valueOf(3)));
		assertEquals("Number_3_foo", dispatcher.invoke(BigInteger.valueOf(3), "foo"));
	}

	public void testAmbiguous() throws Exception {
		Object o1 = new Object() {

			String label(CharSequence i) {
				return CharSequence.class.getSimpleName();
			}

			String label(Comparable<?> c) {
				return Comparable.class.getSimpleName();
			}
		};
		PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("label", Lists.newArrayList(o1));
		try {
			dispatcher.invoke("string");
			fail("exception expected, due to ambiguous methods");
		} catch (IllegalStateException e) {
			// ignore
		}
	}
	
	public void testPrivateMethodAccess() {
		Object o1 = new Object() {
			private String label(Integer i) {
				return "Integer_" + i;
			}
			
			private String label(Number n) {
				return "Number_" + n;
			}
		};
		PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("label", Lists.newArrayList(o1));
		assertEquals("Integer_17", dispatcher.invoke(new Integer(17)));
		assertEquals("Number_42", dispatcher.invoke(BigInteger.valueOf(42)));
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD})
	private @interface TestLabelAnnotation {
	}
	
	public void testCustomFilter() {
		Object o1 = new Object() {
			@TestLabelAnnotation
			private String sillyMethodName(Integer i) {
				return "Integer_" + i;
			}
			private String label(Number n) {
				return "Number_" + n;
			}
		};
		PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>(Lists.newArrayList(o1), new Predicate<Method>() {
			public boolean apply(Method param) {
				return ( (param.getName().equals("label")) || (param.getAnnotation(TestLabelAnnotation.class) != null));
			}
		});

		assertEquals("Integer_17", dispatcher.invoke(new Integer(17)));
		assertEquals("Number_42", dispatcher.invoke(BigInteger.valueOf(42)));
	}

}

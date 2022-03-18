/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package test;

/**
 * @since 2.5
 */
public @interface Annotation {
	boolean booleanValue() default true;
	int intValue() default 1;
	long longValue() default 42;
	String stringValue() default "foo";
	
	boolean[] booleanArrayValue() default {true};
	int[] intArrayValue() default {42};
	long[] longArrayValue() default {99};
	String[] stringArrayValue() default {"foo"};
	
	Class<?> typeValue() default String.class;
	Class<?>[] typeArrayValue() default {String.class};
	
	Annotation2 annotation2Value() default @Annotation2;
	Annotation2[] annotation2ArrayValue() default {@Annotation2};
	
	Enum1 enumValue() default Enum1.BLUE;
	Enum1[] enumArrayValue() default {Enum1.BLUE, Enum1.RED};
}


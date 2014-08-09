/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Optionally annotate a smoke test suite with {@code @IgnoredMethods} and list the names
 * of the methods of the original test class that shouldn't be processed as smoke tests.
 * Names may be semi qualified (e.g. {@code MySimpleTestClass.methodName}) or simple names
 * (e.g. {@code methodName}).
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface IgnoredMethods {
	String[] value() default {};
}
/*******************************************************************************
 * Copyright (c) 2006, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Saff (saff@mit.edu) - initial API and implementation
 *             (bug 102632: [JUnit] Support for JUnit 4.)
 *     Andrew Eisenberg <andrew@eisenberg.as> - [JUnit] Rerun failed first does not work with JUnit4 - https://bugs.eclipse.org/bugs/show_bug.cgi?id=140392
 *******************************************************************************/
package org.eclipse.jdt.junit4.runtime.patch;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Test;

import org.eclipse.jdt.internal.junit.runner.ITestLoader;
import org.eclipse.jdt.internal.junit.runner.ITestReference;
import org.eclipse.jdt.internal.junit.runner.RemoteTestRunner;
import org.eclipse.jdt.internal.junit.runner.junit3.JUnit3TestLoader;
import org.eclipse.jdt.internal.junit.runner.junit3.JUnit3TestReference;

@SuppressWarnings("restriction")
public class JUnit4TestLoader implements ITestLoader {

	public ITestReference[] loadTests(Class[] testClasses, String testName, String[] failureNames, RemoteTestRunner listener) {

		ITestReference[] refs = new ITestReference[testClasses.length];
		for (int i = 0; i < testClasses.length; i++) {
			Class<?> clazz = testClasses[i];
			ITestReference ref = createTest(clazz, testName, failureNames, listener);
			refs[i] = ref;
		}
		return refs;
	}

	private ITestReference createTest(Class<?> clazz, String testName, String[] failureNames, RemoteTestRunner listener) {
		if (clazz == null)
			return null;
		if (testName == null)
			return new JUnit4TestClassReference(clazz, failureNames);
		else if (isJUnit3SetUpTest(clazz, testName)) {
			JUnit3TestLoader jUnit3TestLoader = new JUnit3TestLoader();
			Test test = jUnit3TestLoader.getTest(clazz, testName, listener);
			return new JUnit3TestReference(test);
		}
		return new JUnit4TestMethodReference(clazz, testName, failureNames);
	}

	private boolean isJUnit3SetUpTest(Class<?> clazz, String testName) {
		if (!Test.class.isAssignableFrom(clazz))
			return false;
		try {
			Method testMethod = clazz.getMethod(testName);
			if (testMethod.getAnnotation(org.junit.Test.class) != null)
				return false;

			Method setup = clazz.getMethod(JUnit3TestLoader.SET_UP_TEST_METHOD_NAME, new Class[] { Test.class });
			int modifiers = setup.getModifiers();
			if (setup.getReturnType() == Test.class && Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers))
				return true;
		} catch (SecurityException e1) {
		} catch (NoSuchMethodException e) {
		}
		return false;
	}
}

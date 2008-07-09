/*******************************************************************************
 * Copyright (c) 2008 Syntax Consulting, Inc. All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package com.rcpquickstart.bundletestcollector;

import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import junit.framework.TestSuite;

import org.osgi.framework.Bundle;

import com.rcpquickstart.internal.bundletestcollector.Activator;

/**
 * This class allows you harvest unit tests from resolved bundles based on
 * filters you supply. It can harvest tests from both bundles and fragments, and
 * can also be used during automated builds using the Eclipse Testing Framework.
 * <p>
 * This class is similar to the JUnit TestCollector class, except that it takes
 * responsibility for both loading the classes and adding them to the test
 * suite. The collector must load the classes using the appropriate bundle
 * classloader for each test, so this work cannot be done in the suite.
 * <p>
 * To use this collector, simply create a JUnit test suite with a method like
 * this:
 * <p>
 * 
 * <pre>
 * public static Test suite() {
 * 
 * 	TestSuite suite = new TestSuite(&quot;All Tests&quot;);
 * 
 * 	PluginTestCollector testCollector = new PluginTestCollector();
 * 	testCollector.collectTests(suite, &quot;com.rcpquickstart.&quot;,
 * 			&quot;com.rcpquickstart.mypackage.&quot;, &quot;*Test&quot;);
 * 
 * 	return suite;
 * 
 * }
 * </pre>
 * <p>
 * Note that because JUnit 4 implements suites through annotations, a similar
 * mechanism cannot be used. If anyone has ideas concerning how this could be
 * made to work using JUnit 4, please let me know. Comments and suggestions can
 * be sent to patrick@rcpquickstart.com.
 * 
 * @author Patrick Paulin
 * 
 */
public class BundleTestCollector {

	/**
	 * Create a list of test classes for the bundles currently resolved by the
	 * framework. This method works with JUnit 3.x test cases only, meaning that
	 * it searches for classes that subclass the TestCase class.
	 * 
	 * @param suite
	 * 		to which tests should be added
	 * @param bundleRoot
	 * 		root string that a bundle id needs to start with in order for the
	 * 		bundle to be included in the search
	 * @param packageRoot
	 * 		root string that a package needs to start with in order for the
	 * 		package to be included in the search
	 * @param testClassFilter
	 * 		filter string that will be used to search for test cases. The filter
	 * 		applies to the unqualified class name only (not including the
	 * 		package name). Wildcards are allowed, as defined by the {@link
	 * 		Activator Bundle#findEntries(String, String, boolean)} method.
	 * @return list of test classes that match the roots and filter passed in
	 */
	public void collectTests(TestSuite suite, String bundleRoot,
			String packageRoot, String testClassFilter) {

		for (Bundle bundle : Activator.getDefault().getBundles()) {
			if (!isFragment(bundle)
					&& bundle.getSymbolicName().startsWith(bundleRoot)) {
				List<Class> testClasses = getTestClasesInBundle(bundle,
						packageRoot, testClassFilter);

				for (Class clazz : testClasses) {
					suite.addTestSuite(clazz);
				}
			}
		}
	}

	private List<Class> getTestClasesInBundle(Bundle bundle,
			String packageRoot, String testClassFilter) {
		List<Class> testClassesInBundle = new ArrayList<Class>();

		Enumeration testClassNames = bundle.findEntries(
				"/", testClassFilter + ".class", true); //$NON-NLS-1$
		if (testClassNames != null) {
			while (testClassNames.hasMoreElements()) {

				/*
				 * Take relative path produced by findEntries method and convert
				 * it into a properly formatted class name. The package root is
				 * used to determine the start of the qualified class name in
				 * the path.
				 */
				String testClassPath = ((URL) testClassNames.nextElement())
						.getPath();
				testClassPath = testClassPath.replace('/', '.');

				int packageRootStart = testClassPath.indexOf(packageRoot);

				/* if class does not begin with package root, just ignore it */
				if (packageRootStart == -1) {
					continue;
				}

				String testClassName = testClassPath
						.substring(packageRootStart);
				testClassName = testClassName.substring(0, testClassName
						.length()
						- ".class".length()); //$NON-NLS-1$

				/* Attempt to load the class using the bundle classloader. */
				Class testClass = null;
				try {
					testClass = bundle.loadClass(testClassName);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException("Could not load class: " //$NON-NLS-1$
							+ testClassName, e);
				}

				/*
				 * If the class is not abstract, add it to list
				 */
				if (!Modifier.isAbstract(testClass.getModifiers())) {
					testClassesInBundle.add(testClass);
				}
			}
		}
		return testClassesInBundle;
	}

	private boolean isFragment(Bundle bundle) {
		Enumeration headerKeys = bundle.getHeaders().keys();
		while (headerKeys.hasMoreElements()) {
			if (headerKeys.nextElement().toString().equals("Fragment-Host")) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}
}

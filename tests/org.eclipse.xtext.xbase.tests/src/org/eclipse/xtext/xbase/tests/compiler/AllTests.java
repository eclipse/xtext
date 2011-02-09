/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.xbase.tests.expression.CustomExpressionTest;
import org.eclipse.xtext.xbase.tests.interpreter.XbaseInterpreterTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
//		suite.addTestSuite(OnTheFlyJavaCompilerTest.class);
		suite.addTestSuite(CustomExpressionTest.class);
//		suite.addTestSuite(CompilerTest.class);
		suite.addTestSuite(XbaseInterpreterTest.class);
		//$JUnit-END$
		return suite;
	}

}

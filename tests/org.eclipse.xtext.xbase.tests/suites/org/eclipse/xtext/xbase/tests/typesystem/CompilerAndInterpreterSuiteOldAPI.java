/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.compiler.CompilerTest;
import org.eclipse.xtext.xbase.tests.compiler.CompilerTests2;
import org.eclipse.xtext.xbase.tests.compiler.EvaluationCompilerTest;
import org.eclipse.xtext.xbase.tests.compiler.output.CompilerTraceTest;
import org.eclipse.xtext.xbase.tests.interpreter.XbaseInterpreterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	EvaluationCompilerTest.class,
	XbaseInterpreterTest.class,
	CompilerTest.class,
	CompilerTraceTest.class,
	CompilerTests2.class
})
public class CompilerAndInterpreterSuiteOldAPI {}

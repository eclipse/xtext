/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.annotations.AnnotationsCompilerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	AnnotationCompilerTest.class,
	AnnotationsCompilerTest.class,
	CompilerTest.class,
	CompilerBugTest.class,
	CompilerBug342021Test.class,
	CompilerBug405825Test.class,
	CompilerBug406425Test.class,
	CompilerBug406549Test.class,
	CompilerBug410555Test.class,
	CompilerBug410556Test.class,
	CompilerBug410767Test.class,
	CompilerBug413138Test.class,
	CompilerBug417522Test.class,
	CompilerTraceTest.class,
	ConfiguredCompilerTest.class,
	ExtensionsCompilerTest.class,
	DataCompilerTest.class,
	ParameterizedTypeCompilerTest.class,
	PropertyCompilerTest.class,
	XtendCompilerTest.class,
	XtendCompilerErrorHandlingTest.class,
	XbaseIntegrationTest.class
})
public class CompilerSuite {
}

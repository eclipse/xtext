package org.eclipse.xtend.core.tests.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.eclipse.xtend.core.tests.AbstractXtendTestCase

abstract class AbstractActiveAnnotationTest extends AbstractXtendTestCase {
	
	protected extension XtendCompilerTester
	
	@Inject def doInject(XtendCompilerTester compilerTester) {
		_xtendCompilerTester = compilerTester
		_xtendCompilerTester.javaCompilerClassPath = class.classLoader
	}
}
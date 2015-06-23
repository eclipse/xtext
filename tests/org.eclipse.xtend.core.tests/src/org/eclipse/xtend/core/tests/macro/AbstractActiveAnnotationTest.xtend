package org.eclipse.xtend.core.tests.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.eclipse.xtend.core.tests.AbstractXtendTestCase

abstract class AbstractActiveAnnotationTest extends AbstractXtendTestCase {
	
	@Inject protected extension XtendCompilerTester
	
}
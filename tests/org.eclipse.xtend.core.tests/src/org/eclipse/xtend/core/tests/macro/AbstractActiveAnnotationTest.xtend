package org.eclipse.xtend.core.tests.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.core.tests.AbstractXtendTestCase

abstract class AbstractActiveAnnotationTest extends AbstractXtendTestCase {
	
	protected extension XtendCompilerTester
	
	@Inject def doInject(XtendCompilerTester compilerTester, ProcessorInstanceForJvmTypeProvider processorProvider) {
		processorProvider.setClassLoader(class.classLoader)
		_xtendCompilerTester = compilerTester
	}

}
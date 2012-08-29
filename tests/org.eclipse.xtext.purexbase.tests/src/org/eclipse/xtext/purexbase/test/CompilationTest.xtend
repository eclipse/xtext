package org.eclipse.xtext.purexbase.test

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.purexbase.PureXbaseStandaloneSetup
import org.eclipse.xtext.purexbase.PureXbaseInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PureXbaseInjectorProvider))
class CompilationTest {
	
	@Inject extension CompilationTestHelper
	
	@Test def simpleCompile() {
		'''
		  'foo'.length()
		'''.assertCompilesTo('''
		''')
	}
}
package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.JvmVisibility
import org.junit.Test

class InterfaceBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Test
	def testXtendInterface() {
		(createInterfaceBuilder(xtendClass) => [
			context = xtendClass
			interfaceName = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			interface Bar {
			}''')
	}
	
	@Test
	def testJavaClass() {
		(createInterfaceBuilder(javaClass) => [
			context = javaClass
			interfaceName = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			public interface Bar {
			}''')
	}
}
package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.JvmVisibility
import org.junit.Test

class ClassBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Test
	def testXtendClass() {
		(createClassBuilder(xtendClass) => [
			context = xtendClass
			className = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			class Bar {
			}''')
	}
	
	@Test
	def testJavaClass() {
		(createClassBuilder(javaClass) => [
			context = javaClass
			className = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			public class Bar {
			}''')
	}
}
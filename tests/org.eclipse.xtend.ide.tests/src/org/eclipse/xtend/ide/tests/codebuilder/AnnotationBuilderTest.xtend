package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.JvmVisibility
import org.junit.Test

class AnnotationBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Test
	def testXtendAnnotation() {
		(createAnnotationBuilder(xtendClass) => [
			context = xtendClass
			annotationName = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			annotation Bar {
			}''')
	}
	
	@Test
	def testJavaAnnotation() {
		(createAnnotationBuilder(javaClass) => [
			context = javaClass
			annotationName = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			public @interface Bar {
			}''')
	}
}
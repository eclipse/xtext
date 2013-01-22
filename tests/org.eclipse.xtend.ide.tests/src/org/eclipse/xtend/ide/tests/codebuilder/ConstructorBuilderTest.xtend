package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.junit.Test
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmTypeReference

class ConstructorBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Inject extension TypeReferences
	
	static val DEFAULT_BODY = 'throw new UnsupportedOperationException("TODO: auto-generated method stub")'
	
	@Test
	def testXtendMethod() {
		(createConstructorBuilder(xtendClass) => [
			context = xtendClass
			visibility = JvmVisibility::PROTECTED
			parameterTypes = <JvmTypeReference>newArrayList(xtendClass.createTypeRef, xtendClass.createTypeRef)
		]).assertBuilds('''
			protected new(Foo foo, Foo foo2) {
			  «DEFAULT_BODY»
			}''')
	}
	
	@Test
	def testJavaMethod() {
		(createConstructorBuilder(javaClass) => [
			context = javaClass
			visibility = JvmVisibility::PRIVATE
			parameterTypes = <JvmTypeReference>newArrayList(javaClass.createTypeRef, javaClass.createTypeRef)
		]).assertBuilds('''
			private Bar(Bar bar, Bar bar2) {
			  «DEFAULT_BODY»;
			}''')
	}
}
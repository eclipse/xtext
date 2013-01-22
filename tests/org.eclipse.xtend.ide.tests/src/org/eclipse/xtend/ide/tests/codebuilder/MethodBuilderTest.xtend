package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.junit.Test
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmTypeReference

class MethodBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Inject extension TypeReferences
	
	static val DEFAULT_BODY = 'throw new UnsupportedOperationException("TODO: auto-generated method stub")'
	
	@Test
	def testXtendMethod() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			methodName = 'foo'
			returnType = xtendClass.createTypeRef
			visibility = JvmVisibility::PUBLIC
			parameterTypes = <JvmTypeReference>newArrayList(xtendClass.createTypeRef, xtendClass.createTypeRef)
		]).assertBuilds('''
			def foo(Foo foo, Foo foo2) {
			  «DEFAULT_BODY»
			}''')
	}
	
	@Test
	def testJavaMethod() {
		(createMethodBuilder(javaClass) => [
			context = javaClass
			methodName = 'bar'
			returnType = javaClass.createTypeRef
			visibility = JvmVisibility::PUBLIC
			parameterTypes = <JvmTypeReference>newArrayList(javaClass.createTypeRef, javaClass.createTypeRef)
		]).assertBuilds('''
			public Bar bar(Bar bar, Bar bar2) {
			  «DEFAULT_BODY»;
			}''')
	}
}
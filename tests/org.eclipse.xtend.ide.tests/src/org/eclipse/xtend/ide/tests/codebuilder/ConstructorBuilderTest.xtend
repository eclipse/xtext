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
	
	@Test
	def testXtendConstructor() {
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
	def testJavaConstructor() {
		(createConstructorBuilder(javaClass) => [
			context = javaClass
			visibility = JvmVisibility::PRIVATE
			parameterTypes = <JvmTypeReference>newArrayList(javaClass.createTypeRef, javaClass.createTypeRef)
		]).assertBuilds('''
			private Bar(Bar bar, Bar bar2) {
			  «DEFAULT_BODY»;
			}''') 
	}
	
	@Test
	def testXtendParameterNames() {
		(createConstructorBuilder(xtendClass) => [
			context = xtendClass
			visibility = JvmVisibility::PROTECTED
			parameterTypes = <JvmTypeReference>newArrayList(xtendClass.createTypeRef, javaClass.createTypeRef)
			parameterNames = #['bar','foo']
		]).assertBuilds('''
			protected new(Foo bar, Bar foo) {
			  «DEFAULT_BODY»
			}''')
	}
	
	@Test
	def testJavaParameterNames() {
		(createConstructorBuilder(javaClass) => [
			context = javaClass
			visibility = JvmVisibility::PRIVATE
			parameterTypes = <JvmTypeReference>newArrayList(xtendClass.createTypeRef, javaClass.createTypeRef)
			parameterNames = #['bar','foo']
		]).assertBuilds('''
			private Bar(Foo bar, Bar foo) {
			  «DEFAULT_BODY»;
			}''') 
	}
	
	@Test
	def testXtendExceptions() {
		(createConstructorBuilder(xtendClass) => [
			context = xtendClass
			exceptions = #[ Exception.getTypeForName(xtendClass), RuntimeException.getTypeForName(xtendClass)]
		]).assertBuilds('''
			new() throws Exception, RuntimeException {
			  «DEFAULT_BODY»
			}''')
		
	}
	
	@Test
	def testJavaException() {
		(createConstructorBuilder(javaClass) => [
			context = javaClass
			exceptions = #[ Exception.getTypeForName(javaClass), RuntimeException.getTypeForName(javaClass)]
		]).assertBuilds('''
			Bar() throws Exception, RuntimeException {
			  «DEFAULT_BODY»;
			}''')
	}
	
	@Test
	def testXtendCustomBody() {
		(createConstructorBuilder(xtendClass) => [
			context = xtendClass
			body = 'return'
		]).assertBuilds('''
			new() {
			  return
			}''')
		
	}
	
	@Test
	def testJavaCustomBody() {
		(createConstructorBuilder(javaClass) => [
			context = javaClass
			body = 'return'
		]).assertBuilds('''
			Bar() {
			  return;
			}''')
	}
	
	
	
}
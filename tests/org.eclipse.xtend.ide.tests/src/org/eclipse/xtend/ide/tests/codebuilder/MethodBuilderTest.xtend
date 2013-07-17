package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.junit.Test
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory

class MethodBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Inject extension TypeReferences
	
	@Inject extension TypesFactory
	
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
	
	@Test
	def testStaticXtendMethod() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			methodName = 'foo'
			returnType = xtendClass.createTypeRef
			visibility = JvmVisibility::PROTECTED
			staticFlag = true
			parameterTypes = <JvmTypeReference>newArrayList(xtendClass.createTypeRef)
		]).assertBuilds('''
			def protected static foo(Foo foo) {
			  «DEFAULT_BODY»
			}''')
	}
	
	@Test
	def testStaticJavaMethod() {
		(createMethodBuilder(javaClass) => [
			context = javaClass
			methodName = 'bar'
			returnType = javaClass.createTypeRef
			visibility = JvmVisibility::PRIVATE
			staticFlag = true
			parameterTypes = <JvmTypeReference>newArrayList(javaClass.createTypeRef)
		]).assertBuilds('''
			private static Bar bar(Bar bar) {
			  «DEFAULT_BODY»;
			}''')
	}
	
	@Test
	def testXtendCustomBody() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			methodName = 'foo'
			body = 'return'
		]).assertBuilds('''
			def foo() {
			  return
			}''')
		
	}
	
	@Test
	def testJavaCustomBody() {
		(createMethodBuilder(javaClass) => [
			context = javaClass
			methodName = 'foo'
			body = 'return'
		]).assertBuilds('''
			void foo() {
			  return;
			}''')
	}
	
	@Test
	def testXtendOverrride() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			methodName = 'foo'
			overrideFlag = true
		]).assertBuilds('''
			override foo() {
			  «DEFAULT_BODY»
			}''')
		
	}
	
	@Test
	def testJavaOverride() {
		(createMethodBuilder(javaClass) => [
			context = javaClass
			methodName = 'foo'
			overrideFlag = true
		]).assertBuilds('''
			@Override
			void foo() {
			  «DEFAULT_BODY»;
			}''')
	}
	
	@Test
	def testXtendExceptions() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			methodName = 'foo'
			exceptions = #[ Exception.getTypeForName(xtendClass), RuntimeException.getTypeForName(xtendClass)]
		]).assertBuilds('''
			def foo() throws Exception, RuntimeException {
			  «DEFAULT_BODY»
			}''')
		
	}
	
	@Test
	def testJavaException() {
		(createMethodBuilder(javaClass) => [
			context = javaClass
			methodName = 'foo'
			exceptions = #[ Exception.getTypeForName(javaClass), RuntimeException.getTypeForName(javaClass)]
		]).assertBuilds('''
			void foo() throws Exception, RuntimeException {
			  «DEFAULT_BODY»;
			}''')
	}
	
	@Test
	def testXtendNamedParameter() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			methodName = 'foo'
			parameterNames = #['bar', 'baz']
			parameterTypes = <JvmTypeReference>newArrayList(xtendClass.createTypeRef, xtendClass.createTypeRef)
		]).assertBuilds('''
			def foo(Foo bar, Foo baz) {
			  «DEFAULT_BODY»
			}''')
		
	}
	
	@Test
	def testJavaNamedParameter() {
		(createMethodBuilder(javaClass) => [
			context = javaClass
			methodName = 'foo'
			parameterNames = #['bar', 'baz']
			parameterTypes = <JvmTypeReference>newArrayList(xtendClass.createTypeRef, xtendClass.createTypeRef)
		]).assertBuilds('''
			void foo(Foo bar, Foo baz) {
			  «DEFAULT_BODY»;
			}''')
	}
	
	@Test
	def testXtendTypeParameter() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			methodName = 'foo'
			typeParameters = #[createJvmTypeParameter => [ name = 'T'], createJvmTypeParameter => [ name = 'U']]
		]).assertBuilds('''
			def <T,U> foo() {
			  «DEFAULT_BODY»
			}''')
		
	}
	
	@Test
	def testJavaTypeParameter() {
		(createMethodBuilder(javaClass) => [
			context = javaClass
			methodName = 'foo'
			typeParameters = #[createJvmTypeParameter => [ name = 'T'], createJvmTypeParameter => [ name = 'U']]
		]).assertBuilds('''
			<T,U> void foo() {
			  «DEFAULT_BODY»;
			}''')
	}
	
}
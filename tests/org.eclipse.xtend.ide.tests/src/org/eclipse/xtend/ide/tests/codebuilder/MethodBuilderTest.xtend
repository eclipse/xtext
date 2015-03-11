package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.junit.Test

class MethodBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Inject extension TypesFactory
	
	@Test
	def testXtendMethod() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			methodName = 'foo'
			returnType = xtendClass.createTypeRef
			visibility = JvmVisibility::PUBLIC
			newParameterBuilder.type = xtendClass.createTypeRef
			newParameterBuilder.type = xtendClass.createTypeRef
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
			newParameterBuilder.type = javaClass.createTypeRef
			newParameterBuilder.type = javaClass.createTypeRef
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
			newParameterBuilder.type =  xtendClass.createTypeRef
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
			newParameterBuilder.type = javaClass.createTypeRef
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
			bodyGenerator = [append('return')]
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
			bodyGenerator = [append('return')]
		]).assertBuilds('''
			void foo() {
			  return;
			}''')
	}
	
	@Test
	def testXtendAbstractBody() {
		(createMethodBuilder(xtendClass) => [
			context = xtendClass
			abstractFlag = true
			methodName = 'foo'
		]).assertBuilds('''
			def void foo()''')
		
	}
	
	@Test
	def testJavaAbstractBody() {
		(createMethodBuilder(javaClass) => [
			context = javaClass
			abstractFlag = true
			methodName = 'foo'			
		]).assertBuilds('''
			abstract void foo();''')
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
			exceptions = #[ Exception.createTypeRef(xtendClass), RuntimeException.createTypeRef(xtendClass)]
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
			exceptions = #[ Exception.createTypeRef(javaClass), RuntimeException.createTypeRef(javaClass)]
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
			newParameterBuilder => [
				name = 'bar'
				type = xtendClass.createTypeRef
			]
			newParameterBuilder => [
				name = 'baz'
				type = xtendClass.createTypeRef
			]
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
			newParameterBuilder => [
				name = 'bar'
				type = xtendClass.createTypeRef
			]
			newParameterBuilder => [
				name = 'baz'
				type = xtendClass.createTypeRef
			]
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
	
	
	@Test
	def void testSetContextOnParameters() {
		createMethodBuilder(xtendClass) => [
			val builder = newParameterBuilder
			assertNull(builder.context)
			context = xtendClass
			assertEquals(xtendClass, builder.context)
		]
	}


}
package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.JvmVisibility
import org.junit.Test

class FieldBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Test
	def testXtendField() {
		(createFieldBuilder(xtendClass) => [
			context = xtendClass
			fieldName = 'foo'
			fieldType = xtendClass.createTypeRef
		]).assertBuilds('Foo foo')
	}
	
	@Test
	def testPublicXtendField() {
		(createFieldBuilder(xtendClass) => [
			context = xtendClass
			fieldName = 'foo'
			fieldType = xtendClass.createTypeRef
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('public Foo foo')
	}
	
	@Test
	def testStaticXtendField() {
		(createFieldBuilder(xtendClass) => [
			context = xtendClass
			fieldName = 'foo'
			fieldType = xtendClass.createTypeRef
			visibility = JvmVisibility::PROTECTED
			staticFlag = true
		]).assertBuilds('protected static Foo foo')
	}
	
	@Test
	def testJavaField() {
		(createFieldBuilder(javaClass) => [
			context = javaClass
			fieldName = 'bar'
			fieldType = javaClass.createTypeRef
		]).assertBuilds('Bar bar;')
	}
	
	@Test
	def testPublicJavaField() {
		(createFieldBuilder(javaClass) => [
			context = javaClass
			fieldName = 'bar'
			fieldType = javaClass.createTypeRef
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('public Bar bar;')
	}
	
	@Test
	def testStaticJavaField() {
		(createFieldBuilder(javaClass) => [
			context = javaClass
			fieldName = 'bar'
			fieldType = javaClass.createTypeRef
			visibility = JvmVisibility::PROTECTED
			staticFlag = true
		]).assertBuilds('protected static Bar bar;')
	}
	
}
/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.JvmVisibility
import org.junit.Test

class ConstructorBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Test
	def testXtendConstructor() {
		(createConstructorBuilder(xtendClass) => [
			context = xtendClass
			visibility = JvmVisibility::PROTECTED
			newParameterBuilder.type = xtendClass.createTypeRef
			newParameterBuilder.type = xtendClass.createTypeRef
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
			newParameterBuilder.type = javaClass.createTypeRef
			newParameterBuilder.type = javaClass.createTypeRef
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
			newParameterBuilder => [
				type = xtendClass.createTypeRef
				name = 'bar'
			]
			newParameterBuilder => [
				type = javaClass.createTypeRef
				name = 'foo'
			]
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
			newParameterBuilder => [
				type = xtendClass.createTypeRef
				name = 'bar'
			]
			newParameterBuilder => [
				type = javaClass.createTypeRef
				name = 'foo'
			]
		]).assertBuilds('''
			private Bar(Foo bar, Bar foo) {
			  «DEFAULT_BODY»;
			}''') 
	}
	
	@Test
	def testXtendExceptions() {
		(createConstructorBuilder(xtendClass) => [
			context = xtendClass
			exceptions = #[ Exception.createTypeRef(xtendClass), RuntimeException.createTypeRef(xtendClass)]
		]).assertBuilds('''
			new() throws Exception, RuntimeException {
			  «DEFAULT_BODY»
			}''')
		
	}
	
	@Test
	def testJavaException() {
		(createConstructorBuilder(javaClass) => [
			context = javaClass
			exceptions = #[ Exception.createTypeRef(javaClass), RuntimeException.createTypeRef(javaClass)]
		]).assertBuilds('''
			Bar() throws Exception, RuntimeException {
			  «DEFAULT_BODY»;
			}''')
	}
	
	@Test
	def testXtendCustomBody() {
		(createConstructorBuilder(xtendClass) => [
			context = xtendClass
			bodyGenerator = [append('return')]
		]).assertBuilds('''
			new() {
			  return
			}''')
		
	}
	
	@Test
	def testJavaCustomBody() {
		(createConstructorBuilder(javaClass) => [
			context = javaClass
			bodyGenerator = [append('return')]
		]).assertBuilds('''
			Bar() {
			  return;
			}''')
	}
}
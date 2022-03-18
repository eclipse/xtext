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
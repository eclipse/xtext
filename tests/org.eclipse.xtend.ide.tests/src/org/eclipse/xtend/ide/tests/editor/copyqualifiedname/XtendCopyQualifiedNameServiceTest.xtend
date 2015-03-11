/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor.copyqualifiedname

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.ui.editor.copyqualifiedname.CopyQualifiedNameService
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XConstructorCall
import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XtendCopyQualifiedNameServiceTest extends AbstractXtendUITestCase {

	@Inject
	WorkbenchTestHelper testHelper

	@Inject
	extension ParseHelper<XtendFile> parseHelper

	@Inject
	CopyQualifiedNameService copyQualifiedNameService

	@Test def void testJvmOperation() {
		val xtendFile = '''
			class Foo {
			
				def foo(java.util.List<String> list) {
					list.clear
					list.add(null)
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("java.util.List.clear()")
		expression.expressions.get(1).assertCopyQualifiedName("java.util.List.add(String)")
	}

	@Test def void testJvmOperation_2() {
		val xtendFile = '''
			class Foo {
			
				def foo(java.util.Map<? extends String, ? extends String> map) {
					map.get(null)
					map.put(null, null)
					bar(map)
				}
			
				def <K, V> void bar(java.util.Map<K, V> map) {
					
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("java.util.Map.get(Object)")
		expression.expressions.get(1).assertCopyQualifiedName("java.util.Map.put(? extends String, ? extends String)")
		expression.expressions.get(2).assertCopyQualifiedName("Foo.bar(Map<? extends String, ? extends String>)")
	}

	@Test def void testJvmOperation_3() {
		val xtendFile = '''
			class Foo extends java.util.ArrayList<String> {
			
				def bar() {
					clear
					add(null)
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("java.util.ArrayList.clear()")
		expression.expressions.get(1).assertCopyQualifiedName("java.util.ArrayList.add(String)")
	}

	@Test def void testJvmOperation_4() {
		val xtendFile = '''
			class Foo extends java.util.ArrayList<String> {
			
				def bar() {
					clear
					add(null)
					super.clear
					super.add(null)
				}
			
				override clear () {
					super.clear
				}
			
				override add(String value) {
					super.add(value)
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("Foo.clear()")
		expression.expressions.get(1).assertCopyQualifiedName("Foo.add(String)")
		expression.expressions.get(2).assertCopyQualifiedName("java.util.ArrayList.clear()")
		expression.expressions.get(3).assertCopyQualifiedName("java.util.ArrayList.add(String)")
	}

	@Test def void testJvmOperation_5() {
		val xtendFile = '''
			class Foo {
			
				def foo() {
					val list = <String>newArrayList
					list.clear
					list.add(null)
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(1).assertCopyQualifiedName("java.util.ArrayList.clear()")
		expression.expressions.get(2).assertCopyQualifiedName("java.util.ArrayList.add(String)")
	}

	@Test def void testJvmOperation_6() {
		val xtendFile = '''
			class Foo<T> extends java.util.ArrayList<T> {
			
				def bar() {
					clear
					add(null)
					super.clear
					super.add(null)
				}
			
				override clear () {
					super.clear
				}
			
				override add(T value) {
					super.add(value)
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("Foo.clear()")
		expression.expressions.get(1).assertCopyQualifiedName("Foo.add(T)")
		expression.expressions.get(2).assertCopyQualifiedName("java.util.ArrayList.clear()")
		expression.expressions.get(3).assertCopyQualifiedName("java.util.ArrayList.add(T)")
	}

	@Test def void testJvmOperation_7() {
		val xtendFile = '''
			class Foo {
				
				def foo () {
					new Bar<String>.bar(null)
					new Bar<String>.bar(<String>newArrayList)
				}
				
			}
			
			class Bar<T> {
			
				def bar (java.util.List<T> list) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("Bar.bar(List<String>)")
		expression.expressions.get(1).assertCopyQualifiedName("Bar.bar(ArrayList<String>)")
	}

	@Test def void testJvmOperation_8() {
		val xtendFile = '''
			class Foo<T> extends java.util.ArrayList<java.lang.Iterable<T>> {
			
				def bar() {
					add(null)
					super.add(null)
				}
			
				override add(java.lang.Iterable<T> value) {
					super.add(value)
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression

		expression.expressions.get(0).assertCopyQualifiedName("Foo.add(Iterable<T>)")
		expression.expressions.get(1).assertCopyQualifiedName("java.util.ArrayList.add(Iterable<T>)")
	}

	@Test def void testJvmConstructor() {
		val xtendFile = '''
			class Foo {
			
				def foo () {
					new Bar
					new Bar(null)
					new Bar(<String>newArrayList)
				}
			
			}
			
			class Bar {
			
				new () {
				}
				
				new (java.util.List<?> list) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("Bar()")
		expression.expressions.get(1).assertCopyQualifiedName("Bar(List<?>)")
		expression.expressions.get(2).assertCopyQualifiedName("Bar(ArrayList<String>)")
	}

	@Test def void testJvmConstructor_2() {
		val xtendFile = '''
			class Foo {
			
				def foo () {
					new Bar<String>
					new Bar<String>(null)
					new Bar<String>(<String>newArrayList)
				}
			
			}
			
			class Bar<T> {
			
				new () {
				}
			
				new (java.util.List<T> list) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendFunction).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("Bar()")
		expression.expressions.get(1).assertCopyQualifiedName("Bar(List<String>)")
		expression.expressions.get(2).assertCopyQualifiedName("Bar(ArrayList<String>)")
	}

	@Test def void testJvmConstructor_3() {
		val xtendFile = '''
			class Foo extends Bar {
				
				new (java.util.List<?> list) {
					super(list)
				}
			
				new () {
					super(<String>newArrayList)
				}
			
			}
			
			class Bar {
			
				new (java.util.List<?> list) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendConstructor).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("Bar(List<?>)")

		val expression2 = (xtendType.members.tail.head as XtendConstructor).expression as XBlockExpression
		expression2.expressions.get(0).assertCopyQualifiedName("Bar(ArrayList<String>)")
	}

	@Test def void testJvmConstructor_4() {
		val xtendFile = '''
			class Foo {
			
				new () {
					this(<String>newArrayList)
				}
			
				new (java.util.List<?> list) {
					
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		val expression = (xtendType.members.head as XtendConstructor).expression as XBlockExpression
		expression.expressions.get(0).assertCopyQualifiedName("Foo(ArrayList<String>)")
	}

	@Test def void testXtendFunction() {
		val xtendFile = '''
			class Foo {
			
				def foo(java.util.List<String> list) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		xtendType.members.head.assertCopyQualifiedName("Foo.foo(List<String>)")
	}

	@Test def void testXtendFunction_2() {
		val xtendFile = '''
			class Foo {
			
				def foo(java.util.Map<? extends String, ? extends String> map) {
				}
			
				def <K, V> void bar(java.util.Map<K, V> map) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		xtendType.members.head.assertCopyQualifiedName("Foo.foo(Map<? extends String, ? extends String>)")
		xtendType.members.tail.head.assertCopyQualifiedName("Foo.bar(Map<K, V>)")
	}

	@Test def void testXtendFunction_3() {
		val xtendFile = '''
			class Foo extends java.util.ArrayList<String> {
			
				override clear () {
					super.clear
				}
			
				override add(String value) {
					super.add(value)
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		xtendType.members.head.assertCopyQualifiedName("Foo.clear()")
		xtendType.members.tail.head.assertCopyQualifiedName("Foo.add(String)")
	}

	@Test def void testXtendFunction_4() {
		val xtendFile = '''
			class Foo<T> extends java.util.ArrayList<T> {
			
				override clear () {
					super.clear
				}
			
				override add(T value) {
					super.add(value)
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		xtendType.members.head.assertCopyQualifiedName("Foo.clear()")
		xtendType.members.tail.head.assertCopyQualifiedName("Foo.add(T)")
	}

	@Test def void testXtendFunction_5() {
		val xtendFile = '''
			class Foo<T> {
			
				def foo (java.util.List<T> list) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		xtendType.members.head.assertCopyQualifiedName("Foo.foo(List<T>)")
	}

	@Test def void testXtendConstructor() {
		val xtendFile = '''
			class Foo {
			
				new () {
				}
				
				new (java.util.List<?> list) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		xtendType.members.head.assertCopyQualifiedName("Foo()")
		xtendType.members.tail.head.assertCopyQualifiedName("Foo(List<?>)")
	}

	@Test def void testXtendConstructor_2() {
		val xtendFile = '''
			class Foo<T> {
			
				new (java.util.List<T> list) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		xtendType.members.head.assertCopyQualifiedName("Foo(List<T>)")
	}

	@Test def void testXtendConstructor_3() {
		val xtendFile = '''
			class Foo<X, Y> {
			
				new (X x, Y y) {
				}
			
			}
		'''.parse(resourceSet)
		val xtendType = xtendFile.xtendTypes.head
		xtendType.members.head.assertCopyQualifiedName("Foo(X, Y)")
	}

	def dispatch assertCopyQualifiedName(XAbstractFeatureCall featureCall, String expectedQualifiedName) {
		expectedQualifiedName.assertEquals(copyQualifiedNameService.getQualifiedName(featureCall.feature, featureCall))
	}

	def dispatch assertCopyQualifiedName(XConstructorCall constructorCall, String expectedQualifiedName) {
		expectedQualifiedName.assertEquals(
			copyQualifiedNameService.getQualifiedName(constructorCall.constructor, constructorCall))
	}

	def dispatch assertCopyQualifiedName(EObject object, String expectedQualifiedName) {
		expectedQualifiedName.assertEquals(copyQualifiedNameService.getQualifiedName(object, null))
		expectedQualifiedName.assertEquals(copyQualifiedNameService.getQualifiedName(object, object.eContainer))
	}

	def getResourceSet() {
		injector.getInstance(IResourceSetProvider).get(testHelper.project)
	}

}

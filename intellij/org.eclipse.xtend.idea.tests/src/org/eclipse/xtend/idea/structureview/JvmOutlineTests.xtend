/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.structureview

import com.intellij.ide.structureView.StructureView
import com.intellij.ide.structureView.impl.StructureViewComposite
import com.intellij.ide.structureView.newStructureView.StructureViewComponent
import org.eclipse.xtend.core.idea.structureview.SyntheticMemberFilter
import org.junit.Ignore
import org.junit.Test

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmOutlineTests extends AbstractOutlineTests {

	override protected getStructureViewComponent(StructureView structureView) {
		(structureView as StructureViewComposite).structureViews.last.structureView as StructureViewComponent => [
			setActionActive(SyntheticMemberFilter.ID, true)
		]
	}

	override protected getNestedTypesExpectation() '''
		aaa.xtend
		 Foo
		  Bar
		   Baz
		   FooBar
		    X
		   bar() : Object
		  foo : int
	'''

	override protected getTypeParameter1Expectation() '''
		aaa.xtend
		 Foo<T extends Object>
	'''

	@Test
	def void testDispatchMethod_1() {
		testStructureView('''
			class Foo {
				def dispatch foo(String x) {''}
				def dispatch foo(Object y) {''}
				def dispatch bar(String x) {''}
				def dispatch bar(Object y) {''}
			}
		''', '''
			aaa.xtend
			 Foo
			  _foo(String) : String
			  _foo(Object) : String
			  _bar(String) : String
			  _bar(Object) : String
			  foo(Object) : String
			  bar(Object) : String
		''')
	}

	override protected getOperatorDeclarationWithSymbolExpectation() '''
		aaa.xtend
		 Foo
		  operator_not(Object) : String
	'''

	override protected getOperatorDeclarationWithNameExpectation() '''
		aaa.xtend
		 Foo
		  operator_not(Object) : String
	'''

	override protected getDispatchMethodExpectation() '''
		aaa.xtend
		 Foo
		  _foo(Object) : String
		  _foo(String) : String
		  foo(Object) : String
	'''

	override protected getAnnotationTypeExpectation() '''
		aaa.xtend
		 Foo
		  bar() : int
		  foo() : String
	'''

	override protected getCreateExtensionInfoExpectation() '''
		aaa.xtend
		 Foo
		  foo() : String
		  _createCache_foo : HashMap<ArrayList<?>, String>
		  _init_foo(String) : void
	'''

	override protected getCreateExtensionInfo_dispatchExpectation() '''
		aaa.xtend
		 Foo
		  _foo(Integer) : String
		  _createCache_foo : HashMap<ArrayList<?>, String>
		  _init_foo(String, Integer) : void
		  _foo(String) : String
		  _createCache_foo_1 : HashMap<ArrayList<?>, String>
		  _init_foo_1(String, String) : void
		  foo(Object) : String
	'''

	@Test
	@Ignore("TODO: org.eclipse.xtend.ide.tests.outline.JvmOutlineTests.testActiveAnnotation()")
	def void testActiveAnnotation() {
		// TODO: org.eclipse.xtend.ide.tests.outline.JvmOutlineTests.testActiveAnnotation()
	}

}
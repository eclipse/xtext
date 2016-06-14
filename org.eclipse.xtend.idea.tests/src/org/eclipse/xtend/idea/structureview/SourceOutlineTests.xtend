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
import org.eclipse.xtext.idea.structureview.AlphaSorter
import org.junit.Test

/**
 * @author kosyakov - Initial contribution and API
 */
class SourceOutlineTests extends AbstractOutlineTests {

	override protected getStructureViewComponent(StructureView structureView) {
		(structureView as StructureViewComposite).structureViews.head.structureView as StructureViewComponent
	}

	@Test
	def void testImport() {
		testStructureView('''
			import java.lang.* class Foo {}
		''', '''
			aaa.xtend
			 import declarations
			  java.lang.*
			 Foo
		''')
	}

	@Test
	def void testDispatchMethod_1() {
		testStructureView('''
			class Foo { def dispatch foo(String x) {''} def dispatch foo(Object y) {''} }
		''', '''
			aaa.xtend
			 Foo
			  foo(Object) : String
			   foo(String) : String
			   foo(Object) : String
		''')
	}

	@Test
	def void testDispatchMethod_2() {
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
			  foo(Object) : String
			   foo(String) : String
			   foo(Object) : String
			  bar(Object) : String
			   bar(String) : String
			   bar(Object) : String
		''')
	}

	@Test
	def void testMixedeMethods_Order() {
		testStructureView('''
			class Foo {
				def baz() {null}
				def dispatch foo(String x) {''}
				def dispatch bar(String x) {''}
				def dispatch bar(Object y) {''}
				def dispatch foo(Object y) {''}
				String fooBar
				new() {}
				def static void s() {}
				static String ss
			}
		''', '''
			aaa.xtend
			 Foo
			  baz() : Object
			  foo(Object) : String
			   foo(String) : String
			   foo(Object) : String
			  bar(Object) : String
			   bar(String) : String
			   bar(Object) : String
			  fooBar : String
			  new()
			  s() : void
			  ss : String
		''')
	}

	@Test
	def void testMixmethods_Sorting() {
		testStructureView('''
			package test
			
			import java.lang.*
			
			class Foo {
				def baz() {null}
				def dispatch foo(String x) {''}
				def dispatch bar(String x) {''}
				def dispatch bar(Object y) {''}
				def dispatch foo(Object y) {''}
				String fooBar
				new() {}
				def static void s() {}
				static String ss
			}
		''') [ component |
			component.setActionActive(AlphaSorter.ALPHA_SORTER_ID, true)
			component.assertTreeStructure('''
				aaa.xtend
				 test
				 import declarations
				  java.lang.*
				 Foo
				  ss : String
				  s() : void
				  fooBar : String
				  new()
				  bar(Object) : String
				   bar(Object) : String
				   bar(String) : String
				  foo(Object) : String
				   foo(Object) : String
				   foo(String) : String
				  baz() : Object
			''')
		]
	}

}
/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.structureview

import com.intellij.ide.structureView.StructureView
import com.intellij.ide.structureView.newStructureView.StructureViewComponent
import com.intellij.lang.LanguageStructureViewBuilder
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.util.Disposer
import com.intellij.util.Consumer
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtext.idea.tests.LightToolingTest

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractOutlineTests extends LightToolingTest {

	new() {
		super(XtendFileType.INSTANCE)
	}

	def void testSimpleClass() {
		testStructureView('''
			class Foo {}
		''', '''
			aaa.xtend
			 Foo
		''')
	}

	def void testPackage() {
		testStructureView('''
			package test class Foo {}
		''', '''
			aaa.xtend
			 test
			 Foo
		''')
	}

	def void testTypeParameter() {
		testStructureView('''
			class Foo <T extends Object> {}
		''', '''
			aaa.xtend
			 Foo<T extends Object>
		''')
	}

	def void testTypeParameter1() {
		testStructureView('''
			class Foo <T> {}
		''', typeParameter1Expectation)
	}

	protected def String getTypeParameter1Expectation() '''
		aaa.xtend
		 Foo<T>
	'''

	def void testField() {
		testStructureView('''
			class Foo { String bar }
		''', '''
			aaa.xtend
			 Foo
			  bar : String
		''')
	}

	def void testConstructor() {
		testStructureView('''
			class Foo { new(int foo) {} }
		''', '''
			aaa.xtend
			 Foo
			  new(int)
		''')
	}

	def void testSimpleMethod() {
		testStructureView('''
			class Foo { def foo() {null} }
		''', '''
			aaa.xtend
			 Foo
			  foo() : Object
		''')
	}

	def void testMethodWithParameter() {
		testStructureView('''
			class Foo { def foo(int bar) {null} }
		''', '''
			aaa.xtend
			 Foo
			  foo(int) : Object
		''')
	}

	def void testMethodWithParameters() {
		testStructureView('''
			class Foo { def foo(int bar, java.lang.Object x) {null} }
		''', '''
			aaa.xtend
			 Foo
			  foo(int, Object) : Object
		''')
	}

	def void testMethodWithReturnType() {
		testStructureView('''
			class Foo { def <T> foo() {null} }
		''', '''
			aaa.xtend
			 Foo
			  foo() <T extends Object> : Object
		''')
	}

	def void testMethodWithTypeParameter() {
		testStructureView('''
			class Foo { def <T> foo() {null} }
		''', '''
			aaa.xtend
			 Foo
			  foo() <T extends Object> : Object
		''')
	}

	def void testMethodWithReturnTypeParameter() {
		testStructureView('''
			class Foo { def <T> Foo<T> foo() {null} }
		''', '''
			aaa.xtend
			 Foo
			  foo() <T extends Object> : Foo<T>
		''')
	}

	def void testOperatorDeclarationWithSymbol() {
		testStructureView('''
			class Foo { def java.lang.String !(Object o) {null} }
		''', operatorDeclarationWithSymbolExpectation)
	}

	protected def String getOperatorDeclarationWithSymbolExpectation() '''
		aaa.xtend
		 Foo
		  !(Object) : String (operator_not)
	'''

	def void testOperatorDeclarationWithName() {
		testStructureView('''
			class Foo { def java.lang.String operator_not(Object o) {null} }
		''', operatorDeclarationWithNameExpectation)
	}

	protected def String getOperatorDeclarationWithNameExpectation() '''
		aaa.xtend
		 Foo
		  !(Object) : String (operator_not)
	'''

	def void testDispatchMethod() {
		testStructureView('''
			class Foo { def dispatch foo(Object x) {''} def dispatch foo(String y) {''} }
		''', dispatchMethodExpectation)
	}

	protected def String getDispatchMethodExpectation() '''
		aaa.xtend
		 Foo
		  foo(Object) : String
		   foo(Object) : String
		   foo(String) : String
	'''

	def void testInterface() {
		testStructureView('''
			interface Foo { int bar def String foo() }
		''', '''
			aaa.xtend
			 Foo
			  bar : int
			  foo() : String
		''')
	}

	def void testEnum() {
		testStructureView('''
			enum Foo { BAR, BAZ }
		''', '''
			aaa.xtend
			 Foo
			  BAR
			  BAZ
		''')
	}

	def void testAnnotationType() {
		testStructureView('''
			@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) annotation Foo { int bar String foo = '' }
		''', annotationTypeExpectation)
	}

	protected def String getAnnotationTypeExpectation() '''
		aaa.xtend
		 Foo
		  bar : int
		  foo : String
	'''

	def void testAnnotationTypeNoMembers() {
		testStructureView('''
			@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) annotation Foo { }
		''', '''
			aaa.xtend
			 Foo
		''')
	}

	def void testInterfaceNoMembers() {
		testStructureView('''
			@SuppressWarnings('foo') interface Foo { }
		''', '''
			aaa.xtend
			 Foo
		''')
	}

	def void testCreateExtensionInfo() {
		testStructureView('''
			class Foo { def create 'lalala' foo() {} }
		''', createExtensionInfoExpectation)
	}

	protected def String getCreateExtensionInfoExpectation() '''
		aaa.xtend
		 Foo
		  foo() : String
	'''

	def void testCreateExtensionInfo_dispatch() {
		testStructureView('''
			class Foo {  dispatch def create value : 'bar' foo(Integer it) {}  dispatch def create value : 'foo' foo(String it) {} }
		''', createExtensionInfo_dispatchExpectation)
	}

	protected def String getCreateExtensionInfo_dispatchExpectation() '''
		aaa.xtend
		 Foo
		  foo(Object) : String
		   foo(Integer) : String
		   foo(String) : String
	'''

	def void testNestedTypes() {
		testStructureView('''
			class Foo { int foo static class Bar { def bar() {} interface Baz {} enum FooBar{ X } } }
		''', nestedTypesExpectation)
	}

	protected def String getNestedTypesExpectation() '''
		aaa.xtend
		 Foo
		  foo : int
		  Bar
		   bar() : Object
		   Baz
		   FooBar
		    X
	'''

	def void testAnonymousTypes() {
		testStructureView('''
			class Foo<T extends Object> { def Foo<String> bar() { new Foo<String>() { override bar() { } } } }
		''', '''
			aaa.xtend
			 Foo<T extends Object>
			  bar() : Foo<String>
			   new Foo<String>() {...}
			    bar() : Foo<String>
		''')
	}

	override void testStructureView(Consumer<StructureViewComponent> consumer) {
		val myFile = myFixture.file.virtualFile
		if (!(myFile !== null)) {
			throw new AssertionError("configure first")
		}
		val fileEditor = FileEditorManager.getInstance(project).getSelectedEditor(myFile)
		if (fileEditor === null) {
			throw new AssertionError('''editor not opened for «myFile»''')
		}
		val builder = LanguageStructureViewBuilder.INSTANCE.getStructureViewBuilder(myFixture.file)
		if (builder === null) {
			throw new AssertionError('''no builder for «myFile»''')
		}
		var StructureView view = null
		try {
			view = builder.createStructureView(fileEditor, project)
			val component = view.structureViewComponent
			consumer.consume(component)
		} finally {
			if(view !== null) Disposer.dispose(view)
		}
	}

	protected def StructureViewComponent getStructureViewComponent(StructureView structureView)

}
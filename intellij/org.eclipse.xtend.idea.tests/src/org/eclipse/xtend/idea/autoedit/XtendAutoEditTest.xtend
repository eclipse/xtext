/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtext.idea.tests.AbstractAutoEditTest

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

class XtendAutoEditTest extends AbstractAutoEditTest {

	new() {
		super(XtendFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXtendLibrary
	}

	def void testClassBraces() {
		configureByText('''class Foo {|''')
		newLine
		assertState('''
		class Foo {
			|
		}''')
	}

	def void testMethodParentheses() {
		configureByText('''
			class Foo {
				def bar|
			}
		''')
		myFixture.type("(")
		assertState('''
			class Foo {
				def bar(|)
			}
		''')
	}

	def void testMethodBraces() {
		configureByText('''
			class Foo {
				def bar() {|
			}
		''')
		newLine
		assertState('''
			class Foo {
				def bar() {
					|
				}
			}
		''')
	}

	def void testFeatureCallParentheses() {
		configureByText('''
			class Foo {
				def bar() {
					toString|
				}
			}
		''')
		myFixture.type("(")
		assertState('''
			class Foo {
				def bar() {
					toString(|)
				}
			}
		''')
	}

	def void testArrayBrackets() {
		configureByText('''
			class Foo {
				def bar(int|)
			}
		''')
		myFixture.type("[")
		assertState('''
			class Foo {
				def bar(int[|])
			}
		''')
	}

	def void testGuillemets() {
		configureByText("
			class Foo {
				def bar() {
					'''|'''
				}
			}
		")
		myFixture.type("«")
		assertState("
			class Foo {
				def bar() {
					'''«|»'''
				}
			}
		")
	}

	def void testEnterBetweenMethods_01() {
		configureByText('''
			class Foo {
				def foo() {
				}|
				def bar() {
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
				}
				|
				def bar() {
				}
			}
		''')
	}

	def void testEnterBetweenMethods_02() {
		configureByText('''
			class Foo {
				def foo() {
				}
				|
				def bar() {
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
				}
				
				|
				def bar() {
				}
			}
		''')
	}

	def void testEnterBetweenMethods_03() {
		configureByText('''
			class Foo {
				def foo() {
				}
				//lalala|
				def bar() {
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
				}
				//lalala
				|
				def bar() {
				}
			}
		''')
	}

	def void testEnterBetweenMethods_04() {
		configureByText('''
			class Foo {
				def foo() {
				}
				|//lalala
				def bar() {
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
				}
				
				|//lalala
				def bar() {
				}
			}
		''')
	}
	
	def void test_if_then_01() {
		configureByText('''
			class Foo {
				def foo(int x) {
					if (x == 1)|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						|
				}
			}
		''')
	}
	
	def void test_if_then_02() {
		configureByText('''
			class Foo {
				def foo(int x) {
					if (x == 1) |return true
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					if (x == 1) 
						|return true
				}
			}
		''')
	}
	
	def void test_if_then_03() {
		configureByText('''
			class Foo {
				def foo(int x) {
					if (x == 1) {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					if (x == 1) {
						|
					}
				}
			}
		''')
	}
	
	def void test_if_then_04() {
		configureByText('''
			class Foo {
				def foo(int x) {
					if (x == 1) {|return true}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					if (x == 1) {
						|return true}
				}
			}
		''')
	}
	
	def void test_if_else_01() {
		configureByText('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else
						|
				}
			}
		''')
	}
	
	def void test_if_else_02() {
		configureByText('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else {
						|
					}
				}
			}
		''')
	}
	
	def void test_if_else_03() {
		configureByText('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else |return false
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else 
						|return false
				}
			}
		''')
	}
	
	def void test_if_else_04() {
		configureByText('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else {|return false}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else {
						|return false}
				}
			}
		''')
	}
	
	def void test_switch_default_01() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						default:|
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						default:
							|
					}
				}
			}
		''')
	}
	
	def void test_switch_default_02() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						default|:
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						default
						|:
					}
				}
			}
		''')
	}
	
	def void test_switch_default_03() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						default| :
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						default
						|:
					}
				}
			}
		''')
	}
	
	def void test_switch_default_04() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						default |:
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						default 
						|:
					}
				}
			}
		''')
	}
	
	def void test_switch_default_05() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						default:|return true
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						default:
							|return true
					}
				}
			}
		''')
	}
	
	def void test_switch_case_01() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1:|
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1:
							|
					}
				}
			}
		''')
	}
	
	def void test_switch_case_02() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1:|return true
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1:
							|return true
					}
				}
			}
		''')
	}
	
	def void test_switch_case_03() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1: {|return true}
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1: {
							|return true}
					}
				}
			}
		''')
	}
	
	def void test_switch_case_04() {
		configureByText('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1: {|}
					}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1: {
							|
						}
					}
				}
			}
		''')
	}
	
	def void test_for_01() {
		configureByText('''
			class Foo {
				def foo(java.util.List<String> values) {
					for (value : values)|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(java.util.List<String> values) {
					for (value : values)
						|
				}
			}
		''')
	}
	
	def void test_for_02() {
		configureByText('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for (value : values)|result += value.length
					result
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for (value : values)
						|result += value.length
					result
				}
			}
		''')
	}
	
	def void test_for_03() {
		configureByText('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for (value : values) {|result += value.length}
					result
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for (value : values) {
						|result += value.length}
					result
				}
			}
		''')
	}
	
	def void test_basic_for_01() {
		configureByText('''
			class Foo {
				def foo() {
					for (;;)|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					for (;;)
						|
				}
			}
		''')
	}
	
	def void test_basic_for_02() {
		configureByText('''
			class Foo {
				def foo() {
					for (var i = 0;;) |i++
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					for (var i = 0;;) 
						|i++
				}
			}
		''')
	}
	
	def void test_basic_for_03() {
		configureByText('''
			class Foo {
				def foo() {
					for (var i = 0;;) {|i++}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					for (var i = 0;;) {
						|i++}
				}
			}
		''')
	}
	
	def void test_while_01() {
		configureByText('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10)|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10)
						|
				}
			}
		''')
	}
	
	def void test_while_02() {
		configureByText('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10)|i++
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10)
						|i++
				}
			}
		''')
	}
	
	def void test_do_while_01() {
		configureByText('''
			class Foo {
				def foo() {
					var i = 0
					do|
					while (i < 10)
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 0
					do
						|
					while (i < 10)
				}
			}
		''')
	}
	
	def void test_do_while_02() {
		configureByText('''
			class Foo {
				def foo() {
					var i = 0
					do |i++
					while (i < 10)
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 0
					do 
						|i++
					while (i < 10)
				}
			}
		''')
	}
	
	def void test_do_while_03() {
		configureByText('''
			class Foo {
				def foo() {
					var i = 0
					do {|i++}
					while (i < 10)
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 0
					do {
						|i++}
					while (i < 10)
				}
			}
		''')
	}
	
	def void test_var_declaration_01() {
		configureByText('''
			class Foo {
				def foo() {
					var i = |
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 
						|
				}
			}
		''')
	}
	
	def void test_var_declaration_02() {
		configureByText('''
			class Foo {
				def foo() {
					var i = {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = {
						|
					}
				}
			}
		''')
	}
	
	def void test_var_declaration_03() {
		configureByText('''
			class Foo {
				def foo() {
					var i = |1
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 
						|1
				}
			}
		''')
	}
	
	def void test_var_declaration_04() {
		configureByText('''
			class Foo {
				def foo() {
					var i = {|1}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = {
						|1}
				}
			}
		''')
	}
	
	def void test_throw_01() {
		configureByText('''
			class Foo {
				def foo() {
					throw |
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					throw 
						|
				}
			}
		''')
	}
	
	def void test_throw_02() {
		configureByText('''
			class Foo {
				def foo() {
					throw {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					throw {
						|
					}
				}
			}
		''')
	}
	
	def void test_throw_03() {
		configureByText('''
			class Foo {
				def foo() {
					throw |new java.lang.IllegalStateException
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					throw 
						|new java.lang.IllegalStateException
				}
			}
		''')
	}
	
	def void test_throw_04() {
		configureByText('''
			class Foo {
				def foo() {
					throw {|new java.lang.IllegalStateException}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					throw {
						|new java.lang.IllegalStateException}
				}
			}
		''')
	}
	
	def void test_return_01() {
		configureByText('''
			class Foo {
				def foo() {
					return |
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					return 
					|
				}
			}
		''')
	}
	
	def void test_return_02() {
		configureByText('''
			class Foo {
				def foo() {
					return {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					return {
						|
					}
				}
			}
		''')
	}
	
	def void test_return_03() {
		configureByText('''
			class Foo {
				def foo() {
					return |1
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					return 
						|1
				}
			}
		''')
	}
	
	def void test_return_04() {
		configureByText('''
			class Foo {
				def foo() {
					return {|1}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					return {
						|1}
				}
			}
		''')
	}
	
	def void test_try_01() {
		configureByText('''
			class Foo {
				def foo() {
					try|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try
						|
				}
			}
		''')
	}
	
	def void test_try_02() {
		configureByText('''
			class Foo {
				def foo() {
					try {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try {
						|
					}
				}
			}
		''')
	}
	
	def void test_try_03() {
		configureByText('''
			class Foo {
				def foo() {
					try |return 1
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try 
						|return 1
				}
			}
		''')
	}
	
	def void test_try_04() {
		configureByText('''
			class Foo {
				def foo() {
					try {|return 1}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try {
						|return 1}
				}
			}
		''')
	}
	
	def void test_catch_01() {
		configureByText('''
			class Foo {
				def foo() {
					try
						return 1
					catch (Exception e)|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try
						return 1
					catch (Exception e)
						|
				}
			}
		''')
	}
	
	def void test_catch_02() {
		configureByText('''
			class Foo {
				def foo() {
					try
						return 1
					catch (Exception e) {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try
						return 1
					catch (Exception e) {
						|
					}
				}
			}
		''')
	}
	
	def void test_catch_03() {
		configureByText('''
			class Foo {
				def foo() {
					try
						return 1
					catch (Exception e)|return 2
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try
						return 1
					catch (Exception e)
						|return 2
				}
			}
		''')
	}
	
	def void test_catch_04() {
		configureByText('''
			class Foo {
				def foo() {
					try
						return 1
					catch (Exception e) {|return 2}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try
						return 1
					catch (Exception e) {
						|return 2}
				}
			}
		''')
	}
	
	def void test_finally_01() {
		configureByText('''
			class Foo {
				def foo() {
					try
						return 1
					finally|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try
						return 1
					finally
						|
				}
			}
		''')
	}
	
	def void test_finally_02() {
		configureByText('''
			class Foo {
				def foo() {
					try
						return 1
					finally {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					try
						return 1
					finally {
						|
					}
				}
			}
		''')
	}
	
	def void test_finally_03() {
		configureByText('''
			class Foo {
				def foo() {
					var i = 0
					try
						return 1
					finally |i = 1
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 0
					try
						return 1
					finally 
						|i = 1
				}
			}
		''')
	}
	
	def void test_finally_04() {
		configureByText('''
			class Foo {
				def foo() {
					var i = 0
					try
						return 1
					finally {|i = 1}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					var i = 0
					try
						return 1
					finally {
						|i = 1}
				}
			}
		''')
	}
	
	def void test_synchronized_01() {
		configureByText('''
			class Foo {
				def foo() {
					synchronized(this)|
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					synchronized(this)
						|
				}
			}
		''')
	}
	
	def void test_synchronized_02() {
		configureByText('''
			class Foo {
				def foo() {
					synchronized(this) {|}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					synchronized(this) {
						|
					}
				}
			}
		''')
	}
	
	def void test_synchronized_03() {
		configureByText('''
			class Foo {
				def foo() {
					synchronized(this) |return true
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					synchronized(this) 
						|return true
				}
			}
		''')
	}
	
	def void test_synchronized_04() {
		configureByText('''
			class Foo {
				def foo() {
					synchronized(this) {|return true}
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
					synchronized(this) {
						|return true}
				}
			}
		''')
	}

}
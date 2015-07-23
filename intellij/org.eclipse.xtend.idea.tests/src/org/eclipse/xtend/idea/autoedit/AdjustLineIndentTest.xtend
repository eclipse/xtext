/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleManager
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtext.idea.tests.LightToolingTest

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class AdjustLineIndentTest extends LightToolingTest {

	new() {
		super(XtendFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXtendLibrary
	}

	def void testXIfExpression_then_01() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					return false
				}
			}
		''')
	}

	def void testXIfExpression_then_02() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1) {
			return true
			}
			return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1) {
						return true
					}
					return false
				}
			}
		''')
	}

	def void testXIfExpression_then_03() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1) return true
			return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1) return true
					return false
				}
			}
		''')
	}

	def void testXIfExpression_then_04() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1) { return true }
			return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1) { return true }
					return false
				}
			}
		''')
	}

	def void testXIfExpression_else_01() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			else
			return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else
						return false
				}
			}
		''')
	}

	def void testXIfExpression_else_02() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			else {
			return false
			}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else {
						return false
					}
				}
			}
		''')
	}

	def void testXIfExpression_else_03() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			else return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else return false
				}
			}
		''')
	}

	def void testXIfExpression_else_04() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			else { return false }
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else { return false }
				}
			}
		''')
	}

	def void testXIfExpression_else_if_01() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			else if (x == 2)
			return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else if (x == 2)
						return false
				}
			}
		''')
	}

	def void testXIfExpression_else_if_02() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			else if (x == 2) {
			return false
			}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else if (x == 2) {
						return false
					}
				}
			}
		''')
	}

	def void testXIfExpression_else_if_03() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			else if (x == 2) return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else if (x == 2) return false
				}
			}
		''')
	}

	def void testXIfExpression_else_if_04() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1)
			return true
			else if (x == 2) { return false }
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1)
						return true
					else if (x == 2) { return false }
				}
			}
		''')
	}

	def void testXIfExpression_if_01() {
		'''
			class Foo {
				def foo(int x) {
			if (x == 1
			)
			return true
			return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (x == 1
					)
						return true
					return false
				}
			}
		''')
	}

	def void testXIfExpression_if_02() {
		'''
			class Foo {
				def foo(int x) {
			if (
			x == 1
			)
			return true
			return false
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					if (
							x == 1
					)
						return true
					return false
				}
			}
		''')
	}

	def void testXOrExpression_01() {
		'''
			class Foo {
				def foo(int x) {
					x == 1 || x == 2 || x == 3 || x == 4
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					x == 1 || x == 2 || x == 3 || x == 4
				}
			}
		''')
	}

	def void testXOrExpression_02() {
		'''
			class Foo {
				def foo(int x) {
					x == 1 ||
					x == 2 ||
					x == 3 ||
					x == 4
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					x == 1 ||
							x == 2 ||
							x == 3 ||
							x == 4
				}
			}
		''')
	}

	def void testXOrExpression_03() {
		'''
			class Foo {
				def foo(int x) {
					x == 1
					|| x == 2
					|| x == 3
					|| x == 4
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					x == 1
							|| x == 2
							|| x == 3
							|| x == 4
				}
			}
		''')
	}

	def void testXOrExpression_04() {
		'''
			class Foo {
				def foo(int x) {
					x == 1
					||
					x == 2
					||
					x == 3
					||
					x == 4
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					x == 1
							||
							x == 2
							||
							x == 3
							||
							x == 4
				}
			}
		''')
	}

	def void testXAndExpression_01() {
		'''
			class Foo {
				def foo(int x) {
					x == 1 && x == 2 && x == 3 && x == 4
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					x == 1 && x == 2 && x == 3 && x == 4
				}
			}
		''')
	}

	def void testXAndExpression_02() {
		'''
			class Foo {
				def foo(int x) {
					x == 1 &&
					x == 2 &&
					x == 3 &&
					x == 4
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					x == 1 &&
							x == 2 &&
							x == 3 &&
							x == 4
				}
			}
		''')
	}

	def void testXAndExpression_03() {
		'''
			class Foo {
				def foo(int x) {
					x == 1
					&& x == 2
					&& x == 3
					&& x == 4
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					x == 1
							&& x == 2
							&& x == 3
							&& x == 4
				}
			}
		''')
	}

	def void testXAndExpression_04() {
		'''
			class Foo {
				def foo(int x) {
					x == 1
					&&
					x == 2
					&&
					x == 3
					&&
					x == 4
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					x == 1
							&&
							x == 2
							&&
							x == 3
							&&
							x == 4
				}
			}
		''')
	}

	def void testXEqualityExpression_01() {
		'''
			class Foo {
				def foo(int a, int b, int c, int d) {
					a == b == c == d
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c, int d) {
					a == b == c == d
				}
			}
		''')
	}

	def void testXEqualityExpression_02() {
		'''
			class Foo {
				def foo(int a, int b, int c, int d) {
					a
					==
					b
					==
					c
					==
					d
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c, int d) {
					a
							==
							b
							==
							c
							==
							d
				}
			}
		''')
	}

	def void testXEqualityExpression_03() {
		'''
			class Foo {
				def foo(int a, int b, int c, int d) {
					a
					== b
					== c
					== d
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c, int d) {
					a
							== b
							== c
							== d
				}
			}
		''')
	}

	def void testXInstanceOfExpression_01() {
		'''
			class Foo {
				def foo(Object object) {
					object instanceof Foo
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object instanceof Foo
				}
			}
		''')
	}

	def void testXInstanceOfExpression_02() {
		'''
			class Foo {
				def foo(Object object) {
					object
					instanceof
					Foo
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object
							instanceof
							Foo
				}
			}
		''')
	}

	def void testXInstanceOfExpression_03() {
		'''
			class Foo {
				def foo(Object object) {
					object
					instanceof Foo
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object
							instanceof Foo
				}
			}
		''')
	}

	def void testXRelationalExpression_01() {
		'''
			class Foo {
				def foo(int a, int b) {
					a > b
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b) {
					a > b
				}
			}
		''')
	}

	def void testXRelationalExpression_02() {
		'''
			class Foo {
				def foo(int a, int b) {
					a
					>
					b
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b) {
					a
							>
							b
				}
			}
		''')
	}

	def void testXRelationalExpression_03() {
		'''
			class Foo {
				def foo(int a, int b) {
					a
					> b
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b) {
					a
							> b
				}
			}
		''')
	}

	def void testXOtherOperatorExpression_01() {
		'''
			class Foo {
				def foo(Object object) {
					object.toString ?: 'null'
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object.toString ?: 'null'
				}
			}
		''')
	}

	def void testXOtherOperatorExpression_02() {
		'''
			class Foo {
				def foo(Object object) {
					object.toString
					?:
					'null'
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object.toString
							?:
							'null'
				}
			}
		''')
	}

	def void testXOtherOperatorExpression_03() {
		'''
			class Foo {
				def foo(Object object) {
					object.toString
					?: 'null'
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object.toString
							?: 'null'
				}
			}
		''')
	}

	def void testXAdditiveExpression_01() {
		'''
			class Foo {
				def foo(int a, int b, int c) {
					a + b + c
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c) {
					a + b + c
				}
			}
		''')
	}

	def void testXAdditiveExpression_02() {
		'''
			class Foo {
				def foo(int a, int b, int c) {
					a
					+
					b
					+
					c
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c) {
					a
							+
							b
							+
							c
				}
			}
		''')
	}

	def void testXAdditiveExpression_03() {
		'''
			class Foo {
				def foo(int a, int b, int c) {
					a
					+ b
					+ c
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c) {
					a
							+ b
							+ c
				}
			}
		''')
	}

	def void testXMultiplicativeExpression_01() {
		'''
			class Foo {
				def foo(int a, int b, int c) {
					a * b * c
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c) {
					a * b * c
				}
			}
		''')
	}

	def void testXMultiplicativeExpression_02() {
		'''
			class Foo {
				def foo(int a, int b, int c) {
					a
					*
					b
					*
					c
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c) {
					a
							*
							b
							*
							c
				}
			}
		''')
	}

	def void testXMultiplicativeExpression_03() {
		'''
			class Foo {
				def foo(int a, int b, int c) {
					a
					* b
					* c
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a, int b, int c) {
					a
							* b
							* c
				}
			}
		''')
	}

	def void testXUnaryOperation_01() {
		'''
			class Foo {
				def foo(int a) {
					-a
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a) {
					-a
				}
			}
		''')
	}

	def void testXUnaryOperation_02() {
		'''
			class Foo {
				def foo(int a) {
					-
					a
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int a) {
					-
							a
				}
			}
		''')
	}

	def void testXCastedExpression_01() {
		'''
			class Foo {
				def foo(Object object) {
					object as Foo
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object as Foo
				}
			}
		''')
	}

	def void testXCastedExpression_02() {
		'''
			class Foo {
				def foo(Object object) {
					object
					as
					Foo
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object
							as
							Foo
				}
			}
		''')
	}

	def void testXCastedExpression_03() {
		'''
			class Foo {
				def foo(Object object) {
					object
					as Foo
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					object
							as Foo
				}
			}
		''')
	}

	def void testXPostfixOperation_01() {
		'''
			class Foo {
				int a
				def foo() {
					a++
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					a++
				}
			}
		''')
	}

	def void testXPostfixOperation_02() {
		'''
			class Foo {
				int a
				def foo() {
					a
					++
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					a
							++
				}
			}
		''')
	}

	def void testXAssignment_01() {
		'''
			class Foo {
				int a
				def foo() {
					a = 3
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					a = 3
				}
			}
		''')
	}

	def void testXAssignment_02() {
		'''
			class Foo {
				int a
				def foo() {
					a
					=
					3
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					a
							=
							3
				}
			}
		''')
	}

	def void testXAssignment_03() {
		'''
			class Foo {
				int a
				def foo() {
					this.a = 3
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					this.a = 3
				}
			}
		''')
	}

	def void testXAssignment_04() {
		'''
			class Foo {
				int a
				def foo() {
					this.a
					=
					3
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					this.a
							=
							3
				}
			}
		''')
	}

	def void testXAssignment_05() {
		'''
			class Foo {
				int a
				def foo() {
					a += 3
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					a += 3
				}
			}
		''')
	}

	def void testXAssignment_06() {
		'''
			class Foo {
				int a
				def foo() {
					a
					+=
					3
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					a
							+=
							3
				}
			}
		''')
	}

	def void testXMemberFeatureCall_01() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.head
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.head
				}
			}
		''')
	}

	def void testXMemberFeatureCall_02() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					head
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					head
				}
			}
		''')
	}

	def void testXMemberFeatureCall_03() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.get(0)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.get(0)
				}
			}
		''')
	}

	def void testXMemberFeatureCall_04() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.get(
					0
					)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.get(
							0
					)
				}
			}
		''')
	}

	def void testXMemberFeatureCall_05() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					get
					(
					0
					)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					get
					(
							0
					)
				}
			}
		''')
	}

	def void testXMemberFeatureCall_06() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					get(
					0
					)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					get(
							0
					)
				}
			}
		''')
	}

	def void testXClosure_01() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map[value|value.length]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map[value|value.length]
				}
			}
		''')
	}

	def void testXClosure_02() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map[value|
					value.length
					]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map[value|
						value.length
					]
				}
			}
		''')
	}

	def void testXClosure_03() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map
					[
					value
					|
					value.length
					]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map
					[
						value
						|
						value.length
					]
				}
			}
		''')
	}

	def void testXClosure_04() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map[value|
					value.length
					]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map[value|
						value.length
					]
				}
			}
		''')
	}

	def void testXClosure_05() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map[length]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map[length]
				}
			}
		''')
	}

	def void testXClosure_06() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map[
					length
					]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map[
						length
					]
				}
			}
		''')
	}

	def void testXClosure_07() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map
					[
					length
					]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map
					[
						length
					]
				}
			}
		''')
	}

	def void testXClosure_08() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map[
					length
					]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map[
						length
					]
				}
			}
		''')
	}

	def void testXShortClosure_01() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map(value|value.length)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map(value|value.length)
				}
			}
		''')
	}

	def void testXShortClosure_02() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map(value|
					value.length
					)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values.map(value|
							value.length
					)
				}
			}
		''')
	}

	def void testXShortClosure_03() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map
					(
					value
					|
					value.length
					)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map
					(
							value
									|
									value.length
					)
				}
			}
		''')
	}

	def void testXShortClosure_04() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map(value|
					value.length
					)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					values
					.
					map(value|
							value.length
					)
				}
			}
		''')
	}

	def void testXSetLiteral_01() {
		'''
			class Foo {
				def foo() {
					# {1, 2, 3, 4}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					# {1, 2, 3, 4}
				}
			}
		''')
	}

	def void testXSetLiteral_02() {
		'''
			class Foo {
				def foo() {
					#
					{
					1 + 2
					,
					3 + 4
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					#
					{
						1 + 2
						,
						3 + 4
					}
				}
			}
		''')
	}

	def void testXListLiteral_01() {
		'''
			class Foo {
				def foo() {
					# [1, 2, 3, 4]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					# [1, 2, 3, 4]
				}
			}
		''')
	}

	def void testXListLiteral_02() {
		'''
			class Foo {
				def foo() {
					#
					[
					1 + 2
					,
					3 + 4
					]
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					#
					[
						1 + 2
						,
						3 + 4
					]
				}
			}
		''')
	}

	def void testXSwitchExpression_default_01() {
		'''
			class Foo {
				def foo(Object object) {
					switch object {
						default:
			return true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					switch object {
						default:
							return true
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_default_02() {
		'''
			class Foo {
				def foo(Object object) {
					switch object {
			default: return true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					switch object {
						default: return true
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_default_03() {
		'''
			class Foo {
				def foo(Object object) {
					switch object {
						default: {
			return true
			}
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					switch object {
						default: {
							return true
						}
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_default_04() {
		'''
			class Foo {
				def foo(Object object) {
					switch object {
			default: { return true }
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(Object object) {
					switch object {
						default: { return true }
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_case_then_01() {
		'''
			class Foo {
				def foo(int x) {
					switch x {
						case 1:
			return true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1:
							return true
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_case_then_02() {
		'''
			class Foo {
				def foo(int x) {
					switch x {
			case 1: return true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1: return true
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_case_then_03() {
		'''
			class Foo {
				def foo(int x) {
					switch x {
						case 1: {
			return true
			}
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1: {
							return true
						}
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_case_then_04() {
		'''
			class Foo {
				def foo(int x) {
					switch x {
			case 1: { return true }
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					switch x {
						case 1: { return true }
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_switch_01() {
		'''
			class Foo {
				def foo(int x) {
					switch
					x
					{
					default: return true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					switch
					x
					{
						default: return true
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_switch_02() {
		'''
			class Foo {
				def foo(int x) {
					switch
					(
					x
					)
					{
					default: return true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					switch
					(
							x
					)
					{
						default: return true
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_switch_03() {
		'''
			class Foo {
				def foo(int x) {
					switch
					(
					{
					x
					}
					)
					{
					default: return true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					switch
					(
							{
								x
							}
					)
					{
						default: return true
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_switch_04() {
		'''
			class Foo {
				def foo(int x) {
					switch
					{
					x
					}
					{
					default: return true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(int x) {
					switch
					{
						x
					}
					{
						default: return true
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_declareParam_01() {
		'''
			class Foo {
				def foo() {
					switch
					x
					:
					1
					{
					default: return x + 2
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					switch
					x
					:
					1
					{
						default: return x + 2
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_declaredParam_02() {
		'''
			class Foo {
				def foo() {
					switch
					(
					x
					:
					1
					)
					{
					default: return x + 2
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					switch
					(
							x
							:
							1
					)
					{
						default: return x + 2
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_declareParam_03() {
		'''
			class Foo {
				def foo() {
					switch
					(
					x
					:
					{
					1
					}
					)
					{
					default: return x + 2
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					switch
					(
							x
							:
							{
								1
							}
					)
					{
						default: return x + 2
					}
				}
			}
		''')
	}

	def void testXSwitchExpression_declaredParam_04() {
		'''
			class Foo {
				def foo() {
					switch
					x
					:
					{
					1
					}
					{
					default: return x + 2
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					switch
					x
					:
					{
						1
					}
					{
						default: return x + 2
					}
				}
			}
		''')
	}

	def void testXForLoopExpression_00() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for
					(
					String
					value
					:
					values
					) {
					result
					+=
					value.length
					}
					result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for
					(
							String
							value
							:
							values
					) {
						result
								+=
								value.length
					}
					result
				}
			}
		''')
	}

	def void testXForLoopExpression_01() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for
					(
					String
					value
					:
					values
					)
					{
					result
					+=
					value.length
					}
					result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for
					(
							String
							value
							:
							values
					)
					{
						result
								+=
								value.length
					}
					result
				}
			}
		''')
	}

	def void testXForLoopExpression_02() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for (value : values) {
					result += value.length
					}
					result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for (value : values) {
						result += value.length
					}
					result
				}
			}
		''')
	}

	def void testXForLoopExpression_03() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for
					(
					String
					value
					:
					values
					)
					result
					+=
					value.length
					result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for
					(
							String
							value
							:
							values
					)
						result
								+=
								value.length
					result
				}
			}
		''')
	}

	def void testXForLoopExpression_04() {
		'''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for (value : values)
					result += value.length
					result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo(java.util.List<String> values) {
					var result = 0
					for (value : values)
						result += value.length
					result
				}
			}
		''')
	}

	def void testXBasicForLoopExpression_01() {
		'''
			class Foo {
				def foo() {
				var result = 0
				for (var i = 1; i < 10; i++) {
				result += i
				}
				result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var result = 0
					for (var i = 1; i < 10; i++) {
						result += i
					}
					result
				}
			}
		''')
	}

	def void testXBasicForLoopExpression_02() {
		'''
			class Foo {
				def foo() {
				var result = 0
				for (var i = 1; i < 10; i++)
				result += i
				result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var result = 0
					for (var i = 1; i < 10; i++)
						result += i
					result
				}
			}
		''')
	}

	def void testXBasicForLoopExpression_03() {
		'''
			class Foo {
				def foo() {
				var result = 0
				for (
				var i = 1;
				i < 10;
				i++
				) {
				result += i
				}
				result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var result = 0
					for (
							var i = 1;
							i < 10;
							i++
					) {
						result += i
					}
					result
				}
			}
		''')
	}

	def void testXBasicForLoopExpression_04() {
		'''
			class Foo {
				def foo() {
				var result = 0
				for (
				var i = 1;
				i < 10;
				i++
				)
				result += i
				result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var result = 0
					for (
							var i = 1;
							i < 10;
							i++
					)
						result += i
					result
				}
			}
		''')
	}

	def void testXBasicForLoopExpression_05() {
		'''
			class Foo {
				def foo() {
				var result = 0
				for (
				var i = 1;
				i < 10;
				i++
				)
				{
				result += i
				}
				result
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var result = 0
					for (
							var i = 1;
							i < 10;
							i++
					)
					{
						result += i
					}
					result
				}
			}
		''')
	}

	def void testXWhileExpression_01() {
		'''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10)
					i++
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10)
						i++
				}
			}
		''')
	}

	def void testXWhileExpression_02() {
		'''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10) i++
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10) i++
				}
			}
		''')
	}

	def void testXWhileExpression_03() {
		'''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10) { i++ }
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10) { i++ }
				}
			}
		''')
	}

	def void testXWhileExpression_04() {
		'''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10) {
					i++
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10) {
						i++
					}
				}
			}
		''')
	}

	def void testXWhileExpression_05() {
		'''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10)
					{
					i++
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					while (i < 10)
					{
						i++
					}
				}
			}
		''')
	}

	def void testXDoWhileExpression_01() {
		'''
			class Foo {
				def foo() {
					var i = 0
					do
					i++
					while (i < 10)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					do
						i++
					while (i < 10)
				}
			}
		''')
	}

	def void testXDoWhileExpression_02() {
		'''
			class Foo {
				def foo() {
					var i = 0
					do i++
					while (i < 10)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					do i++
					while (i < 10)
				}
			}
		''')
	}

	def void testXDoWhileExpression_03() {
		'''
			class Foo {
				def foo() {
					var i = 0
					do { i++ }
					while (i < 10)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					do { i++ }
					while (i < 10)
				}
			}
		''')
	}

	def void testXDoWhileExpression_04() {
		'''
			class Foo {
				def foo() {
					var i = 0
					do {
					i++
					} while (i < 10)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					do {
						i++
					} while (i < 10)
				}
			}
		''')
	}

	def void testXDoWhileExpression_05() {
		'''
			class Foo {
				def foo() {
					var i = 0
					do
					{
					i++
					} while (i < 10)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					do
					{
						i++
					} while (i < 10)
				}
			}
		''')
	}

	def void testXDoWhileExpression_06() {
		'''
			class Foo {
				def foo() {
					var i = 0
					do
					{
					i++
					}
					while (i < 10)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var i = 0
					do
					{
						i++
					}
					while (i < 10)
				}
			}
		''')
	}

	def void testXVariableDeclaration_01() {
		'''
			class Foo {
				def foo() {
					val i = 1
					return i
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					val i = 1
					return i
				}
			}
		''')
	}

	def void testXVariableDeclaration_02() {
		'''
			class Foo {
				def foo() {
					val i =
					1
					return i
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					val i =
						1
					return i
				}
			}
		''')
	}

	def void testXVariableDeclaration_03() {
		'''
			class Foo {
				def foo() {
					val i = {
					1
					}
					return i
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					val i = {
						1
					}
					return i
				}
			}
		''')
	}

	def void testXVariableDeclaration_04() {
		'''
			class Foo {
				def foo() {
					val i =
					{
					1
					}
					return i
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					val i =
					{
						1
					}
					return i
				}
			}
		''')
	}

	def void testXFeatureCall_01() {
		'''
			class Foo {
				def foo() {
					values.head
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values.head
				}
			
				def java.util.List<String> values() { null }
			}
		''')
	}

	def void testXFeatureCall_02() {
		'''
			class Foo {
				def foo() {
					values
					.
					head
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values
					.
					head
				}
			
				def java.util.List<String> values() { null }
			}
		''')
	}

	def void testXFeatureCall_03() {
		'''
			class Foo {
				def foo() {
					values.get(0)
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values.get(0)
				}
			
				def java.util.List<String> values() { null }
			}
		''')
	}

	def void testXMFeatureCall_04() {
		'''
			class Foo {
				def foo() {
					values.get(
					0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values.get(
							0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		''')
	}

	def void testXFeatureCall_05() {
		'''
			class Foo {
				def foo() {
					values
					.
					get
					(
					0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values
					.
					get
					(
							0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		''')
	}

	def void testXFeatureCall_06() {
		'''
			class Foo {
				def foo() {
					values
					.
					get(
					0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values
					.
					get(
							0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		''')
	}

	def void testXConstructorCall_01() {
		'''
			class Foo {
				def foo() {
					new
					Foo
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new
					Foo
				}
			}
		''')
	}

	def void testXConstructorCall_02() {
		'''
			class Foo {
				def foo() {
					new Foo(0)
				}
			
				new(int x) {}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new Foo(0)
				}
			
				new(int x) {}
			}
		''')
	}

	def void testXConstructorCall_03() {
		'''
			class Foo {
				def foo() {
					new Foo(
					0
					)
				}
			
				new(int x) {}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new Foo(
							0
					)
				}
			
				new(int x) {}
			}
		''')
	}

	def void testXConstructorCall_04() {
		'''
			class Foo {
				def foo() {
					new
					Foo
					(
					0
					)
				}
			
				new(int x) {}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new
					Foo
					(
							0
					)
				}
			
				new(int x) {}
			}
		''')
	}

	def void testXConstructorCall_05() {
		'''
			class Foo {
				def foo() {
					new
					Foo(
					0
					)
				}
			
				new(int x) {}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new
					Foo(
							0
					)
				}
			
				new(int x) {}
			}
		''')
	}
	
	def void testXTypeLiteral_01() {
		'''
			class Foo {
				def foo() {
					typeof(Foo)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					typeof(Foo)
				}
			}
		''')
	}
	
	def void testXTypeLiteral_02() {
		'''
			class Foo {
				def foo() {
					typeof
					(Foo)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					typeof
					(Foo)
				}
			}
		''')
	}
	
	def void testXTypeLiteral_03() {
		'''
			class Foo {
				def foo() {
					typeof
					(
					Foo)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					typeof
					(
							Foo)
				}
			}
		''')
	}
	
	def void testXTypeLiteral_04() {
		'''
			class Foo {
				def foo() {
					typeof
					(
					Foo
					)
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					typeof
					(
							Foo
					)
				}
			}
		''')
	}
	
	def void testXThrowExpression_01() {
		'''
			class Foo {
				def foo() {
					throw new java.lang.IllegalStateException
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					throw new java.lang.IllegalStateException
				}
			}
		''')
	}
	
	def void testXThrowExpression_02() {
		'''
			class Foo {
				def foo() {
					throw
					new java.lang.IllegalStateException
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					throw
						new java.lang.IllegalStateException
				}
			}
		''')
	}
	
	def void testXThrowExpression_03() {
		'''
			class Foo {
				def foo() {
					throw {
					new java.lang.IllegalStateException
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					throw {
						new java.lang.IllegalStateException
					}
				}
			}
		''')
	}
	
	def void testXThrowExpression_04() {
		'''
			class Foo {
				def foo() {
					throw
					{
					new java.lang.IllegalStateException
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					throw
					{
						new java.lang.IllegalStateException
					}
				}
			}
		''')
	}
	
	def void testXReturnExpression_01() {
		'''
			class Foo {
				def foo() {
					return 1
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					return 1
				}
			}
		''')
	}
	
	def void testXReturnExpression_02() {
		'''
			class Foo {
				def foo() {
					return
					1
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					return
						1
				}
			}
		''')
	}
	
	def void testXReturnExpression_03() {
		'''
			class Foo {
				def foo() {
					return {
					1
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					return {
						1
					}
				}
			}
		''')
	}
	
	def void testXReturnExpression_04() {
		'''
			class Foo {
				def foo() {
					return
					{
					1
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					return
					{
						1
					}
				}
			}
		''')
	}
	
	def void testXTryCatchFinallyExpression_01() {
		'''
			class Foo {
				def foo() {
					var b = false
					try return 1
					catch (java.lang.IllegalStateException e) return 2
					catch (java.lang.Exception e) return 3
					finally b = true
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var b = false
					try return 1
					catch (java.lang.IllegalStateException e) return 2
					catch (java.lang.Exception e) return 3
					finally b = true
				}
			}
		''')
	}
	
	def void testXTryCatchFinallyExpression_02() {
		'''
			class Foo {
				def foo() {
					var b = false
					try 
					return 1
					catch (java.lang.IllegalStateException e)
					return 2
					catch (java.lang.Exception e)
					return 3
					finally
					b = true
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var b = false
					try
						return 1
					catch (java.lang.IllegalStateException e)
						return 2
					catch (java.lang.Exception e)
						return 3
					finally
						b = true
				}
			}
		''')
	}
	
	def void testXTryCatchFinallyExpression_03() {
		'''
			class Foo {
				def foo() {
					var b = false
					try {
					return 1
					} catch (java.lang.IllegalStateException e) {
					return 2
					} catch (java.lang.Exception e) {
					return 3
					} finally {
					b = true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var b = false
					try {
						return 1
					} catch (java.lang.IllegalStateException e) {
						return 2
					} catch (java.lang.Exception e) {
						return 3
					} finally {
						b = true
					}
				}
			}
		''')
	}
	
	def void testXTryCatchFinallyExpression_04() {
		'''
			class Foo {
				def foo() {
					var b = false
					try
					{
					return 1
					}
					catch (java.lang.IllegalStateException e)
					{
					return 2
					}
					catch (java.lang.Exception e)
					{
					return 3
					}
					finally
					{
					b = true
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					var b = false
					try
					{
						return 1
					}
					catch (java.lang.IllegalStateException e)
					{
						return 2
					}
					catch (java.lang.Exception e)
					{
						return 3
					}
					finally
					{
						b = true
					}
				}
			}
		''')
	}
	
	def void testXSynchronizedExpression_01() {
		'''
			class Foo {
				def foo() {
					synchronized (this) return 1
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					synchronized (this) return 1
				}
			}
		''')
	}
	
	def void testXSynchronizedExpression_02() {
		'''
			class Foo {
				def foo() {
					synchronized (this)
					return 1
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					synchronized (this)
						return 1
				}
			}
		''')
	}
	
	def void testXSynchronizedExpression_03() {
		'''
			class Foo {
				def foo() {
					synchronized (this) {
					return 1
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					synchronized (this) {
						return 1
					}
				}
			}
		''')
	}
	
	def void testXSynchronizedExpression_04() {
		'''
			class Foo {
				def foo() {
					synchronized (this)
					{
					return 1
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					synchronized (this)
					{
						return 1
					}
				}
			}
		''')
	}
	
	def void testXSynchronizedExpression_05() {
		'''
			class Foo {
				def foo() {
					synchronized (
					this)
					{
					return 1
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					synchronized (
							this)
					{
						return 1
					}
				}
			}
		''')
	}
	
	def void testXSynchronizedExpression_06() {
		'''
			class Foo {
				def foo() {
					synchronized
					(
					this
					)
					{
					return 1
					}
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					synchronized
					(
							this
					)
					{
						return 1
					}
				}
			}
		''')
	}

	protected def void assertAdjustLineIndent(CharSequence model, String expectedAdjustedModel) {
		val file = configureByText(model.toString)
		myFixture.checkHighlighting
		WriteCommandAction.runWriteCommandAction(project, file.adjustLineIndent)
		assertEquals(dumpFormattingModel, expectedAdjustedModel, myFixture.editor.document.text)
	}

	protected def Runnable adjustLineIndent(PsiFile file) {
		[
			CodeStyleManager.getInstance(project).adjustLineIndent(file, file.textRange)
		]
	}

}
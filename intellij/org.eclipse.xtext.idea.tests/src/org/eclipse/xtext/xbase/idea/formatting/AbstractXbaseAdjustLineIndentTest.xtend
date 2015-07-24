/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.formatting

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleManager
import org.eclipse.xtext.idea.tests.LightToolingTest
import com.intellij.openapi.fileTypes.LanguageFileType

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractXbaseAdjustLineIndentTest extends LightToolingTest {

	new(LanguageFileType fileType) {
		super(fileType)
	}
	
	def void testXIfExpression_then_01() {
		'''
			var x = 0
			if (x == 1)
			return true
			return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			return false
		''')
	}

	def void testXIfExpression_then_02() {
		'''
			var x = 0
			if (x == 1) {
			return true
			}
			return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1) {
				return true
			}
			return false
		''')
	}

	def void testXIfExpression_then_03() {
		'''
			var x = 0
			if (x == 1) return true
			return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1) return true
			return false
		''')
	}

	def void testXIfExpression_then_04() {
		'''
			var x = 0
			if (x == 1) { return true }
			return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1) { return true }
			return false
		''')
	}

	def void testXIfExpression_else_01() {
		'''
			var x = 0
			if (x == 1)
			return true
			else
			return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			else
				return false
		''')
	}

	def void testXIfExpression_else_02() {
		'''
			var x = 0
			if (x == 1)
			return true
			else {
			return false
			}
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			else {
				return false
			}
		''')
	}

	def void testXIfExpression_else_03() {
		'''
			var x = 0
			if (x == 1)
			return true
			else return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			else return false
		''')
	}

	def void testXIfExpression_else_04() {
		'''
			var x = 0
			if (x == 1)
			return true
			else { return false }
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			else { return false }
		''')
	}

	def void testXIfExpression_else_if_01() {
		'''
			var x = 0
			if (x == 1)
			return true
			else if (x == 2)
			return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			else if (x == 2)
				return false
		''')
	}

	def void testXIfExpression_else_if_02() {
		'''
			var x = 0
			if (x == 1)
			return true
			else if (x == 2) {
			return false
			}
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			else if (x == 2) {
				return false
			}
		''')
	}

	def void testXIfExpression_else_if_03() {
		'''
			var x = 0
			if (x == 1)
			return true
			else if (x == 2) return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			else if (x == 2) return false
		''')
	}

	def void testXIfExpression_else_if_04() {
		'''
			var x = 0
			if (x == 1)
			return true
			else if (x == 2) { return false }
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1)
				return true
			else if (x == 2) { return false }
		''')
	}

	def void testXIfExpression_if_01() {
		'''
			var x = 0
			if (x == 1
			)
			return true
			return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (x == 1
			)
				return true
			return false
		''')
	}

	def void testXIfExpression_if_02() {
		'''
			var x = 0
			if (
			x == 1
			)
			return true
			return false
		'''.assertAdjustLineIndent('''
			var x = 0
			if (
					x == 1
			)
				return true
			return false
		''')
	}

	def void testXOrExpression_01() {
		'''
			var x = 0
			x == 1 || x == 2 || x == 3 || x == 4
		'''.assertAdjustLineIndent('''
			var x = 0
			x == 1 || x == 2 || x == 3 || x == 4
		''')
	}

	def void testXOrExpression_02() {
		'''
			var x = 0
			x == 1 ||
			x == 2 ||
			x == 3 ||
			x == 4
		'''.assertAdjustLineIndent('''
			var x = 0
			x == 1 ||
					x == 2 ||
					x == 3 ||
					x == 4
		''')
	}

	def void testXOrExpression_03() {
		'''
			var x = 0
			x == 1
			|| x == 2
			|| x == 3
			|| x == 4
		'''.assertAdjustLineIndent('''
			var x = 0
			x == 1
					|| x == 2
					|| x == 3
					|| x == 4
		''')
	}

	def void testXOrExpression_04() {
		'''
			var x = 0
			x == 1
			||
			x == 2
			||
			x == 3
			||
			x == 4
		'''.assertAdjustLineIndent('''
			var x = 0
			x == 1
					||
					x == 2
					||
					x == 3
					||
					x == 4
		''')
	}

	def void testXAndExpression_01() {
		'''
			var x = 0
			x == 1 && x == 2 && x == 3 && x == 4
		'''.assertAdjustLineIndent('''
			var x = 0
			x == 1 && x == 2 && x == 3 && x == 4
		''')
	}

	def void testXAndExpression_02() {
		'''
			var x = 0
			x == 1 &&
			x == 2 &&
			x == 3 &&
			x == 4
		'''.assertAdjustLineIndent('''
			var x = 0
			x == 1 &&
					x == 2 &&
					x == 3 &&
					x == 4
		''')
	}

	def void testXAndExpression_03() {
		'''
			var x = 0
			x == 1
			&& x == 2
			&& x == 3
			&& x == 4
		'''.assertAdjustLineIndent('''
			var x = 0
			x == 1
					&& x == 2
					&& x == 3
					&& x == 4
		''')
	}

	def void testXAndExpression_04() {
		'''
			var x = 0
			x == 1
			&&
			x == 2
			&&
			x == 3
			&&
			x == 4
		'''.assertAdjustLineIndent('''
			var x = 0
			x == 1
					&&
					x == 2
					&&
					x == 3
					&&
					x == 4
		''')
	}

	def void testXEqualityExpression_01() {
		'''
			var a = 1; var b = 2; var c = 3; var d = 4
			a == b == c == d
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3; var d = 4
			a == b == c == d
		''')
	}

	def void testXEqualityExpression_02() {
		'''
			var a = 1; var b = 2; var c = 3; var d = 4
			a
			==
			b
			==
			c
			==
			d
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3; var d = 4
			a
					==
					b
					==
					c
					==
					d
		''')
	}

	def void testXEqualityExpression_03() {
		'''
			var a = 1; var b = 2; var c = 3; var d = 4
			a
			== b
			== c
			== d
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3; var d = 4
			a
					== b
					== c
					== d
		''')
	}

	def void testXInstanceOfExpression_01() {
		'''
			var object = new Object
			object instanceof java.lang.String
		'''.assertAdjustLineIndent('''
			var object = new Object
			object instanceof java.lang.String
		''')
	}

	def void testXInstanceOfExpression_02() {
		'''
			var object = new Object
			object
			instanceof
			java.lang.String
		'''.assertAdjustLineIndent('''
			var object = new Object
			object
					instanceof
					java.lang.String
		''')
	}

	def void testXInstanceOfExpression_03() {
		'''
			var object = new Object
			object
			instanceof java.lang.String
		'''.assertAdjustLineIndent('''
			var object = new Object
			object
					instanceof java.lang.String
		''')
	}

	def void testXRelationalExpression_01() {
		'''
			var a = 1; var b = 2
			a > b
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2
			a > b
		''')
	}

	def void testXRelationalExpression_02() {
		'''
			var a = 1; var b = 2
			a
			>
			b
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2
			a
					>
					b
		''')
	}

	def void testXRelationalExpression_03() {
		'''
			var a = 1; var b = 2
			a
			> b
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2
			a
					> b
		''')
	}

	def void testXOtherOperatorExpression_01() {
		'''
			var object = new Object
			object.toString ?: 'null'
		'''.assertAdjustLineIndent('''
			var object = new Object
			object.toString ?: 'null'
		''')
	}

	def void testXOtherOperatorExpression_02() {
		'''
			var object = new Object
			object.toString
			?:
			'null'
		'''.assertAdjustLineIndent('''
			var object = new Object
			object.toString
					?:
					'null'
		''')
	}

	def void testXOtherOperatorExpression_03() {
		'''
			var object = new Object
			object.toString
			?: 'null'
		'''.assertAdjustLineIndent('''
			var object = new Object
			object.toString
					?: 'null'
		''')
	}

	def void testXAdditiveExpression_01() {
		'''
			var a = 1; var b = 2; var c = 3
			a + b + c
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3
			a + b + c
		''')
	}

	def void testXAdditiveExpression_02() {
		'''
			var a = 1; var b = 2; var c = 3
			a
			+
			b
			+
			c
			'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3
			a
					+
					b
					+
					c
		''')
	}

	def void testXAdditiveExpression_03() {
		'''
			var a = 1; var b = 2; var c = 3
			a
			+ b
			+ c
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3
			a
					+ b
					+ c
		''')
	}

	def void testXMultiplicativeExpression_01() {
		'''
			var a = 1; var b = 2; var c = 3
			a * b * c
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3
			a * b * c
		''')
	}

	def void testXMultiplicativeExpression_02() {
		'''
			var a = 1; var b = 2; var c = 3
			a
			*
			b
			*
			c
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3
			a
					*
					b
					*
					c
		''')
	}

	def void testXMultiplicativeExpression_03() {
		'''
			var a = 1; var b = 2; var c = 3
			a
			* b
			* c
		'''.assertAdjustLineIndent('''
			var a = 1; var b = 2; var c = 3
			a
					* b
					* c
		''')
	}

	def void testXUnaryOperation_01() {
		'''
			var a = 1;
			-a
		'''.assertAdjustLineIndent('''
			var a = 1;
			-a
		''')
	}

	def void testXUnaryOperation_02() {
		'''
			var a = 1;
			-
			a
		'''.assertAdjustLineIndent('''
			var a = 1;
			-
					a
		''')
	}

	def void testXCastedExpression_01() {
		'''
			var object = new Object
			object as java.util.List<java.lang.String>
		'''.assertAdjustLineIndent('''
			var object = new Object
			object as java.util.List<java.lang.String>
		''')
	}

	def void testXCastedExpression_02() {
		'''
			var object = new Object
			object
			as
			java.util.List<java.lang.String>
		'''.assertAdjustLineIndent('''
			var object = new Object
			object
					as
					java.util.List<java.lang.String>
		''')
	}

	def void testXCastedExpression_03() {
		'''
			var object = new Object
			object
			as java.util.List<java.lang.String>
		'''.assertAdjustLineIndent('''
			var object = new Object
			object
					as java.util.List<java.lang.String>
		''')
	}

	def void testXPostfixOperation_01() {
		'''
			var a = 1
			a++
		'''.assertAdjustLineIndent('''
			var a = 1
			a++
		''')
	}

	def void testXPostfixOperation_02() {
		'''
			var a = 1
			a
			++
		'''.assertAdjustLineIndent('''
			var a = 1
			a
					++
		''')
	}

	def void testXAssignment_01() {
		'''
			var a = 1
			a = 3
		'''.assertAdjustLineIndent('''
			var a = 1
			a = 3
		''')
	}

	def void testXAssignment_02() {
		'''
			var a = 1
			a
			=
			3
		'''.assertAdjustLineIndent('''
			var a = 1
			a
					=
					3
		''')
	}
	
	def void testXAssignment_03() {
		'''
			var a = 1
			a += 3
		'''.assertAdjustLineIndent('''
			var a = 1
			a += 3
		''')
	}

	def void testXAssignment_04() {
		'''
			var a = 1
			a
			+=
			3
		'''.assertAdjustLineIndent('''
			var a = 1
			a
					+=
					3
		''')
	}

	def void testXMemberFeatureCall_01() {
		'''
			var values = <String>newArrayList
			values.head
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.head
		''')
	}

	def void testXMemberFeatureCall_02() {
		'''
			var values = <String>newArrayList
			values
			.
			head
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			head
		''')
	}

	def void testXMemberFeatureCall_03() {
		'''
			var values = <String>newArrayList
			values.get(0)
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.get(0)
		''')
	}

	def void testXMemberFeatureCall_04() {
		'''
			var values = <String>newArrayList
			values.get(
			0
			)
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.get(
					0
			)
		''')
	}

	def void testXMemberFeatureCall_05() {
		'''
			var values = <String>newArrayList
			values
			.
			get
			(
			0
			)
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			get
			(
					0
			)
		''')
	}

	def void testXMemberFeatureCall_06() {
		'''
			var values = <String>newArrayList
			values
			.
			get(
			0
			)
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			get(
					0
			)
		''')
	}

	def void testXClosure_01() {
		'''
			var values = <String>newArrayList
			values.map[value|value.length]
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.map[value|value.length]
		''')
	}

	def void testXClosure_02() {
		'''
			var values = <String>newArrayList
			values.map[value|
			value.length
			]
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.map[value|
				value.length
			]
		''')
	}

	def void testXClosure_03() {
		'''
			var values = <String>newArrayList
			values
			.
			map
			[
			value
			|
			value.length
			]
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			map
			[
				value
				|
				value.length
			]
		''')
	}

	def void testXClosure_04() {
		'''
			var values = <String>newArrayList
			values
			.
			map[value|
			value.length
			]
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			map[value|
				value.length
			]
		''')
	}

	def void testXClosure_05() {
		'''
			var values = <String>newArrayList
			values.map[length]
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.map[length]
		''')
	}

	def void testXClosure_06() {
		'''
			var values = <String>newArrayList
			values.map[
			length
			]
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.map[
				length
			]
		''')
	}

	def void testXClosure_07() {
		'''
			var values = <String>newArrayList
			values
			.
			map
			[
			length
			]
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			map
			[
				length
			]
		''')
	}

	def void testXClosure_08() {
		'''
			var values = <String>newArrayList
			values
			.
			map[
			length
			]
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			map[
				length
			]
		''')
	}

	def void testXShortClosure_01() {
		'''
			var values = <String>newArrayList
			values.map(value|value.length)
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.map(value|value.length)
		''')
	}

	def void testXShortClosure_02() {
		'''
			var values = <String>newArrayList
			values.map(value|
			value.length
			)
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values.map(value|
					value.length
			)
		''')
	}

	def void testXShortClosure_03() {
		'''
			var values = <String>newArrayList
			values
			.
			map
			(
			value
			|
			value.length
			)
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			map
			(
					value
							|
							value.length
			)
		''')
	}

	def void testXShortClosure_04() {
		'''
			var values = <String>newArrayList
			values
			.
			map(value|
			value.length
			)
		'''.assertAdjustLineIndent('''
			var values = <String>newArrayList
			values
			.
			map(value|
					value.length
			)
		''')
	}

	def void testXSetLiteral_01() {
		'''
			# {1, 2, 3, 4}
		'''.assertAdjustLineIndent('''
			# {1, 2, 3, 4}
		''')
	}

	def void testXSetLiteral_02() {
		'''
			#
			{
			1 + 2
			,
			3 + 4
			}
		'''.assertAdjustLineIndent('''
			#
			{
				1 + 2
				,
				3 + 4
			}
		''')
	}

	def void testXListLiteral_01() {
		'''
			# [1, 2, 3, 4]
		'''.assertAdjustLineIndent('''
			# [1, 2, 3, 4]
		''')
	}

	def void testXListLiteral_02() {
		'''
			#
			[
			1 + 2
			,
			3 + 4
			]
		'''.assertAdjustLineIndent('''
			#
			[
				1 + 2
				,
				3 + 4
			]
		''')
	}

	def void testXSwitchExpression_default_01() {
		'''
			var object = new Object
			switch object {
			default:
			return true
			}
		'''.assertAdjustLineIndent('''
			var object = new Object
			switch object {
				default:
					return true
			}
		''')
	}

	def void testXSwitchExpression_default_02() {
		'''
			var object = new Object
			switch object {
			default: return true
			}
		'''.assertAdjustLineIndent('''
			var object = new Object
			switch object {
				default: return true
			}
		''')
	}

	def void testXSwitchExpression_default_03() {
		'''
			var object = new Object
			switch object {
			default: {
			return true
			}
			}
		'''.assertAdjustLineIndent('''
			var object = new Object
			switch object {
				default: {
					return true
				}
			}
		''')
	}

	def void testXSwitchExpression_default_04() {
		'''
			var object = new Object
			switch object {
			default: { return true }
			}
		'''.assertAdjustLineIndent('''
			var object = new Object
			switch object {
				default: { return true }
			}
		''')
	}

	def void testXSwitchExpression_case_then_01() {
		'''
			var x = 1
			switch x {
			case 1:
			return true
			}
		'''.assertAdjustLineIndent('''
			var x = 1
			switch x {
				case 1:
					return true
			}
		''')
	}

	def void testXSwitchExpression_case_then_02() {
		'''
			var x = 1
			switch x {
			case 1: return true
			}
		'''.assertAdjustLineIndent('''
			var x = 1
			switch x {
				case 1: return true
			}
		''')
	}

	def void testXSwitchExpression_case_then_03() {
		'''
			var x = 1
			switch x {
			case 1: {
			return true
			}
			}
		'''.assertAdjustLineIndent('''
			var x = 1
			switch x {
				case 1: {
					return true
				}
			}
		''')
	}

	def void testXSwitchExpression_case_then_04() {
		'''
			var x = 1
			switch x {
			case 1: { return true }
			}
		'''.assertAdjustLineIndent('''
			var x = 1
			switch x {
				case 1: { return true }
			}
		''')
	}

	def void testXSwitchExpression_switch_01() {
		'''
			var x = 1
			switch
			x
			{
			default: return true
			}
		'''.assertAdjustLineIndent('''
			var x = 1
			switch
			x
			{
				default: return true
			}
		''')
	}

	def void testXSwitchExpression_switch_02() {
		'''
			var x = 1
			switch
			(
			x
			)
			{
			default: return true
			}
		'''.assertAdjustLineIndent('''
			var x = 1
			switch
			(
					x
			)
			{
				default: return true
			}
		''')
	}

	def void testXSwitchExpression_switch_03() {
		'''
			var x = 1
			switch
			(
			{
			x
			}
			)
			{
			default: return true
			}
		'''.assertAdjustLineIndent('''
			var x = 1
			switch
			(
					{
						x
					}
			)
			{
				default: return true
			}
		''')
	}

	def void testXSwitchExpression_switch_04() {
		'''
			var x = 1
			switch
			{
			x
			}
			{
			default: return true
			}
		'''.assertAdjustLineIndent('''
			var x = 1
			switch
			{
				x
			}
			{
				default: return true
			}
		''')
	}

	def void testXSwitchExpression_declareParam_01() {
		'''
			switch
			x
			:
			1
			{
			default: return x + 2
			}
		'''.assertAdjustLineIndent('''
			switch
			x
			:
			1
			{
				default: return x + 2
			}
		''')
	}

	def void testXSwitchExpression_declaredParam_02() {
		'''
			switch
			(
			x
			:
			1
			)
			{
			default: return x + 2
			}
		'''.assertAdjustLineIndent('''
			switch
			(
					x
					:
					1
			)
			{
				default: return x + 2
			}
		''')
	}

	def void testXSwitchExpression_declareParam_03() {
		'''
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
		'''.assertAdjustLineIndent('''
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
		''')
	}

	def void testXSwitchExpression_declaredParam_04() {
		'''
			switch
			x
			:
			{
			1
			}
			{
			default: return x + 2
			}
		'''.assertAdjustLineIndent('''
			switch
			x
			:
			{
				1
			}
			{
				default: return x + 2
			}
		''')
	}

	def void testXForLoopExpression_00() {
		'''
			val values = <String>newArrayList
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
		'''.assertAdjustLineIndent('''
			val values = <String>newArrayList
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
		''')
	}

	def void testXForLoopExpression_01() {
		'''
			val values = <String>newArrayList
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
		'''.assertAdjustLineIndent('''
			val values = <String>newArrayList
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
		''')
	}

	def void testXForLoopExpression_02() {
		'''
			val values = <String>newArrayList
			var result = 0
			for (value : values) {
			result += value.length
			}
			result
		'''.assertAdjustLineIndent('''
			val values = <String>newArrayList
			var result = 0
			for (value : values) {
				result += value.length
			}
			result
		''')
	}

	def void testXForLoopExpression_03() {
		'''
			val values = <String>newArrayList
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
		'''.assertAdjustLineIndent('''
			val values = <String>newArrayList
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
		''')
	}

	def void testXForLoopExpression_04() {
		'''
			val values = <String>newArrayList
			var result = 0
			for (value : values)
			result += value.length
			result
		'''.assertAdjustLineIndent('''
			val values = <String>newArrayList
			var result = 0
			for (value : values)
				result += value.length
			result
		''')
	}

	def void testXBasicForLoopExpression_01() {
		'''
			var result = 0
			for (var i = 1; i < 10; i++) {
			result += i
			}
			result
		'''.assertAdjustLineIndent('''
			var result = 0
			for (var i = 1; i < 10; i++) {
				result += i
			}
			result
		''')
	}

	def void testXBasicForLoopExpression_02() {
		'''
			var result = 0
			for (var i = 1; i < 10; i++)
			result += i
			result
		'''.assertAdjustLineIndent('''
			var result = 0
			for (var i = 1; i < 10; i++)
				result += i
			result
		''')
	}

	def void testXBasicForLoopExpression_03() {
		'''
			var result = 0
			for (
			var i = 1;
			i < 10;
			i++
			) {
			result += i
			}
			result
		'''.assertAdjustLineIndent('''
			var result = 0
			for (
					var i = 1;
					i < 10;
					i++
			) {
				result += i
			}
			result
		''')
	}

	def void testXBasicForLoopExpression_04() {
		'''
			var result = 0
			for (
			var i = 1;
			i < 10;
			i++
			)
			result += i
			result
		'''.assertAdjustLineIndent('''
			var result = 0
			for (
					var i = 1;
					i < 10;
					i++
			)
				result += i
			result
		''')
	}

	def void testXBasicForLoopExpression_05() {
		'''
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
		'''.assertAdjustLineIndent('''
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
		''')
	}

	def void testXWhileExpression_01() {
		'''
			var i = 0
			while (i < 10)
			i++
		'''.assertAdjustLineIndent('''
			var i = 0
			while (i < 10)
				i++
		''')
	}

	def void testXWhileExpression_02() {
		'''
			var i = 0
			while (i < 10) i++
		'''.assertAdjustLineIndent('''
			var i = 0
			while (i < 10) i++
		''')
	}

	def void testXWhileExpression_03() {
		'''
			var i = 0
			while (i < 10) { i++ }
		'''.assertAdjustLineIndent('''
			var i = 0
			while (i < 10) { i++ }
		''')
	}

	def void testXWhileExpression_04() {
		'''
			var i = 0
			while (i < 10) {
			i++
			}
		'''.assertAdjustLineIndent('''
			var i = 0
			while (i < 10) {
				i++
			}
		''')
	}

	def void testXWhileExpression_05() {
		'''
			var i = 0
			while (i < 10)
			{
			i++
			}
		'''.assertAdjustLineIndent('''
			var i = 0
			while (i < 10)
			{
				i++
			}
		''')
	}

	def void testXDoWhileExpression_01() {
		'''
			var i = 0
			do
			i++
			while (i < 10)
		'''.assertAdjustLineIndent('''
			var i = 0
			do
				i++
			while (i < 10)
		''')
	}

	def void testXDoWhileExpression_02() {
		'''
			var i = 0
			do i++
			while (i < 10)
		'''.assertAdjustLineIndent('''
			var i = 0
			do i++
			while (i < 10)
		''')
	}

	def void testXDoWhileExpression_03() {
		'''
			var i = 0
			do { i++ }
			while (i < 10)
		'''.assertAdjustLineIndent('''
			var i = 0
			do { i++ }
			while (i < 10)
		''')
	}

	def void testXDoWhileExpression_04() {
		'''
			var i = 0
			do {
			i++
			} while (i < 10)
		'''.assertAdjustLineIndent('''
			var i = 0
			do {
				i++
			} while (i < 10)
		''')
	}

	def void testXDoWhileExpression_05() {
		'''
			var i = 0
			do
			{
			i++
			} while (i < 10)
		'''.assertAdjustLineIndent('''
			var i = 0
			do
			{
				i++
			} while (i < 10)
		''')
	}

	def void testXDoWhileExpression_06() {
		'''
			var i = 0
			do
			{
			i++
			}
			while (i < 10)
		'''.assertAdjustLineIndent('''
			var i = 0
			do
			{
				i++
			}
			while (i < 10)
		''')
	}

	def void testXVariableDeclaration_01() {
		'''
			val i = 1
			return i
		'''.assertAdjustLineIndent('''
			val i = 1
			return i
		''')
	}

	def void testXVariableDeclaration_02() {
		'''
			val i =
			1
			return i
		'''.assertAdjustLineIndent('''
			val i =
				1
			return i
		''')
	}

	def void testXVariableDeclaration_03() {
		'''
			val i = {
			1
			}
			return i
		'''.assertAdjustLineIndent('''
			val i = {
				1
			}
			return i
		''')
	}

	def void testXVariableDeclaration_04() {
		'''
			val i =
			{
			1
			}
			return i
		'''.assertAdjustLineIndent('''
			val i =
			{
				1
			}
			return i
		''')
	}
	
	def void testXTypeLiteral_01() {
		'''
			typeof(java.lang.String)
		'''.assertAdjustLineIndent('''
			typeof(java.lang.String)
		''')
	}
	
	def void testXTypeLiteral_02() {
		'''
			typeof
			(java.lang.String)
		'''.assertAdjustLineIndent('''
			typeof
			(java.lang.String)
		''')
	}
	
	def void testXTypeLiteral_03() {
		'''
			typeof
			(
			java.lang.String)
		'''.assertAdjustLineIndent('''
			typeof
			(
					java.lang.String)
		''')
	}
	
	def void testXTypeLiteral_04() {
		'''
			typeof
			(
			java.lang.String
			)
		'''.assertAdjustLineIndent('''
			typeof
			(
					java.lang.String
			)
		''')
	}
	
	def void testXThrowExpression_01() {
		'''
			throw new java.lang.IllegalStateException
		'''.assertAdjustLineIndent('''
			throw new java.lang.IllegalStateException
		''')
	}
	
	def void testXThrowExpression_02() {
		'''
			throw
			new java.lang.IllegalStateException
		'''.assertAdjustLineIndent('''
			throw
				new java.lang.IllegalStateException
		''')
	}
	
	def void testXThrowExpression_03() {
		'''
			throw {
			new java.lang.IllegalStateException
			}
		'''.assertAdjustLineIndent('''
			throw {
				new java.lang.IllegalStateException
			}
		''')
	}
	
	def void testXThrowExpression_04() {
		'''
			throw
			{
			new java.lang.IllegalStateException
			}
		'''.assertAdjustLineIndent('''
			throw
			{
				new java.lang.IllegalStateException
			}
		''')
	}
	
	def void testXReturnExpression_01() {
		'''
			return 1
		'''.assertAdjustLineIndent('''
			return 1
		''')
	}
	
	def void testXReturnExpression_02() {
		'''
			return
			1
		'''.assertAdjustLineIndent('''
			return
				1
		''')
	}
	
	def void testXReturnExpression_03() {
		'''
			return {
			1
			}
		'''.assertAdjustLineIndent('''
			return {
				1
			}
		''')
	}
	
	def void testXReturnExpression_04() {
		'''
			return
			{
			1
			}
		'''.assertAdjustLineIndent('''
			return
			{
				1
			}
		''')
	}
	
	def void testXTryCatchFinallyExpression_01() {
		'''
			var b = false
			try return 1
			catch (java.lang.IllegalStateException e) return 2
			catch (java.lang.Exception e) return 3
			finally b = true
		'''.assertAdjustLineIndent('''
			var b = false
			try return 1
			catch (java.lang.IllegalStateException e) return 2
			catch (java.lang.Exception e) return 3
			finally b = true
		''')
	}
	
	def void testXTryCatchFinallyExpression_02() {
		'''
			var b = false
			try 
			return 1
			catch (java.lang.IllegalStateException e)
			return 2
			catch (java.lang.Exception e)
			return 3
			finally
			b = true
		'''.assertAdjustLineIndent('''
			var b = false
			try
				return 1
			catch (java.lang.IllegalStateException e)
				return 2
			catch (java.lang.Exception e)
				return 3
			finally
				b = true
		''')
	}
	
	def void testXTryCatchFinallyExpression_03() {
		'''
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
		'''.assertAdjustLineIndent('''
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
		''')
	}
	
	def void testXTryCatchFinallyExpression_04() {
		'''
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
		'''.assertAdjustLineIndent('''
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
		''')
	}
	
	def void testXSynchronizedExpression_01() {
		'''
			var lock = new Object
			synchronized (lock) return 1
		'''.assertAdjustLineIndent('''
			var lock = new Object
			synchronized (lock) return 1
		''')
	}
	
	def void testXSynchronizedExpression_02() {
		'''
			var lock = new Object
			synchronized (lock)
			return 1
		'''.assertAdjustLineIndent('''
			var lock = new Object
			synchronized (lock)
				return 1
		''')
	}
	
	def void testXSynchronizedExpression_03() {
		'''
			var lock = new Object
			synchronized (lock) {
			return 1
			}
		'''.assertAdjustLineIndent('''
			var lock = new Object
			synchronized (lock) {
				return 1
			}
		''')
	}
	
	def void testXSynchronizedExpression_04() {
		'''
			var lock = new Object
			synchronized (lock)
			{
			return 1
			}
		'''.assertAdjustLineIndent('''
			var lock = new Object
			synchronized (lock)
			{
				return 1
			}
		''')
	}
	
	def void testXSynchronizedExpression_05() {
		'''
			var lock = new Object
			synchronized (
			lock)
			{
			return 1
			}
		'''.assertAdjustLineIndent('''
			var lock = new Object
			synchronized (
					lock)
			{
				return 1
			}
		''')
	}
	
	def void testXSynchronizedExpression_06() {
		'''
			var lock = new Object
			synchronized
			(
			lock
			)
			{
			return 1
			}
		'''.assertAdjustLineIndent('''
			var lock = new Object
			synchronized
			(
					lock
			)
			{
				return 1
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

/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation

import com.google.inject.Inject
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test
import org.eclipse.emf.ecore.EClass

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XbaseValidationTest extends AbstractXbaseTestCase {

	@Inject
	extension ValidationTestHelper

	@Test def void testForwardReferenceToLocalVar() {
		'''
			{ val (int)=>int fun = [ fun.apply(it) ] }
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.ILLEGAL_FORWARD_REFERENCE, 'The local variable fun may not have been initialized')
	}
	
	@Test def void testDuplicateCases_typeLiteral() {
		'''
			switch x : String {
				case String: 1
				case String: 1
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_typeLiteral_2() {
		'''
			switch x : String {
				case String: 1
				case typeof(String): 1
			}
		'''.expression => [
			assertError(XbasePackage.Literals.XTYPE_LITERAL, IssueCodes.DUPLICATE_CASE)
			assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
		]
	}

	@Test def void testDuplicateCases_typeLiteral_3() {
		'''
			switch x : String {
				case typeof(String): 1
				case typeof(String): 1
			}
		'''.expression.assertError(XbasePackage.Literals.XTYPE_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_typeLiteral_4() {
		'''
			switch x : String {
				case typeof(Integer): 1
				case typeof(String): 1
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_typeLiteral_5() {
		'''
			switch x : String {
				case Integer: 1
				case typeof(String): 1
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_typeLiteral_6() {
		'''
			switch x : String {
				case Integer: 1
				case String: 1
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_typeLiteral_7() {
		'''
			switch x : String {
				case 'java.lang.String': 1
				case String: 1
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_boolean() {
		'''
			switch x : true {
				case false: 1
				case false: 1
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_int() {
		'''
			switch x : 1 {
				case 1: 1
				case 1: 1
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_int_2() {
		'''
			switch x : 1 {
				case 1: 1
				case 2: 2
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_int_3() {
		'''
			{
				val int a = 1
				val char b = 1 as char
				val byte c = 1 as byte
				val short d = 1 as short
				switch x : 1 {
					case a: 1
					case b: 1
					case c: 1
					case d: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_int_4() {
		'''
			{
				val int a = 1
				val char b = 2 as char
				val byte c = 3 as byte
				val short d = 4 as short
				switch x : 1 {
					case a: 1
					case b: 2
					case c: 3
					case d: 4
				}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_int_5() {
		'''
			{
				switch x : 1 {
					case 1: 1
					case [|1].apply: 1
				}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_int_6() {
		'''
			{
				val Integer x = 1
				switch x {
					Integer case 1: 1
					Integer case 1: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_int_7() {
		'''
			{
				val Integer x = 1
				switch x {
					Integer case 1: 1
					case 1: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_int_8() {
		'''
			{
				switch x : 1 {
					case x: ''
					case x: '1'
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_enum() {
		'''
			{
				switch x : Thread.State.NEW {
					case NEW: 1
					case NEW: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_enum_2() {
		'''
			{
				switch x : Thread.State.NEW {
					case NEW: 1
					case Thread.State.NEW: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_enum_3() {
		'''
			{
				val state = Thread.State.NEW
				switch x : Thread.State.NEW {
					case NEW: 1
					case state: 1
				}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_enum_4() {
		'''
			{
				switch x : Thread.State.NEW {
					case NEW: 1
					case RUNNABLE: 2
				}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_double() {
		'''
			switch x : 1d {
				case 1: 1
				case 1: 1
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_double_2() {
		'''
			switch x : 1.5d {
				case 1.5d: 1
				case 1.5d: 1
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_double_3() {
		'''
			switch x : 1.5d {
				case 1.5d: 1
				case 1.6d: 1
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_number() {
		'''
			switch x : 1 {
				case 1: 1
				case 1l: 1
				case 1f: 1
				case 1d: 1
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testDuplicateCases_string() {
		'''
			switch x : 'lalala' {
				case 'A': 1
				case 'A': 1
			}
		'''.expression.assertError(XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_object() {
		'''
			switch x : new Object {
				case 'A': 1
				case 'A': 1
			}
		'''.expression.assertError(XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.DUPLICATE_CASE)
	}
	
	@Test def void testUnreachableCase() {
		'''
			switch x : new Exception {
				Exception: 1
				java.io.IOException: 2
				java.io.FileNotFoundException: 3
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE)
	}
	
	@Test def void testUnreachableCase_2() {
		'''
			switch x : new Exception {
				java.io.IOException: 2
				Exception: 1
				java.io.FileNotFoundException: 3
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE)
	}
	
	@Test def void testUnreachableCase_3() {
		'''
			switch x : new Exception {
				java.io.IOException: 2
				java.io.FileNotFoundException: 3
				Exception: 1
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE)
	}
	
	@Test def void testUnreachableCase_4() {
		'''
			switch x : new Exception {
				java.io.FileNotFoundException: 3
				java.io.IOException: 2
				Exception: 1
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableCase_5() {
		'''
			switch x : new Exception {
				Exception case true: 1
				java.io.IOException case false: 2
				java.io.FileNotFoundException: 3
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableCase_6() {
		'''
			switch new java.util.ArrayList<String> {
				java.util.List<Integer>: "list of integers"
				java.util.List<String>: "list of strings"
				default: "something else"
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE)
	}
	
	@Test def void testUnreachableCase_7() {
		'''
			switch new java.util.ArrayList<String> {
				java.util.List<Integer>: "list of integers"
				java.util.Set<String>: "set of strings"
				default: "something else"
			}
		'''.expression.assertNoErrors
	}
	
		
	@Test def void testUnreachableCase_8() {
		'''
			switch new java.util.ArrayList<String> {
				java.util.List: "list of integers"
				java.util.List<String>: "list of strings"
				default: "something else"
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE)
	}
	
	@Test def void testUnreachableCatchClause() {
		'''
			try {
				
			} catch (Exception e) {
				
			} catch (java.io.IOException e) {
				
			} catch (java.io.FileNotFoundException e) {
				
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK)
	}
	
	@Test def void testUnreachableCatchClause_2() {
		'''
			try {
				
			} catch (java.io.IOException e) {
				
			} catch (Exception e) {
				
			} catch (java.io.FileNotFoundException e) {
				
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK)
	}
	
	@Test def void testUnreachableCatchClause_3() {
		'''
			try {
				
			} catch (java.io.IOException e) {

			} catch (java.io.FileNotFoundException e) {
				
			} catch (Exception e) {
				
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK)
	}
	
	@Test def void testUnreachableCatchClause_4() {
		'''
			try {
				
			} catch (java.io.FileNotFoundException e) {
				
			} catch (java.io.IOException e) {

			} catch (Exception e) {
				
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf() {
		'''
		{
			val x = new Object
			if (x instanceof Exception) {
				1
			} else if (x instanceof java.io.IOException) {
				2
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			}
		}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK)
	}
	
	@Test def void testUnreachableInstanceOf_2() {
		'''
		{
			val x = new Object
			if (x instanceof java.io.IOException) {
				2
			} else if (x instanceof Exception) {
				1
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			}
		}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK)
	}
	
	@Test def void testUnreachableInstanceOf_3() {
		'''
		{
			val x = new Object
			if (x instanceof java.io.IOException) {
				2
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			} else if (x instanceof Exception) {
				1
			}
		}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK)
	}
	
	@Test def void testUnreachableInstanceOf_4() {
		'''
		{
			val x = new Object
			if (x instanceof java.io.FileNotFoundException) {
				3
			} else if (x instanceof java.io.IOException) {
				2
			} else if (x instanceof Exception) {
				1
			}
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf_5() {
		'''
		{
			val x = new Object
			if (x instanceof Exception && true) {
				1
			} else if (x instanceof java.io.IOException && false) {
				2
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			}
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf_6() {
		'''
		{
			val x = new Object
			if (x instanceof java.util.List) {
				1
			} else if (x instanceof int[]) {
				2
			}
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf_7() {
		'''
		{
			val x = new Object
			val y = new Object
			if (x instanceof java.io.IOException) {
				1
			} else if (y instanceof java.io.FileNotFoundException) {
				2
			}
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf_8() {
		'''
		{
			val x = new Object
			val y = new Object
			if (x instanceof java.io.IOException) {
				1
			} else if (y instanceof java.io.IOException) {
				2
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			} else if (y instanceof java.io.FileNotFoundException) {
				4
			}
		}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK)
	}
	
	@Test def void testIncompleteCasesOnEnum() {
		'''
		{
			switch org.eclipse.xtext.xbase.tests.validation.Color.RED {
				case RED: {
					1
				}
			}
		}
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	}
	
	@Test def void testIncompleteCasesOnEnum_2() {
		'''
		{
			switch org.eclipse.xtext.xbase.tests.validation.Color.RED {
				case RED: {
					1
				}
				case GREEN: {
					1
				}
				case BLUE: {
					1
				}
			}
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testIncompleteCasesOnEnum_3() {
		'''
		{
			val y = Integer.valueOf("1")
			switch org.eclipse.xtext.xbase.tests.validation.Color.RED {
				case RED: {
					1
				}
				case y == 2: {
					2
				}
			}
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testIncompleteCasesOnEnum_4() {
		'''
		{
			switch org.eclipse.xtext.xbase.tests.validation.Color.RED {
				case RED: {
					1
				}
				default: {
					2
				}
			}
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testIncompleteCasesOnEnum_5() {
		'''
		{
			switch org.eclipse.xtext.xbase.tests.validation.Color.RED {
			}
		}
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	}
	
	@Test def void testIncompleteCasesOnEnum_6() {
		'''
		{
			switch org.eclipse.xtext.xbase.tests.validation.Color.RED {
				default: {
					1
				}
			}
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testIncompleteCasesOnEnum_7() {
		'''
		{
			switch org.eclipse.xtext.xbase.tests.validation.Color x : org.eclipse.xtext.xbase.tests.validation.Color.RED {
			}
		}
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	}
	
	@Test def void testIncompleteCasesOnEnum_8() {
		'''
		{
			switch (org.eclipse.xtext.xbase.tests.validation.Color x : org.eclipse.xtext.xbase.tests.validation.Color.RED) {
			}
		}
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	}
	
	@Test def void testIncompleteCasesOnEnum_9() {
		'''
		{
			switch Object x : org.eclipse.xtext.xbase.tests.validation.Color.RED {
			}
		}
		'''.expression.assertNoIssue(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	}
	
	@Test def void testIncompleteCasesOnEnum_10() {
		'''
		{
			switch (Object x : org.eclipse.xtext.xbase.tests.validation.Color.RED) {
			}
		}
		'''.expression.assertNoIssue(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	}
	
	@Test def void testIncompleteCasesOnEnum_11() {
		'''
		{
			val Enum<?> e = null
			switch(e) {
				java.lang.annotation.RetentionPolicy: e.toString
				java.lang.annotation.ElementType: e.toString
			}
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testSwitchNoParameter() {
		val block = '''
			{
				switch "lalala" {
				}
			}
		'''.expression
		block.assertNoIssues
	}
	
	@Test def void testSwitchDeclaredParameter() {
		val block = '''
			{
				switch Object x : "lalala" {
				}
			}
		'''.expression
		block.assertNoErrors
		block.assertWarning(TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE)
	}
	
	@Test def void testSwitchDeclaredParameter_1() {
		val block = '''
			{
				switch String x : "lalala" {
				}
			}
		'''.expression
		block.assertNoErrors
		block.assertWarning(TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE)
	}
	
	@Test def void testSwitchDeclaredParameter_2() {
		val block = '''
			{
				switch Integer x : "lalala" {
				}
			}
		'''.expression
		block.assertError(XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.INCOMPATIBLE_TYPES)
		block.assertWarning(TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE)
	}
	
	@Test def void testSwitchDeclaredParameter_3() {
		val block = '''
			{
				switch (Object x : "lalala") {
				}
			}
		'''.expression
		block.assertNoErrors
		block.assertWarning(TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE)
	}
	
	@Test def void testSwitchDeclaredParameter_4() {
		val block = '''
			{
				switch (String x : "lalala") {
				}
			}
		'''.expression
		block.assertNoErrors
		block.assertWarning(TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE)
	}
	
	@Test def void testSwitchDeclaredParameter_5() {
		val block = '''
			{
				switch (Integer x : "lalala") {
				}
			}
		'''.expression
		block.assertError(XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.INCOMPATIBLE_TYPES)
		block.assertWarning(TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE)
	}
	
	@Test def void testBasicForLoop_InvalidInnerExpression() {
		'''
		{
			for(var condition = true; condition;) {
			}
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testBasicForLoop_UnusedVariable() {
		'''
		{
			for(var condition = true;;) {
			}
		}
		'''.expression.assertWarning(XbasePackage.Literals.XVARIABLE_DECLARATION, IssueCodes.UNUSED_LOCAL_VARIABLE)
	}
	
	@Test def void testSynchronizedExpression_1() {
		'''
			{
				synchronized (1 + 2) {
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES)
	}
	
	@Test def void testSynchronizedExpression_2() {
		'''
			{
				synchronized (null) {
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XNULL_LITERAL, IssueCodes.INCOMPATIBLE_TYPES)
	}
	
	@Test def void testSynchronizedExpression_3() {
		'''
			{
				val x = Integer.valueOf(1)
				synchronized (x) {
				}
			}
		'''.expression.assertNoIssues
	}
	
	@Test def void testSynchronizedExpression_4() {
		'''
			{
				val ()=>void x = [|]
				synchronized (x.apply) {
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPATIBLE_TYPES)
	}
	
	@Test def void testSynchronizedExpression_5() {
		'''
			{
				val ()=>int x = [|1]
				synchronized (x.apply) {
				}
			}
		'''.expression.assertNoIssues
	}
	
	@Test def void testSynchronizedExpression_6() {
		'''
			{
				val ()=>Object x = [|new Object]
				synchronized (x.apply) {
				}
			}
		'''.expression.assertNoIssues
	}
	
	@Test def void testSynchronizedExpression_7() {
		'''
			{
				val x = 1
				synchronized (x) {
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INCOMPATIBLE_TYPES)
	}
	
	@Test def void testSynchronizedExpression_8() {
		'''
			{
				val int x = synchronized (new Object) new Object
				x
			}
		'''.expression.assertError(XbasePackage.Literals.XCONSTRUCTOR_CALL, IssueCodes.INCOMPATIBLE_TYPES)
	}
	
	@Test def void testSynchronizedExpression_9() {
		'''
			{
				val int x = synchronized (new Object) 1
				x
			}
		'''.expression.assertNoIssues
	}
	
	@Test def void testSynchronizedExpression_10() {
		'''
			{
				val x = synchronized (new Object) new Object
				x
			}
		'''.expression.assertNoIssues
	}
	
	@Test def void testSynchronizedExpression_11() {
		'''
			{
				val foo = "lalala"
				synchronized (foo) {
				}
				foo
			}
		'''.expression.assertNoIssues
	}
	
	@Test def void testBug415770_01(){
		'''
		{
			val String str = ""
			val String[] array = null
			str === array
		}
		'''.expression.assertError(XbasePackage.Literals.XBINARY_OPERATION,IssueCodes.INVALID_OPERAND_TYPES)
	}
	
	@Test def void testBug415770_02(){
		'''
		{
			val String str = ""
			val String[] array = null
			str !== array
		}
		'''.expression.assertError(XbasePackage.Literals.XBINARY_OPERATION,IssueCodes.INVALID_OPERAND_TYPES)
	}
	
	@Test def void testBug415770_03(){
		'''
		{
			val String str = ""
			val String[] array = null
			array === str
		}
		'''.expression.assertError(XbasePackage.Literals.XBINARY_OPERATION,IssueCodes.INVALID_OPERAND_TYPES)
	}
	
	@Test def void testBug415770_04(){
		'''
		{
			val String str = ""
			val String[] array = null
			array !== str
		}
		'''.expression.assertError(XbasePackage.Literals.XBINARY_OPERATION,IssueCodes.INVALID_OPERAND_TYPES)
	}
	
	@Test def void testBug415770_05(){
		'''
		{
			val String str = ""
			str === "SomeString"
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testBug415770_06(){
		'''
		{
			val String str = ""
			str !== "SomeString"
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testBug415770_07(){
		'''
		{
			val String[] array = null
			val String[] array2 = null
			array === array2
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testBug415770_08(){
		'''
		{
			val String[] array = null
			val String[] array2 = null
			array !== array2
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testBug415770_09(){
		'''
		{
			val String[] array = null
			array !== null || array === null
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testBug415770_10(){
		'''
		{
			val Cloneable c = null
			val String[] array = null
			array !== c || array === c || c === array || c !== array
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testBug415770_11(){
		'''
		{
			val java.io.Serializable s = null
			val String[] array = null
			array !== s || array === s || s === array || s !== array
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testBug415770_12(){
		'''
		{
			val Object o = null
			val String[] array = null
			array !== o || array === o || o === array || o !== array
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testNullSafePrimitiveNumber(){
		'''
		{
			val x = ""?.hashCode
		}
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, "hashCode", "0")
	}
	
	@Test def void testNullSafePrimitiveBoolean(){
		'''
		{
			val x = ""?.equals(null)
		}
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, "equals", "false")
	}
	
	@Test def void testBug444972_01(){
		'''
		{
			val java.lang.annotation.RetentionPolicy x = null
			val boolean b = switch x {
				case x.name == "": false
				case SOURCE: true
			}
			println(b)
		}
		'''.expression.assertWarning(XbasePackage.Literals.XSWITCH_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE)
	}
	
	@Test def void testBug444972_02(){
		'''
		{
			val java.lang.annotation.RetentionPolicy x = null
			val boolean b = switch x {
				case SOURCE,
				case CLASS,
				case RUNTIME: true
			}
			println(b)
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testBug458742_01() {
		'''
			{
				val list = #["foo"]
				list?.add("bar")
				return false
			}
		'''.expression.assertNoIssues
	}
	
	@Test def void testBug458742_02() {
		'''
			{
				val list = #["foo"]
				list?.add("bar")
			}
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL,
				IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE,
				"Null-safe call of primitive-valued feature")
	}
	
	@Test def void testBug458742_03() {
		'''
		    {
		    	val list = #["foo"]
		        val b = list?.add("bar")
		        return b
		    }
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL,
				IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE,
				"Null-safe call of primitive-valued feature")
	}

	@Test def void testRedundantCases_01() {
		'''
			switch i : 1 {
				case 1,
			}
		'''.expression.assertError(XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE)
	}

	@Test def void testRedundantCases_02() {
		'''
			switch i : 1 {
				case 1,
				case 2,
			}
		'''.expression.assertError(XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE)
	}

	@Test def void testRedundantCases_03() {
		'''
			switch i : 1 {
				case 1,
				default: 1
			}
		'''.expression.assertWarning(XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE)
	}

	@Test def void testRedundantCases_04() {
		'''
			switch i : 1 {
				case 1,
				case 2,
				default: 1
			}
		'''.expression.assertWarning(XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE)
	}

	@Test def void testRedundantCases_05() {
		'''
			switch i : 1 {
				case 1,
				case 2: 1
			}
		'''.expression.assertNoIssue(XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE)
	}

	@Test def void testSetLiteralTypeMismatchBug498779() {
		'''
			{
				val java.util.Set<String> set = #[""]
			}
		'''.expression.assertError(XbasePackage.Literals.XLIST_LITERAL, IssueCodes.INCOMPATIBLE_TYPES)
	}

	@Test def void testListLiteralTypeMismatchBug498779() {
		'''
			{
				val java.util.List<String> list = #{""}
			}
		'''.expression.assertError(XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES)
	}

	@Test def void testSetLiteralAssignedToCollectionBug498779() {
		'''
			{
				val java.util.Collection<String> set = #{""}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testListLiteralAssignedToCollectionBug498779() {
		'''
			{
				val java.util.Collection<String> list = #[""]
			}
		'''.expression.assertNoErrors
	}

	@Test def void testInvalidNestedReturnBug406762() {
		'''
			{
				return return 0
			}
		'''.assertNestedReturn(XbasePackage.Literals.XRETURN_EXPRESSION)
	}

	@Test def void testInvalidNestedReturnBug406762_1() {
		'''
			{
				return {
					return 0
				}
			}
		'''.assertInvalidReturnExpression(XbasePackage.Literals.XBLOCK_EXPRESSION)
	}

	@Test def void testInvalidNestedReturnBug406762_2() {
		'''
			{
				return {
					if (true) return 0 else return 1
				}
			}
		'''.assertInvalidReturnExpression(XbasePackage.Literals.XBLOCK_EXPRESSION)
	}

	@Test def void testInvalidNestedReturnBug406762_3() {
		'''
			{
				return 
					if (true) return 0 else return 1
			}
		'''.assertInvalidReturnExpression(XbasePackage.Literals.XIF_EXPRESSION)
	}

	@Test def void testInvalidNestedReturnBug406762_4() {
		'''
			{
				return 
					throw return new RuntimeException()
			}
		'''.assertInvalidReturnExpression(XbasePackage.Literals.XTHROW_EXPRESSION)
	}

	@Test def void testInvalidReturnInThrowBug406762() {
		'''
			{
				throw return new RuntimeException()
			}
		'''.assertInvalidReturnInsideThrow
	}

	@Test def void testInvalidReturnInThrowBug406762_1() {
		'''
			{
				throw {
					return new RuntimeException()
				}
			}
		'''.assertInvalidReturnInsideThrow
	}

	@Test def void testInvalidReturnInThrowBug406762_2() {
		'''
			{
				throw return
			}
		'''.assertInvalidReturnInsideThrow
	}

	@Test def void testInvalidReturnInThrowBug406762_3() {
		'''
			{
				throw {
					return
				}
			}
		'''.assertInvalidReturnInsideThrow
	}

	@Test def void testInvalidReturnThrowBug406762() {
		'''
			{
				return throw new RuntimeException()
			}
		'''.assertInvalidReturnExpression(XbasePackage.Literals.XTHROW_EXPRESSION)
	}

	@Test def void testInvalidReturnThrowBug406762_1() {
		'''
			{
				val b = true
				return if (b) throw new RuntimeException() else throw new RuntimeException()
			}
		'''.assertInvalidReturnExpression(XbasePackage.Literals.XIF_EXPRESSION)
	}

	@Test def void testValidReturnThrowBug406762() {
		'''
			{
				val b = true
				return if (b) throw new RuntimeException() else 42
			}
		'''.expression.assertNoErrors
	}

	@Test def void testValidReturnThrowBug406762_1() {
		'''
			{
				val b = true
				return if (b) 42 else throw new RuntimeException()
			}
		'''.expression.assertNoErrors
	}

	@Test def void test406762_ValidReturnInLambdaContainedInThrow() {
		'''
			throw {
				val foo = [|return "foo"]
				new Exception(foo.apply)
			}
		'''.expression.assertNoErrors
	}

	@Test def void test406762_ValidReturnInLambdaContainedInThrow_1() {
		'''
			throw {
				val ()=>Exception foo = [|return new Exception]
				foo.apply
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testRangeLiteralInForLoopBug440006_01() {
		'''
			for (int i : #[1..2]) {
			}
		'''.expression.assertError(XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES)
	}

	@Test def void testRangeLiteralInForLoopBug440006_02() {
		'''
			for (Integer i : #[1..2]) {
			}
		'''.expression.assertError(XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES)
	}

	@Test def void testRangeLiteralInForLoopBug440006_03() {
		'''
			for (Number i : #[1..2]) {
			}
		'''.expression.assertError(XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES)
	}

	@Test def void testRangeLiteralInForLoopBug440006_04() {
		'''
			for (i : #[1..2]) {
			}
		'''.expression.assertNoErrors
	}

	@Test def void testRangeLiteralInForLoopBug440006_05() {
		'''
			for (IntegerRange i : #[1..2]) {
			}
		'''.expression.assertNoErrors
	}

	@Test def void testRangeLiteralInForLoopBug440006_06() {
		'''
			for (Iterable<Integer> i : #[1..2]) {
			}
		'''.expression.assertNoErrors
	}

	@Test def void testRangeLiteralInForLoopBug440006_07() {
		'''
			for (int i : #[1..2].flatten) {
			}
		'''.expression.assertNoErrors
	}

	@Test def void testRangeLiteralInForLoopBug440006_01b() {
		'''
			for (int i : #{1..2}) {
			}
		'''.expression.assertError(XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES)
	}

	@Test def void testRangeLiteralInForLoopBug440006_02b() {
		'''
			for (Integer i : #{1..2}) {
			}
		'''.expression.assertError(XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES)
	}


	@Test def void testRangeLiteralInForLoopBug440006_03b() {
		'''
			for (Number i : #{1..2}) {
			}
		'''.expression.assertError(XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES)
	}

	@Test def void testRangeLiteralInForLoopBug440006_04b() {
		'''
			for (i : #{1..2}) {
			}
		'''.expression.assertNoErrors
	}

	@Test def void testRangeLiteralInForLoopBug440006_05b() {
		'''
			for (IntegerRange i : #{1..2}) {
			}
		'''.expression.assertNoErrors
	}

	@Test def void testRangeLiteralInForLoopBug440006_06b() {
		'''
			for (Iterable<Integer> i : #{1..2}) {
			}
		'''.expression.assertNoErrors
	}

	@Test def void testRangeLiteralInForLoopBug440006_07b() {
		'''
			for (int i : #{1..2}.flatten) {
			}
		'''.expression.assertNoErrors
	}

	def private assertNestedReturn(CharSequence input, EClass objectType) {
		input.expression.assertError(
			objectType,
			IssueCodes.INVALID_RETURN,
			"Return cannot be nested."
		)
	}

	def private assertInvalidReturnInsideThrow(CharSequence input) {
		input.expression.assertError(
			XbasePackage.Literals.XRETURN_EXPRESSION,
			IssueCodes.INVALID_RETURN,
			"Invalid return inside throw."
		)
	}

	def private assertInvalidReturnExpression(CharSequence input, EClass objectType) {
		input.expression.assertError(
			objectType,
			IssueCodes.INVALID_RETURN,
			"Invalid return's expression."
		)
	}
}

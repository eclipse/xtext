/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.serializer.impl.Serializer
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Provider
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider)
@RunWith(XtextRunner)
class RegionAccessTest {
	@Inject ParseHelper<Root> parseHelper
	@Inject Provider<TextRegionAccessBuilder> textRegionAccessBuilder
	@Inject ValidationTestHelper validationTestHelper
	@Inject extension Serializer serializer

	@Test def void testSimple() {
		'''
			1 foo
		'''.toString.trim === '''
			0 0 Hidden
			    Start    Simple'foo' via Root
			0 1 Semantic "1" Simple:'1'
			1 1 Hidden   " " Whitespace:TerminalRule'WS'
			2 3 Semantic "foo" Simple:name=ID
			    End      Simple'foo' via Root
			5 0 Hidden
		'''
	}

	@Test def void testAssignedDelegate() {
		'''
			2 foo
		'''.toString.trim === '''
			0 0 Hidden
			    Start    Delegation via Root
			0 1 Semantic "2" Delegation:'2'
			1 1 Hidden   " " Whitespace:TerminalRule'WS'
			    Start    delegate=Delegate'foo' via Delegation:delegate=Delegate
			2 3 Semantic "foo" Delegate:name=ID
			    End      delegate=Delegate'foo' via Delegation:delegate=Delegate
			    End      Delegation via Root
			5 0 Hidden
		'''
	}

	@Test def void testUnassignedDelegate() {
		'''
			3 foo
		'''.toString.trim === '''
			0 0 Hidden
			    Start    Delegate'foo' via Root
			0 1 Semantic "3" Unassigned:'3'
			1 1 Hidden   " " Whitespace:TerminalRule'WS'
			2 3 Semantic "foo" Delegate:name=ID
			    End      Delegate'foo' via Root
			5 0 Hidden
		'''
	}

	@Test def void testUnassignedPrefixedDelegate() {
		'''
			4 prefix foo
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    PrefixedUnassigned via Root
			 0 1 Semantic "4" PrefixedUnassigned:'4'
			 1 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    delegate=Delegate'foo' via PrefixedUnassigned:delegate=PrefixedDelegate
			 2 6 Semantic "prefix" PrefixedDelegate:'prefix'
			 8 1 Hidden   " " Whitespace:TerminalRule'WS'
			 9 3 Semantic "foo" Delegate:name=ID
			     End      delegate=Delegate'foo' via PrefixedUnassigned:delegate=PrefixedDelegate
			     End      PrefixedUnassigned via Root
			12 0 Hidden
		'''
	}
	
	@Test def void testExpression1() {
		'''
			5 a + b
		'''.toString.trim === '''
			0 0 Hidden
			    Start    Add via Root
			0 1 Semantic "5" Root:'5'
			1 1 Hidden   " " Whitespace:TerminalRule'WS'
			    Start    left=Named'a' via Expression:{Add.left=}
			2 1 Semantic "a" Primary:name=ID
			    End      left=Named'a' via Expression:{Add.left=}
			3 1 Hidden   " " Whitespace:TerminalRule'WS'
			4 1 Semantic "+" Expression:'+'
			5 1 Hidden   " " Whitespace:TerminalRule'WS'
			    Start    right=Named'b' via Expression:right=Primary
			6 1 Semantic "b" Primary:name=ID
			    End      right=Named'b' via Expression:right=Primary
			    End      Add via Root
			7 0 Hidden
		'''
	}
	
	@Test def void testExpression2() {
		'''
			5 (a + b) + c
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    Add via Root
			 0 1 Semantic "5" Root:'5'
			 1 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    left=Add via Expression:{Add.left=}
			 2 1 Semantic "(" Parenthesized:'('
			 3 0 Hidden
			     Start    left=Named'a' via Expression:{Add.left=}
			 3 1 Semantic "a" Primary:name=ID
			     End      left=Named'a' via Expression:{Add.left=}
			 4 1 Hidden   " " Whitespace:TerminalRule'WS'
			 5 1 Semantic "+" Expression:'+'
			 6 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    right=Named'b' via Expression:right=Primary
			 7 1 Semantic "b" Primary:name=ID
			     End      right=Named'b' via Expression:right=Primary
			 8 0 Hidden
			 8 1 Semantic ")" Parenthesized:')'
			     End      left=Add via Expression:{Add.left=}
			 9 1 Hidden   " " Whitespace:TerminalRule'WS'
			10 1 Semantic "+" Expression:'+'
			11 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    right=Named'c' via Expression:right=Primary
			12 1 Semantic "c" Primary:name=ID
			     End      right=Named'c' via Expression:right=Primary
			     End      Add via Root
			13 0 Hidden
		'''
	}
	
	@Test def void testMixedUnassignedTerminal() {
		'''
			6 (unassigned foo)
		'''.toString.trim === '''
			 0  0 Hidden
			      Start    Action via Root
			 0  1 Semantic "6" Root:'6'
			 1  1 Hidden   " " Whitespace:TerminalRule'WS'
			 2  1 Semantic "(" Mixed:'('
			 3  0 Hidden
			 3 10 Semantic "unassigned" Mixed:'unassigned'
			13  1 Hidden   " " Whitespace:TerminalRule'WS'
			14  3 Semantic "foo" Mixed:ID
			17  0 Hidden
			17  1 Semantic ")" Mixed:')'
			      End      Action via Root
			18  0 Hidden
		'''
	}
	
	@Test def void testMixedUnassignedDatatype1() {
		'''
			6 (unassigned datatype foo)
		'''.toString.trim === '''
			 0  0 Hidden
			      Start    Action via Root
			 0  1 Semantic "6" Root:'6'
			 1  1 Hidden   " " Whitespace:TerminalRule'WS'
			 2  1 Semantic "(" Mixed:'('
			 3  0 Hidden
			 3 10 Semantic "unassigned" Mixed:'unassigned'
			13  1 Hidden   " " Whitespace:TerminalRule'WS'
			14 12 Semantic "datatyp..." Mixed:Datatype
			26  0 Hidden
			26  1 Semantic ")" Mixed:')'
			      End      Action via Root
			27  0 Hidden
		'''
	}
	
	@Test def void testMixedUnassignedDatatype2() {
		'''
			6 (unassigned datatype datatype foo)
		'''.toString.trim === '''
			 0  0 Hidden
			      Start    Action via Root
			 0  1 Semantic "6" Root:'6'
			 1  1 Hidden   " " Whitespace:TerminalRule'WS'
			 2  1 Semantic "(" Mixed:'('
			 3  0 Hidden
			 3 10 Semantic "unassigned" Mixed:'unassigned'
			13  1 Hidden   " " Whitespace:TerminalRule'WS'
			14 21 Semantic "datatyp..." Mixed:Datatype
			35  0 Hidden
			35  1 Semantic ")" Mixed:')'
			      End      Action via Root
			36  0 Hidden
		'''
	}
	
	@Test def void testAction() {
		'''
			6 ()
		'''.toString.trim === '''
			0 0 Hidden
			    Start    Action via Root
			0 1 Semantic "6" Root:'6'
			1 1 Hidden   " " Whitespace:TerminalRule'WS'
			2 1 Semantic "(" Mixed:'('
			3 0 Hidden
			3 1 Semantic ")" Mixed:')'
			    End      Action via Root
			4 0 Hidden
		'''
	}
	
	@Test def void testActionDelegate() {
		'''
			6 (())
		'''.toString.trim === '''
			0 0 Hidden
			    Start    Action via Root
			0 1 Semantic "6" Root:'6'
			1 1 Hidden   " " Whitespace:TerminalRule'WS'
			2 1 Semantic "(" Mixed:'('
			3 0 Hidden
			3 1 Semantic "(" Mixed:'('
			4 0 Hidden
			4 1 Semantic ")" Mixed:')'
			5 0 Hidden
			5 1 Semantic ")" Mixed:')'
			    End      Action via Root
			6 0 Hidden
		'''
	}
	
	@Test def void testActionDelegate2() {
		'''
			6 ((()))
		'''.toString.trim === '''
			0 0 Hidden
			    Start    Action via Root
			0 1 Semantic "6" Root:'6'
			1 1 Hidden   " " Whitespace:TerminalRule'WS'
			2 1 Semantic "(" Mixed:'('
			3 0 Hidden
			3 1 Semantic "(" Mixed:'('
			4 0 Hidden
			4 1 Semantic "(" Mixed:'('
			5 0 Hidden
			5 1 Semantic ")" Mixed:')'
			6 0 Hidden
			6 1 Semantic ")" Mixed:')'
			7 0 Hidden
			7 1 Semantic ")" Mixed:')'
			    End      Action via Root
			8 0 Hidden
		'''
	}
	
	@Test def void testAssignmentDelegate2() {
		'''
			6 (((foo)))
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    Mixed'foo' via Root
			 0 1 Semantic "6" Root:'6'
			 1 1 Hidden   " " Whitespace:TerminalRule'WS'
			 2 1 Semantic "(" Mixed:'('
			 3 0 Hidden
			 3 1 Semantic "(" Mixed:'('
			 4 0 Hidden
			 4 1 Semantic "(" Mixed:'('
			 5 0 Hidden
			 5 3 Semantic "foo" Mixed:name=ID
			 8 0 Hidden
			 8 1 Semantic ")" Mixed:')'
			 9 0 Hidden
			 9 1 Semantic ")" Mixed:')'
			10 0 Hidden
			10 1 Semantic ")" Mixed:')'
			     End      Mixed'foo' via Root
			11 0 Hidden
		'''
	}
	
	@Test def void testAssignmentChildDelegate2() {
		'''
			6 (child(((foo))))
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    Mixed via Root
			 0 1 Semantic "6" Root:'6'
			 1 1 Hidden   " " Whitespace:TerminalRule'WS'
			 2 1 Semantic "(" Mixed:'('
			 3 0 Hidden
			 3 5 Semantic "child" Mixed:'child'
			 8 0 Hidden
			     Start    eobj=Mixed'foo' via Mixed:eobj=Mixed
			 8 1 Semantic "(" Mixed:'('
			 9 0 Hidden
			 9 1 Semantic "(" Mixed:'('
			10 0 Hidden
			10 1 Semantic "(" Mixed:'('
			11 0 Hidden
			11 3 Semantic "foo" Mixed:name=ID
			14 0 Hidden
			14 1 Semantic ")" Mixed:')'
			15 0 Hidden
			15 1 Semantic ")" Mixed:')'
			16 0 Hidden
			16 1 Semantic ")" Mixed:')'
			     End      eobj=Mixed'foo' via Mixed:eobj=Mixed
			17 0 Hidden
			17 1 Semantic ")" Mixed:')'
			     End      Mixed via Root
			18 0 Hidden
		'''
	}
	
	@Test def void testAssignedDatatype() {
		'''
			6 (datatype foo)
		'''.toString.trim === '''
			 0  0 Hidden
			      Start    Mixed via Root
			 0  1 Semantic "6" Root:'6'
			 1  1 Hidden   " " Whitespace:TerminalRule'WS'
			 2  1 Semantic "(" Mixed:'('
			 3  0 Hidden
			 3 12 Semantic "datatyp..." Mixed:datatype=Datatype
			15  0 Hidden
			15  1 Semantic ")" Mixed:')'
			      End      Mixed via Root
			16  0 Hidden
		'''
	}
	
	@Test def void testAssignedDatatype2() {
		'''
			6 (datatype datatype foo)
		'''.toString.trim === '''
			 0  0 Hidden
			      Start    Mixed via Root
			 0  1 Semantic "6" Root:'6'
			 1  1 Hidden   " " Whitespace:TerminalRule'WS'
			 2  1 Semantic "(" Mixed:'('
			 3  0 Hidden
			 3 21 Semantic "datatyp..." Mixed:datatype=Datatype
			24  0 Hidden
			24  1 Semantic ")" Mixed:')'
			      End      Mixed via Root
			25  0 Hidden
		'''
	}
	
	@Test def void testRef() {
		'''
			6 (foo) action (ref foo) end
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    AssignedAction via Root
			 0 1 Semantic "6" Root:'6'
			 1 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    child=Mixed'foo' via Mixed:{AssignedAction.child=}
			 2 1 Semantic "(" Mixed:'('
			 3 0 Hidden
			 3 3 Semantic "foo" Mixed:name=ID
			 6 0 Hidden
			 6 1 Semantic ")" Mixed:')'
			     End      child=Mixed'foo' via Mixed:{AssignedAction.child=}
			 7 1 Hidden   " " Whitespace:TerminalRule'WS'
			 8 6 Semantic "action" Mixed:'action'
			14 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    body=Mixed via Mixed:body=Mixed
			15 1 Semantic "(" Mixed:'('
			16 0 Hidden
			16 3 Semantic "ref" Mixed:'ref'
			19 1 Hidden   " " Whitespace:TerminalRule'WS'
			20 3 Semantic "foo" Mixed:ref=[Mixed|ID]
			23 0 Hidden
			23 1 Semantic ")" Mixed:')'
			     End      body=Mixed via Mixed:body=Mixed
			24 1 Hidden   " " Whitespace:TerminalRule'WS'
			25 3 Semantic "end" Mixed:'end'
			     End      AssignedAction via Root
			28 0 Hidden
		'''
	}
	
	@Test def void testEnum() {
		'''
			6 (lit1)
		'''.toString.trim === '''
			0 0 Hidden
			    Start    Mixed via Root
			0 1 Semantic "6" Root:'6'
			1 1 Hidden   " " Whitespace:TerminalRule'WS'
			2 1 Semantic "(" Mixed:'('
			3 0 Hidden
			3 4 Semantic "lit1" Mixed:lit=Enum
			7 0 Hidden
			7 1 Semantic ")" Mixed:')'
			    End      Mixed via Root
			8 0 Hidden
		'''
	}
	
	@Test def void testAssignmentAction() {
		'''
			6 (foo) action
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    AssignedAction via Root
			 0 1 Semantic "6" Root:'6'
			 1 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    child=Mixed'foo' via Mixed:{AssignedAction.child=}
			 2 1 Semantic "(" Mixed:'('
			 3 0 Hidden
			 3 3 Semantic "foo" Mixed:name=ID
			 6 0 Hidden
			 6 1 Semantic ")" Mixed:')'
			     End      child=Mixed'foo' via Mixed:{AssignedAction.child=}
			 7 1 Hidden   " " Whitespace:TerminalRule'WS'
			 8 6 Semantic "action" Mixed:'action'
			     End      AssignedAction via Root
			14 0 Hidden
		'''
	}
	
	@Test def void testAssignmentActionAction() {
		'''
			6 (foo) action action
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    AssignedAction via Root
			 0 1 Semantic "6" Root:'6'
			 1 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    child=AssignedAction via Mixed:{AssignedAction.child=}
			     Start    child=Mixed'foo' via Mixed:{AssignedAction.child=}
			 2 1 Semantic "(" Mixed:'('
			 3 0 Hidden
			 3 3 Semantic "foo" Mixed:name=ID
			 6 0 Hidden
			 6 1 Semantic ")" Mixed:')'
			     End      child=Mixed'foo' via Mixed:{AssignedAction.child=}
			 7 1 Hidden   " " Whitespace:TerminalRule'WS'
			 8 6 Semantic "action" Mixed:'action'
			     End      child=AssignedAction via Mixed:{AssignedAction.child=}
			14 1 Hidden   " " Whitespace:TerminalRule'WS'
			15 6 Semantic "action" Mixed:'action'
			     End      AssignedAction via Root
			21 0 Hidden
		'''
	}
	
	@Test def void testActionActionAction() {
		'''
			6 () action action
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    AssignedAction via Root
			 0 1 Semantic "6" Root:'6'
			 1 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    child=AssignedAction via Mixed:{AssignedAction.child=}
			     Start    child=Action via Mixed:{AssignedAction.child=}
			 2 1 Semantic "(" Mixed:'('
			 3 0 Hidden
			 3 1 Semantic ")" Mixed:')'
			     End      child=Action via Mixed:{AssignedAction.child=}
			 4 1 Hidden   " " Whitespace:TerminalRule'WS'
			 5 6 Semantic "action" Mixed:'action'
			     End      child=AssignedAction via Mixed:{AssignedAction.child=}
			11 1 Hidden   " " Whitespace:TerminalRule'WS'
			12 6 Semantic "action" Mixed:'action'
			     End      AssignedAction via Root
			18 0 Hidden
		'''
	}
	
	private def ===(CharSequence file, CharSequence expectation) {
		val exp = expectation.toString
		val obj = parseHelper.parse(file)
		validationTestHelper.assertNoErrors(obj)
		val access1 = obj.createFromNodeModel
		val access2 = obj.serializeToRegions
		Assert.assertEquals(exp, new TextRegionAccessToString().withRegionAccess(access1).hideColumnExplanation() + "\n")
		Assert.assertEquals(exp, new TextRegionAccessToString().withRegionAccess(access2).hideColumnExplanation() + "\n")
	}

	private def createFromNodeModel(EObject obj) {
		textRegionAccessBuilder.get.forNodeModel(obj.eResource as XtextResource).create
	}

}


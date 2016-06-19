/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.inject.Inject
import javax.inject.Provider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.serializer.impl.Serializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider)
@RunWith(XtextRunner)
class RegionAccessBuilderTest {
	@Inject ParseHelper<Root> parseHelper
	@Inject Provider<TextRegionAccessBuilder> textRegionAccessBuilder
	@Inject ValidationTestHelper validationTestHelper
	@Inject extension Serializer serializer

	@Test def void testSimple() {
		'''
			1 foo
		'''.toString.trim === '''
			0 0 H
			    B Simple'foo' Root
			0 1  S "1"        Simple:'1'
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 3  S "foo"      Simple:name=ID
			    E Simple'foo' Root
			5 0 H
		'''
	}
	
	@Test def void testMultiWhitespace() {
		'''
			1 /**/ foo
		'''.toString.trim === '''
			 0 0 H
			     B Simple'foo' Root
			 0 1  S "1"        Simple:'1'
			 1    H " "        Whitespace:TerminalRule'WS'
			        "/**/"     Comment:TerminalRule'ML_COMMENT'
			   6    " "        Whitespace:TerminalRule'WS'
			 7 3  S "foo"      Simple:name=ID
			     E Simple'foo' Root
			10 0 H
		'''
	}

	@Test def void testAssignedDelegate() {
		'''
			2 foo
		'''.toString.trim === '''
			0 0 H
			    B Delegation Root
			0 1  S "2"        Delegation:'2'
			1 1  H " "        Whitespace:TerminalRule'WS'
			     B Delegate'foo' Delegation:delegate=Delegate path:Delegation/delegate
			2 3   S "foo"      Delegate:name=ID
			     E Delegate'foo' Delegation:delegate=Delegate path:Delegation/delegate
			    E Delegation Root
			5 0 H
		'''
	}

	@Test def void testUnassignedDelegate() {
		'''
			3 foo
		'''.toString.trim === '''
			0 0 H
			    B Delegate'foo' Root
			0 1  S "3"        Unassigned:'3'
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 3  S "foo"      Delegate:name=ID
			    E Delegate'foo' Root
			5 0 H
		'''
	}

	@Test def void testUnassignedPrefixedDelegate() {
		'''
			4 prefix foo
		'''.toString.trim === '''
			 0 0 H
			     B PrefixedUnassigned Root
			 0 1  S "4"        PrefixedUnassigned:'4'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			      B Delegate'foo' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate
			 2 6   S "prefix"   PrefixedDelegate:'prefix'
			 8 1   H " "        Whitespace:TerminalRule'WS'
			 9 3   S "foo"      Delegate:name=ID
			      E Delegate'foo' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate
			     E PrefixedUnassigned Root
			12 0 H
		'''
	}

	@Test def void testExpression1() {
		'''
			5 a + b
		'''.toString.trim === '''
			0 0 H
			    B Add        Root
			0 1  S "5"        Root:'5'
			1 1  H " "        Whitespace:TerminalRule'WS'
			     B Named'a'   Expression:{Add.left=} path:Add/left
			2 1   S "a"        Primary:name=ID
			     E Named'a'   Expression:{Add.left=} path:Add/left
			3 1  H " "        Whitespace:TerminalRule'WS'
			4 1  S "+"        Expression:'+'
			5 1  H " "        Whitespace:TerminalRule'WS'
			     B Named'b'   Expression:right=Primary path:Add/right
			6 1   S "b"        Primary:name=ID
			     E Named'b'   Expression:right=Primary path:Add/right
			    E Add        Root
			7 0 H
		'''
	}

	@Test def void testExpression2() {
		'''
			5 (a + b) + c
		'''.toString.trim === '''
			 0 0 H
			     B Add        Root
			 0 1  S "5"        Root:'5'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			      B Add        Expression:{Add.left=} path:Add/left
			 2 1   S "("        Parenthesized:'('
			 3 0   H
			       B Named'a'   Expression:{Add.left=} path:Add/left=Add/left
			 3 1    S "a"        Primary:name=ID
			       E Named'a'   Expression:{Add.left=} path:Add/left=Add/left
			 4 1   H " "        Whitespace:TerminalRule'WS'
			 5 1   S "+"        Expression:'+'
			 6 1   H " "        Whitespace:TerminalRule'WS'
			       B Named'b'   Expression:right=Primary path:Add/right=Add/left
			 7 1    S "b"        Primary:name=ID
			       E Named'b'   Expression:right=Primary path:Add/right=Add/left
			 8 0   H
			 8 1   S ")"        Parenthesized:')'
			      E Add        Expression:{Add.left=} path:Add/left
			 9 1  H " "        Whitespace:TerminalRule'WS'
			10 1  S "+"        Expression:'+'
			11 1  H " "        Whitespace:TerminalRule'WS'
			      B Named'c'   Expression:right=Primary path:Add/right
			12 1   S "c"        Primary:name=ID
			      E Named'c'   Expression:right=Primary path:Add/right
			     E Add        Root
			13 0 H
		'''
	}

	@Test def void testMixedUnassignedTerminal() {
		'''
			6 (unassigned foo)
		'''.toString.trim === '''
			 0  0 H
			      B Action     Root
			 0  1  S "6"        Root:'6'
			 1  1  H " "        Whitespace:TerminalRule'WS'
			 2  1  S "("        Mixed:'('
			 3  0  H
			 3 10  S "unass..." Mixed:'unassigned'
			13  1  H " "        Whitespace:TerminalRule'WS'
			14  3  S "foo"      Mixed:ID
			17  0  H
			17  1  S ")"        Mixed:')'
			      E Action     Root
			18  0 H
		'''
	}

	@Test def void testMixedUnassignedDatatype1() {
		'''
			6 (unassigned datatype foo)
		'''.toString.trim === '''
			 0  0 H
			      B Action     Root
			 0  1  S "6"        Root:'6'
			 1  1  H " "        Whitespace:TerminalRule'WS'
			 2  1  S "("        Mixed:'('
			 3  0  H
			 3 10  S "unass..." Mixed:'unassigned'
			13  1  H " "        Whitespace:TerminalRule'WS'
			14 12  S "datat..." Mixed:Datatype
			26  0  H
			26  1  S ")"        Mixed:')'
			      E Action     Root
			27  0 H
		'''
	}

	@Test def void testMixedUnassignedDatatype2() {
		'''
			6 (unassigned datatype datatype foo)
		'''.toString.trim === '''
			 0  0 H
			      B Action     Root
			 0  1  S "6"        Root:'6'
			 1  1  H " "        Whitespace:TerminalRule'WS'
			 2  1  S "("        Mixed:'('
			 3  0  H
			 3 10  S "unass..." Mixed:'unassigned'
			13  1  H " "        Whitespace:TerminalRule'WS'
			14 21  S "datat..." Mixed:Datatype
			35  0  H
			35  1  S ")"        Mixed:')'
			      E Action     Root
			36  0 H
		'''
	}

	@Test def void testAction() {
		'''
			6 ()
		'''.toString.trim === '''
			0 0 H
			    B Action     Root
			0 1  S "6"        Root:'6'
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 1  S "("        Mixed:'('
			3 0  H
			3 1  S ")"        Mixed:')'
			    E Action     Root
			4 0 H
		'''
	}

	@Test def void testActionDelegate() {
		'''
			6 (())
		'''.toString.trim === '''
			0 0 H
			    B Action     Root
			0 1  S "6"        Root:'6'
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 1  S "("        Mixed:'('
			3 0  H
			3 1  S "("        Mixed:'('
			4 0  H
			4 1  S ")"        Mixed:')'
			5 0  H
			5 1  S ")"        Mixed:')'
			    E Action     Root
			6 0 H
		'''
	}

	@Test def void testActionDelegate2() {
		'''
			6 ((()))
		'''.toString.trim === '''
			0 0 H
			    B Action     Root
			0 1  S "6"        Root:'6'
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 1  S "("        Mixed:'('
			3 0  H
			3 1  S "("        Mixed:'('
			4 0  H
			4 1  S "("        Mixed:'('
			5 0  H
			5 1  S ")"        Mixed:')'
			6 0  H
			6 1  S ")"        Mixed:')'
			7 0  H
			7 1  S ")"        Mixed:')'
			    E Action     Root
			8 0 H
		'''
	}

	@Test def void testAssignmentDelegate2() {
		'''
			6 (((foo)))
		'''.toString.trim === '''
			 0 0 H
			     B Mixed'foo' Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			 2 1  S "("        Mixed:'('
			 3 0  H
			 3 1  S "("        Mixed:'('
			 4 0  H
			 4 1  S "("        Mixed:'('
			 5 0  H
			 5 3  S "foo"      Mixed:name=ID
			 8 0  H
			 8 1  S ")"        Mixed:')'
			 9 0  H
			 9 1  S ")"        Mixed:')'
			10 0  H
			10 1  S ")"        Mixed:')'
			     E Mixed'foo' Root
			11 0 H
		'''
	}

	@Test def void testAssignmentChildDelegate2() {
		'''
			6 (child(((foo))))
		'''.toString.trim === '''
			 0 0 H
			     B Mixed      Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			 2 1  S "("        Mixed:'('
			 3 0  H
			 3 5  S "child"    Mixed:'child'
			 8 0  H
			      B Mixed'foo' Mixed:eobj=Mixed path:Mixed/eobj
			 8 1   S "("        Mixed:'('
			 9 0   H
			 9 1   S "("        Mixed:'('
			10 0   H
			10 1   S "("        Mixed:'('
			11 0   H
			11 3   S "foo"      Mixed:name=ID
			14 0   H
			14 1   S ")"        Mixed:')'
			15 0   H
			15 1   S ")"        Mixed:')'
			16 0   H
			16 1   S ")"        Mixed:')'
			      E Mixed'foo' Mixed:eobj=Mixed path:Mixed/eobj
			17 0  H
			17 1  S ")"        Mixed:')'
			     E Mixed      Root
			18 0 H
		'''
	}

	@Test def void testAssignedDatatype() {
		'''
			6 (datatype foo)
		'''.toString.trim === '''
			 0  0 H
			      B Mixed      Root
			 0  1  S "6"        Root:'6'
			 1  1  H " "        Whitespace:TerminalRule'WS'
			 2  1  S "("        Mixed:'('
			 3  0  H
			 3 12  S "datat..." Mixed:datatype=Datatype
			15  0  H
			15  1  S ")"        Mixed:')'
			      E Mixed      Root
			16  0 H
		'''
	}

	@Test def void testAssignedDatatype2() {
		'''
			6 (datatype datatype foo)
		'''.toString.trim === '''
			 0  0 H
			      B Mixed      Root
			 0  1  S "6"        Root:'6'
			 1  1  H " "        Whitespace:TerminalRule'WS'
			 2  1  S "("        Mixed:'('
			 3  0  H
			 3 21  S "datat..." Mixed:datatype=Datatype
			24  0  H
			24  1  S ")"        Mixed:')'
			      E Mixed      Root
			25  0 H
		'''
	}

	@Test def void testRef() {
		'''
			6 (foo) action (ref foo) end
		'''.toString.trim === '''
			 0 0 H
			     B AssignedAction Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			      B Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child
			 2 1   S "("        Mixed:'('
			 3 0   H
			 3 3   S "foo"      Mixed:name=ID
			 6 0   H
			 6 1   S ")"        Mixed:')'
			      E Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child
			 7 1  H " "        Whitespace:TerminalRule'WS'
			 8 6  S "action"   Mixed:'action'
			14 1  H " "        Whitespace:TerminalRule'WS'
			      B Mixed      Mixed:body=Mixed path:AssignedAction/body
			15 1   S "("        Mixed:'('
			16 0   H
			16 3   S "ref"      Mixed:'ref'
			19 1   H " "        Whitespace:TerminalRule'WS'
			20 3   S "foo"      Mixed:ref=[Mixed|ID]
			23 0   H
			23 1   S ")"        Mixed:')'
			      E Mixed      Mixed:body=Mixed path:AssignedAction/body
			24 1  H " "        Whitespace:TerminalRule'WS'
			25 3  S "end"      Mixed:'end'
			     E AssignedAction Root
			28 0 H
		'''
	}

	@Test def void testEnum() {
		'''
			6 (lit1)
		'''.toString.trim === '''
			0 0 H
			    B Mixed      Root
			0 1  S "6"        Root:'6'
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 1  S "("        Mixed:'('
			3 0  H
			3 4  S "lit1"     Mixed:lit=Enum
			7 0  H
			7 1  S ")"        Mixed:')'
			    E Mixed      Root
			8 0 H
		'''
	}

	@Test def void testAssignmentAction() {
		'''
			6 (foo) action
		'''.toString.trim === '''
			 0 0 H
			     B AssignedAction Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			      B Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child
			 2 1   S "("        Mixed:'('
			 3 0   H
			 3 3   S "foo"      Mixed:name=ID
			 6 0   H
			 6 1   S ")"        Mixed:')'
			      E Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child
			 7 1  H " "        Whitespace:TerminalRule'WS'
			 8 6  S "action"   Mixed:'action'
			     E AssignedAction Root
			14 0 H
		'''
	}

	@Test def void testAssignmentActionAction() {
		'''
			6 (foo) action action
		'''.toString.trim === '''
			 0 0 H
			     B AssignedAction Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			      B AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child
			       B Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child
			 2 1    S "("        Mixed:'('
			 3 0    H
			 3 3    S "foo"      Mixed:name=ID
			 6 0    H
			 6 1    S ")"        Mixed:')'
			       E Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child
			 7 1   H " "        Whitespace:TerminalRule'WS'
			 8 6   S "action"   Mixed:'action'
			      E AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child
			14 1  H " "        Whitespace:TerminalRule'WS'
			15 6  S "action"   Mixed:'action'
			     E AssignedAction Root
			21 0 H
		'''
	}

	@Test def void testActionActionAction() {
		'''
			6 () action action
		'''.toString.trim === '''
			 0 0 H
			     B AssignedAction Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			      B AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child
			       B Action     Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child
			 2 1    S "("        Mixed:'('
			 3 0    H
			 3 1    S ")"        Mixed:')'
			       E Action     Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child
			 4 1   H " "        Whitespace:TerminalRule'WS'
			 5 6   S "action"   Mixed:'action'
			      E AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child
			11 1  H " "        Whitespace:TerminalRule'WS'
			12 6  S "action"   Mixed:'action'
			     E AssignedAction Root
			18 0 H
		'''
	}
	
	@Test def void testFragmentID() {
		'''
			6 (fragment foo)
		'''.toString.trim === '''
			 0 0 H
			     B Action     Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			 2 1  S "("        Mixed:'('
			 3 0  H
			 3 8  S "fragment" Mixed:'fragment'
			11 1  H " "        Whitespace:TerminalRule'WS'
			12 3  S "foo"      Fragment:fragName=ID
			15 0  H
			15 1  S ")"        Mixed:')'
			     E Action     Root
			16 0 H
		'''
	}
	
	@Test def void testFragmentRecursionID() {
		'''
			6 (fragment recursion foo)
		'''.toString.trim === '''
			 0 0 H
			     B Action     Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			 2 1  S "("        Mixed:'('
			 3 0  H
			 3 8  S "fragment" Mixed:'fragment'
			11 1  H " "        Whitespace:TerminalRule'WS'
			12 9  S "recur..." Fragment:'recursion'
			21 1  H " "        Whitespace:TerminalRule'WS'
			22 3  S "foo"      Fragment:fragName=ID
			25 0  H
			25 1  S ")"        Mixed:')'
			     E Action     Root
			26 0 H
		'''
	}
	
	@Test def void testFragmentChildAction() {
		'''
			6 (fragment child ())
		'''.toString.trim === '''
			 0 0 H
			     B Action     Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			 2 1  S "("        Mixed:'('
			 3 0  H
			 3 8  S "fragment" Mixed:'fragment'
			11 1  H " "        Whitespace:TerminalRule'WS'
			12 5  S "child"    Fragment:'child'
			17 1  H " "        Whitespace:TerminalRule'WS'
			      B Action     Fragment:mixed=Mixed path:Action/mixed
			18 1   S "("        Mixed:'('
			19 0   H
			19 1   S ")"        Mixed:')'
			      E Action     Fragment:mixed=Mixed path:Action/mixed
			20 0  H
			20 1  S ")"        Mixed:')'
			     E Action     Root
			21 0 H
		'''
	}
	
	@Test def void testFragmentChildID() {
		'''
			6 (fragment child (foo))
		'''.toString.trim === '''
			 0 0 H
			     B Action     Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			 2 1  S "("        Mixed:'('
			 3 0  H
			 3 8  S "fragment" Mixed:'fragment'
			11 1  H " "        Whitespace:TerminalRule'WS'
			12 5  S "child"    Fragment:'child'
			17 1  H " "        Whitespace:TerminalRule'WS'
			      B Mixed'foo' Fragment:mixed=Mixed path:Action/mixed
			18 1   S "("        Mixed:'('
			19 0   H
			19 3   S "foo"      Mixed:name=ID
			22 0   H
			22 1   S ")"        Mixed:')'
			      E Mixed'foo' Fragment:mixed=Mixed path:Action/mixed
			23 0  H
			23 1  S ")"        Mixed:')'
			     E Action     Root
			24 0 H
		'''
	}
	
	@Test def void testFragmentRecursionChild() {
		'''
			6 (fragment recursion child ())
		'''.toString.trim === '''
			 0 0 H
			     B Action     Root
			 0 1  S "6"        Root:'6'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			 2 1  S "("        Mixed:'('
			 3 0  H
			 3 8  S "fragment" Mixed:'fragment'
			11 1  H " "        Whitespace:TerminalRule'WS'
			12 9  S "recur..." Fragment:'recursion'
			21 1  H " "        Whitespace:TerminalRule'WS'
			22 5  S "child"    Fragment:'child'
			27 1  H " "        Whitespace:TerminalRule'WS'
			      B Action     Fragment:mixed=Mixed path:Action/mixed
			28 1   S "("        Mixed:'('
			29 0   H
			29 1   S ")"        Mixed:')'
			      E Action     Fragment:mixed=Mixed path:Action/mixed
			30 0  H
			30 1  S ")"        Mixed:')'
			     E Action     Root
			31 0 H
		'''
	}
	
	@Test def void testMixedRootAction() {
		'''
			7 action (foo)
		'''.toString.trim === '''
			 0 0 H
			     B RootAction Root
			 0 1  S "7"        Root:'7'
			 1 1  H " "        Whitespace:TerminalRule'WS'
			 2 6  S "action"   Root:'action'
			 8 1  H " "        Whitespace:TerminalRule'WS'
			      B Mixed'foo' Root:mixed=Mixed path:RootAction/mixed
			 9 1   S "("        Mixed:'('
			10 0   H
			10 3   S "foo"      Mixed:name=ID
			13 0   H
			13 1   S ")"        Mixed:')'
			      E Mixed'foo' Root:mixed=Mixed path:RootAction/mixed
			     E RootAction Root
			14 0 H
		'''
	}

	private def ===(CharSequence file, CharSequence expectation) {
		val exp = expectation.toString
		val obj = parseHelper.parse(file)
		validationTestHelper.assertNoErrors(obj)
		val access1 = obj.createFromNodeModel
		val access2 = obj.serializeToRegions
		Assert.assertEquals(exp, new TextRegionAccessToString().withRegionAccess(access1).cfg() + "\n")
		Assert.assertEquals(exp, new TextRegionAccessToString().withRegionAccess(access2).cfg() + "\n")
	}

	private def TextRegionAccessToString cfg(TextRegionAccessToString toStr) {
		toStr.hideColumnExplanation().withTextWidth(10)
	}

	private def createFromNodeModel(EObject obj) {
		textRegionAccessBuilder.get.forNodeModel(obj.eResource as XtextResource).create
	}

}


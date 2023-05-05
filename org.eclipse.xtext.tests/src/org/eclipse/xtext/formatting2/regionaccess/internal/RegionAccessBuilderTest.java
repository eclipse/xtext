/**
 * Copyright (c) 2014, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.formatting2.regionaccess.internal.tests.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
public class RegionAccessBuilderTest {
	@Inject
	private ParseHelper<Root> parseHelper;

	@Inject
	private Provider<TextRegionAccessBuilder> textRegionAccessBuilder;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Inject
	private Serializer serializer;

	@Test
	public void testSimple() throws Exception {
		String model = "1 foo\n".trim();
		String expectation =
				"0 0 H\n" +
				"    B Simple'foo' Root\n" +
				"0 1  S \"1\"        Simple:'1'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 3  S \"foo\"      Simple:name=ID\n" +
				"    E Simple'foo' Root\n" +
				"5 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testMultiWhitespace1() throws Exception {
		String model = "1 /**/ foo\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Simple'foo' Root\n" +
				" 0 1  S \"1\"        Simple:'1'\n" +
				" 1    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"        \"/**/\"     Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"   6    \" \"        Whitespace:TerminalRule'WS'\n" +
				" 7 3  S \"foo\"      Simple:name=ID\n" +
				"     E Simple'foo' Root\n" +
				"10 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testMultiWhitespace2() throws Exception {
		String model =
				"1\n" +
				"/**/\n" +
				"foo\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Simple'foo' Root\n" +
				" 0 1  S \"1\"        Simple:'1'\n" +
				" 1    H \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/**/\"     Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   6    \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				" 7 3  S \"foo\"      Simple:name=ID\n" +
				"     E Simple'foo' Root\n" +
				"10 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testAssignedDelegate() throws Exception {
		String model = "2 foo\n".trim();
		String expectation =
				"0 0 H\n" +
				"    B Delegation Root\n" +
				"0 1  S \"2\"        Delegation:'2'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"     B Delegate'foo' Delegation:delegate=Delegate path:Delegation/delegate\n" +
				"2 3   S \"foo\"      Delegate:name=ID\n" +
				"     E Delegate'foo' Delegation:delegate=Delegate path:Delegation/delegate\n" +
				"    E Delegation Root\n" +
				"5 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testUnassignedDelegate() throws Exception {
		String model = "3 foo\n".trim();
		String expectation =
				"0 0 H\n" +
				"    B Delegate'foo' Root\n" +
				"0 1  S \"3\"        Unassigned:'3'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 3  S \"foo\"      Delegate:name=ID\n" +
				"    E Delegate'foo' Root\n" +
				"5 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testUnassignedPrefixedDelegate() throws Exception {
		String model = "4 prefix foo\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B PrefixedUnassigned Root\n" +
				" 0 1  S \"4\"        PrefixedUnassigned:'4'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Delegate'foo' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate\n" +
				" 2 6   S \"prefix\"   PrefixedDelegate:'prefix'\n" +
				" 8 1   H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 9 3   S \"foo\"      Delegate:name=ID\n" +
				"      E Delegate'foo' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate\n" +
				"     E PrefixedUnassigned Root\n" +
				"12 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testExpression1() throws Exception {
		String model = "5 a + b\n".trim();
		String expectation =
				"0 0 H\n" +
				"    B Add        Root\n" +
				"0 1  S \"5\"        Root:'5'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"     B Named'a'   Expression:{Add.left=} path:Add/left\n" +
				"2 1   S \"a\"        Primary:name=ID\n" +
				"     E Named'a'   Expression:{Add.left=} path:Add/left\n" +
				"3 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"4 1  S \"+\"        Expression:'+'\n" +
				"5 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"     B Named'b'   Expression:right=Primary path:Add/right\n" +
				"6 1   S \"b\"        Primary:name=ID\n" +
				"     E Named'b'   Expression:right=Primary path:Add/right\n" +
				"    E Add        Root\n" +
				"7 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testExpression2() throws Exception {
		String model = "5 (a + b) + c\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Add        Root\n" +
				" 0 1  S \"5\"        Root:'5'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Add        Expression:{Add.left=} path:Add/left\n" +
				" 2 1   S \"(\"        Parenthesized:'('\n" +
				" 3 0   H\n" +
				"       B Named'a'   Expression:{Add.left=} path:Add/left=Add/left\n" +
				" 3 1    S \"a\"        Primary:name=ID\n" +
				"       E Named'a'   Expression:{Add.left=} path:Add/left=Add/left\n" +
				" 4 1   H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 5 1   S \"+\"        Expression:'+'\n" +
				" 6 1   H \" \"        Whitespace:TerminalRule'WS'\n" +
				"       B Named'b'   Expression:right=Primary path:Add/right=Add/left\n" +
				" 7 1    S \"b\"        Primary:name=ID\n" +
				"       E Named'b'   Expression:right=Primary path:Add/right=Add/left\n" +
				" 8 0   H\n" +
				" 8 1   S \")\"        Parenthesized:')'\n" +
				"      E Add        Expression:{Add.left=} path:Add/left\n" +
				" 9 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"10 1  S \"+\"        Expression:'+'\n" +
				"11 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Named'c'   Expression:right=Primary path:Add/right\n" +
				"12 1   S \"c\"        Primary:name=ID\n" +
				"      E Named'c'   Expression:right=Primary path:Add/right\n" +
				"     E Add        Root\n" +
				"13 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testMixedUnassignedTerminal() throws Exception {
		String model = "6 (unassigned foo)\n".trim();
		String expectation =
				" 0  0 H\n" +
				"      B Action     Root\n" +
				" 0  1  S \"6\"        Root:'6'\n" +
				" 1  1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2  1  S \"(\"        Mixed:'('\n" +
				" 3  0  H\n" +
				" 3 10  S \"unass...\" Mixed:'unassigned'\n" +
				"13  1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"14  3  S \"foo\"      Mixed:ID\n" +
				"17  0  H\n" +
				"17  1  S \")\"        Mixed:')'\n" +
				"      E Action     Root\n" +
				"18  0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testMixedUnassignedDatatype1() throws Exception {
		String model = "6 (unassigned datatype foo)\n".trim();
		String expectation =
				" 0  0 H\n" +
				"      B Action     Root\n" +
				" 0  1  S \"6\"        Root:'6'\n" +
				" 1  1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2  1  S \"(\"        Mixed:'('\n" +
				" 3  0  H\n" +
				" 3 10  S \"unass...\" Mixed:'unassigned'\n" +
				"13  1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"14 12  S \"datat...\" Mixed:Datatype\n" +
				"26  0  H\n" +
				"26  1  S \")\"        Mixed:')'\n" +
				"      E Action     Root\n" +
				"27  0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testMixedUnassignedDatatype2() throws Exception {
		String model = "6 (unassigned datatype datatype foo)\n".trim();
		String expectation =
				" 0  0 H\n" +
				"      B Action     Root\n" +
				" 0  1  S \"6\"        Root:'6'\n" +
				" 1  1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2  1  S \"(\"        Mixed:'('\n" +
				" 3  0  H\n" +
				" 3 10  S \"unass...\" Mixed:'unassigned'\n" +
				"13  1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"14 21  S \"datat...\" Mixed:Datatype\n" +
				"35  0  H\n" +
				"35  1  S \")\"        Mixed:')'\n" +
				"      E Action     Root\n" +
				"36  0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testAction() throws Exception {
		String model = "6 ()\n".trim();
		String expectation =
				"0 0 H\n" +
				"    B Action     Root\n" +
				"0 1  S \"6\"        Root:'6'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 1  S \"(\"        Mixed:'('\n" +
				"3 0  H\n" +
				"3 1  S \")\"        Mixed:')'\n" +
				"    E Action     Root\n" +
				"4 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testActionDelegate() throws Exception {
		String model = "6 (())\n".trim();
		String expectation =
				"0 0 H\n" +
				"    B Action     Root\n" +
				"0 1  S \"6\"        Root:'6'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 1  S \"(\"        Mixed:'('\n" +
				"3 0  H\n" +
				"3 1  S \"(\"        Mixed:'('\n" +
				"4 0  H\n" +
				"4 1  S \")\"        Mixed:')'\n" +
				"5 0  H\n" +
				"5 1  S \")\"        Mixed:')'\n" +
				"    E Action     Root\n" +
				"6 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testActionDelegate2() throws Exception {
		String model = "6 ((()))\n".trim();
		String expectation =
				"0 0 H\n" +
				"    B Action     Root\n" +
				"0 1  S \"6\"        Root:'6'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 1  S \"(\"        Mixed:'('\n" +
				"3 0  H\n" +
				"3 1  S \"(\"        Mixed:'('\n" +
				"4 0  H\n" +
				"4 1  S \"(\"        Mixed:'('\n" +
				"5 0  H\n" +
				"5 1  S \")\"        Mixed:')'\n" +
				"6 0  H\n" +
				"6 1  S \")\"        Mixed:')'\n" +
				"7 0  H\n" +
				"7 1  S \")\"        Mixed:')'\n" +
				"    E Action     Root\n" +
				"8 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testAssignmentDelegate2() throws Exception {
		String model = "6 (((foo)))\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Mixed'foo' Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 1  S \"(\"        Mixed:'('\n" +
				" 3 0  H\n" +
				" 3 1  S \"(\"        Mixed:'('\n" +
				" 4 0  H\n" +
				" 4 1  S \"(\"        Mixed:'('\n" +
				" 5 0  H\n" +
				" 5 3  S \"foo\"      Mixed:name=ID\n" +
				" 8 0  H\n" +
				" 8 1  S \")\"        Mixed:')'\n" +
				" 9 0  H\n" +
				" 9 1  S \")\"        Mixed:')'\n" +
				"10 0  H\n" +
				"10 1  S \")\"        Mixed:')'\n" +
				"     E Mixed'foo' Root\n" +
				"11 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testAssignmentChildDelegate2() throws Exception {
		String model = "6 (child(((foo))))\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Mixed      Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 1  S \"(\"        Mixed:'('\n" +
				" 3 0  H\n" +
				" 3 5  S \"child\"    Mixed:'child'\n" +
				" 8 0  H\n" +
				"      B Mixed'foo' Mixed:eobj=Mixed path:Mixed/eobj\n" +
				" 8 1   S \"(\"        Mixed:'('\n" +
				" 9 0   H\n" +
				" 9 1   S \"(\"        Mixed:'('\n" +
				"10 0   H\n" +
				"10 1   S \"(\"        Mixed:'('\n" +
				"11 0   H\n" +
				"11 3   S \"foo\"      Mixed:name=ID\n" +
				"14 0   H\n" +
				"14 1   S \")\"        Mixed:')'\n" +
				"15 0   H\n" +
				"15 1   S \")\"        Mixed:')'\n" +
				"16 0   H\n" +
				"16 1   S \")\"        Mixed:')'\n" +
				"      E Mixed'foo' Mixed:eobj=Mixed path:Mixed/eobj\n" +
				"17 0  H\n" +
				"17 1  S \")\"        Mixed:')'\n" +
				"     E Mixed      Root\n" +
				"18 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testAssignedDatatype() throws Exception {
		String model = "6 (datatype foo)\n".trim();
		String expectation =
				" 0  0 H\n" +
				"      B Mixed      Root\n" +
				" 0  1  S \"6\"        Root:'6'\n" +
				" 1  1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2  1  S \"(\"        Mixed:'('\n" +
				" 3  0  H\n" +
				" 3 12  S \"datat...\" Mixed:datatype=Datatype\n" +
				"15  0  H\n" +
				"15  1  S \")\"        Mixed:')'\n" +
				"      E Mixed      Root\n" +
				"16  0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testAssignedDatatype2() throws Exception {
		String model = "6 (datatype datatype foo)\n".trim();
		String expectation =
				" 0  0 H\n" +
				"      B Mixed      Root\n" +
				" 0  1  S \"6\"        Root:'6'\n" +
				" 1  1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2  1  S \"(\"        Mixed:'('\n" +
				" 3  0  H\n" +
				" 3 21  S \"datat...\" Mixed:datatype=Datatype\n" +
				"24  0  H\n" +
				"24  1  S \")\"        Mixed:')'\n" +
				"      E Mixed      Root\n" +
				"25  0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testRef() throws Exception {
		String model = "6 (foo) action (ref foo) end\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B AssignedAction Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child\n" +
				" 2 1   S \"(\"        Mixed:'('\n" +
				" 3 0   H\n" +
				" 3 3   S \"foo\"      Mixed:name=ID\n" +
				" 6 0   H\n" +
				" 6 1   S \")\"        Mixed:')'\n" +
				"      E Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child\n" +
				" 7 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 8 6  S \"action\"   Mixed:'action'\n" +
				"14 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Mixed      Mixed:body=Mixed path:AssignedAction/body\n" +
				"15 1   S \"(\"        Mixed:'('\n" +
				"16 0   H\n" +
				"16 3   S \"ref\"      Mixed:'ref'\n" +
				"19 1   H \" \"        Whitespace:TerminalRule'WS'\n" +
				"20 3   S \"foo\"      Mixed:ref=[Mixed|ID]\n" +
				"23 0   H\n" +
				"23 1   S \")\"        Mixed:')'\n" +
				"      E Mixed      Mixed:body=Mixed path:AssignedAction/body\n" +
				"24 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"25 3  S \"end\"      Mixed:'end'\n" +
				"     E AssignedAction Root\n" +
				"28 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testEnum() throws Exception {
		String model = "6 (lit1)\n".trim();
		String expectation =
				"0 0 H\n" +
				"    B Mixed      Root\n" +
				"0 1  S \"6\"        Root:'6'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 1  S \"(\"        Mixed:'('\n" +
				"3 0  H\n" +
				"3 4  S \"lit1\"     Mixed:lit=Enum\n" +
				"7 0  H\n" +
				"7 1  S \")\"        Mixed:')'\n" +
				"    E Mixed      Root\n" +
				"8 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testAssignmentAction() throws Exception {
		String model = "6 (foo) action\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B AssignedAction Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child\n" +
				" 2 1   S \"(\"        Mixed:'('\n" +
				" 3 0   H\n" +
				" 3 3   S \"foo\"      Mixed:name=ID\n" +
				" 6 0   H\n" +
				" 6 1   S \")\"        Mixed:')'\n" +
				"      E Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child\n" +
				" 7 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 8 6  S \"action\"   Mixed:'action'\n" +
				"     E AssignedAction Root\n" +
				"14 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testAssignmentActionAction() throws Exception {
		String model = "6 (foo) action action\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B AssignedAction Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child\n" +
				"       B Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child\n" +
				" 2 1    S \"(\"        Mixed:'('\n" +
				" 3 0    H\n" +
				" 3 3    S \"foo\"      Mixed:name=ID\n" +
				" 6 0    H\n" +
				" 6 1    S \")\"        Mixed:')'\n" +
				"       E Mixed'foo' Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child\n" +
				" 7 1   H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 8 6   S \"action\"   Mixed:'action'\n" +
				"      E AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child\n" +
				"14 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"15 6  S \"action\"   Mixed:'action'\n" +
				"     E AssignedAction Root\n" +
				"21 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testActionActionAction() throws Exception {
		String model = "6 () action action\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B AssignedAction Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child\n" +
				"       B Action     Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child\n" +
				" 2 1    S \"(\"        Mixed:'('\n" +
				" 3 0    H\n" +
				" 3 1    S \")\"        Mixed:')'\n" +
				"       E Action     Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child\n" +
				" 4 1   H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 5 6   S \"action\"   Mixed:'action'\n" +
				"      E AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child\n" +
				"11 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"12 6  S \"action\"   Mixed:'action'\n" +
				"     E AssignedAction Root\n" +
				"18 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testFragmentID() throws Exception {
		String model = "6 (fragment foo)\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Action     Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 1  S \"(\"        Mixed:'('\n" +
				" 3 0  H\n" +
				" 3 8  S \"fragment\" Mixed:'fragment'\n" +
				"11 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"12 3  S \"foo\"      Fragment:fragName=ID\n" +
				"15 0  H\n" +
				"15 1  S \")\"        Mixed:')'\n" +
				"     E Action     Root\n" +
				"16 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testFragmentRecursionID() throws Exception {
		String model = "6 (fragment recursion foo)\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Action     Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 1  S \"(\"        Mixed:'('\n" +
				" 3 0  H\n" +
				" 3 8  S \"fragment\" Mixed:'fragment'\n" +
				"11 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"12 9  S \"recur...\" Fragment:'recursion'\n" +
				"21 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"22 3  S \"foo\"      Fragment:fragName=ID\n" +
				"25 0  H\n" +
				"25 1  S \")\"        Mixed:')'\n" +
				"     E Action     Root\n" +
				"26 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testFragmentChildAction() throws Exception {
		String model = "6 (fragment child ())\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Action     Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 1  S \"(\"        Mixed:'('\n" +
				" 3 0  H\n" +
				" 3 8  S \"fragment\" Mixed:'fragment'\n" +
				"11 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"12 5  S \"child\"    Fragment:'child'\n" +
				"17 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Action     Fragment:mixed=Mixed path:Action/mixed\n" +
				"18 1   S \"(\"        Mixed:'('\n" +
				"19 0   H\n" +
				"19 1   S \")\"        Mixed:')'\n" +
				"      E Action     Fragment:mixed=Mixed path:Action/mixed\n" +
				"20 0  H\n" +
				"20 1  S \")\"        Mixed:')'\n" +
				"     E Action     Root\n" +
				"21 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testFragmentChildID() throws Exception {
		String model = "6 (fragment child (foo))\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Action     Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 1  S \"(\"        Mixed:'('\n" +
				" 3 0  H\n" +
				" 3 8  S \"fragment\" Mixed:'fragment'\n" +
				"11 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"12 5  S \"child\"    Fragment:'child'\n" +
				"17 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Mixed'foo' Fragment:mixed=Mixed path:Action/mixed\n" +
				"18 1   S \"(\"        Mixed:'('\n" +
				"19 0   H\n" +
				"19 3   S \"foo\"      Mixed:name=ID\n" +
				"22 0   H\n" +
				"22 1   S \")\"        Mixed:')'\n" +
				"      E Mixed'foo' Fragment:mixed=Mixed path:Action/mixed\n" +
				"23 0  H\n" +
				"23 1  S \")\"        Mixed:')'\n" +
				"     E Action     Root\n" +
				"24 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testFragmentRecursionChild() throws Exception {
		String model = "6 (fragment recursion child ())\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B Action     Root\n" +
				" 0 1  S \"6\"        Root:'6'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 1  S \"(\"        Mixed:'('\n" +
				" 3 0  H\n" +
				" 3 8  S \"fragment\" Mixed:'fragment'\n" +
				"11 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"12 9  S \"recur...\" Fragment:'recursion'\n" +
				"21 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"22 5  S \"child\"    Fragment:'child'\n" +
				"27 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Action     Fragment:mixed=Mixed path:Action/mixed\n" +
				"28 1   S \"(\"        Mixed:'('\n" +
				"29 0   H\n" +
				"29 1   S \")\"        Mixed:')'\n" +
				"      E Action     Fragment:mixed=Mixed path:Action/mixed\n" +
				"30 0  H\n" +
				"30 1  S \")\"        Mixed:')'\n" +
				"     E Action     Root\n" +
				"31 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testMixedRootAction() throws Exception {
		String model = "7 action (foo)\n".trim();
		String expectation =
				" 0 0 H\n" +
				"     B RootAction Root\n" +
				" 0 1  S \"7\"        Root:'7'\n" +
				" 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 6  S \"action\"   Root:'action'\n" +
				" 8 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"      B Mixed'foo' Root:mixed=Mixed path:RootAction/mixed\n" +
				" 9 1   S \"(\"        Mixed:'('\n" +
				"10 0   H\n" +
				"10 3   S \"foo\"      Mixed:name=ID\n" +
				"13 0   H\n" +
				"13 1   S \")\"        Mixed:')'\n" +
				"      E Mixed'foo' Root:mixed=Mixed path:RootAction/mixed\n" +
				"     E RootAction Root\n" +
				"14 0 H\n";
		assertRegions(model,
				expectation);
	}

	@Test
	public void testComments1() throws Exception {
		String model =
				"/*xxxx*/\n" +
				"8\n" +
				"/*aaaaa*/\n" +
				"c\n" +
				"// last\n".trim();
		String expectation =
				" 0    H \"/*xxxx*/\" Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"    9   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"      B ValueList'[c]' Root\n" +
				" 9  1  S \"8\"        Root:'8'\n" +
				"10     H \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"         \"/*aaa...\" Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   11    \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"21  1  S \"c\"        ValueList:name+=ID\n" +
				"      E ValueList'[c]' Root\n" +
				"22    H \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"    8   \"// last\"  Comment:TerminalRule'SL_COMMENT' Association:CONTAINER\n";
		assertRegions(model,
				expectation);
	}

	private void assertRegions(CharSequence file, CharSequence expectation) throws Exception {
		String exp = expectation.toString();
		Root obj = parseHelper.parse(file);
		validationTestHelper.assertNoErrors(obj);
		ITextRegionAccess access1 = createFromNodeModel(obj);
		ITextRegionAccess access2 = serializer.serializeToRegions(obj);
		assertToStringDoesNotCrash(access1);
		assertToStringDoesNotCrash(access2);
		assertLinesAreConsistent(access1);
		assertLinesAreConsistent(access2);
		String tra1 = cfg(new TextRegionAccessToString().withRegionAccess(access1)) + "\n";
		String tra2 = cfg(new TextRegionAccessToString().withRegionAccess(access2)) + "\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(exp), Strings.toPlatformLineSeparator(tra1));
		Assert.assertEquals(Strings.toPlatformLineSeparator(exp), Strings.toPlatformLineSeparator(tra2));
	}

	private void assertLinesAreConsistent(ITextRegionAccess access) {
		Set<String> lines = Sets.newLinkedHashSet(Lists.transform(access.regionForDocument().getLineRegions(),
				it -> it.getOffset() + ":" + it.getLength()));
		String text = access.regionForDocument().getText();
		for (int i = 0; i < text.length(); i++) {
			ILineRegion line = access.regionForLineAtOffset(i);
			String lineStr = line.getOffset() + ":" + line.getLength();
			Assert.assertTrue(lines.contains(lineStr));
		}
	}

	private void assertToStringDoesNotCrash(ITextRegionAccess access) {
		ISequentialRegion current = access.regionForRootEObject().getPreviousHiddenRegion();
		while (current != null) {
			Assert.assertNotNull(current.toString());
			if (current instanceof IHiddenRegion) {
				current = ((IHiddenRegion) current).getNextSemanticRegion();
			} else if (current instanceof ISemanticRegion) {
				Assert.assertNotNull(((ISemanticRegion) current).getEObjectRegion().toString());
				current = ((ISemanticRegion) current).getNextHiddenRegion();
			}
		}
	}

	private TextRegionAccessToString cfg(TextRegionAccessToString toStr) {
		return toStr.hideColumnExplanation().withTextWidth(10);
	}

	private ITextRegionAccess createFromNodeModel(EObject obj) {
		return textRegionAccessBuilder.get().forNodeModel((XtextResource) obj.eResource()).create();
	}
}

/**
 * Copyright (c) 2017, 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.ValueList;
import org.eclipse.xtext.formatting2.regionaccess.internal.tests.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
public class RegionAccessDiffTest {
	@Inject
	private RegionAccessTestHelper regionAccessTestHelper;

	@Inject
	private Serializer serializer;

	@Test
	public void testEmptyModification() throws Exception {
		String model = "1 foo\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		String expectation1 =
				"0 0 H\n" +
				"    B Simple'foo' Root\n" +
				"0 1  S \"1\"        Simple:'1'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 3  S \"foo\"      Simple:name=ID\n" +
				"    E Simple'foo' Root\n" +
				"5 0 H\n";
		regionAccessTestHelper.assertRegions(access, expectation1);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
		});
		String expectation2 =
				"0 0 H\n" +
				"    B Simple'foo' Root\n" +
				"0 1  S \"1\"        Simple:'1'\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 3  S \"foo\"      Simple:name=ID\n" +
				"    E Simple'foo' Root\n" +
				"5 0 H\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation2);
	}

	@Test
	public void testSingleSemanticToken() throws Exception {
		String model = "1 foo\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ITextRegionExtensions ext = access.getExtensions();
			EObject root = access.regionForRootEObject().getSemanticElement();
			ISemanticRegion foo = ext.allRegionsFor(root)
					.feature(RegionaccesstestlanguagePackage.Literals.SIMPLE__NAME);
			it.replace(foo, "baaar");
		});
		String expectation =
				"0 0   H\n" +
				"      B Simple'foo' Root\n" +
				"0 1    S \"1\"        Simple:'1'\n" +
				"1 1    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 5 1  S \"baaar\"    Simple:name=ID\n" +
				"      E Simple'foo' Root\n" +
				"7 0   H\n" +
				"------------ diff 1 ------------\n" +
				"2 3 S \"foo\"      Simple:name=ID\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testSerializeChildObject() throws Exception {
		String model = "2 foo\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			Delegate child = ((Delegation) access.regionForRootEObject().getSemanticElement()).getDelegate();
			IEObjectRegion childRegion = access.regionForEObject(child);
			child.setName("baaaz");
			ITextRegionAccess textRegions = this.serializer.serializeToRegions(child);
			it.replace(childRegion.getPreviousHiddenRegion(), childRegion.getNextHiddenRegion(), textRegions);
		});
		String expectation =
				"0 0   H\n" +
				"      B Delegation Root\n" +
				"0 1    S \"2\"        Delegation:'2'\n" +
				"1 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"       B Delegate'baaaz' Delegate path:Delegation/delegate\n" +
				"2 5 1   S \"baaaz\"    Delegate:name=ID\n" +
				"       E Delegate'baaaz' Delegate path:Delegation/delegate\n" +
				"      E Delegation Root\n" +
				"7 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 3  S \"foo\"      Delegate:name=ID\n" +
				"5 0  H\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testSerializeRootObject() throws Exception {
		String model = "3 foo\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			IEObjectRegion root = access.regionForRootEObject();
			Delegate rootObj = (Delegate) root.getSemanticElement();
			rootObj.setName("baaaz");
			ITextRegionAccess textRegions = this.serializer.serializeToRegions(rootObj);
			it.replace(root.getPreviousHiddenRegion(), root.getNextHiddenRegion(), textRegions);
		});
		String expectation =
				"0 0 1 H\n" +
				"      B Delegate'baaaz' Root\n" +
				"0 1 1  S \"3\"        Unassigned:'3'\n" +
				"1 1 1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 5 1  S \"baaaz\"    Delegate:name=ID\n" +
				"      E Delegate'baaaz' Root\n" +
				"7 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"0 0 H\n" +
				"0 1 S \"3\"        Unassigned:'3'\n" +
				"1 1 H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 3 S \"foo\"      Delegate:name=ID\n" +
				"5 0 H\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testDeleteOne() throws Exception {
		String model = "4/*1*/prefix/*2*/foo\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ITextRegionExtensions ext = access.getExtensions();
			PrefixedUnassigned rootObj = (PrefixedUnassigned) access.regionForRootEObject().getSemanticElement();
			ISemanticRegion prefix = ext.regionFor(rootObj.getDelegate()).keyword("prefix");
			it.remove(prefix);
		});
		String expectation =
				" 0  0   H\n" +
				"        B PrefixedUnassigned Root\n" +
				" 0  1    S \"4\"        PrefixedUnassigned:'4'\n" +
				" 1    1  H \"/*1*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"   10    \"/*2*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"         B Delegate'foo' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate\n" +
				"11  3     S \"foo\"      Delegate:name=ID\n" +
				"         E Delegate'foo' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate\n" +
				"        E PrefixedUnassigned Root\n" +
				"14  0   H\n" +
				"------------ diff 1 ------------\n" +
				" 1  5 H \"/*1*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				" 6  6 S \"prefix\"   PrefixedDelegate:'prefix'\n" +
				"12  5 H \"/*2*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testDeleteTwo() throws Exception {
		String model = "4/*1*/prefix/*2*/foo/*3*/\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ITextRegionExtensions ext = access.getExtensions();
			PrefixedUnassigned rootObj = (PrefixedUnassigned) access.regionForRootEObject().getSemanticElement();
			ISemanticRegion prefix = ext.regionFor(rootObj.getDelegate()).keyword("prefix");
			ISemanticRegion foo = ext.regionFor(rootObj.getDelegate())
					.feature(RegionaccesstestlanguagePackage.Literals.DELEGATE__NAME);
			it.remove(prefix.getPreviousHiddenRegion(), foo.getNextHiddenRegion());
		});
		String expectation =
				" 0  0   H\n" +
				"        B PrefixedUnassigned Root\n" +
				" 0  1    S \"4\"        PrefixedUnassigned:'4'\n" +
				"        E PrefixedUnassigned Root\n" +
				" 1    1 H \"/*1*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"   10   \"/*3*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"------------ diff 1 ------------\n" +
				" 1  5  H \"/*1*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				" 6  6  S \"prefix\"   PrefixedDelegate:'prefix'\n" +
				"12  5  H \"/*2*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"17  3  S \"foo\"      Delegate:name=ID\n" +
				"20  5  H \"/*3*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testInsertInsertReplace() throws Exception {
		String model = "8 a\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ITextRegionExtensions ext = access.getExtensions();
			ValueList rootObj = (ValueList) access.regionForRootEObject().getSemanticElement();
			ISemanticRegion a = ext.regionFor(rootObj).keyword("8").getNextSemanticRegion();
			it.replace(a.getNextHiddenRegion(), a.getNextHiddenRegion(), a.getPreviousHiddenRegion(),
					a.getNextHiddenRegion());
			it.replace(a.getNextHiddenRegion(), a.getNextHiddenRegion(), a.getPreviousHiddenRegion(),
					a.getNextHiddenRegion());
			it.replace(a, "new");
		});
		String expectation =
				" 0 0   H\n" +
				"       B ValueList'[a]' Root\n" +
				" 0 1    S \"8\"        Root:'8'\n" +
				" 1 1    H \" \"        Whitespace:TerminalRule'WS'\n" +
				" 2 3 2  S \"new\"      ValueList:name+=ID\n" +
				" 5 0 2  H\n" +
				" 5 3 2  S \"new\"      ValueList:name+=ID\n" +
				" 8 0 2  H\n" +
				" 8 3 2  S \"new\"      ValueList:name+=ID\n" +
				"       E ValueList'[a]' Root\n" +
				"11 0 2 H\n" +
				"------------ diff 1 ------------\n" +
				" 2 1 S \"a\"        ValueList:name+=ID\n" +
				"------------ diff 2 ------------\n" +
				" 2 1  S \"a\"        ValueList:name+=ID\n" +
				" 3 0  H\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testInsertReplaceReplace() throws Exception {
		String model = "8 a\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ITextRegionExtensions ext = access.getExtensions();
			ValueList rootObj = (ValueList) access.regionForRootEObject().getSemanticElement();
			ISemanticRegion a = ext.regionFor(rootObj).keyword("8").getNextSemanticRegion();
			it.replace(a, "b");
			it.replace(a, "c");
		});
		String expectation =
				"0 0   H\n" +
				"      B ValueList'[a]' Root\n" +
				"0 1    S \"8\"        Root:'8'\n" +
				"1 1    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 1 1  S \"c\"        ValueList:name+=ID\n" +
				"      E ValueList'[a]' Root\n" +
				"3 0   H\n" +
				"------------ diff 1 ------------\n" +
				"2 1 S \"a\"        ValueList:name+=ID\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testInsertBeforeComment() throws Exception {
		String model = "8\n" +
				"/**/\n" +
				"a b\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ITextRegionExtensions ext = access.getExtensions();
			ValueList rootObj = (ValueList) access.regionForRootEObject().getSemanticElement();
			ISemanticRegion a = ext.regionFor(rootObj).keyword("8").getNextSemanticRegion();
			ISemanticRegion b = a.getNextSemanticRegion();
			it.replace(a.getPreviousHiddenRegion(), a.getPreviousHiddenRegion(), b.getPreviousHiddenRegion(),
					b.getNextHiddenRegion());
		});
		String expectation =
				" 0 0   H\n" +
				"       B ValueList'[a, b]' Root\n" +
				" 0 1    S \"8\"        Root:'8'\n" +
				" 1 1 1  H \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				" 2 1 1  S \"b\"        ValueList:name+=ID\n" +
				" 3   1  H \"/**/\"     Comment:TerminalRule'ML_COMMENT' Association:PREVIOUS\n" +
				"   5    \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				" 8 1    S \"a\"        ValueList:name+=ID\n" +
				" 9 1    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"10 1    S \"b\"        ValueList:name+=ID\n" +
				"       E ValueList'[a, b]' Root\n" +
				"11 0   H\n" +
				"------------ diff 1 ------------\n" +
				" 1   H \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"       \"/**/\"     Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   6   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testMove() throws Exception {
		String model = "8 a b c\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			List<ISemanticRegion> regions = access.regionForRootEObject().getAllRegionsFor()
					.features(RegionaccesstestlanguagePackage.Literals.VALUE_LIST__NAME);
			ISemanticRegion a = regions.get(0);
			ISemanticRegion b = regions.get(1);
			it.move(b.getNextHiddenRegion(), a.getPreviousHiddenRegion(), a.getNextHiddenRegion());
		});
		String expectation =
				"0 0   H\n" +
				"      B ValueList'[a, b, c]' Root\n" +
				"0 1    S \"8\"        Root:'8'\n" +
				"1   1  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"  2    \" \"        Whitespace:TerminalRule'WS'\n" +
				"3 1    S \"b\"        ValueList:name+=ID\n" +
				"4 1 2  H \" \"        Whitespace:TerminalRule'WS'\n" +
				"5 1 2  S \"a\"        ValueList:name+=ID\n" +
				"6 0 2  H\n" +
				"6 1    S \"c\"        ValueList:name+=ID\n" +
				"      E ValueList'[a, b, c]' Root\n" +
				"7 0   H\n" +
				"------------ diff 1 ------------\n" +
				"1 1 H \" \"        Whitespace:TerminalRule'WS'\n" +
				"2 1 S \"a\"        ValueList:name+=ID\n" +
				"3 1 H \" \"        Whitespace:TerminalRule'WS'\n" +
				"------------ diff 2 ------------\n" +
				"5 1 H \" \"        Whitespace:TerminalRule'WS'\n" +
				"6 1 S \"c\"        ValueList:name+=ID\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}
}

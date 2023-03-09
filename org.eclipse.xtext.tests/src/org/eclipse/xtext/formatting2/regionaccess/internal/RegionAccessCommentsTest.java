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

import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.tests.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
public class RegionAccessCommentsTest {
	@Inject
	private RegionAccessTestHelper regionAccessTestHelper;

	@Test
	public void testDeleteFirstRegion1() throws Exception {
		String model =
				"/*h*/\n" +
				"\n" +
				"/*8*/\n" +
				"8 //8\n" +
				"/*a*/\n" +
				"a\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ISemanticRegion foo = access.regionForRootEObject().getAllRegionsFor().keyword("8");
			it.remove(foo);
		});
		String expectation =
				" 0    1 H \"/*h*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\\n" +
				"\"     Whitespace:TerminalRule'WS'\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   13   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        B ValueList'[a]' Root\n" +
				"13  1    S \"a\"        ValueList:name+=ID\n" +
				"        E ValueList'[a]' Root\n" +
				"14  0   H\n" +
				"------------ diff 1 ------------\n" +
				" 0    H \"/*h*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\\n" +
				"\"     Whitespace:TerminalRule'WS'\n" +
				"        \"/*8*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   13   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"13  1 S \"8\"        Root:'8'\n" +
				"14    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"        \"//8\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   11   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testDeleteFirstRegion2() throws Exception {
		String model =
				"/*h*/\n" +
				"\n" +
				"/*81*/\n" +
				"/*82*/\n" +
				"8 //8\n" +
				"/*a*/\n" +
				"a\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ISemanticRegion foo = access.regionForRootEObject().getAllRegionsFor().keyword("8");
			it.remove(foo);
		});
		String expectation =
				" 0    1 H \"/*h*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\\n" +
				"\"     Whitespace:TerminalRule'WS'\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   13   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        B ValueList'[a]' Root\n" +
				"13  1    S \"a\"        ValueList:name+=ID\n" +
				"        E ValueList'[a]' Root\n" +
				"14  0   H\n" +
				"------------ diff 1 ------------\n" +
				" 0    H \"/*h*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\\n" +
				"\"     Whitespace:TerminalRule'WS'\n" +
				"        \"/*81*/\"   Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"        \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/*82*/\"   Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   21   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"21  1 S \"8\"        Root:'8'\n" +
				"22    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"        \"//8\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   11   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testDeleteFirstRegion3() throws Exception {
		String model =
				"/*h*/\n" +
				"/*81*/\n" +
				"\n" +
				"/*82*/\n" +
				"8 //8\n" +
				"/*a*/\n" +
				"a\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ISemanticRegion foo = access.regionForRootEObject().getAllRegionsFor().keyword("8");
			it.remove(foo);
		});
		String expectation =
				" 0    1 H \"/*h*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/*81*/\"   Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\\n" +
				"\"     Whitespace:TerminalRule'WS'\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   20   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        B ValueList'[a]' Root\n" +
				"20  1    S \"a\"        ValueList:name+=ID\n" +
				"        E ValueList'[a]' Root\n" +
				"21  0   H\n" +
				"------------ diff 1 ------------\n" +
				" 0    H \"/*h*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/*81*/\"   Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\\n" +
				"\"     Whitespace:TerminalRule'WS'\n" +
				"        \"/*82*/\"   Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   21   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"21  1 S \"8\"        Root:'8'\n" +
				"22    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"        \"//8\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   11   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testDeleteFirstRegion4() throws Exception {
		String model =
				"/*h*/\n" +
				"/*81*/\n" +
				"/*82*/\n" +
				"\n" +
				"8 //8\n" +
				"/*a*/\n" +
				"a\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ISemanticRegion foo = access.regionForRootEObject().getAllRegionsFor().keyword("8");
			it.remove(foo);
		});
		String expectation =
				" 0    1 H \"/*h*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/*81*/\"   Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/*82*/\"   Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\\n" +
				"\"     Whitespace:TerminalRule'WS'\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   27   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        B ValueList'[a]' Root\n" +
				"27  1    S \"a\"        ValueList:name+=ID\n" +
				"        E ValueList'[a]' Root\n" +
				"28  0   H\n" +
				"------------ diff 1 ------------\n" +
				" 0    H \"/*h*/\"    Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/*81*/\"   Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"        \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/*82*/\"   Comment:TerminalRule'ML_COMMENT' Association:CONTAINER\n" +
				"   21   \"\\n" +
				"\\n" +
				"\"     Whitespace:TerminalRule'WS'\n" +
				"21  1 S \"8\"        Root:'8'\n" +
				"22    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"        \"//8\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   11   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testDeleteMiddleRegion() throws Exception {
		String model =
				"8\n" +
				"a /*a*/ //a\n" +
				"/*b1*/\n" +
				"/*b2*/\n" +
				"b\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			ISemanticRegion foo = Iterables.getFirst(access.regionForRootEObject().getAllRegionsFor()
					.features(RegionaccesstestlanguagePackage.Literals.VALUE_LIST__NAME), null);
			it.remove(foo);
		});
		String expectation =
				" 0  0   H\n" +
				"        B ValueList'[a, b]' Root\n" +
				" 0  1    S \"8\"        Root:'8'\n" +
				" 1    1  H \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"         \"/*b1*/\"   Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"         \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"         \"/*b2*/\"   Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   15    \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"16  1    S \"b\"        ValueList:name+=ID\n" +
				"        E ValueList'[a, b]' Root\n" +
				"17  0   H\n" +
				"------------ diff 1 ------------\n" +
				" 1  1 H \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				" 2  1 S \"a\"        ValueList:name+=ID\n" +
				" 3    H \" \"        Whitespace:TerminalRule'WS'\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:PREVIOUS\n" +
				"        \" \"        Whitespace:TerminalRule'WS'\n" +
				"        \"//a\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"        \"/*b1*/\"   Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"        \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"        \"/*b2*/\"   Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   25   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}

	@Test
	public void testMove() throws Exception {
		String model =
				"8//8\n" +
				"/*a*/\n" +
				"a//a\n" +
				"/*b*/\n" +
				"b//b\n" +
				"/*c*/\n" +
				"c\n";
		ITextRegionAccess access = regionAccessTestHelper.toTextRegionAccess(model);
		ITextRegionAccess modifiedAccess = regionAccessTestHelper.modify(access, (ITextRegionDiffBuilder it) -> {
			List<ISemanticRegion> regions = access.regionForRootEObject().getAllRegionsFor()
					.features(RegionaccesstestlanguagePackage.Literals.VALUE_LIST__NAME);
			ISemanticRegion a = regions.get(0);
			ISemanticRegion b = regions.get(1);
			it.move(b.getNextHiddenRegion(), a.getPreviousHiddenRegion(), a.getNextHiddenRegion());
		});
		String expectation =
				" 0  0   H\n" +
				"        B ValueList'[a, b, c]' Root\n" +
				" 0  1    S \"8\"        Root:'8'\n" +
				" 1    1  H \"//8\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"         \"/*b*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   10    \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"11  1    S \"b\"        ValueList:name+=ID\n" +
				"12    2  H \"//b\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"         \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   10    \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"22  1 2  S \"a\"        ValueList:name+=ID\n" +
				"23    2  H \"//a\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"         \"/*c*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   10    \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"33  1    S \"c\"        ValueList:name+=ID\n" +
				"        E ValueList'[a, b, c]' Root\n" +
				"34  0   H\n" +
				"------------ diff 1 ------------\n" +
				" 1    H \"//8\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"        \"/*a*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   10   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"11  1 S \"a\"        ValueList:name+=ID\n" +
				"12    H \"//a\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"        \"/*b*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   10   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n" +
				"------------ diff 2 ------------\n" +
				"23    H \"//b\\n" +
				"\"    Comment:TerminalRule'SL_COMMENT' Association:PREVIOUS\n" +
				"        \"/*c*/\"    Comment:TerminalRule'ML_COMMENT' Association:NEXT\n" +
				"   10   \"\\n" +
				"\"       Whitespace:TerminalRule'WS'\n";
		regionAccessTestHelper.assertRegions(modifiedAccess, expectation);
	}
}

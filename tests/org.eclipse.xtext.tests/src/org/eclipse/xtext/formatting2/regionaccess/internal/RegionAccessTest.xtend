/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResource
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider)
@RunWith(XtextRunner)
class RegionAccessTest {
	@Inject ParseHelper<Root> parseHelper

	@Test def void testSimple() {
		'''
			test 1 foo
		'''.toString.trim === '''
			00 0 Hidden
			     Start    Simple'foo'
			00 4 Semantic "test" Root:'test'
			04 1 Hidden   " " Whitespace:TerminalRule'WS'
			05 1 Semantic "1" Simple:'1'
			06 1 Hidden   " " Whitespace:TerminalRule'WS'
			07 3 Semantic "foo" Simple:name=ID
			     End      Simple'foo'
			10 0 Hidden
		'''
	}

	@Test def void testAssignedDelegate() {
		'''
			test 2 foo
		'''.toString.trim === '''
			00 0 Hidden
			     Start    Delegation
			00 4 Semantic "test" Root:'test'
			04 1 Hidden   " " Whitespace:TerminalRule'WS'
			05 1 Semantic "2" Delegation:'2'
			06 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    delegate=Delegate'foo'
			07 3 Semantic "foo" Delegate:name=ID
			     End      Delegation, delegate=Delegate'foo'
			10 0 Hidden
		'''
	}

	@Test def void testUnassignedDelegate() {
		'''
			test 3 foo
		'''.toString.trim === '''
			00 0 Hidden
			     Start    Delegate'foo'
			00 4 Semantic "test" Root:'test'
			04 1 Hidden   " " Whitespace:TerminalRule'WS'
			05 1 Semantic "3" Unassigned:'3'
			06 1 Hidden   " " Whitespace:TerminalRule'WS'
			07 3 Semantic "foo" Delegate:name=ID
			     End      Delegate'foo'
			10 0 Hidden
		'''
	}

	@Test def void testUnassignedPrefixedDelegate() {
		'''
			test 4 prefix foo
		'''.toString.trim === '''
			00 0 Hidden
			     Start    PrefixedUnassigned
			00 4 Semantic "test" Root:'test'
			04 1 Hidden   " " Whitespace:TerminalRule'WS'
			05 1 Semantic "4" PrefixedUnassigned:'4'
			06 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    delegate=Delegate'foo'
			07 6 Semantic "prefix" PrefixedDelegate:'prefix'
			13 1 Hidden   " " Whitespace:TerminalRule'WS'
			14 3 Semantic "foo" Delegate:name=ID
			     End      PrefixedUnassigned, delegate=Delegate'foo'
			17 0 Hidden
		'''
	}

	private def ===(CharSequence file, CharSequence expectation) {
		val obj = parseHelper.parse(file)
		val access = new NodeModelBaseRegionAccess.Builder().withResource(obj.eResource as XtextResource).create
		val actual = new TokenAccessToString().withOrigin(access).hideColumnExplanation().toString
		Assert.assertEquals(expectation.toString.trim, actual)
	}
}

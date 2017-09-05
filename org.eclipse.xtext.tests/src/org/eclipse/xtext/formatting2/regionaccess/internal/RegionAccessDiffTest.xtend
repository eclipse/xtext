/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage
import org.eclipse.xtext.formatting2.regionaccess.internal.tests.RegionAccessTestLanguageInjectorProvider
import org.eclipse.xtext.serializer.impl.Serializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.ValueList

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider)
@RunWith(XtextRunner)
class RegionAccessDiffTest {
	@Inject extension RegionAccessTestHelper
	@Inject Serializer serializer

	@Test def void testEmptyModification() {
		val access = '''
			1 foo
		'''.toTextRegionAccess

		access === '''
			0 0 H
			    B Simple'foo' Root
			0 1  S "1"        Simple:'1'
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 3  S "foo"      Simple:name=ID
			    E Simple'foo' Root
			5 0 H
		'''
		access.modify[] === '''
			0 0 H
			    B Simple'foo' Root
			0 1  S "1"        Simple:'1'
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 3  S "foo"      Simple:name=ID
			    E Simple'foo' Root
			5 0 H
		'''
	}

	@Test def void testSingleSemanticToken() {
		val access = '''
			1 foo
		'''.toTextRegionAccess
		access.modify [
			val extension ext = access.extensions
			val root = access.regionForRootEObject.semanticElement
			val foo = root.allRegionsFor.feature(RegionaccesstestlanguagePackage.Literals.SIMPLE__NAME)
			replace(foo, "baaar")
		] === '''
			0 0   H
			      B Simple'foo' Root
			0 1    S "1"        Simple:'1'
			1 1    H " "        Whitespace:TerminalRule'WS'
			2 5 1  S "baaar"    Simple:name=ID
			      E Simple'foo' Root
			7 0   H
			------------ diff 1 ------------
			2 3 S "foo"      Simple:name=ID
		'''
	}

	@Test def void testSerializeChildObject() {
		val access = '''
			2 foo
		'''.toTextRegionAccess
		access.modify [
			val child = (access.regionForRootEObject.semanticElement as Delegation).delegate
			val childRegion = access.regionForEObject(child)
			child.name = "baaaz"
			val textRegions = serializer.serializeToRegions(child)
			replace(childRegion.previousHiddenRegion, childRegion.nextHiddenRegion, textRegions)
		] === '''
			0 0   H
			      B Delegation Root
			0 1    S "2"        Delegation:'2'
			1 1 1  H " "        Whitespace:TerminalRule'WS'
			       B Delegate'baaaz' Delegate path:Delegation/delegate
			2 5 1   S "baaaz"    Delegate:name=ID
			       E Delegate'baaaz' Delegate path:Delegation/delegate
			      E Delegation Root
			7 0 1 H
			------------ diff 1 ------------
			1 1  H " "        Whitespace:TerminalRule'WS'
			2 3  S "foo"      Delegate:name=ID
			5 0  H
		'''
	}

	@Test def void testSerializeRootObject() {
		val access = '''
			3 foo
		'''.toTextRegionAccess
		access.modify [
			val root = access.regionForRootEObject;
			val rootObj = root.semanticElement as Delegate
			rootObj.name = "baaaz"
			val textRegions = serializer.serializeToRegions(rootObj)
			replace(root.previousHiddenRegion, root.nextHiddenRegion, textRegions)
		] === '''
			0 0 1 H
			      B Delegate'baaaz' Root
			0 1 1  S "3"        Unassigned:'3'
			1 1 1  H " "        Whitespace:TerminalRule'WS'
			2 5 1  S "baaaz"    Delegate:name=ID
			      E Delegate'baaaz' Root
			7 0 1 H
			------------ diff 1 ------------
			0 0 H
			0 1 S "3"        Unassigned:'3'
			1 1 H " "        Whitespace:TerminalRule'WS'
			2 3 S "foo"      Delegate:name=ID
			5 0 H
		'''
	}

	@Test def void testDeleteOne() {
		val access = '''
			4/*1*/prefix/*2*/foo
		'''.toTextRegionAccess
		access.modify [
			val extension ext = access.extensions
			val rootObj = access.regionForRootEObject.semanticElement as PrefixedUnassigned
			val prefix = rootObj.delegate.regionFor.keyword("prefix")
			remove(prefix)
		] === '''
			 0  0   H
			        B PrefixedUnassigned Root
			 0  1    S "4"        PrefixedUnassigned:'4'
			 1    1  H "/*1*/"    Comment:TerminalRule'ML_COMMENT'
			   10    "/*2*/"    Comment:TerminalRule'ML_COMMENT'
			         B Delegate'foo' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate
			11  3     S "foo"      Delegate:name=ID
			         E Delegate'foo' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate
			        E PrefixedUnassigned Root
			14  0   H
			------------ diff 1 ------------
			 1  5 H "/*1*/"    Comment:TerminalRule'ML_COMMENT'
			 6  6 S "prefix"   PrefixedDelegate:'prefix'
			12  5 H "/*2*/"    Comment:TerminalRule'ML_COMMENT'
		'''
	}

	@Test def void testDeleteTwo() {
		val access = '''
			4/*1*/prefix/*2*/foo/*3*/
		'''.toTextRegionAccess
		access.modify [
			val extension ext = access.extensions
			val rootObj = access.regionForRootEObject.semanticElement as PrefixedUnassigned
			val prefix = rootObj.delegate.regionFor.keyword("prefix")
			val foo = rootObj.delegate.regionFor.feature(RegionaccesstestlanguagePackage.Literals.DELEGATE__NAME)
			remove(prefix.previousHiddenRegion, foo.nextHiddenRegion)
		] === '''
			 0  0   H
			        B PrefixedUnassigned Root
			 0  1    S "4"        PrefixedUnassigned:'4'
			        E PrefixedUnassigned Root
			 1    1 H "/*1*/"    Comment:TerminalRule'ML_COMMENT'
			   10   "/*3*/"    Comment:TerminalRule'ML_COMMENT'
			------------ diff 1 ------------
			 1  5  H "/*1*/"    Comment:TerminalRule'ML_COMMENT'
			 6  6  S "prefix"   PrefixedDelegate:'prefix'
			12  5  H "/*2*/"    Comment:TerminalRule'ML_COMMENT'
			17  3  S "foo"      Delegate:name=ID
			20  5  H "/*3*/"    Comment:TerminalRule'ML_COMMENT'
		'''
	}
	
	@Test def void testInsertInsertReplace() {
		val access = '''
			8 a
		'''.toTextRegionAccess
		access.modify [
			val extension ext = access.extensions
			val rootObj = access.regionForRootEObject.semanticElement as ValueList
			val a = rootObj.regionFor.keyword("8").nextSemanticRegion
			replace(a.nextHiddenRegion, a.nextHiddenRegion, a.previousHiddenRegion, a.nextHiddenRegion)
			replace(a.nextHiddenRegion, a.nextHiddenRegion, a.previousHiddenRegion, a.nextHiddenRegion)
			replace(a, "new")
		] === '''
			0 0   H
			      B ValueList'[a]' Root
			0 1    S "8"        Root:'8'
			1 1    H " "        Whitespace:TerminalRule'WS'
			2 3 1  S "new"      ValueList:name+=ID
			5 0 2  H
			5 1 2  S "a"        ValueList:name+=ID
			6 0 2  H
			6 1 2  S "a"        ValueList:name+=ID
			      E ValueList'[a]' Root
			7 0 2 H
			------------ diff 1 ------------
			2 1 S "a"        ValueList:name+=ID
			------------ diff 2 ------------
			3 0  H
		'''
	}
	
	@Test def void testInsertReplaceReplace() {
		val access = '''
			8 a
		'''.toTextRegionAccess
		access.modify [
			val extension ext = access.extensions
			val rootObj = access.regionForRootEObject.semanticElement as ValueList
			val a = rootObj.regionFor.keyword("8").nextSemanticRegion
			replace(a, "b")
			replace(a, "c")
		] === '''
			0 0   H
			      B ValueList'[a]' Root
			0 1    S "8"        Root:'8'
			1 1    H " "        Whitespace:TerminalRule'WS'
			2 1 1  S "c"        ValueList:name+=ID
			      E ValueList'[a]' Root
			3 0   H
			------------ diff 1 ------------
			2 1 S "a"        ValueList:name+=ID
		'''
	}

}

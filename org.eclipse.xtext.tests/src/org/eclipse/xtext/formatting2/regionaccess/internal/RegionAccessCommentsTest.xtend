/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage
import org.eclipse.xtext.formatting2.regionaccess.internal.tests.RegionAccessTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider)
@RunWith(XtextRunner)
class RegionAccessCommentsTest {
	@Inject extension RegionAccessTestHelper

	@Test def void testDeleteFirstRegion1() {
		val access = '''
			/*h*/
			/*8*/
			8 //8
			/*a*/
			a
		'''.toTextRegionAccess
		access.modify [
			val foo = access.regionForRootEObject.allRegionsFor.keyword("8")
			remove(foo)
		] === '''
			 0    1 H "/*h*/"    Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   12   "\n"       Whitespace:TerminalRule'WS'
			        B ValueList'[a]' Root
			12  1    S "a"        ValueList:name+=ID
			        E ValueList'[a]' Root
			13  0   H
			------------ diff 1 ------------
			 0    H "/*h*/"    Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*8*/"    Comment:TerminalRule'ML_COMMENT'
			   12   "\n"       Whitespace:TerminalRule'WS'
			12  1 S "8"        Root:'8'
			13    H " "        Whitespace:TerminalRule'WS'
			        "//8\n"    Comment:TerminalRule'SL_COMMENT'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   11   "\n"       Whitespace:TerminalRule'WS'
		'''
	}
	
	@Test def void testDeleteFirstRegion2() {
		val access = '''
			/*h*/
			
			/*81*/
			/*82*/
			8 //8
			/*a*/
			a
		'''.toTextRegionAccess
		access.modify [
			val foo = access.regionForRootEObject.allRegionsFor.keyword("8")
			remove(foo)
		] === '''
			 0    1 H "/*h*/"    Comment:TerminalRule'ML_COMMENT'
			        "\n\n"     Whitespace:TerminalRule'WS'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   13   "\n"       Whitespace:TerminalRule'WS'
			        B ValueList'[a]' Root
			13  1    S "a"        ValueList:name+=ID
			        E ValueList'[a]' Root
			14  0   H
			------------ diff 1 ------------
			 0    H "/*h*/"    Comment:TerminalRule'ML_COMMENT'
			        "\n\n"     Whitespace:TerminalRule'WS'
			        "/*81*/"   Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*82*/"   Comment:TerminalRule'ML_COMMENT'
			   21   "\n"       Whitespace:TerminalRule'WS'
			21  1 S "8"        Root:'8'
			22    H " "        Whitespace:TerminalRule'WS'
			        "//8\n"    Comment:TerminalRule'SL_COMMENT'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   11   "\n"       Whitespace:TerminalRule'WS'
		'''
	}
	
	@Test def void testDeleteFirstRegion3() {
		val access = '''
			/*h*/
			/*81*/

			/*82*/
			8 //8
			/*a*/
			a
		'''.toTextRegionAccess
		access.modify [
			val foo = access.regionForRootEObject.allRegionsFor.keyword("8")
			remove(foo)
		] === '''
			 0    1 H "/*h*/"    Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*81*/"   Comment:TerminalRule'ML_COMMENT'
			        "\n\n"     Whitespace:TerminalRule'WS'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   20   "\n"       Whitespace:TerminalRule'WS'
			        B ValueList'[a]' Root
			20  1    S "a"        ValueList:name+=ID
			        E ValueList'[a]' Root
			21  0   H
			------------ diff 1 ------------
			 0    H "/*h*/"    Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*81*/"   Comment:TerminalRule'ML_COMMENT'
			        "\n\n"     Whitespace:TerminalRule'WS'
			        "/*82*/"   Comment:TerminalRule'ML_COMMENT'
			   21   "\n"       Whitespace:TerminalRule'WS'
			21  1 S "8"        Root:'8'
			22    H " "        Whitespace:TerminalRule'WS'
			        "//8\n"    Comment:TerminalRule'SL_COMMENT'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   11   "\n"       Whitespace:TerminalRule'WS'
		'''
	}
	
	@Test def void testDeleteFirstRegion4() {
		val access = '''
			/*h*/
			/*81*/
			/*82*/

			8 //8
			/*a*/
			a
		'''.toTextRegionAccess
		access.modify [
			val foo = access.regionForRootEObject.allRegionsFor.keyword("8")
			remove(foo)
		] === '''
			 0    1 H "/*h*/"    Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*81*/"   Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*82*/"   Comment:TerminalRule'ML_COMMENT'
			        "\n\n"     Whitespace:TerminalRule'WS'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   27   "\n"       Whitespace:TerminalRule'WS'
			        B ValueList'[a]' Root
			27  1    S "a"        ValueList:name+=ID
			        E ValueList'[a]' Root
			28  0   H
			------------ diff 1 ------------
			 0    H "/*h*/"    Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*81*/"   Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*82*/"   Comment:TerminalRule'ML_COMMENT'
			   21   "\n\n"     Whitespace:TerminalRule'WS'
			21  1 S "8"        Root:'8'
			22    H " "        Whitespace:TerminalRule'WS'
			        "//8\n"    Comment:TerminalRule'SL_COMMENT'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   11   "\n"       Whitespace:TerminalRule'WS'
		'''
	}
	
	@Test def void testDeleteMiddleRegion() {
		val access = '''
			8
			a /*a*/ //a
			/*b1*/
			/*b2*/
			b
		'''.toTextRegionAccess
		access.modify [
			val foo = access.regionForRootEObject.allRegionsFor.features(RegionaccesstestlanguagePackage.Literals.VALUE_LIST__NAME).head
			remove(foo)
		] === '''
			 0  0   H
			        B ValueList'[a, b]' Root
			 0  1    S "8"        Root:'8'
			 1    1  H "\n"       Whitespace:TerminalRule'WS'
			         "/*b1*/"   Comment:TerminalRule'ML_COMMENT'
			         "\n"       Whitespace:TerminalRule'WS'
			         "/*b2*/"   Comment:TerminalRule'ML_COMMENT'
			   15    "\n"       Whitespace:TerminalRule'WS'
			16  1    S "b"        ValueList:name+=ID
			        E ValueList'[a, b]' Root
			17  0   H
			------------ diff 1 ------------
			 1  1 H "\n"       Whitespace:TerminalRule'WS'
			 2  1 S "a"        ValueList:name+=ID
			 3    H " "        Whitespace:TerminalRule'WS'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			        " "        Whitespace:TerminalRule'WS'
			        "//a\n"    Comment:TerminalRule'SL_COMMENT'
			        "/*b1*/"   Comment:TerminalRule'ML_COMMENT'
			        "\n"       Whitespace:TerminalRule'WS'
			        "/*b2*/"   Comment:TerminalRule'ML_COMMENT'
			   25   "\n"       Whitespace:TerminalRule'WS'
		'''
	}

	@Test def void testMove() {
		val access = '''
			8//8
			/*a*/
			a//a
			/*b*/
			b//b
			/*c*/
			c
		'''.toTextRegionAccess
		access.modify [
			val regions = access.regionForRootEObject.allRegionsFor.features(RegionaccesstestlanguagePackage.Literals.VALUE_LIST__NAME)
			val a = regions.get(0)
			val b = regions.get(1)
			move(b.nextHiddenRegion, a.previousHiddenRegion, a.nextHiddenRegion)
		] === '''
			 0  0   H
			        B ValueList'[a, b, c]' Root
			 0  1    S "8"        Root:'8'
			 1    1  H "//8\n"    Comment:TerminalRule'SL_COMMENT'
			         "/*b*/"    Comment:TerminalRule'ML_COMMENT'
			   10    "\n"       Whitespace:TerminalRule'WS'
			11  1    S "b"        ValueList:name+=ID
			12    2  H "//b\n"    Comment:TerminalRule'SL_COMMENT'
			         "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   10    "\n"       Whitespace:TerminalRule'WS'
			22  1 2  S "a"        ValueList:name+=ID
			23    2  H "//a\n"    Comment:TerminalRule'SL_COMMENT'
			         "/*c*/"    Comment:TerminalRule'ML_COMMENT'
			   10    "\n"       Whitespace:TerminalRule'WS'
			33  1    S "c"        ValueList:name+=ID
			        E ValueList'[a, b, c]' Root
			34  0   H
			------------ diff 1 ------------
			 1    H "//8\n"    Comment:TerminalRule'SL_COMMENT'
			        "/*a*/"    Comment:TerminalRule'ML_COMMENT'
			   10   "\n"       Whitespace:TerminalRule'WS'
			11  1 S "a"        ValueList:name+=ID
			12    H "//a\n"    Comment:TerminalRule'SL_COMMENT'
			        "/*b*/"    Comment:TerminalRule'ML_COMMENT'
			   10   "\n"       Whitespace:TerminalRule'WS'
			------------ diff 2 ------------
			23    H "//b\n"    Comment:TerminalRule'SL_COMMENT'
			        "/*c*/"    Comment:TerminalRule'ML_COMMENT'
			   10   "\n"       Whitespace:TerminalRule'WS'
		'''
	}

}

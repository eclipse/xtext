/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.parsing

import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtend.core.tests.parsing.ParserTest
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.junit.Ignore
import org.junit.Test

/**
 * @author kosyakov - Initial contribution and API
 */
@TestDecorator
class XtendParsingTestCase extends AbstractModelTestCase {

	Delegate delegate

	new() {
		super(XtendFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected setUp() throws Exception {
		super.setUp()
		xtextLanguage.injectMembers(delegate)
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends ParserTest {

		val ModelChecker modelChecker

		override file(String string, boolean validate) {
			modelChecker.checkModel(string, validate)
		}

		@Test
		def void testErrorRecovery() {
			file('''
					package foo
					
					class Foo2323 {
					
				    def create val result = newArrayList foo() {
				        result.
				    }
				}
			''')
		}
		
		@Ignore
		override testAllGrammarElementsUniqueAfterReparse() throws Exception {
			super.testAllGrammarElementsUniqueAfterReparse()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichString_01() throws Exception {
			super.testRichString_01()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichStringFOR_01() throws Exception {
			super.testRichStringFOR_01()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichStringFOR_02() throws Exception {
			super.testRichStringFOR_02()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichStringFOR_03() throws Exception {
			super.testRichStringFOR_03()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichStringIF_00() throws Exception {
			super.testRichStringIF_00()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichStringIF_01() throws Exception {
			super.testRichStringIF_01()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichStringWithComment_00() throws Exception {
			super.testRichStringWithComment_00()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichStringWithComment_01() throws Exception {
			super.testRichStringWithComment_01()
		}
		
		// TODO https://github.com/eclipse/xtext-xtend/issues/11
		@Ignore
		override testRichStringWithComment_03() throws Exception {
			super.testRichStringWithComment_03()
		}
		
	}
}

/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import org.eclipse.jface.text.TextSelection
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.ide.refactoring.XtendExpressionUtil
import org.eclipse.xtend.ide.tests.AbstractXtendTestCase
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendExpressionUtilTest extends AbstractXtendTestCase {

	@Inject XtendExpressionUtil util
	
	@Inject ParseHelper<XtendFile> parseHelper
	
	@Inject ValidationTestHelper validationHelper
	
	@Inject ILocationInFileProvider locationInFileProvider
	
	@Test
	def testSelectionExpression() {
		assertExpressionSelected("''' Prefix «4$$2» Postfix '''", '42')
		assertExpressionSelected("''' Prefix «$42$» Postfix '''", '42')
		assertExpressionSelected("''' Prefix $«42»$ Postfix '''", '42')
		assertExpressionSelected("''' Prefix «$$42» Postfix '''", '42')
		assertExpressionSelected("''' Prefix «$4$2» Postfix '''", '42')
		assertExpressionSelected("''' Prefix «$42»$ Postfix '''", '42')
		assertExpressionSelected("''' Prefix «42$$» Postfix '''", '42')
		assertExpressionSelected("''' Prefix «4$2$» Postfix '''", '42')
		assertExpressionSelected("''' Prefix $«42$» Postfix '''", '42')
		
		assertExpressionSelected("''' Prefix «$42» Postfix$ '''", "''' Prefix «42» Postfix '''")
		
		assertExpressionSelected("''' Prefix «42»$ Postfix$ '''", "» Postfix '''")
		assertExpressionSelected("''' Prefix «42»$$ Postfix '''", "» Postfix '''")
		assertExpressionSelected("''' Prefix «42» $Postfix$ '''", "» Postfix '''")		
		
		assertExpressionSelected("''' $Prefix «42$» Postfix '''", "''' Prefix «42» Postfix '''")
		
		assertExpressionSelected("''' $Prefix $«42» Postfix '''", "''' Prefix «")
		assertExpressionSelected("''' Prefix $$«42» Postfix '''", "''' Prefix «")		
	}
	
	@Test
	def testSelectionExpression2() {
		assertExpressionSelected("''' Prefix « /* prefix */ 4$$2 /* postfix */ » Postfix '''", '42')
		assertExpressionSelected("''' Prefix « /* prefix */ $42$ /* postfix */ » Postfix '''", '42')
		assertExpressionSelected("''' Prefix $« /* prefix */ 42 /* postfix */ »$ Postfix '''", '42')
		assertExpressionSelected("''' Prefix « /* prefix */ $$42 /* postfix */ » Postfix '''", '42')
		assertExpressionSelected("''' Prefix « /* prefix */ $4$2 /* postfix */ » Postfix '''", '42')
		assertExpressionSelected("''' Prefix « /* prefix */ $42 /* postfix */ »$ Postfix '''", '42')
		assertExpressionSelected("''' Prefix « /* prefix */ 42$$ /* postfix */ » Postfix '''", '42')
		assertExpressionSelected("''' Prefix « /* prefix */ 4$2$ /* postfix */ » Postfix '''", '42')
		assertExpressionSelected("''' Prefix $« /* prefix */ 42$ /* postfix */ » Postfix '''", '42')
		
		assertExpressionSelected("''' Prefix « /* prefix */ $42 /* postfix */ » Postfix$ '''", "''' Prefix « /* prefix */ 42 /* postfix */ » Postfix '''")
		
		assertExpressionSelected("''' Prefix « /* prefix */ 42 /* postfix */ »$ Postfix$ '''", "» Postfix '''")
		assertExpressionSelected("''' Prefix « /* prefix */ 42 /* postfix */ »$$ Postfix '''", "» Postfix '''")
		assertExpressionSelected("''' Prefix « /* prefix */ 42 /* postfix */ » $Postfix$ '''", "» Postfix '''")		
		
		assertExpressionSelected("''' $Prefix « /* prefix */ 42$ /* postfix */ » Postfix '''", "''' Prefix « /* prefix */ 42 /* postfix */ » Postfix '''")
		
		assertExpressionSelected("''' $Prefix $« /* prefix */ 42 /* postfix */ » Postfix '''", "''' Prefix «")
		assertExpressionSelected("''' Prefix $$« /* prefix */ 42 /* postfix */ » Postfix '''", "''' Prefix «")		
	}

	def protected assertExpressionSelected(String modelWithSelectionMarkup, String expectedSelection) {
		val model = '''
			class Foo {
				def foo() «modelWithSelectionMarkup»
			}
		''' 
		val cleanedModel = model.replaceAll("\\$", "")
		val expression = cleanedModel.parse()
		val selectionOffset = model.indexOf("$")
		val selectionLength = model.lastIndexOf("$") - selectionOffset - 1
		val selectedExpression = util.findSelectedExpression(expression.eResource as XtextResource, 
			new TextSelection(selectionOffset, selectionLength))
		val selectedRegion = locationInFileProvider.getFullTextRegion(selectedExpression)
		assertEquals(expectedSelection, cleanedModel.substring(selectedRegion.offset, selectedRegion.offset + selectedRegion.length))
	}

	def protected parse(CharSequence string)  {
		val expression = parseHelper.parse(string)
		validationHelper.assertNoErrors(expression)
		expression
	}
	
}
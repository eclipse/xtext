package org.eclipse.xtext.xbase.ui.tests.refactoring

import com.google.inject.Provider
import javax.inject.Inject
import org.eclipse.jface.text.TextSelection
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil
import org.eclipse.xtext.xbase.ui.refactoring.NewVariableNameUtil
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author Jan Koehnlein
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseInjectorProvider))
class NewVariableNameUtilTest {

	@Inject ExpressionUtil util
	
	@Inject Provider<NewVariableNameUtil> nameUtilProvider 
	
	@Inject ParseHelper<XExpression> parseHelper
	
	@Inject ValidationTestHelper validationHelper
	
	@Test
	def testDefaultNamePrimitive() {
		assertDefaultName('{2+$3}', 'i')
		assertDefaultName('{2+$3f}', 'f')
		assertDefaultName('{2+$3l}', 'l')
		assertDefaultName('{2+$3.0}', 'd')
		assertDefaultName('{$true}', 'b')
	}

	@Test
	def testDefaultNameFeatureCall() {
		assertDefaultName('{val CAMEL_CASE_NAME = 1 $CAMEL_CASE_NAME}', 'camelCaseName')
		assertDefaultName('{"".$getBytes}', 'bytes')
		assertDefaultName('{"".$length}', 'length')
	}

	@Test
	def testDefaultNameType() {
		assertDefaultName('{$2+3$}', 'i')
		assertDefaultName('{"$"}', 'string')
	}

	@Test
	def testDefaultNameAlternate() {
		assertDefaultName('{val i=1 2+$3}', 'i1')
		assertDefaultName('{val j=2+$3 val i=1}', 'i1')
		assertDefaultName('{val i=1 {val j=2+$3}}', 'i1')
		assertDefaultName('{val i=1 {val i1=1 val j=2+$3}}', 'i2')
		assertDefaultName('{{val j=2+$3} val i=1 }', 'i')
	}

	def protected assertDefaultName(String modelWithSelectionMarkup, String expectedName) {
		val cleanedModel = modelWithSelectionMarkup.replaceAll("\\$", "")
		val expression = cleanedModel.parse()
		val selectionOffset = modelWithSelectionMarkup.indexOf("$")
		val selectionLength = modelWithSelectionMarkup.lastIndexOf("$")- selectionOffset - 1
		val selectedExpression = util.findSelectedExpression(expression.eResource as XtextResource, 
			new TextSelection(selectionOffset, selectionLength))
		val point = util.findInsertionPointForVariableDeclaration(selectedExpression)
		val nameUtil = nameUtilProvider.get()
		nameUtil.initialize(point.second, point.first)
		val defaultName = nameUtil.getDefaultName(selectedExpression)
		assertEquals(expectedName, defaultName)
	}

	def protected parse(CharSequence string)  {
		val expression = parseHelper.parse(string)
		validationHelper.assertNoErrors(expression)
		expression
	}
}


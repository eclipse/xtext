package org.eclipse.xtext.xbase.idea.tests.parsing

import com.google.inject.Inject
import com.intellij.lang.LanguageASTFactory
import com.intellij.lang.ParserDefinition
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage

@TestDecorator
class XbaseParsingTest extends AbstractLanguageParsingTestCase implements XExpressionChecker {

	IdeaXbaseParserTest delegate

	@Inject
	ValidationTestHelper validationHelper

	new() {
		super("", "___xbase", XbaseLanguage.INSTANCE.getInstance(ParserDefinition))
		XbaseLanguage.INSTANCE.injectMembers(this)
		delegate = new IdeaXbaseParserTest(this)
	}

	@Override override protected void setUp() {
		super.setUp()
		addExplicitExtension(LanguageASTFactory.INSTANCE, XbaseLanguage.INSTANCE,
			XbaseLanguage.INSTANCE.getInstance(BaseXtextASTFactory))
	}

	@Override override protected String getTestDataPath() {
		return "./testData/parsing"
	}

	override XExpression testExpression(String code, boolean resolve) {
		super.doCodeTest(code)
		val expression = actualResource.contents.head as XExpression
		if (resolve) {
			validationHelper.assertNoErrors(expression)
		}
		expression
	}

}

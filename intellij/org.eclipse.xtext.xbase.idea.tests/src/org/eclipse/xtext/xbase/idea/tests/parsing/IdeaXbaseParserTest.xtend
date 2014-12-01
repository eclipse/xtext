package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest

@FinalFieldsConstructor
class IdeaXbaseParserTest extends XbaseParserTest {

	val ModelChecker expresssionChecker
	
	override protected expression(CharSequence string) throws Exception {
		expresssionChecker.checkModel(string.toString, false)
	}

	override protected expression(CharSequence string, boolean resolve) throws Exception {
		expresssionChecker.checkModel(string.toString, resolve)
	}

}
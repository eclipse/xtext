package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.xbase.idea.lang.XbaseFileType

@TestDecorator
class XbaseParsingTest extends AbstractLanguageParsingTestCase {

	IdeaXbaseParserTest delegate

	new() {
		super(XbaseFileType.INSTANCE)
		delegate = new IdeaXbaseParserTest(this)
	}

	@Override override protected String getTestDataPath() {
		return "./testData/parsing"
	}

}

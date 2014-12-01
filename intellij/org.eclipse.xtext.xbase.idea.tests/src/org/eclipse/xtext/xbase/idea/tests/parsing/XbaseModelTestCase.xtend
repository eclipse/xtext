package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase
import org.eclipse.xtext.xbase.idea.lang.XbaseFileType

@TestDecorator
class XbaseModelTestCase extends AbstractModelTestCase {

	IdeaXbaseParserTest delegate

	new() {
		super(XbaseFileType.INSTANCE)
		delegate = new IdeaXbaseParserTest(this)
	}

}
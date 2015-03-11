package org.eclipse.xtext.parser

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.lang.XtextFileType
import org.eclipse.xtext.idea.lang.XtextLanguage
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.junit.Ignore

@TestDecorator
class IdeaXtextParserTest extends AbstractLanguageParsingTestCase {
	
	IdeaXtextParserTestDelegate delegate
	
	new() {
		super(XtextFileType.INSTANCE)
		delegate = new IdeaXtextParserTestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/xtextParserTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaXtextParserTestDelegate extends XtextParserTest {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp
		injector = XtextLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}
	
}
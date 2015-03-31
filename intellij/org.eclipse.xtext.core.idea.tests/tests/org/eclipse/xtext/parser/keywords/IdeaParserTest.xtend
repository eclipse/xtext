package org.eclipse.xtext.parser.keywords

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageFileType
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage

@TestDecorator
class IdeaParserTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(KeywordsTestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/keywords/parserTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends ParserTest {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = KeywordsTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
	}
}

package org.eclipse.xtext.parser.terminalrules

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageFileType
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage

@TestDecorator
class IdeaParserTest extends AbstractLanguageParsingTestCase {
	
	Delgate delegate
	
	new() {
		super(TerminalRulesTestLanguageFileType.INSTANCE)
		delegate = new Delgate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/terminalrules/parserTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delgate extends ParserTest {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = TerminalRulesTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
	}
}

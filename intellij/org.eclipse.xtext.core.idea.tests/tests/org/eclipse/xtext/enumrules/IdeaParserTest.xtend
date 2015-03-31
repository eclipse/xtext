package org.eclipse.xtext.enumrules

import com.google.inject.Injector
import java.io.IOException
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageFileType
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker

@TestDecorator
class IdeaParserTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(EnumRulesTestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/enumrules/parserTest";
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
			injector = EnumRulesTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected parse(String modelAsString) throws IOException {
			modelChecker.checkModel(modelAsString, false)
		}
		
	}
	
}

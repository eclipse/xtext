package org.eclipse.xtext.parser.superCall

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageFileType
import org.eclipse.xtext.grammarinheritance.idea.InheritanceTest3LanguageStandaloneSetupIdea
import org.eclipse.xtext.grammarinheritance.ParserTest
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage
import org.eclipse.xtext.idea.tests.TestDecorator

@TestDecorator
class IdeaSuperCallParserTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(InheritanceTest3LanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getSetup() {
		new InheritanceTest3LanguageStandaloneSetupIdea
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/superCall/parserTest";
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
			injector = InheritanceTest3LanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
	}
	
}

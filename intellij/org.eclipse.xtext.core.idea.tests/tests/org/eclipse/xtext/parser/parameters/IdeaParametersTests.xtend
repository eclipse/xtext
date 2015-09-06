package org.eclipse.xtext.parser.parameters

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.parameters.idea.ParametersTestLanguageStandaloneSetupIdea
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageFileType
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageFileType
import org.eclipse.xtext.parser.parameters.idea.NoParametersTestLanguageStandaloneSetupIdea
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage

@TestDecorator
class IdeaParametersTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(ParametersTestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getSetup() {
		new ParametersTestLanguageStandaloneSetupIdea
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/parameters/parserTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends AbstractParametersParsingTest {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = ParametersTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
	}
	
}

@TestDecorator
class IdeaNoParametersTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(NoParametersTestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getSetup() {
		new NoParametersTestLanguageStandaloneSetupIdea
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/parameters/noParamsParserTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends NoParametersParsingTest {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = NoParametersTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
	}
	
}

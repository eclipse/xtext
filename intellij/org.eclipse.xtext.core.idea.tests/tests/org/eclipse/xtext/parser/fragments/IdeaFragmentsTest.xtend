package org.eclipse.xtext.parser.fragments

import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageFileType
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.parser.fragments.idea.FragmentTestLanguageStandaloneSetupIdea
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import java.io.InputStream
import org.eclipse.emf.common.util.URI
import com.google.common.io.CharStreams
import java.io.InputStreamReader
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage
import com.google.inject.Injector

@TestDecorator
class IdeaFragmentsTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(FragmentTestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getSetup() {
		new FragmentTestLanguageStandaloneSetupIdea
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/fragments/parserTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends AbstractFragmentsPlainParsingTest {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = FragmentTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
	}
	
}
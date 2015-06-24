package org.eclipse.xtext.parser.unorderedGroups

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testlanguages.backtracking.idea.SimpleBeeLangTestLanguageStandaloneSetupIdea
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageFileType
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage

@TestDecorator
class IdeaBacktrackingParserTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(SimpleBeeLangTestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getSetup() {
		new SimpleBeeLangTestLanguageStandaloneSetupIdea
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/unorderedGroups/backtrackingParserTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp()
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends BacktrackingParserTest {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = SimpleBeeLangTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkModel(CharStreams.toString(new InputStreamReader(in)), false).eResource as XtextResource
		}
		
	}
}

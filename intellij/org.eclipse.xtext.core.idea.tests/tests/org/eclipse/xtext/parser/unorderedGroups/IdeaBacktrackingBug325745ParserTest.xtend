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
import org.eclipse.xtext.parser.unorderedGroups.idea.SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageFileType
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage
import org.eclipse.xtext.resource.XtextResource

@TestDecorator
class IdeaBacktrackingBug325745ParserTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(SimpleBacktrackingBug325745TestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getSetup() {
		new SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/unorderedGroups/backtrackingBug325745ParserTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp()
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends BacktrackingBug325745ParserTest {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkModel(CharStreams.toString(new InputStreamReader(in)), false).eResource as XtextResource
		}
		
	}
}

package org.eclipse.xtext.parser.assignments

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageFileType
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage

@TestDecorator
class IdeaParserBug281962Test extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(AssignmentsTestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/assignments/parserBug281962";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends ParserBug281962Test {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = AssignmentsTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
	}
}

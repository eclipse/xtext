package org.eclipse.xtext.parser.antlr

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageFileType
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage
import org.eclipse.xtext.resource.XtextResource

@TestDecorator
class IdeaBug378967Test extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(Bug378967TestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/antlr/bug378967";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		xtextResourceAsserts.nodeModelPrinter.ignoreSyntaxErrors = true
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends Bug378967Test {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = Bug378967TestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
		override protected shouldTestSerializer(XtextResource resource) {
			false
		}
		
	}
}

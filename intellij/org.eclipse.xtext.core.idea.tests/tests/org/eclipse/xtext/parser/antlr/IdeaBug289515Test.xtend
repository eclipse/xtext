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
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageFileType
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.parser.antlr.idea.Bug289515TestLanguageStandaloneSetupIdea

@TestDecorator
class IdeaBug289515Test extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(Bug289515TestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getSetup() {
		new Bug289515TestLanguageStandaloneSetupIdea
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/antlr/bug289515";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends Bug289515Test {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = Bug289515TestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
		override protected shouldTestSerializer(XtextResource resource) {
			false
		}
		
	}
	
}

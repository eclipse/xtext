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
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageFileType
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage
import org.eclipse.xtext.resource.XtextResource
import org.junit.Ignore

// FIXME ex antlr generator fragment is currently not supported
@Ignore
@TestDecorator
class IdeaBug299237Test extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(Bug299237TestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/antlr/bug299237";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends Bug299237Test {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp
			injector = Bug299237TestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
		
		override protected shouldTestSerializer(XtextResource resource) {
			false
		}
		
	}
}

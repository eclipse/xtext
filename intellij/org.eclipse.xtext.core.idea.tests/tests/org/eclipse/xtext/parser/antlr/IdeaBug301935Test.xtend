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
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageFileType
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage
import org.eclipse.xtext.resource.XtextResource
import org.junit.Ignore

@TestDecorator
class IdeaBug301935Test extends AbstractLanguageParsingTestCase {
	
	IdeaBug301935TestDelegate delegate
	
	new() {
		super(Bug301935TestLanguageFileType.INSTANCE)
		delegate = new IdeaBug301935TestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/antlr/bug301935";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaBug301935TestDelegate extends Bug301935Test {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp
		injector = Bug301935TestLanguageLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}
	
	override protected shouldTestSerializer(XtextResource resource) {
		false
	}
	
}
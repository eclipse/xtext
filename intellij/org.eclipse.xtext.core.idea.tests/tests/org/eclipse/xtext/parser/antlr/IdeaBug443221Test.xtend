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
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageFileType
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage
import org.eclipse.xtext.resource.XtextResource
import org.junit.Ignore

@TestDecorator
class IdeaBug443221Test extends AbstractLanguageParsingTestCase {
	
	IdeaBug443221TestDelegate delegate
	
	new() {
		super(Bug443221TestLanguageFileType.INSTANCE)
		delegate = new IdeaBug443221TestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/antlr/bug443221";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaBug443221TestDelegate extends Bug443221Test {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp
		injector = Bug443221TestLanguageLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}
	
	override protected shouldTestSerializer(XtextResource resource) {
		false
	}
	
}
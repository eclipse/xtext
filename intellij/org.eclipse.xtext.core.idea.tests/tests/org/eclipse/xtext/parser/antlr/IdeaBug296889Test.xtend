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
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageFileType
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage
import org.eclipse.xtext.resource.XtextResource
import org.junit.Ignore

@TestDecorator
class IdeaBug296889Test extends AbstractLanguageParsingTestCase {
	
	IdeaBug296889TestDelegate delegate
	
	new() {
		super(Bug296889TestLanguageFileType.INSTANCE)
		delegate = new IdeaBug296889TestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/antlr/bug296889";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaBug296889TestDelegate extends Bug296889Test {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp
		injector = Bug296889TestLanguageLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}
	
	override protected shouldTestSerializer(XtextResource resource) {
		false
	}
	
}
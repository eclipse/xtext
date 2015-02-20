package org.eclipse.xtext.parser.terminalrules

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageFileType
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage
import org.junit.Ignore

@TestDecorator
class IdeaBug297105Test extends AbstractLanguageParsingTestCase {
	
	IdeaBug297105TestDelegate delegate
	
	new() {
		super(Bug297105TestLanguageFileType.INSTANCE)
		delegate = new IdeaBug297105TestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/terminalrules/bug297105";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaBug297105TestDelegate extends Bug297105Test {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp
		injector = Bug297105TestLanguageLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}
	
}
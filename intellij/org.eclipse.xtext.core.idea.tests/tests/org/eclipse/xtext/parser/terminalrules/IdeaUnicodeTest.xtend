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
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageFileType
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage
import org.junit.Ignore

@TestDecorator
class IdeaUnicodeTest extends AbstractLanguageParsingTestCase {
	
	IdeaUnicodeTestDelegate delegate
	
	new() {
		super(UnicodeTestLanguageFileType.INSTANCE)
		delegate = new IdeaUnicodeTestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/terminalrules/unicodeTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaUnicodeTestDelegate extends UnicodeTest {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp()
		injector = UnicodeTestLanguageLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}
	
}
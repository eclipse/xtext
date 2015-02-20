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
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageFileType
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage
import org.junit.Ignore

@TestDecorator
class IdeaHiddensTest extends AbstractLanguageParsingTestCase {
	
	IdeaHiddensTestDelegate delegate
	
	new() {
		super(HiddenTerminalsTestLanguageFileType.INSTANCE)
		delegate = new IdeaHiddensTestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/terminalrules/hiddensTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaHiddensTestDelegate extends HiddensTest {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp()
		injector = HiddenTerminalsTestLanguageLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}
	
}
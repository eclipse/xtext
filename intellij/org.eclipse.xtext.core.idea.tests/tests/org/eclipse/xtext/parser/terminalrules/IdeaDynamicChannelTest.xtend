package org.eclipse.xtext.parser.terminalrules

import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageFileType
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage
import org.junit.Ignore

@TestDecorator
class IdeaDynamicChannelTest extends AbstractLanguageParsingTestCase {
	
	IdeaDynamicChannelTestDelegate delegate
	
	new() {
		super(XtextTerminalsTestLanguageFileType.INSTANCE)
		delegate = new IdeaDynamicChannelTestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/terminalrules/dynamicChannelTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaDynamicChannelTestDelegate extends DynamicChannelTest {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp()
		injector = XtextTerminalsTestLanguageLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected parse(String model) {
		modelChecker.checkResource(model, false).parseResult
	}
	
}
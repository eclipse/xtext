package org.eclipse.xtext.parser.terminalrules

import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.terminalrules.idea.XtextTerminalsTestLanguageStandaloneSetupIdea
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageFileType
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage

@TestDecorator
class IdeaDynamicChannelTest extends AbstractLanguageParsingTestCase {
	
	Delegate delegate
	
	new() {
		super(XtextTerminalsTestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}
	
	override protected getSetup() {
		new XtextTerminalsTestLanguageStandaloneSetupIdea
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/terminalrules/dynamicChannelTest";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
	@FinalFieldsConstructor
	private static class Delegate extends DynamicChannelTest {
		
		val ModelChecker modelChecker
		
		override setUp() throws Exception {
			super.setUp()
			injector = XtextTerminalsTestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
		
		override protected parse(String model) {
			modelChecker.checkResource(model, false).parseResult
		}
		
	}
}

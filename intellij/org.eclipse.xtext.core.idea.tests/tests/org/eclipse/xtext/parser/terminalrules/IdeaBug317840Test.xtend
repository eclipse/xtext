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
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageFileType
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage

@TestDecorator
class IdeaBug317840Test extends AbstractLanguageParsingTestCase {

	Delegate delegate

	new() {
		super(Bug317840TestLanguageFileType.INSTANCE)
		delegate = new Delegate(this)
	}

	override protected getTestDataPath() {
		"./testData/parsing/terminalrules/bug317840";
	}

	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}

	@FinalFieldsConstructor
	private static class Delegate extends Bug317840Test {
	
		val ModelChecker modelChecker
	
		override setUp() throws Exception {
			super.setUp
			injector = Bug317840TestLanguageLanguage.INSTANCE.getInstance(Injector)
		}
	
		override protected doGetResource(InputStream in, URI uri) throws Exception {
			modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
		}
	
	}
}

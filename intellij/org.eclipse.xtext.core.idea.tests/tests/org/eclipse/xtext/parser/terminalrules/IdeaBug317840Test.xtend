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
import org.junit.Ignore

@TestDecorator
class IdeaBug317840Test extends AbstractLanguageParsingTestCase {

	IdeaBug317840TestDelegate delegate

	new() {
		super(Bug317840TestLanguageFileType.INSTANCE)
		delegate = new IdeaBug317840TestDelegate(this)
	}

	override protected getTestDataPath() {
		"./testData/parsing/terminalrules/bug317840";
	}

	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}

}

@Ignore
@FinalFieldsConstructor
class IdeaBug317840TestDelegate extends Bug317840Test {

	val ModelChecker modelChecker

	override setUp() throws Exception {
		super.setUp
		injector = Bug317840TestLanguageLanguage.INSTANCE.getInstance(Injector)
	}

	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}

}
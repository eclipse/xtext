package org.eclipse.xtext.parser.assignments

import com.google.common.io.CharStreams
import com.google.inject.Injector
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageFileType
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage
import org.junit.Ignore

@TestDecorator
class IdeaBug288432Test extends AbstractLanguageParsingTestCase {
	
	IdeaBug288432TestDelegate delegate
	
	new() {
		super(Bug288432TestLanguageFileType.INSTANCE)
		delegate = new IdeaBug288432TestDelegate(this)
	}
	
	override protected getTestDataPath() {
		"./testData/parsing/assignments/bug288432";
	}
	
	override protected setUp() throws Exception {
		super.setUp
		delegate.setUp
	}
	
}

@Ignore
@FinalFieldsConstructor
class IdeaBug288432TestDelegate extends Bug288432Test {
	
	val ModelChecker modelChecker
	
	override setUp() throws Exception {
		super.setUp
		injector = Bug288432TestLanguageLanguage.INSTANCE.getInstance(Injector)
	}
	
	override protected doGetResource(InputStream in, URI uri) throws Exception {
		modelChecker.checkResource(CharStreams.toString(new InputStreamReader(in)), false)
	}
	
}
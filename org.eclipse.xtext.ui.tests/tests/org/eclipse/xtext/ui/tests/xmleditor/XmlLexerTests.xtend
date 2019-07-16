package org.eclipse.xtext.ui.tests.xmleditor

import javax.inject.Inject
import javax.inject.Named
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.parser.antlr.LexerBindings
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.tests.xmleditor.tests.XmlInjectorProvider
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(XmlInjectorProvider)
class XmlLexerTests extends AbstractXmlLexerTest {

	@Inject @Named(LexerBindings.RUNTIME) Lexer lexer
	
	override lexer() {
		lexer
	}

}

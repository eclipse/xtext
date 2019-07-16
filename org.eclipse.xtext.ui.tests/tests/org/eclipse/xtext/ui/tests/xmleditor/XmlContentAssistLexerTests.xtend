package org.eclipse.xtext.ui.tests.xmleditor

import javax.inject.Inject
import javax.inject.Named
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.LexerUIBindings
import org.junit.runner.RunWith
import org.eclipse.xtext.ui.tests.xmleditor.ui.tests.XmlUiInjectorProvider

@RunWith(XtextRunner)
@InjectWith(XmlUiInjectorProvider)
class XmlContentAssistLexerTests extends AbstractXmlLexerTest {

	@Inject @Named(LexerUIBindings.CONTENT_ASSIST) Lexer lexer

	override lexer() {
		lexer
	}

	override test022() {
		'''
			<a b="/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
ллл	The content assist lexer produces different tokens than the parser/highlighting lexer
ллл			0 '"'
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}
}

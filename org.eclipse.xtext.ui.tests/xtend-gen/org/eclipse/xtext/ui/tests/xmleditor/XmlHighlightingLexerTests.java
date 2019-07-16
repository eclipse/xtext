package org.eclipse.xtext.ui.tests.xmleditor;

import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.tests.xmleditor.AbstractXmlLexerTest;
import org.eclipse.xtext.ui.tests.xmleditor.ui.tests.XmlUiInjectorProvider;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XmlUiInjectorProvider.class)
@SuppressWarnings("all")
public class XmlHighlightingLexerTests extends AbstractXmlLexerTest {
  @Inject
  @Named(LexerUIBindings.HIGHLIGHTING)
  private Lexer lexer;
  
  @Override
  public org.antlr.runtime.Lexer lexer() {
    return this.lexer;
  }
}

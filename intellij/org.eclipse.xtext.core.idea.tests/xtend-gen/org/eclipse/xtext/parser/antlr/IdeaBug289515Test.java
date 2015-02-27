package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.antlr.IdeaBug289515TestDelegate;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug289515Test extends AbstractLanguageParsingTestCase {
  private IdeaBug289515TestDelegate delegate;
  
  public IdeaBug289515Test() {
    super(Bug289515TestLanguageFileType.INSTANCE);
    IdeaBug289515TestDelegate _ideaBug289515TestDelegate = new IdeaBug289515TestDelegate(this);
    this.delegate = _ideaBug289515TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug289515";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testGrammarAccess_01() {
    delegate.testGrammarAccess_01();
  }
  
  public void testGrammarAccess_02() {
    delegate.testGrammarAccess_02();
  }
  
  public void testGrammarAccess_03() {
    delegate.testGrammarAccess_03();
  }
  
  public void testGrammarAccess_04() {
    delegate.testGrammarAccess_04();
  }
  
  public void testGrammarAccess_05() {
    delegate.testGrammarAccess_05();
  }
  
  public void testGrammarAccess_06() {
    delegate.testGrammarAccess_06();
  }
  
  public void testParser_01() throws Exception {
    delegate.testParser_01();
  }
  
  public void testParser_02() throws Exception {
    delegate.testParser_02();
  }
  
  public void testParser_03() throws Exception {
    delegate.testParser_03();
  }
  
  public void testParser_04() throws Exception {
    delegate.testParser_04();
  }
  
  public void testParser_05() throws Exception {
    delegate.testParser_05();
  }
  
  public void testParser_06() throws Exception {
    delegate.testParser_06();
  }
}

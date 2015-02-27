package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.antlr.IdeaBug443221TestDelegate;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug443221Test extends AbstractLanguageParsingTestCase {
  private IdeaBug443221TestDelegate delegate;
  
  public IdeaBug443221Test() {
    super(Bug443221TestLanguageFileType.INSTANCE);
    IdeaBug443221TestDelegate _ideaBug443221TestDelegate = new IdeaBug443221TestDelegate(this);
    this.delegate = _ideaBug443221TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug443221";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testParse() throws Exception {
    delegate.testParse();
  }
}

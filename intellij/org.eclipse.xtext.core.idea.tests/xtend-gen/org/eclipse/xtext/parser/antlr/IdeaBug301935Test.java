package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.antlr.IdeaBug301935TestDelegate;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug301935Test extends AbstractLanguageParsingTestCase {
  private IdeaBug301935TestDelegate delegate;
  
  public IdeaBug301935Test() {
    super(Bug301935TestLanguageFileType.INSTANCE);
    IdeaBug301935TestDelegate _ideaBug301935TestDelegate = new IdeaBug301935TestDelegate(this);
    this.delegate = _ideaBug301935TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug301935";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testGetTokenDefMap_01() {
    delegate.testGetTokenDefMap_01();
  }
  
  public void testGetTokenDefMap_02() {
    delegate.testGetTokenDefMap_02();
  }
  
  public void testParseValidInput() throws Exception {
    delegate.testParseValidInput();
  }
}

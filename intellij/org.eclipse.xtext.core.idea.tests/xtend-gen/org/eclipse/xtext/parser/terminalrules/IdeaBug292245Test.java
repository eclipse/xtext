package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.terminalrules.IdeaBug292245TestDelegate;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug292245Test extends AbstractLanguageParsingTestCase {
  private IdeaBug292245TestDelegate delegate;
  
  public IdeaBug292245Test() {
    super(Bug292245TestLanguageFileType.INSTANCE);
    IdeaBug292245TestDelegate _ideaBug292245TestDelegate = new IdeaBug292245TestDelegate(this);
    this.delegate = _ideaBug292245TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/bug292245";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBug292245_01() throws Exception {
    delegate.testBug292245_01();
  }
  
  public void testBug292245_02() throws Exception {
    delegate.testBug292245_02();
  }
  
  public void testBug292245_03() throws Exception {
    delegate.testBug292245_03();
  }
  
  public void testBug292245_04() throws Exception {
    delegate.testBug292245_04();
  }
  
  public void testBug292245_05() throws Exception {
    delegate.testBug292245_05();
  }
  
  public void testBug292245_06() throws Exception {
    delegate.testBug292245_06();
  }
  
  public void testBug292245_07() throws Exception {
    delegate.testBug292245_07();
  }
  
  public void testBug292245_08() throws Exception {
    delegate.testBug292245_08();
  }
}

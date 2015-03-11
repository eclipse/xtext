package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.terminalrules.IdeaBug297105TestDelegate;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug297105Test extends AbstractLanguageParsingTestCase {
  private IdeaBug297105TestDelegate delegate;
  
  public IdeaBug297105Test() {
    super(Bug297105TestLanguageFileType.INSTANCE);
    IdeaBug297105TestDelegate _ideaBug297105TestDelegate = new IdeaBug297105TestDelegate(this);
    this.delegate = _ideaBug297105TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/bug297105";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBug297105_01() throws Exception {
    delegate.testBug297105_01();
  }
  
  public void testBug297105_02() throws Exception {
    delegate.testBug297105_02();
  }
  
  public void testBug297105_03() throws Exception {
    delegate.testBug297105_03();
  }
  
  public void testBug297105_04() throws Exception {
    delegate.testBug297105_04();
  }
  
  public void testBug297105_05() throws Exception {
    delegate.testBug297105_05();
  }
  
  public void testBug297105_06() throws Exception {
    delegate.testBug297105_06();
  }
  
  public void testBug297105_07() throws Exception {
    delegate.testBug297105_07();
  }
  
  public void testBug297105_08() throws Exception {
    delegate.testBug297105_08();
  }
  
  public void testBug297105_09() throws Exception {
    delegate.testBug297105_09();
  }
  
  public void testBug297105_10() throws Exception {
    delegate.testBug297105_10();
  }
  
  public void testBug297105_11() throws Exception {
    delegate.testBug297105_11();
  }
  
  public void testBug297105_12() throws Exception {
    delegate.testBug297105_12();
  }
  
  public void testBug297105_13() throws Exception {
    delegate.testBug297105_13();
  }
  
  public void testBug297105_14() throws Exception {
    delegate.testBug297105_14();
  }
  
  public void testBug297105_15() throws Exception {
    delegate.testBug297105_15();
  }
  
  public void testBug297105_16() throws Exception {
    delegate.testBug297105_16();
  }
  
  public void testBug297105_17() throws Exception {
    delegate.testBug297105_17();
  }
  
  public void testBug297105_18() throws Exception {
    delegate.testBug297105_18();
  }
  
  public void testBug297105_19() throws Exception {
    delegate.testBug297105_19();
  }
  
  public void testBug297105_20() throws Exception {
    delegate.testBug297105_20();
  }
}

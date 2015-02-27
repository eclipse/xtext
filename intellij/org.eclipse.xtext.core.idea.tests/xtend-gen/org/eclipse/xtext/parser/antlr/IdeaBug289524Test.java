package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.antlr.IdeaBug289524TestDelegate;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug289524Test extends AbstractLanguageParsingTestCase {
  private IdeaBug289524TestDelegate delegate;
  
  public IdeaBug289524Test() {
    super(Bug289524TestLanguageFileType.INSTANCE);
    IdeaBug289524TestDelegate _ideaBug289524TestDelegate = new IdeaBug289524TestDelegate(this);
    this.delegate = _ideaBug289524TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug289524";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testGetModel_01() throws Exception {
    delegate.testGetModel_01();
  }
  
  public void testGetModel_02() throws Exception {
    delegate.testGetModel_02();
  }
  
  public void testGetModel_03() throws Exception {
    delegate.testGetModel_03();
  }
  
  public void testGetModel_04() throws Exception {
    delegate.testGetModel_04();
  }
  
  public void testGetModel_05() throws Exception {
    delegate.testGetModel_05();
  }
  
  public void testGetModel_06() throws Exception {
    delegate.testGetModel_06();
  }
}

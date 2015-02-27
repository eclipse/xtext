package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.antlr.IdeaBug296889TestDelegate;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug296889Test extends AbstractLanguageParsingTestCase {
  private IdeaBug296889TestDelegate delegate;
  
  public IdeaBug296889Test() {
    super(Bug296889TestLanguageFileType.INSTANCE);
    IdeaBug296889TestDelegate _ideaBug296889TestDelegate = new IdeaBug296889TestDelegate(this);
    this.delegate = _ideaBug296889TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug296889";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testGetDataType_01() throws Exception {
    delegate.testGetDataType_01();
  }
  
  public void testGetDataType_02() throws Exception {
    delegate.testGetDataType_02();
  }
  
  public void testGetDataType_03() throws Exception {
    delegate.testGetDataType_03();
  }
  
  public void testGetDataType_04() throws Exception {
    delegate.testGetDataType_04();
  }
  
  public void testGetDataType_05() throws Exception {
    delegate.testGetDataType_05();
  }
  
  public void testGetDataType_06() throws Exception {
    delegate.testGetDataType_06();
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

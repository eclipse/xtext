package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.antlr.IdeaBug299237TestDelegate;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageFileType;
import org.junit.Ignore;

@Ignore
@TestDecorator
@SuppressWarnings("all")
public class IdeaBug299237Test extends AbstractLanguageParsingTestCase {
  private IdeaBug299237TestDelegate delegate;
  
  public IdeaBug299237Test() {
    super(Bug299237TestLanguageFileType.INSTANCE);
    IdeaBug299237TestDelegate _ideaBug299237TestDelegate = new IdeaBug299237TestDelegate(this);
    this.delegate = _ideaBug299237TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug299237";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testCustomizedSyntaxError() throws Exception {
    delegate.testCustomizedSyntaxError();
  }
  
  public void testSyntaxError_01() throws Exception {
    delegate.testSyntaxError_01();
  }
  
  public void testSyntaxError_02() throws Exception {
    delegate.testSyntaxError_02();
  }
  
  public void testSyntaxError_03() throws Exception {
    delegate.testSyntaxError_03();
  }
  
  public void testValidModel_01() throws Exception {
    delegate.testValidModel_01();
  }
  
  public void testValidModel_02() throws Exception {
    delegate.testValidModel_02();
  }
}

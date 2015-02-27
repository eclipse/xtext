package org.eclipse.xtext.parser.assignments;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.assignments.IdeaBug287184TestDelegate;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug287184Test extends AbstractLanguageParsingTestCase {
  private IdeaBug287184TestDelegate delegate;
  
  public IdeaBug287184Test() {
    super(Bug287184TestLanguageFileType.INSTANCE);
    IdeaBug287184TestDelegate _ideaBug287184TestDelegate = new IdeaBug287184TestDelegate(this);
    this.delegate = _ideaBug287184TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/assignments/bug287184";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBug287184_01() throws Exception {
    delegate.testBug287184_01();
  }
  
  public void testBug287184_02() throws Exception {
    delegate.testBug287184_02();
  }
  
  public void testBug287184_03() throws Exception {
    delegate.testBug287184_03();
  }
  
  public void testBug287184_04() throws Exception {
    delegate.testBug287184_04();
  }
  
  public void testBug287184_05() throws Exception {
    delegate.testBug287184_05();
  }
  
  public void testBug287184_06() throws Exception {
    delegate.testBug287184_06();
  }
}

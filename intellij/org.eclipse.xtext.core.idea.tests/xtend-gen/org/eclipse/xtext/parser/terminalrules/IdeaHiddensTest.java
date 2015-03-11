package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.terminalrules.IdeaHiddensTestDelegate;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaHiddensTest extends AbstractLanguageParsingTestCase {
  private IdeaHiddensTestDelegate delegate;
  
  public IdeaHiddensTest() {
    super(HiddenTerminalsTestLanguageFileType.INSTANCE);
    IdeaHiddensTestDelegate _ideaHiddensTestDelegate = new IdeaHiddensTestDelegate(this);
    this.delegate = _ideaHiddensTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/hiddensTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testDatatypeHiddens_01() throws Exception {
    delegate.testDatatypeHiddens_01();
  }
  
  public void testDatatypeHiddens_02() throws Exception {
    delegate.testDatatypeHiddens_02();
  }
  
  public void testDatatypeHiddens_03() throws Exception {
    delegate.testDatatypeHiddens_03();
  }
  
  public void testInheritingHiddens_01() throws Exception {
    delegate.testInheritingHiddens_01();
  }
  
  public void testInheritingHiddens_02() throws Exception {
    delegate.testInheritingHiddens_02();
  }
  
  public void testInheritingHiddens_03() throws Exception {
    delegate.testInheritingHiddens_03();
  }
  
  public void testInheritingHiddens_04() throws Exception {
    delegate.testInheritingHiddens_04();
  }
  
  public void testOverridingHiddens_01() throws Exception {
    delegate.testOverridingHiddens_01();
  }
  
  public void testOverridingHiddens_02() throws Exception {
    delegate.testOverridingHiddens_02();
  }
  
  public void testSetup() {
    delegate.testSetup();
  }
  
  public void testWithHiddens_01() throws Exception {
    delegate.testWithHiddens_01();
  }
  
  public void testWithHiddens_02() throws Exception {
    delegate.testWithHiddens_02();
  }
  
  public void testWithoutHiddens_01() throws Exception {
    delegate.testWithoutHiddens_01();
  }
  
  public void testWithoutHiddens_02() throws Exception {
    delegate.testWithoutHiddens_02();
  }
}

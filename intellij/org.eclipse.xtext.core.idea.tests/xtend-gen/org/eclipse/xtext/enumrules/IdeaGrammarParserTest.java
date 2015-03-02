package org.eclipse.xtext.enumrules;

import org.eclipse.xtext.enumrules.IdeaGrammarParserTestDelegate;
import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;

@TestDecorator
@SuppressWarnings("all")
public class IdeaGrammarParserTest extends AbstractLanguageParsingTestCase {
  private IdeaGrammarParserTestDelegate delegate;
  
  public IdeaGrammarParserTest() {
    super(XtextFileType.INSTANCE);
    IdeaGrammarParserTestDelegate _ideaGrammarParserTestDelegate = new IdeaGrammarParserTestDelegate(this);
    this.delegate = _ideaGrammarParserTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/enumrules/grammarParserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testEnum_01() throws Exception {
    delegate.testEnum_01();
  }
  
  public void testEnum_02() throws Exception {
    delegate.testEnum_02();
  }
  
  public void testEnum_03() throws Exception {
    delegate.testEnum_03();
  }
  
  public void testEnum_04() throws Exception {
    delegate.testEnum_04();
  }
  
  public void testEnum_05() throws Exception {
    delegate.testEnum_05();
  }
  
  public void testEnum_06() throws Exception {
    delegate.testEnum_06();
  }
  
  public void testEnum_07() throws Exception {
    delegate.testEnum_07();
  }
  
  public void testEnum_08() throws Exception {
    delegate.testEnum_08();
  }
  
  public void testEnum_09() throws Exception {
    delegate.testEnum_09();
  }
  
  public void testEnum_10() throws Exception {
    delegate.testEnum_10();
  }
  
  public void testEnum_11() throws Exception {
    delegate.testEnum_11();
  }
}

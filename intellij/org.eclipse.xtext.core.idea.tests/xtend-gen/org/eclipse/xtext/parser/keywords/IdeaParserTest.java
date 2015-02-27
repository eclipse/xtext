package org.eclipse.xtext.parser.keywords;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.keywords.IdeaParserTestDelegate;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaParserTest extends AbstractLanguageParsingTestCase {
  private IdeaParserTestDelegate delegate;
  
  public IdeaParserTest() {
    super(KeywordsTestLanguageFileType.INSTANCE);
    IdeaParserTestDelegate _ideaParserTestDelegate = new IdeaParserTestDelegate(this);
    this.delegate = _ideaParserTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/keywords/parserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBackslash() throws Exception {
    delegate.testBackslash();
  }
  
  public void testBar() throws Exception {
    delegate.testBar();
  }
  
  public void testEighth() throws Exception {
    delegate.testEighth();
  }
  
  public void testFifth() throws Exception {
    delegate.testFifth();
  }
  
  public void testFoo() throws Exception {
    delegate.testFoo();
  }
  
  public void testFooBar() throws Exception {
    delegate.testFooBar();
  }
  
  public void testSeventh() throws Exception {
    delegate.testSeventh();
  }
  
  public void testSixth() throws Exception {
    delegate.testSixth();
  }
}

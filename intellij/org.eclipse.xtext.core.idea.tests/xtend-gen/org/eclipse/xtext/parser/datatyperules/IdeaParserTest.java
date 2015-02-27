package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.datatyperules.IdeaParserTestDelegate;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaParserTest extends AbstractLanguageParsingTestCase {
  private IdeaParserTestDelegate delegate;
  
  public IdeaParserTest() {
    super(DatatypeRulesTestLanguageFileType.INSTANCE);
    IdeaParserTestDelegate _ideaParserTestDelegate = new IdeaParserTestDelegate(this);
    this.delegate = _ideaParserTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/datatyperules/parserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testParseErrors_01() throws Exception {
    delegate.testParseErrors_01();
  }
  
  public void testParseErrors_02() throws Exception {
    delegate.testParseErrors_02();
  }
  
  public void testParseErrors_03() throws Exception {
    delegate.testParseErrors_03();
  }
  
  public void testParseErrors_04() throws Exception {
    delegate.testParseErrors_04();
  }
  
  public void testParseSimple() throws Exception {
    delegate.testParseSimple();
  }
  
  public void testParseSimpleWithMultipleSpaces() throws Exception {
    delegate.testParseSimpleWithMultipleSpaces();
  }
  
  public void testParseSimpleWithSpaces() throws Exception {
    delegate.testParseSimpleWithSpaces();
  }
  
  public void testParseWithDots() throws Exception {
    delegate.testParseWithDots();
  }
  
  public void testParseWithDotsAndComments() throws Exception {
    delegate.testParseWithDotsAndComments();
  }
  
  public void testParseWithDotsAndLinebreak() throws Exception {
    delegate.testParseWithDotsAndLinebreak();
  }
  
  public void testParseWithDoubleDots() throws Exception {
    delegate.testParseWithDoubleDots();
  }
  
  public void testParseWithFraction() throws Exception {
    delegate.testParseWithFraction();
  }
  
  public void testParseWithFractionError() throws Exception {
    delegate.testParseWithFractionError();
  }
  
  public void testParseWithFractionErrorAndSpaces() throws Exception {
    delegate.testParseWithFractionErrorAndSpaces();
  }
  
  public void testParseWithFractionErrorAndSyntaxError() throws Exception {
    delegate.testParseWithFractionErrorAndSyntaxError();
  }
  
  public void testParseWithVector() throws Exception {
    delegate.testParseWithVector();
  }
  
  public void testParseWithVectorAndComment() throws Exception {
    delegate.testParseWithVectorAndComment();
  }
}

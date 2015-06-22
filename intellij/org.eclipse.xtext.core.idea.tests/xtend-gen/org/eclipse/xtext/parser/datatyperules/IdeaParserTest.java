package org.eclipse.xtext.parser.datatyperules;

import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.datatyperules.ParserTest;
import org.eclipse.xtext.parser.datatyperules.idea.DatatypeRulesTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageFileType;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaParserTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends ParserTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = DatatypeRulesTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
      this.setInjector(_instance);
    }
    
    @Override
    protected XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
      InputStreamReader _inputStreamReader = new InputStreamReader(in);
      String _string = CharStreams.toString(_inputStreamReader);
      return this.modelChecker.checkResource(_string, false);
    }
    
    public Delegate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  private IdeaParserTest.Delegate delegate;
  
  public IdeaParserTest() {
    super(DatatypeRulesTestLanguageFileType.INSTANCE);
    IdeaParserTest.Delegate _delegate = new IdeaParserTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new DatatypeRulesTestLanguageStandaloneSetupIdea();
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

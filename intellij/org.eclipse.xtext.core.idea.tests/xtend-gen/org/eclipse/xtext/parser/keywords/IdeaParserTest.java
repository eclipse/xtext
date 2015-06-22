package org.eclipse.xtext.parser.keywords;

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
import org.eclipse.xtext.parser.keywords.ParserTest;
import org.eclipse.xtext.parser.keywords.idea.KeywordsTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageFileType;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;
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
      Injector _instance = KeywordsTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
    super(KeywordsTestLanguageFileType.INSTANCE);
    IdeaParserTest.Delegate _delegate = new IdeaParserTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new KeywordsTestLanguageStandaloneSetupIdea();
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

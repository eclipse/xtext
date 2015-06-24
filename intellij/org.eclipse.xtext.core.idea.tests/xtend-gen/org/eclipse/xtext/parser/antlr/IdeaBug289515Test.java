package org.eclipse.xtext.parser.antlr;

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
import org.eclipse.xtext.parser.antlr.Bug289515Test;
import org.eclipse.xtext.parser.antlr.idea.Bug289515TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug289515Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends Bug289515Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug289515TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
      this.setInjector(_instance);
    }
    
    @Override
    protected XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
      InputStreamReader _inputStreamReader = new InputStreamReader(in);
      String _string = CharStreams.toString(_inputStreamReader);
      return this.modelChecker.checkResource(_string, false);
    }
    
    @Override
    protected boolean shouldTestSerializer(final XtextResource resource) {
      return false;
    }
    
    public Delegate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  private IdeaBug289515Test.Delegate delegate;
  
  public IdeaBug289515Test() {
    super(Bug289515TestLanguageFileType.INSTANCE);
    IdeaBug289515Test.Delegate _delegate = new IdeaBug289515Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new Bug289515TestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug289515";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testGrammarAccess_01() {
    delegate.testGrammarAccess_01();
  }
  
  public void testGrammarAccess_02() {
    delegate.testGrammarAccess_02();
  }
  
  public void testGrammarAccess_03() {
    delegate.testGrammarAccess_03();
  }
  
  public void testGrammarAccess_04() {
    delegate.testGrammarAccess_04();
  }
  
  public void testGrammarAccess_05() {
    delegate.testGrammarAccess_05();
  }
  
  public void testGrammarAccess_06() {
    delegate.testGrammarAccess_06();
  }
  
  public void testParser_01() throws Exception {
    delegate.testParser_01();
  }
  
  public void testParser_02() throws Exception {
    delegate.testParser_02();
  }
  
  public void testParser_03() throws Exception {
    delegate.testParser_03();
  }
  
  public void testParser_04() throws Exception {
    delegate.testParser_04();
  }
  
  public void testParser_05() throws Exception {
    delegate.testParser_05();
  }
  
  public void testParser_06() throws Exception {
    delegate.testParser_06();
  }
}

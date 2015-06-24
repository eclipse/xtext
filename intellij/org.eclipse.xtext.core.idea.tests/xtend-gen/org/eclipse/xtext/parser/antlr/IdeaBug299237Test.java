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
import org.eclipse.xtext.parser.antlr.Bug299237Test;
import org.eclipse.xtext.parser.antlr.idea.Bug299237TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Ignore;

@Ignore
@TestDecorator
@SuppressWarnings("all")
public class IdeaBug299237Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends Bug299237Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug299237TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBug299237Test.Delegate delegate;
  
  public IdeaBug299237Test() {
    super(Bug299237TestLanguageFileType.INSTANCE);
    IdeaBug299237Test.Delegate _delegate = new IdeaBug299237Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new Bug299237TestLanguageStandaloneSetupIdea();
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

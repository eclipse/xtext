package org.eclipse.xtext.parser.parameters;

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
import org.eclipse.xtext.parser.parameters.NoParametersParsingTest;
import org.eclipse.xtext.parser.parameters.idea.NoParametersTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaNoParametersTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends NoParametersParsingTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = NoParametersTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaNoParametersTest.Delegate delegate;
  
  public IdeaNoParametersTest() {
    super(NoParametersTestLanguageFileType.INSTANCE);
    IdeaNoParametersTest.Delegate _delegate = new IdeaNoParametersTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new NoParametersTestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/parameters/noParamsParserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testScenario10_id() {
    delegate.testScenario10_id();
  }
  
  public void testScenario10_id_keyword() {
    delegate.testScenario10_id_keyword();
  }
  
  public void testScenario10_keyword() {
    delegate.testScenario10_keyword();
  }
  
  public void testScenario10_keyword_keyword() {
    delegate.testScenario10_keyword_keyword();
  }
  
  public void testScenario11_id_keyword() {
    delegate.testScenario11_id_keyword();
  }
  
  public void testScenario11_keyword_keyword() {
    delegate.testScenario11_keyword_keyword();
  }
  
  public void testScenario1_first() {
    delegate.testScenario1_first();
  }
  
  public void testScenario2_second() {
    delegate.testScenario2_second();
  }
  
  public void testScenario3_id() {
    delegate.testScenario3_id();
  }
  
  public void testScenario3_keyword() {
    delegate.testScenario3_keyword();
  }
  
  public void testScenario4_id() {
    delegate.testScenario4_id();
  }
  
  public void testScenario4_keyword() {
    delegate.testScenario4_keyword();
  }
  
  public void testScenario5_id() {
    delegate.testScenario5_id();
  }
  
  public void testScenario5_keyword() {
    delegate.testScenario5_keyword();
  }
  
  public void testScenario6_id() {
    delegate.testScenario6_id();
  }
  
  public void testScenario6_keyword() {
    delegate.testScenario6_keyword();
  }
  
  public void testScenario7_id() {
    delegate.testScenario7_id();
  }
  
  public void testScenario7_keyword() {
    delegate.testScenario7_keyword();
  }
  
  public void testScenario8_id() {
    delegate.testScenario8_id();
  }
  
  public void testScenario8_keyword() {
    delegate.testScenario8_keyword();
  }
  
  public void testScenario9_id() {
    delegate.testScenario9_id();
  }
  
  public void testScenario9_id_keyword() {
    delegate.testScenario9_id_keyword();
  }
  
  public void testScenario9_keyword() {
    delegate.testScenario9_keyword();
  }
  
  public void testScenario9_keyword_keyword() {
    delegate.testScenario9_keyword_keyword();
  }
}

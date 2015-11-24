package org.eclipse.xtext.parser.superCall;

import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.grammarinheritance.ParserTest;
import org.eclipse.xtext.grammarinheritance.idea.InheritanceTest3LanguageStandaloneSetupIdea;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaSuperCallParserTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends ParserTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = InheritanceTest3LanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaSuperCallParserTest.Delegate delegate;
  
  public IdeaSuperCallParserTest() {
    super(InheritanceTest3LanguageFileType.INSTANCE);
    IdeaSuperCallParserTest.Delegate _delegate = new IdeaSuperCallParserTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new InheritanceTest3LanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/superCall/parserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void test_01() throws Exception {
    delegate.test_01();
  }
  
  public void test_02() throws Exception {
    delegate.test_02();
  }
  
  public void test_03() throws Exception {
    delegate.test_03();
  }
  
  public void test_04() throws Exception {
    delegate.test_04();
  }
}

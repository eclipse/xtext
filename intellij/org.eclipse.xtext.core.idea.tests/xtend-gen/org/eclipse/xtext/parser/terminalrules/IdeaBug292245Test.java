package org.eclipse.xtext.parser.terminalrules;

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
import org.eclipse.xtext.parser.terminalrules.Bug292245Test;
import org.eclipse.xtext.parser.terminalrules.idea.Bug292245TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug292245Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends Bug292245Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug292245TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBug292245Test.Delegate delegate;
  
  public IdeaBug292245Test() {
    super(Bug292245TestLanguageFileType.INSTANCE);
    IdeaBug292245Test.Delegate _delegate = new IdeaBug292245Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new Bug292245TestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/bug292245";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBug292245_01() throws Exception {
    delegate.testBug292245_01();
  }
  
  public void testBug292245_02() throws Exception {
    delegate.testBug292245_02();
  }
  
  public void testBug292245_03() throws Exception {
    delegate.testBug292245_03();
  }
  
  public void testBug292245_04() throws Exception {
    delegate.testBug292245_04();
  }
  
  public void testBug292245_05() throws Exception {
    delegate.testBug292245_05();
  }
  
  public void testBug292245_06() throws Exception {
    delegate.testBug292245_06();
  }
  
  public void testBug292245_07() throws Exception {
    delegate.testBug292245_07();
  }
  
  public void testBug292245_08() throws Exception {
    delegate.testBug292245_08();
  }
}

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
import org.eclipse.xtext.parser.terminalrules.Bug297105Test;
import org.eclipse.xtext.parser.terminalrules.idea.Bug297105TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug297105Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends Bug297105Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug297105TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBug297105Test.Delegate delegate;
  
  public IdeaBug297105Test() {
    super(Bug297105TestLanguageFileType.INSTANCE);
    IdeaBug297105Test.Delegate _delegate = new IdeaBug297105Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new Bug297105TestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/bug297105";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBug297105_01() throws Exception {
    delegate.testBug297105_01();
  }
  
  public void testBug297105_02() throws Exception {
    delegate.testBug297105_02();
  }
  
  public void testBug297105_03() throws Exception {
    delegate.testBug297105_03();
  }
  
  public void testBug297105_04() throws Exception {
    delegate.testBug297105_04();
  }
  
  public void testBug297105_05() throws Exception {
    delegate.testBug297105_05();
  }
  
  public void testBug297105_06() throws Exception {
    delegate.testBug297105_06();
  }
  
  public void testBug297105_07() throws Exception {
    delegate.testBug297105_07();
  }
  
  public void testBug297105_08() throws Exception {
    delegate.testBug297105_08();
  }
  
  public void testBug297105_09() throws Exception {
    delegate.testBug297105_09();
  }
  
  public void testBug297105_10() throws Exception {
    delegate.testBug297105_10();
  }
  
  public void testBug297105_11() throws Exception {
    delegate.testBug297105_11();
  }
  
  public void testBug297105_12() throws Exception {
    delegate.testBug297105_12();
  }
  
  public void testBug297105_13() throws Exception {
    delegate.testBug297105_13();
  }
  
  public void testBug297105_14() throws Exception {
    delegate.testBug297105_14();
  }
  
  public void testBug297105_15() throws Exception {
    delegate.testBug297105_15();
  }
  
  public void testBug297105_16() throws Exception {
    delegate.testBug297105_16();
  }
  
  public void testBug297105_17() throws Exception {
    delegate.testBug297105_17();
  }
  
  public void testBug297105_18() throws Exception {
    delegate.testBug297105_18();
  }
  
  public void testBug297105_19() throws Exception {
    delegate.testBug297105_19();
  }
  
  public void testBug297105_20() throws Exception {
    delegate.testBug297105_20();
  }
}

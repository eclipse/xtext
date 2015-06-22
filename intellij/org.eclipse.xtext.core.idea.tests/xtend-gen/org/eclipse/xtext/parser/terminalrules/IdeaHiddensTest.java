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
import org.eclipse.xtext.parser.terminalrules.HiddensTest;
import org.eclipse.xtext.parser.terminalrules.idea.HiddenTerminalsTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaHiddensTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends HiddensTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = HiddenTerminalsTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaHiddensTest.Delegate delegate;
  
  public IdeaHiddensTest() {
    super(HiddenTerminalsTestLanguageFileType.INSTANCE);
    IdeaHiddensTest.Delegate _delegate = new IdeaHiddensTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new HiddenTerminalsTestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/hiddensTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testDatatypeHiddens_01() throws Exception {
    delegate.testDatatypeHiddens_01();
  }
  
  public void testDatatypeHiddens_02() throws Exception {
    delegate.testDatatypeHiddens_02();
  }
  
  public void testDatatypeHiddens_03() throws Exception {
    delegate.testDatatypeHiddens_03();
  }
  
  public void testInheritingHiddens_01() throws Exception {
    delegate.testInheritingHiddens_01();
  }
  
  public void testInheritingHiddens_02() throws Exception {
    delegate.testInheritingHiddens_02();
  }
  
  public void testInheritingHiddens_03() throws Exception {
    delegate.testInheritingHiddens_03();
  }
  
  public void testInheritingHiddens_04() throws Exception {
    delegate.testInheritingHiddens_04();
  }
  
  public void testOverridingHiddens_01() throws Exception {
    delegate.testOverridingHiddens_01();
  }
  
  public void testOverridingHiddens_02() throws Exception {
    delegate.testOverridingHiddens_02();
  }
  
  public void testSetup() {
    delegate.testSetup();
  }
  
  public void testWithHiddens_01() throws Exception {
    delegate.testWithHiddens_01();
  }
  
  public void testWithHiddens_02() throws Exception {
    delegate.testWithHiddens_02();
  }
  
  public void testWithoutHiddens_01() throws Exception {
    delegate.testWithoutHiddens_01();
  }
  
  public void testWithoutHiddens_02() throws Exception {
    delegate.testWithoutHiddens_02();
  }
}

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
import org.eclipse.xtext.parser.terminalrules.Bug317840Test;
import org.eclipse.xtext.parser.terminalrules.idea.Bug317840TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug317840Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends Bug317840Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug317840TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBug317840Test.Delegate delegate;
  
  public IdeaBug317840Test() {
    super(Bug317840TestLanguageFileType.INSTANCE);
    IdeaBug317840Test.Delegate _delegate = new IdeaBug317840Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new Bug317840TestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/bug317840";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testCanParse_01_00() throws Exception {
    delegate.testCanParse_01_00();
  }
  
  public void testCanParse_01_01() throws Exception {
    delegate.testCanParse_01_01();
  }
  
  public void testCanParse_01_02() throws Exception {
    delegate.testCanParse_01_02();
  }
  
  public void testCanParse_01_03() throws Exception {
    delegate.testCanParse_01_03();
  }
  
  public void testCanParse_01_04() throws Exception {
    delegate.testCanParse_01_04();
  }
  
  public void testCanParse_01_05() throws Exception {
    delegate.testCanParse_01_05();
  }
  
  public void testCanParse_01_06() throws Exception {
    delegate.testCanParse_01_06();
  }
  
  public void testCanParse_01_07() throws Exception {
    delegate.testCanParse_01_07();
  }
  
  public void testCanParse_01_08() throws Exception {
    delegate.testCanParse_01_08();
  }
  
  public void testCanParse_01_09() throws Exception {
    delegate.testCanParse_01_09();
  }
  
  public void testCanParse_01_10() throws Exception {
    delegate.testCanParse_01_10();
  }
  
  public void testCanParse_01_11() throws Exception {
    delegate.testCanParse_01_11();
  }
  
  public void testCanParse_01_12() throws Exception {
    delegate.testCanParse_01_12();
  }
  
  public void testCanParse_01_13() throws Exception {
    delegate.testCanParse_01_13();
  }
  
  public void testCanParse_02_00() throws Exception {
    delegate.testCanParse_02_00();
  }
  
  public void testCanParse_02_01() throws Exception {
    delegate.testCanParse_02_01();
  }
  
  public void testCanParse_02_02() throws Exception {
    delegate.testCanParse_02_02();
  }
  
  public void testCanParse_02_03() throws Exception {
    delegate.testCanParse_02_03();
  }
  
  public void testCanParse_02_04() throws Exception {
    delegate.testCanParse_02_04();
  }
  
  public void testCanParse_02_05() throws Exception {
    delegate.testCanParse_02_05();
  }
  
  public void testCanParse_02_06() throws Exception {
    delegate.testCanParse_02_06();
  }
  
  public void testCanParse_02_07() throws Exception {
    delegate.testCanParse_02_07();
  }
  
  public void testCanParse_02_08() throws Exception {
    delegate.testCanParse_02_08();
  }
  
  public void testCanParse_02_09() throws Exception {
    delegate.testCanParse_02_09();
  }
  
  public void testCanParse_02_10() throws Exception {
    delegate.testCanParse_02_10();
  }
  
  public void testCanParse_02_11() throws Exception {
    delegate.testCanParse_02_11();
  }
  
  public void testCanParse_02_12() throws Exception {
    delegate.testCanParse_02_12();
  }
  
  public void testCanParse_02_13() throws Exception {
    delegate.testCanParse_02_13();
  }
  
  public void testCanParse_03_00() throws Exception {
    delegate.testCanParse_03_00();
  }
  
  public void testCanParse_03_01() throws Exception {
    delegate.testCanParse_03_01();
  }
  
  public void testCanParse_03_02() throws Exception {
    delegate.testCanParse_03_02();
  }
  
  public void testCanParse_03_03() throws Exception {
    delegate.testCanParse_03_03();
  }
  
  public void testCanParse_03_04() throws Exception {
    delegate.testCanParse_03_04();
  }
  
  public void testCanParse_03_05() throws Exception {
    delegate.testCanParse_03_05();
  }
  
  public void testCanParse_03_06() throws Exception {
    delegate.testCanParse_03_06();
  }
  
  public void testCanParse_03_07() throws Exception {
    delegate.testCanParse_03_07();
  }
  
  public void testCanParse_03_08() throws Exception {
    delegate.testCanParse_03_08();
  }
  
  public void testCanParse_03_09() throws Exception {
    delegate.testCanParse_03_09();
  }
  
  public void testCanParse_03_10() throws Exception {
    delegate.testCanParse_03_10();
  }
  
  public void testCanParse_03_11() throws Exception {
    delegate.testCanParse_03_11();
  }
  
  public void testCanParse_03_12() throws Exception {
    delegate.testCanParse_03_12();
  }
  
  public void testCanParse_03_13() throws Exception {
    delegate.testCanParse_03_13();
  }
  
  public void testCannotParse_01_00() throws Exception {
    delegate.testCannotParse_01_00();
  }
  
  public void testCannotParse_01_01() throws Exception {
    delegate.testCannotParse_01_01();
  }
  
  public void testCannotParse_01_02() throws Exception {
    delegate.testCannotParse_01_02();
  }
  
  public void testCannotParse_01_03() throws Exception {
    delegate.testCannotParse_01_03();
  }
  
  public void testNodeModel_01() throws Exception {
    delegate.testNodeModel_01();
  }
  
  public void testNodeModel_02() throws Exception {
    delegate.testNodeModel_02();
  }
  
  public void testNodeModel_03() throws Exception {
    delegate.testNodeModel_03();
  }
  
  public void testNodeModel_04() throws Exception {
    delegate.testNodeModel_04();
  }
  
  public void testNodeModel_05() throws Exception {
    delegate.testNodeModel_05();
  }
  
  public void testNodeModel_06() throws Exception {
    delegate.testNodeModel_06();
  }
  
  public void testNodeModel_07() throws Exception {
    delegate.testNodeModel_07();
  }
  
  public void testNodeModel_08() throws Exception {
    delegate.testNodeModel_08();
  }
  
  public void testNodeModel_09() throws Exception {
    delegate.testNodeModel_09();
  }
  
  public void testNodeModel_10() throws Exception {
    delegate.testNodeModel_10();
  }
  
  public void testNodeModel_11() throws Exception {
    delegate.testNodeModel_11();
  }
  
  public void testNodeModel_12() throws Exception {
    delegate.testNodeModel_12();
  }
  
  public void testNodeModel_13() throws Exception {
    delegate.testNodeModel_13();
  }
  
  public void testSemanticModel_01() throws Exception {
    delegate.testSemanticModel_01();
  }
  
  public void testSemanticModel_02() throws Exception {
    delegate.testSemanticModel_02();
  }
  
  public void testSemanticModel_03() throws Exception {
    delegate.testSemanticModel_03();
  }
  
  public void testSemanticModel_04() throws Exception {
    delegate.testSemanticModel_04();
  }
  
  public void testSemanticModel_05() throws Exception {
    delegate.testSemanticModel_05();
  }
  
  public void testSemanticModel_06() throws Exception {
    delegate.testSemanticModel_06();
  }
  
  public void testSemanticModel_07() throws Exception {
    delegate.testSemanticModel_07();
  }
  
  public void testSemanticModel_08() throws Exception {
    delegate.testSemanticModel_08();
  }
  
  public void testSemanticModel_09() throws Exception {
    delegate.testSemanticModel_09();
  }
  
  public void testSemanticModel_10() throws Exception {
    delegate.testSemanticModel_10();
  }
}

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
import org.eclipse.xtext.parser.antlr.Bug289524Test;
import org.eclipse.xtext.parser.antlr.idea.Bug289524TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug289524Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends Bug289524Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug289524TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBug289524Test.Delegate delegate;
  
  public IdeaBug289524Test() {
    super(Bug289524TestLanguageFileType.INSTANCE);
    IdeaBug289524Test.Delegate _delegate = new IdeaBug289524Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new Bug289524TestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug289524";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testGetModel_01() throws Exception {
    delegate.testGetModel_01();
  }
  
  public void testGetModel_02() throws Exception {
    delegate.testGetModel_02();
  }
  
  public void testGetModel_03() throws Exception {
    delegate.testGetModel_03();
  }
  
  public void testGetModel_04() throws Exception {
    delegate.testGetModel_04();
  }
  
  public void testGetModel_05() throws Exception {
    delegate.testGetModel_05();
  }
  
  public void testGetModel_06() throws Exception {
    delegate.testGetModel_06();
  }
}

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
import org.eclipse.xtext.parser.antlr.Bug301935Test;
import org.eclipse.xtext.parser.antlr.idea.Bug301935TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug301935Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends Bug301935Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug301935TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBug301935Test.Delegate delegate;
  
  public IdeaBug301935Test() {
    super(Bug301935TestLanguageFileType.INSTANCE);
    IdeaBug301935Test.Delegate _delegate = new IdeaBug301935Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new Bug301935TestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug301935";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testGetTokenDefMap_01() {
    delegate.testGetTokenDefMap_01();
  }
  
  public void testGetTokenDefMap_02() {
    delegate.testGetTokenDefMap_02();
  }
  
  public void testParseValidInput() throws Exception {
    delegate.testParseValidInput();
  }
}

package org.eclipse.xtext.parser.assignments;

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
import org.eclipse.xtext.parser.assignments.Bug287184Test;
import org.eclipse.xtext.parser.assignments.idea.Bug287184TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageFileType;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug287184Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends Bug287184Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug287184TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBug287184Test.Delegate delegate;
  
  public IdeaBug287184Test() {
    super(Bug287184TestLanguageFileType.INSTANCE);
    IdeaBug287184Test.Delegate _delegate = new IdeaBug287184Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new Bug287184TestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/assignments/bug287184";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBug287184_01() throws Exception {
    delegate.testBug287184_01();
  }
  
  public void testBug287184_02() throws Exception {
    delegate.testBug287184_02();
  }
  
  public void testBug287184_03() throws Exception {
    delegate.testBug287184_03();
  }
  
  public void testBug287184_04() throws Exception {
    delegate.testBug287184_04();
  }
  
  public void testBug287184_05() throws Exception {
    delegate.testBug287184_05();
  }
  
  public void testBug287184_06() throws Exception {
    delegate.testBug287184_06();
  }
}

package org.eclipse.xtext.parser.fragments;

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
import org.eclipse.xtext.parser.fragments.AbstractFragmentsPlainParsingTest;
import org.eclipse.xtext.parser.fragments.idea.FragmentTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageFileType;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaFragmentsTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends AbstractFragmentsPlainParsingTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = FragmentTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaFragmentsTest.Delegate delegate;
  
  public IdeaFragmentsTest() {
    super(FragmentTestLanguageFileType.INSTANCE);
    IdeaFragmentsTest.Delegate _delegate = new IdeaFragmentsTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new FragmentTestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/fragments/parserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testAction() {
    delegate.testAction();
  }
  
  public void testActionAndReference() {
    delegate.testActionAndReference();
  }
  
  public void testActionInFragmentAndReferenceLoop() {
    delegate.testActionInFragmentAndReferenceLoop();
  }
  
  public void testActionInFragmentAndReference_01() {
    delegate.testActionInFragmentAndReference_01();
  }
  
  public void testActionInFragmentAndReference_02() {
    delegate.testActionInFragmentAndReference_02();
  }
  
  public void testActionInFragment_01() {
    delegate.testActionInFragment_01();
  }
  
  public void testActionInFragment_02() {
    delegate.testActionInFragment_02();
  }
  
  public void testDatatypeRule_01() {
    delegate.testDatatypeRule_01();
  }
  
  public void testDatatypeRule_02() {
    delegate.testDatatypeRule_02();
  }
  
  public void testDatatypeRule_03() {
    delegate.testDatatypeRule_03();
  }
  
  public void testReference() {
    delegate.testReference();
  }
  
  public void testReferenceBeforeFragment() {
    delegate.testReferenceBeforeFragment();
  }
  
  public void testReferenceInFragment() {
    delegate.testReferenceInFragment();
  }
  
  public void testReference_02() {
    delegate.testReference_02();
  }
  
  public void testSimpleModel() {
    delegate.testSimpleModel();
  }
}

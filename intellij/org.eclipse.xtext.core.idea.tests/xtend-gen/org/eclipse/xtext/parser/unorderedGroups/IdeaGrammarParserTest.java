package org.eclipse.xtext.parser.unorderedGroups;

import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.XtextStandaloneSetupIdea;
import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.lang.XtextLanguage;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.unorderedGroups.GrammarParserTest;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaGrammarParserTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends GrammarParserTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = XtextLanguage.INSTANCE.<Injector>getInstance(Injector.class);
      this.setInjector(_instance);
    }
    
    @Override
    protected XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
      InputStreamReader _inputStreamReader = new InputStreamReader(in);
      String _string = CharStreams.toString(_inputStreamReader);
      EObject _checkModel = this.modelChecker.<EObject>checkModel(_string, false);
      Resource _eResource = _checkModel.eResource();
      return ((XtextResource) _eResource);
    }
    
    public Delegate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  private IdeaGrammarParserTest.Delegate delegate;
  
  public IdeaGrammarParserTest() {
    super(XtextFileType.INSTANCE);
    IdeaGrammarParserTest.Delegate _delegate = new IdeaGrammarParserTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new XtextStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/unorderedGroups/grammarParserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testAction() throws Exception {
    delegate.testAction();
  }
  
  public void testAlternatives() throws Exception {
    delegate.testAlternatives();
  }
  
  public void testAssignment() throws Exception {
    delegate.testAssignment();
  }
  
  public void testGroup() throws Exception {
    delegate.testGroup();
  }
  
  public void testKeyword() throws Exception {
    delegate.testKeyword();
  }
  
  public void testNotAllowedInAssignment() throws Exception {
    delegate.testNotAllowedInAssignment();
  }
  
  public void testPrecedencies_01() throws Exception {
    delegate.testPrecedencies_01();
  }
  
  public void testPrecedencies_02() throws Exception {
    delegate.testPrecedencies_02();
  }
  
  public void testPrecedencies_03() throws Exception {
    delegate.testPrecedencies_03();
  }
  
  public void testPrecedencies_04() throws Exception {
    delegate.testPrecedencies_04();
  }
  
  public void testPrecedencies_05() throws Exception {
    delegate.testPrecedencies_05();
  }
  
  public void testRuleCall() throws Exception {
    delegate.testRuleCall();
  }
  
  public void testUnorderedGroup_01() throws Exception {
    delegate.testUnorderedGroup_01();
  }
  
  public void testUnorderedGroup_02() throws Exception {
    delegate.testUnorderedGroup_02();
  }
}

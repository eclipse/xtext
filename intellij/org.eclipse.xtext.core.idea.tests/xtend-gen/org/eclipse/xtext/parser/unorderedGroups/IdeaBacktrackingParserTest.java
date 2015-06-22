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
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.unorderedGroups.BacktrackingParserTest;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.backtracking.idea.SimpleBeeLangTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageFileType;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBacktrackingParserTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends BacktrackingParserTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = SimpleBeeLangTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBacktrackingParserTest.Delegate delegate;
  
  public IdeaBacktrackingParserTest() {
    super(SimpleBeeLangTestLanguageFileType.INSTANCE);
    IdeaBacktrackingParserTest.Delegate _delegate = new IdeaBacktrackingParserTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new SimpleBeeLangTestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/unorderedGroups/backtrackingParserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testException_01() throws Exception {
    delegate.testException_01();
  }
  
  public void testNoException_01() throws Exception {
    delegate.testNoException_01();
  }
}

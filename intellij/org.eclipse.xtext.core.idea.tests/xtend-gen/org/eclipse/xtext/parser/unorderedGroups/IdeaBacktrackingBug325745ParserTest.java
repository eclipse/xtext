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
import org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745ParserTest;
import org.eclipse.xtext.parser.unorderedGroups.idea.SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBacktrackingBug325745ParserTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends BacktrackingBug325745ParserTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
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
  
  private IdeaBacktrackingBug325745ParserTest.Delegate delegate;
  
  public IdeaBacktrackingBug325745ParserTest() {
    super(SimpleBacktrackingBug325745TestLanguageFileType.INSTANCE);
    IdeaBacktrackingBug325745ParserTest.Delegate _delegate = new IdeaBacktrackingBug325745ParserTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/unorderedGroups/backtrackingBug325745ParserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testValid_01() throws Exception {
    delegate.testValid_01();
  }
  
  public void testValid_02() throws Exception {
    delegate.testValid_02();
  }
  
  public void testValid_03() throws Exception {
    delegate.testValid_03();
  }
  
  public void testValid_04() throws Exception {
    delegate.testValid_04();
  }
  
  public void testValid_05() throws Exception {
    delegate.testValid_05();
  }
  
  public void testValid_06() throws Exception {
    delegate.testValid_06();
  }
  
  public void testValid_07() throws Exception {
    delegate.testValid_07();
  }
  
  public void testValid_08() throws Exception {
    delegate.testValid_08();
  }
  
  public void testValid_09() throws Exception {
    delegate.testValid_09();
  }
  
  public void testValid_10() throws Exception {
    delegate.testValid_10();
  }
}

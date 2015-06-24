package org.eclipse.xtext.enumrules;

import com.google.inject.Injector;
import java.io.IOException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.enumrules.ParserTest;
import org.eclipse.xtext.enumrules.idea.EnumRulesTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageFileType;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;

@TestDecorator
@SuppressWarnings("all")
public class IdeaParserTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends ParserTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = EnumRulesTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
      this.setInjector(_instance);
    }
    
    @Override
    protected EObject parse(final String modelAsString) throws IOException {
      return this.modelChecker.<EObject>checkModel(modelAsString, false);
    }
    
    public Delegate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  private IdeaParserTest.Delegate delegate;
  
  public IdeaParserTest() {
    super(EnumRulesTestLanguageFileType.INSTANCE);
    IdeaParserTest.Delegate _delegate = new IdeaParserTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new EnumRulesTestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/enumrules/parserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testParseDifferentName() throws Exception {
    delegate.testParseDifferentName();
  }
  
  public void testParseDifferentName2() throws Exception {
    delegate.testParseDifferentName2();
  }
  
  public void testParseOverridden() throws Exception {
    delegate.testParseOverridden();
  }
  
  public void testParseSameName() throws Exception {
    delegate.testParseSameName();
  }
  
  public void testParseSameName2() throws Exception {
    delegate.testParseSameName2();
  }
}

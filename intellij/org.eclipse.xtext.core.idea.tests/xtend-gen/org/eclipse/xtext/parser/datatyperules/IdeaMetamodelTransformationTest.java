package org.eclipse.xtext.parser.datatyperules;

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
import org.eclipse.xtext.parser.datatyperules.MetamodelTransformationTest;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaMetamodelTransformationTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends MetamodelTransformationTest {
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
  
  private IdeaMetamodelTransformationTest.Delegate delegate;
  
  public IdeaMetamodelTransformationTest() {
    super(XtextFileType.INSTANCE);
    IdeaMetamodelTransformationTest.Delegate _delegate = new IdeaMetamodelTransformationTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new XtextStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/datatyperules/metamodelTransformationTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testAssignmentWithAlternative() {
    delegate.testAssignmentWithAlternative();
  }
  
  public void testFarbe() {
    delegate.testFarbe();
  }
  
  public void testOnlyKeywords() {
    delegate.testOnlyKeywords();
  }
  
  public void testRuleCalledId() {
    delegate.testRuleCalledId();
  }
  
  public void testRuleRecursiveId() {
    delegate.testRuleRecursiveId();
  }
  
  public void testRuleStartId() {
    delegate.testRuleStartId();
  }
  
  public void testRuleValue() {
    delegate.testRuleValue();
  }
  
  public void testSetUp() {
    delegate.testSetUp();
  }
  
  public void testUnorderedGroupClass() {
    delegate.testUnorderedGroupClass();
  }
  
  public void testUnorderedGroupDataType() {
    delegate.testUnorderedGroupDataType();
  }
}

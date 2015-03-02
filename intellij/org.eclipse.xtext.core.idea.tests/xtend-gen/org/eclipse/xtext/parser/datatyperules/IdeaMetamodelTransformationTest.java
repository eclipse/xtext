package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.datatyperules.IdeaMetamodelTransformationTestDelegate;

@TestDecorator
@SuppressWarnings("all")
public class IdeaMetamodelTransformationTest extends AbstractLanguageParsingTestCase {
  private IdeaMetamodelTransformationTestDelegate delegate;
  
  public IdeaMetamodelTransformationTest() {
    super(XtextFileType.INSTANCE);
    IdeaMetamodelTransformationTestDelegate _ideaMetamodelTransformationTestDelegate = new IdeaMetamodelTransformationTestDelegate(this);
    this.delegate = _ideaMetamodelTransformationTestDelegate;
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

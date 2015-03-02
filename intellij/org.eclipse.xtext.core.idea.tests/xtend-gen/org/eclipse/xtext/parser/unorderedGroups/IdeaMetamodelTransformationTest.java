package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.unorderedGroups.IdeaMetamodelTransformationTestDelegate;

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
    return "./testData/parsing/unorderedGroups/metamodelTransformationTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBooleanAssignments() throws Exception {
    delegate.testBooleanAssignments();
  }
  
  public void testMultiValueAssignments() throws Exception {
    delegate.testMultiValueAssignments();
  }
  
  public void testSimpleAssignments() throws Exception {
    delegate.testSimpleAssignments();
  }
}

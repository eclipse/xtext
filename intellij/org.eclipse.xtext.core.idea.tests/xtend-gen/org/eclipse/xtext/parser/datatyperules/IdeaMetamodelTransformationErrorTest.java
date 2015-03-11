package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.datatyperules.IdeaMetamodelTransformationErrorTestDelegate;

@TestDecorator
@SuppressWarnings("all")
public class IdeaMetamodelTransformationErrorTest extends AbstractLanguageParsingTestCase {
  private IdeaMetamodelTransformationErrorTestDelegate delegate;
  
  public IdeaMetamodelTransformationErrorTest() {
    super(XtextFileType.INSTANCE);
    IdeaMetamodelTransformationErrorTestDelegate _ideaMetamodelTransformationErrorTestDelegate = new IdeaMetamodelTransformationErrorTestDelegate(this);
    this.delegate = _ideaMetamodelTransformationErrorTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/datatyperules/metamodelTransformationErrorTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testErrorMessages() throws Exception {
    delegate.testErrorMessages();
  }
  
  public void testSetUp() {
    delegate.testSetUp();
  }
}

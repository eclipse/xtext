package org.eclipse.xtext.parser.assignments;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.assignments.IdeaBug288432TestDelegate;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug288432Test extends AbstractLanguageParsingTestCase {
  private IdeaBug288432TestDelegate delegate;
  
  public IdeaBug288432Test() {
    super(Bug288432TestLanguageFileType.INSTANCE);
    IdeaBug288432TestDelegate _ideaBug288432TestDelegate = new IdeaBug288432TestDelegate(this);
    this.delegate = _ideaBug288432TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/assignments/bug288432";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testBug288432_01() throws Exception {
    delegate.testBug288432_01();
  }
}

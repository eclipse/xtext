package org.eclipse.xtext.parser;

import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.IdeaXtextParserTestDelegate;

@TestDecorator
@SuppressWarnings("all")
public class IdeaXtextParserTest extends AbstractLanguageParsingTestCase {
  private IdeaXtextParserTestDelegate delegate;
  
  public IdeaXtextParserTest() {
    super(XtextFileType.INSTANCE);
    IdeaXtextParserTestDelegate _ideaXtextParserTestDelegate = new IdeaXtextParserTestDelegate(this);
    this.delegate = _ideaXtextParserTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/xtextParserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testParseCrossRef() throws Exception {
    delegate.testParseCrossRef();
  }
  
  public void test_resolveReturnType() throws Exception {
    delegate.test_resolveReturnType();
  }
}

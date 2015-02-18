package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.unorderedGroups.IdeaBacktrackingParserTestDelegate;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBacktrackingParserTest extends AbstractLanguageParsingTestCase {
  private IdeaBacktrackingParserTestDelegate delegate;
  
  public IdeaBacktrackingParserTest() {
    super(SimpleBeeLangTestLanguageFileType.INSTANCE);
    IdeaBacktrackingParserTestDelegate _ideaBacktrackingParserTestDelegate = new IdeaBacktrackingParserTestDelegate(this);
    this.delegate = _ideaBacktrackingParserTestDelegate;
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

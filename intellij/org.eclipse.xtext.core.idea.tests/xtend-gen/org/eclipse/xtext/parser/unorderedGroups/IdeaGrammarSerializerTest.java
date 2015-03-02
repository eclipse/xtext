package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.unorderedGroups.IdeaGrammarSerializerTestDelegate;

@TestDecorator
@SuppressWarnings("all")
public class IdeaGrammarSerializerTest extends AbstractLanguageParsingTestCase {
  private IdeaGrammarSerializerTestDelegate delegate;
  
  public IdeaGrammarSerializerTest() {
    super(XtextFileType.INSTANCE);
    IdeaGrammarSerializerTestDelegate _ideaGrammarSerializerTestDelegate = new IdeaGrammarSerializerTestDelegate(this);
    this.delegate = _ideaGrammarSerializerTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/unorderedGroups/grammarSerializerTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testSerializeGrammar() throws Exception {
    delegate.testSerializeGrammar();
  }
}

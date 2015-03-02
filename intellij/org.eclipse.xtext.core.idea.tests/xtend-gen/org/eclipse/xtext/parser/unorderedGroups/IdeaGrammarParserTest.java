package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.unorderedGroups.IdeaGrammarParserTestDelegate;

@TestDecorator
@SuppressWarnings("all")
public class IdeaGrammarParserTest extends AbstractLanguageParsingTestCase {
  private IdeaGrammarParserTestDelegate delegate;
  
  public IdeaGrammarParserTest() {
    super(XtextFileType.INSTANCE);
    IdeaGrammarParserTestDelegate _ideaGrammarParserTestDelegate = new IdeaGrammarParserTestDelegate(this);
    this.delegate = _ideaGrammarParserTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/unorderedGroups/grammarParserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testAction() throws Exception {
    delegate.testAction();
  }
  
  public void testAlternatives() throws Exception {
    delegate.testAlternatives();
  }
  
  public void testAssignment() throws Exception {
    delegate.testAssignment();
  }
  
  public void testGroup() throws Exception {
    delegate.testGroup();
  }
  
  public void testKeyword() throws Exception {
    delegate.testKeyword();
  }
  
  public void testNotAllowedInAssignment() throws Exception {
    delegate.testNotAllowedInAssignment();
  }
  
  public void testPrecedencies_01() throws Exception {
    delegate.testPrecedencies_01();
  }
  
  public void testPrecedencies_02() throws Exception {
    delegate.testPrecedencies_02();
  }
  
  public void testPrecedencies_03() throws Exception {
    delegate.testPrecedencies_03();
  }
  
  public void testPrecedencies_04() throws Exception {
    delegate.testPrecedencies_04();
  }
  
  public void testPrecedencies_05() throws Exception {
    delegate.testPrecedencies_05();
  }
  
  public void testRuleCall() throws Exception {
    delegate.testRuleCall();
  }
  
  public void testUnorderedGroup_01() throws Exception {
    delegate.testUnorderedGroup_01();
  }
  
  public void testUnorderedGroup_02() throws Exception {
    delegate.testUnorderedGroup_02();
  }
}

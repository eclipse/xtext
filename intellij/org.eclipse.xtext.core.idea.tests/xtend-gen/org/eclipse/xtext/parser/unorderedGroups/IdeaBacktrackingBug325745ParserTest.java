package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745ParserTestDelegate;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBacktrackingBug325745ParserTest extends AbstractLanguageParsingTestCase {
  private BacktrackingBug325745ParserTestDelegate delegate;
  
  public IdeaBacktrackingBug325745ParserTest() {
    super(SimpleBacktrackingBug325745TestLanguageFileType.INSTANCE);
    BacktrackingBug325745ParserTestDelegate _backtrackingBug325745ParserTestDelegate = new BacktrackingBug325745ParserTestDelegate(this);
    this.delegate = _backtrackingBug325745ParserTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/unorderedGroups/backtrackingBug325745ParserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testValid_01() throws Exception {
    delegate.testValid_01();
  }
  
  public void testValid_02() throws Exception {
    delegate.testValid_02();
  }
  
  public void testValid_03() throws Exception {
    delegate.testValid_03();
  }
  
  public void testValid_04() throws Exception {
    delegate.testValid_04();
  }
  
  public void testValid_05() throws Exception {
    delegate.testValid_05();
  }
  
  public void testValid_06() throws Exception {
    delegate.testValid_06();
  }
  
  public void testValid_07() throws Exception {
    delegate.testValid_07();
  }
  
  public void testValid_08() throws Exception {
    delegate.testValid_08();
  }
  
  public void testValid_09() throws Exception {
    delegate.testValid_09();
  }
  
  public void testValid_10() throws Exception {
    delegate.testValid_10();
  }
}

package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.terminalrules.IdeaUnicodeTestDelegate;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaUnicodeTest extends AbstractLanguageParsingTestCase {
  private IdeaUnicodeTestDelegate delegate;
  
  public IdeaUnicodeTest() {
    super(UnicodeTestLanguageFileType.INSTANCE);
    IdeaUnicodeTestDelegate _ideaUnicodeTestDelegate = new IdeaUnicodeTestDelegate(this);
    this.delegate = _ideaUnicodeTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/unicodeTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testParse() throws Exception {
    delegate.testParse();
  }
  
  public void testParseSTRING() throws Exception {
    delegate.testParseSTRING();
  }
  
  public void testWrite() throws Exception {
    delegate.testWrite();
  }
}

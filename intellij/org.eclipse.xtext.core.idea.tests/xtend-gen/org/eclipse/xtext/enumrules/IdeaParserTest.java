package org.eclipse.xtext.enumrules;

import org.eclipse.xtext.enumrules.IdeaParserTestDelegate;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageFileType;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;

@TestDecorator
@SuppressWarnings("all")
public class IdeaParserTest extends AbstractLanguageParsingTestCase {
  private IdeaParserTestDelegate delegate;
  
  public IdeaParserTest() {
    super(EnumRulesTestLanguageFileType.INSTANCE);
    IdeaParserTestDelegate _ideaParserTestDelegate = new IdeaParserTestDelegate(this);
    this.delegate = _ideaParserTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/enumrules/parserTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testParseDifferentName() throws Exception {
    delegate.testParseDifferentName();
  }
  
  public void testParseDifferentName2() throws Exception {
    delegate.testParseDifferentName2();
  }
  
  public void testParseOverridden() throws Exception {
    delegate.testParseOverridden();
  }
  
  public void testParseSameName() throws Exception {
    delegate.testParseSameName();
  }
  
  public void testParseSameName2() throws Exception {
    delegate.testParseSameName2();
  }
}

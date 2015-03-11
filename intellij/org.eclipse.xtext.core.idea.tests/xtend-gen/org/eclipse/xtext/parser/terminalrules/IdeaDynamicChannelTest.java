package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.terminalrules.IdeaDynamicChannelTestDelegate;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaDynamicChannelTest extends AbstractLanguageParsingTestCase {
  private IdeaDynamicChannelTestDelegate delegate;
  
  public IdeaDynamicChannelTest() {
    super(XtextTerminalsTestLanguageFileType.INSTANCE);
    IdeaDynamicChannelTestDelegate _ideaDynamicChannelTestDelegate = new IdeaDynamicChannelTestDelegate(this);
    this.delegate = _ideaDynamicChannelTestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/terminalrules/dynamicChannelTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testNodeModelOfSimpleLanguage() throws Exception {
    delegate.testNodeModelOfSimpleLanguage();
  }
  
  public void testParseSimpleLanguage() throws Exception {
    delegate.testParseSimpleLanguage();
  }
}

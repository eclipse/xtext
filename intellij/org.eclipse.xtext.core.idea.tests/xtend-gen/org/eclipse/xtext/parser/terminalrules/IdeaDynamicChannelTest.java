package org.eclipse.xtext.parser.terminalrules;

import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.terminalrules.DynamicChannelTest;
import org.eclipse.xtext.parser.terminalrules.idea.XtextTerminalsTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaDynamicChannelTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends DynamicChannelTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = XtextTerminalsTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
      this.setInjector(_instance);
    }
    
    @Override
    protected IParseResult parse(final String model) {
      XtextResource _checkResource = this.modelChecker.checkResource(model, false);
      return _checkResource.getParseResult();
    }
    
    public Delegate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  private IdeaDynamicChannelTest.Delegate delegate;
  
  public IdeaDynamicChannelTest() {
    super(XtextTerminalsTestLanguageFileType.INSTANCE);
    IdeaDynamicChannelTest.Delegate _delegate = new IdeaDynamicChannelTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new XtextTerminalsTestLanguageStandaloneSetupIdea();
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

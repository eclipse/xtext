package org.eclipse.xtext.parser.terminalrules;

import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.terminalrules.DynamicChannelTest;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Ignore;

@Ignore
@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaDynamicChannelTestDelegate extends DynamicChannelTest {
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
  
  public IdeaDynamicChannelTestDelegate(final ModelChecker modelChecker) {
    super();
    this.modelChecker = modelChecker;
  }
}

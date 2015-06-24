package org.eclipse.xtext.testlanguages.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.testlanguages.idea.PartialParserTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class PartialParserTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      PartialParserTestLanguageStandaloneSetupIdea _partialParserTestLanguageStandaloneSetupIdea = new PartialParserTestLanguageStandaloneSetupIdea();
      _xblockexpression = _partialParserTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

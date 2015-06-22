package org.eclipse.xtext.generator.grammarAccess.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.grammarAccess.idea.GrammarAccessTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class GrammarAccessTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      GrammarAccessTestLanguageStandaloneSetupIdea _grammarAccessTestLanguageStandaloneSetupIdea = new GrammarAccessTestLanguageStandaloneSetupIdea();
      _xblockexpression = _grammarAccessTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

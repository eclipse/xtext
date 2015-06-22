package org.eclipse.xtext.testlanguages.backtracking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.testlanguages.backtracking.idea.BeeLangTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class BeeLangTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      BeeLangTestLanguageStandaloneSetupIdea _beeLangTestLanguageStandaloneSetupIdea = new BeeLangTestLanguageStandaloneSetupIdea();
      _xblockexpression = _beeLangTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.testlanguages.backtracking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.testlanguages.backtracking.idea.ExBeeLangTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ExBeeLangTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ExBeeLangTestLanguageStandaloneSetupIdea _exBeeLangTestLanguageStandaloneSetupIdea = new ExBeeLangTestLanguageStandaloneSetupIdea();
      _xblockexpression = _exBeeLangTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.enumrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.enumrules.idea.EnumRulesTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class EnumRulesTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EnumRulesTestLanguageStandaloneSetupIdea _enumRulesTestLanguageStandaloneSetupIdea = new EnumRulesTestLanguageStandaloneSetupIdea();
      _xblockexpression = _enumRulesTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

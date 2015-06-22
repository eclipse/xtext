package org.eclipse.xtext.enumrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.enumrules.idea.MultiRuleEnumTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class MultiRuleEnumTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      MultiRuleEnumTestLanguageStandaloneSetupIdea _multiRuleEnumTestLanguageStandaloneSetupIdea = new MultiRuleEnumTestLanguageStandaloneSetupIdea();
      _xblockexpression = _multiRuleEnumTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

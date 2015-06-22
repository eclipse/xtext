package org.eclipse.xtext.xtext.ecoreInference.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.xtext.ecoreInference.idea.UnassignedRuleCallTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class UnassignedRuleCallTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      UnassignedRuleCallTestLanguageStandaloneSetupIdea _unassignedRuleCallTestLanguageStandaloneSetupIdea = new UnassignedRuleCallTestLanguageStandaloneSetupIdea();
      _xblockexpression = _unassignedRuleCallTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

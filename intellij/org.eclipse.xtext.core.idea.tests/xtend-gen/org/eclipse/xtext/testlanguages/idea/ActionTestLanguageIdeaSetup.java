package org.eclipse.xtext.testlanguages.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.testlanguages.idea.ActionTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ActionTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ActionTestLanguageStandaloneSetupIdea _actionTestLanguageStandaloneSetupIdea = new ActionTestLanguageStandaloneSetupIdea();
      _xblockexpression = _actionTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

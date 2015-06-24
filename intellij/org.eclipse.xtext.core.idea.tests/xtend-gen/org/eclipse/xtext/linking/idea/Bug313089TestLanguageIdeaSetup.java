package org.eclipse.xtext.linking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.idea.Bug313089TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug313089TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug313089TestLanguageStandaloneSetupIdea _bug313089TestLanguageStandaloneSetupIdea = new Bug313089TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug313089TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

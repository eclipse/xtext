package org.eclipse.xtext.linking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.idea.Bug289059TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug289059TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug289059TestLanguageStandaloneSetupIdea _bug289059TestLanguageStandaloneSetupIdea = new Bug289059TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug289059TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

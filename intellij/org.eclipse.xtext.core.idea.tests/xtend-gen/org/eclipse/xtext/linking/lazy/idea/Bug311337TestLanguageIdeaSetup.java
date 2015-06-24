package org.eclipse.xtext.linking.lazy.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.lazy.idea.Bug311337TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug311337TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug311337TestLanguageStandaloneSetupIdea _bug311337TestLanguageStandaloneSetupIdea = new Bug311337TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug311337TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

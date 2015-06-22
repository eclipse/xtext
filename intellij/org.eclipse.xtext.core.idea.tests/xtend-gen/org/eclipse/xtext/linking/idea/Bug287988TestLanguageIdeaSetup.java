package org.eclipse.xtext.linking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.idea.Bug287988TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug287988TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug287988TestLanguageStandaloneSetupIdea _bug287988TestLanguageStandaloneSetupIdea = new Bug287988TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug287988TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

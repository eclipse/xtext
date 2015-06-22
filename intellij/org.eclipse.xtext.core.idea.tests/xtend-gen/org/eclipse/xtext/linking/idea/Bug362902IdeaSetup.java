package org.eclipse.xtext.linking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.idea.Bug362902StandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug362902IdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug362902StandaloneSetupIdea _bug362902StandaloneSetupIdea = new Bug362902StandaloneSetupIdea();
      _xblockexpression = _bug362902StandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

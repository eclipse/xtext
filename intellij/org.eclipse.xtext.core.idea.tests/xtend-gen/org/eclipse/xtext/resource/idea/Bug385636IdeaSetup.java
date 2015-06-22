package org.eclipse.xtext.resource.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.resource.idea.Bug385636StandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug385636IdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug385636StandaloneSetupIdea _bug385636StandaloneSetupIdea = new Bug385636StandaloneSetupIdea();
      _xblockexpression = _bug385636StandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.parsetree.impl.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.impl.idea.Bug305397StandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug305397IdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug305397StandaloneSetupIdea _bug305397StandaloneSetupIdea = new Bug305397StandaloneSetupIdea();
      _xblockexpression = _bug305397StandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.idea.sdomain.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.idea.sdomain.idea.SDomainStandaloneSetupIdea;

@SuppressWarnings("all")
public class SDomainIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SDomainStandaloneSetupIdea _sDomainStandaloneSetupIdea = new SDomainStandaloneSetupIdea();
      _xblockexpression = _sDomainStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

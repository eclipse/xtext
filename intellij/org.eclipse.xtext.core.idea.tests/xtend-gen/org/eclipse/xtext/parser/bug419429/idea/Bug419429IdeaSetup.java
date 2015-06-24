package org.eclipse.xtext.parser.bug419429.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.bug419429.idea.Bug419429StandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug419429IdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug419429StandaloneSetupIdea _bug419429StandaloneSetupIdea = new Bug419429StandaloneSetupIdea();
      _xblockexpression = _bug419429StandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

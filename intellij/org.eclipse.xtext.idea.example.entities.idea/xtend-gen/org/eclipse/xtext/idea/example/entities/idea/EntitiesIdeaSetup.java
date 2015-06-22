package org.eclipse.xtext.idea.example.entities.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.example.entities.idea.EntitiesStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class EntitiesIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EntitiesStandaloneSetupIdea _entitiesStandaloneSetupIdea = new EntitiesStandaloneSetupIdea();
      _xblockexpression = _entitiesStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

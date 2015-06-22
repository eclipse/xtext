package org.eclipse.xtext.resource.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.resource.idea.LiveContainerTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class LiveContainerTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      LiveContainerTestLanguageStandaloneSetupIdea _liveContainerTestLanguageStandaloneSetupIdea = new LiveContainerTestLanguageStandaloneSetupIdea();
      _xblockexpression = _liveContainerTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.resource.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.resource.idea.LiveContainerBuilderIntegerationTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class LiveContainerBuilderIntegerationTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      LiveContainerBuilderIntegerationTestLanguageStandaloneSetupIdea _liveContainerBuilderIntegerationTestLanguageStandaloneSetupIdea = new LiveContainerBuilderIntegerationTestLanguageStandaloneSetupIdea();
      _xblockexpression = _liveContainerBuilderIntegerationTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

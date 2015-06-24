package org.eclipse.xtext.serializer.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.serializer.idea.ContextFinderTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ContextFinderTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ContextFinderTestLanguageStandaloneSetupIdea _contextFinderTestLanguageStandaloneSetupIdea = new ContextFinderTestLanguageStandaloneSetupIdea();
      _xblockexpression = _contextFinderTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

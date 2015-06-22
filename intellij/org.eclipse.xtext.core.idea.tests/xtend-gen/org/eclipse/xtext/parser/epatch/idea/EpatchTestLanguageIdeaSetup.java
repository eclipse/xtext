package org.eclipse.xtext.parser.epatch.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.epatch.idea.EpatchTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class EpatchTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EpatchTestLanguageStandaloneSetupIdea _epatchTestLanguageStandaloneSetupIdea = new EpatchTestLanguageStandaloneSetupIdea();
      _xblockexpression = _epatchTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

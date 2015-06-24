package org.eclipse.xtext.parser.unorderedGroups.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.unorderedGroups.idea.ExBacktrackingBug325745TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ExBacktrackingBug325745TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ExBacktrackingBug325745TestLanguageStandaloneSetupIdea _exBacktrackingBug325745TestLanguageStandaloneSetupIdea = new ExBacktrackingBug325745TestLanguageStandaloneSetupIdea();
      _xblockexpression = _exBacktrackingBug325745TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.parser.unorderedGroups.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.unorderedGroups.idea.BacktrackingBug325745TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class BacktrackingBug325745TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      BacktrackingBug325745TestLanguageStandaloneSetupIdea _backtrackingBug325745TestLanguageStandaloneSetupIdea = new BacktrackingBug325745TestLanguageStandaloneSetupIdea();
      _xblockexpression = _backtrackingBug325745TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

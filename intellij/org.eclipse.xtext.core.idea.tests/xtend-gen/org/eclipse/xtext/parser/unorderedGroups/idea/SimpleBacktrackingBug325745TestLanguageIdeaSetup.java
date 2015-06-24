package org.eclipse.xtext.parser.unorderedGroups.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.unorderedGroups.idea.SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class SimpleBacktrackingBug325745TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea _simpleBacktrackingBug325745TestLanguageStandaloneSetupIdea = new SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea();
      _xblockexpression = _simpleBacktrackingBug325745TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

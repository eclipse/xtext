package org.eclipse.xtext.parser.unorderedGroups.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.unorderedGroups.idea.ExUnorderedGroupsTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ExUnorderedGroupsTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ExUnorderedGroupsTestLanguageStandaloneSetupIdea _exUnorderedGroupsTestLanguageStandaloneSetupIdea = new ExUnorderedGroupsTestLanguageStandaloneSetupIdea();
      _xblockexpression = _exUnorderedGroupsTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

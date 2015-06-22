package org.eclipse.xtext.testlanguages.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.testlanguages.idea.OptionalEmptyTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class OptionalEmptyTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      OptionalEmptyTestLanguageStandaloneSetupIdea _optionalEmptyTestLanguageStandaloneSetupIdea = new OptionalEmptyTestLanguageStandaloneSetupIdea();
      _xblockexpression = _optionalEmptyTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.linking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.idea.IgnoreCaseImportsTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class IgnoreCaseImportsTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      IgnoreCaseImportsTestLanguageStandaloneSetupIdea _ignoreCaseImportsTestLanguageStandaloneSetupIdea = new IgnoreCaseImportsTestLanguageStandaloneSetupIdea();
      _xblockexpression = _ignoreCaseImportsTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

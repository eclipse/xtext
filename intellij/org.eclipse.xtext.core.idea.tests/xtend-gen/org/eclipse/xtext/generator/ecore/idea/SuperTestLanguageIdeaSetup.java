package org.eclipse.xtext.generator.ecore.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.ecore.idea.SuperTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class SuperTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SuperTestLanguageStandaloneSetupIdea _superTestLanguageStandaloneSetupIdea = new SuperTestLanguageStandaloneSetupIdea();
      _xblockexpression = _superTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

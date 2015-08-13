package org.eclipse.xtext.grammarinheritance.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.grammarinheritance.idea.InheritanceTest3LanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class InheritanceTest3LanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      InheritanceTest3LanguageStandaloneSetupIdea _inheritanceTest3LanguageStandaloneSetupIdea = new InheritanceTest3LanguageStandaloneSetupIdea();
      _xblockexpression = _inheritanceTest3LanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.grammarinheritance.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.grammarinheritance.idea.InheritanceTest2LanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class InheritanceTest2LanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      InheritanceTest2LanguageStandaloneSetupIdea _inheritanceTest2LanguageStandaloneSetupIdea = new InheritanceTest2LanguageStandaloneSetupIdea();
      _xblockexpression = _inheritanceTest2LanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.grammarinheritance.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.grammarinheritance.idea.InheritanceTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class InheritanceTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      InheritanceTestLanguageStandaloneSetupIdea _inheritanceTestLanguageStandaloneSetupIdea = new InheritanceTestLanguageStandaloneSetupIdea();
      _xblockexpression = _inheritanceTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

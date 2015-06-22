package org.eclipse.xtext.grammarinheritance.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.grammarinheritance.idea.ConcreteTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class ConcreteTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ConcreteTestLanguageStandaloneSetupIdea _concreteTestLanguageStandaloneSetupIdea = new ConcreteTestLanguageStandaloneSetupIdea();
      _xblockexpression = _concreteTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

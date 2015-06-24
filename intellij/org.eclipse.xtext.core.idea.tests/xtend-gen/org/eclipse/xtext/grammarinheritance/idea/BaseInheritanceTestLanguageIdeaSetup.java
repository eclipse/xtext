package org.eclipse.xtext.grammarinheritance.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.grammarinheritance.idea.BaseInheritanceTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class BaseInheritanceTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      BaseInheritanceTestLanguageStandaloneSetupIdea _baseInheritanceTestLanguageStandaloneSetupIdea = new BaseInheritanceTestLanguageStandaloneSetupIdea();
      _xblockexpression = _baseInheritanceTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

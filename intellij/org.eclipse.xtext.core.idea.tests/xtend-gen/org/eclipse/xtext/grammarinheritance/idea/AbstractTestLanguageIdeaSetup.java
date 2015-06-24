package org.eclipse.xtext.grammarinheritance.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.grammarinheritance.idea.AbstractTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class AbstractTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      AbstractTestLanguageStandaloneSetupIdea _abstractTestLanguageStandaloneSetupIdea = new AbstractTestLanguageStandaloneSetupIdea();
      _xblockexpression = _abstractTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

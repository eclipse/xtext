package org.eclipse.xtext.validation.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.validation.idea.ConcreteSyntaxValidationTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ConcreteSyntaxValidationTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ConcreteSyntaxValidationTestLanguageStandaloneSetupIdea _concreteSyntaxValidationTestLanguageStandaloneSetupIdea = new ConcreteSyntaxValidationTestLanguageStandaloneSetupIdea();
      _xblockexpression = _concreteSyntaxValidationTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

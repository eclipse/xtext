package org.eclipse.xtext.metamodelreferencing.tests.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.metamodelreferencing.tests.idea.EcoreReferenceTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class EcoreReferenceTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EcoreReferenceTestLanguageStandaloneSetupIdea _ecoreReferenceTestLanguageStandaloneSetupIdea = new EcoreReferenceTestLanguageStandaloneSetupIdea();
      _xblockexpression = _ecoreReferenceTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

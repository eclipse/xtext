package org.eclipse.xtext.enumrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.enumrules.idea.EnumAndReferenceTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class EnumAndReferenceTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EnumAndReferenceTestLanguageStandaloneSetupIdea _enumAndReferenceTestLanguageStandaloneSetupIdea = new EnumAndReferenceTestLanguageStandaloneSetupIdea();
      _xblockexpression = _enumAndReferenceTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

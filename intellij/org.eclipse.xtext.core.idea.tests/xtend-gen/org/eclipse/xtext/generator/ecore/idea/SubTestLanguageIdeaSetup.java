package org.eclipse.xtext.generator.ecore.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.ecore.idea.SubTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class SubTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SubTestLanguageStandaloneSetupIdea _subTestLanguageStandaloneSetupIdea = new SubTestLanguageStandaloneSetupIdea();
      _xblockexpression = _subTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

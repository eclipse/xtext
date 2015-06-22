package org.eclipse.xtext.generator.ecore.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.ecore.idea.EcoreFragmentTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class EcoreFragmentTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EcoreFragmentTestLanguageStandaloneSetupIdea _ecoreFragmentTestLanguageStandaloneSetupIdea = new EcoreFragmentTestLanguageStandaloneSetupIdea();
      _xblockexpression = _ecoreFragmentTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

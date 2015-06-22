package org.eclipse.xtext.linking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.idea.LangATestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class LangATestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      LangATestLanguageStandaloneSetupIdea _langATestLanguageStandaloneSetupIdea = new LangATestLanguageStandaloneSetupIdea();
      _xblockexpression = _langATestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

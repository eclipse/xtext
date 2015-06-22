package org.eclipse.xtext.parsetree.reconstr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.reconstr.idea.Bug302128TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug302128TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug302128TestLanguageStandaloneSetupIdea _bug302128TestLanguageStandaloneSetupIdea = new Bug302128TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug302128TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

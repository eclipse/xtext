package org.eclipse.xtext.parsetree.reconstr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.reconstr.idea.Bug299395TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug299395TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug299395TestLanguageStandaloneSetupIdea _bug299395TestLanguageStandaloneSetupIdea = new Bug299395TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug299395TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

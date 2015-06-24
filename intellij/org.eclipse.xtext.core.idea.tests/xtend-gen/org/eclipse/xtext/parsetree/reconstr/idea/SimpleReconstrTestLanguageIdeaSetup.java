package org.eclipse.xtext.parsetree.reconstr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.reconstr.idea.SimpleReconstrTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class SimpleReconstrTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SimpleReconstrTestLanguageStandaloneSetupIdea _simpleReconstrTestLanguageStandaloneSetupIdea = new SimpleReconstrTestLanguageStandaloneSetupIdea();
      _xblockexpression = _simpleReconstrTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

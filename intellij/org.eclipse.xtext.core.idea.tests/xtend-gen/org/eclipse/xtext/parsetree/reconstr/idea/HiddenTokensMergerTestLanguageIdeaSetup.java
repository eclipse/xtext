package org.eclipse.xtext.parsetree.reconstr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.reconstr.idea.HiddenTokensMergerTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class HiddenTokensMergerTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      HiddenTokensMergerTestLanguageStandaloneSetupIdea _hiddenTokensMergerTestLanguageStandaloneSetupIdea = new HiddenTokensMergerTestLanguageStandaloneSetupIdea();
      _xblockexpression = _hiddenTokensMergerTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

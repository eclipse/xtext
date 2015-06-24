package org.eclipse.xtext.parsetree.unassignedtext.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.unassignedtext.idea.UnassignedTextTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class UnassignedTextTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      UnassignedTextTestLanguageStandaloneSetupIdea _unassignedTextTestLanguageStandaloneSetupIdea = new UnassignedTextTestLanguageStandaloneSetupIdea();
      _xblockexpression = _unassignedTextTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

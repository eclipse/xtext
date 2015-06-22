package org.eclipse.xtext.testlanguages.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.testlanguages.idea.SimpleExpressionsTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class SimpleExpressionsTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SimpleExpressionsTestLanguageStandaloneSetupIdea _simpleExpressionsTestLanguageStandaloneSetupIdea = new SimpleExpressionsTestLanguageStandaloneSetupIdea();
      _xblockexpression = _simpleExpressionsTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

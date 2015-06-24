package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug299237TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug299237TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug299237TestLanguageStandaloneSetupIdea _bug299237TestLanguageStandaloneSetupIdea = new Bug299237TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug299237TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.parser.keywords.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.keywords.idea.KeywordsTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class KeywordsTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      KeywordsTestLanguageStandaloneSetupIdea _keywordsTestLanguageStandaloneSetupIdea = new KeywordsTestLanguageStandaloneSetupIdea();
      _xblockexpression = _keywordsTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

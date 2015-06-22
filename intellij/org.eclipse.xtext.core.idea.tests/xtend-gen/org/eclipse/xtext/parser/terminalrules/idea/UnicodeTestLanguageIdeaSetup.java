package org.eclipse.xtext.parser.terminalrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.terminalrules.idea.UnicodeTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class UnicodeTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      UnicodeTestLanguageStandaloneSetupIdea _unicodeTestLanguageStandaloneSetupIdea = new UnicodeTestLanguageStandaloneSetupIdea();
      _xblockexpression = _unicodeTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

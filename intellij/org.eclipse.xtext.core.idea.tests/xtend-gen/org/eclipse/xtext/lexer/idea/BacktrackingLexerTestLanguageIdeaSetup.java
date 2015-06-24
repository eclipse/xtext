package org.eclipse.xtext.lexer.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.lexer.idea.BacktrackingLexerTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class BacktrackingLexerTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      BacktrackingLexerTestLanguageStandaloneSetupIdea _backtrackingLexerTestLanguageStandaloneSetupIdea = new BacktrackingLexerTestLanguageStandaloneSetupIdea();
      _xblockexpression = _backtrackingLexerTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

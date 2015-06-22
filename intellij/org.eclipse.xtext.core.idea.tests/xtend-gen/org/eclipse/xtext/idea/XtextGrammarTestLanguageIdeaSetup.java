package org.eclipse.xtext.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.XtextGrammarTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class XtextGrammarTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      XtextGrammarTestLanguageStandaloneSetupIdea _xtextGrammarTestLanguageStandaloneSetupIdea = new XtextGrammarTestLanguageStandaloneSetupIdea();
      _xblockexpression = _xtextGrammarTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

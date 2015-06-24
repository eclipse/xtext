package org.eclipse.xtext.parser.indentation.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.indentation.idea.IndentationAwareTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class IndentationAwareTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      IndentationAwareTestLanguageStandaloneSetupIdea _indentationAwareTestLanguageStandaloneSetupIdea = new IndentationAwareTestLanguageStandaloneSetupIdea();
      _xblockexpression = _indentationAwareTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

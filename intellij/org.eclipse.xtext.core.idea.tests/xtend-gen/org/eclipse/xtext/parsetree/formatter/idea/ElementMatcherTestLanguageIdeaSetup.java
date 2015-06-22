package org.eclipse.xtext.parsetree.formatter.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.formatter.idea.ElementMatcherTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ElementMatcherTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ElementMatcherTestLanguageStandaloneSetupIdea _elementMatcherTestLanguageStandaloneSetupIdea = new ElementMatcherTestLanguageStandaloneSetupIdea();
      _xblockexpression = _elementMatcherTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

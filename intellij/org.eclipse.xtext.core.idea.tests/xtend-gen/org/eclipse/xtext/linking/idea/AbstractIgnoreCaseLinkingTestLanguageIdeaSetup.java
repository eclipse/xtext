package org.eclipse.xtext.linking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.idea.AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class AbstractIgnoreCaseLinkingTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupIdea _abstractIgnoreCaseLinkingTestLanguageStandaloneSetupIdea = new AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupIdea();
      _xblockexpression = _abstractIgnoreCaseLinkingTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

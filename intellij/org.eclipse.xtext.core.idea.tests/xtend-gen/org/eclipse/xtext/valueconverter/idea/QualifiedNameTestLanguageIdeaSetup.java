package org.eclipse.xtext.valueconverter.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.valueconverter.idea.QualifiedNameTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class QualifiedNameTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      QualifiedNameTestLanguageStandaloneSetupIdea _qualifiedNameTestLanguageStandaloneSetupIdea = new QualifiedNameTestLanguageStandaloneSetupIdea();
      _xblockexpression = _qualifiedNameTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

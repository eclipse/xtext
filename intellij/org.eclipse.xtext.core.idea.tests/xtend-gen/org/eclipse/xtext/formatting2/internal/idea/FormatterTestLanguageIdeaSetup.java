package org.eclipse.xtext.formatting2.internal.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.formatting2.internal.idea.FormatterTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class FormatterTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      FormatterTestLanguageStandaloneSetupIdea _formatterTestLanguageStandaloneSetupIdea = new FormatterTestLanguageStandaloneSetupIdea();
      _xblockexpression = _formatterTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

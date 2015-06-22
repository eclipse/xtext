package org.eclipse.xtext.linking.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.linking.idea.ImportUriTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ImportUriTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ImportUriTestLanguageStandaloneSetupIdea _importUriTestLanguageStandaloneSetupIdea = new ImportUriTestLanguageStandaloneSetupIdea();
      _xblockexpression = _importUriTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

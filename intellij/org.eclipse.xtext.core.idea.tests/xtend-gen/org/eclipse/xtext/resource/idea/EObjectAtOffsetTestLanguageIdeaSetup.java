package org.eclipse.xtext.resource.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.resource.idea.EObjectAtOffsetTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class EObjectAtOffsetTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EObjectAtOffsetTestLanguageStandaloneSetupIdea _eObjectAtOffsetTestLanguageStandaloneSetupIdea = new EObjectAtOffsetTestLanguageStandaloneSetupIdea();
      _xblockexpression = _eObjectAtOffsetTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

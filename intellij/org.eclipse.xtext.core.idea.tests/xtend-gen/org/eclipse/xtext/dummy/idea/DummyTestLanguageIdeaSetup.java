package org.eclipse.xtext.dummy.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.dummy.idea.DummyTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class DummyTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      DummyTestLanguageStandaloneSetupIdea _dummyTestLanguageStandaloneSetupIdea = new DummyTestLanguageStandaloneSetupIdea();
      _xblockexpression = _dummyTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

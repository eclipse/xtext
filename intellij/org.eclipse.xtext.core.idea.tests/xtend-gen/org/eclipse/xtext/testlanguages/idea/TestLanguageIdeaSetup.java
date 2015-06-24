package org.eclipse.xtext.testlanguages.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.testlanguages.idea.TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      TestLanguageStandaloneSetupIdea _testLanguageStandaloneSetupIdea = new TestLanguageStandaloneSetupIdea();
      _xblockexpression = _testLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

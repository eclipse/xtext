package org.eclipse.xtext.parser.fragments.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.fragments.idea.FragmentTestLanguageExStandaloneSetupIdea;

@SuppressWarnings("all")
public class FragmentTestLanguageExIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      FragmentTestLanguageExStandaloneSetupIdea _fragmentTestLanguageExStandaloneSetupIdea = new FragmentTestLanguageExStandaloneSetupIdea();
      _xblockexpression = _fragmentTestLanguageExStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

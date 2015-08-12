package org.eclipse.xtext.parser.fragments.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.fragments.idea.FragmentTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class FragmentTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      FragmentTestLanguageStandaloneSetupIdea _fragmentTestLanguageStandaloneSetupIdea = new FragmentTestLanguageStandaloneSetupIdea();
      _xblockexpression = _fragmentTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

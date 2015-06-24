package org.eclipse.xtext.index.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.index.idea.IndexTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class IndexTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      IndexTestLanguageStandaloneSetupIdea _indexTestLanguageStandaloneSetupIdea = new IndexTestLanguageStandaloneSetupIdea();
      _xblockexpression = _indexTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

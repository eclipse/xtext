package org.eclipse.xtext.parsetree.reconstr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.reconstr.idea.PartialSerializationTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class PartialSerializationTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      PartialSerializationTestLanguageStandaloneSetupIdea _partialSerializationTestLanguageStandaloneSetupIdea = new PartialSerializationTestLanguageStandaloneSetupIdea();
      _xblockexpression = _partialSerializationTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

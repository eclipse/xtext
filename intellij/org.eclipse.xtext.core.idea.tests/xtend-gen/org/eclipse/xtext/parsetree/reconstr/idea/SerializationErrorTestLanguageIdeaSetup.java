package org.eclipse.xtext.parsetree.reconstr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.reconstr.idea.SerializationErrorTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class SerializationErrorTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SerializationErrorTestLanguageStandaloneSetupIdea _serializationErrorTestLanguageStandaloneSetupIdea = new SerializationErrorTestLanguageStandaloneSetupIdea();
      _xblockexpression = _serializationErrorTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

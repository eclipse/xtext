package org.eclipse.xtext.parser.encoding.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.encoding.idea.EncodingTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class EncodingTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EncodingTestLanguageStandaloneSetupIdea _encodingTestLanguageStandaloneSetupIdea = new EncodingTestLanguageStandaloneSetupIdea();
      _xblockexpression = _encodingTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

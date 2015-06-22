package org.eclipse.xtext.serializer.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.serializer.idea.SequencerTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class SequencerTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SequencerTestLanguageStandaloneSetupIdea _sequencerTestLanguageStandaloneSetupIdea = new SequencerTestLanguageStandaloneSetupIdea();
      _xblockexpression = _sequencerTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

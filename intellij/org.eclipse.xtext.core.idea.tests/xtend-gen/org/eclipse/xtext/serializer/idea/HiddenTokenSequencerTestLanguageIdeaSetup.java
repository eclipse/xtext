package org.eclipse.xtext.serializer.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.serializer.idea.HiddenTokenSequencerTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class HiddenTokenSequencerTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      HiddenTokenSequencerTestLanguageStandaloneSetupIdea _hiddenTokenSequencerTestLanguageStandaloneSetupIdea = new HiddenTokenSequencerTestLanguageStandaloneSetupIdea();
      _xblockexpression = _hiddenTokenSequencerTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

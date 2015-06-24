package org.eclipse.xtext.serializer.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.serializer.idea.SyntacticSequencerTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class SyntacticSequencerTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      SyntacticSequencerTestLanguageStandaloneSetupIdea _syntacticSequencerTestLanguageStandaloneSetupIdea = new SyntacticSequencerTestLanguageStandaloneSetupIdea();
      _xblockexpression = _syntacticSequencerTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.xtext.ecoreInference.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.xtext.ecoreInference.idea.MultiValueFeatureTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class MultiValueFeatureTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      MultiValueFeatureTestLanguageStandaloneSetupIdea _multiValueFeatureTestLanguageStandaloneSetupIdea = new MultiValueFeatureTestLanguageStandaloneSetupIdea();
      _xblockexpression = _multiValueFeatureTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

package org.eclipse.xtext.parser.parameters.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;

@SuppressWarnings("all")
public class NoParametersTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field EcoreGlobalRegistries is undefined"
      + "\nNoParametersTestLanguageStandaloneSetupIdea cannot be resolved."
      + "\nensureInitialized cannot be resolved"
      + "\ncreateInjector cannot be resolved");
  }
}

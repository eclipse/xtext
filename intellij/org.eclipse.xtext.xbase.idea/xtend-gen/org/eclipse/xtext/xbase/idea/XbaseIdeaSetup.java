package org.eclipse.xtext.xbase.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.xbase.idea.XbaseStandaloneSetupIdea;

@SuppressWarnings("all")
public class XbaseIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      XbaseStandaloneSetupIdea _xbaseStandaloneSetupIdea = new XbaseStandaloneSetupIdea();
      _xblockexpression = _xbaseStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

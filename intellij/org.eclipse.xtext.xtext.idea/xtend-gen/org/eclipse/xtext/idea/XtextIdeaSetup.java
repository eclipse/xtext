package org.eclipse.xtext.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.XtextStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class XtextIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      XtextStandaloneSetupIdea _xtextStandaloneSetupIdea = new XtextStandaloneSetupIdea();
      _xblockexpression = _xtextStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

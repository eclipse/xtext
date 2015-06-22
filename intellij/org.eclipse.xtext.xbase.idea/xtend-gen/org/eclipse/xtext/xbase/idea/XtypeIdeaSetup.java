package org.eclipse.xtext.xbase.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.xbase.idea.XtypeStandaloneSetupIdea;

@SuppressWarnings("all")
public class XtypeIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      XtypeStandaloneSetupIdea _xtypeStandaloneSetupIdea = new XtypeStandaloneSetupIdea();
      _xblockexpression = _xtypeStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

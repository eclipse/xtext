package org.eclipse.xtend.core.idea;

import com.google.inject.Injector;
import org.eclipse.xtend.core.idea.XtendStandaloneSetupIdea;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class XtendIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      XtendStandaloneSetupIdea _xtendStandaloneSetupIdea = new XtendStandaloneSetupIdea();
      _xblockexpression = _xtendStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

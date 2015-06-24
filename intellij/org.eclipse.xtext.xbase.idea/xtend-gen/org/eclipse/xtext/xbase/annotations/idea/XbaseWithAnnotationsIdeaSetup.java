package org.eclipse.xtext.xbase.annotations.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.xbase.annotations.idea.XbaseWithAnnotationsStandaloneSetupIdea;

@SuppressWarnings("all")
public class XbaseWithAnnotationsIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      XbaseWithAnnotationsStandaloneSetupIdea _xbaseWithAnnotationsStandaloneSetupIdea = new XbaseWithAnnotationsStandaloneSetupIdea();
      _xblockexpression = _xbaseWithAnnotationsStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

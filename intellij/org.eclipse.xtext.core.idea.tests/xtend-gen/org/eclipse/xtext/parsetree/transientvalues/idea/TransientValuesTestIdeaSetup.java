package org.eclipse.xtext.parsetree.transientvalues.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.transientvalues.idea.TransientValuesTestStandaloneSetupIdea;

@SuppressWarnings("all")
public class TransientValuesTestIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      TransientValuesTestStandaloneSetupIdea _transientValuesTestStandaloneSetupIdea = new TransientValuesTestStandaloneSetupIdea();
      _xblockexpression = _transientValuesTestStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

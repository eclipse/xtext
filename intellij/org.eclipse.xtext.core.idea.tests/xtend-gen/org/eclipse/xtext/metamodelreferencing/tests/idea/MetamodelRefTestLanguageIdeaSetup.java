package org.eclipse.xtext.metamodelreferencing.tests.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.metamodelreferencing.tests.idea.MetamodelRefTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class MetamodelRefTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      MetamodelRefTestLanguageStandaloneSetupIdea _metamodelRefTestLanguageStandaloneSetupIdea = new MetamodelRefTestLanguageStandaloneSetupIdea();
      _xblockexpression = _metamodelRefTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

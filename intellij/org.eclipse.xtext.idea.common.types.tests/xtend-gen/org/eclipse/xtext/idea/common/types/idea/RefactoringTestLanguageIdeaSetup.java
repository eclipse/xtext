package org.eclipse.xtext.idea.common.types.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.common.types.idea.RefactoringTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class RefactoringTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      RefactoringTestLanguageStandaloneSetupIdea _refactoringTestLanguageStandaloneSetupIdea = new RefactoringTestLanguageStandaloneSetupIdea();
      _xblockexpression = _refactoringTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

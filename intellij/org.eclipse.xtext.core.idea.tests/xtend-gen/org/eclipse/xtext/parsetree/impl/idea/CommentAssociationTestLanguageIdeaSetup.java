package org.eclipse.xtext.parsetree.impl.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parsetree.impl.idea.CommentAssociationTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class CommentAssociationTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      CommentAssociationTestLanguageStandaloneSetupIdea _commentAssociationTestLanguageStandaloneSetupIdea = new CommentAssociationTestLanguageStandaloneSetupIdea();
      _xblockexpression = _commentAssociationTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}

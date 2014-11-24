package org.eclipse.xtext.idea.types.access;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.psi.IPsiModelAssociator;

@SuppressWarnings("all")
public class StubTypeProviderFactory extends AbstractTypeProviderFactory {
  @Inject
  private IPsiModelAssociator psiModelAssociator;
  
  public IJvmTypeProvider createTypeProvider(final ResourceSet resourceSet) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getProject is undefined for the type StubTypeProviderFactory"
      + "\n== cannot be resolved");
  }
}

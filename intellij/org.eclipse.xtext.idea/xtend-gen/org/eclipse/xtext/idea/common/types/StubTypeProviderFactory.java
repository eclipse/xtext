/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types;

import com.google.inject.Inject;
import com.intellij.openapi.module.Module;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.idea.common.types.StubJvmTypeProvider;
import org.eclipse.xtext.idea.resource.IndexingAwareGlobalSearchScope;
import org.eclipse.xtext.idea.resource.ModuleProvider;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("all")
public class StubTypeProviderFactory extends AbstractTypeProviderFactory {
  @Inject
  private IPsiModelAssociator psiModelAssociator;
  
  @Inject
  private IndexingAwareGlobalSearchScope.Factory searchScopeFactory;
  
  @Override
  public IJvmTypeProvider createTypeProvider(final ResourceSet resourceSet) {
    if ((resourceSet instanceof XtextResourceSet)) {
      final Module module = ModuleProvider.findModule(resourceSet);
      final IndexingAwareGlobalSearchScope searchScope = this.searchScopeFactory.createSearchScope(((XtextResourceSet)resourceSet));
      IndexedJvmTypeAccess _indexedJvmTypeAccess = this.getIndexedJvmTypeAccess();
      TypeResourceServices _services = this.getServices();
      return new StubJvmTypeProvider(module, resourceSet, _indexedJvmTypeAccess, _services, this.psiModelAssociator, searchScope);
    }
    throw new IllegalArgumentException(("resourceSet was " + resourceSet));
  }
}

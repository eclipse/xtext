/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.idea.common.types.StubBasedConstructorScope;
import org.eclipse.xtext.idea.common.types.StubBasedTypeScope;
import org.eclipse.xtext.idea.common.types.StubJvmTypeProvider;
import org.eclipse.xtext.idea.common.types.StubTypeProviderFactory;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StubBasedTypeScopeProvider extends AbstractTypeScopeProvider {
  @Inject
  @Accessors
  private StubTypeProviderFactory typeProviderFactory;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Override
  public StubBasedConstructorScope createConstructorScope(final IJvmTypeProvider typeProvider, final Predicate<IEObjectDescription> filter) {
    StubBasedTypeScope _createTypeScope = this.createTypeScope(typeProvider, filter);
    return new StubBasedConstructorScope(_createTypeScope);
  }
  
  @Override
  public StubBasedTypeScope createTypeScope(final IJvmTypeProvider typeProvider, final Predicate<IEObjectDescription> filter) {
    return new StubBasedTypeScope(((StubJvmTypeProvider) typeProvider), this.qualifiedNameConverter, filter);
  }
  
  @Pure
  public StubTypeProviderFactory getTypeProviderFactory() {
    return this.typeProviderFactory;
  }
  
  public void setTypeProviderFactory(final StubTypeProviderFactory typeProviderFactory) {
    this.typeProviderFactory = typeProviderFactory;
  }
}

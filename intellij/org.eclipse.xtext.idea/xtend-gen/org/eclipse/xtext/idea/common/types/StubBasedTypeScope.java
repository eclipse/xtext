/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types;

import com.google.common.base.Predicate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.idea.common.types.StubJvmTypeProvider;
import org.eclipse.xtext.idea.common.types.StubURIHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class StubBasedTypeScope extends AbstractTypeScope {
  protected StubBasedTypeScope(final StubJvmTypeProvider typeProvider, final IQualifiedNameConverter qualifiedNameConverter, final Predicate<IEObjectDescription> filter) {
    super(typeProvider, qualifiedNameConverter, filter);
  }
  
  @Override
  protected Iterable<IEObjectDescription> internalGetAllElements() {
    return CollectionLiterals.<IEObjectDescription>emptyList();
  }
  
  protected InternalEObject createProxy(final String fullClassName) {
    InternalEObject _xblockexpression = null;
    {
      IJvmTypeProvider _typeProvider = this.getTypeProvider();
      StubURIHelper _uriHelper = ((StubJvmTypeProvider) _typeProvider).getUriHelper();
      final URI uri = _uriHelper.getFullURI(fullClassName);
      JvmVoid _createJvmVoid = TypesFactory.eINSTANCE.createJvmVoid();
      final InternalEObject proxy = ((InternalEObject) _createJvmVoid);
      proxy.eSetProxyURI(uri);
      _xblockexpression = proxy;
    }
    return _xblockexpression;
  }
}

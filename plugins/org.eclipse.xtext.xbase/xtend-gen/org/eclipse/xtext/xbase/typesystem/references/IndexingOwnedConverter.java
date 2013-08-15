/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage.Literals;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class IndexingOwnedConverter extends OwnedConverter {
  public IndexingOwnedConverter(final ITypeReferenceOwner owner) {
    super(owner);
  }
  
  public IndexingOwnedConverter(final ITypeReferenceOwner owner, final boolean keepUnboundWildcards) {
    super(owner, keepUnboundWildcards);
  }
  
  protected JvmType getType(final JvmParameterizedTypeReference it) {
    JvmType _switchResult = null;
    Object _eGet = it.eGet(Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, false);
    final Object proxy = _eGet;
    boolean _matched = false;
    if (!_matched) {
      if (proxy instanceof EObject) {
        final EObject _eObject = (EObject)proxy;
        boolean _eIsProxy = _eObject.eIsProxy();
        if (_eIsProxy) {
          _matched=true;
          final URI uri = ((InternalEObject) _eObject).eProxyURI();
          Resource _eResource = it.eResource();
          ResourceSet _resourceSet = _eResource.getResourceSet();
          EObject _eObject_1 = _resourceSet.getEObject(uri, true);
          return ((JvmType) _eObject_1);
        }
      }
    }
    if (!_matched) {
      if (proxy instanceof JvmType) {
        final JvmType _jvmType = (JvmType)proxy;
        _matched=true;
        _switchResult = _jvmType;
      }
    }
    return _switchResult;
  }
}

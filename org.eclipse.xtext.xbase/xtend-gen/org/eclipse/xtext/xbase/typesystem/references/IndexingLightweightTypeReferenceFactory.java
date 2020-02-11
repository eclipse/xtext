/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.impl.JvmGenericArrayTypeReferenceImplCustom;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypePackage;
import org.eclipse.xtext.xtype.impl.XFunctionTypeRefImplCustom;
import org.eclipse.xtext.xtype.util.XFunctionTypeRefs;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class IndexingLightweightTypeReferenceFactory extends LightweightTypeReferenceFactory {
  public IndexingLightweightTypeReferenceFactory(final ITypeReferenceOwner owner) {
    super(owner);
  }
  
  public IndexingLightweightTypeReferenceFactory(final ITypeReferenceOwner owner, final boolean keepUnboundWildcards) {
    super(owner, keepUnboundWildcards);
  }
  
  protected JvmType _getType(final JvmTypeReference it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("It is not possible to get a type for the given jvm type reference: ");
    String _name = it.getClass().getName();
    _builder.append(_name);
    throw new UnsupportedOperationException(_builder.toString());
  }
  
  protected JvmType _getType(final JvmGenericArrayTypeReferenceImplCustom it) {
    JvmArrayType _xblockexpression = null;
    {
      final JvmTypeReference componentTypeReference = it.getComponentType();
      if ((componentTypeReference == null)) {
        return null;
      }
      JvmArrayType _switchResult = null;
      JvmType _type = this.getType(componentTypeReference);
      final JvmType componentType = _type;
      boolean _matched = false;
      if (componentType instanceof JvmComponentType) {
        _matched=true;
        _switchResult = ((JvmComponentType)componentType).getArrayType();
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected JvmType _getType(final JvmParameterizedTypeReference it) {
    return this.getType(it, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
  }
  
  protected JvmType _getType(final XFunctionTypeRef it) {
    return this.getType(it, XtypePackage.Literals.XFUNCTION_TYPE_REF__TYPE);
  }
  
  protected JvmType _getType(final XFunctionTypeRefImplCustom it) {
    JvmType _xblockexpression = null;
    {
      final URI uri = XFunctionTypeRefs.computeTypeUri(this.isProcedure(it), it.getParamTypes().size());
      EObject _eObject = it.eResource().getResourceSet().getEObject(uri, true);
      _xblockexpression = ((JvmType) _eObject);
    }
    return _xblockexpression;
  }
  
  public boolean isProcedure(final XFunctionTypeRefImplCustom it) {
    final JvmTypeReference returnType = it.getReturnType();
    if ((returnType == null)) {
      return true;
    }
    final JvmType type = this.getType(returnType);
    if ((type == null)) {
      return false;
    }
    boolean _eIsProxy = type.eIsProxy();
    if (_eIsProxy) {
      return false;
    }
    if ((type instanceof JvmVoid)) {
      return true;
    }
    return false;
  }
  
  public JvmType getType(final EObject it, final EReference reference) {
    JvmType _switchResult = null;
    Object _eGet = it.eGet(reference, false);
    final Object proxy = _eGet;
    boolean _matched = false;
    if (proxy instanceof EObject) {
      boolean _eIsProxy = ((EObject)proxy).eIsProxy();
      if (_eIsProxy) {
        _matched=true;
        final URI uri = ((InternalEObject) proxy).eProxyURI();
        EObject _eObject = it.eResource().getResourceSet().getEObject(uri, true);
        return ((JvmType) _eObject);
      }
    }
    if (!_matched) {
      if (proxy instanceof JvmType) {
        _matched=true;
        _switchResult = ((JvmType)proxy);
      }
    }
    return _switchResult;
  }
  
  @Override
  public LightweightTypeReference doVisitFunctionTypeReference(final XFunctionTypeRef reference) {
    ITypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.getType(reference);
    final FunctionTypeReference result = new FunctionTypeReference(_owner, _type);
    EList<JvmTypeReference> _paramTypes = reference.getParamTypes();
    for (final JvmTypeReference parameter : _paramTypes) {
      {
        final LightweightTypeReference parameterType = this.visit(this.wrapIfNecessary(parameter));
        result.addParameterType(parameterType);
        final WildcardTypeReference typeArgument = this.getOwner().newWildcardTypeReference();
        typeArgument.setLowerBound(parameterType);
        typeArgument.addUpperBound(this.getJavaLangObjectTypeReference());
        result.addTypeArgument(typeArgument);
      }
    }
    JvmTypeReference _returnType = reference.getReturnType();
    boolean _tripleNotEquals = (_returnType != null);
    if (_tripleNotEquals) {
      final LightweightTypeReference returnType = this.visit(this.wrapIfNecessary(reference.getReturnType()));
      result.setReturnType(returnType);
      if ((reference instanceof XFunctionTypeRefImplCustom)) {
        boolean _isProcedure = this.isProcedure(((XFunctionTypeRefImplCustom)reference));
        if (_isProcedure) {
          return result;
        }
      }
      final WildcardTypeReference typeArgument = this.getOwner().newWildcardTypeReference();
      typeArgument.addUpperBound(returnType);
      result.addTypeArgument(typeArgument);
    }
    return result;
  }
  
  public JvmTypeReference wrapIfNecessary(final JvmTypeReference reference) {
    JvmTypeReference _xblockexpression = null;
    {
      if ((reference == null)) {
        return null;
      }
      final JvmType type = this.getType(reference);
      _xblockexpression = XFunctionTypeRefs.wrapIfNecessary(reference, type);
    }
    return _xblockexpression;
  }
  
  protected LightweightTypeReference getJavaLangObjectTypeReference() {
    return this.getOwner().newReferenceToObject();
  }
  
  public JvmType getType(final JvmTypeReference it) {
    if (it instanceof XFunctionTypeRefImplCustom) {
      return _getType((XFunctionTypeRefImplCustom)it);
    } else if (it instanceof JvmGenericArrayTypeReferenceImplCustom) {
      return _getType((JvmGenericArrayTypeReferenceImplCustom)it);
    } else if (it instanceof XFunctionTypeRef) {
      return _getType((XFunctionTypeRef)it);
    } else if (it instanceof JvmParameterizedTypeReference) {
      return _getType((JvmParameterizedTypeReference)it);
    } else if (it != null) {
      return _getType(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}

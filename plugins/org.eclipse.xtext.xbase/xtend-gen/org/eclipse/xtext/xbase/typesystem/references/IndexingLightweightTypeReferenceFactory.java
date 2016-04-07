/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.typesystem.references;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
    Class<? extends JvmTypeReference> _class = it.getClass();
    String _name = _class.getName();
    _builder.append(_name, "");
    throw new UnsupportedOperationException(_builder.toString());
  }
  
  protected JvmType _getType(final JvmGenericArrayTypeReferenceImplCustom it) {
    JvmArrayType _xblockexpression = null;
    {
      final JvmTypeReference componentTypeReference = it.getComponentType();
      boolean _equals = Objects.equal(componentTypeReference, null);
      if (_equals) {
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
      boolean _isProcedure = this.isProcedure(it);
      EList<JvmTypeReference> _paramTypes = it.getParamTypes();
      int _size = _paramTypes.size();
      final URI uri = XFunctionTypeRefs.computeTypeUri(_isProcedure, _size);
      Resource _eResource = it.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      EObject _eObject = _resourceSet.getEObject(uri, true);
      _xblockexpression = ((JvmType) _eObject);
    }
    return _xblockexpression;
  }
  
  public boolean isProcedure(final XFunctionTypeRefImplCustom it) {
    final JvmTypeReference returnType = it.getReturnType();
    boolean _equals = Objects.equal(returnType, null);
    if (_equals) {
      return true;
    }
    final JvmType type = this.getType(returnType);
    boolean _equals_1 = Objects.equal(type, null);
    if (_equals_1) {
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
        Resource _eResource = it.eResource();
        ResourceSet _resourceSet = _eResource.getResourceSet();
        EObject _eObject = _resourceSet.getEObject(uri, true);
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
        JvmTypeReference _wrapIfNecessary = this.wrapIfNecessary(parameter);
        final LightweightTypeReference parameterType = this.visit(_wrapIfNecessary);
        result.addParameterType(parameterType);
        ITypeReferenceOwner _owner_1 = this.getOwner();
        final WildcardTypeReference typeArgument = _owner_1.newWildcardTypeReference();
        typeArgument.setLowerBound(parameterType);
        LightweightTypeReference _javaLangObjectTypeReference = this.getJavaLangObjectTypeReference();
        typeArgument.addUpperBound(_javaLangObjectTypeReference);
        result.addTypeArgument(typeArgument);
      }
    }
    JvmTypeReference _returnType = reference.getReturnType();
    boolean _notEquals = (!Objects.equal(_returnType, null));
    if (_notEquals) {
      JvmTypeReference _returnType_1 = reference.getReturnType();
      JvmTypeReference _wrapIfNecessary = this.wrapIfNecessary(_returnType_1);
      final LightweightTypeReference returnType = this.visit(_wrapIfNecessary);
      result.setReturnType(returnType);
      if ((reference instanceof XFunctionTypeRefImplCustom)) {
        boolean _isProcedure = this.isProcedure(((XFunctionTypeRefImplCustom)reference));
        if (_isProcedure) {
          return result;
        }
      }
      ITypeReferenceOwner _owner_1 = this.getOwner();
      final WildcardTypeReference typeArgument = _owner_1.newWildcardTypeReference();
      typeArgument.addUpperBound(returnType);
      result.addTypeArgument(typeArgument);
    }
    return result;
  }
  
  public JvmTypeReference wrapIfNecessary(final JvmTypeReference reference) {
    JvmTypeReference _xblockexpression = null;
    {
      boolean _equals = Objects.equal(reference, null);
      if (_equals) {
        return null;
      }
      final JvmType type = this.getType(reference);
      _xblockexpression = XFunctionTypeRefs.wrapIfNecessary(reference, type);
    }
    return _xblockexpression;
  }
  
  protected LightweightTypeReference getJavaLangObjectTypeReference() {
    ITypeReferenceOwner _owner = this.getOwner();
    return _owner.newReferenceToObject();
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

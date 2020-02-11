/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XFunctionTypeRefs {
  public static URI computeTypeUri(final boolean procedure, final int functionParamCount) {
    return URI.createURI(XFunctionTypeRefs.buildUri(procedure, functionParamCount));
  }
  
  public static String buildUri(final boolean procedure, final int functionParamCount) {
    final int paramCount = Math.min(6, functionParamCount);
    if (procedure) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("java:/Objects/");
      String _canonicalName = Procedures.class.getCanonicalName();
      _builder.append(_canonicalName);
      _builder.append("#");
      String _canonicalName_1 = Procedures.class.getCanonicalName();
      _builder.append(_canonicalName_1);
      _builder.append("$Procedure");
      _builder.append(paramCount);
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("java:/Objects/");
    String _canonicalName_2 = Functions.class.getCanonicalName();
    _builder_1.append(_canonicalName_2);
    _builder_1.append("#");
    String _canonicalName_3 = Functions.class.getCanonicalName();
    _builder_1.append(_canonicalName_3);
    _builder_1.append("$Function");
    _builder_1.append(paramCount);
    return _builder_1.toString();
  }
  
  public static URI computeTypeUri(final Class<?> topLevelClass) {
    return new ClassURIHelper().getFullURI(topLevelClass);
  }
  
  public static JvmTypeReference wrapIfNecessary(final JvmTypeReference reference, final JvmType type) {
    JvmTypeReference _switchResult = null;
    boolean _matched = false;
    if (type instanceof JvmPrimitiveType) {
      _matched=true;
      JvmTypeReference _xblockexpression = null;
      {
        final JvmType wrappedType = XFunctionTypeRefs.getWrappedType(type);
        JvmTypeReference _xifexpression = null;
        if ((wrappedType == null)) {
          _xifexpression = reference;
        } else {
          JvmParameterizedTypeReference _createJvmParameterizedTypeReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
          final Procedure1<JvmParameterizedTypeReference> _function = (JvmParameterizedTypeReference it) -> {
            it.setType(wrappedType);
          };
          _xifexpression = ObjectExtensions.<JvmParameterizedTypeReference>operator_doubleArrow(_createJvmParameterizedTypeReference, _function);
        }
        _xblockexpression = _xifexpression;
      }
      _switchResult = _xblockexpression;
    }
    if (!_matched) {
      if (type instanceof JvmVoid) {
        boolean _eIsProxy = ((JvmVoid)type).eIsProxy();
        boolean _not = (!_eIsProxy);
        if (_not) {
          _matched=true;
          JvmParameterizedTypeReference _createJvmParameterizedTypeReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
          final Procedure1<JvmParameterizedTypeReference> _function = (JvmParameterizedTypeReference it) -> {
            it.setType(XFunctionTypeRefs.getType(Void.class, type));
          };
          _switchResult = ObjectExtensions.<JvmParameterizedTypeReference>operator_doubleArrow(_createJvmParameterizedTypeReference, _function);
        }
      }
    }
    if (!_matched) {
      _switchResult = reference;
    }
    return _switchResult;
  }
  
  public static JvmType getWrappedType(final JvmType type) {
    JvmType _xblockexpression = null;
    {
      final String name = type.getIdentifier();
      JvmType _switchResult = null;
      boolean _matched = false;
      boolean _equals = "int".equals(name);
      if (_equals) {
        _matched=true;
        _switchResult = XFunctionTypeRefs.getType(Integer.class, type);
      }
      if (!_matched) {
        boolean _equals_1 = "boolean".equals(name);
        if (_equals_1) {
          _matched=true;
          _switchResult = XFunctionTypeRefs.getType(Boolean.class, type);
        }
      }
      if (!_matched) {
        boolean _equals_2 = "char".equals(name);
        if (_equals_2) {
          _matched=true;
          _switchResult = XFunctionTypeRefs.getType(Character.class, type);
        }
      }
      if (!_matched) {
        boolean _equals_3 = "long".equals(name);
        if (_equals_3) {
          _matched=true;
          _switchResult = XFunctionTypeRefs.getType(Long.class, type);
        }
      }
      if (!_matched) {
        boolean _equals_4 = "double".equals(name);
        if (_equals_4) {
          _matched=true;
          _switchResult = XFunctionTypeRefs.getType(Double.class, type);
        }
      }
      if (!_matched) {
        boolean _equals_5 = "byte".equals(name);
        if (_equals_5) {
          _matched=true;
          _switchResult = XFunctionTypeRefs.getType(Byte.class, type);
        }
      }
      if (!_matched) {
        boolean _equals_6 = "float".equals(name);
        if (_equals_6) {
          _matched=true;
          _switchResult = XFunctionTypeRefs.getType(Float.class, type);
        }
      }
      if (!_matched) {
        boolean _equals_7 = "short".equals(name);
        if (_equals_7) {
          _matched=true;
          _switchResult = XFunctionTypeRefs.getType(Short.class, type);
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static JvmType getType(final Class<?> clazz, final EObject context) {
    JvmType _xblockexpression = null;
    {
      JvmVoid _createJvmVoid = TypesFactory.eINSTANCE.createJvmVoid();
      final InternalEObject proxy = ((InternalEObject) _createJvmVoid);
      proxy.eSetProxyURI(XFunctionTypeRefs.computeTypeUri(clazz));
      EObject _resolve = EcoreUtil.resolve(proxy, context);
      _xblockexpression = ((JvmType) _resolve);
    }
    return _xblockexpression;
  }
}

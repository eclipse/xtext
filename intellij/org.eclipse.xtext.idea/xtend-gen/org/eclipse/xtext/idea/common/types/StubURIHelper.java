/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types;

import com.google.common.base.Objects;
import com.intellij.psi.PsiArrayType;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiNameHelper;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import com.intellij.psi.PsiPrimitiveType;
import com.intellij.psi.PsiType;
import com.intellij.psi.PsiTypeParameter;
import com.intellij.psi.PsiTypeParameterListOwner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.common.types.access.impl.Primitives;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.idea.common.types.UnresolvedPsiClassType;

@SuppressWarnings("all")
public class StubURIHelper implements URIHelperConstants {
  public URI getFullURI(final String name) {
    StringBuilder _createURIBuilder = this.createURIBuilder();
    StringBuilder _appendClassResourceURI = this.appendClassResourceURI(_createURIBuilder, name);
    StringBuilder _append = _appendClassResourceURI.append("#");
    StringBuilder _appendTypeFragment = this.appendTypeFragment(_append, name);
    return this.createURI(_appendTypeFragment);
  }
  
  public URI createResourceURI(final String name) {
    StringBuilder _createURIBuilder = this.createURIBuilder();
    StringBuilder _appendClassResourceURI = this.appendClassResourceURI(_createURIBuilder, name);
    return this.createURI(_appendClassResourceURI);
  }
  
  public String getFragment(final String name) {
    StringBuilder _createFragmentBuilder = this.createFragmentBuilder();
    StringBuilder _appendTypeFragment = this.appendTypeFragment(_createFragmentBuilder, name);
    return _appendTypeFragment.toString();
  }
  
  protected StringBuilder appendClassResourceURI(final StringBuilder builder, final String name) {
    String _trimInnerType = this.trimInnerType(name);
    final String topLevelTypeName = this.trimBrackets(_trimInnerType);
    Class<?> _forName = Primitives.forName(topLevelTypeName);
    boolean _tripleNotEquals = (_forName != null);
    if (_tripleNotEquals) {
      builder.append(URIHelperConstants.PRIMITIVES);
    } else {
      StringBuilder _append = builder.append(URIHelperConstants.OBJECTS);
      _append.append(topLevelTypeName);
    }
    return builder;
  }
  
  protected String trimInnerType(final String name) {
    final int innerTypeIndex = name.indexOf("$");
    if ((innerTypeIndex == (-1))) {
      return name;
    }
    final int simpleNameIndex = name.lastIndexOf(".");
    if (((simpleNameIndex + 1) == innerTypeIndex)) {
      return name;
    }
    return name.substring(0, innerTypeIndex);
  }
  
  protected String trimBrackets(final String name) {
    boolean _endsWith = name.endsWith("]");
    if (_endsWith) {
      final int endIndex = name.indexOf("[");
      return name.substring(0, endIndex);
    } else {
      return name;
    }
  }
  
  protected StringBuilder appendTypeFragment(final StringBuilder builder, final String name) {
    return builder.append(name);
  }
  
  public URI getFullURI(final PsiClass psiClass) {
    StringBuilder _createURIBuilder = this.createURIBuilder();
    StringBuilder _appendFullURI = this.appendFullURI(_createURIBuilder, psiClass);
    return this.createURI(_appendFullURI);
  }
  
  public URI getFullURI(final PsiMethod method) {
    URI _xblockexpression = null;
    {
      PsiParameterList _parameterList = method.getParameterList();
      int _parametersCount = _parameterList.getParametersCount();
      boolean _notEquals = (_parametersCount != 0);
      if (_notEquals) {
        String _string = method.toString();
        throw new IllegalArgumentException(_string);
      }
      StringBuilder _createURIBuilder = this.createURIBuilder();
      PsiClass _containingClass = method.getContainingClass();
      StringBuilder _appendFullURI = this.appendFullURI(_createURIBuilder, _containingClass);
      StringBuilder _append = _appendFullURI.append(".");
      String _name = method.getName();
      StringBuilder _append_1 = _append.append(_name);
      StringBuilder _append_2 = _append_1.append("()");
      _xblockexpression = this.createURI(_append_2);
    }
    return _xblockexpression;
  }
  
  public URI getFullURI(final PsiField field) {
    StringBuilder _createURIBuilder = this.createURIBuilder();
    PsiClass _containingClass = field.getContainingClass();
    StringBuilder _appendFullURI = this.appendFullURI(_createURIBuilder, _containingClass);
    StringBuilder _append = _appendFullURI.append(".");
    String _name = field.getName();
    StringBuilder _append_1 = _append.append(_name);
    return this.createURI(_append_1);
  }
  
  public URI getFullURI(final PsiType type) throws UnresolvedPsiClassType {
    StringBuilder _createURIBuilder = this.createURIBuilder();
    StringBuilder _appendFullURI = this.appendFullURI(_createURIBuilder, type);
    return this.createURI(_appendFullURI);
  }
  
  protected StringBuilder appendFullURI(final StringBuilder it, final PsiType type) throws UnresolvedPsiClassType {
    StringBuilder _appendTypeResourceURI = this.appendTypeResourceURI(it, type);
    StringBuilder _append = _appendTypeResourceURI.append("#");
    return this.appendTypeFragment(_append, type);
  }
  
  protected StringBuilder appendFullURI(final StringBuilder it, final PsiClass psiClass) {
    StringBuilder _appendClassResourceURI = this.appendClassResourceURI(it, psiClass);
    StringBuilder _append = _appendClassResourceURI.append("#");
    return this.appendClassFragment(_append, psiClass);
  }
  
  protected StringBuilder appendTypeResourceURI(final StringBuilder builder, final PsiType type) throws UnresolvedPsiClassType {
    StringBuilder _switchResult = null;
    boolean _matched = false;
    if (type instanceof PsiArrayType) {
      _matched=true;
      PsiType _componentType = ((PsiArrayType)type).getComponentType();
      _switchResult = this.appendTypeResourceURI(builder, _componentType);
    }
    if (!_matched) {
      if (type instanceof PsiPrimitiveType) {
        _matched=true;
        _switchResult = builder.append(URIHelperConstants.PRIMITIVES);
      }
    }
    if (!_matched) {
      if (type instanceof PsiClassType) {
        _matched=true;
        StringBuilder _xblockexpression = null;
        {
          final PsiClassType.ClassResolveResult resolveResult = ((PsiClassType)type).resolveGenerics();
          boolean _isValidResult = resolveResult.isValidResult();
          boolean _not = (!_isValidResult);
          if (_not) {
            throw new UnresolvedPsiClassType(((PsiClassType)type), resolveResult);
          }
          PsiClass _element = resolveResult.getElement();
          _xblockexpression = this.appendClassResourceURI(builder, _element);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("Unknown type: " + type));
    }
    return _switchResult;
  }
  
  protected StringBuilder appendClassResourceURI(final StringBuilder builder, final PsiClass psiClass) {
    StringBuilder _xblockexpression = null;
    {
      if ((psiClass instanceof PsiTypeParameter)) {
        return this.appendTypeParameterResourceURI(builder, ((PsiTypeParameter)psiClass));
      }
      final PsiClass containingClass = psiClass.getContainingClass();
      StringBuilder _xifexpression = null;
      boolean _notEquals = (!Objects.equal(containingClass, null));
      if (_notEquals) {
        _xifexpression = this.appendClassResourceURI(builder, containingClass);
      } else {
        StringBuilder _append = builder.append(URIHelperConstants.OBJECTS);
        String _qualifiedName = psiClass.getQualifiedName();
        _xifexpression = _append.append(_qualifiedName);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder appendTypeParameterResourceURI(final StringBuilder builder, final PsiTypeParameter typeParameter) {
    StringBuilder _switchResult = null;
    PsiTypeParameterListOwner _owner = typeParameter.getOwner();
    final PsiTypeParameterListOwner owner = _owner;
    boolean _matched = false;
    if (owner instanceof PsiClass) {
      _matched=true;
      _switchResult = this.appendClassResourceURI(builder, ((PsiClass)owner));
    }
    if (!_matched) {
      if (owner instanceof PsiMethod) {
        _matched=true;
        PsiClass _containingClass = ((PsiMethod)owner).getContainingClass();
        _switchResult = this.appendClassResourceURI(builder, _containingClass);
      }
    }
    return _switchResult;
  }
  
  protected StringBuilder appendTypeFragment(final StringBuilder builder, final PsiType type) throws UnresolvedPsiClassType {
    StringBuilder _switchResult = null;
    boolean _matched = false;
    if (type instanceof PsiPrimitiveType) {
      _matched=true;
      String _canonicalText = ((PsiPrimitiveType)type).getCanonicalText(false);
      _switchResult = builder.append(_canonicalText);
    }
    if (!_matched) {
      if (type instanceof PsiClassType) {
        _matched=true;
        StringBuilder _xblockexpression = null;
        {
          final PsiClassType.ClassResolveResult resolveResult = ((PsiClassType)type).resolveGenerics();
          boolean _isValidResult = resolveResult.isValidResult();
          boolean _not = (!_isValidResult);
          if (_not) {
            throw new UnresolvedPsiClassType(((PsiClassType)type), resolveResult);
          }
          PsiClass _element = resolveResult.getElement();
          _xblockexpression = this.appendClassFragment(builder, _element);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (type instanceof PsiArrayType) {
        _matched=true;
        PsiType _componentType = ((PsiArrayType)type).getComponentType();
        StringBuilder _appendTypeFragment = this.appendTypeFragment(builder, _componentType);
        _switchResult = _appendTypeFragment.append("[]");
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("Unknown type: " + type));
    }
    return _switchResult;
  }
  
  protected StringBuilder appendClassFragment(final StringBuilder builder, final PsiClass psiClass) {
    if ((psiClass instanceof PsiTypeParameter)) {
      return this.appendTypeParameterFragment(builder, ((PsiTypeParameter)psiClass));
    }
    final PsiClass containingClass = psiClass.getContainingClass();
    boolean _equals = Objects.equal(containingClass, null);
    if (_equals) {
      String _qualifiedName = psiClass.getQualifiedName();
      return builder.append(_qualifiedName);
    } else {
      StringBuilder _appendClassFragment = this.appendClassFragment(builder, containingClass);
      StringBuilder _append = _appendClassFragment.append("$");
      String _name = psiClass.getName();
      return _append.append(_name);
    }
  }
  
  protected StringBuilder appendTypeParameterFragment(final StringBuilder builder, final PsiTypeParameter typeParameter) {
    PsiTypeParameterListOwner _owner = typeParameter.getOwner();
    final PsiTypeParameterListOwner owner = _owner;
    boolean _matched = false;
    if (owner instanceof PsiClass) {
      _matched=true;
      this.appendClassFragment(builder, ((PsiClass)owner));
    }
    if (!_matched) {
      if (owner instanceof PsiMethod) {
        _matched=true;
        this.appendMethodFragment(builder, ((PsiMethod)owner));
      }
    }
    StringBuilder _append = builder.append("/");
    String _name = typeParameter.getName();
    return _append.append(_name);
  }
  
  protected StringBuilder appendMethodFragment(final StringBuilder builder, final PsiMethod method) {
    PsiClass _containingClass = method.getContainingClass();
    this.appendClassFragment(builder, _containingClass);
    StringBuilder _append = builder.append(".");
    String _name = method.getName();
    StringBuilder _append_1 = _append.append(_name);
    _append_1.append("(");
    final PsiParameterList parameterList = method.getParameterList();
    final int parameterCount = parameterList.getParametersCount();
    if ((parameterCount > 0)) {
      final PsiParameter[] parameters = parameterList.getParameters();
      for (int i = 0; (i < parameterCount); i++) {
        {
          if ((i != 0)) {
            builder.append(",");
          }
          PsiParameter _get = parameters[i];
          PsiType _type = _get.getType();
          this.appendTypeName(builder, _type);
        }
      }
    }
    return builder.append(")");
  }
  
  public StringBuilder appendTypeName(final StringBuilder builder, final PsiType type) {
    StringBuilder _switchResult = null;
    boolean _matched = false;
    if (type instanceof PsiPrimitiveType) {
      _matched=true;
      String _canonicalText = ((PsiPrimitiveType)type).getCanonicalText();
      _switchResult = builder.append(_canonicalText);
    }
    if (!_matched) {
      if (type instanceof PsiClassType) {
        _matched=true;
        StringBuilder _xblockexpression = null;
        {
          final PsiClass resolved = ((PsiClassType)type).resolve();
          StringBuilder _switchResult_1 = null;
          boolean _matched_1 = false;
          if (resolved instanceof PsiTypeParameter) {
            _matched_1=true;
            String _name = ((PsiTypeParameter)resolved).getName();
            _switchResult_1 = builder.append(_name);
          }
          if (!_matched_1) {
            boolean _notEquals = (!Objects.equal(resolved, null));
            if (_notEquals) {
              _matched_1=true;
              _switchResult_1 = this.appendTypeName(builder, resolved);
            }
          }
          if (!_matched_1) {
            String _canonicalText = ((PsiClassType)type).getCanonicalText();
            String _qualifiedClassName = PsiNameHelper.getQualifiedClassName(_canonicalText, false);
            _switchResult_1 = builder.append(_qualifiedClassName);
          }
          _xblockexpression = _switchResult_1;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (type instanceof PsiArrayType) {
        _matched=true;
        PsiType _componentType = ((PsiArrayType)type).getComponentType();
        StringBuilder _appendTypeName = this.appendTypeName(builder, _componentType);
        _switchResult = _appendTypeName.append("[]");
      }
    }
    if (!_matched) {
      String _canonicalText = null;
      if (type!=null) {
        _canonicalText=type.getCanonicalText();
      }
      String _plus = ("Unknown type: " + _canonicalText);
      throw new IllegalStateException(_plus);
    }
    return _switchResult;
  }
  
  private StringBuilder appendTypeName(final StringBuilder builder, final PsiClass clazz) {
    StringBuilder _xblockexpression = null;
    {
      final PsiClass container = clazz.getContainingClass();
      StringBuilder _xifexpression = null;
      if ((container != null)) {
        StringBuilder _appendTypeName = this.appendTypeName(builder, container);
        StringBuilder _append = _appendTypeName.append("$");
        String _name = clazz.getName();
        _xifexpression = _append.append(_name);
      } else {
        String _qualifiedName = clazz.getQualifiedName();
        _xifexpression = builder.append(_qualifiedName);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder createURIBuilder() {
    StringBuilder _stringBuilder = new StringBuilder(48);
    StringBuilder _append = _stringBuilder.append(URIHelperConstants.PROTOCOL);
    return _append.append(":");
  }
  
  protected StringBuilder createFragmentBuilder() {
    return new StringBuilder(32);
  }
  
  protected URI createURI(final StringBuilder uriBuilder) {
    String _string = uriBuilder.toString();
    return URI.createURI(_string);
  }
}

package org.eclipse.xtext.idea.types.access;

import com.google.common.base.Objects;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiArrayType;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import com.intellij.psi.PsiPrimitiveType;
import com.intellij.psi.PsiType;
import com.intellij.psi.PsiTypeParameter;
import com.intellij.psi.PsiTypeParameterListOwner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.access.impl.Primitives;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
    StringBuilder _xblockexpression = null;
    {
      String _trimInnerType = this.trimInnerType(name);
      final String topLevelTypeName = this.trimBrackets(_trimInnerType);
      StringBuilder _xifexpression = null;
      final Function1<Class<?>, Boolean> _function = new Function1<Class<?>, Boolean>() {
        public Boolean apply(final Class<?> type) {
          String _name = type.getName();
          return Boolean.valueOf(Objects.equal(_name, topLevelTypeName));
        }
      };
      boolean _exists = IterableExtensions.<Class<?>>exists(Primitives.ALL_PRIMITIVE_TYPES, _function);
      if (_exists) {
        _xifexpression = builder.append(URIHelperConstants.PRIMITIVES);
      } else {
        StringBuilder _append = builder.append(URIHelperConstants.OBJECTS);
        _xifexpression = _append.append(topLevelTypeName);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String trimInnerType(final String name) {
    String _xblockexpression = null;
    {
      final int innerTypeIndex = name.indexOf("$");
      if ((innerTypeIndex == (-1))) {
        return name;
      }
      final int simpleNameIndex = name.lastIndexOf(".");
      if (((simpleNameIndex + 1) == innerTypeIndex)) {
        return name;
      }
      _xblockexpression = name.substring(0, innerTypeIndex);
    }
    return _xblockexpression;
  }
  
  protected String trimBrackets(final String name) {
    String _xblockexpression = null;
    {
      final int endIndex = name.indexOf("[");
      String _xifexpression = null;
      if ((endIndex == (-1))) {
        _xifexpression = name;
      } else {
        _xifexpression = name.substring(0, endIndex);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder appendTypeFragment(final StringBuilder builder, final String name) {
    return builder.append(name);
  }
  
  public URI getFullURI(final PsiMethod method) {
    URI _xblockexpression = null;
    {
      PsiElementFactory _psiElementFactory = this.getPsiElementFactory(method);
      PsiClass _containingClass = method.getContainingClass();
      final PsiClassType type = _psiElementFactory.createType(_containingClass);
      StringBuilder _createURIBuilder = this.createURIBuilder();
      StringBuilder _appendFullURI = this.appendFullURI(_createURIBuilder, type);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(".");
      String _name = method.getName();
      _builder.append(_name, "");
      _builder.append("()");
      StringBuilder _append = _appendFullURI.append(_builder);
      _xblockexpression = this.createURI(_append);
    }
    return _xblockexpression;
  }
  
  public URI getFullURI(final PsiField field) {
    URI _xblockexpression = null;
    {
      PsiElementFactory _psiElementFactory = this.getPsiElementFactory(field);
      PsiClass _containingClass = field.getContainingClass();
      final PsiClassType type = _psiElementFactory.createType(_containingClass);
      StringBuilder _createURIBuilder = this.createURIBuilder();
      StringBuilder _appendFullURI = this.appendFullURI(_createURIBuilder, type);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(".");
      String _name = field.getName();
      _builder.append(_name, "");
      StringBuilder _append = _appendFullURI.append(_builder);
      _xblockexpression = this.createURI(_append);
    }
    return _xblockexpression;
  }
  
  public URI getFullURI(final PsiType type) {
    StringBuilder _createURIBuilder = this.createURIBuilder();
    StringBuilder _appendFullURI = this.appendFullURI(_createURIBuilder, type);
    return this.createURI(_appendFullURI);
  }
  
  protected StringBuilder appendFullURI(final StringBuilder it, final PsiType type) {
    StringBuilder _appendTypeResourceURI = this.appendTypeResourceURI(it, type);
    StringBuilder _append = _appendTypeResourceURI.append("#");
    return this.appendTypeFragment(_append, type);
  }
  
  protected StringBuilder appendTypeResourceURI(final StringBuilder builder, final PsiType type) {
    StringBuilder _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof PsiArrayType) {
        _matched=true;
        PsiType _componentType = ((PsiArrayType)type).getComponentType();
        _switchResult = this.appendTypeResourceURI(builder, _componentType);
      }
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
        StringBuilder _switchResult_1 = null;
        PsiClass _resolve = ((PsiClassType)type).resolve();
        final PsiClass resolvedType = _resolve;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (resolvedType instanceof PsiTypeParameter) {
            _matched_1=true;
            _switchResult_1 = this.appendTypeParameterResourceURI(builder, ((PsiTypeParameter)resolvedType));
          }
        }
        if (!_matched_1) {
          if (resolvedType instanceof PsiClass) {
            _matched_1=true;
            _switchResult_1 = this.appendClassResourceURI(builder, resolvedType);
          }
        }
        if (!_matched_1) {
          String _canonicalText = null;
          if (((PsiClassType)type)!=null) {
            _canonicalText=((PsiClassType)type).getCanonicalText();
          }
          String _plus = ("Unknown type: " + _canonicalText);
          throw new IllegalStateException(_plus);
        }
        _switchResult = _switchResult_1;
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
  
  protected StringBuilder appendTypeParameterResourceURI(final StringBuilder builder, final PsiTypeParameter typeParameter) {
    StringBuilder _switchResult = null;
    PsiTypeParameterListOwner _owner = typeParameter.getOwner();
    final PsiTypeParameterListOwner owner = _owner;
    boolean _matched = false;
    if (!_matched) {
      if (owner instanceof PsiClass) {
        _matched=true;
        _switchResult = this.appendClassResourceURI(builder, ((PsiClass)owner));
      }
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
  
  protected StringBuilder appendClassResourceURI(final StringBuilder builder, final PsiClass psiClass) {
    StringBuilder _xblockexpression = null;
    {
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
  
  protected StringBuilder appendTypeFragment(final StringBuilder builder, final PsiType type) {
    StringBuilder _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof PsiPrimitiveType) {
        _matched=true;
        String _canonicalText = ((PsiPrimitiveType)type).getCanonicalText(false);
        _switchResult = builder.append(_canonicalText);
      }
    }
    if (!_matched) {
      if (type instanceof PsiClassType) {
        _matched=true;
        StringBuilder _switchResult_1 = null;
        PsiClass _resolve = ((PsiClassType)type).resolve();
        final PsiClass resolvedType = _resolve;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (resolvedType instanceof PsiTypeParameter) {
            _matched_1=true;
            _switchResult_1 = this.appendTypeParameterFragment(builder, ((PsiTypeParameter)resolvedType));
          }
        }
        if (!_matched_1) {
          if (resolvedType instanceof PsiClass) {
            _matched_1=true;
            _switchResult_1 = this.appendClassFragment(builder, resolvedType);
          }
        }
        if (!_matched_1) {
          String _canonicalText = null;
          if (((PsiClassType)type)!=null) {
            _canonicalText=((PsiClassType)type).getCanonicalText();
          }
          String _plus = ("Unknown type: " + _canonicalText);
          throw new IllegalStateException(_plus);
        }
        _switchResult = _switchResult_1;
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
      String _canonicalText = null;
      if (type!=null) {
        _canonicalText=type.getCanonicalText();
      }
      String _plus = ("Unknown type: " + _canonicalText);
      throw new IllegalStateException(_plus);
    }
    return _switchResult;
  }
  
  protected StringBuilder appendTypeParameterFragment(final StringBuilder builder, final PsiTypeParameter typeParameter) {
    StringBuilder _xblockexpression = null;
    {
      PsiTypeParameterListOwner _owner = typeParameter.getOwner();
      final PsiTypeParameterListOwner owner = _owner;
      boolean _matched = false;
      if (!_matched) {
        if (owner instanceof PsiClass) {
          _matched=true;
          this.appendClassFragment(builder, ((PsiClass)owner));
        }
      }
      if (!_matched) {
        if (owner instanceof PsiMethod) {
          _matched=true;
          this.appendMethodFragment(builder, ((PsiMethod)owner));
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/");
      String _name = typeParameter.getName();
      _builder.append(_name, "");
      _xblockexpression = builder.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected StringBuilder appendClassFragment(final StringBuilder builder, final PsiClass psiClass) {
    StringBuilder _xblockexpression = null;
    {
      final PsiClass containingClass = psiClass.getContainingClass();
      StringBuilder _xifexpression = null;
      boolean _equals = Objects.equal(containingClass, null);
      if (_equals) {
        String _qualifiedName = psiClass.getQualifiedName();
        _xifexpression = builder.append(_qualifiedName);
      } else {
        StringBuilder _appendClassFragment = this.appendClassFragment(builder, containingClass);
        StringBuilder _append = _appendClassFragment.append("$");
        String _name = psiClass.getName();
        _xifexpression = _append.append(_name);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder appendMethodFragment(final StringBuilder builder, final PsiMethod method) {
    StringBuilder _xblockexpression = null;
    {
      PsiClass _containingClass = method.getContainingClass();
      this.appendClassFragment(builder, _containingClass);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(".");
      String _name = method.getName();
      _builder.append(_name, "");
      _builder.append("(");
      builder.append(_builder);
      PsiParameterList _parameterList = method.getParameterList();
      final int parameterCount = _parameterList.getParametersCount();
      for (int i = 0; (i < parameterCount); i++) {
        {
          if ((i != 0)) {
            builder.append(",");
          }
          PsiParameterList _parameterList_1 = method.getParameterList();
          PsiParameter[] _parameters = _parameterList_1.getParameters();
          PsiParameter _get = _parameters[i];
          PsiType _type = _get.getType();
          this.appendTypeName(builder, _type);
        }
      }
      _xblockexpression = builder.append(")");
    }
    return _xblockexpression;
  }
  
  public StringBuilder appendTypeName(final StringBuilder builder, final PsiType type) {
    StringBuilder _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof PsiPrimitiveType) {
        _matched=true;
        String _canonicalText = ((PsiPrimitiveType)type).getCanonicalText(false);
        _switchResult = builder.append(_canonicalText);
      }
    }
    if (!_matched) {
      if (type instanceof PsiClassType) {
        _matched=true;
        StringBuilder _switchResult_1 = null;
        PsiClass _resolve = ((PsiClassType)type).resolve();
        final PsiClass resolvedType = _resolve;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (resolvedType instanceof PsiTypeParameter) {
            _matched_1=true;
            String _name = ((PsiTypeParameter)resolvedType).getName();
            _switchResult_1 = builder.append(_name);
          }
        }
        if (!_matched_1) {
          if (resolvedType instanceof PsiClass) {
            _matched_1=true;
            _switchResult_1 = this.appendClassFragment(builder, resolvedType);
          }
        }
        if (!_matched_1) {
          String _canonicalText = null;
          if (((PsiClassType)type)!=null) {
            _canonicalText=((PsiClassType)type).getCanonicalText();
          }
          String _plus = ("Unknown type: " + _canonicalText);
          throw new IllegalStateException(_plus);
        }
        _switchResult = _switchResult_1;
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
  
  public PsiElementFactory getPsiElementFactory(final PsiElement it) {
    Project _project = it.getProject();
    return this.getPsiElementFactory(_project);
  }
  
  public PsiElementFactory getPsiElementFactory(final Project project) {
    return PsiElementFactory.SERVICE.getInstance(project);
  }
}

package org.eclipse.xtext.idea.types.access;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
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
  
  public URI getFullURI(final /* PsiMethod */Object method) {
    throw new Error("Unresolved compilation problems:"
      + "\npsiElementFactory cannot be resolved"
      + "\ncreateType cannot be resolved"
      + "\ncontainingClass cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public URI getFullURI(final /* PsiField */Object field) {
    throw new Error("Unresolved compilation problems:"
      + "\npsiElementFactory cannot be resolved"
      + "\ncreateType cannot be resolved"
      + "\ncontainingClass cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public URI getFullURI(final /* PsiType */Object type) {
    StringBuilder _createURIBuilder = this.createURIBuilder();
    StringBuilder _appendFullURI = this.appendFullURI(_createURIBuilder, type);
    return this.createURI(_appendFullURI);
  }
  
  protected StringBuilder appendFullURI(final StringBuilder it, final /* PsiType */Object type) {
    StringBuilder _appendTypeResourceURI = this.appendTypeResourceURI(it, type);
    StringBuilder _append = _appendTypeResourceURI.append("#");
    return this.appendTypeFragment(_append, type);
  }
  
  protected StringBuilder appendTypeResourceURI(final StringBuilder builder, final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiArrayType cannot be resolved to a type."
      + "\nPsiPrimitiveType cannot be resolved to a type."
      + "\nPsiClassType cannot be resolved to a type."
      + "\nPsiTypeParameter cannot be resolved to a type."
      + "\nPsiClass cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\ncomponentType cannot be resolved"
      + "\nresolve cannot be resolved"
      + "\ncanonicalText cannot be resolved"
      + "\ncanonicalText cannot be resolved");
  }
  
  protected StringBuilder appendTypeParameterResourceURI(final StringBuilder builder, final /* PsiTypeParameter */Object typeParameter) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClass cannot be resolved to a type."
      + "\nPsiMethod cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nowner cannot be resolved"
      + "\ncontainingClass cannot be resolved");
  }
  
  protected StringBuilder appendClassResourceURI(final StringBuilder builder, final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\ncontainingClass cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nqualifiedName cannot be resolved");
  }
  
  protected StringBuilder appendTypeFragment(final StringBuilder builder, final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiPrimitiveType cannot be resolved to a type."
      + "\nPsiClassType cannot be resolved to a type."
      + "\nPsiTypeParameter cannot be resolved to a type."
      + "\nPsiClass cannot be resolved to a type."
      + "\nPsiArrayType cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\ngetCanonicalText cannot be resolved"
      + "\nresolve cannot be resolved"
      + "\ncanonicalText cannot be resolved"
      + "\ncomponentType cannot be resolved"
      + "\ncanonicalText cannot be resolved");
  }
  
  protected StringBuilder appendTypeParameterFragment(final StringBuilder builder, final /* PsiTypeParameter */Object typeParameter) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClass cannot be resolved to a type."
      + "\nPsiMethod cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nowner cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  protected StringBuilder appendClassFragment(final StringBuilder builder, final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\ncontainingClass cannot be resolved"
      + "\n== cannot be resolved"
      + "\nqualifiedName cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  protected StringBuilder appendMethodFragment(final StringBuilder builder, final /* PsiMethod */Object method) {
    throw new Error("Unresolved compilation problems:"
      + "\ncontainingClass cannot be resolved"
      + "\nname cannot be resolved"
      + "\nparameterList cannot be resolved"
      + "\nparametersCount cannot be resolved"
      + "\nparameterList cannot be resolved"
      + "\nparameters cannot be resolved"
      + "\nget cannot be resolved"
      + "\ntype cannot be resolved");
  }
  
  public StringBuilder appendTypeName(final StringBuilder builder, final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiPrimitiveType cannot be resolved to a type."
      + "\nPsiClassType cannot be resolved to a type."
      + "\nPsiTypeParameter cannot be resolved to a type."
      + "\nPsiClass cannot be resolved to a type."
      + "\nPsiArrayType cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\ngetCanonicalText cannot be resolved"
      + "\nresolve cannot be resolved"
      + "\nname cannot be resolved"
      + "\ncanonicalText cannot be resolved"
      + "\ncomponentType cannot be resolved"
      + "\ncanonicalText cannot be resolved");
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
  
  public Object getPsiElementFactory(final /* PsiElement */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field project is undefined for the type StubURIHelper"
      + "\npsiElementFactory cannot be resolved");
  }
  
  public Object getPsiElementFactory(final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiElementFactory is undefined for the type StubURIHelper"
      + "\nSERVICE cannot be resolved"
      + "\ngetInstance cannot be resolved");
  }
}

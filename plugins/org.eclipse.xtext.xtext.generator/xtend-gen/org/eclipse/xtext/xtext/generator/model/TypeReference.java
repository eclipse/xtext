/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;

@Accessors
@EqualsHashCode
@SuppressWarnings("all")
public class TypeReference {
  public static TypeReference typeRef(final String name, final TypeReference... arguments) {
    return new TypeReference(name, (List<TypeReference>)Conversions.doWrapArray(arguments));
  }
  
  /**
   * @deprecated this method is available for backwards compatibility reasons
   */
  @Deprecated
  public static TypeReference guessTypeRef(final String name, final TypeReference... arguments) {
    return new TypeReference(name, (List<TypeReference>)Conversions.doWrapArray(arguments), false);
  }
  
  public static TypeReference typeRef(final Class<?> clazz, final TypeReference... arguments) {
    return new TypeReference(clazz, (List<TypeReference>)Conversions.doWrapArray(arguments));
  }
  
  public static TypeReference typeRef(final EClass clazz, final IXtextGeneratorLanguage language) {
    ResourceSet _resourceSet = language.getResourceSet();
    return new TypeReference(clazz, _resourceSet);
  }
  
  private final String packageName;
  
  private final List<String> simpleNames;
  
  private final List<TypeReference> typeArguments;
  
  public TypeReference(final String qualifiedName) {
    this(qualifiedName, ((List<TypeReference>) null));
  }
  
  public TypeReference(final String qualifiedName, final List<TypeReference> arguments) {
    this(qualifiedName, arguments, true);
  }
  
  private TypeReference(final String qualifiedName, final List<TypeReference> arguments, final boolean strict) {
    this(TypeReference.getPackageName(qualifiedName, strict), TypeReference.getClassName(qualifiedName, strict), arguments);
  }
  
  public TypeReference(final String packageName, final String className) {
    this(packageName, className, null);
  }
  
  public TypeReference(final String packageName, final String className, final List<TypeReference> arguments) {
    if ((packageName == null)) {
      throw new IllegalArgumentException(("Invalid package name: " + packageName));
    }
    if ((className == null)) {
      throw new IllegalArgumentException(("Invalid class name: " + className));
    }
    this.packageName = packageName;
    String[] _split = className.split("\\.");
    this.simpleNames = ((List<String>)Conversions.doWrapArray(_split));
    List<TypeReference> _elvis = null;
    if (arguments != null) {
      _elvis = arguments;
    } else {
      List<TypeReference> _emptyList = Collections.<TypeReference>emptyList();
      _elvis = _emptyList;
    }
    this.typeArguments = _elvis;
  }
  
  public TypeReference(final Class<?> clazz) {
    this(clazz, null);
  }
  
  public TypeReference(final Class<?> clazz, final List<TypeReference> arguments) {
    boolean _isPrimitive = clazz.isPrimitive();
    if (_isPrimitive) {
      String _name = clazz.getName();
      String _plus = ("Type is primitive: " + _name);
      throw new IllegalArgumentException(_plus);
    }
    boolean _isAnonymousClass = clazz.isAnonymousClass();
    if (_isAnonymousClass) {
      String _name_1 = clazz.getName();
      String _plus_1 = ("Class is anonymous: " + _name_1);
      throw new IllegalArgumentException(_plus_1);
    }
    boolean _isLocalClass = clazz.isLocalClass();
    if (_isLocalClass) {
      String _name_2 = clazz.getName();
      String _plus_2 = ("Class is local: " + _name_2);
      throw new IllegalArgumentException(_plus_2);
    }
    Package _package = clazz.getPackage();
    String _name_3 = _package.getName();
    this.packageName = _name_3;
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.simpleNames = _newArrayList;
    List<TypeReference> _elvis = null;
    if (arguments != null) {
      _elvis = arguments;
    } else {
      List<TypeReference> _emptyList = Collections.<TypeReference>emptyList();
      _elvis = _emptyList;
    }
    this.typeArguments = _elvis;
    Class<?> c = clazz;
    do {
      {
        String _simpleName = c.getSimpleName();
        this.simpleNames.add(0, _simpleName);
        Class<?> _declaringClass = c.getDeclaringClass();
        c = _declaringClass;
      }
    } while((c != null));
  }
  
  public TypeReference(final EClass clazz, final ResourceSet resourceSet) {
    this(TypeReference.getQualifiedName(clazz, resourceSet));
  }
  
  public TypeReference(final EPackage epackage, final ResourceSet resourceSet) {
    this(TypeReference.getQualifiedName(epackage, resourceSet));
  }
  
  private static String getPackageName(final String qualifiedName, final boolean strict) {
    Splitter _on = Splitter.on(".");
    Iterable<String> _split = _on.split(qualifiedName);
    final List<String> segments = IterableExtensions.<String>toList(_split);
    int _size = segments.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      return "";
    }
    if (strict) {
      int _length = ((Object[])Conversions.unwrapArray(segments, Object.class)).length;
      int _minus = (_length - 1);
      final List<String> packageSegments = segments.subList(0, _minus);
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          char _charAt = it.charAt(0);
          return Boolean.valueOf(Character.isUpperCase(_charAt));
        }
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(packageSegments, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter);
      boolean _not = (!_isEmpty);
      if (_not) {
        throw new IllegalArgumentException((("Cannot determine the package name of \'" + qualifiedName) + "\'. Please use the TypeReference(packageName, className) constructor"));
      }
      return IterableExtensions.join(packageSegments, ".");
    } else {
      int _length_1 = ((Object[])Conversions.unwrapArray(segments, Object.class)).length;
      int _minus_1 = (_length_1 - 1);
      List<String> packageSegments_1 = segments.subList(0, _minus_1);
      while ((!packageSegments_1.isEmpty())) {
        String _last = IterableExtensions.<String>last(packageSegments_1);
        char _charAt = _last.charAt(0);
        boolean _isUpperCase = Character.isUpperCase(_charAt);
        if (_isUpperCase) {
          final List<String> _converted_packageSegments_1 = (List<String>)packageSegments_1;
          int _length_2 = ((Object[])Conversions.unwrapArray(_converted_packageSegments_1, Object.class)).length;
          int _minus_2 = (_length_2 - 1);
          List<String> _subList = packageSegments_1.subList(0, _minus_2);
          packageSegments_1 = _subList;
        } else {
          return IterableExtensions.join(packageSegments_1, ".");
        }
      }
      return "";
    }
  }
  
  private static String getClassName(final String qualifiedName, final boolean strict) {
    String _xblockexpression = null;
    {
      final String packageName = TypeReference.getPackageName(qualifiedName, strict);
      String _xifexpression = null;
      boolean _isEmpty = packageName.isEmpty();
      if (_isEmpty) {
        _xifexpression = qualifiedName;
      } else {
        int _length = packageName.length();
        int _plus = (_length + 1);
        int _length_1 = qualifiedName.length();
        _xifexpression = qualifiedName.substring(_plus, _length_1);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private static String getQualifiedName(final EClass clazz, final ResourceSet resourceSet) {
    String _xifexpression = null;
    EPackage _ePackage = clazz.getEPackage();
    String _nsURI = _ePackage.getNsURI();
    boolean _equals = Objects.equal(_nsURI, "http://www.eclipse.org/2008/Xtext");
    if (_equals) {
      String _name = clazz.getName();
      _xifexpression = ("org.eclipse.xtext." + _name);
    } else {
      GenClass _genClass = GenModelUtil2.getGenClass(clazz, resourceSet);
      _xifexpression = _genClass.getQualifiedInterfaceName();
    }
    return _xifexpression;
  }
  
  private static String getQualifiedName(final EPackage epackage, final ResourceSet resourceSet) {
    GenPackage _genPackage = GenModelUtil2.getGenPackage(epackage, resourceSet);
    return _genPackage.getQualifiedPackageInterfaceName();
  }
  
  @Override
  public String toString() {
    String _name = this.getName();
    final Function1<TypeReference, CharSequence> _function = new Function1<TypeReference, CharSequence>() {
      @Override
      public CharSequence apply(final TypeReference it) {
        return it.toString();
      }
    };
    String _join = IterableExtensions.<TypeReference>join(this.typeArguments, "<", ", ", ">", _function);
    return (_name + _join);
  }
  
  public String getName() {
    String _join = IterableExtensions.join(this.simpleNames, ".");
    return ((this.packageName + ".") + _join);
  }
  
  public String getSimpleName() {
    return IterableExtensions.<String>last(this.simpleNames);
  }
  
  public String getPath() {
    String _replace = this.packageName.replace(".", "/");
    String _plus = (_replace + "/");
    String _head = IterableExtensions.<String>head(this.simpleNames);
    return (_plus + _head);
  }
  
  public String getJavaPath() {
    String _path = this.getPath();
    return (_path + ".java");
  }
  
  public String getXtendPath() {
    String _path = this.getPath();
    return (_path + ".xtend");
  }
  
  @Pure
  public String getPackageName() {
    return this.packageName;
  }
  
  @Pure
  public List<String> getSimpleNames() {
    return this.simpleNames;
  }
  
  @Pure
  public List<TypeReference> getTypeArguments() {
    return this.typeArguments;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TypeReference other = (TypeReference) obj;
    if (this.packageName == null) {
      if (other.packageName != null)
        return false;
    } else if (!this.packageName.equals(other.packageName))
      return false;
    if (this.simpleNames == null) {
      if (other.simpleNames != null)
        return false;
    } else if (!this.simpleNames.equals(other.simpleNames))
      return false;
    if (this.typeArguments == null) {
      if (other.typeArguments != null)
        return false;
    } else if (!this.typeArguments.equals(other.typeArguments))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.packageName== null) ? 0 : this.packageName.hashCode());
    result = prime * result + ((this.simpleNames== null) ? 0 : this.simpleNames.hashCode());
    result = prime * result + ((this.typeArguments== null) ? 0 : this.typeArguments.hashCode());
    return result;
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@EqualsHashCode
@SuppressWarnings("all")
public class TypeReference {
  public static TypeReference typeRef(final String name, final String... arguments) {
    final Function1<String, TypeReference> _function = new Function1<String, TypeReference>() {
      @Override
      public TypeReference apply(final String it) {
        return new TypeReference(it);
      }
    };
    List<TypeReference> _map = ListExtensions.<String, TypeReference>map(((List<String>)Conversions.doWrapArray(arguments)), _function);
    return new TypeReference(name, _map);
  }
  
  public static TypeReference typeRef(final Class<?> clazz, final Class<?>... arguments) {
    final Function1<Class<?>, TypeReference> _function = new Function1<Class<?>, TypeReference>() {
      @Override
      public TypeReference apply(final Class<?> it) {
        return new TypeReference(it);
      }
    };
    List<TypeReference> _map = ListExtensions.<Class<?>, TypeReference>map(((List<Class<?>>)Conversions.doWrapArray(arguments)), _function);
    return new TypeReference(clazz, _map);
  }
  
  private final String name;
  
  private final List<TypeReference> arguments;
  
  public TypeReference(final String name) {
    this.name = name;
    List<TypeReference> _emptyList = Collections.<TypeReference>emptyList();
    this.arguments = _emptyList;
  }
  
  public TypeReference(final String name, final List<TypeReference> arguments) {
    this.name = name;
    List<TypeReference> _unmodifiableList = Collections.<TypeReference>unmodifiableList(arguments);
    this.arguments = _unmodifiableList;
  }
  
  public TypeReference(final String packageName, final String className) {
    this.name = ((packageName + ".") + className);
    List<TypeReference> _emptyList = Collections.<TypeReference>emptyList();
    this.arguments = _emptyList;
  }
  
  public TypeReference(final Class<?> clazz) {
    String _name = clazz.getName();
    String _replace = _name.replace("$", ".");
    this.name = _replace;
    List<TypeReference> _emptyList = Collections.<TypeReference>emptyList();
    this.arguments = _emptyList;
  }
  
  public TypeReference(final Class<?> clazz, final List<TypeReference> arguments) {
    String _name = clazz.getName();
    String _replace = _name.replace("$", ".");
    this.name = _replace;
    List<TypeReference> _unmodifiableList = Collections.<TypeReference>unmodifiableList(arguments);
    this.arguments = _unmodifiableList;
  }
  
  @Override
  public String toString() {
    final Function1<TypeReference, CharSequence> _function = new Function1<TypeReference, CharSequence>() {
      @Override
      public CharSequence apply(final TypeReference it) {
        return it.toString();
      }
    };
    String _join = IterableExtensions.<TypeReference>join(this.arguments, "<", ", ", ">", _function);
    return (this.name + _join);
  }
  
  public String getSimpleName() {
    final int simpleNameIndex = this.name.lastIndexOf(".");
    return this.name.substring((simpleNameIndex + 1));
  }
  
  public String getPackage() {
    int packageEnd = this.name.length();
    for (int i = (this.name.length() - 1); (i >= 0); i--) {
      char _charAt = this.name.charAt(i);
      boolean _matches = this.matches(_charAt, '.');
      if (_matches) {
        char _charAt_1 = this.name.charAt((i + 1));
        boolean _isLowerCase = Character.isLowerCase(_charAt_1);
        if (_isLowerCase) {
          return this.name.substring(0, packageEnd);
        } else {
          packageEnd = i;
        }
      }
    }
    return "";
  }
  
  public String getPath() {
    final String packageName = this.getPackage();
    int _length = packageName.length();
    int _plus = (_length + 1);
    String className = this.name.substring(_plus);
    final int outerClassEnd = className.indexOf(".");
    if ((outerClassEnd >= 0)) {
      String _substring = className.substring(0, outerClassEnd);
      className = _substring;
    }
    String _replace = packageName.replace(".", "/");
    String _plus_1 = (_replace + "/");
    String _plus_2 = (_plus_1 + className);
    return (_plus_2 + ".java");
  }
  
  private boolean matches(final char c1, final char c2) {
    return (c1 == c2);
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public List<TypeReference> getArguments() {
    return this.arguments;
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
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.arguments == null) {
      if (other.arguments != null)
        return false;
    } else if (!this.arguments.equals(other.arguments))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.arguments== null) ? 0 : this.arguments.hashCode());
    return result;
  }
}

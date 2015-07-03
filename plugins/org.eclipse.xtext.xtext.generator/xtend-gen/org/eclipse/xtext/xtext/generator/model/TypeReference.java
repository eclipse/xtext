/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtext.xbase.lib.Pure;

@EqualsHashCode
@SuppressWarnings("all")
public class TypeReference {
  private final String name;
  
  public TypeReference(final String name) {
    this.name = name;
  }
  
  public TypeReference(final String packageName, final String className) {
    this.name = ((packageName + ".") + className);
  }
  
  public TypeReference(final Class<?> clazz) {
    String _name = clazz.getName();
    String _replace = _name.replace("$", ".");
    this.name = _replace;
  }
  
  @Override
  public String toString() {
    return this.name;
  }
  
  public String getName() {
    return this.name;
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
  
  private boolean matches(final char c1, final char c2) {
    return (c1 == c2);
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
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    return result;
  }
}

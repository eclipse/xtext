/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.descriptions;

import com.google.common.base.Splitter;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@EqualsHashCode
@Accessors
@SuppressWarnings("all")
public class ClasspathTypeDescriptor implements ITypeDescriptor {
  private static final Splitter PACKAGE_AND_NESTED_CLASS_SPLITTER = Splitter.onPattern("\\.|\\$");
  
  private final String name;
  
  private final int modifiers;
  
  @Override
  public String getSimpleName() {
    return this.getQualifiedName().getLastSegment();
  }
  
  @Override
  public QualifiedName getQualifiedName() {
    return QualifiedName.create(((String[])Conversions.unwrapArray(ClasspathTypeDescriptor.PACKAGE_AND_NESTED_CLASS_SPLITTER.split(this.name), String.class)));
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
    ClasspathTypeDescriptor other = (ClasspathTypeDescriptor) obj;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (other.modifiers != this.modifiers)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    return prime * result + this.modifiers;
  }
  
  public ClasspathTypeDescriptor(final String name, final int modifiers) {
    super();
    this.name = name;
    this.modifiers = modifiers;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public int getModifiers() {
    return this.modifiers;
  }
}

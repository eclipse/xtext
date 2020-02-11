/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.annotations;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;

/**
 * A class annotation configuration for the <code>@SuppressWarnings</code> annotation.
 */
@Accessors
@SuppressWarnings("all")
public class SuppressWarningsAnnotation implements IClassAnnotation {
  private String suppress = "all";
  
  @Override
  public CharSequence generate() {
    final StringBuilder stringBuilder = new StringBuilder("@SuppressWarnings(");
    final String[] suppressedWarnings = this.suppress.split("\\s*,\\s*");
    int _length = suppressedWarnings.length;
    boolean _notEquals = (_length != 1);
    if (_notEquals) {
      stringBuilder.append("{");
    }
    final Function1<String, CharSequence> _function = (String it) -> {
      return it;
    };
    stringBuilder.append(IterableExtensions.<String>join(((Iterable<String>)Conversions.doWrapArray(suppressedWarnings)), "\"", "\", \"", "\"", _function));
    int _length_1 = suppressedWarnings.length;
    boolean _notEquals_1 = (_length_1 != 1);
    if (_notEquals_1) {
      stringBuilder.append("}");
    }
    stringBuilder.append(")");
    return stringBuilder;
  }
  
  @Override
  public boolean appliesTo(final JavaFileAccess javaFile) {
    return true;
  }
  
  @Override
  public TypeReference getAnnotationImport() {
    return new TypeReference(SuppressWarnings.class);
  }
  
  @Override
  public String toString() {
    return this.generate().toString();
  }
  
  @Override
  public boolean equals(final Object obj) {
    return (obj instanceof SuppressWarningsAnnotation);
  }
  
  @Override
  public int hashCode() {
    return this.getClass().getName().hashCode();
  }
  
  @Pure
  public String getSuppress() {
    return this.suppress;
  }
  
  public void setSuppress(final String suppress) {
    this.suppress = suppress;
  }
}

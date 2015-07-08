/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

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
    final Function1<String, CharSequence> _function = new Function1<String, CharSequence>() {
      @Override
      public CharSequence apply(final String it) {
        return it;
      }
    };
    String _join = IterableExtensions.<String>join(((Iterable<String>)Conversions.doWrapArray(suppressedWarnings)), "\"", "\", \"", "\"", _function);
    stringBuilder.append(_join);
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
    return new TypeReference("java.lang.SuppressWarnings");
  }
  
  @Pure
  public String getSuppress() {
    return this.suppress;
  }
  
  public void setSuppress(final String suppress) {
    this.suppress = suppress;
  }
}

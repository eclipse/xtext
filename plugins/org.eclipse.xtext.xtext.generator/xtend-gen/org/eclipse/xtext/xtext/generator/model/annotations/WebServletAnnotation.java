/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model.annotations;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;

/**
 * A class annotation configuration for the <code>@WebServlet</code> annotation.
 */
@Accessors
@SuppressWarnings("all")
public class WebServletAnnotation implements IClassAnnotation {
  private String name;
  
  private String urlPatterns;
  
  @Override
  public CharSequence generate() {
    final StringBuilder stringBuilder = new StringBuilder("@WebServlet(");
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.name);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      this.operator_add(stringBuilder, "name = \"");
      this.operator_add(stringBuilder, this.name);
      this.operator_add(stringBuilder, "\"");
    }
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.urlPatterns);
    boolean _not_1 = (!_isNullOrEmpty_1);
    if (_not_1) {
      boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(this.name);
      boolean _not_2 = (!_isNullOrEmpty_2);
      if (_not_2) {
        this.operator_add(stringBuilder, ", ");
      }
      this.operator_add(stringBuilder, "urlPatterns = \"");
      this.operator_add(stringBuilder, this.urlPatterns);
      this.operator_add(stringBuilder, "\"");
    }
    this.operator_add(stringBuilder, ")");
    return stringBuilder;
  }
  
  @Override
  public boolean appliesTo(final JavaFileAccess javaFile) {
    return true;
  }
  
  @Override
  public TypeReference getAnnotationImport() {
    return new TypeReference("javax.servlet.annotation.WebServlet");
  }
  
  private void operator_add(final StringBuilder stringBuilder, final String s) {
    stringBuilder.append(s);
  }
  
  @Override
  public String toString() {
    CharSequence _generate = this.generate();
    return _generate.toString();
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public String getUrlPatterns() {
    return this.urlPatterns;
  }
  
  public void setUrlPatterns(final String urlPatterns) {
    this.urlPatterns = urlPatterns;
  }
}

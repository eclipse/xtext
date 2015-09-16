/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model.annotations;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.XtextGenerator;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;

/**
 * A class annotation configuration for the <code>@Generated</code> annotation.
 */
@Accessors
@SuppressWarnings("all")
public class GeneratedClassAnnotation implements IClassAnnotation {
  private boolean includeDate = false;
  
  private String comment;
  
  @Override
  public CharSequence generate() {
    final StringBuilder stringBuilder = new StringBuilder("@Generated(");
    boolean _or = false;
    if (this.includeDate) {
      _or = true;
    } else {
      boolean _isEmpty = Strings.isEmpty(this.comment);
      boolean _not = (!_isEmpty);
      _or = _not;
    }
    if (_or) {
      this.operator_add(stringBuilder, "value = ");
    }
    this.operator_add(stringBuilder, "\"");
    String _generatorName = this.getGeneratorName();
    this.operator_add(stringBuilder, _generatorName);
    this.operator_add(stringBuilder, "\"");
    if (this.includeDate) {
      final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mmZ");
      Date _date = new Date();
      final String date = dateFormat.format(_date);
      this.operator_add(stringBuilder, ", date = \"");
      this.operator_add(stringBuilder, date);
      this.operator_add(stringBuilder, "\"");
    }
    boolean _isEmpty_1 = Strings.isEmpty(this.comment);
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      final String convertedComment = Strings.convertToJavaString(this.comment);
      this.operator_add(stringBuilder, ", comments = \"");
      this.operator_add(stringBuilder, convertedComment);
      this.operator_add(stringBuilder, "\"");
    }
    this.operator_add(stringBuilder, ")");
    return stringBuilder;
  }
  
  protected String getGeneratorName() {
    return XtextGenerator.class.getName();
  }
  
  @Override
  public boolean appliesTo(final JavaFileAccess javaFile) {
    return javaFile.isMarkedAsGenerated();
  }
  
  @Override
  public TypeReference getAnnotationImport() {
    return new TypeReference("javax.annotation.Generated");
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
  public boolean isIncludeDate() {
    return this.includeDate;
  }
  
  public void setIncludeDate(final boolean includeDate) {
    this.includeDate = includeDate;
  }
  
  @Pure
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
}

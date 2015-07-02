/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;

@SuppressWarnings("all")
public class JavaFileAccess extends TextFileAccess {
  private final Map<String, String> imports = CollectionLiterals.<String, String>newHashMap();
  
  private final String packageName;
  
  private final CodeConfig codeConfig;
  
  @Accessors
  private CharSequence typeComment;
  
  @Accessors
  private boolean markedAsGenerated;
  
  public JavaFileAccess(final String qualifiedName, final CodeConfig codeConfig) {
    final int simpleNameIndex = qualifiedName.lastIndexOf(".");
    String _substring = qualifiedName.substring(0, simpleNameIndex);
    this.packageName = _substring;
    final String simpleName = qualifiedName.substring((simpleNameIndex + 1));
    String _replace = this.packageName.replace(".", "/");
    String _plus = (_replace + "/");
    String _plus_1 = (_plus + simpleName);
    String _plus_2 = (_plus_1 + ".java");
    this.setPath(_plus_2);
    this.codeConfig = codeConfig;
  }
  
  public String imported(final Class<?> clazz) {
    String _name = clazz.getName();
    String _replace = _name.replace("$", ".");
    return this.imported(_replace);
  }
  
  public String imported(final String clazz) {
    final int simpleNameIndex = clazz.lastIndexOf(".");
    final String simpleName = clazz.substring((simpleNameIndex + 1));
    final String packageName = clazz.substring(0, simpleNameIndex);
    boolean _or = false;
    boolean _isJavaDefaultType = CodeGenUtil.isJavaDefaultType(simpleName);
    if (_isJavaDefaultType) {
      _or = true;
    } else {
      boolean _equals = Objects.equal(this.packageName, packageName);
      _or = _equals;
    }
    if (_or) {
      return simpleName;
    }
    final String imported = this.imports.get(simpleName);
    boolean _notEquals = (!Objects.equal(imported, null));
    if (_notEquals) {
      boolean _equals_1 = imported.equals(clazz);
      if (_equals_1) {
        return simpleName;
      } else {
        return clazz;
      }
    }
    this.imports.put(simpleName, clazz);
    return simpleName;
  }
  
  @Override
  public CharSequence generate() {
    List<IClassAnnotation> _classAnnotations = this.codeConfig.getClassAnnotations();
    final Function1<IClassAnnotation, Boolean> _function = new Function1<IClassAnnotation, Boolean>() {
      @Override
      public Boolean apply(final IClassAnnotation it) {
        return Boolean.valueOf(it.appliesTo(JavaFileAccess.this));
      }
    };
    final Iterable<IClassAnnotation> classAnnotations = IterableExtensions.<IClassAnnotation>filter(_classAnnotations, _function);
    final Procedure1<IClassAnnotation> _function_1 = new Procedure1<IClassAnnotation>() {
      @Override
      public void apply(final IClassAnnotation it) {
        String _annotationImport = it.getAnnotationImport();
        JavaFileAccess.this.imported(_annotationImport);
      }
    };
    IterableExtensions.<IClassAnnotation>forEach(classAnnotations, _function_1);
    Collection<String> _values = this.imports.values();
    final ArrayList<String> sortedImports = Lists.<String>newArrayList(_values);
    Collections.<String>sort(sortedImports);
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this.codeConfig.getFileHeader();
    _builder.append(_fileHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    _builder.append(this.packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      for(final String importName : sortedImports) {
        _builder.append("import ");
        _builder.append(importName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append(this.typeComment, "");
    _builder.newLineIfNotEmpty();
    {
      for(final IClassAnnotation annot : classAnnotations) {
        CharSequence _generate = annot.generate();
        _builder.append(_generate, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      List<CharSequence> _codeFragments = this.getCodeFragments();
      for(final CharSequence fragment : _codeFragments) {
        _builder.append(fragment, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  @Pure
  public CharSequence getTypeComment() {
    return this.typeComment;
  }
  
  public void setTypeComment(final CharSequence typeComment) {
    this.typeComment = typeComment;
  }
  
  @Pure
  public boolean isMarkedAsGenerated() {
    return this.markedAsGenerated;
  }
  
  public void setMarkedAsGenerated(final boolean markedAsGenerated) {
    this.markedAsGenerated = markedAsGenerated;
  }
}

/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;

/**
 * A specialized Java file generator used for classes in the 'src-gen' folder.
 */
@SuppressWarnings("all")
public class GeneratedJavaFileAccess extends JavaFileAccess {
  private CharSequence typeComment;

  @Accessors
  private final List<IClassAnnotation> annotations = CollectionLiterals.<IClassAnnotation>newArrayList();

  protected GeneratedJavaFileAccess(final TypeReference typeRef, final CodeConfig codeConfig) {
    super(typeRef, codeConfig);
  }

  @Override
  public boolean isMarkedAsGenerated() {
    return true;
  }

  @Override
  public void setMarkedAsGenerated(final boolean markedAsGenerated) {
    if ((!markedAsGenerated)) {
      throw new IllegalArgumentException("It\'s always generated");
    }
  }

  public void setTypeComment(final StringConcatenationClient javaContent) {
    final JavaFileAccess.JavaTypeAwareStringConcatenation javaStringConcat = new JavaFileAccess.JavaTypeAwareStringConcatenation(this);
    javaStringConcat.append(javaContent);
    this.typeComment = javaStringConcat;
  }

  /**
   * Prepends the addition of required imports of the employed annotations.
   * Since the 'typeComment' is a {@link JavaFileAccess.JavaTypeAwareStringConcatenation}
   * any optionally required imports are already processed and tracked in {@link #imports}.
   */
  @Override
  public CharSequence getContent() {
    CharSequence _xblockexpression = null;
    {
      final Consumer<IClassAnnotation> _function = (IClassAnnotation it) -> {
        this.importType(it.getAnnotationImport());
      };
      this.getClassAnnotations().forEach(_function);
      _xblockexpression = super.getContent();
    }
    return _xblockexpression;
  }

  private Set<IClassAnnotation> getClassAnnotations() {
    final Function1<IClassAnnotation, Boolean> _function = (IClassAnnotation it) -> {
      return Boolean.valueOf(it.appliesTo(this));
    };
    Iterable<IClassAnnotation> _filter = IterableExtensions.<IClassAnnotation>filter(this.codeConfig.getClassAnnotations(), _function);
    return IterableExtensions.<IClassAnnotation>toSet(Iterables.<IClassAnnotation>concat(this.annotations, _filter));
  }

  @Override
  public CharSequence getInternalContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.typeComment);
    _builder.newLineIfNotEmpty();
    {
      Set<IClassAnnotation> _classAnnotations = this.getClassAnnotations();
      for(final IClassAnnotation annot : _classAnnotations) {
        CharSequence _generate = annot.generate();
        _builder.append(_generate);
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _internalContent = super.getInternalContent();
    _builder.append(_internalContent);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  @Pure
  public List<IClassAnnotation> getAnnotations() {
    return this.annotations;
  }
}

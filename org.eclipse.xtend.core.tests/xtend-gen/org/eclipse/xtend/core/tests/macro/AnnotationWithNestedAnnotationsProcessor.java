/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class AnnotationWithNestedAnnotationsProcessor implements RegisterGlobalsParticipant<TypeDeclaration>, TransformationParticipant<MutableTypeDeclaration> {
  @Override
  public void doRegisterGlobals(final List<? extends TypeDeclaration> decls, @Extension final RegisterGlobalsContext context) {
    final Function1<TypeDeclaration, Boolean> _function = (TypeDeclaration it) -> {
      return Boolean.valueOf((it instanceof ClassDeclaration));
    };
    final Function1<TypeDeclaration, ClassDeclaration> _function_1 = (TypeDeclaration it) -> {
      return ((ClassDeclaration) it);
    };
    final Consumer<ClassDeclaration> _function_2 = (ClassDeclaration it) -> {
      this.doRegisterGlobals(it, context);
    };
    IterableExtensions.map(IterableExtensions.filter(decls, _function), _function_1).forEach(_function_2);
  }

  public void doRegisterGlobals(final TypeDeclaration decl, @Extension final RegisterGlobalsContext context) {
    AnnotationWithNestedAnnotationsProcessor.readConfig(decl);
  }

  @Override
  public void doTransform(final List<? extends MutableTypeDeclaration> decls, @Extension final TransformationContext context) {
    final Function1<MutableTypeDeclaration, Boolean> _function = (MutableTypeDeclaration it) -> {
      return Boolean.valueOf((!(it instanceof MutableClassDeclaration)));
    };
    final Consumer<MutableTypeDeclaration> _function_1 = (MutableTypeDeclaration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _simpleName = it.getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" is not a class");
      context.addError(it, _builder.toString());
    };
    IterableExtensions.filter(decls, _function).forEach(_function_1);
    final Function1<MutableTypeDeclaration, Boolean> _function_2 = (MutableTypeDeclaration it) -> {
      return Boolean.valueOf((it instanceof MutableClassDeclaration));
    };
    final Function1<MutableTypeDeclaration, MutableClassDeclaration> _function_3 = (MutableTypeDeclaration it) -> {
      return ((MutableClassDeclaration) it);
    };
    final Consumer<MutableClassDeclaration> _function_4 = (MutableClassDeclaration it) -> {
      this.doTransform(it, context);
    };
    IterableExtensions.map(IterableExtensions.filter(decls, _function_2), _function_3).forEach(_function_4);
  }

  public void doTransform(@Extension final MutableClassDeclaration clazz, @Extension final TransformationContext context) {
    AnnotationWithNestedAnnotationsProcessor.readConfig(clazz);
  }

  public static void readConfig(final TypeDeclaration clazz) {
    final Function1<AnnotationReference, Boolean> _function = (AnnotationReference it) -> {
      String _qualifiedName = it.getAnnotationTypeDeclaration().getQualifiedName();
      String _name = AnnotationWithNestedAnnotations.Annotation1.class.getName();
      return Boolean.valueOf(Objects.equals(_qualifiedName, _name));
    };
    final Consumer<AnnotationReference> _function_1 = (AnnotationReference it) -> {
      new AnnotationWithNestedAnnotations.Annotation1Config(it);
    };
    IterableExtensions.filter(clazz.getAnnotations(), _function).forEach(_function_1);
    final Function1<AnnotationReference, Boolean> _function_2 = (AnnotationReference it) -> {
      String _qualifiedName = it.getAnnotationTypeDeclaration().getQualifiedName();
      String _name = AnnotationWithNestedAnnotations.Annotation2.class.getName();
      return Boolean.valueOf(Objects.equals(_qualifiedName, _name));
    };
    final Consumer<AnnotationReference> _function_3 = (AnnotationReference it) -> {
      new AnnotationWithNestedAnnotations.Annotation2Config(it);
    };
    IterableExtensions.filter(clazz.getAnnotations(), _function_2).forEach(_function_3);
    final Function1<AnnotationReference, Boolean> _function_4 = (AnnotationReference it) -> {
      String _qualifiedName = it.getAnnotationTypeDeclaration().getQualifiedName();
      String _name = AnnotationWithNestedAnnotations.Annotation3.class.getName();
      return Boolean.valueOf(Objects.equals(_qualifiedName, _name));
    };
    final Consumer<AnnotationReference> _function_5 = (AnnotationReference it) -> {
      new AnnotationWithNestedAnnotations.Annotation3Config(it);
    };
    IterableExtensions.filter(clazz.getAnnotations(), _function_4).forEach(_function_5);
  }
}

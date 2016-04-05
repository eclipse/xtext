/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.tests;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class TestDecoratorProcessor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration cls, @Extension final TransformationContext context) {
    final MutableFieldDeclaration delegate = cls.findDeclaredField("delegate");
    boolean _equals = Objects.equal(delegate, null);
    if (_equals) {
      context.addWarning(cls, "Delegate is not declared");
      return;
    }
    final Type atTest = context.findTypeGlobally(Test.class);
    final Type atIgnore = context.findTypeGlobally(Ignore.class);
    delegate.markAsRead();
    TypeReference _type = delegate.getType();
    Iterable<? extends ResolvedMethod> _allResolvedMethods = _type.getAllResolvedMethods();
    final Function1<ResolvedMethod, MethodDeclaration> _function = new Function1<ResolvedMethod, MethodDeclaration>() {
      @Override
      public MethodDeclaration apply(final ResolvedMethod it) {
        return it.getDeclaration();
      }
    };
    Iterable<MethodDeclaration> _map = IterableExtensions.map(_allResolvedMethods, _function);
    final Function1<MethodDeclaration, Boolean> _function_1 = new Function1<MethodDeclaration, Boolean>() {
      @Override
      public Boolean apply(final MethodDeclaration it) {
        boolean _and = false;
        AnnotationReference _findAnnotation = it.findAnnotation(atTest);
        boolean _tripleNotEquals = (_findAnnotation != null);
        if (!_tripleNotEquals) {
          _and = false;
        } else {
          AnnotationReference _findAnnotation_1 = it.findAnnotation(atIgnore);
          boolean _tripleEquals = (_findAnnotation_1 == null);
          _and = _tripleEquals;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<MethodDeclaration> _filter = IterableExtensions.<MethodDeclaration>filter(_map, _function_1);
    final Function1<MethodDeclaration, Boolean> _function_2 = new Function1<MethodDeclaration, Boolean>() {
      @Override
      public Boolean apply(final MethodDeclaration it) {
        String _simpleName = it.getSimpleName();
        MutableMethodDeclaration _findDeclaredMethod = cls.findDeclaredMethod(_simpleName);
        return Boolean.valueOf(Objects.equal(_findDeclaredMethod, null));
      }
    };
    Iterable<MethodDeclaration> _filter_1 = IterableExtensions.<MethodDeclaration>filter(_filter, _function_2);
    final Function1<MethodDeclaration, String> _function_3 = new Function1<MethodDeclaration, String>() {
      @Override
      public String apply(final MethodDeclaration it) {
        return it.getSimpleName();
      }
    };
    List<MethodDeclaration> _sortBy = IterableExtensions.<MethodDeclaration, String>sortBy(_filter_1, _function_3);
    for (final MethodDeclaration declaredMethod : _sortBy) {
      String _simpleName = declaredMethod.getSimpleName();
      final Procedure1<MutableMethodDeclaration> _function_4 = new Procedure1<MutableMethodDeclaration>() {
        @Override
        public void apply(final MutableMethodDeclaration it) {
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("delegate.");
              String _simpleName = declaredMethod.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append("();");
            }
          };
          it.setBody(_client);
          Iterable<? extends TypeReference> _exceptions = declaredMethod.getExceptions();
          it.setExceptions(((TypeReference[])Conversions.unwrapArray(_exceptions, TypeReference.class)));
        }
      };
      cls.addMethod(_simpleName, _function_4);
    }
  }
}

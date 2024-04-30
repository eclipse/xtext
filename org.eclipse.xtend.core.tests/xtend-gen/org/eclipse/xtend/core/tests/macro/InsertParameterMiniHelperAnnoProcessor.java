/**
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.Objects;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class InsertParameterMiniHelperAnnoProcessor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration clazz, @Extension final TransformationContext context) {
    final Function1<AnnotationReference, Boolean> _function = (AnnotationReference a) -> {
      return Boolean.valueOf((Objects.equals(a.getAnnotationTypeDeclaration().getSimpleName(), InsertParameterMiniHelperAnno.class.getSimpleName()) && (a.getClassValue("classRef") != null)));
    };
    AnnotationReference _findFirst = IterableExtensions.findFirst(clazz.getAnnotations(), _function);
    TypeReference _classValue = null;
    if (_findFirst!=null) {
      _classValue=_findFirst.getClassValue("classRef");
    }
    final TypeReference annotClassName = _classValue;
    final Function1<AnnotationReference, Boolean> _function_1 = (AnnotationReference a) -> {
      String _simpleName = a.getAnnotationTypeDeclaration().getSimpleName();
      String _simpleName_1 = InsertParameterMiniHelperAnno.class.getSimpleName();
      return Boolean.valueOf(Objects.equals(_simpleName, _simpleName_1));
    };
    final int position = IterableExtensions.findFirst(clazz.getAnnotations(), _function_1).getIntValue("position");
    Iterable<? extends MutableMethodDeclaration> _declaredMethods = clazz.getDeclaredMethods();
    for (final MutableMethodDeclaration m : _declaredMethods) {
      m.addParameter(position, "_self", annotClassName);
    }
  }
}

/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.lib.macro.AbstractMethodProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CheckMutableMethodDeclarationProcessor extends AbstractMethodProcessor {
  @Override
  public void doTransform(final MutableMethodDeclaration annotatedMethod, @Extension final TransformationContext context) {
    final Procedure1<String> _function = (String identifier) -> {
      annotatedMethod.addTypeParameter(identifier).remove();
    };
    MutableAssert.assertValidJavaIdentifier("name", _function);
    final Procedure0 _function_1 = () -> {
      annotatedMethod.addTypeParameter("T", ((TypeReference[]) null));
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot be null", _function_1);
    final Procedure0 _function_2 = () -> {
      annotatedMethod.addTypeParameter("T", new TypeReference[] { null });
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot contain null", _function_2);
    annotatedMethod.addTypeParameter("T", ((TypeReference[])Conversions.unwrapArray(CollectionLiterals.<TypeReference>emptyList(), TypeReference.class))).remove();
    final Procedure1<String> _function_3 = (String identifier) -> {
      annotatedMethod.addParameter(identifier, context.newTypeReference(String.class)).remove();
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_3);
    final Procedure0 _function_4 = () -> {
      annotatedMethod.addParameter("foo", null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "type cannot be null", _function_4);
    final Procedure0 _function_5 = () -> {
      annotatedMethod.setReturnType(null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "returnType cannot be null", _function_5);
    final Procedure1<String> _function_6 = (String identifier) -> {
      annotatedMethod.setSimpleName(identifier);
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_6);
    final Procedure0 _function_7 = () -> {
      annotatedMethod.setExceptions(((TypeReference[]) null));
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "exceptions cannot be null", _function_7);
    final Procedure0 _function_8 = () -> {
      annotatedMethod.setExceptions(new TypeReference[] { null });
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "exceptions cannot contain null", _function_8);
    annotatedMethod.setExceptions(((TypeReference[])Conversions.unwrapArray(CollectionLiterals.<TypeReference>emptyList(), TypeReference.class)));
  }
}

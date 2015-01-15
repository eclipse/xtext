/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.core.tests.macro.MutableAssert;
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
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
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String identifier) {
        MutableTypeParameterDeclaration _addTypeParameter = annotatedMethod.addTypeParameter(identifier);
        _addTypeParameter.remove();
      }
    };
    MutableAssert.assertValidJavaIdentifier("name", _function);
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        annotatedMethod.addTypeParameter("T", ((TypeReference[]) null));
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot be null", _function_1);
    final Procedure0 _function_2 = new Procedure0() {
      @Override
      public void apply() {
        annotatedMethod.addTypeParameter("T", new TypeReference[] { null });
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot contain null", _function_2);
    List<TypeReference> _emptyList = CollectionLiterals.<TypeReference>emptyList();
    MutableTypeParameterDeclaration _addTypeParameter = annotatedMethod.addTypeParameter("T", ((TypeReference[])Conversions.unwrapArray(_emptyList, TypeReference.class)));
    _addTypeParameter.remove();
    final Procedure1<String> _function_3 = new Procedure1<String>() {
      @Override
      public void apply(final String identifier) {
        TypeReference _newTypeReference = context.newTypeReference(String.class);
        MutableParameterDeclaration _addParameter = annotatedMethod.addParameter(identifier, _newTypeReference);
        _addParameter.remove();
      }
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_3);
    final Procedure0 _function_4 = new Procedure0() {
      @Override
      public void apply() {
        annotatedMethod.addParameter("foo", null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "type cannot be null", _function_4);
    final Procedure0 _function_5 = new Procedure0() {
      @Override
      public void apply() {
        annotatedMethod.setReturnType(null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "returnType cannot be null", _function_5);
    final Procedure1<String> _function_6 = new Procedure1<String>() {
      @Override
      public void apply(final String identifier) {
        annotatedMethod.setSimpleName(identifier);
      }
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_6);
    final Procedure0 _function_7 = new Procedure0() {
      @Override
      public void apply() {
        annotatedMethod.setExceptions(null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "exceptions cannot be null", _function_7);
    final Procedure0 _function_8 = new Procedure0() {
      @Override
      public void apply() {
        annotatedMethod.setExceptions(new TypeReference[] { null });
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "exceptions cannot contain null", _function_8);
    List<TypeReference> _emptyList_1 = CollectionLiterals.<TypeReference>emptyList();
    annotatedMethod.setExceptions(((TypeReference[])Conversions.unwrapArray(_emptyList_1, TypeReference.class)));
  }
}

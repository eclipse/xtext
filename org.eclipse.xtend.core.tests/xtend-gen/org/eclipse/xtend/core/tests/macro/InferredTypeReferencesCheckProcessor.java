/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Iterables;
import java.util.Collections;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

@SuppressWarnings("all")
public class InferredTypeReferencesCheckProcessor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    final TypeReference type = it.findDeclaredField("foo").getType();
    Assert.assertTrue(type.isInferred());
    final Procedure0 _function = () -> {
      it.setExtendedClass(type);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as extended class.", _function);
    final Procedure0 _function_1 = () -> {
      Iterable<? extends TypeReference> _implementedInterfaces = it.getImplementedInterfaces();
      Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_implementedInterfaces, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(type)));
      it.setImplementedInterfaces(_plus);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as implemented interface.", _function_1);
    final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it_1) -> {
      it_1.setReturnType(type);
      final Procedure0 _function_3 = () -> {
        it_1.addParameter("bar", type);
      };
      MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_3);
      final Procedure0 _function_4 = () -> {
        it_1.setExceptions(type);
      };
      MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as exception type.", _function_4);
      final Procedure0 _function_5 = () -> {
        it_1.addTypeParameter("T", type);
      };
      MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_5);
      MutableTypeParameterDeclaration _addTypeParameter = it_1.addTypeParameter("T");
      final Procedure1<MutableTypeParameterDeclaration> _function_6 = (MutableTypeParameterDeclaration it_2) -> {
        final Procedure0 _function_7 = () -> {
          Iterable<? extends TypeReference> _upperBounds = it_2.getUpperBounds();
          Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_upperBounds, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(type)));
          it_2.setUpperBounds(_plus);
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_7);
      };
      ObjectExtensions.<MutableTypeParameterDeclaration>operator_doubleArrow(_addTypeParameter, _function_6);
    };
    it.addMethod("bar", _function_2);
    final Procedure1<MutableFieldDeclaration> _function_3 = (MutableFieldDeclaration field) -> {
      field.setType(type);
    };
    it.addField("bar2", _function_3);
    MutableInterfaceDeclaration _findInterface = context.findInterface("Bar");
    final Procedure1<MutableInterfaceDeclaration> _function_4 = (MutableInterfaceDeclaration it_1) -> {
      final Procedure0 _function_5 = () -> {
        Iterable<? extends TypeReference> _extendedInterfaces = it_1.getExtendedInterfaces();
        Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_extendedInterfaces, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(type)));
        it_1.setExtendedInterfaces(_plus);
      };
      MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as extended interface.", _function_5);
      final Procedure0 _function_6 = () -> {
        it_1.addTypeParameter("T", type);
      };
      MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_6);
      MutableTypeParameterDeclaration _addTypeParameter = it_1.addTypeParameter("T");
      final Procedure1<MutableTypeParameterDeclaration> _function_7 = (MutableTypeParameterDeclaration it_2) -> {
        final Procedure0 _function_8 = () -> {
          Iterable<? extends TypeReference> _upperBounds = it_2.getUpperBounds();
          Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_upperBounds, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(type)));
          it_2.setUpperBounds(_plus);
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_8);
      };
      ObjectExtensions.<MutableTypeParameterDeclaration>operator_doubleArrow(_addTypeParameter, _function_7);
    };
    ObjectExtensions.<MutableInterfaceDeclaration>operator_doubleArrow(_findInterface, _function_4);
    final Procedure0 _function_5 = () -> {
      it.addTypeParameter("T", type);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_5);
    MutableTypeParameterDeclaration _addTypeParameter = it.addTypeParameter("T");
    final Procedure1<MutableTypeParameterDeclaration> _function_6 = (MutableTypeParameterDeclaration it_1) -> {
      final Procedure0 _function_7 = () -> {
        Iterable<? extends TypeReference> _upperBounds = it_1.getUpperBounds();
        Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_upperBounds, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(type)));
        it_1.setUpperBounds(_plus);
      };
      MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_7);
    };
    ObjectExtensions.<MutableTypeParameterDeclaration>operator_doubleArrow(_addTypeParameter, _function_6);
  }
}

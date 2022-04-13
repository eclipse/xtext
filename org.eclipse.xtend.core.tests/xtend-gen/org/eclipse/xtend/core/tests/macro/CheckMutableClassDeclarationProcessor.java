/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.Collections;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CheckMutableClassDeclarationProcessor extends AbstractClassProcessor {
  @Override
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, @Extension final RegisterGlobalsContext context) {
    final Procedure1<String> _function = (String qualifiedName) -> {
      context.registerClass(qualifiedName);
    };
    MutableAssert.assertValidQualifiedName("qualifiedName", "foo.Bar", _function);
    final Procedure0 _function_1 = () -> {
      context.registerClass("foo.Bar");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The type \'foo.Bar\' has already been registered.", _function_1);
    final Procedure1<String> _function_2 = (String qualifiedName) -> {
      context.registerAnnotationType(qualifiedName);
    };
    MutableAssert.assertValidQualifiedName("qualifiedName", "foo.Bar2", _function_2);
    final Procedure0 _function_3 = () -> {
      context.registerAnnotationType("foo.Bar2");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The type \'foo.Bar2\' has already been registered.", _function_3);
    final Procedure1<String> _function_4 = (String qualifiedName) -> {
      context.registerEnumerationType(qualifiedName);
    };
    MutableAssert.assertValidQualifiedName("qualifiedName", "foo.Bar3", _function_4);
    final Procedure0 _function_5 = () -> {
      context.registerEnumerationType("foo.Bar3");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The type \'foo.Bar3\' has already been registered.", _function_5);
    final Procedure1<String> _function_6 = (String qualifiedName) -> {
      context.registerInterface(qualifiedName);
    };
    MutableAssert.assertValidQualifiedName("qualifiedName", "foo.Bar4", _function_6);
    final Procedure0 _function_7 = () -> {
      context.registerInterface("foo.Bar4");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The type \'foo.Bar4\' has already been registered.", _function_7);
  }

  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    final Procedure0 _function = () -> {
      annotatedClass.setImplementedInterfaces(null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "superIntefaces cannot be null", _function);
    final Procedure0 _function_1 = () -> {
      annotatedClass.setImplementedInterfaces(Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList((TypeReference)null)));
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "superIntefaces cannot contain null", _function_1);
    annotatedClass.setImplementedInterfaces(CollectionLiterals.<TypeReference>emptyList());
    final Procedure1<String> _function_2 = (String identifier) -> {
      annotatedClass.addTypeParameter(identifier).remove();
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_2);
    final Procedure0 _function_3 = () -> {
      annotatedClass.addTypeParameter("T", ((TypeReference[]) null));
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot be null", _function_3);
    final Procedure0 _function_4 = () -> {
      annotatedClass.addTypeParameter("T", new TypeReference[] { null });
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot contain null", _function_4);
    final MutableTypeParameterDeclaration typeParameter = annotatedClass.addTypeParameter("T");
    final Procedure1<String> _function_5 = (String identifier) -> {
      typeParameter.setSimpleName(identifier);
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_5);
    final Procedure0 _function_6 = () -> {
      typeParameter.setUpperBounds(null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot be null", _function_6);
    final Procedure0 _function_7 = () -> {
      typeParameter.setUpperBounds(Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList((TypeReference)null)));
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot contain null", _function_7);
    typeParameter.setUpperBounds(CollectionLiterals.<TypeReference>emptyList());
    final Procedure0 _function_8 = () -> {
      annotatedClass.setSimpleName(null);
    };
    MutableAssert.<UnsupportedOperationException>assertThrowable(UnsupportedOperationException.class, "The type cannot be renamed.", _function_8);
    final Procedure1<String> _function_9 = (String identifier) -> {
      final Procedure1<MutableFieldDeclaration> _function_10 = (MutableFieldDeclaration it) -> {
        it.setType(context.newTypeReference(String.class));
      };
      annotatedClass.addField(identifier, _function_10).remove();
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_9);
    final Procedure0 _function_10 = () -> {
      annotatedClass.addField("foo", null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "initializer cannot be null", _function_10);
    final Procedure1<String> _function_11 = (String identifier) -> {
      final Procedure1<MutableMethodDeclaration> _function_12 = (MutableMethodDeclaration it) -> {
      };
      annotatedClass.addMethod(identifier, _function_12).remove();
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_11);
    final Procedure0 _function_12 = () -> {
      annotatedClass.addMethod("foo", null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "initializer cannot be null", _function_12);
    final Procedure0 _function_13 = () -> {
      annotatedClass.addConstructor(null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "initializer cannot be null", _function_13);
    final Procedure1<MutableMethodDeclaration> _function_14 = (MutableMethodDeclaration it) -> {
    };
    final MutableMethodDeclaration method = annotatedClass.addMethod("foo", _function_14);
    annotatedClass.findDeclaredMethod(null);
    annotatedClass.findDeclaredMethod("foo");
    final Procedure0 _function_15 = () -> {
      annotatedClass.findDeclaredMethod("foo", ((TypeReference[]) null));
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "parameterTypes cannot be null", _function_15);
    final Procedure0 _function_16 = () -> {
      annotatedClass.findDeclaredMethod("foo", new TypeReference[] { null });
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "parameterTypes cannot contain null", _function_16);
    annotatedClass.findDeclaredMethod("foo", ((TypeReference[])Conversions.unwrapArray(CollectionLiterals.<TypeReference>emptyList(), TypeReference.class)));
    method.remove();
    final Procedure0 _function_17 = () -> {
      annotatedClass.findDeclaredConstructor(((TypeReference[]) null));
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "parameterTypes cannot be null", _function_17);
    final Procedure0 _function_18 = () -> {
      annotatedClass.findDeclaredConstructor(new TypeReference[] { null });
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "parameterTypes cannot contain null", _function_18);
    annotatedClass.findDeclaredConstructor(((TypeReference[])Conversions.unwrapArray(CollectionLiterals.<TypeReference>emptyList(), TypeReference.class)));
  }
}

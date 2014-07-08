/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.core.tests.macro.MutableAssert;
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
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, @Extension final RegisterGlobalsContext context) {
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String qualifiedName) {
        context.registerClass(qualifiedName);
      }
    };
    MutableAssert.assertValidQualifiedName("qualifiedName", "foo.Bar", _function);
    final Procedure0 _function_1 = new Procedure0() {
      public void apply() {
        context.registerClass("foo.Bar");
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The type \'foo.Bar\' has already been registered.", _function_1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      public void apply(final String qualifiedName) {
        context.registerAnnotationType(qualifiedName);
      }
    };
    MutableAssert.assertValidQualifiedName("qualifiedName", "foo.Bar2", _function_2);
    final Procedure0 _function_3 = new Procedure0() {
      public void apply() {
        context.registerAnnotationType("foo.Bar2");
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The type \'foo.Bar2\' has already been registered.", _function_3);
    final Procedure1<String> _function_4 = new Procedure1<String>() {
      public void apply(final String qualifiedName) {
        context.registerEnumerationType(qualifiedName);
      }
    };
    MutableAssert.assertValidQualifiedName("qualifiedName", "foo.Bar3", _function_4);
    final Procedure0 _function_5 = new Procedure0() {
      public void apply() {
        context.registerEnumerationType("foo.Bar3");
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The type \'foo.Bar3\' has already been registered.", _function_5);
    final Procedure1<String> _function_6 = new Procedure1<String>() {
      public void apply(final String qualifiedName) {
        context.registerInterface(qualifiedName);
      }
    };
    MutableAssert.assertValidQualifiedName("qualifiedName", "foo.Bar4", _function_6);
    final Procedure0 _function_7 = new Procedure0() {
      public void apply() {
        context.registerInterface("foo.Bar4");
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The type \'foo.Bar4\' has already been registered.", _function_7);
  }
  
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        annotatedClass.setImplementedInterfaces(null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "superIntefaces cannot be null", _function);
    final Procedure0 _function_1 = new Procedure0() {
      public void apply() {
        annotatedClass.setImplementedInterfaces(Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList((TypeReference)null)));
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "superIntefaces cannot contain null", _function_1);
    List<TypeReference> _emptyList = CollectionLiterals.<TypeReference>emptyList();
    annotatedClass.setImplementedInterfaces(_emptyList);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      public void apply(final String identifier) {
        MutableTypeParameterDeclaration _addTypeParameter = annotatedClass.addTypeParameter(identifier);
        _addTypeParameter.remove();
      }
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_2);
    final Procedure0 _function_3 = new Procedure0() {
      public void apply() {
        annotatedClass.addTypeParameter("T", ((TypeReference[]) null));
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot be null", _function_3);
    final Procedure0 _function_4 = new Procedure0() {
      public void apply() {
        annotatedClass.addTypeParameter("T", new TypeReference[] { null });
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot contain null", _function_4);
    final MutableTypeParameterDeclaration typeParameter = annotatedClass.addTypeParameter("T");
    final Procedure1<String> _function_5 = new Procedure1<String>() {
      public void apply(final String identifier) {
        typeParameter.setSimpleName(identifier);
      }
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_5);
    final Procedure0 _function_6 = new Procedure0() {
      public void apply() {
        typeParameter.setUpperBounds(null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot be null", _function_6);
    final Procedure0 _function_7 = new Procedure0() {
      public void apply() {
        typeParameter.setUpperBounds(Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList((TypeReference)null)));
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot contain null", _function_7);
    List<TypeReference> _emptyList_1 = CollectionLiterals.<TypeReference>emptyList();
    typeParameter.setUpperBounds(_emptyList_1);
    final Procedure0 _function_8 = new Procedure0() {
      public void apply() {
        annotatedClass.setSimpleName(null);
      }
    };
    MutableAssert.<UnsupportedOperationException>assertThrowable(UnsupportedOperationException.class, "The type cannot be renamed.", _function_8);
    final Procedure1<String> _function_9 = new Procedure1<String>() {
      public void apply(final String identifier) {
        final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
          public void apply(final MutableFieldDeclaration it) {
            TypeReference _newTypeReference = context.newTypeReference(String.class);
            it.setType(_newTypeReference);
          }
        };
        MutableFieldDeclaration _addField = annotatedClass.addField(identifier, _function);
        _addField.remove();
      }
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_9);
    final Procedure0 _function_10 = new Procedure0() {
      public void apply() {
        annotatedClass.addField("foo", null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "initializer cannot be null", _function_10);
    final Procedure1<String> _function_11 = new Procedure1<String>() {
      public void apply(final String identifier) {
        final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
          public void apply(final MutableMethodDeclaration it) {
          }
        };
        MutableMethodDeclaration _addMethod = annotatedClass.addMethod(identifier, _function);
        _addMethod.remove();
      }
    };
    MutableAssert.assertValidJavaIdentifier("name", _function_11);
    final Procedure0 _function_12 = new Procedure0() {
      public void apply() {
        annotatedClass.addMethod("foo", null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "initializer cannot be null", _function_12);
    final Procedure0 _function_13 = new Procedure0() {
      public void apply() {
        annotatedClass.addConstructor(null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "initializer cannot be null", _function_13);
    final Procedure1<MutableMethodDeclaration> _function_14 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
      }
    };
    final MutableMethodDeclaration method = annotatedClass.addMethod("foo", _function_14);
    annotatedClass.findDeclaredMethod(null);
    annotatedClass.findDeclaredMethod("foo");
    final Procedure0 _function_15 = new Procedure0() {
      public void apply() {
        annotatedClass.findDeclaredMethod("foo", ((TypeReference[]) null));
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "parameterTypes cannot be null", _function_15);
    final Procedure0 _function_16 = new Procedure0() {
      public void apply() {
        annotatedClass.findDeclaredMethod("foo", new TypeReference[] { null });
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "parameterTypes cannot contain null", _function_16);
    List<TypeReference> _emptyList_2 = CollectionLiterals.<TypeReference>emptyList();
    annotatedClass.findDeclaredMethod("foo", ((TypeReference[])Conversions.unwrapArray(_emptyList_2, TypeReference.class)));
    method.remove();
    final Procedure0 _function_17 = new Procedure0() {
      public void apply() {
        annotatedClass.findDeclaredConstructor(((TypeReference[]) null));
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "parameterTypes cannot be null", _function_17);
    final Procedure0 _function_18 = new Procedure0() {
      public void apply() {
        annotatedClass.findDeclaredConstructor(new TypeReference[] { null });
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "parameterTypes cannot contain null", _function_18);
    List<TypeReference> _emptyList_3 = CollectionLiterals.<TypeReference>emptyList();
    annotatedClass.findDeclaredConstructor(((TypeReference[])Conversions.unwrapArray(_emptyList_3, TypeReference.class)));
  }
}

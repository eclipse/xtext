/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collections;
import org.eclipse.xtend.core.tests.macro.MutableAssert;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

@SuppressWarnings("all")
public class InferredTypeReferencesCheckProcessor extends AbstractClassProcessor {
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    MutableFieldDeclaration _findDeclaredField = it.findDeclaredField("foo");
    final TypeReference type = _findDeclaredField.getType();
    boolean _isInferred = type.isInferred();
    Assert.assertTrue(_isInferred);
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        it.setExtendedClass(type);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as extended class.", _function);
    final Procedure0 _function_1 = new Procedure0() {
      public void apply() {
        Iterable<? extends TypeReference> _implementedInterfaces = it.getImplementedInterfaces();
        Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_implementedInterfaces, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(type)));
        it.setImplementedInterfaces(_plus);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as implemented interface.", _function_1);
    final Procedure1<MutableMethodDeclaration> _function_2 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        it.setReturnType(type);
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            it.addParameter("bar", type);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function);
        final Procedure0 _function_1 = new Procedure0() {
          public void apply() {
            it.setExceptions(type);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as exception type.", _function_1);
        final Procedure0 _function_2 = new Procedure0() {
          public void apply() {
            it.addTypeParameter("T", type);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_2);
        MutableTypeParameterDeclaration _addTypeParameter = it.addTypeParameter("T");
        final Procedure1<MutableTypeParameterDeclaration> _function_3 = new Procedure1<MutableTypeParameterDeclaration>() {
          public void apply(final MutableTypeParameterDeclaration it) {
            final Procedure0 _function = new Procedure0() {
              public void apply() {
                Iterable<? extends TypeReference> _upperBounds = it.getUpperBounds();
                Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_upperBounds, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(type)));
                it.setUpperBounds(_plus);
              }
            };
            MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function);
          }
        };
        ObjectExtensions.<MutableTypeParameterDeclaration>operator_doubleArrow(_addTypeParameter, _function_3);
      }
    };
    it.addMethod("bar", _function_2);
    final Procedure1<MutableFieldDeclaration> _function_3 = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration field) {
        field.setType(type);
      }
    };
    it.addField("bar2", _function_3);
    MutableInterfaceDeclaration _findInterface = context.findInterface("Bar");
    final Procedure1<MutableInterfaceDeclaration> _function_4 = new Procedure1<MutableInterfaceDeclaration>() {
      public void apply(final MutableInterfaceDeclaration it) {
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            Iterable<? extends TypeReference> _extendedInterfaces = it.getExtendedInterfaces();
            Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_extendedInterfaces, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(type)));
            it.setExtendedInterfaces(_plus);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as extended interface.", _function);
        final Procedure0 _function_1 = new Procedure0() {
          public void apply() {
            it.addTypeParameter("T", type);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_1);
        MutableTypeParameterDeclaration _addTypeParameter = it.addTypeParameter("T");
        final Procedure1<MutableTypeParameterDeclaration> _function_2 = new Procedure1<MutableTypeParameterDeclaration>() {
          public void apply(final MutableTypeParameterDeclaration it) {
            final Procedure0 _function = new Procedure0() {
              public void apply() {
                Iterable<? extends TypeReference> _upperBounds = it.getUpperBounds();
                Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_upperBounds, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(type)));
                it.setUpperBounds(_plus);
              }
            };
            MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function);
          }
        };
        ObjectExtensions.<MutableTypeParameterDeclaration>operator_doubleArrow(_addTypeParameter, _function_2);
      }
    };
    ObjectExtensions.<MutableInterfaceDeclaration>operator_doubleArrow(_findInterface, _function_4);
    final Procedure0 _function_5 = new Procedure0() {
      public void apply() {
        it.addTypeParameter("T", type);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function_5);
    MutableTypeParameterDeclaration _addTypeParameter = it.addTypeParameter("T");
    final Procedure1<MutableTypeParameterDeclaration> _function_6 = new Procedure1<MutableTypeParameterDeclaration>() {
      public void apply(final MutableTypeParameterDeclaration it) {
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            Iterable<? extends TypeReference> _upperBounds = it.getUpperBounds();
            Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_upperBounds, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(type)));
            it.setUpperBounds(_plus);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot use inferred type as parameter type.", _function);
      }
    };
    ObjectExtensions.<MutableTypeParameterDeclaration>operator_doubleArrow(_addTypeParameter, _function_6);
  }
}

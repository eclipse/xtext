/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.core.tests.macro.MutableAssert;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CheckMutableInterfaceDeclarationProcessor implements RegisterGlobalsParticipant<InterfaceDeclaration>, TransformationParticipant<MutableInterfaceDeclaration>, CodeGenerationParticipant<MutableInterfaceDeclaration> {
  public void doRegisterGlobals(final List<? extends InterfaceDeclaration> annotatedSourceElements, final RegisterGlobalsContext context) {
  }
  
  public void doTransform(final List<? extends MutableInterfaceDeclaration> annotatedTargetElements, @Extension final TransformationContext context) {
    for (final MutableInterfaceDeclaration annotatedTargetElement : annotatedTargetElements) {
      {
        final Procedure1<String> _function = new Procedure1<String>() {
          public void apply(final String identifier) {
            MutableTypeParameterDeclaration _addTypeParameter = annotatedTargetElement.addTypeParameter(identifier);
            _addTypeParameter.remove();
          }
        };
        MutableAssert.assertValidJavaIdentifier("name", _function);
        final Procedure0 _function_1 = new Procedure0() {
          public void apply() {
            annotatedTargetElement.addTypeParameter("T", ((TypeReference[]) null));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot be null", _function_1);
        final Procedure0 _function_2 = new Procedure0() {
          public void apply() {
            annotatedTargetElement.addTypeParameter("T", new TypeReference[] { null });
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "upperBounds cannot contain null", _function_2);
        List<TypeReference> _emptyList = CollectionLiterals.<TypeReference>emptyList();
        MutableTypeParameterDeclaration _addTypeParameter = annotatedTargetElement.addTypeParameter("T", ((TypeReference[])Conversions.unwrapArray(_emptyList, TypeReference.class)));
        _addTypeParameter.remove();
        final Procedure0 _function_3 = new Procedure0() {
          public void apply() {
            annotatedTargetElement.setExtendedInterfaces(null);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "superinterfaces cannot be null", _function_3);
        final Procedure0 _function_4 = new Procedure0() {
          public void apply() {
            annotatedTargetElement.setExtendedInterfaces(Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList((TypeReference)null)));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "superinterfaces cannot contain null", _function_4);
        List<TypeReference> _emptyList_1 = CollectionLiterals.<TypeReference>emptyList();
        annotatedTargetElement.setExtendedInterfaces(_emptyList_1);
        TypeReference _newTypeReference = context.newTypeReference(Deprecated.class);
        Type _type = _newTypeReference.getType();
        final MutableAnnotationReference annotationReference = annotatedTargetElement.addAnnotation(_type);
        final Procedure0 _function_5 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, null);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "name has to be a valid java identifier", _function_5);
        final Procedure0 _function_6 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, "foo");
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "name has to be a valid java identifier", _function_6);
        final Procedure0 _function_7 = new Procedure0() {
          public void apply() {
            String[] _xblockexpression = null;
            {
              final String[] array = { "foo" };
              _xblockexpression = array;
            }
            annotationReference.set(null, _xblockexpression);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "name has to be a valid java identifier", _function_7);
        final Procedure0 _function_8 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, Boolean.valueOf(true));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "name has to be a valid java identifier", _function_8);
        final Procedure0 _function_9 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, ((boolean[]) ((boolean[])Conversions.unwrapArray(Collections.<Boolean>unmodifiableList(Lists.<Boolean>newArrayList(true)), boolean.class))));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "name has to be a valid java identifier", _function_9);
        final Procedure0 _function_10 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, Integer.valueOf(0));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "name has to be a valid java identifier", _function_10);
        final Procedure0 _function_11 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, ((int[]) ((int[])Conversions.unwrapArray(Collections.<Integer>unmodifiableList(Lists.<Integer>newArrayList(0)), int.class))));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "name has to be a valid java identifier", _function_11);
        final Procedure0 _function_12 = new Procedure0() {
          public void apply() {
            String[] _xblockexpression = null;
            {
              final String[] array = { "foo" };
              _xblockexpression = array;
            }
            annotationReference.set("doesNotExist", _xblockexpression);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "The annotation property \'doesNotExist\' is not declared on the annotation type \'java.lang.Deprecated\'.", _function_12);
        annotationReference.remove();
        TypeReference _newTypeReference_1 = context.newTypeReference(SuppressWarnings.class);
        Type _type_1 = _newTypeReference_1.getType();
        final MutableAnnotationReference otherAnnotationReference = annotatedTargetElement.addAnnotation(_type_1);
        String[] _xblockexpression = null;
        {
          final String[] array = { "foo" };
          _xblockexpression = array;
        }
        otherAnnotationReference.set("value", _xblockexpression);
        final Procedure0 _function_13 = new Procedure0() {
          public void apply() {
            int[] _xblockexpression = null;
            {
              final int[] array = { 1 };
              _xblockexpression = array;
            }
            otherAnnotationReference.set("value", _xblockexpression);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "int[] is not applicable at this location. Expected java.lang.String[]", _function_13);
        otherAnnotationReference.remove();
        TypeReference _newTypeReference_2 = context.newTypeReference(ComposedChecks.class);
        Type _type_2 = _newTypeReference_2.getType();
        final MutableAnnotationReference composedChecksReference = annotatedTargetElement.addAnnotation(_type_2);
        TypeReference[] _newArrayOfSize = new TypeReference[0];
        composedChecksReference.set("validators", _newArrayOfSize);
        TypeReference _newTypeReference_3 = context.newTypeReference(String.class);
        composedChecksReference.set("validators", _newTypeReference_3);
        final Procedure0 _function_14 = new Procedure0() {
          public void apply() {
            String[] _newArrayOfSize = new String[0];
            composedChecksReference.set("validators", _newArrayOfSize);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "java.lang.String[] is not applicable at this location. Expected org.eclipse.xtend.lib.macro.declaration.TypeReference[]", _function_14);
        final Procedure0 _function_15 = new Procedure0() {
          public void apply() {
            Object[] _newArrayOfSize = new Object[0];
            composedChecksReference.set("validators", _newArrayOfSize);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "Cannot set annotation values of type java.lang.Object[]", _function_15);
        composedChecksReference.remove();
      }
    }
  }
  
  public void doGenerateCode(final List<? extends MutableInterfaceDeclaration> annotatedSourceElements, @Extension final CodeGenerationContext context) {
  }
}

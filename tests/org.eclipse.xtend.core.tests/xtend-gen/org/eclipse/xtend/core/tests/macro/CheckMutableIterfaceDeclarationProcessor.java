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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CheckMutableIterfaceDeclarationProcessor implements RegisterGlobalsParticipant<InterfaceDeclaration>, TransformationParticipant<MutableInterfaceDeclaration>, CodeGenerationParticipant<MutableInterfaceDeclaration> {
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
            annotationReference.set(null, ((String[]) null));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "values cannot be null", _function_5);
        final Procedure0 _function_6 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, ((String) null));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "values cannot contain null", _function_6);
        final Procedure0 _function_7 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, ((String[]) ((String[])Conversions.unwrapArray(Collections.<Object>unmodifiableList(Lists.<Object>newArrayList((Object)null)), String.class))));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "values cannot contain null", _function_7);
        final Procedure0 _function_8 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, ((boolean[]) null));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "values cannot be null", _function_8);
        final Procedure0 _function_9 = new Procedure0() {
          public void apply() {
            annotationReference.set(null, ((int[]) null));
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "values cannot be null", _function_9);
        annotationReference.set(null, "foo");
        String[] _xblockexpression = null;
        {
          final String[] array = { "foo" };
          _xblockexpression = (array);
        }
        annotationReference.set(null, _xblockexpression);
        annotationReference.set(null, true);
        annotationReference.set(null, ((boolean[]) ((boolean[])Conversions.unwrapArray(Collections.<Boolean>unmodifiableList(Lists.<Boolean>newArrayList(true)), boolean.class))));
        annotationReference.set(null, 0);
        annotationReference.set(null, ((int[]) ((int[])Conversions.unwrapArray(Collections.<Integer>unmodifiableList(Lists.<Integer>newArrayList(0)), int.class))));
        annotationReference.remove();
      }
    }
  }
  
  public void doGenerateCode(final List<? extends MutableInterfaceDeclaration> annotatedSourceElements, @Extension final CodeGenerationContext context) {
  }
}

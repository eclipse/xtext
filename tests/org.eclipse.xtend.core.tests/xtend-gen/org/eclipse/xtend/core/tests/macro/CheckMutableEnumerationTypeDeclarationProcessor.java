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
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CheckMutableEnumerationTypeDeclarationProcessor implements RegisterGlobalsParticipant<EnumerationTypeDeclaration>, TransformationParticipant<MutableEnumerationTypeDeclaration>, CodeGenerationParticipant<EnumerationTypeDeclaration> {
  @Override
  public void doRegisterGlobals(final List<? extends EnumerationTypeDeclaration> annotatedSourceElements, final RegisterGlobalsContext context) {
  }
  
  @Override
  public void doTransform(final List<? extends MutableEnumerationTypeDeclaration> annotatedTargetElements, @Extension final TransformationContext context) {
    for (final MutableEnumerationTypeDeclaration enumeration : annotatedTargetElements) {
      {
        final Procedure1<String> _function = new Procedure1<String>() {
          @Override
          public void apply(final String identifier) {
            final Procedure1<MutableEnumerationValueDeclaration> _function = new Procedure1<MutableEnumerationValueDeclaration>() {
              @Override
              public void apply(final MutableEnumerationValueDeclaration it) {
              }
            };
            MutableEnumerationValueDeclaration _addValue = enumeration.addValue(identifier, _function);
            _addValue.remove();
          }
        };
        MutableAssert.assertValidJavaIdentifier("name", _function);
        final Procedure0 _function_1 = new Procedure0() {
          @Override
          public void apply() {
            enumeration.addValue("foo", null);
          }
        };
        MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "initializer cannot be null", _function_1);
        final Procedure0 _function_2 = new Procedure0() {
          @Override
          public void apply() {
            final Procedure1<MutableEnumerationValueDeclaration> _function = new Procedure1<MutableEnumerationValueDeclaration>() {
              @Override
              public void apply(final MutableEnumerationValueDeclaration it) {
              }
            };
            MutableEnumerationValueDeclaration _addValue = enumeration.addValue("A", _function);
            _addValue.setVisibility(Visibility.PRIVATE);
          }
        };
        MutableAssert.<UnsupportedOperationException>assertThrowable(UnsupportedOperationException.class, "It is not possible to change visibility of enumeration value.", _function_2);
      }
    }
  }
  
  @Override
  public void doGenerateCode(final List<? extends EnumerationTypeDeclaration> annotatedSourceElements, @Extension final CodeGenerationContext context) {
  }
}

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
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CheckMutableParameterDeclarationProcessor implements RegisterGlobalsParticipant<ParameterDeclaration>, TransformationParticipant<MutableParameterDeclaration>, CodeGenerationParticipant<MutableParameterDeclaration> {
  @Override
  public void doRegisterGlobals(final List<? extends ParameterDeclaration> annotatedSourceElements, final RegisterGlobalsContext context) {
  }
  
  @Override
  public void doTransform(final List<? extends MutableParameterDeclaration> annotatedTargetElements, @Extension final TransformationContext context) {
    for (final MutableParameterDeclaration annotatedTargetElement : annotatedTargetElements) {
      final Procedure1<String> _function = new Procedure1<String>() {
        @Override
        public void apply(final String identifier) {
          annotatedTargetElement.setSimpleName(identifier);
        }
      };
      MutableAssert.assertValidJavaIdentifier("name", _function);
    }
  }
  
  @Override
  public void doGenerateCode(final List<? extends MutableParameterDeclaration> annotatedSourceElements, @Extension final CodeGenerationContext context) {
  }
}

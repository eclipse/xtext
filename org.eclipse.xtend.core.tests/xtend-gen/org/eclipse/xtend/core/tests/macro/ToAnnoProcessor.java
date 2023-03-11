/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ToAnnoProcessor extends AbstractClassProcessor {
  @Override
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, @Extension final RegisterGlobalsContext context) {
    super.doRegisterGlobals(annotatedClass, context);
    context.registerAnnotationType(this.generatedAnnotationName(annotatedClass));
  }

  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    super.doTransform(annotatedClass, context);
    Type _findTypeGlobally = context.findTypeGlobally(this.generatedAnnotationName(annotatedClass));
    final MutableAnnotationTypeDeclaration annotationType = ((MutableAnnotationTypeDeclaration) _findTypeGlobally);
    final Procedure1<MutableAnnotationTypeElementDeclaration> _function = (MutableAnnotationTypeElementDeclaration it) -> {
      it.setDocComment("Best building strategy game ever");
      it.setType(context.newTypeReference(Integer.TYPE));
      boolean _booleanValue = annotatedClass.findAnnotation(context.findTypeGlobally(ToAnno.class)).getBooleanValue("defaultValue");
      if (_booleanValue) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("1602");
          }
        };
        it.setDefaultValueExpression(_client);
      }
    };
    annotationType.addAnnotationTypeElement("anno", _function);
  }

  public String generatedAnnotationName(final ClassDeclaration decl) {
    String _qualifiedName = decl.getQualifiedName();
    return (_qualifiedName + "Anno");
  }
}

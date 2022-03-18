/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro.declaration;

import java.util.List;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;

@SuppressWarnings("all")
public class AddNestedTypesProcessor implements RegisterGlobalsParticipant<TypeDeclaration> {
  @Override
  public void doRegisterGlobals(final List<? extends TypeDeclaration> annotatedSourceElements, final RegisterGlobalsContext context) {
    for (final TypeDeclaration type : annotatedSourceElements) {
      {
        String _qualifiedName = type.getQualifiedName();
        String _plus = (_qualifiedName + ".NestedClass");
        context.registerClass(_plus);
        String _qualifiedName_1 = type.getQualifiedName();
        String _plus_1 = (_qualifiedName_1 + ".NestedInterface");
        context.registerInterface(_plus_1);
        String _qualifiedName_2 = type.getQualifiedName();
        String _plus_2 = (_qualifiedName_2 + ".NestedAnnotationType");
        context.registerAnnotationType(_plus_2);
        String _qualifiedName_3 = type.getQualifiedName();
        String _plus_3 = (_qualifiedName_3 + ".NestedEnumerationType");
        context.registerEnumerationType(_plus_3);
      }
    }
  }
}

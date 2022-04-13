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
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AddInterfaceWithDefaultProcessor extends AbstractClassProcessor {
  @Override
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, final RegisterGlobalsContext context) {
    context.registerInterface("de.test.Test");
  }

  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    super.doTransform(annotatedClass, context);
    Type _findTypeGlobally = context.findTypeGlobally("de.test.Test");
    final MutableInterfaceDeclaration ifType = ((MutableInterfaceDeclaration) _findTypeGlobally);
    final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("System.out.println(\"Hello World\");");
        }
      };
      it.setBody(_client);
      it.setDefault(true);
    };
    ifType.addMethod("sayHello", _function);
  }
}

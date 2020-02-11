/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.function.Consumer;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Bug446364Processor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    String _stringValue = IterableExtensions.head(annotatedClass.getAnnotations()).getStringValue("value");
    if (_stringValue != null) {
      switch (_stringValue) {
        case "rename":
          final Consumer<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
            String _simpleName = it.getSimpleName();
            String _plus = ("prefix_" + _simpleName);
            it.setSimpleName(_plus);
          };
          annotatedClass.getDeclaredMethods().forEach(_function);
          break;
        case "changeBody":
          final Consumer<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it) -> {
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("return null;");
              }
            };
            it.setBody(_client);
          };
          annotatedClass.getDeclaredMethods().forEach(_function_1);
          break;
      }
    }
  }
}

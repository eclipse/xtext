/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ArtificialMethodsProcessor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
      final CompilationStrategy _function_1 = (CompilationStrategy.CompilationContext it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        return _builder;
      };
      it.setBody(_function_1);
    };
    annotatedClass.addMethod("blank", _function);
    final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it) -> {
      final CompilationStrategy _function_2 = (CompilationStrategy.CompilationContext it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\t\t\t\t");
        _builder.newLine();
        return _builder;
      };
      it.setBody(_function_2);
    };
    annotatedClass.addMethod("blank_1", _function_1);
    final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it) -> {
      final CompilationStrategy _function_3 = (CompilationStrategy.CompilationContext it_1) -> {
        return "";
      };
      it.setBody(_function_3);
    };
    annotatedClass.addMethod("blank_2", _function_2);
    final Procedure1<MutableMethodDeclaration> _function_3 = (MutableMethodDeclaration it) -> {
      final CompilationStrategy _function_4 = (CompilationStrategy.CompilationContext it_1) -> {
        return "\n";
      };
      it.setBody(_function_4);
    };
    annotatedClass.addMethod("blank_3", _function_3);
    final Procedure1<MutableMethodDeclaration> _function_4 = (MutableMethodDeclaration it) -> {
      final CompilationStrategy _function_5 = (CompilationStrategy.CompilationContext it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("int foo = 42;");
        _builder.newLine();
        return _builder;
      };
      it.setBody(_function_5);
    };
    annotatedClass.addMethod("blank_4", _function_4);
    final Procedure1<MutableMethodDeclaration> _function_5 = (MutableMethodDeclaration it) -> {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("int foo = 42;");
          _builder.newLine();
        }
      };
      it.setBody(_client);
    };
    annotatedClass.addMethod("blank_5", _function_5);
    final Procedure1<MutableMethodDeclaration> _function_6 = (MutableMethodDeclaration it) -> {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("int foo = 42;");
        }
      };
      it.setBody(_client);
    };
    annotatedClass.addMethod("blank_6", _function_6);
    final Procedure1<MutableMethodDeclaration> _function_7 = (MutableMethodDeclaration it) -> {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append(List.class);
          _builder.append("<? extends Object> list = new ");
          _builder.append(ArrayList.class);
          _builder.append("<");
          _builder.append(BigDecimal.class);
          _builder.append(">();");
        }
      };
      it.setBody(_client);
    };
    annotatedClass.addMethod("blank_7", _function_7);
  }
}

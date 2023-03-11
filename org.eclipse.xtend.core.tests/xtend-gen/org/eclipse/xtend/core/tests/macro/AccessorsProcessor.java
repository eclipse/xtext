/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AccessorsProcessor implements TransformationParticipant<MutableFieldDeclaration> {
  @Override
  public void doTransform(final List<? extends MutableFieldDeclaration> javaFields, @Extension final TransformationContext context) {
    for (final MutableFieldDeclaration f : javaFields) {
      {
        String _firstUpper = StringExtensions.toFirstUpper(f.getSimpleName());
        final String getterName = ("get" + _firstUpper);
        String _firstUpper_1 = StringExtensions.toFirstUpper(f.getSimpleName());
        final String setterName = ("set" + _firstUpper_1);
        final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
          it.setReturnType(f.getType());
          final CompilationStrategy _function_1 = (CompilationStrategy.CompilationContext it_1) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("return ");
            String _simpleName = f.getSimpleName();
            _builder.append(_simpleName);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            return _builder;
          };
          it.setBody(_function_1);
        };
        this.tryAddMethod(f.getDeclaringType(), getterName, _function);
        boolean _isFinal = f.isFinal();
        boolean _not = (!_isFinal);
        if (_not) {
          final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it) -> {
            it.setReturnType(context.getPrimitiveVoid());
            it.addParameter(f.getSimpleName(), f.getType());
            final CompilationStrategy _function_2 = (CompilationStrategy.CompilationContext it_1) -> {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("this.");
              String _simpleName = f.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(" = ");
              String _simpleName_1 = f.getSimpleName();
              _builder.append(_simpleName_1);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              return _builder;
            };
            it.setBody(_function_2);
          };
          this.tryAddMethod(f.getDeclaringType(), setterName, _function_1);
        }
      }
    }
  }

  public MutableMethodDeclaration tryAddMethod(final MutableTypeDeclaration it, final String name, final Procedure1<? super MutableMethodDeclaration> initializer) {
    MutableMethodDeclaration _elvis = null;
    MutableMethodDeclaration _findDeclaredMethod = it.findDeclaredMethod(name);
    if (_findDeclaredMethod != null) {
      _elvis = _findDeclaredMethod;
    } else {
      MutableMethodDeclaration _addMethod = it.addMethod(name, ((Procedure1<MutableMethodDeclaration>)initializer));
      _elvis = _addMethod;
    }
    return _elvis;
  }
}

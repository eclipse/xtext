/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package lazy;

import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class LazyProcessor extends AbstractFieldProcessor {
  @Override
  public void doTransform(final MutableFieldDeclaration field, @Extension final TransformationContext context) {
    boolean _isPrimitive = field.getType().isPrimitive();
    if (_isPrimitive) {
      context.addError(field, "Fields with primitives are not supported by @Lazy");
    }
    Expression _initializer = field.getInitializer();
    boolean _tripleEquals = (_initializer == null);
    if (_tripleEquals) {
      context.addError(field, "A lazy field must have an initializer.");
    }
    MutableTypeDeclaration _declaringType = field.getDeclaringType();
    String _simpleName = field.getSimpleName();
    String _plus = ("_init" + _simpleName);
    final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
      it.setVisibility(Visibility.PRIVATE);
      it.setReturnType(field.getType());
      it.setBody(field.getInitializer());
      context.setPrimarySourceElement(it, field);
    };
    _declaringType.addMethod(_plus, _function);
    MutableTypeDeclaration _declaringType_1 = field.getDeclaringType();
    String _firstUpper = StringExtensions.toFirstUpper(field.getSimpleName());
    String _plus_1 = ("get" + _firstUpper);
    final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it) -> {
      field.markAsRead();
      it.setReturnType(field.getType());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("if (");
          String _simpleName = field.getSimpleName();
          _builder.append(_simpleName);
          _builder.append("==null)");
          _builder.newLineIfNotEmpty();
          _builder.append("  ");
          String _simpleName_1 = field.getSimpleName();
          _builder.append(_simpleName_1, "  ");
          _builder.append(" = _init");
          String _simpleName_2 = field.getSimpleName();
          _builder.append(_simpleName_2, "  ");
          _builder.append("();");
          _builder.newLineIfNotEmpty();
          _builder.append("return ");
          String _simpleName_3 = field.getSimpleName();
          _builder.append(_simpleName_3);
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      };
      it.setBody(_client);
      context.setPrimarySourceElement(it, field);
    };
    _declaringType_1.addMethod(_plus_1, _function_1);
  }
}

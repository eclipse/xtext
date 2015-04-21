/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package lazy;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
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
    TypeReference _type = field.getType();
    boolean _isPrimitive = _type.isPrimitive();
    if (_isPrimitive) {
      context.addError(field, "Fields with primitives are not supported by @Lazy");
    }
    Expression _initializer = field.getInitializer();
    boolean _equals = Objects.equal(_initializer, null);
    if (_equals) {
      context.addError(field, "A lazy field must have an initializer.");
    }
    MutableTypeDeclaration _declaringType = field.getDeclaringType();
    String _simpleName = field.getSimpleName();
    String _plus = ("_init" + _simpleName);
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      @Override
      public void apply(final MutableMethodDeclaration it) {
        it.setVisibility(Visibility.PRIVATE);
        TypeReference _type = field.getType();
        it.setReturnType(_type);
        Expression _initializer = field.getInitializer();
        it.setBody(_initializer);
        context.setPrimarySourceElement(it, field);
      }
    };
    _declaringType.addMethod(_plus, _function);
    MutableTypeDeclaration _declaringType_1 = field.getDeclaringType();
    String _simpleName_1 = field.getSimpleName();
    String _firstUpper = StringExtensions.toFirstUpper(_simpleName_1);
    String _plus_1 = ("get" + _firstUpper);
    final Procedure1<MutableMethodDeclaration> _function_1 = new Procedure1<MutableMethodDeclaration>() {
      @Override
      public void apply(final MutableMethodDeclaration it) {
        field.markAsRead();
        TypeReference _type = field.getType();
        it.setReturnType(_type);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("if (");
            String _simpleName = field.getSimpleName();
            _builder.append(_simpleName, "");
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
            _builder.append(_simpleName_3, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        };
        it.setBody(_client);
        context.setPrimarySourceElement(it, field);
      }
    };
    _declaringType_1.addMethod(_plus_1, _function_1);
  }
}

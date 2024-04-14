/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import java.util.Objects;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Beta
@SuppressWarnings("all")
public class ToStringProcessor extends AbstractClassProcessor {
  /**
   * @since 2.7
   * @noextend
   * @noreference
   */
  @Beta
  public static class Util {
    @Extension
    private TransformationContext context;

    public Util(final TransformationContext context) {
      this.context = context;
    }

    public boolean hasToString(final ClassDeclaration it) {
      MethodDeclaration _findDeclaredMethod = it.findDeclaredMethod("toString");
      return (_findDeclaredMethod != null);
    }

    public ToStringConfiguration getToStringConfig(final ClassDeclaration it) {
      ToStringConfiguration _xblockexpression = null;
      {
        final AnnotationReference anno = it.findAnnotation(this.context.findTypeGlobally(ToString.class));
        ToStringConfiguration _xifexpression = null;
        if ((anno == null)) {
          _xifexpression = null;
        } else {
          _xifexpression = new ToStringConfiguration(anno);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }

    public void addReflectiveToString(final MutableClassDeclaration cls, final ToStringConfiguration config) {
      final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
        this.context.setPrimarySourceElement(it, this.context.getPrimarySourceElement(cls));
        it.setReturnType(this.context.getString());
        it.addAnnotation(this.context.newAnnotationReference(Override.class));
        it.addAnnotation(this.context.newAnnotationReference(Pure.class));
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("return new ");
            _builder.append(ToStringBuilder.class);
            _builder.append("(this)");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(".addAllFields()");
            _builder.newLine();
            _builder.append("\t");
            {
              boolean _isSkipNulls = config.isSkipNulls();
              if (_isSkipNulls) {
                _builder.append(".skipNulls()");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              boolean _isSingleLine = config.isSingleLine();
              if (_isSingleLine) {
                _builder.append(".singleLine()");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              boolean _isHideFieldNames = config.isHideFieldNames();
              if (_isHideFieldNames) {
                _builder.append(".hideFieldNames()");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              boolean _isVerbatimValues = config.isVerbatimValues();
              if (_isVerbatimValues) {
                _builder.append(".verbatimValues()");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(".toString();");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      cls.addMethod("toString", _function);
    }

    public void addToString(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> fields, final ToStringConfiguration config) {
      final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
        this.context.setPrimarySourceElement(it, this.context.getPrimarySourceElement(cls));
        it.setReturnType(this.context.getString());
        it.addAnnotation(this.context.newAnnotationReference(Override.class));
        it.addAnnotation(this.context.newAnnotationReference(Pure.class));
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append(ToStringBuilder.class);
            _builder.append(" b = new ");
            _builder.append(ToStringBuilder.class);
            _builder.append("(this);");
            _builder.newLineIfNotEmpty();
            {
              boolean _isSkipNulls = config.isSkipNulls();
              if (_isSkipNulls) {
                _builder.append("b.skipNulls();");
              }
            }
            _builder.newLineIfNotEmpty();
            {
              boolean _isSingleLine = config.isSingleLine();
              if (_isSingleLine) {
                _builder.append("b.singleLine();");
              }
            }
            _builder.newLineIfNotEmpty();
            {
              boolean _isHideFieldNames = config.isHideFieldNames();
              if (_isHideFieldNames) {
                _builder.append("b.hideFieldNames();");
              }
            }
            _builder.newLineIfNotEmpty();
            {
              boolean _isVerbatimValues = config.isVerbatimValues();
              if (_isVerbatimValues) {
                _builder.append("b.verbatimValues();");
              }
            }
            _builder.newLineIfNotEmpty();
            {
              for(final FieldDeclaration field : fields) {
                _builder.append("b.add(\"");
                String _simpleName = field.getSimpleName();
                _builder.append(_simpleName);
                _builder.append("\", this.");
                String _simpleName_1 = field.getSimpleName();
                _builder.append(_simpleName_1);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("return b.toString();");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      cls.addMethod("toString", _function);
    }
  }

  @Override
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    AnnotationReference _findAnnotation = it.findAnnotation(context.findTypeGlobally(Data.class));
    boolean _tripleNotEquals = (_findAnnotation != null);
    if (_tripleNotEquals) {
      return;
    }
    @Extension
    final ToStringProcessor.Util util = new ToStringProcessor.Util(context);
    final AnnotationReference annotation = it.findAnnotation(context.findTypeGlobally(ToString.class));
    final ToStringConfiguration configuration = new ToStringConfiguration(annotation);
    boolean _hasToString = util.hasToString(it);
    if (_hasToString) {
      context.addWarning(annotation, "toString is already defined, this annotation has no effect.");
    } else {
      TypeReference _extendedClass = it.getExtendedClass();
      TypeReference _object = context.getObject();
      boolean _notEquals = (!Objects.equals(_extendedClass, _object));
      if (_notEquals) {
        util.addReflectiveToString(it, configuration);
      } else {
        final Function1<MutableFieldDeclaration, Boolean> _function = (MutableFieldDeclaration it_1) -> {
          return Boolean.valueOf(((context.isThePrimaryGeneratedJavaElement(it_1) && (!it_1.isStatic())) && (!it_1.isTransient())));
        };
        util.addToString(it, IterableExtensions.filter(it.getDeclaredFields(), _function), configuration);
      }
    }
  }
}

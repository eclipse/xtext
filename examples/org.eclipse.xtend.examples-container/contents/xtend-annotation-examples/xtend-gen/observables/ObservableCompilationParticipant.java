/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package observables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ObservableCompilationParticipant extends AbstractClassProcessor {
  public void doTransform(final MutableClassDeclaration clazz, @Extension final TransformationContext context) {
    Iterable<? extends MutableFieldDeclaration> _declaredFields = clazz.getDeclaredFields();
    for (final MutableFieldDeclaration f : _declaredFields) {
      {
        final String fieldName = f.getSimpleName();
        final TypeReference fieldType = f.getType();
        String _firstUpper = StringExtensions.toFirstUpper(fieldName);
        String _plus = ("get" + _firstUpper);
        final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
          public void apply(final MutableMethodDeclaration it) {
            it.setReturnType(fieldType);
            final CompilationStrategy _function = new CompilationStrategy() {
              public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("return this.");
                _builder.append(fieldName, "");
                _builder.append(";");
                return _builder;
              }
            };
            it.setBody(_function);
          }
        };
        clazz.addMethod(_plus, _function);
        String _firstUpper_1 = StringExtensions.toFirstUpper(fieldName);
        String _plus_1 = ("set" + _firstUpper_1);
        final Procedure1<MutableMethodDeclaration> _function_1 = new Procedure1<MutableMethodDeclaration>() {
          public void apply(final MutableMethodDeclaration it) {
            it.addParameter(fieldName, fieldType);
            final CompilationStrategy _function = new CompilationStrategy() {
              public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append(fieldType, "");
                _builder.append(" _oldValue = this.");
                _builder.append(fieldName, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("this.");
                _builder.append(fieldName, "");
                _builder.append(" = ");
                _builder.append(fieldName, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("_propertyChangeSupport.firePropertyChange(\"");
                _builder.append(fieldName, "");
                _builder.append("\", _oldValue, ");
                _builder.append(fieldName, "");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                return _builder;
              }
            };
            it.setBody(_function);
          }
        };
        clazz.addMethod(_plus_1, _function_1);
        f.markAsRead();
      }
    }
    final TypeReference changeSupportType = context.newTypeReference(PropertyChangeSupport.class);
    final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        it.setType(changeSupportType);
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationStrategy.CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("new ");
            String _javaCode = it.toJavaCode(changeSupportType);
            _builder.append(_javaCode, "");
            _builder.append("(this)");
            return _builder;
          }
        };
        it.setInitializer(_function);
      }
    };
    clazz.addField("_propertyChangeSupport", _function);
    final TypeReference propertyChangeListener = context.newTypeReference(PropertyChangeListener.class);
    final Procedure1<MutableMethodDeclaration> _function_1 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        it.addParameter("listener", propertyChangeListener);
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationStrategy.CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("this._propertyChangeSupport.addPropertyChangeListener(listener);");
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    clazz.addMethod("addPropertyChangeListener", _function_1);
    final Procedure1<MutableMethodDeclaration> _function_2 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        it.addParameter("listener", propertyChangeListener);
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationStrategy.CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("this._propertyChangeSupport.removePropertyChangeListener(listener);");
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    clazz.addMethod("removePropertyChangeListener", _function_2);
  }
}

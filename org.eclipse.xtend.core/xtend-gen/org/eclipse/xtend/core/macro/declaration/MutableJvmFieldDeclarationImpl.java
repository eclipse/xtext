/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Preconditions;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.util.Strings;

@SuppressWarnings("all")
public class MutableJvmFieldDeclarationImpl extends JvmFieldDeclarationImpl implements MutableFieldDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    this.getCompilationUnit().getReadAndWriteTracking().markReadAccess(this.getDelegate());
  }

  @Override
  public void markAsInitializedBy(final ConstructorDeclaration constructorDeclaration) {
    this.checkMutable();
    JvmConstructor _switchResult = null;
    boolean _matched = false;
    if (constructorDeclaration instanceof JvmConstructorDeclarationImpl) {
      _matched=true;
      _switchResult = ((JvmConstructorDeclarationImpl)constructorDeclaration).getDelegate();
    }
    if (!_matched) {
      if (constructorDeclaration instanceof XtendConstructorDeclarationImpl) {
        _matched=true;
        JvmConstructor _xblockexpression = null;
        {
          final EObject jvmElement = this.getCompilationUnit().getJvmModelAssociations().getPrimaryJvmElement(((XtendConstructorDeclarationImpl)constructorDeclaration).getDelegate());
          JvmConstructor _xifexpression = null;
          if ((jvmElement instanceof JvmConstructor)) {
            _xifexpression = ((JvmConstructor)jvmElement);
          }
          _xblockexpression = _xifexpression;
        }
        _switchResult = _xblockexpression;
      }
    }
    final JvmConstructor constructor = _switchResult;
    this.getCompilationUnit().getReadAndWriteTracking().markInitialized(this.getDelegate(), constructor);
  }

  @Override
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }

  @Override
  public void setInitializer(final Expression initializer) {
    this.checkMutable();
    if ((initializer == null)) {
      this.getCompilationUnit().getJvmTypesBuilder().removeExistingBody(this.getDelegate());
    } else {
      this.getCompilationUnit().getJvmTypesBuilder().setInitializer(this.getDelegate(), ((ExpressionImpl) initializer).getDelegate());
    }
  }

  @Override
  public void setInitializer(final CompilationStrategy initializer) {
    this.checkMutable();
    Preconditions.checkArgument((initializer != null), "initializer cannot be null");
    this.getCompilationUnit().setCompilationStrategy(this.getDelegate(), initializer);
  }

  @Override
  public void setInitializer(final StringConcatenationClient template) {
    this.checkMutable();
    Preconditions.checkArgument((template != null), "template cannot be null");
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), template);
  }

  @Override
  public void setFinal(final boolean isFinal) {
    this.checkMutable();
    this.getDelegate().setFinal(isFinal);
  }

  @Override
  public void setStatic(final boolean isStatic) {
    this.checkMutable();
    this.getDelegate().setStatic(isStatic);
  }

  @Override
  public void setTransient(final boolean isTransient) {
    this.checkMutable();
    this.getDelegate().setTransient(isTransient);
  }

  @Override
  public void setVolatile(final boolean isVolatile) {
    this.checkMutable();
    this.getDelegate().setVolatile(isVolatile);
  }

  @Override
  public void setType(final TypeReference type) {
    this.checkMutable();
    Preconditions.checkArgument((type != null), "type cannot be null");
    this.getDelegate().setType(this.getCompilationUnit().toJvmTypeReference(type));
  }

  @Override
  public void setConstantValueAsBoolean(final boolean value) {
    this.internalGenericSetConstantValue(Boolean.valueOf(value));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value);
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }

  private void internalGenericSetConstantValue(final Object value) {
    this.checkMutable();
    Preconditions.checkArgument((value != null), "value cannot be null");
    JvmField _delegate = this.getDelegate();
    _delegate.setConstant(true);
    JvmField _delegate_1 = this.getDelegate();
    _delegate_1.setFinal(true);
    JvmField _delegate_2 = this.getDelegate();
    _delegate_2.setStatic(true);
    JvmField _delegate_3 = this.getDelegate();
    _delegate_3.setConstantValue(value);
  }

  @Override
  public void setConstantValueAsByte(final byte value) {
    this.internalGenericSetConstantValue(Byte.valueOf(value));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value);
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }

  @Override
  public void setConstantValueAsInt(final int value) {
    this.internalGenericSetConstantValue(Integer.valueOf(value));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value);
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }

  @Override
  public void setConstantValueAsShort(final short value) {
    this.internalGenericSetConstantValue(Short.valueOf(value));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value);
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }

  @Override
  public void setConstantValueAsLong(final long value) {
    this.internalGenericSetConstantValue(Long.valueOf(value));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value);
        _builder.append("L");
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }

  @Override
  public void setConstantValueAsFloat(final float value) {
    this.internalGenericSetConstantValue(Float.valueOf(value));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value);
        _builder.append("f");
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }

  @Override
  public void setConstantValueAsDouble(final double value) {
    this.internalGenericSetConstantValue(Double.valueOf(value));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value);
        _builder.append("d");
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }

  @Override
  public void setConstantValueAsChar(final char value) {
    this.internalGenericSetConstantValue(Character.valueOf(value));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("\'");
        String _convertToJavaString = Strings.convertToJavaString(Character.toString(value));
        _builder.append(_convertToJavaString);
        _builder.append("\'");
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }

  @Override
  public void setConstantValueAsString(final String value) {
    this.internalGenericSetConstantValue(value);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("\"");
        String _convertToJavaString = Strings.convertToJavaString(value);
        _builder.append(_convertToJavaString);
        _builder.append("\"");
      }
    };
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), _client);
  }
}

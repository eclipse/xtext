/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.ExpressionImpl;
import org.eclipse.xtend.core.macro.declaration.JvmConstructorDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmFieldDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendConstructorDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendConstructor;
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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking;

@SuppressWarnings("all")
public class MutableJvmFieldDeclarationImpl extends JvmFieldDeclarationImpl implements MutableFieldDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    ReadAndWriteTracking _readAndWriteTracking = _compilationUnit.getReadAndWriteTracking();
    JvmField _delegate = this.getDelegate();
    _readAndWriteTracking.markReadAccess(_delegate);
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
          CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
          IXtendJvmAssociations _jvmModelAssociations = _compilationUnit.getJvmModelAssociations();
          XtendConstructor _delegate = ((XtendConstructorDeclarationImpl)constructorDeclaration).getDelegate();
          final EObject jvmElement = _jvmModelAssociations.getPrimaryJvmElement(_delegate);
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
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    ReadAndWriteTracking _readAndWriteTracking = _compilationUnit.getReadAndWriteTracking();
    JvmField _delegate = this.getDelegate();
    _readAndWriteTracking.markInitialized(_delegate, constructor);
  }
  
  @Override
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }
  
  @Override
  public void setInitializer(final Expression initializer) {
    this.checkMutable();
    boolean _equals = Objects.equal(initializer, null);
    if (_equals) {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      JvmTypesBuilder _jvmTypesBuilder = _compilationUnit.getJvmTypesBuilder();
      JvmField _delegate = this.getDelegate();
      _jvmTypesBuilder.removeExistingBody(_delegate);
    } else {
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      JvmTypesBuilder _jvmTypesBuilder_1 = _compilationUnit_1.getJvmTypesBuilder();
      JvmField _delegate_1 = this.getDelegate();
      XExpression _delegate_2 = ((ExpressionImpl) initializer).getDelegate();
      _jvmTypesBuilder_1.setInitializer(_delegate_1, _delegate_2);
    }
  }
  
  @Override
  public void setInitializer(final CompilationStrategy initializer) {
    this.checkMutable();
    boolean _notEquals = (!Objects.equal(initializer, null));
    Preconditions.checkArgument(_notEquals, "initializer cannot be null");
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    _compilationUnit.setCompilationStrategy(_delegate, initializer);
  }
  
  @Override
  public void setInitializer(final StringConcatenationClient template) {
    this.checkMutable();
    boolean _notEquals = (!Objects.equal(template, null));
    Preconditions.checkArgument(_notEquals, "template cannot be null");
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    _compilationUnit.setCompilationTemplate(_delegate, template);
  }
  
  @Override
  public void setFinal(final boolean isFinal) {
    this.checkMutable();
    JvmField _delegate = this.getDelegate();
    _delegate.setFinal(isFinal);
  }
  
  @Override
  public void setStatic(final boolean isStatic) {
    this.checkMutable();
    JvmField _delegate = this.getDelegate();
    _delegate.setStatic(isStatic);
  }
  
  @Override
  public void setTransient(final boolean isTransient) {
    this.checkMutable();
    JvmField _delegate = this.getDelegate();
    _delegate.setTransient(isTransient);
  }
  
  @Override
  public void setVolatile(final boolean isVolatile) {
    this.checkMutable();
    JvmField _delegate = this.getDelegate();
    _delegate.setVolatile(isVolatile);
  }
  
  @Override
  public void setType(final TypeReference type) {
    this.checkMutable();
    boolean _notEquals = (!Objects.equal(type, null));
    Preconditions.checkArgument(_notEquals, "type cannot be null");
    JvmField _delegate = this.getDelegate();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(type);
    _delegate.setType(_jvmTypeReference);
  }
  
  @Override
  public void setConstantValueAsBoolean(final boolean value) {
    this.internalGenericSetConstantValue(Boolean.valueOf(value));
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value, "");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
  
  private void internalGenericSetConstantValue(final Object value) {
    this.checkMutable();
    boolean _notEquals = (!Objects.equal(value, null));
    Preconditions.checkArgument(_notEquals, "value cannot be null");
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
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value, "");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
  
  @Override
  public void setConstantValueAsInt(final int value) {
    this.internalGenericSetConstantValue(Integer.valueOf(value));
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value, "");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
  
  @Override
  public void setConstantValueAsShort(final short value) {
    this.internalGenericSetConstantValue(Short.valueOf(value));
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value, "");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
  
  @Override
  public void setConstantValueAsLong(final long value) {
    this.internalGenericSetConstantValue(Long.valueOf(value));
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value, "");
        _builder.append("L");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
  
  @Override
  public void setConstantValueAsFloat(final float value) {
    this.internalGenericSetConstantValue(Float.valueOf(value));
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value, "");
        _builder.append("f");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
  
  @Override
  public void setConstantValueAsDouble(final double value) {
    this.internalGenericSetConstantValue(Double.valueOf(value));
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(value, "");
        _builder.append("d");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
  
  @Override
  public void setConstantValueAsChar(final char value) {
    this.internalGenericSetConstantValue(Character.valueOf(value));
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("\'");
        String _string = Character.toString(value);
        String _convertToJavaString = Strings.convertToJavaString(_string);
        _builder.append(_convertToJavaString, "");
        _builder.append("\'");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
  
  @Override
  public void setConstantValueAsString(final String value) {
    this.internalGenericSetConstantValue(value);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("\"");
        String _convertToJavaString = Strings.convertToJavaString(value);
        _builder.append(_convertToJavaString, "");
        _builder.append("\"");
      }
    };
    _compilationUnit.setCompilationTemplate(_delegate, _client);
  }
}

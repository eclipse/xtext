/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
class EvaluationResult {
  protected final static EvaluationResult NOT_A_CONSTANT = new EvaluationResult(new Object(), false) {
    public Object equalValue(final EvaluationResult other) {
      return Boolean.valueOf(false);
    }
  };
  
  private final Object value;
  
  private final boolean compileTimeConstant;
  
  public boolean isNotAConstant() {
    return Objects.equal(this.value, EvaluationResult.NOT_A_CONSTANT.value);
  }
  
  public Object equalValue(final EvaluationResult other) {
    return this.equalValue(this.value, other.value);
  }
  
  private Object _equalValue(final Object myValue, final Object otherValue) {
    return Boolean.valueOf(Objects.equal(myValue, otherValue));
  }
  
  private Object _equalValue(final Void myValue, final Object otherValue) {
    return Boolean.valueOf(false);
  }
  
  private Object _equalValue(final Void myValue, final JvmIdentifiableElement otherValue) {
    return EvaluationResult.NOT_A_CONSTANT.value;
  }
  
  private Object _equalValue(final Void myValue, final JvmType otherValue) {
    return Boolean.valueOf(false);
  }
  
  private Object _equalValue(final Void myValue, final Void otherValue) {
    return Boolean.valueOf(true);
  }
  
  private Object _equalValue(final Object myValue, final Void otherValue) {
    return Boolean.valueOf(false);
  }
  
  private Object _equalValue(final JvmIdentifiableElement myValue, final Void otherValue) {
    return EvaluationResult.NOT_A_CONSTANT.value;
  }
  
  private Object _equalValue(final JvmType myValue, final Void otherValue) {
    return Boolean.valueOf(false);
  }
  
  private Object _equalValue(final XTypeLiteral myValue, final XTypeLiteral otherTypeLiteral) {
    boolean _and = false;
    JvmType _type = myValue.getType();
    JvmType _type_1 = otherTypeLiteral.getType();
    boolean _equals = Objects.equal(_type, _type_1);
    if (!_equals) {
      _and = false;
    } else {
      EList<String> _arrayDimensions = myValue.getArrayDimensions();
      EList<String> _arrayDimensions_1 = otherTypeLiteral.getArrayDimensions();
      boolean _equals_1 = Objects.equal(_arrayDimensions, _arrayDimensions_1);
      _and = _equals_1;
    }
    return Boolean.valueOf(_and);
  }
  
  private Object _equalValue(final JvmType myValue, final XTypeLiteral otherTypeLiteral) {
    boolean _and = false;
    JvmType _type = otherTypeLiteral.getType();
    boolean _equals = Objects.equal(myValue, _type);
    if (!_equals) {
      _and = false;
    } else {
      EList<String> _arrayDimensions = otherTypeLiteral.getArrayDimensions();
      boolean _isEmpty = _arrayDimensions.isEmpty();
      _and = _isEmpty;
    }
    return Boolean.valueOf(_and);
  }
  
  private Object _equalValue(final XTypeLiteral myValue, final JvmType otherType) {
    boolean _and = false;
    JvmType _type = myValue.getType();
    boolean _equals = Objects.equal(_type, otherType);
    if (!_equals) {
      _and = false;
    } else {
      EList<String> _arrayDimensions = myValue.getArrayDimensions();
      boolean _isEmpty = _arrayDimensions.isEmpty();
      _and = _isEmpty;
    }
    return Boolean.valueOf(_and);
  }
  
  private Object equalValue(final Object myValue, final Object otherTypeLiteral) {
    if (myValue instanceof JvmType
         && otherTypeLiteral instanceof XTypeLiteral) {
      return _equalValue((JvmType)myValue, (XTypeLiteral)otherTypeLiteral);
    } else if (myValue instanceof XTypeLiteral
         && otherTypeLiteral instanceof JvmType) {
      return _equalValue((XTypeLiteral)myValue, (JvmType)otherTypeLiteral);
    } else if (myValue instanceof XTypeLiteral
         && otherTypeLiteral instanceof XTypeLiteral) {
      return _equalValue((XTypeLiteral)myValue, (XTypeLiteral)otherTypeLiteral);
    } else if (myValue instanceof JvmType
         && otherTypeLiteral == null) {
      return _equalValue((JvmType)myValue, (Void)null);
    } else if (myValue instanceof JvmIdentifiableElement
         && otherTypeLiteral == null) {
      return _equalValue((JvmIdentifiableElement)myValue, (Void)null);
    } else if (myValue == null
         && otherTypeLiteral instanceof JvmType) {
      return _equalValue((Void)null, (JvmType)otherTypeLiteral);
    } else if (myValue == null
         && otherTypeLiteral instanceof JvmIdentifiableElement) {
      return _equalValue((Void)null, (JvmIdentifiableElement)otherTypeLiteral);
    } else if (myValue == null
         && otherTypeLiteral == null) {
      return _equalValue((Void)null, (Void)null);
    } else if (myValue == null
         && otherTypeLiteral != null) {
      return _equalValue((Void)null, otherTypeLiteral);
    } else if (myValue != null
         && otherTypeLiteral == null) {
      return _equalValue(myValue, (Void)null);
    } else if (myValue != null
         && otherTypeLiteral != null) {
      return _equalValue(myValue, otherTypeLiteral);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(myValue, otherTypeLiteral).toString());
    }
  }
  
  public EvaluationResult(final Object value, final boolean compileTimeConstant) {
    super();
    this.value = value;
    this.compileTimeConstant = compileTimeConstant;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.value== null) ? 0 : this.value.hashCode());
    result = prime * result + (this.compileTimeConstant ? 1231 : 1237);
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EvaluationResult other = (EvaluationResult) obj;
    if (this.value == null) {
      if (other.value != null)
        return false;
    } else if (!this.value.equals(other.value))
      return false;
    if (other.compileTimeConstant != this.compileTimeConstant)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("value", this.value);
    b.add("compileTimeConstant", this.compileTimeConstant);
    return b.toString();
  }
  
  @Pure
  public Object getValue() {
    return this.value;
  }
  
  @Pure
  public boolean isCompileTimeConstant() {
    return this.compileTimeConstant;
  }
}

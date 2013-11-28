/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.typing.XbaseTypeArgumentContextProvider;

/**
 * @author Sebastian Zarnekow
 */
@Data
@SuppressWarnings("all")
public class FeatureCallRequest extends XbaseTypeArgumentContextProvider.AbstractFeatureCallRequest {
  private final XAbstractFeatureCall _call;
  
  public XAbstractFeatureCall getCall() {
    return this._call;
  }
  
  private final JvmExecutable _feature;
  
  public JvmExecutable getFeature() {
    return this._feature;
  }
  
  private final JvmTypeReference _receiverType;
  
  public JvmTypeReference getReceiverType() {
    return this._receiverType;
  }
  
  private final JvmTypeReference _expectedType;
  
  public JvmTypeReference getExpectedType() {
    return this._expectedType;
  }
  
  private final List<JvmTypeReference> _argumentTypes;
  
  public List<JvmTypeReference> getArgumentTypes() {
    return this._argumentTypes;
  }
  
  private final ILogicalContainerProvider _contextProvider;
  
  public ILogicalContainerProvider getContextProvider() {
    return this._contextProvider;
  }
  
  public JvmTypeParameterDeclarator getNearestDeclarator() {
    EObject context = this.getCall();
    JvmTypeParameterDeclarator result = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(context, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _equals = Objects.equal(result, null);
      _and = (_notEquals && _equals);
    }
    boolean _while = _and;
    while (_while) {
      if ((context instanceof JvmTypeParameterDeclarator)) {
        result = ((JvmTypeParameterDeclarator)context);
      } else {
        ILogicalContainerProvider _contextProvider = this.getContextProvider();
        final JvmIdentifiableElement logicalContainer = _contextProvider.getLogicalContainer(context);
        boolean _notEquals_1 = (!Objects.equal(logicalContainer, null));
        if (_notEquals_1) {
          context = logicalContainer;
        } else {
          EObject _eContainer = context.eContainer();
          context = _eContainer;
        }
      }
      boolean _and_1 = false;
      boolean _notEquals_2 = (!Objects.equal(context, null));
      if (!_notEquals_2) {
        _and_1 = false;
      } else {
        boolean _equals_1 = Objects.equal(result, null);
        _and_1 = (_notEquals_2 && _equals_1);
      }
      _while = _and_1;
    }
    return result;
  }
  
  public List<JvmTypeReference> getExplicitTypeArgument() {
    XAbstractFeatureCall _call = this.getCall();
    return _call.getTypeArguments();
  }
  
  public JvmTypeReference getDeclaredType() {
    JvmTypeReference _switchResult = null;
    JvmExecutable _feature = this.getFeature();
    final JvmExecutable f = _feature;
    boolean _matched = false;
    if (!_matched) {
      if (f instanceof JvmOperation) {
        _matched=true;
        JvmTypeReference _returnType = ((JvmOperation)f).getReturnType();
        _switchResult = _returnType;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  public XAbstractFeatureCall getFeatureCall() {
    XAbstractFeatureCall _call = this.getCall();
    return _call;
  }
  
  public FeatureCallRequest(final XAbstractFeatureCall call, final JvmExecutable feature, final JvmTypeReference receiverType, final JvmTypeReference expectedType, final List<JvmTypeReference> argumentTypes, final ILogicalContainerProvider contextProvider) {
    super();
    this._call = call;
    this._feature = feature;
    this._receiverType = receiverType;
    this._expectedType = expectedType;
    this._argumentTypes = argumentTypes;
    this._contextProvider = contextProvider;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_call== null) ? 0 : _call.hashCode());
    result = prime * result + ((_feature== null) ? 0 : _feature.hashCode());
    result = prime * result + ((_receiverType== null) ? 0 : _receiverType.hashCode());
    result = prime * result + ((_expectedType== null) ? 0 : _expectedType.hashCode());
    result = prime * result + ((_argumentTypes== null) ? 0 : _argumentTypes.hashCode());
    result = prime * result + ((_contextProvider== null) ? 0 : _contextProvider.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    FeatureCallRequest other = (FeatureCallRequest) obj;
    if (_call == null) {
      if (other._call != null)
        return false;
    } else if (!_call.equals(other._call))
      return false;
    if (_feature == null) {
      if (other._feature != null)
        return false;
    } else if (!_feature.equals(other._feature))
      return false;
    if (_receiverType == null) {
      if (other._receiverType != null)
        return false;
    } else if (!_receiverType.equals(other._receiverType))
      return false;
    if (_expectedType == null) {
      if (other._expectedType != null)
        return false;
    } else if (!_expectedType.equals(other._expectedType))
      return false;
    if (_argumentTypes == null) {
      if (other._argumentTypes != null)
        return false;
    } else if (!_argumentTypes.equals(other._argumentTypes))
      return false;
    if (_contextProvider == null) {
      if (other._contextProvider != null)
        return false;
    } else if (!_contextProvider.equals(other._contextProvider))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}

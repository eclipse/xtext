/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.editor.copyqualifiedname;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.naming.DefaultCopyQualifiedNameService;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
@SuppressWarnings("all")
public class XbaseCopyQualifiedNameService extends DefaultCopyQualifiedNameService {
  @Inject
  @Extension
  private OverrideHelper overrideHelper;
  
  @Inject
  @Extension
  private IBatchTypeResolver typeResolver;
  
  protected String _getQualifiedName(final JvmExecutable it, final EObject context) {
    return this.toQualifiedName(it);
  }
  
  protected String _getQualifiedName(final JvmExecutable it, final Void context) {
    return this.toQualifiedName(it);
  }
  
  protected String toQualifiedName(final JvmExecutable it) {
    StringConcatenation _builder = new StringConcatenation();
    String _fullyQualifiedName = this.toFullyQualifiedName(it);
    _builder.append(_fullyQualifiedName);
    _builder.append("(");
    final Function1<JvmFormalParameter, String> _function = (JvmFormalParameter it_1) -> {
      return it_1.getParameterType().getSimpleName();
    };
    CharSequence _qualifiedNames = this.<JvmFormalParameter>toQualifiedNames(it.getParameters(), _function);
    _builder.append(_qualifiedNames);
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _getQualifiedName(final JvmExecutable executable, final XAbstractFeatureCall featureCall) {
    String _xblockexpression = null;
    {
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(featureCall);
      final IResolvedExecutable resolvedExecutable = this.resolveExecutable(executable, featureCall, resolvedTypes);
      StringConcatenation _builder = new StringConcatenation();
      String _fullyQualifiedName = this.toFullyQualifiedName(executable);
      _builder.append(_fullyQualifiedName);
      _builder.append("(");
      final Function1<XExpression, String> _function = (XExpression it) -> {
        return this.toQualifiedName(it, resolvedExecutable, executable, resolvedTypes, featureCall.getActualArguments());
      };
      CharSequence _qualifiedNames = this.<XExpression>toQualifiedNames(featureCall.getActualArguments(), _function);
      _builder.append(_qualifiedNames);
      _builder.append(")");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String _getQualifiedName(final JvmConstructor constructor, final XConstructorCall constructorCall) {
    String _xblockexpression = null;
    {
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(constructorCall);
      final IResolvedExecutable resolvedExecutable = this.resolveExecutable(constructor, constructorCall, resolvedTypes);
      StringConcatenation _builder = new StringConcatenation();
      String _fullyQualifiedName = this.toFullyQualifiedName(constructor);
      _builder.append(_fullyQualifiedName);
      _builder.append("(");
      final Function1<XExpression, String> _function = (XExpression it) -> {
        return this.toQualifiedName(it, resolvedExecutable, constructor, resolvedTypes, constructorCall.getArguments());
      };
      CharSequence _qualifiedNames = this.<XExpression>toQualifiedNames(constructorCall.getArguments(), _function);
      _builder.append(_qualifiedNames);
      _builder.append(")");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String toQualifiedName(final XExpression it, final IResolvedExecutable resolvedExecutable, final JvmExecutable executable, @Extension final IResolvedTypes resolvedTypes, final List<XExpression> arguments) {
    final LightweightTypeReference actualType = resolvedTypes.getActualType(it);
    if ((((actualType != null) && (!actualType.isAny())) && (!actualType.isUnknown()))) {
      return actualType.getHumanReadableName();
    }
    final int index = arguments.indexOf(it);
    if ((resolvedExecutable == null)) {
      return executable.getParameters().get(index).getParameterType().getSimpleName();
    }
    return resolvedExecutable.getResolvedParameterTypes().get(index).getSimpleName();
  }
  
  protected IResolvedExecutable _resolveExecutable(final JvmConstructor constructor, final XConstructorCall it, @Extension final IResolvedTypes resolvedTypes) {
    LightweightTypeReference _actualType = resolvedTypes.getActualType(it);
    ResolvedFeatures _resolvedFeatures = null;
    if (_actualType!=null) {
      _resolvedFeatures=this.overrideHelper.getResolvedFeatures(_actualType);
    }
    List<IResolvedConstructor> _declaredConstructors = null;
    if (_resolvedFeatures!=null) {
      _declaredConstructors=_resolvedFeatures.getDeclaredConstructors();
    }
    Iterable<IResolvedConstructor> _filter = null;
    if (_declaredConstructors!=null) {
      final Function1<IResolvedConstructor, Boolean> _function = (IResolvedConstructor it_1) -> {
        return Boolean.valueOf(it_1.getDeclaration().equals(constructor));
      };
      _filter=IterableExtensions.<IResolvedConstructor>filter(_declaredConstructors, _function);
    }
    IResolvedConstructor _head = null;
    if (_filter!=null) {
      _head=IterableExtensions.<IResolvedConstructor>head(_filter);
    }
    return _head;
  }
  
  protected IResolvedExecutable _resolveExecutable(final JvmOperation operation, final XAbstractFeatureCall it, @Extension final IResolvedTypes resolvedTypes) {
    XExpression _actualReceiver = it.getActualReceiver();
    LightweightTypeReference _actualType = null;
    if (_actualReceiver!=null) {
      _actualType=resolvedTypes.getActualType(_actualReceiver);
    }
    ResolvedFeatures _resolvedFeatures = null;
    if (_actualType!=null) {
      _resolvedFeatures=this.overrideHelper.getResolvedFeatures(_actualType);
    }
    List<IResolvedOperation> _allOperations = null;
    if (_resolvedFeatures!=null) {
      _allOperations=_resolvedFeatures.getAllOperations();
    }
    Iterable<IResolvedOperation> _filter = null;
    if (_allOperations!=null) {
      final Function1<IResolvedOperation, Boolean> _function = (IResolvedOperation it_1) -> {
        return Boolean.valueOf(it_1.getDeclaration().equals(operation));
      };
      _filter=IterableExtensions.<IResolvedOperation>filter(_allOperations, _function);
    }
    IResolvedOperation _head = null;
    if (_filter!=null) {
      _head=IterableExtensions.<IResolvedOperation>head(_filter);
    }
    return _head;
  }
  
  protected IResolvedExecutable _resolveExecutable(final JvmConstructor consturctor, final XAbstractFeatureCall it, @Extension final IResolvedTypes resolvedTypes) {
    XExpression _actualReceiver = it.getActualReceiver();
    LightweightTypeReference _actualType = null;
    if (_actualReceiver!=null) {
      _actualType=resolvedTypes.getActualType(_actualReceiver);
    }
    ResolvedFeatures _resolvedFeatures = null;
    if (_actualType!=null) {
      _resolvedFeatures=this.overrideHelper.getResolvedFeatures(_actualType);
    }
    List<IResolvedConstructor> _declaredConstructors = null;
    if (_resolvedFeatures!=null) {
      _declaredConstructors=_resolvedFeatures.getDeclaredConstructors();
    }
    Iterable<IResolvedConstructor> _filter = null;
    if (_declaredConstructors!=null) {
      final Function1<IResolvedConstructor, Boolean> _function = (IResolvedConstructor it_1) -> {
        return Boolean.valueOf(it_1.getDeclaration().equals(consturctor));
      };
      _filter=IterableExtensions.<IResolvedConstructor>filter(_declaredConstructors, _function);
    }
    IResolvedConstructor _head = null;
    if (_filter!=null) {
      _head=IterableExtensions.<IResolvedConstructor>head(_filter);
    }
    return _head;
  }
  
  public String getQualifiedName(final EObject constructor, final EObject constructorCall) {
    if (constructor instanceof JvmConstructor
         && constructorCall instanceof XConstructorCall) {
      return _getQualifiedName((JvmConstructor)constructor, (XConstructorCall)constructorCall);
    } else if (constructor instanceof JvmExecutable
         && constructorCall instanceof XAbstractFeatureCall) {
      return _getQualifiedName((JvmExecutable)constructor, (XAbstractFeatureCall)constructorCall);
    } else if (constructor instanceof JvmExecutable
         && constructorCall != null) {
      return _getQualifiedName((JvmExecutable)constructor, constructorCall);
    } else if (constructor instanceof JvmExecutable
         && constructorCall == null) {
      return _getQualifiedName((JvmExecutable)constructor, (Void)null);
    } else if (constructor != null
         && constructorCall != null) {
      return _getQualifiedName(constructor, constructorCall);
    } else if (constructor != null
         && constructorCall == null) {
      return _getQualifiedName(constructor, (Void)null);
    } else if (constructor == null
         && constructorCall != null) {
      return _getQualifiedName((Void)null, constructorCall);
    } else if (constructor == null
         && constructorCall == null) {
      return _getQualifiedName((Void)null, (Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(constructor, constructorCall).toString());
    }
  }
  
  protected IResolvedExecutable resolveExecutable(final JvmExecutable consturctor, final XExpression it, final IResolvedTypes resolvedTypes) {
    if (consturctor instanceof JvmConstructor
         && it instanceof XAbstractFeatureCall) {
      return _resolveExecutable((JvmConstructor)consturctor, (XAbstractFeatureCall)it, resolvedTypes);
    } else if (consturctor instanceof JvmConstructor
         && it instanceof XConstructorCall) {
      return _resolveExecutable((JvmConstructor)consturctor, (XConstructorCall)it, resolvedTypes);
    } else if (consturctor instanceof JvmOperation
         && it instanceof XAbstractFeatureCall) {
      return _resolveExecutable((JvmOperation)consturctor, (XAbstractFeatureCall)it, resolvedTypes);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(consturctor, it, resolvedTypes).toString());
    }
  }
}

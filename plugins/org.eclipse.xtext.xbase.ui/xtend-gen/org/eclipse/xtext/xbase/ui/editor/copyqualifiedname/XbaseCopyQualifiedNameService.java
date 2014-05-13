/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.editor.copyqualifiedname;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.editor.copyqualifiedname.DefaultCopyQualifiedNameService;
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
import org.eclipse.xtext.xbase.typesystem.override.ResolvedOperations;
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
    _builder.append(_fullyQualifiedName, "");
    _builder.append("(");
    EList<JvmFormalParameter> _parameters = it.getParameters();
    final Function1<JvmFormalParameter, String> _function = new Function1<JvmFormalParameter, String>() {
      public String apply(final JvmFormalParameter it) {
        JvmTypeReference _parameterType = it.getParameterType();
        return _parameterType.getSimpleName();
      }
    };
    CharSequence _qualifiedNames = this.<JvmFormalParameter>toQualifiedNames(_parameters, _function);
    _builder.append(_qualifiedNames, "");
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
      _builder.append(_fullyQualifiedName, "");
      _builder.append("(");
      EList<XExpression> _actualArguments = featureCall.getActualArguments();
      final Function1<XExpression, String> _function = new Function1<XExpression, String>() {
        public String apply(final XExpression it) {
          EList<XExpression> _actualArguments = featureCall.getActualArguments();
          return XbaseCopyQualifiedNameService.this.toQualifiedName(it, resolvedExecutable, executable, resolvedTypes, _actualArguments);
        }
      };
      CharSequence _qualifiedNames = this.<XExpression>toQualifiedNames(_actualArguments, _function);
      _builder.append(_qualifiedNames, "");
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
      _builder.append(_fullyQualifiedName, "");
      _builder.append("(");
      EList<XExpression> _arguments = constructorCall.getArguments();
      final Function1<XExpression, String> _function = new Function1<XExpression, String>() {
        public String apply(final XExpression it) {
          EList<XExpression> _arguments = constructorCall.getArguments();
          return XbaseCopyQualifiedNameService.this.toQualifiedName(it, resolvedExecutable, constructor, resolvedTypes, _arguments);
        }
      };
      CharSequence _qualifiedNames = this.<XExpression>toQualifiedNames(_arguments, _function);
      _builder.append(_qualifiedNames, "");
      _builder.append(")");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String toQualifiedName(final XExpression it, final IResolvedExecutable resolvedExecutable, final JvmExecutable executable, @Extension final IResolvedTypes resolvedTypes, final List<XExpression> arguments) {
    final LightweightTypeReference actualType = resolvedTypes.getActualType(it);
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(actualType, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      boolean _isAny = actualType.isAny();
      boolean _not = (!_isAny);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isUnknown = actualType.isUnknown();
      boolean _not_1 = (!_isUnknown);
      _and = _not_1;
    }
    if (_and) {
      return actualType.getHumanReadableName();
    }
    final int index = arguments.indexOf(it);
    boolean _equals = Objects.equal(resolvedExecutable, null);
    if (_equals) {
      EList<JvmFormalParameter> _parameters = executable.getParameters();
      JvmFormalParameter _get = _parameters.get(index);
      JvmTypeReference _parameterType = _get.getParameterType();
      return _parameterType.getSimpleName();
    }
    List<LightweightTypeReference> _resolvedParameterTypes = resolvedExecutable.getResolvedParameterTypes();
    LightweightTypeReference _get_1 = _resolvedParameterTypes.get(index);
    return _get_1.getSimpleName();
  }
  
  protected IResolvedExecutable _resolveExecutable(final JvmConstructor constructor, final XConstructorCall it, @Extension final IResolvedTypes resolvedTypes) {
    LightweightTypeReference _actualType = resolvedTypes.getActualType(it);
    ResolvedOperations _resolvedOperations = null;
    if (_actualType!=null) {
      _resolvedOperations=this.overrideHelper.getResolvedOperations(_actualType);
    }
    List<IResolvedConstructor> _declaredConstructors = null;
    if (_resolvedOperations!=null) {
      _declaredConstructors=_resolvedOperations.getDeclaredConstructors();
    }
    Iterable<IResolvedConstructor> _filter = null;
    if (_declaredConstructors!=null) {
      final Function1<IResolvedConstructor, Boolean> _function = new Function1<IResolvedConstructor, Boolean>() {
        public Boolean apply(final IResolvedConstructor it) {
          JvmConstructor _declaration = it.getDeclaration();
          return Boolean.valueOf(_declaration.equals(constructor));
        }
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
    ResolvedOperations _resolvedOperations = null;
    if (_actualType!=null) {
      _resolvedOperations=this.overrideHelper.getResolvedOperations(_actualType);
    }
    List<IResolvedOperation> _allOperations = null;
    if (_resolvedOperations!=null) {
      _allOperations=_resolvedOperations.getAllOperations();
    }
    Iterable<IResolvedOperation> _filter = null;
    if (_allOperations!=null) {
      final Function1<IResolvedOperation, Boolean> _function = new Function1<IResolvedOperation, Boolean>() {
        public Boolean apply(final IResolvedOperation it) {
          JvmOperation _declaration = it.getDeclaration();
          return Boolean.valueOf(_declaration.equals(operation));
        }
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
    ResolvedOperations _resolvedOperations = null;
    if (_actualType!=null) {
      _resolvedOperations=this.overrideHelper.getResolvedOperations(_actualType);
    }
    List<IResolvedConstructor> _declaredConstructors = null;
    if (_resolvedOperations!=null) {
      _declaredConstructors=_resolvedOperations.getDeclaredConstructors();
    }
    Iterable<IResolvedConstructor> _filter = null;
    if (_declaredConstructors!=null) {
      final Function1<IResolvedConstructor, Boolean> _function = new Function1<IResolvedConstructor, Boolean>() {
        public Boolean apply(final IResolvedConstructor it) {
          JvmConstructor _declaration = it.getDeclaration();
          return Boolean.valueOf(_declaration.equals(consturctor));
        }
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

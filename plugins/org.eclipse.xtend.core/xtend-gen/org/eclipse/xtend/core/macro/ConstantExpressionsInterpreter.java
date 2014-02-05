/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.interpreter.AbstractConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.Context;
import org.eclipse.xtext.xbase.interpreter.StackedConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.UnresolvableFeatureException;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * An interpreter for evaluating constant expressions in annotation values.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class ConstantExpressionsInterpreter extends AbstractConstantExpressionsInterpreter {
  @Inject
  private ILogicalContainerProvider containerProvider;
  
  @Inject
  private ProcessorInstanceForJvmTypeProvider classLoaderProvider;
  
  @Inject
  @Extension
  private NumberLiterals numberLiterals;
  
  @Inject
  private IScopeProvider scopeProvider;
  
  @Inject
  private IImportsConfiguration importSectionLocator;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  public Object evaluate(final XExpression expression, final JvmTypeReference expectedType) {
    final ClassLoader classLoader = this.classLoaderProvider.getClassLoader(expression);
    final Map<String,JvmIdentifiableElement> visibleFeatures = this.findVisibleFeatures(expression);
    JvmTypeReference _xifexpression = null;
    if ((expectedType instanceof XComputedTypeReference)) {
      _xifexpression = null;
    } else {
      _xifexpression = expectedType;
    }
    ClassFinder _classFinder = new ClassFinder(classLoader);
    LinkedHashSet<XExpression> _newLinkedHashSet = CollectionLiterals.<XExpression>newLinkedHashSet();
    Context _context = new Context(_xifexpression, _classFinder, visibleFeatures, _newLinkedHashSet);
    final Object result = this.internalEvaluate(expression, _context);
    return result;
  }
  
  /**
   * looks up the static final fields which are accessible in unqualified form for the given expression.
   * That essentially includes static imports and the fields declared in the containing types
   */
  protected Map<String,JvmIdentifiableElement> findVisibleFeatures(final XExpression expression) {
    final HashMap<String,JvmIdentifiableElement> result = CollectionLiterals.<String, JvmIdentifiableElement>newHashMap();
    Resource _eResource = expression.eResource();
    final XImportSection section = this.importSectionLocator.getImportSection(((XtextResource) _eResource));
    boolean _notEquals = (!Objects.equal(section, null));
    if (_notEquals) {
      EList<XImportDeclaration> _importDeclarations = section.getImportDeclarations();
      for (final XImportDeclaration imp : _importDeclarations) {
        boolean _isStatic = imp.isStatic();
        if (_isStatic) {
          String _importedTypeName = imp.getImportedTypeName();
          final JvmType type = this.findTypeByName(imp, _importedTypeName);
          boolean _matched = false;
          if (!_matched) {
            if (type instanceof JvmGenericType) {
              _matched=true;
              Iterable<JvmFeature> _allFeatures = ((JvmGenericType)type).getAllFeatures();
              Iterable<JvmField> _filter = Iterables.<JvmField>filter(_allFeatures, JvmField.class);
              final Function1<JvmField,Boolean> _function = new Function1<JvmField,Boolean>() {
                public Boolean apply(final JvmField it) {
                  boolean _and = false;
                  boolean _isStatic = it.isStatic();
                  if (!_isStatic) {
                    _and = false;
                  } else {
                    boolean _isFinal = it.isFinal();
                    _and = _isFinal;
                  }
                  return Boolean.valueOf(_and);
                }
              };
              Iterable<JvmField> _filter_1 = IterableExtensions.<JvmField>filter(_filter, _function);
              for (final JvmField feature : _filter_1) {
                String _simpleName = feature.getSimpleName();
                result.put(_simpleName, feature);
              }
            }
          }
          if (!_matched) {
            if (type instanceof JvmEnumerationType) {
              _matched=true;
              EList<JvmEnumerationLiteral> _literals = ((JvmEnumerationType)type).getLiterals();
              for (final JvmEnumerationLiteral feature : _literals) {
                String _simpleName = feature.getSimpleName();
                result.put(_simpleName, feature);
              }
            }
          }
        }
      }
    }
    JvmDeclaredType _switchResult_1 = null;
    JvmIdentifiableElement _nearestLogicalContainer = this.containerProvider.getNearestLogicalContainer(expression);
    final JvmIdentifiableElement cont = _nearestLogicalContainer;
    boolean _matched_1 = false;
    if (!_matched_1) {
      if (cont instanceof JvmGenericType) {
        _matched_1=true;
        _switchResult_1 = ((JvmGenericType)cont);
      }
    }
    if (!_matched_1) {
      if (cont instanceof JvmMember) {
        _matched_1=true;
        _switchResult_1 = ((JvmMember)cont).getDeclaringType();
      }
    }
    JvmDeclaredType container = _switchResult_1;
    boolean _notEquals_1 = (!Objects.equal(container, null));
    boolean _while = _notEquals_1;
    while (_while) {
      {
        Iterable<JvmFeature> _allFeatures = container.getAllFeatures();
        Iterable<JvmField> _filter = Iterables.<JvmField>filter(_allFeatures, JvmField.class);
        final Function1<JvmField,Boolean> _function = new Function1<JvmField,Boolean>() {
          public Boolean apply(final JvmField it) {
            boolean _and = false;
            boolean _isStatic = it.isStatic();
            if (!_isStatic) {
              _and = false;
            } else {
              boolean _isFinal = it.isFinal();
              _and = _isFinal;
            }
            return Boolean.valueOf(_and);
          }
        };
        Iterable<JvmField> _filter_1 = IterableExtensions.<JvmField>filter(_filter, _function);
        for (final JvmField feature : _filter_1) {
          String _simpleName = feature.getSimpleName();
          result.put(_simpleName, feature);
        }
        JvmDeclaredType _declaringType = container.getDeclaringType();
        container = _declaringType;
      }
      boolean _notEquals_2 = (!Objects.equal(container, null));
      _while = _notEquals_2;
    }
    return result;
  }
  
  protected JvmType findTypeByName(final EObject context, final String qualifiedName) {
    final IScope scope = this.scopeProvider.getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
    final QualifiedName qn = this.qualifiedNameConverter.toQualifiedName(qualifiedName);
    IEObjectDescription _singleElement = scope.getSingleElement(qn);
    EObject _eObjectOrProxy = null;
    if (_singleElement!=null) {
      _eObjectOrProxy=_singleElement.getEObjectOrProxy();
    }
    return ((JvmType) _eObjectOrProxy);
  }
  
  protected Object _internalEvaluate(final XNumberLiteral it, final Context ctx) {
    try {
      Number _xblockexpression = null;
      {
        Class<? extends Number> _xifexpression = null;
        JvmTypeReference _expectedType = ctx.getExpectedType();
        boolean _equals = Objects.equal(_expectedType, null);
        if (_equals) {
          _xifexpression = this.numberLiterals.getJavaType(it);
        } else {
          JvmTypeReference _expectedType_1 = ctx.getExpectedType();
          JvmType _type = _expectedType_1.getType();
          ClassFinder _classFinder = ctx.getClassFinder();
          Class<? extends Object> _javaType = this.getJavaType(_type, _classFinder);
          _xifexpression = ((Class<? extends Number>) _javaType);
        }
        final Class<? extends Number> type = _xifexpression;
        _xblockexpression = (this.numberLiterals.numberValue(it, type));
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Object _internalEvaluate(final XListLiteral it, final Context ctx) {
    try {
      JvmTypeReference _switchResult = null;
      JvmTypeReference _expectedType = ctx.getExpectedType();
      final JvmTypeReference exp = _expectedType;
      boolean _matched = false;
      if (!_matched) {
        if (exp instanceof JvmGenericArrayTypeReference) {
          _matched=true;
          _switchResult = ((JvmGenericArrayTypeReference)exp).getComponentType();
        }
      }
      final JvmTypeReference expectedComponentType = _switchResult;
      EList<XExpression> _elements = it.getElements();
      final Function1<XExpression,Object> _function = new Function1<XExpression,Object>() {
        public Object apply(final XExpression it) {
          Context _cloneWithExpectation = ctx.cloneWithExpectation(expectedComponentType);
          return ConstantExpressionsInterpreter.this.internalEvaluate(it, _cloneWithExpectation);
        }
      };
      final List<Object> elements = ListExtensions.<XExpression, Object>map(_elements, _function);
      Class<? extends Object> _xifexpression = null;
      boolean _notEquals = (!Objects.equal(expectedComponentType, null));
      if (_notEquals) {
        JvmType _type = expectedComponentType.getType();
        ClassFinder _classFinder = ctx.getClassFinder();
        _xifexpression = this.getJavaType(_type, _classFinder);
      } else {
        Class<? extends Object> _xifexpression_1 = null;
        boolean _isEmpty = elements.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          Class<? extends Object> _switchResult_1 = null;
          Object _head = IterableExtensions.<Object>head(elements);
          Class<? extends Object> _class = _head.getClass();
          final Class<? extends Object> cl = _class;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (Objects.equal(cl,Integer.class)) {
              _matched_1=true;
              _switchResult_1 = Integer.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl,Long.class)) {
              _matched_1=true;
              _switchResult_1 = Long.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl,Short.class)) {
              _matched_1=true;
              _switchResult_1 = Short.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl,Boolean.class)) {
              _matched_1=true;
              _switchResult_1 = Boolean.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl,Double.class)) {
              _matched_1=true;
              _switchResult_1 = Double.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl,Byte.class)) {
              _matched_1=true;
              _switchResult_1 = Byte.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl,Float.class)) {
              _matched_1=true;
              _switchResult_1 = Float.TYPE;
            }
          }
          if (!_matched_1) {
            _switchResult_1 = cl;
          }
          _xifexpression_1 = _switchResult_1;
        } else {
          _xifexpression_1 = Object.class;
        }
        _xifexpression = _xifexpression_1;
      }
      final Class<?> componentType = _xifexpression;
      return Conversions.unwrapArray(elements, componentType);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Object _internalEvaluate(final XFeatureCall it, final Context ctx) {
    final String featureName = it.getConcreteSyntaxFeatureName();
    Map<String,JvmIdentifiableElement> _visibleFeatures = ctx.getVisibleFeatures();
    boolean _containsKey = _visibleFeatures.containsKey(featureName);
    if (_containsKey) {
      Object _switchResult = null;
      Map<String,JvmIdentifiableElement> _visibleFeatures_1 = ctx.getVisibleFeatures();
      JvmIdentifiableElement _get = _visibleFeatures_1.get(featureName);
      final JvmIdentifiableElement feature = _get;
      boolean _matched = false;
      if (!_matched) {
        if (feature instanceof JvmEnumerationLiteral) {
          _matched=true;
          _switchResult = ((JvmEnumerationLiteral)feature);
        }
      }
      if (!_matched) {
        if (feature instanceof JvmField) {
          _matched=true;
          _switchResult = this.evaluateField(it, ((JvmField)feature), ctx);
        }
      }
      return _switchResult;
    }
    final JvmType type = this.findTypeByName(it, featureName);
    boolean _notEquals = (!Objects.equal(type, null));
    if (_notEquals) {
      return this.toTypeReference(type, 0);
    }
    throw new UnresolvableFeatureException(("Couldn\'t resolve feature " + featureName), it);
  }
  
  protected Object _internalEvaluate(final XMemberFeatureCall it, final Context ctx) {
    final String featureName = it.getConcreteSyntaxFeatureName();
    try {
      XExpression _memberCallTarget = it.getMemberCallTarget();
      final Object receiver = this.internalEvaluate(_memberCallTarget, ctx);
      boolean _matched = false;
      if (!_matched) {
        if (receiver instanceof JvmTypeReference) {
          _matched=true;
          JvmType _type = ((JvmTypeReference)receiver).getType();
          final JvmType type = _type;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (type instanceof JvmEnumerationType) {
              _matched_1=true;
              EList<JvmEnumerationLiteral> _literals = ((JvmEnumerationType)type).getLiterals();
              final Function1<JvmEnumerationLiteral,Boolean> _function = new Function1<JvmEnumerationLiteral,Boolean>() {
                public Boolean apply(final JvmEnumerationLiteral it) {
                  String _simpleName = it.getSimpleName();
                  return Boolean.valueOf(Objects.equal(_simpleName, featureName));
                }
              };
              final JvmEnumerationLiteral enumValue = IterableExtensions.<JvmEnumerationLiteral>findFirst(_literals, _function);
              boolean _equals = Objects.equal(enumValue, null);
              if (_equals) {
                String _simpleName = ((JvmTypeReference)receiver).getSimpleName();
                String _plus = ((("Couldn\'t find enum value " + featureName) + " on enum ") + _simpleName);
                throw new ConstantExpressionEvaluationException(_plus, it);
              }
              return enumValue;
            }
          }
          if (!_matched_1) {
            if (type instanceof JvmGenericType) {
              _matched_1=true;
              Iterable<JvmFeature> _allFeatures = ((JvmGenericType)type).getAllFeatures();
              Iterable<JvmField> _filter = Iterables.<JvmField>filter(_allFeatures, JvmField.class);
              final Function1<JvmField,Boolean> _function = new Function1<JvmField,Boolean>() {
                public Boolean apply(final JvmField it) {
                  String _simpleName = it.getSimpleName();
                  return Boolean.valueOf(Objects.equal(_simpleName, featureName));
                }
              };
              final JvmField field = IterableExtensions.<JvmField>findFirst(_filter, _function);
              boolean _equals = Objects.equal(field, null);
              if (_equals) {
                String _simpleName = ((JvmTypeReference)receiver).getSimpleName();
                String _plus = ((("Couldn\'t find field " + featureName) + " on type ") + _simpleName);
                throw new ConstantExpressionEvaluationException(_plus, it);
              }
              return this.evaluateField(it, field, ctx);
            }
          }
        }
      }
      throw new UnresolvableFeatureException(((("Unresolvable feature " + featureName) + " on ") + receiver), it);
    } catch (final Throwable _t) {
      if (_t instanceof UnresolvableFeatureException) {
        final UnresolvableFeatureException e = (UnresolvableFeatureException)_t;
        final String typeName = this.getFullName(it);
        final JvmType type = this.findTypeByName(it, typeName);
        boolean _notEquals = (!Objects.equal(type, null));
        if (_notEquals) {
          return this.toTypeReference(type, 0);
        } else {
          throw new UnresolvableFeatureException(("Unresolvable type " + typeName), it);
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected String _getFullName(final XExpression call) {
    String _text = this.toText(call);
    String _plus = ("The expression \'" + _text);
    String _plus_1 = (_plus + "\' cannot be used as a receiver within a constant expression.");
    throw new ConstantExpressionEvaluationException(_plus_1);
  }
  
  protected String _getFullName(final XMemberFeatureCall call) {
    XExpression _memberCallTarget = call.getMemberCallTarget();
    final String prefix = this.getFullName(_memberCallTarget);
    String _concreteSyntaxFeatureName = call.getConcreteSyntaxFeatureName();
    return ((prefix + ".") + _concreteSyntaxFeatureName);
  }
  
  protected String _getFullName(final XFeatureCall call) {
    return call.getConcreteSyntaxFeatureName();
  }
  
  protected Object evaluateField(final XAbstractFeatureCall call, final JvmField field, final Context context) {
    try {
      Resource _eResource = field.eResource();
      if ((_eResource instanceof TypeResource)) {
        JvmDeclaredType _declaringType = field.getDeclaringType();
        ClassFinder _classFinder = context.getClassFinder();
        final Class<? extends Object> clazz = this.getJavaType(_declaringType, _classFinder);
        String _simpleName = field.getSimpleName();
        Field _field = clazz.getField(_simpleName);
        Object _get = null;
        if (_field!=null) {
          _get=_field.get(null);
        }
        return _get;
      }
      final XExpression expression = this.containerProvider.getAssociatedExpression(field);
      Set<XExpression> _alreadyEvaluating = context.getAlreadyEvaluating();
      boolean _contains = _alreadyEvaluating.contains(expression);
      if (_contains) {
        throw new ConstantExpressionEvaluationException("Endless recursive evaluation detected.");
      }
      try {
        final Map<String,JvmIdentifiableElement> visibleFeatures = this.findVisibleFeatures(expression);
        Set<XExpression> _alreadyEvaluating_1 = context.getAlreadyEvaluating();
        final LinkedHashSet<XExpression> set = new LinkedHashSet<XExpression>(_alreadyEvaluating_1);
        set.add(expression);
        JvmTypeReference _type = field.getType();
        ClassFinder _classFinder_1 = context.getClassFinder();
        final Context ctx = new Context(_type, _classFinder_1, visibleFeatures, set);
        return this.internalEvaluate(expression, ctx);
      } catch (final Throwable _t) {
        if (_t instanceof ConstantExpressionEvaluationException) {
          final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
          throw new StackedConstantExpressionEvaluationException(call, field, e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Class<? extends Object> getJavaType(final JvmType type, final ClassFinder classFinder) throws ClassNotFoundException {
    if ((type instanceof JvmArrayType)) {
      JvmType t = type;
      String dimensions = "";
      boolean _while = (t instanceof JvmArrayType);
      while (_while) {
        {
          dimensions = (dimensions + "[]");
          JvmComponentType _componentType = ((JvmArrayType)t).getComponentType();
          t = _componentType;
        }
        _while = (t instanceof JvmArrayType);
      }
      final Class<? extends Object> componentClass = this.getJavaType(t, classFinder);
      String _name = componentClass.getName();
      String _plus = (_name + dimensions);
      return classFinder.forName(_plus);
    }
    String _identifier = type.getIdentifier();
    boolean _equals = Objects.equal(_identifier, "java.lang.Class");
    if (_equals) {
      return JvmTypeReference.class;
    }
    if ((type instanceof JvmEnumerationType)) {
      return JvmEnumerationLiteral.class;
    }
    if ((type instanceof JvmAnnotationType)) {
      return XAnnotation.class;
    }
    String _identifier_1 = type.getIdentifier();
    return classFinder.forName(_identifier_1);
  }
  
  public Object internalEvaluate(final XExpression it, final Context ctx) {
    if (it instanceof XBinaryOperation) {
      return _internalEvaluate((XBinaryOperation)it, ctx);
    } else if (it instanceof XFeatureCall) {
      return _internalEvaluate((XFeatureCall)it, ctx);
    } else if (it instanceof XListLiteral) {
      return _internalEvaluate((XListLiteral)it, ctx);
    } else if (it instanceof XMemberFeatureCall) {
      return _internalEvaluate((XMemberFeatureCall)it, ctx);
    } else if (it instanceof XUnaryOperation) {
      return _internalEvaluate((XUnaryOperation)it, ctx);
    } else if (it instanceof XBooleanLiteral) {
      return _internalEvaluate((XBooleanLiteral)it, ctx);
    } else if (it instanceof XCastedExpression) {
      return _internalEvaluate((XCastedExpression)it, ctx);
    } else if (it instanceof XNumberLiteral) {
      return _internalEvaluate((XNumberLiteral)it, ctx);
    } else if (it instanceof XStringLiteral) {
      return _internalEvaluate((XStringLiteral)it, ctx);
    } else if (it instanceof XTypeLiteral) {
      return _internalEvaluate((XTypeLiteral)it, ctx);
    } else if (it instanceof XAnnotation) {
      return _internalEvaluate((XAnnotation)it, ctx);
    } else if (it != null) {
      return _internalEvaluate(it, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, ctx).toString());
    }
  }
  
  public String getFullName(final XExpression call) {
    if (call instanceof XFeatureCall) {
      return _getFullName((XFeatureCall)call);
    } else if (call instanceof XMemberFeatureCall) {
      return _getFullName((XMemberFeatureCall)call);
    } else if (call != null) {
      return _getFullName(call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
}

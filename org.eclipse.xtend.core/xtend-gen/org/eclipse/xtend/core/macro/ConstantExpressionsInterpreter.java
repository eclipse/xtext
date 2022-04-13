/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
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
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.IResourceScopeCache;
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
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
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
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;
import org.eclipse.xtext.xbase.typesystem.util.PendingLinkingCandidateResolver;
import org.eclipse.xtext.xbase.typesystem.util.TypeLiteralLinkingCandidateResolver;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * An interpreter for evaluating constant expressions in annotation values.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class ConstantExpressionsInterpreter extends AbstractConstantExpressionsInterpreter {
  /**
   * The visible fields collector does not interfere with the local caches of JvmDeclaredTypes
   * but only looks at the fields of those types.
   */
  public static class VisibleFieldsCollector {
    public void collect(final JvmDeclaredType type, final Map<String, JvmIdentifiableElement> result) {
      this.collect(type, CollectionLiterals.<JvmType>newHashSet(), result);
    }

    private void collect(final JvmDeclaredType type, final Set<JvmType> seen, final Map<String, JvmIdentifiableElement> result) {
      boolean _add = seen.add(type);
      if (_add) {
        EList<JvmMember> _members = type.getMembers();
        for (final JvmMember member : _members) {
          if ((member instanceof JvmField)) {
            if ((((JvmField)member).isFinal() && ((JvmField)member).isStatic())) {
              final JvmIdentifiableElement existing = result.put(((JvmField)member).getSimpleName(), member);
              if ((existing != null)) {
                result.put(existing.getSimpleName(), existing);
              }
            }
          }
        }
        EList<JvmTypeReference> _superTypes = type.getSuperTypes();
        for (final JvmTypeReference superType : _superTypes) {
          {
            JvmType _type = null;
            if (superType!=null) {
              _type=superType.getType();
            }
            final JvmType rawSuperType = _type;
            if (((rawSuperType instanceof JvmDeclaredType) && (!rawSuperType.eIsProxy()))) {
              this.collect(((JvmDeclaredType) rawSuperType), seen, result);
            }
          }
        }
      }
    }
  }

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

  @Inject
  private IResourceScopeCache cache;

  public Object evaluate(final XExpression expression, final JvmTypeReference expectedType) {
    final ClassLoader classLoader = this.classLoaderProvider.getClassLoader(expression);
    final Map<String, JvmIdentifiableElement> visibleFeatures = this.findVisibleFeatures(expression);
    JvmTypeReference _xifexpression = null;
    if ((expectedType instanceof XComputedTypeReference)) {
      _xifexpression = null;
    } else {
      _xifexpression = expectedType;
    }
    ClassFinder _classFinder = new ClassFinder(classLoader);
    LinkedHashSet<XExpression> _newLinkedHashSet = CollectionLiterals.<XExpression>newLinkedHashSet();
    Context _context = new Context(_xifexpression, _classFinder, visibleFeatures, _newLinkedHashSet);
    final Object result = this.evaluate(expression, _context);
    return result;
  }

  /**
   * looks up the static final fields which are accessible in unqualified form for the given expression.
   * That essentially includes static imports and the fields declared in the containing types
   */
  protected Map<String, JvmIdentifiableElement> findVisibleFeatures(final XExpression expression) {
    HashMap<String, JvmIdentifiableElement> _xblockexpression = null;
    {
      Resource _eResource = expression.eResource();
      final Resource res = _eResource;
      boolean _matched = false;
      if (res instanceof StorageAwareResource) {
        boolean _isLoadedFromStorage = ((StorageAwareResource)res).isLoadedFromStorage();
        if (_isLoadedFromStorage) {
          _matched=true;
          return CollectionLiterals.<String, JvmIdentifiableElement>newHashMap();
        }
      }
      JvmDeclaredType _switchResult_1 = null;
      JvmIdentifiableElement _nearestLogicalContainer = this.containerProvider.getNearestLogicalContainer(expression);
      final JvmIdentifiableElement cont = _nearestLogicalContainer;
      boolean _matched_1 = false;
      if (cont instanceof JvmGenericType) {
        _matched_1=true;
        _switchResult_1 = ((JvmGenericType)cont);
      }
      if (!_matched_1) {
        if (cont instanceof JvmMember) {
          _matched_1=true;
          _switchResult_1 = ((JvmMember)cont).getDeclaringType();
        }
      }
      final JvmDeclaredType container = _switchResult_1;
      Pair<String, JvmDeclaredType> _mappedTo = Pair.<String, JvmDeclaredType>of("visibleFeaturesForAnnotationValues", container);
      final Provider<HashMap<String, JvmIdentifiableElement>> _function = () -> {
        final HashMap<String, JvmIdentifiableElement> result = CollectionLiterals.<String, JvmIdentifiableElement>newHashMap();
        Resource _eResource_1 = expression.eResource();
        final XImportSection section = this.importSectionLocator.getImportSection(((XtextResource) _eResource_1));
        if ((section != null)) {
          EList<XImportDeclaration> _importDeclarations = section.getImportDeclarations();
          for (final XImportDeclaration imp : _importDeclarations) {
            boolean _isStatic = imp.isStatic();
            if (_isStatic) {
              final String importedTypeName = imp.getImportedTypeName();
              if ((importedTypeName != null)) {
                final JvmType type = this.findTypeByName(imp, importedTypeName);
                boolean _matched_2 = false;
                if (type instanceof JvmGenericType) {
                  _matched_2=true;
                  this.collectAllVisibleFields(((JvmDeclaredType)type), result);
                }
                if (!_matched_2) {
                  if (type instanceof JvmEnumerationType) {
                    _matched_2=true;
                    EList<JvmEnumerationLiteral> _literals = ((JvmEnumerationType)type).getLiterals();
                    for (final JvmEnumerationLiteral feature : _literals) {
                      result.put(feature.getSimpleName(), feature);
                    }
                  }
                }
              }
            }
          }
        }
        this.collectAllVisibleFields(container, result);
        return result;
      };
      _xblockexpression = this.cache.<HashMap<String, JvmIdentifiableElement>>get(_mappedTo, expression.eResource(), _function);
    }
    return _xblockexpression;
  }

  protected void collectAllVisibleFields(final JvmDeclaredType type, final Map<String, JvmIdentifiableElement> result) {
    if ((type == null)) {
      return;
    }
    this.collectAllVisibleFields(type.getDeclaringType(), result);
    result.putAll(this.getAllVisibleFields(type));
  }

  protected HashMap<String, JvmIdentifiableElement> getAllVisibleFields(final JvmDeclaredType type) {
    final HashMap<String, JvmIdentifiableElement> result = CollectionLiterals.<String, JvmIdentifiableElement>newHashMap();
    new ConstantExpressionsInterpreter.VisibleFieldsCollector().collect(type, result);
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
        boolean _tripleEquals = (_expectedType == null);
        if (_tripleEquals) {
          _xifexpression = this.numberLiterals.getJavaType(it);
        } else {
          Class<?> _javaType = this.getJavaType(ctx.getExpectedType().getType(), ctx.getClassFinder());
          _xifexpression = ((Class<? extends Number>) _javaType);
        }
        final Class<? extends Number> type = _xifexpression;
        _xblockexpression = this.numberLiterals.numberValue(it, type);
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
      if (exp instanceof JvmGenericArrayTypeReference) {
        _matched=true;
        _switchResult = ((JvmGenericArrayTypeReference)exp).getComponentType();
      }
      final JvmTypeReference expectedComponentType = _switchResult;
      final Function1<XExpression, Object> _function = (XExpression it_1) -> {
        return this.evaluate(it_1, ctx.cloneWithExpectation(expectedComponentType));
      };
      final List<Object> elements = ListExtensions.<XExpression, Object>map(it.getElements(), _function);
      Class<?> _xifexpression = null;
      if ((expectedComponentType != null)) {
        _xifexpression = this.getJavaType(expectedComponentType.getType(), ctx.getClassFinder());
      } else {
        Class<?> _xifexpression_1 = null;
        boolean _isEmpty = elements.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          Class<?> _switchResult_1 = null;
          Class<?> _class = IterableExtensions.<Object>head(elements).getClass();
          final Class<?> cl = _class;
          boolean _matched_1 = false;
          if (Objects.equal(cl, Integer.class)) {
            _matched_1=true;
            _switchResult_1 = Integer.TYPE;
          }
          if (!_matched_1) {
            if (Objects.equal(cl, Long.class)) {
              _matched_1=true;
              _switchResult_1 = Long.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl, Short.class)) {
              _matched_1=true;
              _switchResult_1 = Short.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl, Boolean.class)) {
              _matched_1=true;
              _switchResult_1 = Boolean.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl, Double.class)) {
              _matched_1=true;
              _switchResult_1 = Double.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl, Byte.class)) {
              _matched_1=true;
              _switchResult_1 = Byte.TYPE;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(cl, Float.class)) {
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

  protected boolean isResolveProxies(final EObject ctx) {
    boolean _switchResult = false;
    Resource _eResource = ctx.eResource();
    final Resource res = _eResource;
    boolean _matched = false;
    if (res instanceof StorageAwareResource) {
      _matched=true;
      _switchResult = ((StorageAwareResource)res).isLoadedFromStorage();
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }

  protected Object _internalEvaluate(final XFeatureCall it, final Context ctx) {
    Object _eGet = it.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, this.isResolveProxies(it));
    final EObject feature = ((EObject) _eGet);
    boolean _eIsProxy = feature.eIsProxy();
    boolean _not = (!_eIsProxy);
    if (_not) {
      Object _switchResult = null;
      boolean _matched = false;
      if (feature instanceof JvmEnumerationLiteral) {
        _matched=true;
        _switchResult = feature;
      }
      if (!_matched) {
        if (feature instanceof JvmField) {
          _matched=true;
          _switchResult = this.evaluateField(it, ((JvmField)feature), ctx);
        }
      }
      if (!_matched) {
        if (feature instanceof JvmType) {
          _matched=true;
          _switchResult = this.toTypeReference(((JvmType)feature), 0);
        }
      }
      return _switchResult;
    }
    final String featureName = it.getConcreteSyntaxFeatureName();
    JvmType _switchResult_1 = null;
    JvmTypeReference _expectedType = ctx.getExpectedType();
    final JvmTypeReference it_1 = _expectedType;
    boolean _matched_1 = false;
    if (it_1 instanceof XComputedTypeReferenceImplCustom) {
      boolean _isEquivalentComputed = ((XComputedTypeReferenceImplCustom)it_1).isEquivalentComputed();
      if (_isEquivalentComputed) {
        _matched_1=true;
        _switchResult_1 = ((XComputedTypeReferenceImplCustom)it_1).getType();
      }
    }
    if (!_matched_1) {
      if (it_1 instanceof XComputedTypeReference) {
        _matched_1=true;
      }
      if (!_matched_1) {
        if ((it_1 == null)) {
          _matched_1=true;
        }
      }
      if (_matched_1) {
        _switchResult_1 = null;
      }
    }
    if (!_matched_1) {
      _switchResult_1 = it_1.getType();
    }
    final JvmType expectedRawType = _switchResult_1;
    Map<String, JvmIdentifiableElement> _xifexpression = null;
    boolean _isEnumExpectationInAnnotationValue = this.isEnumExpectationInAnnotationValue(it, expectedRawType);
    if (_isEnumExpectationInAnnotationValue) {
      HashMap<String, JvmIdentifiableElement> _xblockexpression = null;
      {
        JvmEnumerationType _switchResult_2 = null;
        boolean _matched_2 = false;
        if (expectedRawType instanceof JvmEnumerationType) {
          _matched_2=true;
          _switchResult_2 = ((JvmEnumerationType)expectedRawType);
        }
        if (!_matched_2) {
          if (expectedRawType instanceof JvmArrayType) {
            _matched_2=true;
            JvmComponentType _componentType = ((JvmArrayType)expectedRawType).getComponentType();
            _switchResult_2 = ((JvmEnumerationType) _componentType);
          }
        }
        final JvmEnumerationType enumType = _switchResult_2;
        Map<String, JvmIdentifiableElement> _visibleFeatures = ctx.getVisibleFeatures();
        final HashMap<String, JvmIdentifiableElement> copy = new HashMap<String, JvmIdentifiableElement>(_visibleFeatures);
        final Consumer<JvmEnumerationLiteral> _function = (JvmEnumerationLiteral it_2) -> {
          copy.put(it_2.getSimpleName(), it_2);
        };
        enumType.getLiterals().forEach(_function);
        _xblockexpression = copy;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = ctx.getVisibleFeatures();
    }
    final Map<String, JvmIdentifiableElement> visibleFeatures = _xifexpression;
    boolean _containsKey = visibleFeatures.containsKey(featureName);
    if (_containsKey) {
      Object _switchResult_2 = null;
      JvmIdentifiableElement _get = visibleFeatures.get(featureName);
      final JvmIdentifiableElement visibleFeature = _get;
      boolean _matched_2 = false;
      if (visibleFeature instanceof JvmEnumerationLiteral) {
        _matched_2=true;
        JvmEnumerationLiteral _xblockexpression_1 = null;
        {
          this.resolveFeature(it, visibleFeature);
          _xblockexpression_1 = ((JvmEnumerationLiteral)visibleFeature);
        }
        _switchResult_2 = _xblockexpression_1;
      }
      if (!_matched_2) {
        if (visibleFeature instanceof JvmField) {
          _matched_2=true;
          Object _xblockexpression_1 = null;
          {
            this.resolveFeature(it, visibleFeature);
            _xblockexpression_1 = this.evaluateField(it, ((JvmField)visibleFeature), ctx);
          }
          _switchResult_2 = _xblockexpression_1;
        }
      }
      return _switchResult_2;
    }
    final JvmType type = this.findTypeByName(it, featureName);
    if ((type != null)) {
      this.resolveType(it, type);
      return this.toTypeReference(type, 0);
    }
    throw new UnresolvableFeatureException(("Couldn\'t resolve feature " + featureName), it);
  }

  private boolean isEnumExpectationInAnnotationValue(final XFeatureCall it, final JvmType expectedRawType) {
    if (((expectedRawType instanceof JvmEnumerationType) || ((expectedRawType instanceof JvmArrayType) && (((JvmArrayType) expectedRawType).getComponentType() instanceof JvmEnumerationType)))) {
      EObject container = it.eContainer();
      if ((container instanceof XAnnotationElementValuePair)) {
        return true;
      }
      if ((container instanceof XAnnotation)) {
        return true;
      }
      if ((container instanceof XListLiteral)) {
        container = ((XListLiteral)container).eContainer();
        if ((container instanceof XAnnotationElementValuePair)) {
          return true;
        }
        if ((container instanceof XAnnotation)) {
          return true;
        }
      }
    }
    return false;
  }

  protected Object _internalEvaluate(final XMemberFeatureCall it, final Context ctx) {
    Object _eGet = it.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, this.isResolveProxies(it));
    final EObject feature = ((EObject) _eGet);
    boolean _eIsProxy = feature.eIsProxy();
    boolean _not = (!_eIsProxy);
    if (_not) {
      Object _switchResult = null;
      boolean _matched = false;
      if (feature instanceof JvmEnumerationLiteral) {
        _matched=true;
        _switchResult = feature;
      }
      if (!_matched) {
        if (feature instanceof JvmField) {
          _matched=true;
          _switchResult = this.evaluateField(it, ((JvmField)feature), ctx);
        }
      }
      if (!_matched) {
        if (feature instanceof JvmType) {
          _matched=true;
          _switchResult = this.toTypeReference(((JvmType)feature), 0);
        }
      }
      return _switchResult;
    }
    final String featureName = it.getConcreteSyntaxFeatureName();
    try {
      final Object receiver = this.evaluate(it.getMemberCallTarget(), ctx);
      boolean _matched_1 = false;
      if (receiver instanceof JvmTypeReference) {
        _matched_1=true;
        JvmType _type = ((JvmTypeReference)receiver).getType();
        final JvmType type = _type;
        boolean _matched_2 = false;
        if (type instanceof JvmEnumerationType) {
          _matched_2=true;
          final Function1<JvmEnumerationLiteral, Boolean> _function = (JvmEnumerationLiteral it_1) -> {
            String _simpleName = it_1.getSimpleName();
            return Boolean.valueOf(Objects.equal(_simpleName, featureName));
          };
          final JvmEnumerationLiteral enumValue = IterableExtensions.<JvmEnumerationLiteral>findFirst(((JvmEnumerationType)type).getLiterals(), _function);
          if ((enumValue == null)) {
            String _simpleName = ((JvmTypeReference)receiver).getSimpleName();
            String _plus = ((("Couldn\'t find enum value " + featureName) + " on enum ") + _simpleName);
            throw new ConstantExpressionEvaluationException(_plus, it);
          }
          this.resolveFeature(it, enumValue);
          return enumValue;
        }
        if (!_matched_2) {
          if (type instanceof JvmGenericType) {
            _matched_2=true;
            final Function1<JvmField, Boolean> _function = (JvmField it_1) -> {
              String _simpleName = it_1.getSimpleName();
              return Boolean.valueOf(Objects.equal(_simpleName, featureName));
            };
            final JvmField field = IterableExtensions.<JvmField>findFirst(Iterables.<JvmField>filter(((JvmGenericType)type).getAllFeatures(), JvmField.class), _function);
            if ((field == null)) {
              String _simpleName = ((JvmTypeReference)receiver).getSimpleName();
              String _plus = ((("Couldn\'t find field " + featureName) + " on type ") + _simpleName);
              throw new ConstantExpressionEvaluationException(_plus, it);
            }
            this.resolveFeature(it, field);
            return this.evaluateField(it, field, ctx);
          }
        }
      }
      throw new UnresolvableFeatureException(((("Unresolvable feature " + featureName) + " on ") + receiver), it);
    } catch (final Throwable _t) {
      if (_t instanceof UnresolvableFeatureException) {
        final String typeName = this.getFullName(it);
        final JvmType type = this.findTypeByName(it, typeName);
        if ((type != null)) {
          this.resolveType(it, type);
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
    final String prefix = this.getFullName(call.getMemberCallTarget());
    String _concreteSyntaxFeatureName = call.getConcreteSyntaxFeatureName();
    return ((prefix + ".") + _concreteSyntaxFeatureName);
  }

  protected String _getFullName(final XFeatureCall call) {
    return call.getConcreteSyntaxFeatureName();
  }

  protected Object evaluateField(final XAbstractFeatureCall call, final JvmField field, final Context context) {
    if ((field.isSetConstant() || (field.eResource() instanceof TypeResource))) {
      boolean _isConstant = field.isConstant();
      if (_isConstant) {
        return field.getConstantValue();
      } else {
        String _simpleName = field.getDeclaringType().getSimpleName();
        String _plus = ("Field " + _simpleName);
        String _plus_1 = (_plus + ".");
        String _simpleName_1 = field.getSimpleName();
        String _plus_2 = (_plus_1 + _simpleName_1);
        String _plus_3 = (_plus_2 + " is not a constant");
        throw new ConstantExpressionEvaluationException(_plus_3);
      }
    }
    final XExpression expression = this.containerProvider.getAssociatedExpression(field);
    boolean _contains = context.getAlreadyEvaluating().contains(expression);
    if (_contains) {
      throw new ConstantExpressionEvaluationException("Endless recursive evaluation detected.");
    }
    try {
      final Map<String, JvmIdentifiableElement> visibleFeatures = this.findVisibleFeatures(expression);
      JvmTypeReference _type = field.getType();
      ClassFinder _classFinder = context.getClassFinder();
      Set<XExpression> _alreadyEvaluating = context.getAlreadyEvaluating();
      final Context ctx = new Context(_type, _classFinder, visibleFeatures, _alreadyEvaluating);
      return this.evaluate(expression, ctx);
    } catch (final Throwable _t) {
      if (_t instanceof ConstantExpressionEvaluationException) {
        final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
        throw new StackedConstantExpressionEvaluationException(call, field, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  protected Class<?> getJavaType(final JvmType type, final ClassFinder classFinder) throws ClassNotFoundException {
    if ((type instanceof JvmArrayType)) {
      JvmType t = type;
      String dimensions = "";
      while ((t instanceof JvmArrayType)) {
        {
          dimensions = (dimensions + "[]");
          t = ((JvmArrayType)t).getComponentType();
        }
      }
      final Class<?> componentClass = this.getJavaType(t, classFinder);
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
    return classFinder.forName(type.getIdentifier());
  }

  protected void resolveType(final XAbstractFeatureCall featureCall, final JvmIdentifiableElement feature) {
    new TypeLiteralLinkingCandidateResolver(featureCall).resolveLinkingProxy(((InternalEObject) featureCall), feature, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
  }

  protected void resolveFeature(final XAbstractFeatureCall featureCall, final JvmIdentifiableElement feature) {
    new PendingLinkingCandidateResolver<XAbstractFeatureCall>(featureCall).resolveLinkingProxy(((InternalEObject) featureCall), feature, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
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
    } else if (it == null) {
      return _internalEvaluate((Void)null, ctx);
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

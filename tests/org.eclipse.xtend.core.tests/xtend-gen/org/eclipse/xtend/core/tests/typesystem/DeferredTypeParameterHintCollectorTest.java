/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.tests.typesystem.MockTypeParameterSubstitutor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class DeferredTypeParameterHintCollectorTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private Provider<DefaultReentrantTypeResolver> resolverProvider;
  
  private ListMultimap<Object, LightweightBoundTypeArgument> hints = Multimaps2.<Object, LightweightBoundTypeArgument>newLinkedHashListMultimap();
  
  public JvmOperation operation(final String typeParameters, final String expectedType, final String actualType) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def <");
      _builder.append(typeParameters, "");
      _builder.append("> void method(");
      _builder.append(expectedType, "");
      _builder.append(" expected, ");
      _builder.append(actualType, "");
      _builder.append(" actual) {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      return operation;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> in(final String typeParameters, final String expectedType, final String actualType) {
    final JvmOperation operation = this.operation(typeParameters, expectedType, actualType);
    ITypeReferenceOwner _owner = this.getOwner();
    final DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(_owner);
    final DefaultReentrantTypeResolver resolver = this.resolverProvider.get();
    EObject _rootContainer = EcoreUtil.getRootContainer(operation);
    resolver.initializeFrom(_rootContainer);
    ITypeReferenceOwner _owner_1 = this.getOwner();
    PublicResolvedTypes _publicResolvedTypes = new PublicResolvedTypes(resolver);
    final MockTypeParameterSubstitutor substitutor = new MockTypeParameterSubstitutor(_owner_1, _publicResolvedTypes);
    EList<JvmFormalParameter> _parameters = operation.getParameters();
    JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
    JvmTypeReference _parameterType = _head.getParameterType();
    LightweightTypeReference _lightweightTypeReference = this.toLightweightTypeReference(_parameterType);
    final LightweightTypeReference hasUnbounds = substitutor.substitute(_lightweightTypeReference);
    EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
    JvmFormalParameter _last = IterableExtensions.<JvmFormalParameter>last(_parameters_1);
    JvmTypeReference _parameterType_1 = _last.getParameterType();
    final LightweightTypeReference isActual = this.toLightweightTypeReference(_parameterType_1);
    collector.processPairedReferences(hasUnbounds, isActual);
    return substitutor.getTypeParameterMapping();
  }
  
  public List<LightweightBoundTypeArgument> hasHintsFor(final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        LightweightMergedBoundTypeArgument _get = mapping.get(key);
        LightweightTypeReference _typeReference = _get.getTypeReference();
        final UnboundTypeReference unbound = ((UnboundTypeReference) _typeReference);
        List<LightweightBoundTypeArgument> _allHints = unbound.getAllHints();
        for (final LightweightBoundTypeArgument it : _allHints) {
          BoundTypeArgumentSource _source = it.getSource();
          Assert.assertEquals(BoundTypeArgumentSource.INFERRED_LATER, _source);
        }
        return unbound.getAllHints();
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("No mapping for ");
    _builder.append(typeParamName, "");
    _builder.append(" in ");
    Set<JvmTypeParameter> _keySet = mapping.keySet();
    final Function1<JvmTypeParameter, String> _function = new Function1<JvmTypeParameter, String>() {
      @Override
      public String apply(final JvmTypeParameter it) {
        return it.getSimpleName();
      }
    };
    Iterable<String> _map = IterableExtensions.<JvmTypeParameter, String>map(_keySet, _function);
    _builder.append(_map, "");
    String _string = _builder.toString();
    Assert.fail(_string);
    return null;
  }
  
  public void hasNoHintsFor(final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        LightweightMergedBoundTypeArgument _get = mapping.get(key);
        LightweightTypeReference _typeReference = _get.getTypeReference();
        final UnboundTypeReference unbound = ((UnboundTypeReference) _typeReference);
        List<LightweightBoundTypeArgument> _allHints = unbound.getAllHints();
        boolean _isEmpty = _allHints.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Unexpected mapping for ");
          _builder.append(typeParamName, "");
          _builder.append(" in ");
          Set<JvmTypeParameter> _keySet = mapping.keySet();
          final Function1<JvmTypeParameter, String> _function = new Function1<JvmTypeParameter, String>() {
            @Override
            public String apply(final JvmTypeParameter it) {
              return it.getSimpleName();
            }
          };
          Iterable<String> _map = IterableExtensions.<JvmTypeParameter, String>map(_keySet, _function);
          _builder.append(_map, "");
          String _string = _builder.toString();
          Assert.fail(_string);
        }
      }
    }
  }
  
  public List<LightweightBoundTypeArgument> like(final List<LightweightBoundTypeArgument> mappingData, final Triple<String, VarianceInfo, VarianceInfo>... mappedTypes) {
    final Function1<LightweightBoundTypeArgument, String> _function = new Function1<LightweightBoundTypeArgument, String>() {
      @Override
      public String apply(final LightweightBoundTypeArgument it) {
        StringConcatenation _builder = new StringConcatenation();
        LightweightTypeReference _typeReference = it.getTypeReference();
        String _string = _typeReference.toString();
        _builder.append(_string, "");
        _builder.append("(");
        VarianceInfo _declaredVariance = it.getDeclaredVariance();
        _builder.append(_declaredVariance, "");
        _builder.append("/");
        VarianceInfo _actualVariance = it.getActualVariance();
        _builder.append(_actualVariance, "");
        _builder.append(")");
        return _builder.toString();
      }
    };
    List<String> _map = ListExtensions.<LightweightBoundTypeArgument, String>map(mappingData, _function);
    String _string = _map.toString();
    int _size = ((List<Triple<String, VarianceInfo, VarianceInfo>>)Conversions.doWrapArray(mappedTypes)).size();
    int _size_1 = mappingData.size();
    Assert.assertEquals(_string, _size, _size_1);
    List<Triple<String, VarianceInfo, VarianceInfo>> _list = IterableExtensions.<Triple<String, VarianceInfo, VarianceInfo>>toList(((Iterable<Triple<String, VarianceInfo, VarianceInfo>>)Conversions.doWrapArray(mappedTypes)));
    final Function1<LightweightBoundTypeArgument, Triple<String, VarianceInfo, VarianceInfo>> _function_1 = new Function1<LightweightBoundTypeArgument, Triple<String, VarianceInfo, VarianceInfo>>() {
      @Override
      public Triple<String, VarianceInfo, VarianceInfo> apply(final LightweightBoundTypeArgument it) {
        LightweightTypeReference _typeReference = it.getTypeReference();
        String _string = _typeReference.toString();
        VarianceInfo _declaredVariance = it.getDeclaredVariance();
        VarianceInfo _actualVariance = it.getActualVariance();
        return Tuples.<String, VarianceInfo, VarianceInfo>create(_string, _declaredVariance, _actualVariance);
      }
    };
    List<Triple<String, VarianceInfo, VarianceInfo>> _map_1 = ListExtensions.<LightweightBoundTypeArgument, Triple<String, VarianceInfo, VarianceInfo>>map(mappingData, _function_1);
    List<Triple<String, VarianceInfo, VarianceInfo>> _list_1 = IterableExtensions.<Triple<String, VarianceInfo, VarianceInfo>>toList(_map_1);
    Assert.assertEquals(((Object) _list), _list_1);
    return mappingData;
  }
  
  @Override
  protected StandardTypeReferenceOwner createOwner() {
    CommonTypeComputationServices _services = this.getServices();
    ResourceSet _contextResourceSet = this.getContextResourceSet();
    return new StandardTypeReferenceOwner(_services, _contextResourceSet) {
      @Override
      public void acceptHint(final Object handle, final LightweightBoundTypeArgument boundTypeArgument) {
        DeferredTypeParameterHintCollectorTest.this.hints.put(handle, boundTypeArgument);
      }
      
      @Override
      public List<LightweightBoundTypeArgument> getAllHints(final Object handle) {
        return DeferredTypeParameterHintCollectorTest.this.hints.get(handle);
      }
      
      @Override
      public boolean isResolved(final Object handle) {
        return false;
      }
    };
  }
  
  public Triple<String, VarianceInfo, VarianceInfo> operator_mappedTo(final Pair<String, VarianceInfo> pair, final VarianceInfo third) {
    String _key = pair.getKey();
    VarianceInfo _value = pair.getValue();
    return Tuples.<String, VarianceInfo, VarianceInfo>create(_key, _value, third);
  }
  
  @Test
  public void testDirectUnboundExpectation() {
    Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _in = this.in("T", "T", "String");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_01() {
    Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _in = this.in("T", "Iterable<T>", "java.util.List<String>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_02() {
    Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _in = this.in("T", "Iterable<? extends T>", "java.util.List<String>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_03() {
    Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _in = this.in("T", "Iterable<? super T>", "java.util.List<String>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testUsedTwice() {
    Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _in = this.in("T", "java.util.Map<T, T>", "com.google.common.collect.BiMap<CharSequence, Integer>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String, VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testDependsOnOther() {
    Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _in = this.in("T, V", "java.util.Map<T, String>", "java.util.Map<V, Integer>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("V", VarianceInfo.INVARIANT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testUnusedExpectation_01() {
    Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _in = this.in("T", "Iterable<T>", "String");
    this.hasNoHintsFor(_in, "T");
  }
  
  @Test
  public void testUnusedExpectation_02() {
    Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _in = this.in("T", "String", "Iterable<T>");
    this.hasNoHintsFor(_in, "T");
  }
}

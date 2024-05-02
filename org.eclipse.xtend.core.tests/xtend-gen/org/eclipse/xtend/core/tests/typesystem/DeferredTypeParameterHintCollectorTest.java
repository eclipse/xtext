/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
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
      _builder.append(typeParameters);
      _builder.append("> void method(");
      _builder.append(expectedType);
      _builder.append(" expected, ");
      _builder.append(actualType);
      _builder.append(" actual) {}");
      final String signature = _builder.toString();
      final XtendFunction function = this.function(signature.toString());
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
    resolver.initializeFrom(EcoreUtil.getRootContainer(operation));
    ITypeReferenceOwner _owner_1 = this.getOwner();
    PublicResolvedTypes _publicResolvedTypes = new PublicResolvedTypes(resolver);
    final MockTypeParameterSubstitutor substitutor = new MockTypeParameterSubstitutor(_owner_1, _publicResolvedTypes);
    final LightweightTypeReference hasUnbounds = substitutor.substitute(this.toLightweightTypeReference(IterableExtensions.<JvmFormalParameter>head(operation.getParameters()).getParameterType()));
    final LightweightTypeReference isActual = this.toLightweightTypeReference(IterableExtensions.<JvmFormalParameter>lastOrNull(operation.getParameters()).getParameterType());
    collector.processPairedReferences(hasUnbounds, isActual);
    return substitutor.getTypeParameterMapping();
  }

  public List<LightweightBoundTypeArgument> hasHintsFor(final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equals(_simpleName, typeParamName);
      if (_equals) {
        LightweightTypeReference _typeReference = mapping.get(key).getTypeReference();
        final UnboundTypeReference unbound = ((UnboundTypeReference) _typeReference);
        final Consumer<LightweightBoundTypeArgument> _function = (LightweightBoundTypeArgument it) -> {
          Assert.assertEquals(BoundTypeArgumentSource.INFERRED_LATER, it.getSource());
        };
        unbound.getAllHints().forEach(_function);
        return unbound.getAllHints();
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("No mapping for ");
    _builder.append(typeParamName);
    _builder.append(" in ");
    final Function1<JvmTypeParameter, String> _function_1 = (JvmTypeParameter it) -> {
      return it.getSimpleName();
    };
    Iterable<String> _map = IterableExtensions.<JvmTypeParameter, String>map(mapping.keySet(), _function_1);
    _builder.append(_map);
    Assert.fail(_builder.toString());
    return null;
  }

  public void hasNoHintsFor(final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equals(_simpleName, typeParamName);
      if (_equals) {
        LightweightTypeReference _typeReference = mapping.get(key).getTypeReference();
        final UnboundTypeReference unbound = ((UnboundTypeReference) _typeReference);
        boolean _isEmpty = unbound.getAllHints().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Unexpected mapping for ");
          _builder.append(typeParamName);
          _builder.append(" in ");
          final Function1<JvmTypeParameter, String> _function = (JvmTypeParameter it) -> {
            return it.getSimpleName();
          };
          Iterable<String> _map = IterableExtensions.<JvmTypeParameter, String>map(mapping.keySet(), _function);
          _builder.append(_map);
          Assert.fail(_builder.toString());
        }
      }
    }
  }

  public List<LightweightBoundTypeArgument> like(final List<LightweightBoundTypeArgument> mappingData, final Triple<String, VarianceInfo, VarianceInfo>... mappedTypes) {
    final Function1<LightweightBoundTypeArgument, String> _function = (LightweightBoundTypeArgument it) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _string = it.getTypeReference().toString();
      _builder.append(_string);
      _builder.append("(");
      VarianceInfo _declaredVariance = it.getDeclaredVariance();
      _builder.append(_declaredVariance);
      _builder.append("/");
      VarianceInfo _actualVariance = it.getActualVariance();
      _builder.append(_actualVariance);
      _builder.append(")");
      return _builder.toString();
    };
    Assert.assertEquals(ListExtensions.<LightweightBoundTypeArgument, String>map(mappingData, _function).toString(), ((List<Triple<String, VarianceInfo, VarianceInfo>>)Conversions.doWrapArray(mappedTypes)).size(), mappingData.size());
    List<Triple<String, VarianceInfo, VarianceInfo>> _list = IterableExtensions.<Triple<String, VarianceInfo, VarianceInfo>>toList(((Iterable<Triple<String, VarianceInfo, VarianceInfo>>)Conversions.doWrapArray(mappedTypes)));
    final Function1<LightweightBoundTypeArgument, Triple<String, VarianceInfo, VarianceInfo>> _function_1 = (LightweightBoundTypeArgument it) -> {
      return Tuples.<String, VarianceInfo, VarianceInfo>create(it.getTypeReference().toString(), it.getDeclaredVariance(), it.getActualVariance());
    };
    Assert.assertEquals(((Object) _list), IterableExtensions.<Triple<String, VarianceInfo, VarianceInfo>>toList(ListExtensions.<LightweightBoundTypeArgument, Triple<String, VarianceInfo, VarianceInfo>>map(mappingData, _function_1)));
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
    return Tuples.<String, VarianceInfo, VarianceInfo>create(pair.getKey(), pair.getValue(), third);
  }

  @Test
  public void testDirectUnboundExpectation() {
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(this.in("T", "T", "String"), "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.like(_hasHintsFor, _mappedTo_1);
  }

  @Test
  public void testNestedUnboundExpectation_01() {
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(this.in("T", "Iterable<T>", "java.util.List<String>"), "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }

  @Test
  public void testNestedUnboundExpectation_02() {
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(this.in("T", "Iterable<? extends T>", "java.util.List<String>"), "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }

  @Test
  public void testNestedUnboundExpectation_03() {
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(this.in("T", "Iterable<? super T>", "java.util.List<String>"), "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }

  @Test
  public void testUsedTwice() {
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(this.in("T", "java.util.Map<T, T>", "com.google.common.collect.BiMap<CharSequence, Integer>"), "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String, VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1, _mappedTo_3);
  }

  @Test
  public void testDependsOnOther() {
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(this.in("T, V", "java.util.Map<T, String>", "java.util.Map<V, Integer>"), "T");
    Pair<String, VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("V", VarianceInfo.INVARIANT);
    Triple<String, VarianceInfo, VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }

  @Test
  public void testUnusedExpectation_01() {
    this.hasNoHintsFor(this.in("T", "Iterable<T>", "String"), "T");
  }

  @Test
  public void testUnusedExpectation_02() {
    this.hasNoHintsFor(this.in("T", "String", "Iterable<T>"), "T");
  }
}

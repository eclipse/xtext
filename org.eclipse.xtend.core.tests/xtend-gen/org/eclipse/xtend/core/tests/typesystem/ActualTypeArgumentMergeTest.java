/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class ActualTypeArgumentMergeTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;

  @Inject
  private BoundTypeArgumentMerger merger;

  public Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> mappedBy(final String typeParameters, final String... alternatingTypeReferences) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(typeParameters);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          _builder.append(typeParameters);
          _builder.append(">");
        }
      }
      _builder.append(" void method(");
      final Function1<String, CharSequence> _function = (String it) -> {
        return it;
      };
      String _join = IterableExtensions.<String>join(((Iterable<String>)Conversions.doWrapArray(alternatingTypeReferences)), null, " p, ", " p", _function);
      _builder.append(_join);
      _builder.append(") {}");
      final String signature = _builder.toString();
      final XtendFunction function = this.function(signature.toString());
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmTypeParameter> _typeParameters = operation.getTypeParameters();
      ITypeReferenceOwner _owner = this.getOwner();
      final ActualTypeArgumentCollector collector = new ActualTypeArgumentCollector(_typeParameters, BoundTypeArgumentSource.INFERRED, _owner);
      int _size = ((List<String>)Conversions.doWrapArray(alternatingTypeReferences)).size();
      int _minus = (_size - 1);
      IntegerRange _withStep = new IntegerRange(0, _minus).withStep(2);
      for (final Integer i : _withStep) {
        collector.populateTypeParameterMapping(this.toLightweightTypeReference(operation.getParameters().get((i).intValue()).getParameterType()), this.toLightweightTypeReference(operation.getParameters().get(((i).intValue() + 1)).getParameterType()));
      }
      return collector.getTypeParameterMapping();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> merge(final Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equals(_simpleName, typeParamName);
      if (_equals) {
        final List<LightweightBoundTypeArgument> mappingData = mapping.get(key);
        LightweightMergedBoundTypeArgument _merge = this.merger.merge(mappingData, this.getOwner());
        return Pair.<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument>of(mapping, _merge);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("No mapping for ");
    _builder.append(typeParamName);
    _builder.append(" in ");
    final Function1<JvmTypeParameter, String> _function = (JvmTypeParameter it) -> {
      return it.getSimpleName();
    };
    Iterable<String> _map = IterableExtensions.<JvmTypeParameter, String>map(mapping.keySet(), _function);
    _builder.append(_map);
    Assert.fail(_builder.toString());
    return null;
  }

  public Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> to(final Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> merged, final String type, final VarianceInfo variance) {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _xblockexpression = null;
    {
      if ((type == null)) {
        Assert.assertNull(merged.getValue());
      } else {
        Assert.assertEquals(type, merged.getValue().getTypeReference().toString());
        Assert.assertEquals(variance, merged.getValue().getVariance());
      }
      _xblockexpression = merged.getKey();
    }
    return _xblockexpression;
  }

  @Test
  public void testUnusedParam() {
    this.to(this.merge(this.mappedBy("T", "CharSequence", "String"), "T"), "Object", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnusedParams_01() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T, T2", "CharSequence", "String"), "T"), "Object", VarianceInfo.INVARIANT), "T2"), "Object", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnusedParams_02() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T extends CharSequence, T2", "CharSequence", "String"), "T"), "CharSequence", VarianceInfo.INVARIANT), "T2"), "Object", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnusedParams_03() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T extends CharSequence, T2 extends T", "CharSequence", "String"), "T"), "CharSequence", VarianceInfo.INVARIANT), "T2"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnusedParams_04() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T extends T2, T2", "CharSequence", "String"), "T"), "Object", VarianceInfo.INVARIANT), "T2"), "Object", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnusedParams_05() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T extends T2, T2 extends CharSequence", "CharSequence", "String"), "T"), "Object", VarianceInfo.INVARIANT), "T2"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnambiguousMapping_01() {
    this.to(this.merge(this.mappedBy("T", "java.util.List<T>", "java.util.List<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnambiguousMapping_02() {
    this.to(this.merge(this.mappedBy("T", "java.util.Map<T, T>", "java.util.Map<String, String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnambiguousMapping_03() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("K, V", "java.util.Map<K, V>", "java.util.Map<String, Integer>"), "K"), "String", VarianceInfo.INVARIANT), "V"), "Integer", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnambiguousMapping_04() {
    this.to(this.merge(this.mappedBy("T", "T", "CharSequence", "T", "CharSequence"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUnambiguousMapping_05() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T, T2", "T", "CharSequence", "T2", "CharSequence"), "T"), "CharSequence", VarianceInfo.INVARIANT), "T2"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_01() {
    this.to(this.merge(this.mappedBy("T", "T", "CharSequence", "T", "String"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_02() {
    this.to(this.merge(this.mappedBy("T", "T", "String", "T", "CharSequence"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_03() {
    this.to(this.merge(this.mappedBy("T", "T", "String", "Iterable<T>", "Iterable<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_04() {
    this.to(this.merge(this.mappedBy("T", "T", "String", "Iterable<T>", "Iterable<CharSequence>"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_05() {
    this.to(this.merge(this.mappedBy("T", "T", "CharSequence", "Iterable<T>", "Iterable<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_06() {
    this.to(this.merge(this.mappedBy("T", "Iterable<T>", "Iterable<CharSequence>", "Iterable<T>", "Iterable<String>"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_07() {
    this.to(this.merge(this.mappedBy("T", "Iterable<T>", "Iterable<String>", "Iterable<T>", "Iterable<CharSequence>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_08() {
    this.to(this.merge(this.mappedBy("T", "Iterable<T>", "Iterable<? extends CharSequence>", "Iterable<T>", "Iterable<? extends CharSequence>"), "T"), "CharSequence", null);
  }

  @Test
  public void testUsedTwice_09() {
    this.to(this.merge(this.mappedBy("T", "T", "String", "Iterable<T>", "Iterable<? extends CharSequence>"), "T"), "CharSequence", null);
  }

  @Test
  public void testUsedTwice_10() {
    this.to(this.merge(this.mappedBy("T", "T", "CharSequence", "Iterable<? extends T>", "Iterable<String>"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_11() {
    this.to(this.merge(this.mappedBy("T", "T", "CharSequence", "Iterable<? super T>", "Iterable<String>"), "T"), "CharSequence", null);
  }

  @Test
  public void testUsedTwice_12() {
    this.to(this.merge(this.mappedBy("T", "T", "String", "Iterable<? super T>", "Iterable<CharSequence>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_13() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? super T>", "Iterable<String>", "Iterable<? super T>", "Iterable<CharSequence>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUsedTwice_14() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? super T>", "Iterable<CharSequence>", "Iterable<? super T>", "Iterable<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testBestEffortMapping_01() {
    this.to(this.merge(this.mappedBy("T", "java.util.List<T>", "java.util.Set<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testBestEffortMapping_02() {
    this.to(this.merge(this.mappedBy("T", "java.util.ArrayList<T>", "java.util.HashSet<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testBestEffortMapping_03() {
    this.to(this.merge(this.mappedBy("T", "java.util.ArrayList<T>", "Iterable<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testBestEffortMapping_04() {
    this.to(this.merge(this.mappedBy("T", "java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>", "java.util.Map<Iterable<String>, java.util.HashSet<Integer>>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testBestEffortMapping_05() {
    this.to(this.merge(this.mappedBy("T", "java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>", "java.util.Map<Iterable<Integer>, java.util.HashSet<String>>"), "T"), "Integer", VarianceInfo.INVARIANT);
  }

  @Test
  public void testBestEffortMapping_06() {
    this.to(this.merge(this.mappedBy("T", "org.eclipse.xtend.core.tests.typesystem.MapType<T>", "java.util.HashMap<String, Integer>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testBestEffortMapping_07() {
    this.to(this.merge(this.mappedBy("T", "org.eclipse.xtend.core.tests.typesystem.MapType<T>", "java.util.HashMap<Integer, String>"), "T"), "Integer", VarianceInfo.INVARIANT);
  }

  @Test
  public void testInheritanceMapping_01() {
    this.to(this.merge(this.mappedBy("E", "Iterable<E>", "java.util.ArrayList<String>"), "E"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testInheritanceMapping_02() {
    this.to(this.merge(this.mappedBy("C", "Comparable<C>", "String"), "C"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testMappedGenericType_01() {
    this.to(this.merge(this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<String>>"), "T"), "Iterable<String>", VarianceInfo.INVARIANT);
  }

  @Test
  public void testMappedArray_01() {
    this.to(this.merge(this.mappedBy("T", "T[]", "String[]"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testMappedArray_02() {
    this.to(this.merge(this.mappedBy("T", "T[]", "String[][]"), "T"), "String[]", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUpperBound_01() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? extends T>", "Iterable<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUpperBound_02() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? extends T>", "Iterable<? extends String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUpperBound_03() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? extends T>", "Iterable<? super String>"), "T"), "Object", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUpperBound_04() {
    this.to(this.merge(this.mappedBy("T", "Iterable<T>", "Iterable<? extends String>"), "T"), "String", VarianceInfo.OUT);
  }

  @Test
  public void testUpperBound_05() {
    this.to(this.merge(this.mappedBy("T", "Iterable<Iterable<T>>", "Iterable<Iterable<? extends CharSequence>>"), "T"), "CharSequence", VarianceInfo.OUT);
  }

  @Test
  public void testUpperBound_06() {
    this.to(this.merge(this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<? extends CharSequence>>"), "T"), "Iterable<? extends CharSequence>", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUpperBound_07() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<Iterable<? extends CharSequence>>"), "T"), "CharSequence", VarianceInfo.OUT);
  }

  @Test
  public void testUpperBound_08() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<Iterable<CharSequence>>"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUpperBound_09() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<? extends Iterable<CharSequence>>"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUpperBound_10() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<? super Iterable<CharSequence>>"), "T"), "CharSequence", VarianceInfo.INVARIANT);
  }

  @Test
  public void testUpperBound_11() {
    boolean _isJava12OrLater = JavaRuntimeVersion.isJava12OrLater();
    if (_isJava12OrLater) {
      this.to(this.merge(this.mappedBy("T", "java.util.Map<? extends T, ? extends T>", "java.util.Map<String, Integer>"), "T"), "Comparable<?> & Constable & ConstantDesc & Serializable", VarianceInfo.INVARIANT);
    } else {
      this.to(this.merge(this.mappedBy("T", "java.util.Map<? extends T, ? extends T>", "java.util.Map<String, Integer>"), "T"), "Comparable<?> & Serializable", VarianceInfo.INVARIANT);
    }
  }

  @Test
  public void testLowerBound_01() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? super T>", "Iterable<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testLowerBound_02() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? super T>", "Iterable<? super String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testLowerBound_03() {
    this.to(this.merge(this.mappedBy("T", "Iterable<? super T>", "Iterable<? extends String>"), "T"), "String", null);
  }

  @Test
  public void testLowerBound_04() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T, T2 extends T", "Iterable<? super T>", "Iterable<? extends String>"), "T"), "String", null), "T2"), "String", null);
  }

  @Test
  public void testLowerBound_05() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T, T2 extends T", "java.util.Map<? super T, T>", "java.util.Map<? extends String, Integer>"), "T"), "Integer", null), "T2"), "Integer", null);
  }

  @Test
  public void testLowerBound_06() {
    this.to(this.merge(this.mappedBy("T", "Iterable<T>", "Iterable<? super String>"), "T"), "String", VarianceInfo.IN);
  }

  @Test
  public void testLowerBound_07() {
    this.to(this.merge(this.mappedBy("T", "Iterable<Iterable<T>>", "java.util.LinkedList<Iterable<? super String>>"), "T"), "String", VarianceInfo.IN);
  }

  @Test
  public void testLowerBound_08() {
    this.to(this.merge(this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<? super String>>"), "T"), "Iterable<? super String>", VarianceInfo.INVARIANT);
  }

  @Test
  public void testLowerBound_09() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T extends T2, T2", "Iterable<? super T2>", "Iterable<? extends String>"), "T"), "String", null), "T2"), "String", null);
  }

  @Test
  public void testDependentTypeParams_01() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T extends CharSequence, T2 extends T", "java.util.Map<T, T2>", "java.util.Map<String, String>"), "T"), "String", VarianceInfo.INVARIANT), "T2"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testDependentTypeParams_02() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T, T2 extends T", "Iterable<T>", "Iterable<String>"), "T"), "String", VarianceInfo.INVARIANT), "T2"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testDependentTypeParams_03() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T extends T2, T2 extends CharSequence", "Iterable<T2>", "Iterable<String>"), "T"), "String", VarianceInfo.INVARIANT), "T2"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testDependentTypeParams_04() {
    this.to(this.merge(this.to(this.merge(this.to(this.merge(this.mappedBy("T, T2 extends T, T3 extends T2", "java.util.Map<T, T3>", "java.util.Map<String, Integer>"), "T"), "String", VarianceInfo.INVARIANT), "T2"), "String", VarianceInfo.INVARIANT), "T3"), "Integer", VarianceInfo.INVARIANT);
  }

  @Test
  public void testCircularTypeParams_01() {
    this.to(this.merge(this.mappedBy("T extends T", "String", "String"), "T"), "Object", VarianceInfo.INVARIANT);
  }

  @Test
  public void testCircularTypeParams_02() {
    this.to(this.merge(this.mappedBy("T extends Iterable<T>", "CharSequence", "String"), "T"), "Iterable<Object>", VarianceInfo.INVARIANT);
  }

  @Test
  public void testCircularTypeParams_03() {
    this.to(this.merge(this.mappedBy("T extends Iterable<T>", "T", "java.util.List<String>"), "T"), "List<String>", VarianceInfo.INVARIANT);
  }

  @Test
  public void testCircularTypeParams_04() {
    this.to(this.merge(this.mappedBy("T extends Iterable<T>", "Iterable<? extends T>", "java.util.List<String>"), "T"), "String", VarianceInfo.INVARIANT);
  }

  @Test
  public void testCircularTypeParams_05() {
    this.to(this.merge(this.mappedBy("T extends Iterable<? extends T>", "CharSequence", "String"), "T"), "Iterable<?>", VarianceInfo.INVARIANT);
  }

  @Test
  public void testCircularTypeParams_06() {
    this.to(this.merge(this.mappedBy("T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<T>", "CharSequence", "String"), "T"), "CharIterable<CharSequence>", VarianceInfo.INVARIANT);
  }

  @Test
  public void testCircularTypeParams_07() {
    this.to(this.merge(this.mappedBy("T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends T>", "CharSequence", "String"), "T"), "CharIterable<? extends CharSequence>", VarianceInfo.INVARIANT);
  }

  @Test
  public void testCircularTypeParams_08() {
    this.to(this.merge(this.to(this.merge(this.mappedBy("T extends Iterable<T>, T2 extends Iterable<T>", "CharSequence", "String"), "T"), "Iterable<Object>", VarianceInfo.INVARIANT), "T2"), "Iterable<Iterable<Object>>", VarianceInfo.INVARIANT);
  }
}

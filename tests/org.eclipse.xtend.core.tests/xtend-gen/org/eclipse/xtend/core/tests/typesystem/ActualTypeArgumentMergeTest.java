/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
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
          _builder.append(typeParameters, "");
          _builder.append(">");
        }
      }
      _builder.append(" void method(");
      final Function1<String, String> _function = new Function1<String, String>() {
        public String apply(final String it) {
          return it;
        }
      };
      String _join = IterableExtensions.<String>join(((Iterable<String>)Conversions.doWrapArray(alternatingTypeReferences)), null, " p, ", " p", _function);
      _builder.append(_join, "");
      _builder.append(") {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmTypeParameter> _typeParameters = operation.getTypeParameters();
      final ActualTypeArgumentCollector collector = new ActualTypeArgumentCollector(_typeParameters, BoundTypeArgumentSource.INFERRED, this);
      int _size = ((List<String>)Conversions.doWrapArray(alternatingTypeReferences)).size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      IntegerRange _withStep = _upTo.withStep(2);
      for (final Integer i : _withStep) {
        EList<JvmFormalParameter> _parameters = operation.getParameters();
        JvmFormalParameter _get = _parameters.get((i).intValue());
        JvmTypeReference _parameterType = _get.getParameterType();
        LightweightTypeReference _lightweightReference = this.toLightweightReference(_parameterType);
        EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
        JvmFormalParameter _get_1 = _parameters_1.get(((i).intValue() + 1));
        JvmTypeReference _parameterType_1 = _get_1.getParameterType();
        LightweightTypeReference _lightweightReference_1 = this.toLightweightReference(_parameterType_1);
        collector.populateTypeParameterMapping(_lightweightReference, _lightweightReference_1);
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
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        final List<LightweightBoundTypeArgument> mappingData = mapping.get(key);
        LightweightMergedBoundTypeArgument _merge = this.merger.merge(mappingData, this);
        return Pair.<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument>of(mapping, _merge);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("No mapping for ");
    _builder.append(typeParamName, "");
    _builder.append(" in ");
    Set<JvmTypeParameter> _keySet = mapping.keySet();
    final Function1<JvmTypeParameter, String> _function = new Function1<JvmTypeParameter, String>() {
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
  
  public Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> to(final Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> merged, final String type, final VarianceInfo variance) {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _xblockexpression = null;
    {
      boolean _equals = Objects.equal(type, null);
      if (_equals) {
        LightweightMergedBoundTypeArgument _value = merged.getValue();
        Assert.assertNull(_value);
      } else {
        LightweightMergedBoundTypeArgument _value_1 = merged.getValue();
        LightweightTypeReference _typeReference = _value_1.getTypeReference();
        String _string = _typeReference.toString();
        Assert.assertEquals(type, _string);
        LightweightMergedBoundTypeArgument _value_2 = merged.getValue();
        VarianceInfo _variance = _value_2.getVariance();
        Assert.assertEquals(variance, _variance);
      }
      _xblockexpression = merged.getKey();
    }
    return _xblockexpression;
  }
  
  public List<JvmTypeParameter> getDeclaredTypeParameters() {
    return CollectionLiterals.<JvmTypeParameter>emptyList();
  }
  
  @Test
  public void testUnusedParam() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Object", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnusedParams_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T, T2", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "Object", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "Object", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnusedParams_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends CharSequence, T2", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "Object", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnusedParams_03() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends CharSequence, T2 extends T", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnusedParams_04() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends T2, T2", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "Object", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "Object", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnusedParams_05() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends T2, T2 extends CharSequence", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "Object", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnambiguousMapping_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "java.util.List<T>", "java.util.List<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnambiguousMapping_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "java.util.Map<T, T>", "java.util.Map<String, String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnambiguousMapping_03() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("K, V", "java.util.Map<K, V>", "java.util.Map<String, Integer>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "K");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "V");
    this.to(_merge_1, "Integer", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnambiguousMapping_04() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "CharSequence", "T", "CharSequence");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUnambiguousMapping_05() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T, T2", "T", "CharSequence", "T2", "CharSequence");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "CharSequence", "T", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "String", "T", "CharSequence");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_03() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "String", "Iterable<T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_04() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "String", "Iterable<T>", "Iterable<CharSequence>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_05() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "CharSequence", "Iterable<T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_06() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<CharSequence>", "Iterable<T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_07() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<String>", "Iterable<T>", "Iterable<CharSequence>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_08() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<? extends CharSequence>", "Iterable<T>", "Iterable<? extends CharSequence>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", null);
  }
  
  @Test
  public void testUsedTwice_09() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "String", "Iterable<T>", "Iterable<? extends CharSequence>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", null);
  }
  
  @Test
  public void testUsedTwice_10() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "CharSequence", "Iterable<? extends T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_11() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "CharSequence", "Iterable<? super T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", null);
  }
  
  @Test
  public void testUsedTwice_12() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T", "String", "Iterable<? super T>", "Iterable<CharSequence>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_13() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<String>", "Iterable<? super T>", "Iterable<CharSequence>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUsedTwice_14() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<CharSequence>", "Iterable<? super T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testBestEffortMapping_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "java.util.List<T>", "java.util.Set<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testBestEffortMapping_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "java.util.ArrayList<T>", "java.util.HashSet<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testBestEffortMapping_03() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "java.util.ArrayList<T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testBestEffortMapping_04() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>", "java.util.Map<Iterable<String>, java.util.HashSet<Integer>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testBestEffortMapping_05() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>", "java.util.Map<Iterable<Integer>, java.util.HashSet<String>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Integer", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testBestEffortMapping_06() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "org.eclipse.xtend.core.tests.typesystem.MapType<T>", "java.util.HashMap<String, Integer>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testBestEffortMapping_07() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "org.eclipse.xtend.core.tests.typesystem.MapType<T>", "java.util.HashMap<Integer, String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Integer", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testInheritanceMapping_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("E", "Iterable<E>", "java.util.ArrayList<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "E");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testInheritanceMapping_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("C", "Comparable<C>", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "C");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testMappedGenericType_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<String>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Iterable<String>", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testMappedArray_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T[]", "String[]");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testMappedArray_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "T[]", "String[][]");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String[]", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUpperBound_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUpperBound_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<? extends String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUpperBound_03() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<? super String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Object", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUpperBound_04() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<? extends String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testUpperBound_05() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<Iterable<T>>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.OUT);
  }
  
  @Test
  public void testUpperBound_06() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Iterable<? extends CharSequence>", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUpperBound_07() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.OUT);
  }
  
  @Test
  public void testUpperBound_08() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<Iterable<CharSequence>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUpperBound_09() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<? extends Iterable<CharSequence>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUpperBound_10() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<? super Iterable<CharSequence>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testUpperBound_11() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "java.util.Map<? extends T, ? extends T>", "java.util.Map<String, Integer>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Comparable<?> & Serializable", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testLowerBound_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testLowerBound_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<? super String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testLowerBound_03() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<? extends String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testLowerBound_04() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T, T2 extends T", "Iterable<? super T>", "Iterable<? extends String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "String", null);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "String", null);
  }
  
  @Test
  public void testLowerBound_05() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T, T2 extends T", "java.util.Map<? super T, T>", "java.util.Map<? extends String, Integer>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "Integer", null);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "Integer", null);
  }
  
  @Test
  public void testLowerBound_06() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<? super String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testLowerBound_07() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<Iterable<T>>", "java.util.LinkedList<Iterable<? super String>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testLowerBound_08() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<? super String>>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Iterable<? super String>", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testLowerBound_09() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends T2, T2", "Iterable<? super T2>", "Iterable<? extends String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "String", null);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "String", null);
  }
  
  @Test
  public void testDependentTypeParams_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends CharSequence, T2 extends T", "java.util.Map<T, T2>", "java.util.Map<String, String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testDependentTypeParams_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T, T2 extends T", "Iterable<T>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testDependentTypeParams_03() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends T2, T2 extends CharSequence", "Iterable<T2>", "Iterable<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testDependentTypeParams_04() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T, T2 extends T, T3 extends T2", "java.util.Map<T, T3>", "java.util.Map<String, Integer>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to_1 = this.to(_merge_1, "String", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_2 = this.merge(_to_1, "T3");
    this.to(_merge_2, "Integer", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testCircularTypeParams_01() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends T", "String", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Object", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testCircularTypeParams_02() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends Iterable<T>", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Iterable<Object>", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testCircularTypeParams_03() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends Iterable<T>", "T", "java.util.List<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "List<String>", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testCircularTypeParams_04() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends Iterable<T>", "Iterable<? extends T>", "java.util.List<String>");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testCircularTypeParams_05() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends Iterable<? extends T>", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "Iterable<?>", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testCircularTypeParams_06() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<T>", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharIterable<CharSequence>", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testCircularTypeParams_07() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends T>", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    this.to(_merge, "CharIterable<? extends CharSequence>", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testCircularTypeParams_08() {
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _mappedBy = this.mappedBy("T extends Iterable<T>, T2 extends Iterable<T>", "CharSequence", "String");
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge = this.merge(_mappedBy, "T");
    Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> _to = this.to(_merge, "Iterable<Object>", VarianceInfo.INVARIANT);
    Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> _merge_1 = this.merge(_to, "T2");
    this.to(_merge_1, "Iterable<Iterable<Object>>", VarianceInfo.INVARIANT);
  }
}

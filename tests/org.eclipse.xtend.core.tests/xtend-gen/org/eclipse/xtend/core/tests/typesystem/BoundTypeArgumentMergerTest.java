/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BoundTypeArgumentMergerTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private BoundTypeArgumentMerger merger;
  
  public LightweightMergedBoundTypeArgument merge(final Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
    return this.mergeWithSource(null, mergeUs);
  }
  
  public LightweightMergedBoundTypeArgument mergeWithSource(final Object source, final Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def void method(");
      final Function1<Triple<String,VarianceInfo,VarianceInfo>,String> _function = new Function1<Triple<String,VarianceInfo,VarianceInfo>,String>() {
        public String apply(final Triple<String,VarianceInfo,VarianceInfo> it) {
          return it.getFirst();
        }
      };
      String _join = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>join(((Iterable<Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mergeUs)), null, " p, ", " p", _function);
      _builder.append(_join, "");
      _builder.append(") {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      final ArrayList<LightweightBoundTypeArgument> mergable = CollectionLiterals.<LightweightBoundTypeArgument>newArrayList();
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      final Procedure2<JvmFormalParameter,Integer> _function_1 = new Procedure2<JvmFormalParameter,Integer>() {
        public void apply(final JvmFormalParameter p, final Integer i) {
          final Triple<String,VarianceInfo,VarianceInfo> input = mergeUs[(i).intValue()];
          JvmTypeReference _parameterType = p.getParameterType();
          LightweightTypeReference _lightweightReference = BoundTypeArgumentMergerTest.this.toLightweightReference(_parameterType);
          Object _elvis = null;
          if (source != null) {
            _elvis = source;
          } else {
            Object _object = new Object();
            _elvis = ObjectExtensions.<Object>operator_elvis(source, _object);
          }
          VarianceInfo _second = input.getSecond();
          VarianceInfo _third = input.getThird();
          LightweightBoundTypeArgument _lightweightBoundTypeArgument = new LightweightBoundTypeArgument(_lightweightReference, null, _elvis, _second, _third);
          mergable.add(_lightweightBoundTypeArgument);
        }
      };
      IterableExtensions.<JvmFormalParameter>forEach(_parameters, _function_1);
      return this.merger.merge(mergable, this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public LightweightMergedBoundTypeArgument mergeSuccessive(final Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
    try {
      int _length = mergeUs.length;
      boolean _greaterThan = (_length > 2);
      Assert.assertTrue(_greaterThan);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def void method(");
      final Function1<Triple<String,VarianceInfo,VarianceInfo>,String> _function = new Function1<Triple<String,VarianceInfo,VarianceInfo>,String>() {
        public String apply(final Triple<String,VarianceInfo,VarianceInfo> it) {
          return it.getFirst();
        }
      };
      String _join = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>join(((Iterable<Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mergeUs)), null, " p, ", " p", _function);
      _builder.append(_join, "");
      _builder.append(") {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      final ArrayList<LightweightBoundTypeArgument> mergable = CollectionLiterals.<LightweightBoundTypeArgument>newArrayList();
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      final Procedure2<JvmFormalParameter,Integer> _function_1 = new Procedure2<JvmFormalParameter,Integer>() {
        public void apply(final JvmFormalParameter p, final Integer i) {
          final Triple<String,VarianceInfo,VarianceInfo> input = mergeUs[(i).intValue()];
          JvmTypeReference _parameterType = p.getParameterType();
          LightweightTypeReference _lightweightReference = BoundTypeArgumentMergerTest.this.toLightweightReference(_parameterType);
          Object _object = new Object();
          VarianceInfo _second = input.getSecond();
          VarianceInfo _third = input.getThird();
          LightweightBoundTypeArgument _lightweightBoundTypeArgument = new LightweightBoundTypeArgument(_lightweightReference, null, _object, _second, _third);
          mergable.add(_lightweightBoundTypeArgument);
        }
      };
      IterableExtensions.<JvmFormalParameter>forEach(_parameters, _function_1);
      final Iterator<LightweightBoundTypeArgument> iterator = mergable.iterator();
      LightweightBoundTypeArgument first = iterator.next();
      LightweightBoundTypeArgument second = iterator.next();
      LightweightMergedBoundTypeArgument merged = this.merger.merge(Collections.<LightweightBoundTypeArgument>unmodifiableList(Lists.<LightweightBoundTypeArgument>newArrayList(first, second)), this);
      boolean _hasNext = iterator.hasNext();
      boolean _while = _hasNext;
      while (_while) {
        {
          LightweightTypeReference _typeReference = merged.getTypeReference();
          Object _object = new Object();
          VarianceInfo _variance = merged.getVariance();
          VarianceInfo _variance_1 = merged.getVariance();
          LightweightBoundTypeArgument _lightweightBoundTypeArgument = new LightweightBoundTypeArgument(_typeReference, null, _object, _variance, _variance_1);
          first = _lightweightBoundTypeArgument;
          LightweightBoundTypeArgument _next = iterator.next();
          second = _next;
          LightweightMergedBoundTypeArgument _merge = this.merger.merge(Collections.<LightweightBoundTypeArgument>unmodifiableList(Lists.<LightweightBoundTypeArgument>newArrayList(first, second)), this);
          merged = _merge;
        }
        boolean _hasNext_1 = iterator.hasNext();
        _while = _hasNext_1;
      }
      return merged;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void to(final LightweightMergedBoundTypeArgument merged, final String type, final VarianceInfo variance) {
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      Assert.assertNull(merged);
    } else {
      LightweightTypeReference _typeReference = merged.getTypeReference();
      String _simpleName = _typeReference.getSimpleName();
      Assert.assertEquals(type, _simpleName);
      VarianceInfo _variance = merged.getVariance();
      Assert.assertEquals(variance, _variance);
    }
  }
  
  public Triple<String,VarianceInfo,VarianceInfo> operator_mappedTo(final Pair<String,VarianceInfo> pair, final VarianceInfo third) {
    String _key = pair.getKey();
    VarianceInfo _value = pair.getValue();
    return Tuples.<String, VarianceInfo, VarianceInfo>create(_key, _value, third);
  }
  
  @Test
  public void testNothingToMerge_01() {
    LightweightMergedBoundTypeArgument _merge = this.merge();
    this.to(_merge, null, null);
  }
  
  @Test
  public void testNothingToMerge_02() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge_1 = this.merge(_mappedTo_3);
    this.to(_merge_1, "String", VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge_2 = this.merge(_mappedTo_5);
    this.to(_merge_2, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testNothingToMerge_03() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge_1 = this.merge(_mappedTo_3);
    this.to(_merge_1, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge_2 = this.merge(_mappedTo_5);
    this.to(_merge_2, "String", null);
  }
  
  @Test
  public void testNothingToMerge_04() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge_1 = this.merge(_mappedTo_3);
    this.to(_merge_1, "String", null);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge_2 = this.merge(_mappedTo_5);
    this.to(_merge_2, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwiceDifferentTypes_01() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_6 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_7 = this.operator_mappedTo(_mappedTo_6, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge_1 = this.merge(_mappedTo_5, _mappedTo_7);
    this.to(_merge_1, "Integer", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testValidityPrecedence_01() {
    Object _object = new Object();
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    LightweightMergedBoundTypeArgument _mergeWithSource = this.mergeWithSource(_object, _mappedTo_1, _mappedTo_3);
    this.to(_mergeWithSource, "Object", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testMergeMultiType_01() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("StringBuilder", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("StringBuffer", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "AbstractStringBuilder & Serializable", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testMergeMultiType_02() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("StringBuilder", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("StringBuffer", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("StringBuilder", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.OUT);
    LightweightMergedBoundTypeArgument _mergeSuccessive = this.mergeSuccessive(_mappedTo_1, _mappedTo_3, _mappedTo_5);
    this.to(_mergeSuccessive, "AbstractStringBuilder & Serializable", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testMergeMultiType_03() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("StringBuilder", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("StringBuffer", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3, _mappedTo_5);
    this.to(_merge, "Serializable & CharSequence", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testMergeMultiType_04() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("AbstractStringBuilder", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("java.io.Serializable", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.INVARIANT);
    LightweightMergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3, _mappedTo_5);
    this.to(_merge, "Object", VarianceInfo.INVARIANT);
  }
}

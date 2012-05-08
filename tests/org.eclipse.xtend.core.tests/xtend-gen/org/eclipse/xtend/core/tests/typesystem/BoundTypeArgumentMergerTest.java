package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BoundTypeArgumentMergerTest extends AbstractXtendTestCase {
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private BoundTypeArgumentMerger merger;
  
  public MergedBoundTypeArgument merge(final Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
    MergedBoundTypeArgument _mergeWithSource = this.mergeWithSource(null, mergeUs);
    return _mergeWithSource;
  }
  
  public MergedBoundTypeArgument mergeWithSource(final Object source, final Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def void method(");
      final Function1<Triple<String,VarianceInfo,VarianceInfo>,String> _function = new Function1<Triple<String,VarianceInfo,VarianceInfo>,String>() {
          public String apply(final Triple<String,VarianceInfo,VarianceInfo> it) {
            String _first = it.getFirst();
            return _first;
          }
        };
      String _join = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>join(((Iterable<Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mergeUs)), null, " p, ", " p", _function);
      _builder.append(_join, "");
      _builder.append(") {}");
      final CharSequence signature = _builder;
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      final ArrayList<BoundTypeArgument> mergable = CollectionLiterals.<BoundTypeArgument>newArrayList();
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      final Procedure2<JvmFormalParameter,Integer> _function_1 = new Procedure2<JvmFormalParameter,Integer>() {
          public void apply(final JvmFormalParameter p, final Integer i) {
            final Triple<String,VarianceInfo,VarianceInfo> input = ((List<Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mergeUs)).get((i).intValue());
            JvmTypeReference _parameterType = p.getParameterType();
            Object _object = new Object();
            Object _elvis = ObjectExtensions.<Object>operator_elvis(source, _object);
            VarianceInfo _second = input.getSecond();
            VarianceInfo _third = input.getThird();
            BoundTypeArgument _boundTypeArgument = new BoundTypeArgument(_parameterType, null, _elvis, _second, _third);
            mergable.add(_boundTypeArgument);
          }
        };
      IterableExtensions.<JvmFormalParameter>forEach(_parameters, _function_1);
      return this.merger.merge(mergable);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void to(final MergedBoundTypeArgument merged, final String type, final VarianceInfo variance) {
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      Assert.assertNull(merged);
    } else {
      JvmTypeReference _typeReference = merged.getTypeReference();
      String _simpleName = _typeReference.getSimpleName();
      Assert.assertEquals(type, _simpleName);
      VarianceInfo _variance = merged.getVariance();
      Assert.assertEquals(variance, _variance);
    }
  }
  
  public Triple<String,VarianceInfo,VarianceInfo> operator_mappedTo(final Pair<String,VarianceInfo> pair, final VarianceInfo third) {
    String _key = pair.getKey();
    VarianceInfo _value = pair.getValue();
    Triple<String,VarianceInfo,VarianceInfo> _create = Tuples.<String, VarianceInfo, VarianceInfo>create(_key, _value, third);
    return _create;
  }
  
  @Test
  public void testNothingToMerge_01() {
    MergedBoundTypeArgument _merge = this.merge();
    this.to(_merge, null, null);
  }
  
  @Test
  public void testNothingToMerge_02() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge_1 = this.merge(_mappedTo_3);
    this.to(_merge_1, "String", VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.IN);
    MergedBoundTypeArgument _merge_2 = this.merge(_mappedTo_5);
    this.to(_merge_2, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testNothingToMerge_03() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge_1 = this.merge(_mappedTo_3);
    this.to(_merge_1, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.IN);
    MergedBoundTypeArgument _merge_2 = this.merge(_mappedTo_5);
    this.to(_merge_2, "String", null);
  }
  
  @Test
  public void testNothingToMerge_04() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge_1 = this.merge(_mappedTo_3);
    this.to(_merge_1, "String", null);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.IN);
    MergedBoundTypeArgument _merge_2 = this.merge(_mappedTo_5);
    this.to(_merge_2, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwiceDifferentTypes_01() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_6 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_7 = this.operator_mappedTo(_mappedTo_6, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge_1 = this.merge(_mappedTo_5, _mappedTo_7);
    this.to(_merge_1, "Integer", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_01_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_02_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_03_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.IN);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_04_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.OUT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_05_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_06_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_07_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_08_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_a() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_b() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_c() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_d() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_e() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_f() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_g() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_h() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", null);
  }
  
  @Test
  public void testArgumentTypeUsedTwice_09_i() {
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _merge = this.merge(_mappedTo_1, _mappedTo_3);
    this.to(_merge, "String", VarianceInfo.INVARIANT);
  }
  
  @Test
  public void testValidityPrecedence_01() {
    Object _object = new Object();
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    MergedBoundTypeArgument _mergeWithSource = this.mergeWithSource(_object, _mappedTo_1, _mappedTo_3);
    this.to(_mergeWithSource, "Object", VarianceInfo.INVARIANT);
  }
}

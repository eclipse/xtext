package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractDeferredTypeParameterHintCollectorTest extends AbstractXtendTestCase {
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  public abstract Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> in(final String typeParameters, final String expectedType, final String actualType);
  
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
      final CharSequence signature = _builder;
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      return operation;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public abstract List<LightweightBoundTypeArgument> hasHintsFor(final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> mapping, final String typeParamName);
  
  public abstract void hasNoHintsFor(final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> mapping, final String typeParamName);
  
  public abstract List<LightweightBoundTypeArgument> like(final List<LightweightBoundTypeArgument> mappingData, final Triple<String,VarianceInfo,VarianceInfo>... mappedTypes);
  
  public Triple<String,VarianceInfo,VarianceInfo> operator_mappedTo(final Pair<String,VarianceInfo> pair, final VarianceInfo third) {
    String _key = pair.getKey();
    VarianceInfo _value = pair.getValue();
    Triple<String,VarianceInfo,VarianceInfo> _create = Tuples.<String, VarianceInfo, VarianceInfo>create(_key, _value, third);
    return _create;
  }
  
  @Test
  public void testDirectUnboundExpectation() {
    Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _in = this.in("T", "T", "String");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_01() {
    Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _in = this.in("T", "Iterable<T>", "java.util.List<String>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_02() {
    Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _in = this.in("T", "Iterable<? extends T>", "java.util.List<String>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_03() {
    Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _in = this.in("T", "Iterable<? super T>", "java.util.List<String>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testUsedTwice() {
    Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _in = this.in("T", "java.util.Map<T, T>", "com.google.common.collect.BiMap<CharSequence, Integer>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testDependsOnOther() {
    Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _in = this.in("T, V", "java.util.Map<T, String>", "java.util.Map<V, Integer>");
    List<LightweightBoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("V", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testUnusedExpectation_01() {
    Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _in = this.in("T", "Iterable<T>", "String");
    this.hasNoHintsFor(_in, "T");
  }
  
  @Test
  public void testUnusedExpectation_02() {
    Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _in = this.in("T", "String", "Iterable<T>");
    this.hasNoHintsFor(_in, "T");
  }
}

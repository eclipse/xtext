package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.typesystem.MockResolvedTypes;
import org.eclipse.xtend.core.tests.typesystem.MockTypeParameterSubstitutor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.internal.BaseUnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class DeferredTypeParameterHintCollectorTest extends AbstractXtendTestCase {
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private CommonTypeComputationServices services;
  
  @Inject
  private DefaultReentrantTypeResolver resolver;
  
  public Map<JvmTypeParameter,MergedBoundTypeArgument> in(final String typeParameters, final String expectedType, final String actualType) {
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
      DeferredTypeParameterHintCollector _deferredTypeParameterHintCollector = new DeferredTypeParameterHintCollector(this.services);
      final DeferredTypeParameterHintCollector collector = _deferredTypeParameterHintCollector;
      MockResolvedTypes _mockResolvedTypes = new MockResolvedTypes(this.resolver);
      MockTypeParameterSubstitutor _mockTypeParameterSubstitutor = new MockTypeParameterSubstitutor(this.services, _mockResolvedTypes);
      final MockTypeParameterSubstitutor substitutor = _mockTypeParameterSubstitutor;
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
      JvmTypeReference _parameterType = _head.getParameterType();
      final JvmTypeReference hasUnbounds = substitutor.substitute(_parameterType);
      EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
      JvmFormalParameter _last = IterableExtensions.<JvmFormalParameter>last(_parameters_1);
      final JvmTypeReference isActual = _last.getParameterType();
      collector.processPairedReferences(hasUnbounds, isActual);
      return substitutor.getTypeParameterMapping();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public List<BoundTypeArgument> hasHintsFor(final Map<JvmTypeParameter,MergedBoundTypeArgument> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        MergedBoundTypeArgument _get = mapping.get(key);
        JvmTypeReference _typeReference = _get.getTypeReference();
        final XComputedTypeReference computed = ((XComputedTypeReference) _typeReference);
        IJvmTypeReferenceProvider _typeProvider = computed.getTypeProvider();
        final BaseUnboundTypeParameter unbound = ((BaseUnboundTypeParameter) _typeProvider);
        List<BoundTypeArgument> _allHints = unbound.getAllHints();
        final Procedure1<BoundTypeArgument> _function = new Procedure1<BoundTypeArgument>() {
            public void apply(final BoundTypeArgument it) {
              BoundTypeArgumentSource _source = it.getSource();
              Assert.assertEquals(BoundTypeArgumentSource.INFERRED_LATER, _source);
            }
          };
        IterableExtensions.<BoundTypeArgument>forEach(_allHints, _function);
        return unbound.getAllHints();
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("No mapping for ");
    _builder.append(typeParamName, "");
    _builder.append(" in ");
    Set<JvmTypeParameter> _keySet = mapping.keySet();
    final Function1<JvmTypeParameter,String> _function_1 = new Function1<JvmTypeParameter,String>() {
        public String apply(final JvmTypeParameter it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
      };
    Iterable<String> _map = IterableExtensions.<JvmTypeParameter, String>map(_keySet, _function_1);
    _builder.append(_map, "");
    String _string = _builder.toString();
    Assert.fail(_string);
    return null;
  }
  
  public void hasNoHintsFor(final Map<JvmTypeParameter,MergedBoundTypeArgument> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        MergedBoundTypeArgument _get = mapping.get(key);
        JvmTypeReference _typeReference = _get.getTypeReference();
        final XComputedTypeReference computed = ((XComputedTypeReference) _typeReference);
        IJvmTypeReferenceProvider _typeProvider = computed.getTypeProvider();
        final BaseUnboundTypeParameter unbound = ((BaseUnboundTypeParameter) _typeProvider);
        List<BoundTypeArgument> _allHints = unbound.getAllHints();
        boolean _isEmpty = _allHints.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Unexpected mapping for ");
          _builder.append(typeParamName, "");
          _builder.append(" in ");
          Set<JvmTypeParameter> _keySet = mapping.keySet();
          final Function1<JvmTypeParameter,String> _function = new Function1<JvmTypeParameter,String>() {
              public String apply(final JvmTypeParameter it) {
                String _simpleName = it.getSimpleName();
                return _simpleName;
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
  
  public List<BoundTypeArgument> like(final List<BoundTypeArgument> mappingData, final Triple<String,VarianceInfo,VarianceInfo>... mappedTypes) {
    final Function1<BoundTypeArgument,CharSequence> _function = new Function1<BoundTypeArgument,CharSequence>() {
        public CharSequence apply(final BoundTypeArgument it) {
          StringConcatenation _builder = new StringConcatenation();
          JvmTypeReference _typeReference = it.getTypeReference();
          String _simpleName = _typeReference.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append("(");
          VarianceInfo _declaredVariance = it.getDeclaredVariance();
          _builder.append(_declaredVariance, "");
          _builder.append("/");
          VarianceInfo _actualVariance = it.getActualVariance();
          _builder.append(_actualVariance, "");
          _builder.append(")");
          return _builder;
        }
      };
    List<CharSequence> _map = ListExtensions.<BoundTypeArgument, CharSequence>map(mappingData, _function);
    String _string = _map.toString();
    int _size = ((List<Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mappedTypes)).size();
    int _size_1 = mappingData.size();
    Assert.assertEquals(_string, _size, _size_1);
    List<Triple<String,VarianceInfo,VarianceInfo>> _list = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>toList(((Iterable<? extends Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mappedTypes)));
    final Function1<BoundTypeArgument,Triple<String,VarianceInfo,VarianceInfo>> _function_1 = new Function1<BoundTypeArgument,Triple<String,VarianceInfo,VarianceInfo>>() {
        public Triple<String,VarianceInfo,VarianceInfo> apply(final BoundTypeArgument it) {
          JvmTypeReference _typeReference = it.getTypeReference();
          String _simpleName = _typeReference.getSimpleName();
          VarianceInfo _declaredVariance = it.getDeclaredVariance();
          VarianceInfo _actualVariance = it.getActualVariance();
          Triple<String,VarianceInfo,VarianceInfo> _create = Tuples.<String, VarianceInfo, VarianceInfo>create(_simpleName, _declaredVariance, _actualVariance);
          return _create;
        }
      };
    List<Triple<String,VarianceInfo,VarianceInfo>> _map_1 = ListExtensions.<BoundTypeArgument, Triple<String,VarianceInfo,VarianceInfo>>map(mappingData, _function_1);
    List<Triple<String,VarianceInfo,VarianceInfo>> _list_1 = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>toList(_map_1);
    Assert.assertEquals(((Object) _list), _list_1);
    return mappingData;
  }
  
  public Triple<String,VarianceInfo,VarianceInfo> operator_mappedTo(final Pair<String,VarianceInfo> pair, final VarianceInfo third) {
    String _key = pair.getKey();
    VarianceInfo _value = pair.getValue();
    Triple<String,VarianceInfo,VarianceInfo> _create = Tuples.<String, VarianceInfo, VarianceInfo>create(_key, _value, third);
    return _create;
  }
  
  @Test
  public void testDirectUnboundExpectation() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _in = this.in("T", "T", "String");
    List<BoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_01() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _in = this.in("T", "Iterable<T>", "java.util.List<String>");
    List<BoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_02() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _in = this.in("T", "Iterable<? extends T>", "java.util.List<String>");
    List<BoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testNestedUnboundExpectation_03() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _in = this.in("T", "Iterable<? super T>", "java.util.List<String>");
    List<BoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testUsedTwice() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _in = this.in("T", "java.util.Map<T, T>", "com.google.common.collect.BiMap<CharSequence, Integer>");
    List<BoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testDependsOnOther() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _in = this.in("T, V", "java.util.Map<T, String>", "java.util.Map<V, Integer>");
    List<BoundTypeArgument> _hasHintsFor = this.hasHintsFor(_in, "T");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("V", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.like(_hasHintsFor, _mappedTo_1);
  }
  
  @Test
  public void testUnusedExpectation_01() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _in = this.in("T", "Iterable<T>", "String");
    this.hasNoHintsFor(_in, "T");
  }
  
  @Test
  public void testUnusedExpectation_02() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _in = this.in("T", "String", "Iterable<T>");
    this.hasNoHintsFor(_in, "T");
  }
}

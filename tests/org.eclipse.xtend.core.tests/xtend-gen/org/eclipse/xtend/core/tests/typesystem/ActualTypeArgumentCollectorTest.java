package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
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
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class ActualTypeArgumentCollectorTest extends AbstractXtendTestCase {
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private CommonTypeComputationServices services;
  
  public ListMultimap<JvmTypeParameter,BoundTypeArgument> mappedBy(final String typeParameters, final String... alternatingTypeReferences) {
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
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String it) {
            return it;
          }
        };
      String _join = IterableExtensions.<String>join(((Iterable<String>)Conversions.doWrapArray(alternatingTypeReferences)), null, " p, ", " p", _function);
      _builder.append(_join, "");
      _builder.append(") {}");
      final CharSequence signature = _builder;
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmTypeParameter> _typeParameters = operation.getTypeParameters();
      ActualTypeArgumentCollector _actualTypeArgumentCollector = new ActualTypeArgumentCollector(_typeParameters, BoundTypeArgumentSource.INFERRED, this.services);
      final ActualTypeArgumentCollector collector = _actualTypeArgumentCollector;
      int _size = ((List<String>)Conversions.doWrapArray(alternatingTypeReferences)).size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      IntegerRange _withStep = _upTo.withStep(2);
      for (final Integer i : _withStep) {
        EList<JvmFormalParameter> _parameters = operation.getParameters();
        JvmFormalParameter _get = _parameters.get((i).intValue());
        JvmTypeReference _parameterType = _get.getParameterType();
        EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
        int _plus = ((i).intValue() + 1);
        JvmFormalParameter _get_1 = _parameters_1.get(_plus);
        JvmTypeReference _parameterType_1 = _get_1.getParameterType();
        collector.populateTypeParameterMapping(_parameterType, _parameterType_1);
      }
      return collector.getTypeParameterMapping();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Multimap<JvmTypeParameter,BoundTypeArgument> assertMapping(final Multimap<JvmTypeParameter,BoundTypeArgument> mapping, final String typeParamName, final Triple<String,VarianceInfo,VarianceInfo>... mappedTypes) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        Assert.assertNotNull(mappedTypes);
        final Collection<BoundTypeArgument> mappingData = mapping.get(key);
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
        Iterable<CharSequence> _map = IterableExtensions.<BoundTypeArgument, CharSequence>map(mappingData, _function);
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
        Iterable<Triple<String,VarianceInfo,VarianceInfo>> _map_1 = IterableExtensions.<BoundTypeArgument, Triple<String,VarianceInfo,VarianceInfo>>map(mappingData, _function_1);
        List<Triple<String,VarianceInfo,VarianceInfo>> _list_1 = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>toList(_map_1);
        Assert.assertEquals(((Object) _list), _list_1);
        return mapping;
      }
    }
    boolean _notEquals = (!Objects.equal(mappedTypes, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No mapping for ");
      _builder.append(typeParamName, "");
      _builder.append(" in ");
      Set<JvmTypeParameter> _keySet = mapping.keySet();
      final Function1<JvmTypeParameter,String> _function_2 = new Function1<JvmTypeParameter,String>() {
          public String apply(final JvmTypeParameter it) {
            String _simpleName = it.getSimpleName();
            return _simpleName;
          }
        };
      Iterable<String> _map_2 = IterableExtensions.<JvmTypeParameter, String>map(_keySet, _function_2);
      _builder.append(_map_2, "");
      String _string_1 = _builder.toString();
      Assert.fail(_string_1);
    }
    return mapping;
  }
  
  public Multimap<JvmTypeParameter,BoundTypeArgument> assertOrigins(final Multimap<JvmTypeParameter,BoundTypeArgument> mapping, final String typeParamName, final int count) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        final Collection<BoundTypeArgument> mappingData = mapping.get(key);
        final Function1<BoundTypeArgument,Object> _function = new Function1<BoundTypeArgument,Object>() {
            public Object apply(final BoundTypeArgument it) {
              Object _origin = it.getOrigin();
              return _origin;
            }
          };
        Iterable<Object> _map = IterableExtensions.<BoundTypeArgument, Object>map(mappingData, _function);
        Set _set = IterableExtensions.<Object>toSet(_map);
        int _size = _set.size();
        Assert.assertEquals(count, _size);
        return mapping;
      }
    }
    return mapping;
  }
  
  public Triple<String,VarianceInfo,VarianceInfo> operator_mappedTo(final Pair<String,VarianceInfo> pair, final VarianceInfo third) {
    String _key = pair.getKey();
    VarianceInfo _value = pair.getValue();
    Triple<String,VarianceInfo,VarianceInfo> _create = Tuples.<String, VarianceInfo, VarianceInfo>create(_key, _value, third);
    return _create;
  }
  
  @Test
  public void testNoParams_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("", "String", "String");
    boolean _isEmpty = _mappedBy.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testNoParams_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("", "java.util.List<?>", "java.util.ArrayList<String>");
    boolean _isEmpty = _mappedBy.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testUnusedParam() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUnusedParams_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T, T2", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnusedParams_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends CharSequence, T2", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnusedParams_03() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends CharSequence, T2 extends T", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnusedParams_04() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends T2, T2", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnusedParams_05() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends T2, T2 extends CharSequence", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnambiguousMapping_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "java.util.List<T>", "java.util.List<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUnambiguousMapping_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "java.util.Map<T, T>", "java.util.Map<String, String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testUnambiguousMapping_03() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("K, V", "java.util.Map<K, V>", "java.util.Map<String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "K", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "V", _mappedTo_3);
  }
  
  @Test
  public void testUnambiguousMapping_04() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "T", "CharSequence", "T", "CharSequence");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testUnambiguousMapping_05() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T, T2", "T", "CharSequence", "T2", "CharSequence");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUsedTwice_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "T", "CharSequence", "T", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testUsedTwice_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "T", "String", "T", "CharSequence");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testBestEffortMapping_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "java.util.List<T>", "java.util.Set<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testBestEffortMapping_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "java.util.ArrayList<T>", "java.util.HashSet<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testBestEffortMapping_03() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "java.util.ArrayList<T>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testBestEffortMapping_04() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>", "java.util.Map<Iterable<String>, java.util.HashSet<Integer>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testBestEffortMapping_05() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "org.eclipse.xtend.core.tests.typesystem.MapType<T>", "java.util.HashMap<String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testInheritanceMapping_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("E", "Iterable<E>", "java.util.ArrayList<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "E", _mappedTo_1);
  }
  
  @Test
  public void testInheritanceMapping_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("C", "Comparable<C>", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "C", _mappedTo_1);
  }
  
  @Test
  public void testMappedGenericType_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<String>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<String>", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testMappedArray_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "T[]", "String[]");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testMappedArray_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "T[]", "String[][]");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String[]", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_03() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<? super String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
    this.assertOrigins(_assertMapping, "T", 1);
  }
  
  @Test
  public void testUpperBound_04() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_05() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<Iterable<T>>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_06() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<? extends CharSequence>", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_07() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_08() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<Iterable<CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_09() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<? extends Iterable<CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_10() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<? super Iterable<CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_11() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "java.util.Map<? extends T, ? extends T>", "java.util.Map<String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
    this.assertOrigins(_assertMapping, "T", 2);
  }
  
  @Test
  public void testLowerBound_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<? super String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_03() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_04() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T, T2 extends T", "Iterable<? super T>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testLowerBound_05() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T, T2 extends T", "java.util.Map<? super T, T>", "java.util.Map<? extends String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_6 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_7 = this.operator_mappedTo(_mappedTo_6, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_5, _mappedTo_7);
  }
  
  @Test
  public void testLowerBound_06() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<? super String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_07() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<Iterable<T>>", "java.util.LinkedList<Iterable<? super String>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_08() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<? super String>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<? super String>", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_09() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends T2, T2", "Iterable<? super T2>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testDependentTypeParams_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends CharSequence, T2 extends T", "java.util.Map<T, T2>", "java.util.Map<String, String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testDependentTypeParams_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T, T2 extends T", "Iterable<T>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testDependentTypeParams_03() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends T2, T2 extends CharSequence", "Iterable<T2>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testDependentTypeParams_04() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T, T2 extends T, T3 extends T2", "java.util.Map<T, T3>", "java.util.Map<String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping_1 = this.assertMapping(_assertMapping, "T2", _mappedTo_3);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping_1, "T3", _mappedTo_5);
  }
  
  @Test
  public void testCircularTypeParams_01() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends T", "String", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_02() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends Iterable<T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<Object>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_03() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends Iterable<T>", "T", "java.util.List<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("List<String>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_04() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends Iterable<T>", "Iterable<? extends T>", "java.util.List<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_05() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends Iterable<? extends T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<Object>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_06() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharIterable<CharSequence>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_07() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharIterable<CharSequence>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_08() {
    ListMultimap<JvmTypeParameter,BoundTypeArgument> _mappedBy = this.mappedBy("T extends Iterable<T>, T2 extends Iterable<T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<Object>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,BoundTypeArgument> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Iterable<Iterable<Object>>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
}

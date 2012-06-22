package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractTypeArgumentCollectorTest extends AbstractXtendTestCase {
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  public abstract Multimap<JvmTypeParameter,? extends Object> mappedBy(final String typeParameters, final String... alternatingTypeReferences);
  
  protected JvmOperation operation(final String typeParameters, final String... alternatingTypeReferences) {
    try {
      JvmOperation _xblockexpression = null;
      {
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
        _xblockexpression = (operation);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public abstract Multimap<JvmTypeParameter,? extends Object> assertMapping(final Multimap<JvmTypeParameter,? extends Object> mapping, final String typeParamName, final Triple<String,VarianceInfo,VarianceInfo>... mappedTypes);
  
  public abstract Multimap<JvmTypeParameter,? extends Object> assertOrigins(final Multimap<JvmTypeParameter,? extends Object> mapping, final String typeParamName, final int count);
  
  public Triple<String,VarianceInfo,VarianceInfo> operator_mappedTo(final Pair<String,VarianceInfo> pair, final VarianceInfo third) {
    String _key = pair.getKey();
    VarianceInfo _value = pair.getValue();
    Triple<String,VarianceInfo,VarianceInfo> _create = Tuples.<String, VarianceInfo, VarianceInfo>create(_key, _value, third);
    return _create;
  }
  
  @Test
  public void testNoParams_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("", "String", "String");
    boolean _isEmpty = _mappedBy.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testNoParams_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("", "java.util.List<?>", "java.util.ArrayList<String>");
    boolean _isEmpty = _mappedBy.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testUnusedParam() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUnusedParams_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T, T2", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnusedParams_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends CharSequence, T2", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnusedParams_03() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends CharSequence, T2 extends T", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnusedParams_04() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends T2, T2", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnusedParams_05() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends T2, T2 extends CharSequence", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUnambiguousMapping_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "java.util.List<T>", "java.util.List<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUnambiguousMapping_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "java.util.Map<T, T>", "java.util.Map<String, String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testUnambiguousMapping_03() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("K, V", "java.util.Map<K, V>", "java.util.Map<String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "K", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "V", _mappedTo_3);
  }
  
  @Test
  public void testUnambiguousMapping_04() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "T", "CharSequence", "T", "CharSequence");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testUnambiguousMapping_05() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T, T2", "T", "CharSequence", "T2", "CharSequence");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testUsedTwice_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "T", "CharSequence", "T", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testUsedTwice_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "T", "String", "T", "CharSequence");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testBestEffortMapping_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "java.util.List<T>", "java.util.Set<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testBestEffortMapping_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "java.util.ArrayList<T>", "java.util.HashSet<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testBestEffortMapping_03() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "java.util.ArrayList<T>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testBestEffortMapping_04() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>", "java.util.Map<Iterable<String>, java.util.HashSet<Integer>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testBestEffortMapping_05() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "org.eclipse.xtend.core.tests.typesystem.MapType<T>", "java.util.HashMap<String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
  }
  
  @Test
  public void testInheritanceMapping_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("E", "Iterable<E>", "java.util.ArrayList<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "E", _mappedTo_1);
  }
  
  @Test
  public void testInheritanceMapping_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("C", "Comparable<C>", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "C", _mappedTo_1);
  }
  
  @Test
  public void testMappedGenericType_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<String>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<String>", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testMappedArray_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "T[]", "String[]");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testMappedArray_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "T[]", "String[][]");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String[]", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_03() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? extends T>", "Iterable<? super String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.IN);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
    this.assertOrigins(_assertMapping, "T", 1);
  }
  
  @Test
  public void testUpperBound_04() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_05() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<Iterable<T>>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_06() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<? extends CharSequence>", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_07() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<Iterable<? extends CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_08() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<Iterable<CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_09() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<? extends Iterable<CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_10() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? extends Iterable<T>>", "Iterable<? super Iterable<CharSequence>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharSequence", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testUpperBound_11() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "java.util.Map<? extends T, ? extends T>", "java.util.Map<String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
    this.assertOrigins(_assertMapping, "T", 2);
  }
  
  @Test
  public void testLowerBound_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<? super String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_03() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<? super T>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_04() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T, T2 extends T", "Iterable<? super T>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testLowerBound_05() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T, T2 extends T", "java.util.Map<? super T, T>", "java.util.Map<? extends String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1, _mappedTo_3);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.OUT);
    Pair<String,VarianceInfo> _mappedTo_6 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_7 = this.operator_mappedTo(_mappedTo_6, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_5, _mappedTo_7);
  }
  
  @Test
  public void testLowerBound_06() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<? super String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_07() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<Iterable<T>>", "java.util.LinkedList<Iterable<? super String>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.IN);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_08() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T", "Iterable<T>", "Iterable<Iterable<? super String>>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<? super String>", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testLowerBound_09() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends T2, T2", "Iterable<? super T2>", "Iterable<? extends String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.IN);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testDependentTypeParams_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends CharSequence, T2 extends T", "java.util.Map<T, T2>", "java.util.Map<String, String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testDependentTypeParams_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T, T2 extends T", "Iterable<T>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testDependentTypeParams_03() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends T2, T2 extends CharSequence", "Iterable<T2>", "Iterable<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
  
  @Test
  public void testDependentTypeParams_04() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T, T2 extends T, T3 extends T2", "java.util.Map<T, T3>", "java.util.Map<String, Integer>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("String", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.INVARIANT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping_1 = this.assertMapping(_assertMapping, "T2", _mappedTo_3);
    Pair<String,VarianceInfo> _mappedTo_4 = Pair.<String, VarianceInfo>of("Integer", VarianceInfo.INVARIANT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_5 = this.operator_mappedTo(_mappedTo_4, VarianceInfo.INVARIANT);
    this.assertMapping(_assertMapping_1, "T3", _mappedTo_5);
  }
  
  @Test
  public void testCircularTypeParams_01() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends T", "String", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Object", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_02() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends Iterable<T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<Object>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_03() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends Iterable<T>", "T", "java.util.List<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("List<String>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_04() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends Iterable<T>", "Iterable<? extends T>", "java.util.List<String>");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("String", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.INVARIANT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_05() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends Iterable<? extends T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<?>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_06() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends Iterable<T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<Object>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_07() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends Iterable<? super T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<? super Object>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_08() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharIterable<CharSequence>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_09() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("CharIterable<? extends CharSequence>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    this.assertMapping(_mappedBy, "T", _mappedTo_1);
  }
  
  @Test
  public void testCircularTypeParams_10() {
    Multimap<JvmTypeParameter,? extends Object> _mappedBy = this.mappedBy("T extends Iterable<T>, T2 extends Iterable<T>", "CharSequence", "String");
    Pair<String,VarianceInfo> _mappedTo = Pair.<String, VarianceInfo>of("Iterable<Object>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_1 = this.operator_mappedTo(_mappedTo, VarianceInfo.OUT);
    Multimap<JvmTypeParameter,? extends Object> _assertMapping = this.assertMapping(_mappedBy, "T", _mappedTo_1);
    Pair<String,VarianceInfo> _mappedTo_2 = Pair.<String, VarianceInfo>of("Iterable<Iterable<Object>>", VarianceInfo.OUT);
    Triple<String,VarianceInfo,VarianceInfo> _mappedTo_3 = this.operator_mappedTo(_mappedTo_2, VarianceInfo.OUT);
    this.assertMapping(_assertMapping, "T2", _mappedTo_3);
  }
}

package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtend.core.tests.typesystem.AbstractAssignabilityTest;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RawAssignabilityTest extends AbstractAssignabilityTest {
  public boolean doIsAssignable(final LightweightTypeReference lhs, final LightweightTypeReference rhs) {
    TypeConformanceComputationArgument _typeConformanceComputationArgument = new TypeConformanceComputationArgument(true, false, true);
    return lhs.isAssignableFrom(rhs, _typeConformanceComputationArgument);
  }
  
  @Test
  public void testPrimitiveConversion_09() {
    this.isAssignableFrom("Comparable", "int");
    this.isAssignableFrom("Comparable<Integer>", "int");
    this.isAssignableFrom("Comparable<? extends Number>", "int");
    this.isAssignableFrom("Comparable<Number>", "int");
  }
  
  @Test
  public void testWildcardWithDefaultUpper() {
    this.isAssignableFrom("Iterable<? extends Object>", "java.util.List<?>");
  }
  
  @Test
  public void testWildcardLowerBound_02() {
    this.isAssignableFrom("java.util.List<? super Integer>", "java.util.List<? super String>");
  }
  
  @Test
  public void testLeftIsRawType_01() {
    this.isAssignableFrom("java.util.Collection", "java.util.List<? super String>");
  }
  
  @Test
  public void testLeftIsRawType_02() {
    this.isAssignableFrom("java.util.Collection", "java.util.List<? extends String>");
  }
  
  @Test
  public void testLeftIsRawType_03() {
    this.isAssignableFrom("java.util.Collection", "java.util.List<String>");
  }
  
  @Test
  public void testRightIsRawType_01() {
    this.isAssignableFrom("java.util.Collection<? super String>", "java.util.List");
  }
  
  @Test
  public void testRightIsRawType_02() {
    this.isAssignableFrom("java.util.Collection<? extends String>", "java.util.List");
  }
  
  @Test
  public void testRightIsRawType_03() {
    this.isAssignableFrom("java.util.Collection<String>", "java.util.List");
  }
  
  @Test
  public void testInterfaceConformsToObject_01() {
    this.isAssignableFrom("Object", "CharSequence");
  }
  
  @Test
  public void testInterfaceConformsToObject_02() {
    this.isAssignableFrom("Object", "Iterable<CharSequence>");
  }
  
  @Test
  public void testLowerBoundTypeParameter() {
    this.isAssignableFrom("java.util.List<? super String>", "java.util.List<? super CharSequence>");
    this.isAssignableFrom("java.util.List<? super CharSequence>", "java.util.List<? super String>");
  }
  
  @Test
  public void testLowerBoundTypeParameterAndInvariant_01() {
    this.isAssignableFrom("Iterable<? super String>", "java.util.List<CharSequence>");
    this.isAssignableFrom("Iterable<? super CharSequence>", "java.util.List<? super String>");
  }
  
  @Test
  public void testLowerBoundTypeParameterAndInvariant_02() {
    this.isAssignableFrom("Iterable<? super String>", "Iterable<CharSequence>");
    this.isAssignableFrom("Iterable<? super CharSequence>", "Iterable<? super String>");
  }
  
  @Test
  public void testLowerBoundAndUpperBound_01() {
    this.isAssignableFrom("Iterable<? super CharSequence>", "Iterable<? extends String>");
    this.isAssignableFrom("Iterable<? extends CharSequence>", "Iterable<? super String>");
  }
  
  @Test
  public void testWildcardAndInvariant_01() {
    this.isAssignableFrom("Iterable<?>", "Iterable<String>");
    this.isAssignableFrom("Iterable<? extends Object>", "Iterable<String>");
  }
  
  @Test
  public void testWildcardAndUpperBound_01() {
    this.isAssignableFrom("Iterable<?>", "Iterable<? extends String>");
    this.isAssignableFrom("Iterable<? extends Object>", "Iterable<? extends String>");
  }
  
  @Test
  public void testWildcardAndLowerBound_01() {
    this.isAssignableFrom("Iterable<?>", "Iterable<? super String>");
    this.isAssignableFrom("Iterable<? extends Object>", "Iterable<? super String>");
  }
  
  @Test
  public void testBoundTypeParameter_01() {
    this.isAssignableFrom("Iterable<CharSequence>", "org.eclipse.xtend.core.tests.typesystem.CharIterable");
    this.isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable", "Iterable<Character>");
  }
  
  @Test
  public void testBoundTypeParameter_02() {
    this.isAssignableFrom("Iterable<Object>", "org.eclipse.xtend.core.tests.typesystem.CharIterable");
    this.isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable", "Iterable<Object>");
  }
  
  @Test
  public void testUpperBoundTypeParameter() {
    this.isAssignableFrom("java.util.List<? extends String>", "java.util.List<? extends CharSequence>");
    this.isAssignableFrom("java.util.List<? extends CharSequence>", "java.util.List<? extends String>");
  }
  
  @Test
  public void testUpperBoundTypeParameter_02() {
    this.isAssignableFrom("java.util.List<? extends CharSequence>", "java.util.List<? extends String>");
  }
  
  @Test
  public void testInvariantTypeParameter_01() {
    this.isAssignableFrom("java.util.Collection<String>", "java.util.List<CharSequence>");
    this.isAssignableFrom("java.util.Collection<String>", "java.util.List<String>");
    this.isAssignableFrom("java.util.Collection<CharSequence>", "java.util.List<String>");
  }
  
  @Test
  public void testInvariantTypeParameter_02() {
    this.isAssignableFrom("java.util.Map<? extends CharSequence, ? extends Number>", "java.util.Map<? extends String, ? extends Integer>");
    this.isAssignableFrom("java.util.Map<? extends CharSequence, ? extends Number>", "java.util.Map<String, Integer>");
  }
  
  @Test
  public void testInvariantTypeParameter_03() {
    this.isAssignableFrom("Iterable<Iterable<String>>", "Iterable<Iterable<CharSequence>>");
    this.isAssignableFrom("Iterable<Iterable<CharSequence>>", "Iterable<Iterable<String>>");
  }
  
  @Test
  public void testTypeParameter_08() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Iterable<T>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo, "org.eclipse.xtend.core.tests.typesystem.CharIterable<String>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("Iterable<T>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo_1, "org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("Iterable<T>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo_2, "org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends CharSequence>");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("Iterable<? extends T>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo_3, "org.eclipse.xtend.core.tests.typesystem.CharIterable<String>");
    Pair<String,String> _mappedTo_4 = Pair.<String, String>of("Iterable<? extends T>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo_4, "org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>");
    Pair<String,String> _mappedTo_5 = Pair.<String, String>of("Iterable<? extends T>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo_5, "org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends CharSequence>");
    Pair<String,String> _mappedTo_6 = Pair.<String, String>of("Iterable<T>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo_6, "org.eclipse.xtend.core.tests.typesystem.CharIterable");
    Pair<String,String> _mappedTo_7 = Pair.<String, String>of("Iterable<T>", "T extends Number");
    this.isAssignableFrom(_mappedTo_7, "org.eclipse.xtend.core.tests.typesystem.CharIterable");
  }
  
  @Test
  public void testTwoTypeParameters_02() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Iterable<T>", "T, V extends T");
    this.isAssignableFrom(_mappedTo, "Iterable<V>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("Iterable<? extends T>", "T, V extends T");
    this.isAssignableFrom(_mappedTo_1, "Iterable<V>");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("Iterable<? extends T>", "T, V extends T");
    this.isAssignableFrom(_mappedTo_2, "Iterable<? extends V>");
  }
  
  @Test
  public void testTwoTypeParameters_03() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Iterable<? super V>", "T, V extends T");
    this.isAssignableFrom(_mappedTo, "Iterable<? super T>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("Iterable<? super T>", "T, V extends T");
    this.isAssignableFrom(_mappedTo_1, "Iterable<? super V>");
  }
  
  @Test
  public void testFunctionTypes_01() {
    this.isAssignableFrom("(String)=>void", "(CharSequence)=>void");
    this.isAssignableFrom("(String)=>void", "(CharSequence)=>void");
    this.isAssignableFrom("(CharSequence)=>void", "(String)=>void");
  }
  
  @Test
  public void testFunctionTypes_02() {
    this.isAssignableFrom("(String)=>String", "(CharSequence)=>String");
    this.isAssignableFrom("(String)=>String", "(CharSequence)=>String");
    this.isAssignableFrom("(CharSequence)=>String", "(String)=>String");
  }
  
  @Test
  public void testFunctionTypes_03() {
    this.isAssignableFrom("(String)=>CharSequence", "(CharSequence)=>String");
    this.isAssignableFrom("(String)=>CharSequence", "(CharSequence)=>String");
    this.isAssignableFrom("(CharSequence)=>CharSequence", "(String)=>String");
  }
  
  @Test
  public void testFunctionTypes_08() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("(T)=>T", "T extends Integer");
    this.isAssignableFrom(_mappedTo, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("(T)=>T", "T extends Integer");
    this.isAssignableFrom(_mappedTo_1, "(int)=>int");
  }
}

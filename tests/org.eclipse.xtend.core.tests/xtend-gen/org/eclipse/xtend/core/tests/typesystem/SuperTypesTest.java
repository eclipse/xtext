/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import java.util.Collection;
import java.util.List;
import org.eclipse.xtend.core.tests.typesystem.AbstractSuperTypesTest;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class SuperTypesTest extends AbstractSuperTypesTest {
  @Override
  public Iterable<LightweightTypeReference> collectSuperTypes(final LightweightTypeReference reference) {
    return reference.getSuperTypes();
  }
  
  @Test
  @Override
  public void testString() {
    this.assertSuperTypes(String.class, "Serializable", "Comparable<String>", "CharSequence");
  }
  
  @Test
  @Override
  public void testRawCollection() {
    this.assertSuperTypes(Collection.class, "Iterable");
  }
  
  @Test
  @Override
  public void testStringCollection() {
    this.assertSuperTypes("java.util.Collection<String>", "Iterable<String>");
  }
  
  @Test
  @Override
  public void testStringArray() {
    this.assertSuperTypes("String[]", "Serializable[]", "Comparable<String>[]", "CharSequence[]");
  }
  
  @Test
  @Override
  public void testObjectArray() {
    this.assertSuperTypes("Object[]", "Cloneable", "Serializable");
  }
  
  @Test
  @Override
  public void testPrimitiveArray() {
    this.assertSuperTypes("int[]", "Cloneable", "Serializable");
  }
  
  @Test
  @Override
  public void testRawList() {
    this.assertSuperTypes(List.class, "Collection");
  }
  
  @Test
  @Override
  public void testStringList() {
    this.assertSuperTypes("java.util.List<String>", "Collection<String>");
  }
  
  @Test
  @Override
  public void testStringArrayArrayList() {
    this.assertSuperTypes("java.util.ArrayList<? extends String[]>", 
      "AbstractList<? extends String[]>", 
      "List<? extends String[]>", 
      "RandomAccess", 
      "Cloneable", 
      "Serializable");
  }
  
  @Test
  @Override
  public void testTypeParameters() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("T", "T extends CharSequence");
    this.assertSuperTypes(_mappedTo, "CharSequence");
  }
  
  @Test
  @Override
  public void testTypeParameterArray() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("T", "T extends CharSequence[]");
    this.assertSuperTypes(_mappedTo, "CharSequence[]");
  }
  
  @Test
  @Override
  public void testDependentTypeParameters() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("T", "V, T extends V");
    this.assertSuperTypes(_mappedTo, "V");
  }
  
  @Test
  @Override
  public void testDependentTypeParametersWithBounds() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("T", "V extends CharSequence, T extends V");
    this.assertSuperTypes(_mappedTo, "V");
  }
  
  @Test
  @Override
  public void testParameterizedInnerTypes_01() {
    this.assertSuperTypes("test.InnerClasses.SubString<Number>.SubInner<CharSequence>", "Super<String>$Inner<CharSequence>");
  }
  
  @Test
  @Override
  public void testParameterizedInnerTypes_02() {
    this.assertSuperTypes("test.InnerClasses.Sub<Number>.SubInner2<CharSequence>", "Super<Number>$Inner<Number>");
  }
  
  @Test
  @Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=442013")
  @Override
  public void testParameterizedInnerTypes_03() {
    this.assertSuperTypes("test.InnerClasses.Sub3.Inner2<Number>", "Super3<String>$Inner<Number>");
  }
  
  @Test
  @Override
  public void testParameterizedInnerTypes_04() {
    this.assertSuperTypes("test.InnerClasses.Sub4<Number>.Inner3<CharSequence>", "Super3<String>$Inner2<Number>");
  }
}

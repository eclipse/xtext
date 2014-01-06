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
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class SuperTypesTest extends AbstractSuperTypesTest {
  public Iterable<LightweightTypeReference> collectSuperTypes(final LightweightTypeReference reference) {
    return reference.getSuperTypes();
  }
  
  @Test
  public void testString() {
    this.assertSuperTypes(String.class, "Serializable", "Comparable<String>", "CharSequence");
  }
  
  @Test
  public void testRawCollection() {
    this.assertSuperTypes(Collection.class, "Iterable");
  }
  
  @Test
  public void testStringCollection() {
    this.assertSuperTypes("java.util.Collection<String>", "Iterable<String>");
  }
  
  @Test
  public void testStringArray() {
    this.assertSuperTypes("String[]", "Serializable[]", "Comparable<String>[]", "CharSequence[]");
  }
  
  @Test
  public void testObjectArray() {
    this.assertSuperTypes("Object[]", "Cloneable", "Serializable");
  }
  
  @Test
  public void testPrimitiveArray() {
    this.assertSuperTypes("int[]", "Cloneable", "Serializable");
  }
  
  @Test
  public void testRawList() {
    this.assertSuperTypes(List.class, "Collection");
  }
  
  @Test
  public void testStringList() {
    this.assertSuperTypes("java.util.List<String>", "Collection<String>");
  }
  
  @Test
  public void testStringArrayArrayList() {
    this.assertSuperTypes("java.util.ArrayList<? extends String[]>", 
      "AbstractList<? extends String[]>", 
      "List<? extends String[]>", 
      "RandomAccess", 
      "Cloneable", 
      "Serializable");
  }
  
  @Test
  public void testTypeParameters() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T extends CharSequence");
    this.assertSuperTypes(_mappedTo, "CharSequence");
  }
  
  @Test
  public void testTypeParameterArray() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T extends CharSequence[]");
    this.assertSuperTypes(_mappedTo, "CharSequence[]");
  }
  
  @Test
  public void testDependentTypeParameters() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "V, T extends V");
    this.assertSuperTypes(_mappedTo, "V");
  }
  
  @Test
  public void testDependentTypeParametersWithBounds() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "V extends CharSequence, T extends V");
    this.assertSuperTypes(_mappedTo, "V");
  }
}

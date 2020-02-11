/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator;

import java.util.Collections;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TypeReferenceTest {
  /**
   * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=480196
   */
  @Test
  public void testDefaultPackage() {
    final TypeReference ref = TypeReference.typeRef("EString");
    Assert.assertEquals("", ref.getPackageName());
    Assert.assertEquals("EString", ref.getSimpleName());
  }
  
  @Test
  public void testUnderscopresAnd$() {
    final TypeReference ref = TypeReference.typeRef("E_$tring");
    Assert.assertEquals("", ref.getPackageName());
    Assert.assertEquals("E_$tring", ref.getSimpleName());
  }
  
  @Test
  public void testUnderscopresAnd$02() {
    final TypeReference ref = TypeReference.typeRef("$.$._$.E_$tring");
    Assert.assertEquals("$.$._$", ref.getPackageName());
    Assert.assertEquals("E_$tring", ref.getSimpleName());
  }
  
  @Test
  public void testPackageName() {
    final TypeReference ref = TypeReference.typeRef("org.example.MyType");
    Assert.assertEquals("MyType", ref.getSimpleName());
    Assert.assertEquals("org.example", ref.getPackageName());
  }
  
  @Test
  public void testParametrizedType() {
    final TypeReference ref = TypeReference.typeRef("java.util.List", TypeReference.typeRef("String"));
    Assert.assertEquals("List", ref.getSimpleName());
    Assert.assertEquals("java.util", ref.getPackageName());
    Assert.assertEquals("String", IterableExtensions.<TypeReference>head(ref.getTypeArguments()).getSimpleName());
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testWrongNestedTypeUsage() {
    TypeReference.typeRef("java.util.Map.Entry");
  }
  
  @Test
  public void testNestedType() {
    final TypeReference ref = new TypeReference("java.util", "Map.Entry");
    Assert.assertEquals("java.util", ref.getPackageName());
    Assert.assertEquals("Entry", ref.getSimpleName());
    Assert.assertEquals(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Map", "Entry")), ref.getSimpleNames());
  }
  
  @Test
  public void testLowerCaseNestedType() {
    final TypeReference ref = new TypeReference("java.util", "Map.entry");
    Assert.assertEquals("java.util", ref.getPackageName());
    Assert.assertEquals("entry", ref.getSimpleName());
    Assert.assertEquals(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Map", "entry")), ref.getSimpleNames());
  }
  
  @Test
  @Deprecated
  public void testGuessTypeRef() {
    final TypeReference ref = TypeReference.guessTypeRef("java.util.Map.Entry");
    Assert.assertEquals("java.util", ref.getPackageName());
    Assert.assertEquals("Entry", ref.getSimpleName());
    Assert.assertEquals(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Map", "Entry")), ref.getSimpleNames());
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalTypeRef() {
    TypeReference.typeRef("java.util.Map.Entry");
  }
  
  @Test
  public void testJavaPath() {
    final TypeReference ref = TypeReference.typeRef("org.example.MyType");
    Assert.assertEquals("org/example/MyType.java", ref.getJavaPath());
  }
  
  @Test
  public void testXtendPath() {
    final TypeReference ref = TypeReference.typeRef("org.example.MyType");
    Assert.assertEquals("org/example/MyType.xtend", ref.getXtendPath());
  }
  
  @Test
  public void testEObject() {
    final ResourceSetImpl rs = new ResourceSetImpl();
    final TypeReference ref = new TypeReference(EcorePackage.Literals.EOBJECT, rs);
    Assert.assertEquals("org.eclipse.emf.ecore.EObject", ref.getName());
  }
  
  @Test
  public void testBug508810() {
    final ResourceSetImpl rs = new ResourceSetImpl();
    final TypeReference ref = new TypeReference(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, rs);
    Assert.assertEquals("java.util.Map.Entry", ref.getName());
  }
}

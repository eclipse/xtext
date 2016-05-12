/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator;

import java.util.Collections;
import java.util.List;
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
    String _packageName = ref.getPackageName();
    Assert.assertEquals("", _packageName);
    String _simpleName = ref.getSimpleName();
    Assert.assertEquals("EString", _simpleName);
  }
  
  @Test
  public void testUnderscopresAnd$() {
    final TypeReference ref = TypeReference.typeRef("E_$tring");
    String _packageName = ref.getPackageName();
    Assert.assertEquals("", _packageName);
    String _simpleName = ref.getSimpleName();
    Assert.assertEquals("E_$tring", _simpleName);
  }
  
  @Test
  public void testUnderscopresAnd$02() {
    final TypeReference ref = TypeReference.typeRef("$.$._$.E_$tring");
    String _packageName = ref.getPackageName();
    Assert.assertEquals("$.$._$", _packageName);
    String _simpleName = ref.getSimpleName();
    Assert.assertEquals("E_$tring", _simpleName);
  }
  
  @Test
  public void testPackageName() {
    final TypeReference ref = TypeReference.typeRef("org.example.MyType");
    String _simpleName = ref.getSimpleName();
    Assert.assertEquals("MyType", _simpleName);
    String _packageName = ref.getPackageName();
    Assert.assertEquals("org.example", _packageName);
  }
  
  @Test
  public void testParametrizedType() {
    TypeReference _typeRef = TypeReference.typeRef("String");
    final TypeReference ref = TypeReference.typeRef("java.util.List", _typeRef);
    String _simpleName = ref.getSimpleName();
    Assert.assertEquals("List", _simpleName);
    String _packageName = ref.getPackageName();
    Assert.assertEquals("java.util", _packageName);
    List<TypeReference> _typeArguments = ref.getTypeArguments();
    TypeReference _head = IterableExtensions.<TypeReference>head(_typeArguments);
    String _simpleName_1 = _head.getSimpleName();
    Assert.assertEquals("String", _simpleName_1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testWrongNestedTypeUsage() {
    TypeReference.typeRef("java.util.Map.Entry");
  }
  
  @Test
  public void testNestedType() {
    final TypeReference ref = new TypeReference("java.util", "Map.Entry");
    String _packageName = ref.getPackageName();
    Assert.assertEquals("java.util", _packageName);
    String _simpleName = ref.getSimpleName();
    Assert.assertEquals("Entry", _simpleName);
    List<String> _simpleNames = ref.getSimpleNames();
    Assert.assertEquals(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Map", "Entry")), _simpleNames);
  }
  
  @Test
  public void testLowerCaseNestedType() {
    final TypeReference ref = new TypeReference("java.util", "Map.entry");
    String _packageName = ref.getPackageName();
    Assert.assertEquals("java.util", _packageName);
    String _simpleName = ref.getSimpleName();
    Assert.assertEquals("entry", _simpleName);
    List<String> _simpleNames = ref.getSimpleNames();
    Assert.assertEquals(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Map", "entry")), _simpleNames);
  }
  
  @Test
  public void testGuessTypeRef() {
    final TypeReference ref = TypeReference.guessTypeRef("java.util.Map.Entry");
    String _packageName = ref.getPackageName();
    Assert.assertEquals("java.util", _packageName);
    String _simpleName = ref.getSimpleName();
    Assert.assertEquals("Entry", _simpleName);
    List<String> _simpleNames = ref.getSimpleNames();
    Assert.assertEquals(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Map", "Entry")), _simpleNames);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalTypeRef() {
    TypeReference.typeRef("java.util.Map.Entry");
  }
  
  @Test
  public void testJavaPath() {
    final TypeReference ref = TypeReference.typeRef("org.example.MyType");
    String _javaPath = ref.getJavaPath();
    Assert.assertEquals("org/example/MyType.java", _javaPath);
  }
  
  @Test
  public void testXtendPath() {
    final TypeReference ref = TypeReference.typeRef("org.example.MyType");
    String _xtendPath = ref.getXtendPath();
    Assert.assertEquals("org/example/MyType.xtend", _xtendPath);
  }
  
  @Test
  public void testEObject() {
    final ResourceSetImpl rs = new ResourceSetImpl();
    final TypeReference ref = new TypeReference(EcorePackage.Literals.EOBJECT, rs);
    String _name = ref.getName();
    Assert.assertEquals("org.eclipse.emf.ecore.EObject", _name);
  }
}

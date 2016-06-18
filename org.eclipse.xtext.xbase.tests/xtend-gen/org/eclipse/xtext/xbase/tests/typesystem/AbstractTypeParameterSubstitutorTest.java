/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractTypeParameterSubstitutorTest extends AbstractXbaseTestCase {
  @Inject
  private TypeReferences typeReferences;
  
  private XtextResourceSet resourceSet;
  
  @Before
  public void createResourceSet() {
    XtextResourceSet _get = this.<XtextResourceSet>get(XtextResourceSet.class);
    this.resourceSet = _get;
  }
  
  @After
  public void tearDown() {
    this.resourceSet = null;
  }
  
  public abstract String resolve(final JvmTypeReference declaration, final JvmTypeReference reference);
  
  @Test
  public void testResolve_01() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(TypeResolutionTestData.NestedList.class, this.resourceSet);
    final JvmTypeReference resolveMe = declaration;
    final String resolved = this.resolve(declaration, resolveMe);
    Assert.assertEquals("NestedList<T>", resolved);
  }
  
  @Test
  public void testResolve_02() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(TypeResolutionTestData.NestedList.class, this.resourceSet);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(List.class, this.resourceSet);
    final String resolved = this.resolve(declaration, resolveMe);
    Assert.assertEquals("List<List<T>>", resolved);
  }
  
  @Test
  public void testResolve_03() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(TypeResolutionTestData.NestedList.class, this.resourceSet);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Iterable.class, this.resourceSet);
    final String resolved = this.resolve(declaration, resolveMe);
    Assert.assertEquals("Iterable<List<T>>", resolved);
  }
  
  @Test
  public void testResolve_04() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(TypeResolutionTestData.NestedList.class, this.resourceSet);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Iterable.class, this.resourceSet);
    final String resolved = this.resolve(declaration, resolveMe);
    Assert.assertEquals("Iterable<List<T>>", resolved);
  }
  
  @Test
  public void testResolve_05() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(RetentionPolicy.class, this.resourceSet);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Enum.class, this.resourceSet);
    final String resolved = this.resolve(declaration, resolveMe);
    Assert.assertEquals("Enum<RetentionPolicy>", resolved);
  }
}

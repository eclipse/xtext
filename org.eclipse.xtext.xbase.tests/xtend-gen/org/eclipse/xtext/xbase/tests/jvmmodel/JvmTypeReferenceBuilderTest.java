/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmTypeReferenceBuilderTest extends AbstractJvmModelTest {
  @Inject
  private JvmTypeReferenceBuilder.Factory typeReferenceBuilderFactory;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Extension
  private JvmTypeReferenceBuilder typeReferenceBuilder;
  
  @Before
  public void setUp() {
    this.typeReferenceBuilder = this.typeReferenceBuilderFactory.create(this.resourceSetProvider.get());
  }
  
  @Test
  public void testTypeRef_01() {
    final JvmTypeReference stringType = this.typeReferenceBuilder.typeRef(String.class);
    Assert.assertEquals("java.lang.String", stringType.getIdentifier());
  }
  
  @Test
  public void testTypeRef_02() {
    JvmTypeReference _typeRef = this.typeReferenceBuilder.typeRef(List.class);
    final JvmParameterizedTypeReference type = ((JvmParameterizedTypeReference) _typeRef);
    Assert.assertEquals("java.util.List", type.getIdentifier());
    Assert.assertTrue(type.getArguments().isEmpty());
  }
  
  @Test
  public void testTypeRef_03() {
    try {
      this.typeReferenceBuilder.typeRef(List.class, this.typeReferenceBuilder.typeRef(String.class), this.typeReferenceBuilder.typeRef(String.class));
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testTypeRef_04() {
    try {
      this.typeReferenceBuilder.typeRef(List[].class, this.typeReferenceBuilder.typeRef(String.class));
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testTypeRef_05() {
    final JvmTypeReference typeRef = this.typeReferenceBuilder.typeRef("hubble.Fubble", this.typeReferenceBuilder.typeRef(String.class));
    Assert.assertTrue((typeRef instanceof JvmUnknownTypeReference));
    Assert.assertEquals("hubble.Fubble", typeRef.getQualifiedName());
  }
  
  @Test
  public void testWildcard_01() {
    JvmTypeReference _wildcard = this.typeReferenceBuilder.wildcard();
    Assert.assertEquals("java.lang.Object", IterableExtensions.<JvmTypeConstraint>head(((JvmWildcardTypeReference) _wildcard).getConstraints()).getTypeReference().getIdentifier());
  }
  
  @Test
  public void testWildcard_02() {
    JvmTypeReference _wildcardExtends = this.typeReferenceBuilder.wildcardExtends(this.typeReferenceBuilder.typeRef(CharSequence.class));
    final EList<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) _wildcardExtends).getConstraints();
    Assert.assertEquals(1, constraints.size());
    Assert.assertEquals("java.lang.CharSequence", IterableExtensions.<JvmUpperBound>head(Iterables.<JvmUpperBound>filter(constraints, JvmUpperBound.class)).getTypeReference().getIdentifier());
  }
  
  @Test
  public void testWildcard_03() {
    JvmTypeReference _wildcardSuper = this.typeReferenceBuilder.wildcardSuper(this.typeReferenceBuilder.typeRef(CharSequence.class));
    final EList<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) _wildcardSuper).getConstraints();
    Assert.assertEquals(2, constraints.size());
    Assert.assertEquals("java.lang.CharSequence", IterableExtensions.<JvmLowerBound>head(Iterables.<JvmLowerBound>filter(constraints, JvmLowerBound.class)).getTypeReference().getIdentifier());
  }
}

/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
    XtextResourceSet _get = this.resourceSetProvider.get();
    JvmTypeReferenceBuilder _create = this.typeReferenceBuilderFactory.create(_get);
    this.typeReferenceBuilder = _create;
  }
  
  @Test
  public void testTypeRef_01() {
    final JvmTypeReference stringType = this.typeReferenceBuilder.typeRef(String.class);
    String _identifier = stringType.getIdentifier();
    Assert.assertEquals("java.lang.String", _identifier);
  }
  
  @Test
  public void testTypeRef_02() {
    JvmTypeReference _typeRef = this.typeReferenceBuilder.typeRef(List.class);
    final JvmParameterizedTypeReference type = ((JvmParameterizedTypeReference) _typeRef);
    String _identifier = type.getIdentifier();
    Assert.assertEquals("java.util.List", _identifier);
    EList<JvmTypeReference> _arguments = type.getArguments();
    boolean _isEmpty = _arguments.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testTypeRef_03() {
    try {
      JvmTypeReference _typeRef = this.typeReferenceBuilder.typeRef(String.class);
      JvmTypeReference _typeRef_1 = this.typeReferenceBuilder.typeRef(String.class);
      this.typeReferenceBuilder.typeRef(List.class, _typeRef, _typeRef_1);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testTypeRef_04() {
    try {
      JvmTypeReference _typeRef = this.typeReferenceBuilder.typeRef(String.class);
      this.typeReferenceBuilder.typeRef(List[].class, _typeRef);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testTypeRef_05() {
    JvmTypeReference _typeRef = this.typeReferenceBuilder.typeRef(String.class);
    final JvmTypeReference typeRef = this.typeReferenceBuilder.typeRef("hubble.Fubble", _typeRef);
    Assert.assertTrue((typeRef instanceof JvmUnknownTypeReference));
    String _qualifiedName = typeRef.getQualifiedName();
    Assert.assertEquals("hubble.Fubble", _qualifiedName);
  }
  
  @Test
  public void testWildcard_01() {
    JvmTypeReference _wildcard = this.typeReferenceBuilder.wildcard();
    EList<JvmTypeConstraint> _constraints = ((JvmWildcardTypeReference) _wildcard).getConstraints();
    JvmTypeConstraint _head = IterableExtensions.<JvmTypeConstraint>head(_constraints);
    JvmTypeReference _typeReference = _head.getTypeReference();
    String _identifier = _typeReference.getIdentifier();
    Assert.assertEquals("java.lang.Object", _identifier);
  }
  
  @Test
  public void testWildcard_02() {
    JvmTypeReference _typeRef = this.typeReferenceBuilder.typeRef(CharSequence.class);
    JvmTypeReference _wildcardExtends = this.typeReferenceBuilder.wildcardExtends(_typeRef);
    final EList<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) _wildcardExtends).getConstraints();
    int _size = constraints.size();
    Assert.assertEquals(1, _size);
    Iterable<JvmUpperBound> _filter = Iterables.<JvmUpperBound>filter(constraints, JvmUpperBound.class);
    JvmUpperBound _head = IterableExtensions.<JvmUpperBound>head(_filter);
    JvmTypeReference _typeReference = _head.getTypeReference();
    String _identifier = _typeReference.getIdentifier();
    Assert.assertEquals("java.lang.CharSequence", _identifier);
  }
  
  @Test
  public void testWildcard_03() {
    JvmTypeReference _typeRef = this.typeReferenceBuilder.typeRef(CharSequence.class);
    JvmTypeReference _wildcardSuper = this.typeReferenceBuilder.wildcardSuper(_typeRef);
    final EList<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) _wildcardSuper).getConstraints();
    int _size = constraints.size();
    Assert.assertEquals(2, _size);
    Iterable<JvmLowerBound> _filter = Iterables.<JvmLowerBound>filter(constraints, JvmLowerBound.class);
    JvmLowerBound _head = IterableExtensions.<JvmLowerBound>head(_filter);
    JvmTypeReference _typeReference = _head.getTypeReference();
    String _identifier = _typeReference.getIdentifier();
    Assert.assertEquals("java.lang.CharSequence", _identifier);
  }
}

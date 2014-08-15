/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResolvedTypesTest extends AbstractXbaseTestCase {
  @Inject
  @Accessors
  private PublicReentrantTypeResolver resolver;
  
  private TypesFactory typesFactory = TypesFactory.eINSTANCE;
  
  private XbaseFactory xbaseFactory = XbaseFactory.eINSTANCE;
  
  @Accessors
  private PublicResolvedTypes testMe;
  
  @Before
  public void initResolvedTypes() {
    try {
      final XExpression expression = this.expression("null");
      this.resolver.initializeFrom(expression);
      PublicResolvedTypes _publicResolvedTypes = new PublicResolvedTypes(this.resolver);
      this.testMe = _publicResolvedTypes;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiagnostics() {
    List<Object> _emptyList = CollectionLiterals.<Object>emptyList();
    Collection<AbstractDiagnostic> _queuedDiagnostics = this.testMe.getQueuedDiagnostics();
    Assert.assertEquals(((Object) _emptyList), _queuedDiagnostics);
  }
  
  @Test
  public void testActualTypeArguments() {
    List<LightweightTypeReference> _actualTypeArguments = this.testMe.getActualTypeArguments(null);
    boolean _isEmpty = _actualTypeArguments.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testCreateAndGetUnboundTypeParameter() {
    XFeatureCall _createXFeatureCall = this.xbaseFactory.createXFeatureCall();
    JvmTypeParameter _createJvmTypeParameter = this.typesFactory.createJvmTypeParameter();
    final UnboundTypeReference unbound = this.testMe.createUnboundTypeReference(_createXFeatureCall, _createJvmTypeParameter);
    Object _handle = unbound.getHandle();
    UnboundTypeReference _unboundTypeReference = this.testMe.getUnboundTypeReference(_handle);
    Assert.assertSame(unbound, _unboundTypeReference);
  }
  
  @Test(expected = IllegalStateException.class)
  public void testTryGetUnknownUnboundTypeParameter() {
    this.testMe.getUnboundTypeReference("unknown handle");
  }
  
  @Pure
  public PublicReentrantTypeResolver getResolver() {
    return this.resolver;
  }
  
  public void setResolver(final PublicReentrantTypeResolver resolver) {
    this.resolver = resolver;
  }
  
  @Pure
  public PublicResolvedTypes getTestMe() {
    return this.testMe;
  }
  
  public void setTestMe(final PublicResolvedTypes testMe) {
    this.testMe = testMe;
  }
}

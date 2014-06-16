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
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
  @Property
  private PublicReentrantTypeResolver _resolver;
  
  private TypesFactory typesFactory = TypesFactory.eINSTANCE;
  
  private XbaseFactory xbaseFactory = XbaseFactory.eINSTANCE;
  
  @Property
  private PublicResolvedTypes _testMe;
  
  @Before
  public void initResolvedTypes() {
    PublicReentrantTypeResolver _resolver = this.getResolver();
    PublicResolvedTypes _publicResolvedTypes = new PublicResolvedTypes(_resolver);
    this.setTestMe(_publicResolvedTypes);
  }
  
  @Test
  public void testDiagnostics() {
    List<Object> _emptyList = CollectionLiterals.<Object>emptyList();
    PublicResolvedTypes _testMe = this.getTestMe();
    Collection<AbstractDiagnostic> _queuedDiagnostics = _testMe.getQueuedDiagnostics();
    Assert.assertEquals(((Object) _emptyList), _queuedDiagnostics);
  }
  
  @Test
  public void testActualTypeArguments() {
    PublicResolvedTypes _testMe = this.getTestMe();
    List<LightweightTypeReference> _actualTypeArguments = _testMe.getActualTypeArguments(null);
    boolean _isEmpty = _actualTypeArguments.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testCreateAndGetUnboundTypeParameter() {
    PublicResolvedTypes _testMe = this.getTestMe();
    XFeatureCall _createXFeatureCall = this.xbaseFactory.createXFeatureCall();
    JvmTypeParameter _createJvmTypeParameter = this.typesFactory.createJvmTypeParameter();
    final UnboundTypeReference unbound = _testMe.createUnboundTypeReference(_createXFeatureCall, _createJvmTypeParameter);
    PublicResolvedTypes _testMe_1 = this.getTestMe();
    Object _handle = unbound.getHandle();
    UnboundTypeReference _unboundTypeReference = _testMe_1.getUnboundTypeReference(_handle);
    Assert.assertSame(unbound, _unboundTypeReference);
  }
  
  @Test(expected = IllegalStateException.class)
  public void testTryGetUnknownUnboundTypeParameter() {
    PublicResolvedTypes _testMe = this.getTestMe();
    _testMe.getUnboundTypeReference("unknown handle");
  }
  
  @Pure
  public PublicReentrantTypeResolver getResolver() {
    return this._resolver;
  }
  
  public void setResolver(final PublicReentrantTypeResolver resolver) {
    this._resolver = resolver;
  }
  
  @Pure
  public PublicResolvedTypes getTestMe() {
    return this._testMe;
  }
  
  public void setTestMe(final PublicResolvedTypes testMe) {
    this._testMe = testMe;
  }
}

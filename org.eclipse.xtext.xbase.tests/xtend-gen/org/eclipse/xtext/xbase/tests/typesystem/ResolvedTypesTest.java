/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
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
    Assert.assertEquals(((Object) _emptyList), this.testMe.getQueuedDiagnostics());
  }
  
  @Test
  public void testActualTypeArguments() {
    Assert.assertTrue(this.testMe.getActualTypeArguments(null).isEmpty());
  }
  
  @Test
  public void testCreateAndGetUnboundTypeParameter() {
    final UnboundTypeReference unbound = this.testMe.createUnboundTypeReference(this.xbaseFactory.createXFeatureCall(), this.typesFactory.createJvmTypeParameter());
    Assert.assertSame(unbound, this.testMe.getUnboundTypeReference(unbound.getHandle()));
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

/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.junit.typesystem.Oven;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractSmokeTest extends AbstractTypeResolverTest<LightweightTypeReference> {
  @Inject
  @Extension
  private Oven _oven;
  
  public LightweightTypeReference resolvesTo(final String expression, final String type, final boolean expectWarning) {
    try {
      this.assertNonSmoking(expression);
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void isFunctionAndEquivalentTo(final LightweightTypeReference reference, final String type) {
  }
  
  protected void handleDuplicateExpression(final CharSequence expression) {
  }
  
  /**
   * Processes the input and uses permutations of it to check for raised exceptions.
   */
  public abstract void assertNonSmoking(final String input) throws Exception;
  
  public void processExpression(final String expression) throws Exception {
    this._oven.fireproof(expression);
  }
  
  @Test
  public void testOverloadedOperators_11() throws Exception {
    super.testOverloadedOperators_11();
  }
  
  @Test
  public void testOverloadedOperators_13() throws Exception {
    super.testOverloadedOperators_13();
  }
  
  @Test
  public void testClosure_14() throws Exception {
    super.testClosure_14();
  }
  
  @Test
  public void testClosure_32() throws Exception {
    super.testClosure_32();
  }
  
  @Ignore("Disable block expression with 1000+ lines")
  @Test
  public void testBlockExpression_03() throws Exception {
    super.testBlockExpression_03();
  }
  
  @Ignore("Disable member feature calls with plenty of nested target expressions")
  @Test
  public void testFeatureCall_15_m() throws Exception {
    super.testFeatureCall_15_m();
  }
}

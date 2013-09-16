/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractOldAPITypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class LegacyTypeResolverTest extends AbstractOldAPITypeResolverTest {
  @Inject
  private ITypeProvider typeProvider;
  
  protected ITypeProvider getTypeProvider() {
    return this.typeProvider;
  }
  
  @Test
  public void testSetup() {
    Assert.assertTrue((this.typeProvider instanceof XbaseBatchTypeProvider));
  }
  
  @Ignore("TODO discuss the preference - list or array?")
  @Test
  public void testIfExpression_10() throws Exception {
    super.testIfExpression_10();
  }
}

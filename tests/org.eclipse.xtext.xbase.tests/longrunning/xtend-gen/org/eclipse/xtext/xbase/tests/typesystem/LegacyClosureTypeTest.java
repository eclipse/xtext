/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractOldAPIClosureTypeTest;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class LegacyClosureTypeTest extends AbstractOldAPIClosureTypeTest {
  @Inject
  private ITypeProvider typeProvider;
  
  protected ITypeProvider getTypeProvider() {
    return this.typeProvider;
  }
  
  @Test
  public void testSetup() {
    Assert.assertTrue((this.typeProvider instanceof XbaseBatchTypeProvider));
  }
  
  @Ignore("TODO the assertion should hold")
  @Test
  public void testClosure_51() throws Exception {
    super.testClosure_51();
  }
  
  @Ignore("TODO the assertion should hold")
  @Test
  public void testClosure_52() throws Exception {
    super.testClosure_52();
  }
}

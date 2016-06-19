/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.xtend.core.tests.linking.LinkingShadowingTest;
import org.eclipse.xtend.core.tests.linking.RuntimeInjectorProviderWithReversedCandidates;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProviderWithReversedCandidates.class)
@SuppressWarnings("all")
public class LinkingShadowingWithReversedCandidatesTest extends LinkingShadowingTest {
  @Ignore("TODO")
  @Test
  @Override
  public void testOperation_implicitArgumentOnThis_shadows_implicitArgumentOnExtension() throws Exception {
    super.testOperation_implicitArgumentOnThis_shadows_implicitArgumentOnExtension();
  }
  
  @Ignore("TODO")
  @Test
  @Override
  public void testOperation_sugarImplicitArgumentOnThis_shadows_sugarImplicitArgumentOnExtension() throws Exception {
    super.testOperation_sugarImplicitArgumentOnThis_shadows_sugarImplicitArgumentOnExtension();
  }
}

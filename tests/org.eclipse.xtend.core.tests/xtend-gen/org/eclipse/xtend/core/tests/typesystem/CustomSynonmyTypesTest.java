/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse def License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtend.core.tests.typesystem.RuntimeInjectorProviderWithCustomSynonyms;
import org.eclipse.xtend.core.tests.typesystem.SynonmyTypesTest;
import org.eclipse.xtext.junit4.InjectWith;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(RuntimeInjectorProviderWithCustomSynonyms.class)
@SuppressWarnings("all")
public class CustomSynonmyTypesTest extends SynonmyTypesTest {
  @Test
  public void testBigIntegerToBigDecimal() {
    this.hasSynonyms("java.math.BigInteger", "BigDecimal");
  }
}

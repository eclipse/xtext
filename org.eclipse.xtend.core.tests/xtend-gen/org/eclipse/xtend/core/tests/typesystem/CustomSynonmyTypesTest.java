/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtext.testing.InjectWith;
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

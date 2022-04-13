/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtext.testing.InjectWith;
import org.junit.Test;

@InjectWith(RuntimeInjectorProviderWithCustomSynonyms.class)
@SuppressWarnings("all")
public class AssignabilityWithCustomSynonymsTest extends AbstractAssignabilityTest {
  @Test
  public void testBigIntegerIsBigDecimal() {
    this.isAssignableFrom("java.math.BigDecimal", "java.math.BigInteger");
  }

  @Test
  public void testIterableBigIntegerIsNotIterableBigDecimal() {
    this.isNotAssignableFrom("Iterable<java.math.BigDecimal>", "Iterable<java.math.BigInteger>");
  }
}

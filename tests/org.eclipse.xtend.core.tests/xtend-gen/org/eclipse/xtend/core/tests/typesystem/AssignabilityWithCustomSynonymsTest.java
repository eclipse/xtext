/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtend.core.tests.typesystem.AbstractAssignabilityTest;
import org.eclipse.xtend.core.tests.typesystem.RuntimeInjectorProviderWithCustomSynonyms;
import org.eclipse.xtext.junit4.InjectWith;
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

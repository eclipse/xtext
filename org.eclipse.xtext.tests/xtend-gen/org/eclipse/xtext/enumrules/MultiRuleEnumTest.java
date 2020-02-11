/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.enumrules;

import org.eclipse.xtext.enumrules.multiRuleenums.MyEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class MultiRuleEnumTest {
  /**
   * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=413395
   */
  @Test
  public void testEnumOrder() {
    Assert.assertEquals(0, MyEnum.A_VALUE);
    Assert.assertEquals(1, MyEnum.B_VALUE);
    Assert.assertEquals(2, MyEnum.C_VALUE);
    Assert.assertEquals(3, MyEnum.D_VALUE);
    Assert.assertEquals(4, MyEnum.E_VALUE);
  }
}

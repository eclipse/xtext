/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.lib;

import java.util.Objects;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Mathias Rieder - Initial contribution and API
 */
@SuppressWarnings("all")
public class ArrayExtensionsBooleanTest {
  private boolean[] data;

  @Before
  public void init() {
    this.data = this.createData();
  }

  private boolean[] createData() {
    final boolean[] array = new boolean[3];
    array[0] = true;
    array[1] = false;
    array[2] = true;
    return array;
  }

  @Test
  public void testSetGet__boolean() {
    Assert.assertTrue(this.data[0]);
    Assert.assertFalse(this.data[1]);
    Assert.assertTrue(this.data[2]);
  }

  @Test
  public void testClone__boolean() {
    final boolean[] clonedData = this.data.clone();
    Assert.assertTrue(clonedData[0]);
    Assert.assertFalse(clonedData[1]);
    Assert.assertTrue(clonedData[2]);
  }

  @Test
  public void testLength__boolean() {
    Assert.assertEquals(3, this.data.length);
  }

  @Test
  public void testHashCode__boolean() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }

  @Test
  public void testEquals__boolean() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    boolean[] _createData = this.createData();
    final Procedure1<boolean[]> _function = (boolean[] it) -> {
      it[1] = true;
    };
    final boolean[] newData = ObjectExtensions.<boolean[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }

  @Test
  public void testContains__boolean() {
    Assert.assertTrue(ArrayExtensions.contains(this.data, true));
    Assert.assertTrue(ArrayExtensions.contains(this.data, false));
    boolean[] _newBooleanArrayOfSize = new boolean[2];
    final Procedure1<boolean[]> _function = (boolean[] it) -> {
      it[0] = false;
      it[1] = false;
    };
    final boolean[] onlyFalse = ObjectExtensions.<boolean[]>operator_doubleArrow(_newBooleanArrayOfSize, _function);
    Assert.assertFalse(ArrayExtensions.contains(onlyFalse, true));
    Assert.assertTrue(ArrayExtensions.contains(onlyFalse, false));
  }
}

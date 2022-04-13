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
public class ArrayExtensionsLongTest {
  private long[] data;

  @Before
  public void init() {
    this.data = this.createData();
  }

  private long[] createData() {
    final long[] array = new long[3];
    array[0] = 10l;
    array[1] = 20l;
    array[2] = 30l;
    return array;
  }

  @Test
  public void testSetGet__long() {
    Assert.assertEquals(10l, this.data[0]);
    Assert.assertEquals(20l, this.data[1]);
    Assert.assertEquals(30l, this.data[2]);
  }

  @Test
  public void testClone__long() {
    final long[] clonedData = this.data.clone();
    Assert.assertEquals(10l, clonedData[0]);
    Assert.assertEquals(20l, clonedData[1]);
    Assert.assertEquals(30l, clonedData[2]);
  }

  @Test
  public void testLength__long() {
    Assert.assertEquals(3, this.data.length);
  }

  @Test
  public void testHashCode__long() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }

  @Test
  public void testEquals__long() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    long[] _createData = this.createData();
    final Procedure1<long[]> _function = (long[] it) -> {
      it[1] = 0l;
    };
    final long[] newData = ObjectExtensions.<long[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }

  @Test
  public void testContains__long() {
    Assert.assertTrue(ArrayExtensions.contains(this.data, 10l));
    Assert.assertTrue(ArrayExtensions.contains(this.data, 20l));
    Assert.assertTrue(ArrayExtensions.contains(this.data, 30l));
    Assert.assertFalse(ArrayExtensions.contains(this.data, 40l));
  }
}

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
public class ArrayExtensionsObjectTest {
  private Object[] data;

  @Before
  public void init() {
    this.data = this.createData();
  }

  private Object[] createData() {
    final Object[] array = new Object[3];
    array[0] = Integer.valueOf(0);
    array[1] = Integer.valueOf(1);
    array[2] = null;
    return array;
  }

  @Test
  public void testSetGet__Object() {
    Assert.assertSame(Integer.valueOf(0), this.data[0]);
    Assert.assertSame(Integer.valueOf(1), this.data[1]);
    Assert.assertNull(null, this.data[2]);
  }

  @Test
  public void testClone__Object() {
    final Object[] clonedData = this.data.clone();
    Assert.assertSame(Integer.valueOf(0), clonedData[0]);
    Assert.assertSame(Integer.valueOf(1), clonedData[1]);
    Assert.assertNull(null, this.data[2]);
  }

  @Test
  public void testLength__Object() {
    Assert.assertEquals(3, this.data.length);
  }

  @Test
  public void testHashCode__Object() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }

  @Test
  public void testEquals__Object() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    Object[] _createData = this.createData();
    final Procedure1<Object[]> _function = (Object[] it) -> {
      it[1] = "Hello World";
    };
    final Object[] newData = ObjectExtensions.<Object[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }

  @Test
  public void testContains__Object() {
    Assert.assertTrue(ArrayExtensions.contains(this.data, Integer.valueOf(0)));
    Assert.assertTrue(ArrayExtensions.contains(this.data, Integer.valueOf(1)));
    Assert.assertTrue(ArrayExtensions.contains(this.data, null));
    Assert.assertFalse(ArrayExtensions.contains(this.data, Integer.valueOf(3)));
    Assert.assertFalse(ArrayExtensions.contains(this.data, Integer.valueOf(4)));
  }
}

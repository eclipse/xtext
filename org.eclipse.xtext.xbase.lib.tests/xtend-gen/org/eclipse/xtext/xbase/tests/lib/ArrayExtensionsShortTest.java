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
public class ArrayExtensionsShortTest {
  private short[] data;

  private final short _10 = ((short) 10);

  private final short _20 = ((short) 20);

  private final short _30 = ((short) 30);

  @Before
  public void init() {
    this.data = this.createData();
  }

  private short[] createData() {
    final short[] array = new short[3];
    array[0] = this._10;
    array[1] = this._20;
    array[2] = this._30;
    return array;
  }

  @Test
  public void testSetGet__short() {
    Assert.assertEquals(this._10, this.data[0]);
    Assert.assertEquals(this._20, this.data[1]);
    Assert.assertEquals(this._30, this.data[2]);
  }

  @Test
  public void testClone__short() {
    final short[] clonedData = this.data.clone();
    Assert.assertEquals(this._10, clonedData[0]);
    Assert.assertEquals(this._20, clonedData[1]);
    Assert.assertEquals(this._30, clonedData[2]);
  }

  @Test
  public void testLength__short() {
    Assert.assertEquals(3, this.data.length);
  }

  @Test
  public void testHashCode__short() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }

  @Test
  public void testEquals__short() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    short[] _createData = this.createData();
    final Procedure1<short[]> _function = (short[] it) -> {
      it[1] = ((short) 0);
    };
    final short[] newData = ObjectExtensions.<short[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }

  @Test
  public void testContains__short() {
    Assert.assertTrue(ArrayExtensions.contains(this.data, ((short) 10)));
    Assert.assertTrue(ArrayExtensions.contains(this.data, ((short) 20)));
    Assert.assertTrue(ArrayExtensions.contains(this.data, ((short) 30)));
    Assert.assertFalse(ArrayExtensions.contains(this.data, ((short) 40)));
  }
}

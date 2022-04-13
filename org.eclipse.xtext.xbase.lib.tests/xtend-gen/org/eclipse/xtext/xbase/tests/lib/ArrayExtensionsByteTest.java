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
public class ArrayExtensionsByteTest {
  private byte[] data;

  private final byte _10 = ((byte) 10);

  private final byte _20 = ((byte) 20);

  private final byte _30 = ((byte) 30);

  @Before
  public void init() {
    this.data = this.createData();
  }

  private byte[] createData() {
    final byte[] array = new byte[3];
    array[0] = this._10;
    array[1] = this._20;
    array[2] = this._30;
    return array;
  }

  @Test
  public void testSetGet__byte() {
    Assert.assertEquals(this._10, this.data[0]);
    Assert.assertEquals(this._20, this.data[1]);
    Assert.assertEquals(this._30, this.data[2]);
  }

  @Test
  public void testClone__byte() {
    final byte[] clonedData = this.data.clone();
    Assert.assertEquals(this._10, clonedData[0]);
    Assert.assertEquals(this._20, clonedData[1]);
    Assert.assertEquals(this._30, clonedData[2]);
  }

  @Test
  public void testLength__byte() {
    Assert.assertEquals(3, this.data.length);
  }

  @Test
  public void testHashCode__byte() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }

  @Test
  public void testEquals__byte() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    byte[] _createData = this.createData();
    final Procedure1<byte[]> _function = (byte[] it) -> {
      it[1] = ((byte) 0);
    };
    final byte[] newData = ObjectExtensions.<byte[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }

  @Test
  public void testContains__byte() {
    Assert.assertTrue(ArrayExtensions.contains(this.data, ((byte) 10)));
    Assert.assertTrue(ArrayExtensions.contains(this.data, ((byte) 20)));
    Assert.assertTrue(ArrayExtensions.contains(this.data, ((byte) 30)));
    Assert.assertFalse(ArrayExtensions.contains(this.data, ((byte) 40)));
  }
}

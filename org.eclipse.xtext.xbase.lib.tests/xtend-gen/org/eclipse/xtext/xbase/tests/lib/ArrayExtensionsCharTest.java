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
public class ArrayExtensionsCharTest {
  private char[] data;

  private final char a = 'a';

  private final char b = 'b';

  private final char c = 'c';

  private final char x = 'x';

  @Before
  public void init() {
    this.data = this.createData();
  }

  private char[] createData() {
    final char[] array = new char[3];
    array[0] = this.a;
    array[1] = this.b;
    array[2] = this.c;
    return array;
  }

  @Test
  public void testSetGet__char() {
    Assert.assertEquals(this.a, this.data[0]);
    Assert.assertEquals(this.b, this.data[1]);
    Assert.assertEquals(this.c, this.data[2]);
  }

  @Test
  public void testClone__char() {
    final char[] clonedData = this.data.clone();
    Assert.assertEquals(this.a, clonedData[0]);
    Assert.assertEquals(this.b, clonedData[1]);
    Assert.assertEquals(this.c, clonedData[2]);
  }

  @Test
  public void testLength__char() {
    Assert.assertEquals(3, this.data.length);
  }

  @Test
  public void testHashCode__char() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }

  @Test
  public void testEquals__char() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    char[] _createData = this.createData();
    final Procedure1<char[]> _function = (char[] it) -> {
      it[1] = this.a;
    };
    final char[] newData = ObjectExtensions.<char[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }

  @Test
  public void testContains__char() {
    Assert.assertTrue(ArrayExtensions.contains(this.data, this.a));
    Assert.assertTrue(ArrayExtensions.contains(this.data, this.b));
    Assert.assertTrue(ArrayExtensions.contains(this.data, this.c));
    Assert.assertFalse(ArrayExtensions.contains(this.data, this.x));
  }
}
